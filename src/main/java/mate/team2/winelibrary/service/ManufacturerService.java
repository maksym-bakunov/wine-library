package mate.team2.winelibrary.service;

import java.util.List;
import mate.team2.winelibrary.dto.request.ManufacturerRequestDto;
import mate.team2.winelibrary.model.Manufacturer;

public interface ManufacturerService {
    Manufacturer add(ManufacturerRequestDto manufacturerRequestDto);

    List<Manufacturer> findAllManufacturers();

    Manufacturer findById(Integer id);
}
