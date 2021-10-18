package br.com.algaworks.produtos.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/* 
 * Boilerplate - Codigo que se repete varias vezes no projeto
 * O lombok usa chamadas internas ao compilador, para adicionar metodos dinamicamente 
 * nestas classes que estão sendo compiladas, ou seja, ele trabalha na hora de compilar o projeto.
 * 
 * Instalação do Lombok, primeiro instalar na IDE.
 * 1. Faça o download da biblioteca.
 * 2. Inicie o .jar do lombok, ele provavelmente vai encontrar a sua IDE, se não você busca o 
 * inicializador (.exe por exemplo) e marca como sua IDE, então clique em Install/Update.
 * 3. Adicionar o Lombok.jar no nosso projeto. Se estiver usando o Maven adicione a dependencia no POM.
 * 
 * Getter e Setter no nive da classe vão servir para todos os atrivutos.
 * @Setter
 * @Getter
 * 
 * A anotação ToString, implementa um metodo To String com todos os seus metodos Getters.
 * @ToString
 * 
 * Tem um valor da anotação @ToString chamada OnlyExplicityIncluded, onde apenas atributos que
 * tenham o ToString.Included vai ser exibido no ToString.
 * @ToString(OnlyExplicityIncluded = true)
 * 
 * Anotação pra gerar Equals e Hash Code
 * @EqualsAndHashCode
 * 
 * Eu posso também alterar o parametro de comparação, determinando apenas alguns 
 * atributos(@EqualsAndHashCode.Include) de comparação, e se eles forem iguais as
 * classes são iguais(equals).
 * @EqualsAndHashCode(OnlyExplicitedIncluded = true)
 * 
 * Cria um construtor para todos os argumentos(parametros).
 * @AllArgsConstructor
 * 
 * Cria uma contrutor sem nenhum argumento.
 * @NoArgsConstructor
 * 
 * Cria um construtor com argumentos obrigatrios 
 * especificados(@NonNull do Lombok para dizer que este atributo é obrigatório).
 * @RequiredArgsConstructor
 * 
 * A anotação @Data vai incluir as anotações juntas @ToString, @EqualsAndHashCode, @Setter, @Getter e
 * @RequiredArgsConstructor em apenas uma anotação.
 * @Data
 * 
 * A anotação @Builder cria uma classe model com o padrão de projeto Builder.
 * Exemplo desta classe:
 * Produto produto = Produto.builder().
 * 			.codigo(1L)
 * 			.nome("Relogio")
 * 			.descricao("Um relogio bem util")
 * 			.build();
 * 
 * No caso de List nos podemos "singularizar", ou seja, na hora de fazer o builder(), e tiver um
 * metodo no padrão builder que requer uma lista no podemos passar a anotação @Singular na lista.
 * Obs: E você pode chamar varios metodo que representam uma lista no seu builder().
 */

@AllArgsConstructor
@Builder
@Data
public class Produto {

	/* Ao colocar em cima de uma classe Setter ou Getter na hora de compilar dinamicamente ele
	 * vai gerar um metodo Setter deste atributo.
	 * @Setter
	 * @Getter
	 */
	private Long codigo;
	/* Eu posso também definir o nivel de acesso de um setter ou getter para um determinado atributo.
	 * @Setter(value = AccessLevel.PRIVATE)
	 * Obs: O NONE é pra nem gerar o metodo.
	 */
	private String nome;
	/* Eu posso remover um metodo especifico do ToString
	 * @ToString.exclude
	 */
	private String descricao;
}
