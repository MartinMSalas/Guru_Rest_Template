package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerRequestDTO;
import guru.springframework.spring6resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientImplTest {

    @Autowired
    private BeerClientImpl beerClientImpl;

    @Test
    void listBeersNoName() {
        beerClientImpl.listBeers();
    }
    @Test
    void listBeers() {
        beerClientImpl.listBeers(BeerRequestDTO.builder().beerStyle(BeerStyle.IPA).beerName("IPA").build());
    }
}