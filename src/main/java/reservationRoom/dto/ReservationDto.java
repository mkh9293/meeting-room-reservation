package reservationRoom.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reservationRoom.entity.Reservation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
	private String roomName;
	private String userName;
	private LocalDateTime reservationStartTime;
	private LocalDateTime reservationEndTime;
	private int repeatReservationCount;
	
	public Reservation toEntity() {
		return new Reservation(roomName, userName, reservationStartTime, reservationEndTime, repeatReservationCount);
	}
}
