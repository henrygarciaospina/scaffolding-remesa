package co.com.nequi.jpa;

import co.com.nequi.model.customer.Customer;
import co.com.nequi.model.customer.gateways.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.text.html.Option;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.stream.Stream;

import static reactor.core.publisher.Flux.*;

@Service
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Mono<Customer> findById(String customerId) {
        Customer customer;
        customer = getCustomers()
                .filter(c -> c.getId().equals(customerId))
                .findFirst().orElse(null);
        return Mono.justOrEmpty(customer);
    }
    @Override
    public Flux<Customer> findAll() {
        Stream<Customer> customers = getCustomers();
        return  customers;
    }

    private Stream<Customer> getCustomers(){
        return Stream.of(
                Customer.builder()
                        .id("10140004")
                        .name("Steve Jobs").build(),
                Customer.builder()
                        .id("10120001")
                        .name("Gosling").build()
        );
    }
}