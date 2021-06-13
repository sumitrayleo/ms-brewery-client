package ray.sumit.bbms.msbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ray.sumit.bbms.msbreweryclient.web.model.BeerDto;

import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "bbms.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public static final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID beerId) {
        return restTemplate.getForObject(apiHost + BEER_PATH_V1 + beerId.toString(), BeerDto.class);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
