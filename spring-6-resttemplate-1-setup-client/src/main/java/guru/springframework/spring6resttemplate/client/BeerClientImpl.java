package guru.springframework.spring6resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerDTOPageImpl;
import guru.springframework.spring6resttemplate.model.BeerRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;


    private static final String GET_BEER_PATH = "/api/v1/beer";
    private static final String GET_BEER_PATH_ID = GET_BEER_PATH + "/{beerId}";



    @Override
    public Optional<BeerDTO> getBeerByID(UUID beerId, boolean showInventoryOnHand) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        return restTemplate.getForObject(GET_BEER_PATH_ID, Optional.class);

    }

    @Override
    public Page<BeerDTO>  listBeers(String beerName) {



        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        if (beerName != null){
            uriComponentsBuilder.queryParam("beerName", beerName);
        }


        ResponseEntity<String> stringResponse = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class);

        ResponseEntity<Map> response = restTemplate.getForEntity( uriComponentsBuilder.toUriString(), Map.class);

        ResponseEntity<JsonNode> jsonNodeResponse = restTemplate.getForEntity( uriComponentsBuilder.toUriString(), JsonNode.class);

        ResponseEntity<BeerDTOPageImpl> pageResponse = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

        System.out.println(stringResponse.getBody());
        System.out.println(response.getBody());
        System.out.println(jsonNodeResponse.getBody());
        System.out.println(pageResponse.getBody().getContent());

        return null;
    }

    @Override
    public Page<BeerDTO> listBeers(BeerRequestDTO beerRequestDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);
        if(beerRequestDTO != null){
            if(beerRequestDTO.getPageNumber() != null){
                uriComponentsBuilder.queryParam("pageNumber", beerRequestDTO.getPageNumber());
            }
            if(beerRequestDTO.getPageSize() != null){
                uriComponentsBuilder.queryParam("pageSize", beerRequestDTO.getPageSize());
            }
            if(beerRequestDTO.getBeerName() != null){
                uriComponentsBuilder.queryParam("beerName", beerRequestDTO.getBeerName());
            }
            if(beerRequestDTO.getBeerStyle() != null){
                uriComponentsBuilder.queryParam("beerStyle", beerRequestDTO.getBeerStyle());
            }
            if(beerRequestDTO.getShowInventory() != null){
                uriComponentsBuilder.queryParam("showInventoryOnHand", beerRequestDTO.getShowInventory());
            }
        }
        ResponseEntity<String> stringResponse = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class);

        ResponseEntity<Map> response = restTemplate.getForEntity( uriComponentsBuilder.toUriString(), Map.class);

        ResponseEntity<JsonNode> jsonNodeResponse = restTemplate.getForEntity( uriComponentsBuilder.toUriString(), JsonNode.class);

        ResponseEntity<BeerDTOPageImpl> pageResponse = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

        System.out.println(stringResponse.getBody());
        System.out.println(response.getBody());
        System.out.println(jsonNodeResponse.getBody());
        System.out.println(pageResponse.getBody().getContent());
        return null;
    }

    @Override
    public Page<BeerDTO> listBeers() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);
        ResponseEntity<String> stringResponse = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class);

        ResponseEntity<Map> response = restTemplate.getForEntity( uriComponentsBuilder.toUriString(), Map.class);

        ResponseEntity<JsonNode> jsonNodeResponse = restTemplate.getForEntity( uriComponentsBuilder.toUriString(), JsonNode.class);

        ResponseEntity<BeerDTOPageImpl> pageResponse = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

        System.out.println(stringResponse.getBody());
        System.out.println(response.getBody());
        System.out.println(jsonNodeResponse.getBody());
        System.out.println(pageResponse.getBody().getContent());
        BeerDTO beerDTO = (BeerDTO) pageResponse.getBody().getContent().get(0);
        System.out.println(beerDTO.getId());
        return (pageResponse.getBody());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID beerId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return Optional.ofNullable(restTemplate.getForObject(GET_BEER_PATH_ID, BeerDTO.class, beerId));
    }




}
