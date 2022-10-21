package br.com.alura.jpa.model;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String profissao;
    private String endereco;
    // A chave estrangeira deve ser unica
    @JoinColumn(unique = true)
    @OneToOne
    private Conta conta;

    public Cliente() {

    }

    public Cliente(String nome, String profissao, String endereco) {
        this.nome = nome;
        this.profissao = profissao;
        this.endereco = endereco;
    }

    public Cliente(String nome, String profissao, String endereco, Conta conta) {
        this.nome = nome;
        this.profissao = profissao;
        this.endereco = endereco;
        this.conta = conta;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Conta getContaModel() {
        return conta;
    }
    public void setContaModel(Conta conta) {
        this.conta = conta;
    }
}
