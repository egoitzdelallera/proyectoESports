package controlador.controladorM;

import jakarta.persistence.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Clob;

/**
 * Controlador para gestionar operaciones relacionadas con XML en la base de datos.
 * Proporciona métodos para truncar tablas, llamar a procedimientos y obtener resultados en formato XML.
 */
public class ControladorMXml {
    private ControladorM cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;

    /**
     * Constructor que inicializa el controlador con una instancia de ControladorM.
     * Crea las instancias de EntityManagerFactory, EntityManager y EntityTransaction.
     *
     * @param cm la instancia de ControladorM.
     */
    public ControladorMXml(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

    /**
     * Trunca una tabla en la base de datos utilizando la consulta SQL proporcionada.
     *
     * @param query la consulta SQL para truncar la tabla.
     * @throws Exception si ocurre un error durante la operación.
     */
    public void truncarTabla(String query) throws Exception {
        try {
            transaction.begin();
            em.createNativeQuery(query).executeUpdate();
            transaction.commit();
            System.out.println("Tabla truncada con éxito.");
        }catch (Exception e) {
            if(transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

    /**
     * Llama a un procedimiento almacenado en la base de datos utilizando la consulta SQL proporcionada.
     *
     * @param query la consulta SQL para llamar al procedimiento.
     * @throws Exception si ocurre un error durante la operación.
     */
    public void llamarProcedimiento(String query) throws Exception {
        try {
            transaction.begin();
            em.createNativeQuery(query).executeUpdate();
            transaction.commit();
            System.out.println("Consulta generada con éxito.");
        }catch (Exception e) {
            if(transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

    /**
     * Obtiene un resultado en formato XML de la base de datos utilizando la consulta SQL proporcionada.
     * Formatea el resultado XML antes de devolverlo.
     *
     * @param query la consulta SQL para obtener el resultado en formato XML.
     * @return el resultado en formato XML.
     * @throws Exception si ocurre un error durante la operación.
     */
    public String obtenerXml(String query) throws Exception {
        try {
            transaction.begin();
            Query qry = em.createNativeQuery(query);
            Object result = qry.getSingleResult();
            Clob consulta = (Clob) result;
            transaction.commit();
            return formatearXml(parsearClob(consulta));

        }catch (Exception e) {
            if(transaction.isActive()) transaction.rollback();
            throw e;
        }
    }

    /**
     * Convierte un objeto Clob a una cadena de texto.
     *
     * @param consulta el objeto Clob a convertir.
     * @return la cadena de texto resultante.
     * @throws Exception si ocurre un error durante la operación.
     */
    public String parsearClob(Clob consulta) throws Exception {
        StringBuilder sb = new StringBuilder();
        Reader reader = consulta.getCharacterStream();
        BufferedReader br = new BufferedReader(reader);
        int c;
        while ((c = br.read()) != -1) {
            sb.append((char) c);
        }
        br.close();
        reader.close();
        return sb.toString();
    }

    /**
     * Formatea una cadena de texto XML para que sea más legible.
     *
     * @param xml la cadena de texto XML a formatear.
     * @return la cadena de texto XML formateada.
     * @throws Exception si ocurre un error durante la operación.
     */
    public String formatearXml(String xml) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();

        t.setOutputProperty(OutputKeys.INDENT,"yes");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        StreamSource source = new StreamSource(new StringReader(xml));
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        t.transform(source,result);

        return writer.toString();
    }
}
