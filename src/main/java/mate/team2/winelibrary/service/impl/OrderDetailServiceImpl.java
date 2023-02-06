package mate.team2.winelibrary.service.impl;

import java.util.List;
import mate.team2.winelibrary.model.OrderDetail;
import mate.team2.winelibrary.repository.OrderDetailRepository;
import mate.team2.winelibrary.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public OrderDetail add(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> findAllByOrderId(Integer order_id) {
        return orderDetailRepository.findAllByOrderId(order_id);
    }
}
