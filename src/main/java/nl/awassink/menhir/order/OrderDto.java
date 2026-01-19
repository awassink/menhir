package nl.awassink.menhir.order;

import java.util.List;

public record OrderDto(String customerName, String customerEmail, List<InventoryRequestDto> inventoryRequestDtoList) {
}
