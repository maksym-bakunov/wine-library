package mate.team2.winelibrary.service;

import java.util.List;
import mate.team2.winelibrary.dto.request.DishCategoryRequestDto;
import mate.team2.winelibrary.model.DishCategory;
import mate.team2.winelibrary.repository.DishCategoryRepository;

public interface DishCategoryService {
    DishCategory add(DishCategoryRequestDto dishCategoryRequestDto);

    List<DishCategory> findAll();

    DishCategory findById(Integer id);
    List<DishCategoryRepository.dishesCategoryInWine> dishesCategoryInWine();
}
