package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.DishCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishCategoryRepository extends JpaRepository<DishCategory, Integer>,
        JpaSpecificationExecutor<DishCategory> {
    @Query(value = "SELECT d.dish_category_id id " +
            "FROM wines_dishes wd LEFT JOIN dishes d ON wd.dish_id = d.id  " +
            "GROUP BY d.dish_category_id", nativeQuery = true)
    List<DishCategoryRepository.dishesCategoryInWine> dishesCategoryInWine();

    interface dishesCategoryInWine {
        Integer getId();
    }
}
