package nl.awassink.menhir.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Optional<Inventory> findInventoryByName(String name);
    List<Inventory> findInventoryByNameIn(Collection<String> names);
}
