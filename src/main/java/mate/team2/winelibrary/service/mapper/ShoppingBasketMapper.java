package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.request.ShoppingBasketRequestDto;
import mate.team2.winelibrary.dto.response.ShoppingBasketResponseDto;
import mate.team2.winelibrary.model.ShoppingBasket;
import org.springframework.stereotype.Component;

@Component
public class ShoppingBasketMapper implements RequestDtoMapper<ShoppingBasket, ShoppingBasketRequestDto>,
        ResponseDtoMapper<ShoppingBasketResponseDto, ShoppingBasket> {

    @Override
    public ShoppingBasket mapToModel(ShoppingBasketRequestDto shoppingBasketRequestDto) {
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setWine(shoppingBasketRequestDto.getWine());
        shoppingBasket.setQuantity(shoppingBasketRequestDto.getQuantity());
        shoppingBasket.setUser(shoppingBasketRequestDto.getUserId());
        return shoppingBasket;
    }

    @Override
    public ShoppingBasketResponseDto mapToDto(ShoppingBasket shoppingBasket) {
        ShoppingBasketResponseDto shoppingBasketResponseDto = new ShoppingBasketResponseDto();
        shoppingBasketResponseDto.setId(shoppingBasket.getId());
        shoppingBasketResponseDto.setWine(shoppingBasket.getWine());
        shoppingBasketResponseDto.setQuantity(shoppingBasket.getQuantity());
        shoppingBasketResponseDto.setUserId(shoppingBasket.getUser());
        return shoppingBasketResponseDto;
    }
}
