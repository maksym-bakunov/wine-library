package mate.team2.winelibrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.team2.winelibrary.model.Country;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuantityByCountriesResponseDto {
    private Integer id;
    private Country country;
    @NotEmpty
    private Integer quantity;
}
