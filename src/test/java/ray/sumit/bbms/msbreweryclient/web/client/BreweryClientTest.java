package ray.sumit.bbms.msbreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ray.sumit.bbms.msbreweryclient.web.model.BeerDto;
import ray.sumit.bbms.msbreweryclient.web.model.CustomerDto;

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
        client.deleteBeerById(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Sierra Jones").build();
        URI uri = client.saveNewCustomer(customerDto);

        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    void saveExistingCustomer() {
        //given
        CustomerDto customerDto = CustomerDto.builder().name("Sierra Jones").build();
        client.updateExistingCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteExistingCustomer() {
        client.deleteCustomerById(UUID.randomUUID());
    }
}