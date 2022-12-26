package br.com.alura.ecommerce.service;

import java.util.Map;
import java.util.concurrent.Callable;

// Serviço responsavel por implementar o KafkaService
public class ServiceProvider<T, TT> implements Callable<Void> {

    private final ServiceFactory<T> serviceFactory;
    private final Class<TT> classType;

    public ServiceProvider(ServiceFactory<T> serviceFactory, Class<TT> classType) {
        this.serviceFactory = serviceFactory;
        this.classType = classType;
    }

    /*public <T, TT> void run(ServiceFactory<T> serviceFactory, Class<TT> type) throws ExecutionException, InterruptedException {
        var service = serviceFactory.create();
        try(KafkaService<TT> kafkaService = new KafkaService(
                service.getTopic(),
                service::parse,
                service.getConsumerGroup(),
                type,
                Map.of()
        )){
            kafkaService.run();
        }
    }*/

    @Override
    public Void call() throws Exception {
        var service = serviceFactory.create();
        try(KafkaService<TT> kafkaService = new KafkaService(
                service.getTopic(),
                service::parse,
                service.getConsumerGroup(),
                this.classType,
                Map.of()
        )){
            kafkaService.run();
        }
        return null;
    }
}
