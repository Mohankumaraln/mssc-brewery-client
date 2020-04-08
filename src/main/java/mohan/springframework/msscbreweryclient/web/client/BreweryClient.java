package mohan.springframework.msscbreweryclient.web.client;

import mohan.springframework.msscbreweryclient.web.model.BeerDto;
import mohan.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1 ,beerDto);
    }

    public void updateBeerId(BeerDto beerDto , UUID uuid){
         restTemplate.put(apihost + BEER_PATH_V1 + uuid.toString(), beerDto);
        //restTemplate.put(apihost + BEER_PATH_V1+beerId,beerDto);
    }

    public void     deleteBeerById(UUID beerId){
        System.out.println("  "+beerId);
        restTemplate.delete(apihost + BEER_PATH_V1 + "/"+ beerId.toString());
    }

    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + uuid.toString(), CustomerDto.class);
    }



    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1 ,customerDto);
    }

    public void updateCustomerId(CustomerDto customerDto , UUID uuid){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + uuid.toString(), customerDto);
        //restTemplate.put(apihost + BEER_PATH_V1+beerId,beerDto);
    }

    public void deleteCustomerById(UUID uuid){
        System.out.println("  "+uuid);
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + "/"+ uuid.toString());
    }
}