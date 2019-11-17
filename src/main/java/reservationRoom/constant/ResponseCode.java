package reservationRoom.constant;

import org.springframework.http.HttpStatus;

public enum ResponseCode {
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "50000", "Internal Server Error");
	
	private HttpStatus status;
	private String code;
	private String msg;
	
	ResponseCode(HttpStatus status, String code, String msg) {
		this.status = status;
		this.code = code;
		this.msg = msg;
	}
}
