package br.com.alura.ecommerce.service;

import java.util.concurrent.Executors;

// Serviço responsavel por criar instancia de um serviço.
public class ServiceRunner<T, TT> {
    private final ServiceProvider<T, TT> serviceProvider;

    public ServiceRunner(ServiceFactory<T> serviceFactory, Class<TT> classType) {
        this.serviceProvider = new ServiceProvider<>(serviceFactory, classType);
    }

    // Cria a quantidade de instancias igual a variavel "threads"
    public void start(int threads) {
        var pool = Executors.newFixedThreadPool(threads);
        for (int index = 0; index <= threads; index++) {
            pool.submit(serviceProvider);
        }
    }
}
