package ray.sumit.bbms.msbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ray.sumit.bbms.msbreweryclient.web.model.BeerDto;
import ray.sumit.bbms.msbreweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "bbms.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public static final String BEER_PATH_V1 = "/api/v1/beer/";
    public static final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apiHost + BEER_PATH_V1, beerDto);
    }

    public void updateExistingBeer(UUID beerId, BeerDto beerDto) {
        restTemplate.getForObject(apiHost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }

    public void deleteBeerById(UUID beerId) {
        restTemplate.delete(apiHost + BEER_PATH_V1 + beerId.toString());
    }

    public CustomerDto getCustomerById(UUID randomUUID) {
        return restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + randomUUID.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateExistingCustomer(UUID randomUUID, CustomerDto customerDto) {
        restTemplate.getForObject(apiHost + CUSTOMER_PATH_V1 + randomUUID.toString(), CustomerDto.class);
    }

    public void deleteCustomerById(UUID randomUUID) {
        restTemplate.delete(apiHost + CUSTOMER_PATH_V1 + randomUUID.toString());
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
