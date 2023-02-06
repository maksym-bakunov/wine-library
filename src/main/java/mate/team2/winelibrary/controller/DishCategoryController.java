package mate.team2.winelibrary.controller;

import mate.team2.winelibrary.dto.response.DishCategoryResponseDto;
import mate.team2.winelibrary.model.DishCategory;
import mate.team2.winelibrary.service.DishCategoryService;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dish-categories")
public class DishCategoryController {
    private final DishCategoryService dishCategoryService;
    private final ResponseDtoMapper<DishCategoryResponseDto, DishCategory> responseDtoMapper;

    public DishCategoryController(DishCategoryService dishCategoryService,
                                  ResponseDtoMapper<DishCategoryResponseDto, DishCategory> responseDtoMapper) {
        this.dishCategoryService = dishCategoryService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @GetMapping("/wines")
    public List<DishCategoryResponseDto> findAllInWine() {
        return dishCategoryService.dishesCategoryInWine()
                .stream()
                .map(dc -> responseDtoMapper.mapToDto(dishCategoryService.findById(dc.getId())))
                .collect(Collectors.toList());
    }

    @GetMapping()
    public List<DishCategoryResponseDto> findAll() {
        return dishCategoryService.findAll()
                .stream()
                .map(responseDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
