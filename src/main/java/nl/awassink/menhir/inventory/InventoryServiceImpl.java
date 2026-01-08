package nl.awassink.menhir.inventory;

import lombok.AllArgsConstructor;
import nl.awassink.menhir.inventory.exposed.InventoryDto;
import nl.awassink.menhir.inventory.exposed.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryDto getInventoryByName(String name) {
        return inventoryRepository.findInventoryByName(name)
                .map(InventoryMapper::toInventoryDto)
                .orElseThrow(() -> new IllegalArgumentException("No OrderStatus Found for ["+name+"]"));
    }

    @Override
    public List<InventoryDto> getInventoryByNames(List<String> names) {
        return inventoryRepository.findInventoryByNameIn(names)
                .stream()
                .map(InventoryMapper::toInventoryDto)
                .toList();
    }
}
