package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.ShoppingBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShoppingBasketRepository extends JpaRepository<ShoppingBasket, Integer>,
        JpaSpecificationExecutor<ShoppingBasket> {
}
