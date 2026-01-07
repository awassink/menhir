package nl.awassink.menhir.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    OPEN("O"), COMPLETED("C");
    private final String statusCode;
}
