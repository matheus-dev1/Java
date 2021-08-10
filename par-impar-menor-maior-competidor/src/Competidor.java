public class Competidor {
    //Apenas a classe "Competidor" tem acesso ao valor "idade"
    private int idade;

    //O construtor é definido como um método cujo nome deve ser o mesmo nome da classe e sem indicação do tipo de retorno -- nem mesmo void. ... O construtor é unicamente invocado no momento da criação do objeto através do operador new. O retorno do operador new é uma referência para o objeto recém-criado.
    public Competidor(){
        System.out.println("Construtor passou aqui...");
    }
    // Você usa void como o tipo de retorno de um método (ou uma função local) para especificar que o método não retorna um valor.
    // Você também pode usar void como um tipo Referent para declarar um ponteiro para um tipo desconhecido.
    public void setIdade(int idade) {
        // Neste metodo eu vou ter como parametro um inteiro chamado "idade" que neste caso esta sendo recebido pelo Principal.java e esta atribuindo ao atributo "Competidor.idade" declarado no inicio da classe Competidor.java que sera usado por toda a classe no metodo verificarCategoria();
        this.idade = idade;
    }

    // Aqui eu estou declarando que o retorno da variavel e do tipo String.
    public String verificarCategoria(){
        String msg = "";
        
        if(idade >= 10 && idade <= 13){
            msg = "infantil";
        }
        
        if(idade>=14 && idade <= 16){
            msg = "Juvenil";
        }
        
        if(idade >= 17 && idade <= 20){
            msg = "Júnior";     
        }
        
        if(idade >= 21 && idade <= 30){
            msg = "Adulto";
        }
        
        if(idade >= 31 && idade <= 99){
            msg = "Veterano";
        }
        
        if(idade <= 10 || idade > 99){
            msg = "Idade inválida";
        }
     
        //Ele passa por um dos if's e no final retona o valor atribuido.
        return msg;
    }
}
