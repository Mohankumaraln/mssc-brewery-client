package mohan.springframework.msscbreweryclient.web.client;

import mohan.springframework.msscbreweryclient.web.model.BeerDto;
import mohan.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;


    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void saveNewBeer(){
        BeerDto  beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beerDto);
        System.out.println(" Inside save new >>>>>>    "+uri.toString());
        assertNotNull(uri);
    }

    @Test
    void updateBeerById()
    {
        BeerDto  beerDto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeerId(beerDto, UUID.randomUUID());
        assertNotNull(HttpStatus.NO_CONTENT);
    }

    @Test
    void deleteBeerById()
    {
        client.deleteBeerById(UUID.randomUUID());
        assertNotNull(HttpStatus.NO_CONTENT);
    }

    @Test
    void testgetCustomerById(){
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testsaveNewCustomer()
    {
        URI uri =client.saveNewCustomer(CustomerDto.builder().id(UUID.randomUUID()).name("Mohan").build());
        assertNotNull(uri);
    }

    @Test
    void testupdateCustomerById(){
        client.updateCustomerId(CustomerDto.builder().name("Mohan").build(),UUID.randomUUID());
        assertNotNull(HttpStatus.NO_CONTENT);
    }

    @Test
    void testDeleteCustomerById()
    {
        client.deleteCustomerById(UUID.randomUUID());
        assertNotNull(HttpStatus.ALREADY_REPORTED);
    }





}