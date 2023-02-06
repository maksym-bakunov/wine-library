package mate.team2.winelibrary.dto.request;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private Integer dishCategoryId;
}
