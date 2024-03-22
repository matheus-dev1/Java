package br.com.sending.email.sendingemail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendingEmailController {

	// Get para teste
	@GetMapping("/email-tet")
	private String SendingEmailTesting (){
		return "Testing...";
	}
	
	// Get para retorno de um json
	@ResponseBody
	@GetMapping("/email-entity")
	private ResponseEntity<Object> SendingEmailEntity (){
		return ResponseEntity.ok(new MeuObjeto("1", "2"));
	}
	
	// Rota get para processamento do envio do email
	@ResponseBody
	@GetMapping("/email")
	private ResponseEntity<Object> SendingEmail (){
	    try {
	    	// Este é um serviço de email do angus-mail usando o serviço do mailtrap
	    	// Aonde enviamos o smtp, porta, user e senha do serviço
	        new SendingEmailService("sandbox.smtp.mailtrap.io", 2525, "6876e13e72e2ff", "db74c2addd48bd").sendMail();
	        return ResponseEntity.ok("E-mail sended!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Caso a requisição não seja processada
	        return ResponseEntity.ok(HttpStatus.UNPROCESSABLE_ENTITY);
	    }
	}

}
