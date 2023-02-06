package mate.team2.winelibrary.controller;

import javax.validation.Valid;

import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import mate.team2.winelibrary.dto.request.UserRequestDto;
import mate.team2.winelibrary.dto.response.UserResponseDto;
import mate.team2.winelibrary.model.User;
import mate.team2.winelibrary.service.UserService;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;

@RestController
public class AuthController {
    private final UserService userService;
    private final OrderService orderService;
    private final ResponseDtoMapper<UserResponseDto, User> responseDtoMapper;

    public AuthController(UserService userService,
                          OrderService orderService,
                          ResponseDtoMapper<UserResponseDto, User> responseDtoMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.responseDtoMapper = responseDtoMapper;
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody  @Valid UserRequestDto userRequestDto){
        User user = userService.save(userRequestDto);
        orderService.setUserIdByUserId(user, user.getEmail());
        return responseDtoMapper.mapToDto(user);
    }

    @GetMapping("/login")
    public UserResponseDto login(Authentication authentication){
        User user = userService.findUserByEmail(authentication.getName())
                .orElseThrow(() -> new AppEntityNotFoundException("email = " + authentication.getName()));
        return responseDtoMapper.mapToDto(user);
    }
}
