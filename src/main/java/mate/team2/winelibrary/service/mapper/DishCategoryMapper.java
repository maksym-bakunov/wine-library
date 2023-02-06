package mate.team2.winelibrary.service.mapper;

import java.util.stream.Collectors;
import mate.team2.winelibrary.dto.request.DishCategoryRequestDto;
import mate.team2.winelibrary.dto.response.DishCategoryResponseDto;
import mate.team2.winelibrary.model.DishCategory;
import org.springframework.stereotype.Component;

@Component
public class DishCategoryMapper  implements RequestDtoMapper<DishCategory, DishCategoryRequestDto>,
        ResponseDtoMapper<DishCategoryResponseDto, DishCategory>{

        private final DishMapper dishMapper;

        public DishCategoryMapper(DishMapper dishMapper) {
                this.dishMapper = dishMapper;
        }

        @Override
        public DishCategoryResponseDto mapToDto(DishCategory dishCategory) {
                DishCategoryResponseDto dishCategoryResponseDto = new DishCategoryResponseDto();
                dishCategoryResponseDto.setId(dishCategory.getId());
                dishCategoryResponseDto.setName(dishCategory.getName());
                dishCategoryResponseDto.setDishes(dishCategory.getDishes().
                        stream().
                        map(d -> dishMapper.mapToDto(d)).
                        collect(Collectors.toList()));
                return dishCategoryResponseDto;
        }

        @Override
        public DishCategory mapToModel(DishCategoryRequestDto dishCategoryRequestDto) {
                DishCategory dishCategory = new DishCategory();
                dishCategory.setName(dishCategoryRequestDto.getName());
                return dishCategory;
        }
}
