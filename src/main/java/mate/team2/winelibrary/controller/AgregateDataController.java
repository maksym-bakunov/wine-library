package mate.team2.winelibrary.controller;

import java.util.List;
import mate.team2.winelibrary.repository.WineRepository;
import mate.team2.winelibrary.service.WineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class AgregateDataController {
    private final WineService wineService;

    public AgregateDataController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/quantitybycountries")
    public List<WineRepository.QuantityByCountries> getQtyByCountries() {
        return wineService.findAllQuantityByCountry();
    }
}
