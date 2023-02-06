package mate.team2.winelibrary.service;

import java.util.List;

import mate.team2.winelibrary.dto.request.OrderRequestDto;
import mate.team2.winelibrary.model.Order;
import mate.team2.winelibrary.model.User;

public interface OrderService {
    Order add(OrderRequestDto orderRequestDto);

    List<Order> findByEmail(String email);

    Order findById(Integer id);

    void setUserIdByUserId(User user, String email);
}
