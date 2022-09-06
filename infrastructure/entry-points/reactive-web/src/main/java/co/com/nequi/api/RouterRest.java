package co.com.nequi.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET("/api/otherusercase/path"), handler::listenGETOtherUseCase)
            .and(route(GET("/api/customer/find/{id}"), handler::findCustomer)
                   .andRoute(GET("/api/customer/"), handler::findAllCustomer)
            .andRoute(POST("/api/usecase/otherpath"), handler::listenPOSTUseCase));

    }
}
