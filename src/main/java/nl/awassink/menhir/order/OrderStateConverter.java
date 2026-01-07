package nl.awassink.menhir.order;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter
public class OrderStateConverter implements AttributeConverter<OrderStatus, String> {
    @Override
    public String convertToDatabaseColumn(OrderStatus status) {
        if (status == null) throw new IllegalArgumentException("Order status is null");
        return status.getStatusCode();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String code) {
        return Arrays.stream(OrderStatus.values())
                .filter(s -> s.getStatusCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No OrderStatus Found for ["+code+"]"));
    }
}

