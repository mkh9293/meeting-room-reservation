package reservationRoom.dto.Response;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
	private String msg;
	private String code;
	private HttpStatus status;
}
