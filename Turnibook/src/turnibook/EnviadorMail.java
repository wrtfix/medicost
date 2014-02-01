package turnibook;

import java.io.FileInputStream;
import java.io.IOException;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.swing.JOptionPane;

public class EnviadorMail {
    private String miCorreo;
    private String miContrasenia;
    private String mailReceptor;
    private String asunto;
    private String cuerpo;

   private final Properties properties;
    
    public EnviadorMail(String mailReceptor, String asunto, String cuerpo) {
        this.mailReceptor = mailReceptor;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        
        this.properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("configuration.properties"));
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
            msg.setText(cuerpo);
            msg.setSubject(asunto);
            msg.setFrom(new InternetAddress(miCorreo));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                    mailReceptor));
            Transport.send(msg);
        } catch (Exception mex) {
            mex.printStackTrace();
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