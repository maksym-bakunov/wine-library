package mate.team2.winelibrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.team2.winelibrary.model.Color;
import mate.team2.winelibrary.model.Country;
import mate.team2.winelibrary.model.Manufacturer;
import mate.team2.winelibrary.model.Region;
import mate.team2.winelibrary.model.Sort;
import mate.team2.winelibrary.model.Sweetness;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WineResponseDto {
    private Integer id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Color should be empty")
    private Color color;
    private Sort sort;
    private Sweetness sweetness;
    private Manufacturer manufacturer;
    private Country country;
    private Region region;
    private BigDecimal price;
    private BigDecimal volume;
    private Integer year;
    private String composition;
    private Integer rang;
    private Integer discount;
    private Integer pictureId;
    private String description;
    private Set<DishResponseDto> dishes;
}
