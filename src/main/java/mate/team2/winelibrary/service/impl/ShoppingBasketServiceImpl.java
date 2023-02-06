package mate.team2.winelibrary.service.impl;

import java.util.List;
import mate.team2.winelibrary.model.ShoppingBasket;
import mate.team2.winelibrary.repository.ShoppingBasketRepository;
import mate.team2.winelibrary.service.ShoppingBasketService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
    ShoppingBasketRepository shoppingBasketRepository;

    public ShoppingBasketServiceImpl(ShoppingBasketRepository shoppingBasketRepository) {
        this.shoppingBasketRepository = shoppingBasketRepository;
    }

    @Override
    public ShoppingBasket add(ShoppingBasket shoppingBasket) {
         return shoppingBasketRepository.save(shoppingBasket);
    }

    @Override
    public List<ShoppingBasket> findAll() {
        return shoppingBasketRepository.findAll();
    }

}
