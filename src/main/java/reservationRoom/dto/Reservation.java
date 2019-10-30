package reservationRoom.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
	private String roomName;
	private String userName;
	private LocalDateTime reservationStartTime;
	private LocalDateTime reservationEndTime;
	private int repeatReservationCount;
}
