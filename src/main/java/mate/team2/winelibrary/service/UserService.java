package mate.team2.winelibrary.service;

import java.util.List;
import java.util.Optional;

import mate.team2.winelibrary.dto.request.UserRequestDto;
import mate.team2.winelibrary.dto.response.UserResponseDto;
import mate.team2.winelibrary.model.User;

public interface UserService {
    User save(UserRequestDto userRequestDto);

    User update(User user);

    Optional<User> findUserByEmail(String email);

    Optional<User> findByLogin(String login);

    User findById(Integer id);

    List<UserResponseDto> findAllUsers();
}
