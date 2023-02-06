package mate.team2.winelibrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.team2.winelibrary.model.Country;
import mate.team2.winelibrary.model.Region;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegionResponseDto {
    private Integer id;
    @NotEmpty
    private String name;
    private Country country;
}
