package br.com.alura.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.alura.entidade.AgendamentoEmail;
import br.com.alura.servico.AgendamentoEmailServico;

// Aqui eu vou definir o recurso desta classe, ou seja o que vem depois de "/rest", configurado na nossa "AgendamentoEmailApplication"
@Path("emails-rest")
public class AgendamentoEmailController {

	public AgendamentoEmailController() {}
	
	@Inject
	private AgendamentoEmailServico agendamentoEmailServico;
	
	/*
	 * GET para definir uma requisição do tipo GET e Produces, quer dizer que eu vou retornar um objeto do tipo definido, no nosso caso JSON 
	 * */
	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response listarEmails() {
		/* O método de retorno Response, é muito bom, porque com ele nos podemos utilizar de diversos
		 *  metodo para auxiliar, na montagm da nossa resposta 
		 *  sem a gente se preocupar com formatar em JSON e/ou retornar um status http code. 
		 * */
		List<AgendamentoEmail> listaDeEmails = agendamentoEmailServico.listarEmailsBd();
		ResponseBuilder responseBuilder = Response.ok(listaDeEmails);
		return responseBuilder.build();
	}
	
	/*
	 * POST para definir que é uma requisição do tipo POST e Consumes, quer dizer que eu vou consumir dados no formato JSON 
	 * */
	@POST
	@Consumes(value = MediaType.APPLICATION_JSON)
	public Response inserirEmails(AgendamentoEmail agendamentoEmail) {
		agendamentoEmailServico.inserirEmail(agendamentoEmail);
		ResponseBuilder responseBuilder = Response.status(201);
		return responseBuilder.build();
	}
}
