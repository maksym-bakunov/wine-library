package mate.team2.winelibrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Integer id;
    @NotEmpty
    private String login;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    private String firstname;
    private String lastname;
    private String phone;
    private Date birthday;
}
