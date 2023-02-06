package mate.team2.winelibrary.service.impl;

import java.util.List;
import mate.team2.winelibrary.dto.request.ManufacturerRequestDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Manufacturer;
import mate.team2.winelibrary.repository.ManufacturerRepository;
import mate.team2.winelibrary.service.ManufacturerService;
import mate.team2.winelibrary.service.mapper.ManufacturerMapper;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper manufacturerMapper;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository,
                                   ManufacturerMapper manufacturerMapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.manufacturerMapper = manufacturerMapper;
    }

    @Override
    public Manufacturer add(ManufacturerRequestDto manufacturerRequestDto) {
        Manufacturer manufacturer = manufacturerMapper.mapToModel(manufacturerRequestDto);
        return manufacturerRepository.save(manufacturer);
    }

    @Override
    public List<Manufacturer> findAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Manufacturer findById(Integer id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new AppEntityNotFoundException(id));
    }
}
