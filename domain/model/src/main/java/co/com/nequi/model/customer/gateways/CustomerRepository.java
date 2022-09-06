package co.com.nequi.model.customer.gateways;

import co.com.nequi.model.customer.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public interface CustomerRepository {
    Mono<Customer> findById(String customerId);
    Flux<Customer> findAll();
}
