package co.com.nequi.model.customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Customer {
    private String id;
    private String name;
}
