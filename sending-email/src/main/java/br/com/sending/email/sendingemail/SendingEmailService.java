package br.com.sending.email.sendingemail;

import java.io.File;
import java.net.URI;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class SendingEmailService {
	
	// User and password
    private String username;
    private String password;

    // Properties used in the project
    private final Properties prop;
	
    // Constructor with auth, starttls, host, port and trust
    public SendingEmailService(String host, int port, String username, String password) {
        prop = new Properties();
        // Propriedade de autenticação
        prop.put("mail.smtp.auth", true);
        // Propriedade de Starttls
        prop.put("mail.smtp.starttls.enable", true);
        // Propriedades do host
        prop.put("mail.smtp.host", host);
        // Propriedades da porta
        prop.put("mail.smtp.port", port);
        // Propriedades do host para trust
        prop.put("mail.smtp.ssl.trust", host);

        this.username = username;
        this.password = password;
    }

    // Constructor with host and port
    public SendingEmailService(String host, int port) {
        prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
    }
	
    // Method to send e-mail
    public void sendMail() throws Exception {
    	// Sessão para autenticação do smtp
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
            	return new PasswordAuthentication(username, password);
            }
        });
        
        Message message = new MimeMessage(session);
        // Do email de origem
        message.setFrom(new InternetAddress("kojodos@yahoo.com"));
        // Para o email de envio
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("matheusdeoliveiraferrero@hotmail.com"));
        // Titulo do email
        message.setSubject("Mail Subject");

        // Mensagem do email
        String msg = "This is my first email using JavaMailer";

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        // Setando content
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        // Estdo da mensagem
        String msgStyled = "This is my <b style='color:red;'>bold-red email</b> using JavaMailer";
        MimeBodyPart mimeBodyPartWithStyledText = new MimeBodyPart();
        mimeBodyPartWithStyledText.setContent(msgStyled, "text/html; charset=utf-8");

        MimeBodyPart attachmentBodyPart = new MimeBodyPart();

        // Anexando o texto do arquivo
        attachmentBodyPart.attachFile(getFile());

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        multipart.addBodyPart(mimeBodyPartWithStyledText);
        multipart.addBodyPart(attachmentBodyPart);

        message.setContent(multipart);

        // Envia propriamente o email
        Transport.send(message);
    }
    
    // Pega o arquivo e coloca o conteudo dele no corpo do email
    private File getFile() throws Exception {
        URI uri = this.getClass()
          .getClassLoader()
          .getResource("attachment.txt")
          .toURI();
        return new File(uri);
    }

}
