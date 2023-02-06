package mate.team2.winelibrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.team2.winelibrary.model.Status;
import mate.team2.winelibrary.model.User;
import mate.team2.winelibrary.model.Wine;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBasketResponseDto {
    private Integer id;
    private Wine wine;
    private Integer quantity;
    private User userId;
}
