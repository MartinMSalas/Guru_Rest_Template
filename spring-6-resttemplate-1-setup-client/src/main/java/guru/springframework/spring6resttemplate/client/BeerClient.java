package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerRequestDTO;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
public interface BeerClient {

    Page<BeerDTO> listBeers(String beerName);

    Page<BeerDTO> listBeers(BeerRequestDTO beerRequestDTO);

    Page<BeerDTO> listBeers();

    Optional<BeerDTO> getBeerById(UUID beerId);

    Optional<BeerDTO> getBeerByID(UUID beerId, boolean showInventoryOnHand);
}
