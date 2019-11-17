package reservationRoom.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@NotEmpty
	private String roomName;
	
	@Column
	@NotEmpty
	private String userName;
	
	@Column
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime startDate;
	
	@Column
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
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
