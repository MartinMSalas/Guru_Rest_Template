package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerRequestDTO;
import guru.springframework.spring6resttemplate.model.BeerStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Optional;

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

    @Test
    void getBeerById() {
        Page<BeerDTO> beerDTOS = beerClientImpl.listBeers();
        BeerDTO dto = beerDTOS.getContent().getFirst();
        Optional<BeerDTO> byId = beerClientImpl.getBeerById(dto.getId());

        assertTrue(byId.isPresent());

    }
}