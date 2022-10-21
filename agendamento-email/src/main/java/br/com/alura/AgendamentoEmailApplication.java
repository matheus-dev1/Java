package br.com.alura;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/*
 * Para a utilização do JAX-RS, eu preciso crair um classe Application, que normalmente armazena configurações globais da nossa aplicação.
 * E além disso herdar a classe "Apllication" de JAX-RS
 * Além disso preciso definir um path entre o contexto da nossa aplicação (agendamento-email-0.0.1-SNAPSHOT) e os nosso recursos/controllers (emails-rest) */
@ApplicationPath("/rest")
public class AgendamentoEmailApplication extends Application { }
