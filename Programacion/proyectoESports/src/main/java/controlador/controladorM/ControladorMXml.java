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

public class ControladorMXml {
    private ControladorM cm;
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction transaction;

    public ControladorMXml(ControladorM cm) {
        this.cm = cm;
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
        transaction = em.getTransaction();
    }

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
