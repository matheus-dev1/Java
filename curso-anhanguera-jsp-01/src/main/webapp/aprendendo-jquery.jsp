<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<!-- Basicamente adicionando codigo, como se tivesse adicionando o Bootstrap. -->
		<link href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css" rel="stylesheet"> 
		<!-- <link href="jquery-ui.css" rel="stylesheet"> -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<!-- <script type="text/javascript" src="jquery.js"></script> -->
		<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
		<!-- <script type="text/javascript" src="jquery-ui.js"></script> -->
		<meta charset="ISO-8859-1">
		<title>Aprendendo JQuery</title>
	</head>
	<body>
		<form action="#" method="get">
			<table>
				<tr><td>Nome:</td><td><input type="text" name="nome" /></td></tr>
				<tr><td>E-mail:</td><td><input type="text" name="email" /></td></tr>
				<tr><td>Endereço:</td><td><input type="text" name="endereco" /></td></tr>
				<!-- Colocando uma classe com o nome "Data" em um input -->
				<tr><td>Data Nascimento:</td><td><input type="text" id="dataNascimento" name="dataNascimento" class="Data" /></td></tr>
			</table>
			<input id="gravar" type="button" value="Gravar" class="ui-button ui-widget ui-corner-all" onclick="mensagem()"/>   
		</form>
	     <div id="dialog-sucesso" title="Basic dialog" style="display:none">
	          <p class="sucesso_gravar">DADOS ENVIADOS COM SUCESSO!!!</p>
	          <div class="dias">Dias da semana</div>
	          <div class="data-input">dd/mm/yy</div>
	          <div class="ajax-response">Ajax Response</div>
	     </div>
	</body>
	<script type="text/javascript">
		// Quando a gente usa uma "função anonima", ele executa no onload, ou seja, quando a pagina iniciar.
		$(function () {
			console.log("Executando função...");
			// Pega o elemento do DOM com a classe "Data" que é um input.
			// Dentro temos varios parametro configuraveis.
		    $('.Data').datepicker({
		    	// Formata uma data.
		    	dateFormat: 'dd/mm/yy',
				dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabado'],
		        dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
		        dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
		        monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
		        monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
		        nextText: 'Proximo', 
		        prevText: 'Anterior',
		        minDate: 0,
			});
		});
		
		$(function (){
			// Conseguimos recuperar da classe o datapicker configurado e pegar valores das configurações,
			// como o que esta configurado em "dayNames"
			var dayNames = $(".Data").datepicker("option", "dayNames");
			console.log(dayNames);
		});
		
		$(function (){
			// Coloca na proxima linha algum conteudo, podendo ser codigo HTML ou valores de variaveis, ou texto mesmo.
			$(".sucesso_gravar").append("<p>Append Teste</p>");
		});
		
		$(function (){
			var dayNamesShort = $(".Data").datepicker("option", "dayNamesShort");
			console.log(dayNamesShort);
			// Inserindo o conteudo no elemento dom que tem a classe dias.
			$(".dias").html("<p>" + dayNamesShort + "</p>");
		});
		
		// Click em um elemento do DOM.
		$("#gravar").click(function (){
			// Requisição ajax do metodo GET
			$.ajax('https://viacep.com.br/ws/09780900/json/', {
				// Se sucesso faz isso.
				success: function(result){
					console.log(result);
					$(".ajax-response").html(result.cep);
				},
				// Se der error.
				error: function(error){
					console.log(error);
					$(".ajax-response").html(error);
				}
			});
		});
	
		function mensagem(){
			// Ao executar a função mensagem atraves do botão "Gravar", ele vai executar este script jquery
			// Ele vai criar um dialog, no padrão Jquery, com o conteudo que este id, "#dialog-sucesso", possuir.
			$("#dialog-sucesso").dialog();
			// Com o metodo .val(), conseguimos recuperar, o valor de um elemento do dom.
			var data_input = $(".Data").val();
			console.log(data_input);
			$(".data-input").html("<p>" + data_input + "</p>");
		}
	</script>
</html>