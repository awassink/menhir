package nl.awassink.menhir;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class MenhirApplicationTests {

    @Test
    void contextLoads() {
        ApplicationModules.of(MenhirApplication.class).verify();
    }

}
