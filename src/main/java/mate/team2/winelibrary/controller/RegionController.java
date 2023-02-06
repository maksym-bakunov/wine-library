package mate.team2.winelibrary.controller;

import mate.team2.winelibrary.dto.request.RegionRequestDto;
import mate.team2.winelibrary.dto.response.RegionResponseDto;
import mate.team2.winelibrary.model.Region;
import mate.team2.winelibrary.service.RegionService;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("regions")
public class RegionController {
    private final RegionService regionService;
    private final ResponseDtoMapper<RegionResponseDto, Region> responseDtoMapper;

    public RegionController(RegionService regionService,
                            ResponseDtoMapper<RegionResponseDto, Region> responseDtoMapper) {
        this.regionService = regionService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping
    public RegionResponseDto add(@Valid @RequestBody RegionRequestDto regionRequestDto) {
        return responseDtoMapper.mapToDto(regionService.add(regionRequestDto));
    }

    @GetMapping
    public List<RegionResponseDto> findAll() {
        return regionService.findAllRegions().
                stream().
                map(responseDtoMapper::mapToDto).
                collect(Collectors.toList());
    }

}
