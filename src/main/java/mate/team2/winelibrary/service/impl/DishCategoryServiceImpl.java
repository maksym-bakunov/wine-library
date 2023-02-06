package mate.team2.winelibrary.service.impl;

import java.util.List;
import mate.team2.winelibrary.dto.request.DishCategoryRequestDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.DishCategory;
import mate.team2.winelibrary.repository.DishCategoryRepository;
import mate.team2.winelibrary.service.DishCategoryService;
import org.springframework.stereotype.Service;

@Service
public class DishCategoryServiceImpl implements DishCategoryService {
    private final DishCategoryRepository dishCategoryRepository;

    public DishCategoryServiceImpl(DishCategoryRepository dishCategoryRepository) {
        this.dishCategoryRepository = dishCategoryRepository;
    }

    //TODO
    @Override
    public DishCategory add(DishCategoryRequestDto dishCategoryRequestDto) {
        return null; //dishCategoryRepository.save(dishCategoryMapper.mapToModel(dishCategoryRequestDto));
    }

    @Override
    public List<DishCategory> findAll() {
        return dishCategoryRepository.findAll();
    }

    @Override
    public DishCategory findById(Integer id) {
        return dishCategoryRepository.findById(id)
                .orElseThrow(() -> new AppEntityNotFoundException(id));
    }

    @Override
    public List<DishCategoryRepository.dishesCategoryInWine> dishesCategoryInWine(){
        return dishCategoryRepository.dishesCategoryInWine();
    }
}
