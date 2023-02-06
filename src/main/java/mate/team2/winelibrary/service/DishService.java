package mate.team2.winelibrary.service;

import java.util.List;
import mate.team2.winelibrary.dto.request.DishRequestDto;
import mate.team2.winelibrary.model.Dish;

public interface DishService {
    Dish add(DishRequestDto dishRequestDto);

    List<Dish> findAll();

    Dish findById(Integer id);
}
