package mate.team2.winelibrary.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import mate.team2.winelibrary.config.AppConstans;
import mate.team2.winelibrary.dto.request.UserRequestDto;
import mate.team2.winelibrary.dto.response.UserResponseDto;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Role;
import mate.team2.winelibrary.model.User;
import mate.team2.winelibrary.repository.RoleRepository;
import mate.team2.winelibrary.repository.UserRepository;
import mate.team2.winelibrary.service.UserService;
import mate.team2.winelibrary.service.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public User save(UserRequestDto userRequestDto) {
        User user = new User();
        user.setLogin(userRequestDto.getLogin());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));

        Role role = roleRepository.findByName(AppConstans.DEFAULT_USER)
                .orElseGet(() -> roleRepository.save(new Role(AppConstans.DEFAULT_USER)));
        user.setRoles(Set.of(role));
        userRepository.save(user);
        return user;
    }

    @Override
    public User update(User user) {
       return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new AppEntityNotFoundException(id));
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
