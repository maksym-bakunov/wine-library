package mate.team2.winelibrary.service;

import java.util.List;
import mate.team2.winelibrary.dto.request.CountryRequestDto;
import mate.team2.winelibrary.model.Country;

public interface CountryService {
    Country add(CountryRequestDto countryRequestDto);

    List<Country> findAllCountries();

    Country findById(Integer id);
}
