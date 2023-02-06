package mate.team2.winelibrary.service.impl;

import java.util.List;
import mate.team2.winelibrary.dto.request.DishRequestDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Dish;
import mate.team2.winelibrary.repository.DishRepository;
import mate.team2.winelibrary.service.DishService;
import mate.team2.winelibrary.service.mapper.DishMapper;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl implements DishService {

    private DishRepository dishRepository;
    private DishMapper dishMapper;

    @Override
    public Dish add(DishRequestDto dishRequestDto) {
        return dishRepository.save(dishMapper.mapToModel(dishRequestDto));
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findById(Integer id) {
        return dishRepository.findById(id).orElseThrow(() -> new AppEntityNotFoundException(id));
    }
}
