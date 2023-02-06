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
public class SweetnessResponseDto {
    private Integer id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
}
