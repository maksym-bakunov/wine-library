package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DishRepository extends JpaRepository<Dish, Integer>,
        JpaSpecificationExecutor<Dish> {
}
