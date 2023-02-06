package mate.team2.winelibrary.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestUpdateDto {
    private String firstname;
    private String lastname;
    private String phone;
    private Date birthday;
}
