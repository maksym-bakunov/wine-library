package mate.team2.winelibrary.service;

import java.util.List;
import mate.team2.winelibrary.model.ShoppingBasket;

public interface ShoppingBasketService {
    ShoppingBasket add(ShoppingBasket shoppingBasket);

    List<ShoppingBasket> findAll();
}

