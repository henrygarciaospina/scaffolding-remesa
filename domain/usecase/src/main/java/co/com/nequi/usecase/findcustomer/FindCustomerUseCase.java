package co.com.nequi.usecase.findcustomer;

import co.com.nequi.model.customer.Customer;
import co.com.nequi.model.customer.gateways.CustomerRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindCustomerUseCase {
    private final CustomerRepository customerRepository;
    public Mono<Customer> execute(String customerId) {
        return customerRepository.findById(customerId);
    }
}
