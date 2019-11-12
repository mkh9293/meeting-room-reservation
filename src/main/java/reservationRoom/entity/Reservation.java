package reservationRoom.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Reservations")
@Getter
@NoArgsConstructor
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String roomName;
	
	@Column
	private String userName;
	
	@Column
	private LocalDateTime startDate;
	
	@Column
	private LocalDateTime endDate;
	
	@Column
	private int repeatCount;
	
	@Builder
	public Reservation(String roomName, String userName, LocalDateTime startDate, LocalDateTime endDate, int repeatCount) {
		this.roomName = roomName;
		this.userName = userName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.repeatCount = repeatCount;
	}
}
