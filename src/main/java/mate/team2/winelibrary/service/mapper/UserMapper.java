package mate.team2.winelibrary.service.mapper;

import mate.team2.winelibrary.dto.response.UserResponseDto;
import mate.team2.winelibrary.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setLogin(user.getLogin());
        responseDto.setEmail(user.getEmail());
        responseDto.setFirstname(user.getFirstname());
        responseDto.setLastname(user.getLastname());
        responseDto.setBirthday(user.getBirthday());
        responseDto.setPhone(user.getPhone());
        return responseDto;
    }
}
