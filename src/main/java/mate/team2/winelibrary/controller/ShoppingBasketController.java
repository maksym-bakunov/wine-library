package mate.team2.winelibrary.controller;

import javax.validation.Valid;
import mate.team2.winelibrary.dto.request.ShoppingBasketRequestDto;
import mate.team2.winelibrary.dto.response.ShoppingBasketResponseDto;
import mate.team2.winelibrary.model.ShoppingBasket;
import mate.team2.winelibrary.service.ShoppingBasketService;
import mate.team2.winelibrary.service.mapper.ShoppingBasketMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingbean")
public class ShoppingBasketController {
    ShoppingBasketMapper shoppingBasketMapper;
    ShoppingBasketService shoppingBasketService;

    public ShoppingBasketController(ShoppingBasketMapper shoppingBasketMapper,
                                    ShoppingBasketService shoppingBasketService) {
        this.shoppingBasketMapper = shoppingBasketMapper;
        this.shoppingBasketService = shoppingBasketService;
    }

    @PostMapping
    public ShoppingBasketResponseDto add(
            @Valid @RequestBody ShoppingBasketRequestDto shoppingBasketRequestDto) {
        ShoppingBasket shoppingBasket = shoppingBasketMapper.mapToModel(shoppingBasketRequestDto);
        return shoppingBasketMapper.mapToDto(shoppingBasketService.add(shoppingBasket));
    }
}
