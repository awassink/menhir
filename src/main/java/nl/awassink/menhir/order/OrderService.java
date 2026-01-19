package nl.awassink.menhir.order;

import lombok.RequiredArgsConstructor;
import nl.awassink.menhir.inventory.exposed.InventoryDto;
import nl.awassink.menhir.inventory.exposed.InventoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final InventoryService inventoryService;
    private final OrderRepository orderRepository;
    private final OrderInventoryRepository orderInventoryRepository;

    public OrderResponseDto createOrder(OrderDto orderDto){

        List<String> inventoryNames = orderDto.inventoryRequestDtoList().stream().map(InventoryRequestDto::inventoryName).toList();
        List<InventoryDto> inventoryByNames = inventoryService.getInventoryByNames(inventoryNames);

        Order order = new Order();
        order.setOrderIdentifier(UUID.randomUUID().toString());
        order.setCustomerName(orderDto.customerName());
        order.setCustomerEmail(orderDto.customerEmail());
        order.setStatus(OrderStatus.COMPLETED);
        orderRepository.save(order);

        List<OrderInventory> orderInventories = new ArrayList<OrderInventory>(inventoryByNames.size());
        inventoryByNames.forEach(inventoryDto -> {
            OrderInventory orderInventory = new OrderInventory();
            InventoryRequestDto orderInventoryRequestDto = getOrderInventoryByName(inventoryDto.name(), orderDto.inventoryRequestDtoList());
            orderInventory.setOrderId(order.getId());
            orderInventory.setInventoryId(inventoryDto.id());
            orderInventory.setQuantity(orderInventoryRequestDto.qty());
            orderInventory.setTotalPrice(inventoryDto.price() * orderInventoryRequestDto.qty());
            orderInventories.add(orderInventory);
        });
        orderInventoryRepository.saveAll(orderInventories);

        return new OrderResponseDto("Order Currently Processed", 102);
    }

    private InventoryRequestDto getOrderInventoryByName(String name, List<InventoryRequestDto> inventory){
        return inventory.stream().filter(inv -> inv.inventoryName().equals(name)).findFirst().orElse(null);
    }
}
