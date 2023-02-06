package mate.team2.winelibrary.controller;

import javax.validation.constraints.Min;
import mate.team2.winelibrary.dto.request.UserRequestUpdateDto;
import mate.team2.winelibrary.dto.response.UserResponseDto;
import mate.team2.winelibrary.model.User;
import mate.team2.winelibrary.service.UserService;
import mate.team2.winelibrary.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> responseDtoMapper;

    public UserController(UserService userService, ResponseDtoMapper<UserResponseDto, User> responseDtoMapper) {
        this.userService = userService;
        this.responseDtoMapper = responseDtoMapper;
    }

    @GetMapping("{id}")
    public UserResponseDto findBById(@PathVariable @Min(1) int id){
        User user = userService.findById(id);
        return responseDtoMapper.mapToDto(user);
    }

    @PutMapping("{id}")
    public UserResponseDto patchById(@PathVariable @Min(1) int id,
                                     @RequestBody UserRequestUpdateDto userRequestUpdateDto){
        User user = userService.findById(id);
        user.setFirstname(userRequestUpdateDto.getFirstname());
        user.setLastname(userRequestUpdateDto.getLastname());
        user.setBirthday(userRequestUpdateDto.getBirthday());
        user.setPhone(userRequestUpdateDto.getPhone());
        return responseDtoMapper.mapToDto(userService.update(user));
    }
}
