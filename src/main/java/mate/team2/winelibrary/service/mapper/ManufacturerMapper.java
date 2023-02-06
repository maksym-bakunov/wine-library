package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.request.ManufacturerRequestDto;
import mate.team2.winelibrary.dto.response.ManufacturerResponseDto;
import mate.team2.winelibrary.model.Manufacturer;
import org.springframework.stereotype.Component;

@Component
public class ManufacturerMapper  implements RequestDtoMapper<Manufacturer, ManufacturerRequestDto>,
        ResponseDtoMapper<ManufacturerResponseDto, Manufacturer> {
    @Override
    public ManufacturerResponseDto mapToDto(Manufacturer manufacturer) {
        ManufacturerResponseDto manufacturerResponseDto = new ManufacturerResponseDto();
        manufacturerResponseDto.setId(manufacturer.getId());
        manufacturerResponseDto.setName(manufacturer.getName());
        return manufacturerResponseDto;
    }

    @Override
    public Manufacturer mapToModel(ManufacturerRequestDto manufacturerRequestDto) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(manufacturerRequestDto.getName());
        return manufacturer;
    }
}
