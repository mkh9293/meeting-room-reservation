package reservationRoom.exception;

public class HandleException extends RuntimeException {
	public HandleException() {
	}
	
	public HandleException(String msg) {
		super(msg);
	}
	
	public HandleException(String msg, long l) {
		super(msg + " : [id] " + l);
	}
}
