package turnibook.utils;

import java.io.FileInputStream;
import java.io.IOException;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EnviadorMail {
    private String miCorreo;
    private String miContrasenia;
    private String mailReceptor;

   private final Properties properties;
    
    public EnviadorMail(String mailReceptor, String asunto, String cuerpo) {
        this.mailReceptor = mailReceptor;

        this.properties = new Properties();
        try {
            
            String versionString = null;
            Properties mainProperties = new Properties();
            FileInputStream file;
            String path = "C:\\configuration.properties";
            file = new FileInputStream(path);
            
            properties.load(file);
            miCorreo = this.properties.getProperty("mail.smtp.user");
            miContrasenia = this.properties.getProperty("mail.smtp.password");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ""+ex.getMessage());
        }

        SecurityManager security = System.getSecurityManager();

        try {
            Authenticator auth = new autentificadorSMTP();
            Session session = Session.getInstance(properties, auth);
            // session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);
            msg.setContent(cuerpo,"text/html; charset=utf-8");
            msg.setSubject(asunto);
            msg.setFrom(new InternetAddress(miCorreo));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mailReceptor));
            Transport.send(msg);
        } catch (Exception mex) {
            Logger.getLogger(EnviadorMail.class.getName()).log(Level.SEVERE, null, mex);
        }

    }
    
    public String getMailReceptor() {
		return mailReceptor;
	}

	public void setMailReceptor(String mailReceptor) {
		this.mailReceptor = mailReceptor;
	}

	public String getMiCorreo() {
		return miCorreo;
	}

	public String getMiContraseña() {
		return miContrasenia;
	}

	private class autentificadorSMTP extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(miCorreo, miContrasenia);
        }
    }
}
