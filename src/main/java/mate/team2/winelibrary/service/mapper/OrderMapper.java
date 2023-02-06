package mate.team2.winelibrary.service.mapper;

import java.util.ArrayList;
import java.util.List;
import mate.team2.winelibrary.config.AppConstans;
import mate.team2.winelibrary.dto.request.OrderDetailRequestDto;
import mate.team2.winelibrary.dto.request.OrderRequestDto;
import mate.team2.winelibrary.dto.response.OrderDetailResponseDto;
import mate.team2.winelibrary.dto.response.OrderResponseDto;
import mate.team2.winelibrary.dto.response.WineOrderDetailResponseDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Order;
import mate.team2.winelibrary.model.OrderDetail;
import mate.team2.winelibrary.model.User;
import mate.team2.winelibrary.model.Wine;
import mate.team2.winelibrary.service.DeliveryTypeService;
import mate.team2.winelibrary.service.PaymentTypeService;
import mate.team2.winelibrary.service.UserService;
import mate.team2.winelibrary.service.WineService;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements RequestDtoMapper<Order, OrderRequestDto>,
        ResponseDtoMapper<OrderResponseDto, Order>{

    private final UserService userService;
    private final DeliveryTypeService deliveryTypeService;
    private final PaymentTypeService paymentTypeService;
    private final WineService wineService;

    public OrderMapper(UserService userService, DeliveryTypeService deliveryTypeService,
                       PaymentTypeService paymentTypeService, WineService wineService) {
        this.userService = userService;
        this.deliveryTypeService = deliveryTypeService;
        this.paymentTypeService = paymentTypeService;
        this.wineService = wineService;
    }

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setFirstName(order.getFirstName());
        orderResponseDto.setLastName(order.getLastName());
        orderResponseDto.setEmail(order.getEmail());
        orderResponseDto.setPhone(order.getPhone());
        orderResponseDto.setDeliveryTypeId(order.getDeliveryType().getId());
        orderResponseDto.setPaymentTypeId(order.getPaymentType().getId());
        orderResponseDto.setTown(order.getTown());
        orderResponseDto.setAddress(order.getAddress());
        orderResponseDto.setDiscountSum(order.getDiscountSum());
        orderResponseDto.setOrderStatus(order.getOrderStatus());

        List<OrderDetailResponseDto> orderDetailResponseDtos = new ArrayList<>();
        for (OrderDetail orderDetail : order.getOrderDetails()) {
            OrderDetailResponseDto orderDetailResponseDto = new OrderDetailResponseDto();

            //TODO
            Wine wine = orderDetail.getWine();
            WineOrderDetailResponseDto wineOrderDetailResponseDto = new WineOrderDetailResponseDto();
            wineOrderDetailResponseDto.setId(wine.getId());
            wineOrderDetailResponseDto.setName(wine.getName());
            wineOrderDetailResponseDto.setVolume(wine.getVolume());
            wineOrderDetailResponseDto.setPictureId(wine.getPictureId());

            orderDetailResponseDto.setWine(wineOrderDetailResponseDto);
            orderDetailResponseDto.setPrice(orderDetail.getPrice());
            orderDetailResponseDto.setQuantity(orderDetail.getQuantity());
            orderDetailResponseDtos.add(orderDetailResponseDto);
        }
        orderResponseDto.setOrderDetails(orderDetailResponseDtos);
        return orderResponseDto;
    }

    @Override
    public Order mapToModel(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        User user = userService.findUserByEmail(orderRequestDto.getEmail())
                .orElseGet(() -> userService.findByLogin(AppConstans.DEFAULT_USER)
                        .orElseThrow(() -> new AppEntityNotFoundException("login = "
                                + AppConstans.DEFAULT_USER)));
        order.setUser(user);
        order.setEmail(orderRequestDto.getEmail());
        order.setPhone(orderRequestDto.getPhone());
        order.setOrderDate(orderRequestDto.getOrderDate());
        order.setOrderStatus(orderRequestDto.getOrderStatus());
        order.setAddress(orderRequestDto.getAddress());
        order.setOrderStatus(orderRequestDto.getOrderStatus());
        order.setDeliveryType(deliveryTypeService.findById(orderRequestDto.getDeliveryTypeId()));
        order.setPaymentType(paymentTypeService.findById(orderRequestDto.getPaymentTypeId()));
        order.setTown(orderRequestDto.getTown());
        order.setFirstName(orderRequestDto.getFirstName());
        order.setLastName(orderRequestDto.getLastName());
        order.setDiscountSum(orderRequestDto.getDiscountSum());
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailRequestDto orderDetailDto : orderRequestDto.getOrderDetails()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setWine(wineService.findById(orderDetailDto.getWine_id()));
            orderDetail.setQuantity(orderDetailDto.getQuantity());
            orderDetail.setPrice(orderDetailDto.getPrice());
            orderDetails.add(orderDetail);
        }
        order.setOrderDetails(orderDetails);
        return order;
    }
}
