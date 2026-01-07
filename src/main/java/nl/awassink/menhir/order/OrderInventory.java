package nl.awassink.menhir.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(indexes = {
        @Index(name = "order_idx", columnList = "order_id"),
        @Index(name = "inventory_idx", columnList = "inventory_id")
})
public class OrderInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long inventoryId;
    private int quantity;
    private long totalPrice;
}
