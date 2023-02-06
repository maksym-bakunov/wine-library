package mate.team2.winelibrary.dto.request;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRequestDto {
    private Integer wine_id;
    private Integer quantity;
    private BigDecimal price;
}
