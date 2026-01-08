package nl.awassink.menhir.inventory;

import lombok.experimental.UtilityClass;
import nl.awassink.menhir.inventory.exposed.InventoryDto;

@UtilityClass
public class InventoryMapper {
    public static InventoryDto toInventoryDto (Inventory inventory) {
        return new InventoryDto(inventory.getId(), inventory.getName(), inventory.getDescription(), inventory.getPrice());
    }
}
