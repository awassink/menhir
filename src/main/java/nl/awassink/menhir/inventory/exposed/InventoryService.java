package nl.awassink.menhir.inventory.exposed;

import java.util.List;

public interface InventoryService {
    public InventoryDto getInventoryByName(String name);
    public List<InventoryDto> getInventoryByNames(List<String> names);
}
