package co.com.nequi.jpa;

import co.com.nequi.model.customer.Customer;
import co.com.nequi.model.customer.gateways.CustomerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.swing.text.html.Option;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
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
        List<Customer> customers = getCustomers().collect(Collectors.toCollection(CopyOnWriteArrayList::new));
        return Flux.fromIterable(customers);
    }

    private Stream<Customer> getCustomers(){
        return Stream.of(
                Customer.builder()
                        .id("10010001")
                        .name("Henry Gosling").build(),
                Customer.builder()
                        .id("10020002")
                        .name("Dennis Ritchie").build(),
                Customer.builder()
                        .id("10030003")
                        .name("Bjarne Stroustrup").build(),
                Customer.builder()
                        .id("10040004")
                        .name("Linus Torvalds").build(),
                Customer.builder()
                        .id("10050005")
                        .name("Richard Stallman").build()
        );
    }
}