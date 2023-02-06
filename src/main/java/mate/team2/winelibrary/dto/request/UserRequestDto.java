package mate.team2.winelibrary.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    @NotBlank
    private String login;
    @NotBlank(message = "Email should not be empty")
    @Email
    private String email;
    @NotBlank(message = "Password should not be empty")
    private String password;
}