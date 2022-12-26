package br.com.alura.ecommerce.service;

// Interface responsavel por receber a insancia da classe que eu quero criar um serviço.
public interface ServiceFactory<T> {
    public ConsumerService<T> create() throws Exception;
}
