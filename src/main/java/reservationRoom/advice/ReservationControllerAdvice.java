package reservationRoom.advice;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import reservationRoom.constant.ResponseCode;
import reservationRoom.dto.Response.ErrorResponse;
import reservationRoom.exception.HandleException;

@Slf4j
@ControllerAdvice
public class ReservationControllerAdvice {
    @ExceptionHandler(HandleException.class)
    public ResponseEntity<ErrorResponse> handleException(final HandleException e) {
    	log.error("handleException", e);
    	return error(e, HttpStatus.NOT_FOUND, e.toString());
    }

    private ResponseEntity<ErrorResponse> error(Exception exception, HttpStatus httpStatus, String logRef) {
      String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
      ErrorResponse response = new ErrorResponse(logRef, message, httpStatus);
      return new ResponseEntity(response, httpStatus);
    }
}