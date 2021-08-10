public class Numero {
    //Aqui eu estou declarando o atributo "num" do tipo inteiro sem valor.
    private int num;

    /*
    Para utilizar estes modificadores de acesso, basta que o escreva antes do nome do atributo, método ou classe.

    Public: O modificador public deixará visível a classe ou membro para todas as outras classes, subclasses e pacotes do projeto Java.
    Protected: O modificador protected deixará visível o atributo para todas as outras classes e subclasses que pertencem ao mesmo pacote. A principal diferença é que apenas as classes do mesmo pacote têm acesso ao membro. O pacote da subclasse não tem acesso ao membro.
    Private: O modificador private deixará visível o atributo apenas para a classe em que este atributo se encontra.
    Package-Private: é o modificador padrão quando outro não é definido. Isto torna acessível na própria classe, nas classes e subclasses do mesmo pacote. Ele geralmente é utilizado para construtores e métodos que só dever ser invocados pelas classes e subclasses do pacote, constantes estáticas que são úteis apenas dentro do pacote em que estive inserido.
    */

    //Construtor
    public Numero(){
        System.out.println("Construtor passou aqui...");
    }

    //Metodos
    public void setNum(int num) {
        this.num = num;
    }
    
    private int getNum(){
        // Ele vai me retornar o valor de "num" que foi setado por setNum()
        return num;
    }

    public void maior(int x){
        // Eu uso o this porque eu estou chamando um metodo da propria classe, entao este this ficaria mais ou menos como Numero.getNum() e ele me retorno o numero setado por setNum()
        if(this.getNum() > x){
            System.out.println(this.getNum() + " é maior");
        }
        if(x > this.getNum()){
            System.out.println(x + " é maior");
        }
    }

    public void par_impar(){
        if (this.getNum() % 2 == 0){
            System.out.println(this.getNum() + " par");  
        } else {
            System.out.println(this.getNum() + " ímpar");
        }
    }
}
