package br.com.alura.forum.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Handler - Classe manipuladora, neste caso, maipuladora dos erros de Validação.

// Controller Advice vai fazer tratamento de erros, para quando aparecer uma exceção.
// Por exemplo, invalidação de formulários.
@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	// Classe para mensagens
	private MessageSource messageSource;

	// Que tipo de resposta este metodo deve retornar ao usuario.
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	// Aqui definimos que ele será executado quando a exceção que está no argumento for lançada.
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeFormularioDto> handler(MethodArgumentNotValidException methodArgumentNotValidException) {
		/* Repreetação de uma lista de objetos.
		
		[
			 {
				 "campo": "titulo",
	             "erro": "tamanho deve estar entre 5 e 214783647"
			 },
			 {
		            "campo": "titulo",
	                "erro": "não pode estar vazio"
			 }
			 }
		]
		
		CTRL + 1 | Ele disponibiliza uns atalhos por exemplo o de atribuir o retorno deste metodo em uma varaivel.
		
		*/
		// Quando instanciamos uma lista, nos temos que iniciala vazia.
		List<ErroDeFormularioDto> listaDeErros = new ArrayList<ErroDeFormularioDto>();
		List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
		fieldErrors.forEach(error -> {
			// O metodo getMessage vai nos retornar uma mensagem padrão do Spring referente ao erro do 
			// primeiro argumento e a localidade do contexto ou seja, dependencia de
			// qual é sua localidade voce recebe uma mensagem na sua linguagem.
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			// Instanciando e setando um objeto do tipo ErroDeFormularioDto em uma lisga de ErroDeFormularioDto.
			ErroDeFormularioDto erroDeFormularioDto = new ErroDeFormularioDto(error.getField(), mensagem);
			listaDeErros.add(erroDeFormularioDto);
		});
		return listaDeErros;
	}
}
