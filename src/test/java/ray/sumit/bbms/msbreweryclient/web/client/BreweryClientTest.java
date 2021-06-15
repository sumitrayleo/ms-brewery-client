package ray.sumit.bbms.msbreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ray.sumit.bbms.msbreweryclient.web.model.BeerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("Black Label").build();
        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void saveExistingBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("Black Label").build();
        client.updateExistingBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteExistingBeer() {
        //given
        BeerDto beerDto = BeerDto.builder().beerName("Black Label").build();
        client.deleteBeerById(UUID.randomUUID());

    }
}