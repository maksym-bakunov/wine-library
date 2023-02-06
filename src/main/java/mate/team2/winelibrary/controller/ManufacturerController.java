package mate.team2.winelibrary.controller;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import mate.team2.winelibrary.dto.request.ManufacturerRequestDto;
import mate.team2.winelibrary.dto.response.ManufacturerResponseDto;
import mate.team2.winelibrary.model.Manufacturer;
import mate.team2.winelibrary.service.ManufacturerService;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;
    private final ResponseDtoMapper<ManufacturerResponseDto, Manufacturer> responseDtoMapper;

    public ManufacturerController(ManufacturerService manufacturerService,
                                  ResponseDtoMapper<ManufacturerResponseDto, Manufacturer> responseDtoMapper) {
        this.manufacturerService = manufacturerService;
        this.responseDtoMapper = responseDtoMapper;
    }


    @PostMapping
    public ManufacturerResponseDto add(@RequestBody @Valid ManufacturerRequestDto manufacturerRequestDto) {
        Manufacturer manufacturer = manufacturerService.add(manufacturerRequestDto);
        return responseDtoMapper.mapToDto(manufacturer);
    }

    @GetMapping
    public List<ManufacturerResponseDto> findAll() {
        return manufacturerService.findAllManufacturers().
                stream().
                map(responseDtoMapper::mapToDto).
                collect(Collectors.toList());
    }
}
