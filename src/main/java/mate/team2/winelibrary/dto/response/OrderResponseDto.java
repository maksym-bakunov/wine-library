package mate.team2.winelibrary.dto.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mate.team2.winelibrary.model.DeliveryType;
import mate.team2.winelibrary.model.OrderDetail;
import mate.team2.winelibrary.model.PaymentType;
import mate.team2.winelibrary.model.Wine;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {
    private Integer id;
    //private Integer userId;
    private Date orderDate;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer deliveryTypeId;
    private String town;
    private String address;
    private Integer paymentTypeId;
    private BigDecimal discountSum;
    private Integer orderStatus;
    private List<OrderDetailResponseDto> orderDetails;
}
