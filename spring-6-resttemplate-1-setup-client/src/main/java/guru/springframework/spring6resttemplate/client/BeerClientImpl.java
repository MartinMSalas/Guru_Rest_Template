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


import java.util.Map;


@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {


    private final RestTemplateBuilder restTemplateBuilder;

    private static final String BASE_URL = "http://localhost:8080";

    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDTO> listBeers() {



        RestTemplate restTemplate = restTemplateBuilder.build();



        ResponseEntity<String> stringResponse = restTemplate.getForEntity(GET_BEER_PATH, String.class);

        ResponseEntity<Map> response = restTemplate.getForEntity( GET_BEER_PATH, Map.class);

        ResponseEntity<JsonNode> jsonNodeResponse = restTemplate.getForEntity( GET_BEER_PATH, JsonNode.class);

        ResponseEntity<BeerDTOPageImpl> pageResponse = restTemplate.getForEntity(GET_BEER_PATH, BeerDTOPageImpl.class);

        //System.out.println(stringResponse.getBody());
        //System.out.println(response.getBody());
        //System.out.println(jsonNodeResponse.getBody());
        System.out.println(pageResponse.getBody().getContent());

        return null;
    }
}
