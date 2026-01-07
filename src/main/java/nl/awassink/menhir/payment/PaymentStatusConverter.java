package nl.awassink.menhir.payment;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {
    @Override
    public String convertToDatabaseColumn(PaymentStatus status) {
        if (status == null) throw new IllegalArgumentException("Payment status is null");
        return status.getCode();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String code) {
        return Arrays.stream(PaymentStatus.values())
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No PaymentStatus Found for ["+code+"]"));
    }
}
