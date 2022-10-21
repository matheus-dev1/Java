package br.com.alura;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/*
 * Para a utiliza��o do JAX-RS, eu preciso crair um classe Application, que normalmente armazena configura��es globais da nossa aplica��o.
 * E al�m disso herdar a classe "Apllication" de JAX-RS
 * Al�m disso preciso definir um path entre o contexto da nossa aplica��o (agendamento-email-0.0.1-SNAPSHOT) e os nosso recursos/controllers (emails-rest) */
@ApplicationPath("/rest")
public class AgendamentoEmailApplication extends Application { }
