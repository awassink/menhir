package nl.awassink.menhir.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.Instant;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Order {

    private Long Id;
    private String orderIdentifier;
    private String customerName;
    private String customerEmail;
    private Timestamp orderDate = Timestamp.from(Instant.now());
    private OrderStatus status = OrderStatus.OPEN;
}
