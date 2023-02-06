package mate.team2.winelibrary.dto.response;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishCategoryResponseDto {
    private Integer id;
    @NotEmpty
    private String name;
    private List<DishResponseDto> dishes;
}
