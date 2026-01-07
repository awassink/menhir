package nl.awassink.menhir.order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInventoryRepository extends CrudRepository<OrderInventory, Long> {
    @Query(nativeQuery = true, value = "SELECT SUM(oi.totalPrice) from order_inventory oi where oi.order_id = ?1")
    long gettotalOrderAmount (Long orderId);
}
