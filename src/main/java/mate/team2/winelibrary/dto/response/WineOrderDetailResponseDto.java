package mate.team2.winelibrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WineOrderDetailResponseDto {
    private Integer id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Color should be empty")
    private BigDecimal volume;
    private Integer pictureId;
}
