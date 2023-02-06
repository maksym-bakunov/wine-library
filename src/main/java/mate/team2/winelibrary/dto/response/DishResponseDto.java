package mate.team2.winelibrary.dto.response;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.team2.winelibrary.model.DishCategory;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishResponseDto {
    private Integer id;
    @NotEmpty
    private String name;
}
