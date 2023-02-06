package mate.team2.winelibrary.controller;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import mate.team2.winelibrary.dto.request.ColorRequestDto;
import mate.team2.winelibrary.dto.response.ColorResponseDto;
import mate.team2.winelibrary.model.Color;
import mate.team2.winelibrary.service.ColorService;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colors")
public class ColorController {
    private final ColorService colorService;
    private final ResponseDtoMapper<ColorResponseDto, Color> responseDtoMapper;

    public ColorController(ColorService colorService,
                           ResponseDtoMapper<ColorResponseDto, Color> responseDtoMapper) {
        this.colorService = colorService;
        this.responseDtoMapper = responseDtoMapper;
    }


    @PostMapping
    public ColorResponseDto add(@RequestBody @Valid ColorRequestDto colorRequestDto) {
        Color color = colorService.add(colorRequestDto);
        return responseDtoMapper.mapToDto(color);
    }

    @GetMapping
    public List<ColorResponseDto> findAll() {
        return colorService.findAllColors().
                stream().
                map(responseDtoMapper::mapToDto).
                collect(Collectors.toList());
    }
}
