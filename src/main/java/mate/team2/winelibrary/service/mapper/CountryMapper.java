package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.request.CountryRequestDto;
import mate.team2.winelibrary.dto.response.CountryResponseDto;
import mate.team2.winelibrary.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper implements RequestDtoMapper<Country, CountryRequestDto>,
        ResponseDtoMapper<CountryResponseDto, Country> {
    @Override
    public CountryResponseDto mapToDto(Country country) {
        CountryResponseDto countryResponseDto = new CountryResponseDto();
        countryResponseDto.setId(country.getId());
        countryResponseDto.setName(country.getName());
        return countryResponseDto;
    }

    @Override
    public Country mapToModel(CountryRequestDto countryRequestDto) {
        Country country = new Country();
        country.setName(countryRequestDto.getName());
        return country;
    }
}
