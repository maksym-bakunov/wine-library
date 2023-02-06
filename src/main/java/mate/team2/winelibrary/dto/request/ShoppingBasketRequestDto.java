package mate.team2.winelibrary.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.team2.winelibrary.model.Status;
import mate.team2.winelibrary.model.User;
import mate.team2.winelibrary.model.Wine;

import javax.validation.constraints.Min;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingBasketRequestDto {
    private Wine wine;
    @Min(1)
    private Integer quantity;
    private User userId;
}
