package nl.awassink.menhir.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.awassink.menhir.order.exposed.OrderCreatedDto;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void orderCreated(final OrderCreatedDto orderCreatedDto){
        log.info("Order Created: {}",orderCreatedDto);
        eventPublisher.publishEvent(orderCreatedDto);
    }
}
