package mate.team2.winelibrary.controller;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import mate.team2.winelibrary.dto.request.SortRequestDto;
import mate.team2.winelibrary.dto.response.SortResponseDto;
import mate.team2.winelibrary.model.Sort;
import mate.team2.winelibrary.service.SortService;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sorts")
public class SortController {
    private final SortService sortService;
    private final ResponseDtoMapper<SortResponseDto, Sort> responseDtoMapper;

    public SortController(SortService sortService, ResponseDtoMapper<SortResponseDto, Sort> responseDtoMapper) {
        this.sortService = sortService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping
    public SortResponseDto add(@RequestBody @Valid SortRequestDto sortRequestDto) {
        Sort sort = sortService.add(sortRequestDto);
        return responseDtoMapper.mapToDto(sort);
    }

    @GetMapping
    public List<SortResponseDto> findAll() {
        return sortService.findAllSorts().
                stream().
                map(responseDtoMapper::mapToDto).
                collect(Collectors.toList());
    }
}
