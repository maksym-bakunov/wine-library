package mate.team2.winelibrary.service;

import java.util.List;
import mate.team2.winelibrary.model.OrderDetail;

public interface OrderDetailService {
    OrderDetail add(OrderDetail orderDetail);

    List<OrderDetail> findAllByOrderId(Integer id);
}
