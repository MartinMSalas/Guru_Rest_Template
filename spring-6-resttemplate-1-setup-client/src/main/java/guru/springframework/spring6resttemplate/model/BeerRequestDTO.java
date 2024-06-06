package guru.springframework.spring6resttemplate.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Builder
@Data
public class BeerRequestDTO {

    String beerName;
    BeerStyle beerStyle;
    Boolean showInventory;
    Integer pageNumber;
    Integer pageSize;
}
