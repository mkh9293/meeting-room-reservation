package reservationRoom.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reservationRoom.entity.Reservation;

@Getter
@Setter
@NoArgsConstructor
public class ReservationDto {
	private String roomName;
	private String userName;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int repeatCount;
	
	public Reservation toEntity() {
		return Reservation.builder()
				.roomName(roomName) 
				.userName(userName)
				.startDate(startDate)
				.endDate(endDate)
				.repeatCount(repeatCount)
				.build();
	}
}
