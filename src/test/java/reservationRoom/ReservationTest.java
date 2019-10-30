package reservationRoom;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import reservationRoom.dto.Reservation;
import reservationRoom.service.ReservationService;

public class ReservationTest {
	private ReservationService reservationService;
	
	@Before
	public void init() {
		reservationService = new ReservationService();
	}
	
	@Test
	public void 예약테스트() {
		String roomName = "A";
		String userName = "mkh";
		LocalDateTime reservationStartTime = LocalDateTime.now();
		LocalDateTime reservationEndTime = reservationStartTime.plusHours(2);
		int repeatReservationCount = 0;
		Reservation reservation = new Reservation(roomName, userName, reservationStartTime, reservationEndTime, repeatReservationCount);
		
		boolean result = reservationService.reservation(reservation);
		
		assertTrue(result);
	}
	
}
