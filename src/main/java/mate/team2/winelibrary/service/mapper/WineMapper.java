package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.request.WineRequestDto;
import mate.team2.winelibrary.dto.response.WineResponseDto;
import mate.team2.winelibrary.model.Wine;
import mate.team2.winelibrary.service.ColorService;
import mate.team2.winelibrary.service.CountryService;
import mate.team2.winelibrary.service.DishService;
import mate.team2.winelibrary.service.ManufacturerService;
import mate.team2.winelibrary.service.RegionService;
import mate.team2.winelibrary.service.SortService;
import mate.team2.winelibrary.service.SweetnessService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class WineMapper implements ResponseDtoMapper<WineResponseDto, Wine>,
        RequestDtoMapper<Wine, WineRequestDto>{

    private final CountryService countryService;
    private final SweetnessService sweetnessService;
    private final RegionService regionService;
    private final ColorService colorService;
    private final SortService sortService;
    private final ManufacturerService manufacturerService;
    private final DishService dishService;
    private final DishMapper dishMapper;

    public WineMapper(CountryService countryService,
                      SweetnessService sweetnessService,
                      RegionService regionService, ColorService colorService, SortService sortService, ManufacturerService manufacturerService, DishService dishService, DishMapper dishMapper) {
        this.countryService = countryService;
        this.sweetnessService = sweetnessService;
        this.regionService = regionService;
        this.colorService = colorService;
        this.sortService = sortService;
        this.manufacturerService = manufacturerService;
        this.dishService = dishService;
        this.dishMapper = dishMapper;
    }

    @Override
    public WineResponseDto mapToDto(Wine wine) {
        WineResponseDto wineResponseDto = new WineResponseDto();
        wineResponseDto.setId(wine.getId());
        wineResponseDto.setName(wine.getName());
        wineResponseDto.setColor(wine.getColor());
        wineResponseDto.setSort(wine.getSort());
        wineResponseDto.setSweetness(wine.getSweetness());
        wineResponseDto.setCountry(wine.getCountry());
        wineResponseDto.setRegion(wine.getRegion());
        wineResponseDto.setManufacturer(wine.getManufacturer());
        wineResponseDto.setPrice(wine.getPrice());
        wineResponseDto.setVolume(wine.getVolume());
        wineResponseDto.setYear(wine.getYear());
        wineResponseDto.setComposition(wine.getComposition());
        wineResponseDto.setRang(wine.getRang());
        wineResponseDto.setDiscount(wine.getDiscount());
        wineResponseDto.setPictureId(wine.getPictureId());
        wineResponseDto.setDescription(wine.getDescription());
        wineResponseDto.setDishes(wine.
                getDishes().
                stream().
                map(dishMapper::mapToDto).
                collect(Collectors.toSet()));
        return wineResponseDto;
    }

    @Override
    public Wine mapToModel(WineRequestDto wineRequestDto) {
        Wine wine = new Wine();
        wine.setName(wineRequestDto.getName());
        wine.setColor(colorService.findById(wineRequestDto.getColorId()));
        wine.setSort(sortService.findById(wineRequestDto.getSortId()));
        wine.setCountry(countryService.findById(wineRequestDto.getCountryId()));
        wine.setRegion(regionService.fineById(wineRequestDto.getRegionId()));
        wine.setManufacturer(manufacturerService.findById(wineRequestDto.getManufacturerId()));
        wine.setSweetness(sweetnessService.findById(wineRequestDto.getSweetnessId()));
        wine.setDishes(wineRequestDto.getDishes().
                stream().
                map(dishService::findById).collect(Collectors.toSet()));

        wine.setPrice(wineRequestDto.getPrice());
        wine.setVolume(wineRequestDto.getVolume());
        wine.setYear(wineRequestDto.getYear());
        wine.setComposition(wineRequestDto.getComposition());
        wine.setRang(wineRequestDto.getRang());
        wine.setDiscount(wineRequestDto.getDiscount());
        wine.setPictureId(wineRequestDto.getPictureId());
        wine.setDescription(wineRequestDto.getDescription());
        return wine;
    }
}
