package mate.team2.winelibrary.controller;

import mate.team2.winelibrary.dto.request.OrderRequestDto;
import mate.team2.winelibrary.dto.response.OrderResponseDto;
import mate.team2.winelibrary.model.Order;
import mate.team2.winelibrary.service.OrderDetailService;
import mate.team2.winelibrary.service.OrderService;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final ResponseDtoMapper<OrderResponseDto, Order> responseDtoMapper;

    public OrderController(OrderService orderService,
                           OrderDetailService orderDetailService,
                           ResponseDtoMapper<OrderResponseDto, Order> responseDtoMapper) {
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @PostMapping
    public OrderResponseDto add(@RequestBody @Valid OrderRequestDto orderRequestDto) {
        return responseDtoMapper.mapToDto(orderService.add(orderRequestDto));
    }

    @GetMapping
    public List<OrderResponseDto> findByEmail(@RequestParam String email) {
        return orderService.findByEmail(email).stream().
                map(responseDtoMapper::mapToDto).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public OrderResponseDto findById(@PathVariable("id") @Min(1) int orderId) {
        return responseDtoMapper.mapToDto(orderService.findById(orderId));
    }
}
