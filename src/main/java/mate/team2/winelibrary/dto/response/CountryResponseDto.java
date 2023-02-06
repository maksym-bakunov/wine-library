package mate.team2.winelibrary.dto.response;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryResponseDto {
    private Integer id;
    @NotEmpty
    private String name;
}
