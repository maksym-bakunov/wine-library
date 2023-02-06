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
public class SweetnessRequestDto {
    @NotBlank(message = "Name should not be empty")
    private String name;
}
