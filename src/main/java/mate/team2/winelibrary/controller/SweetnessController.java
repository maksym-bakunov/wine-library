package mate.team2.winelibrary.controller;

import javax.validation.Valid;
import mate.team2.winelibrary.dto.request.SweetnessRequestDto;
import mate.team2.winelibrary.dto.response.CountryResponseDto;
import mate.team2.winelibrary.dto.response.SweetnessResponseDto;
import mate.team2.winelibrary.model.Sweetness;
import mate.team2.winelibrary.service.SweetnessService;
import mate.team2.winelibrary.service.mapper.RequestDtoMapper;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sweetness")
public class SweetnessController {
    private final SweetnessService sweetnessService;
    private final ResponseDtoMapper<SweetnessResponseDto, Sweetness> responseDtoMapper;
    private final RequestDtoMapper<Sweetness, SweetnessRequestDto> requestDtoMapper;

    public SweetnessController(SweetnessService sweetnessService,
                               ResponseDtoMapper<SweetnessResponseDto, Sweetness> responseDtoMapper,
                               RequestDtoMapper<Sweetness, SweetnessRequestDto> requestDtoMapper) {
        this.sweetnessService = sweetnessService;
        this.responseDtoMapper = responseDtoMapper;
        this.requestDtoMapper = requestDtoMapper;
    }

    @PostMapping
    public SweetnessResponseDto add(@Valid @RequestBody SweetnessRequestDto sweetnessRequestDto) {
        return responseDtoMapper.
                mapToDto(sweetnessService.add(requestDtoMapper.mapToModel(sweetnessRequestDto)));
    }

    @GetMapping
    public List<SweetnessResponseDto> findAll() {
        return sweetnessService.findAllSweetness().
                stream().
                map(responseDtoMapper::mapToDto).
                collect(Collectors.toList());
    }
}
