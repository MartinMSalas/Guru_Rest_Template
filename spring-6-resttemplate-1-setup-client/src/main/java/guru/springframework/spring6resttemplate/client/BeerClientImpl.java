package guru.springframework.spring6resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import guru.springframework.spring6resttemplate.model.BeerDTO;
import guru.springframework.spring6resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.Map;


@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {


    private final RestTemplateBuilder restTemplateBuilder;



    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers(String beerName) {



        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(GET_BEER_PATH);

        if (beerName != null){
            uriComponentsBuilder.queryParam("beerName", beerName);
        }


        ResponseEntity<String> stringResponse = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class);

        ResponseEntity<Map> response = restTemplate.getForEntity( uriComponentsBuilder.toUriString(), Map.class);

        ResponseEntity<JsonNode> jsonNodeResponse = restTemplate.getForEntity( uriComponentsBuilder.toUriString(), JsonNode.class);

        ResponseEntity<BeerDTOPageImpl> pageResponse = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);

        //System.out.println(stringResponse.getBody());
        //System.out.println(response.getBody());
        //System.out.println(jsonNodeResponse.getBody());
        System.out.println(pageResponse.getBody().getContent());

        return null;
    }
}
