package mate.team2.winelibrary.service.impl;

import java.util.List;
import mate.team2.winelibrary.dto.request.CountryRequestDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Country;
import mate.team2.winelibrary.repository.CountryRepository;
import mate.team2.winelibrary.service.CountryService;
import mate.team2.winelibrary.service.mapper.CountryMapper;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public Country add(CountryRequestDto countryRequestDto) {
        Country country = countryMapper.mapToModel(countryRequestDto);
        return countryRepository.save(country);
    }

    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Integer id) {
        return countryRepository.findById(id).orElseThrow(() -> new AppEntityNotFoundException(id));
    }
}
