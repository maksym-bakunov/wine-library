package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.request.DishRequestDto;
import mate.team2.winelibrary.dto.response.DishResponseDto;
import mate.team2.winelibrary.model.Dish;
import mate.team2.winelibrary.service.DishCategoryService;
import org.springframework.stereotype.Component;

@Component
public class DishMapper implements RequestDtoMapper<Dish, DishRequestDto>,
        ResponseDtoMapper<DishResponseDto, Dish> {
    private final DishCategoryService dishCategoryService;

    public DishMapper(DishCategoryService dishCategoryService) {
        this.dishCategoryService = dishCategoryService;
    }

    @Override
    public DishResponseDto mapToDto(Dish dish) {
        DishResponseDto dishResponseDto = new DishResponseDto();
        dishResponseDto.setId(dish.getId());
        dishResponseDto.setName(dish.getName());
        return dishResponseDto;
    }

    @Override
    public Dish mapToModel(DishRequestDto dishRequestDto) {
        Dish dish = new Dish();
        dish.setName(dishRequestDto.getName());
        dish.setDishCategory(dishCategoryService.findById(dishRequestDto.getDishCategoryId()));
        return dish;
    }
}
