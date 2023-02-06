package mate.team2.winelibrary.dto.request;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {
    @NotBlank
    private Integer userId;
    @NotBlank
    private Date orderDate;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private Integer deliveryTypeId;
    @NotBlank
    private String town;
    @NotBlank
    private String address;
    @NotBlank
    private Integer paymentTypeId;
    private BigDecimal discountSum;
    private Integer orderStatus;
    private List<OrderDetailRequestDto> orderDetails;
}
