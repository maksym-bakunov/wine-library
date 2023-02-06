package mate.team2.winelibrary.security;

import java.util.Optional;

import mate.team2.winelibrary.config.AppConstans;
import mate.team2.winelibrary.exception.AppEntityNotFoundException;
import mate.team2.winelibrary.model.Role;
import mate.team2.winelibrary.model.User;
import mate.team2.winelibrary.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(username)
                .orElseThrow(() -> new AppEntityNotFoundException("login = " + username));

        org.springframework.security.core.userdetails.User.UserBuilder builder =
                org.springframework.security.core.userdetails.User.withUsername(username);
        builder.password(user.getPassword());
        //builder.authorities(user.getRoles().stream().map(Role::getName).toArray(String[]::new));
        builder.roles(user.getRoles().stream().map(Role::getName).toArray(String[]::new));
        return builder.build();

        /*
        User user = userService.findByEmail(username);
        if(user != null){
            return new org.springframework.security.core.userdetails.User(user.getEmail()
                    , user.getPassword(),
                    user.getRoles().stream()
                            .map((role) -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList()));
        }else {
            throw new UsernameNotFoundException("Invalid email or password");
        }
        */
    }
}
