package co.com.nequi.api;

import co.com.nequi.model.customer.Customer;
import co.com.nequi.usecase.findcustomer.FindAllCustomerUseCase;
import co.com.nequi.usecase.findcustomer.FindCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class Handler {
    private  final FindCustomerUseCase findCustomerUseCase;
    private  final FindAllCustomerUseCase findAllCustomerUseCase;

    public Mono<ServerResponse> findCustomer(ServerRequest serverRequest) {
        String customerId = serverRequest.pathVariable("id");

        return findCustomerUseCase.execute(customerId)
                .flatMap(c-> ServerResponse.ok()
                        .bodyValue(c))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> findAllCustomer(ServerRequest serverRequest) {
        return findAllCustomerUseCase.execute().collectList().flatMap(c->ServerResponse.ok().bodyValue(c));
    }

    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // usecase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
