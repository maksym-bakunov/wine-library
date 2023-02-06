package mate.team2.winelibrary.controller;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import mate.team2.winelibrary.dto.request.CountryRequestDto;
import mate.team2.winelibrary.dto.response.CountryResponseDto;
import mate.team2.winelibrary.model.Country;
import mate.team2.winelibrary.service.CountryService;
import mate.team2.winelibrary.service.mapper.CountryMapper;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryService countryService;
    private final ResponseDtoMapper<CountryResponseDto, Country> responseDtoMapper;

    public CountryController(CountryService countryService,
                             ResponseDtoMapper<CountryResponseDto, Country> responseDtoMapper) {
        this.countryService = countryService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping
    public CountryResponseDto add(@RequestBody @Valid CountryRequestDto countryRequestDto) {
        Country country = countryService.add(countryRequestDto);
        return responseDtoMapper.mapToDto(country);
    }

    @GetMapping
    public List<CountryResponseDto> findAll() {
        return countryService.findAllCountries().
                stream().
                map(responseDtoMapper::mapToDto).
                collect(Collectors.toList());
    }
}
