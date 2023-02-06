package mate.team2.winelibrary.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppError {
    private String message;
    private String debugMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errors;

    public AppError(String message, String debugMessage) {
        this.message = message;
        this.debugMessage = debugMessage;
    }
}
