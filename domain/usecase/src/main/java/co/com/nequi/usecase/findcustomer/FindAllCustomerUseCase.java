package co.com.nequi.usecase.findcustomer;

import co.com.nequi.model.customer.Customer;
import co.com.nequi.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindAllCustomerUseCase {
    private final CustomerRepository customerRepository;
    public Flux<Customer> execute() {
        return customerRepository.findAll();
    }
}