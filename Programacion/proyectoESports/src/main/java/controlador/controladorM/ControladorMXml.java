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
 * Controlador para la gestión de operaciones XML en la base de datos.
 */
public class ControladorMXml {
    private ControladorM cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;


    /**
     * Constructor del controlador de XML.
     *
     * @param cm El controlador principal utilizado para la inicialización.
     */
    public ControladorMXml(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

    /**
     * Trunca una tabla en la base de datos utilizando una consulta.
     *
     * @param query La consulta SQL para truncar la tabla.
     * @throws Exception Si ocurre un error durante la operación.
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
     * Llama a un procedimiento almacenado en la base de datos utilizando una consulta.
     *
     * @param query La consulta SQL para llamar al procedimiento almacenado.
     * @throws Exception Si ocurre un error durante la operación.
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
     * Obtiene un resultado XML desde la base de datos y lo formatea.
     *
     * @param query La consulta SQL para obtener el XML.
     * @return El XML formateado como una string.
     * @throws Exception Si ocurre un error durante la operación.
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
     * Convierte un CLOB a una cadena de texto.
     *
     * @param consulta El CLOB a convertir.
     * @return El contenido del CLOB como un string.
     * @throws Exception Si ocurre un error durante la conversión.
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
     * Formatea una cadena XML para que sea legible.
     *
     * @param xml La cadena XML a formatear.
     * @return El XML formateado como una cadena.
     * @throws Exception Si ocurre un error durante el formateo.
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
