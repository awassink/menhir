package nl.awassink.menhir.payment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.awassink.menhir.order.exposed.OrderCreatedDto;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentEventService {

    private final PaymentRepository paymentRepository;

    @ApplicationModuleListener
    void onOrderCreated(final OrderCreatedDto orderCreatedDto){
        log.info("OrderCreated event received: {}",orderCreatedDto);
    }
}
