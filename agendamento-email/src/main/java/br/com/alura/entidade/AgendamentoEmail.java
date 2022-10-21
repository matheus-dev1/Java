package br.com.alura.entidade;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    Name: AgendamentoEmailDS
	JNDI Name: java:/AgendamentoEmailDS
	Connection URL: jdbc:mysql://localhost:3306/agendamentoemaildb
	Driver Name: mysql
	User Name: root
	Password: root
*/

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoEmail implements Serializable {
	
	private static final long serialVersionUID = 2239844661356219814L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String assunto;
	private String mensagem;
	private Boolean agendado;
}
