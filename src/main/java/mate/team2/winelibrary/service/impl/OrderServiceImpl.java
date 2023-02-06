package mate.team2.winelibrary.service.impl;

import java.util.List;
import mate.team2.winelibrary.dto.request.OrderRequestDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Order;
import mate.team2.winelibrary.model.OrderDetail;
import mate.team2.winelibrary.model.User;
import mate.team2.winelibrary.repository.OrderDetailRepository;
import mate.team2.winelibrary.repository.OrderRepository;
import mate.team2.winelibrary.repository.specification.SpecificationManager;
import mate.team2.winelibrary.service.OrderService;
import mate.team2.winelibrary.service.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final SpecificationManager specificationManager;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderDetailRepository orderDetailRepository,
                            SpecificationManager specificationManager, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.specificationManager = specificationManager;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order add(OrderRequestDto orderRequestDto) {
        Order order = orderMapper.mapToModel(orderRequestDto);
        List<OrderDetail> orderDetails = order.getOrderDetails();
        order = orderRepository.save(order);
        for (OrderDetail orderDetail : orderDetails) {
            OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
        }
        return order;
    }

    @Override
    public List<Order> findByEmail(String email) {
       return orderRepository.findByEmail(email);
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElseThrow(() -> new AppEntityNotFoundException(id));
    }

    @Override
    public void setUserIdByUserId(User user, String email) {
        orderRepository.setUserIdByUserId(user, email);
    }
}
