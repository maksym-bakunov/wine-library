package mate.team2.winelibrary.dto.request;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WineRequestDto {
    @NotBlank(message = "Name should not be empty")
    private String name;
    @NotBlank(message = "Color should be empty")
    private Integer colorId;
    @NotBlank(message = "Sort should be empty")
    private Integer sortId;
    @NotBlank(message = "Manufacturer should be empty")
    private Integer manufacturerId;
    @NotNull
    private Integer sweetnessId;
    @NotNull
    private Integer countryId;
    private Integer regionId;
    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    private BigDecimal volume;
    @Min(value = 1900)
    @PastOrPresent
    private Integer year;
    private String composition;
    private Integer rang;
    private Integer discount;
    private Integer pictureId;
    private String description;
    private List<Integer> dishes;
}
