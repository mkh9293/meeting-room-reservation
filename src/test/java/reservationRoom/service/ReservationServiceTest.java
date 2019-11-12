package reservationRoom.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reservationRoom.entity.Reservation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceTest {
	
	@Autowired
	private ReservationService reservationService;
	
	private List<Reservation> reservations = new ArrayList<>();

	
	@Before
	public void setUp() {
		LocalDateTime startTime = LocalDateTime.of(LocalDate.of(2019, 11, 06), LocalTime.of(15, 0));
		LocalDateTime endTime = startTime.plusHours(2); // 17:00
		
		reservations.add(Reservation.builder()
				.roomName("A")
				.userName("mkh")
				.startDate(startTime)
				.endDate(endTime)
				.repeatCount(0)
				.build());
	}
	
	@Test
	public void 정시또는30분단위가아닐때_일회성예약_테스트() {
		//given
		LocalDateTime startTime = LocalDateTime.of(LocalDate.of(2019, 11, 10), LocalTime.of(13, 20)); 
		LocalDateTime endTime	= startTime.plusHours(3);
		Reservation reservation = Reservation.builder()
										.roomName("A")
										.userName("mkh")
										.startDate(startTime)
										.endDate(endTime)
										.repeatCount(0)
										.build();
				
		//when
		boolean result = reservationService.reservation(reservations, reservation);
		
		//then
		assertFalse(result); 
	}
	
	@Test
	public void 중첩시간일때_일회성예약_테스트() {
		//given
		LocalDateTime startTime = LocalDateTime.of(LocalDate.of(2019, 11, 06), LocalTime.of(13, 0)); 
		LocalDateTime endTime	= startTime.plusHours(3);
		Reservation reservation = Reservation.builder()
										.roomName("A")
										.userName("mkh")
										.startDate(startTime)
										.endDate(endTime)
										.repeatCount(0)
										.build();
				
		//when
		boolean result = reservationService.reservation(reservations, reservation);
		
		//then
		assertFalse(result); 
	}
	
	@Test
	public void 중첩시간아닐때_일회성예약_테스트() {
		//given
		LocalDateTime startTime = LocalDateTime.of(LocalDate.of(2019, 11, 06), LocalTime.of(17, 0)); 
		LocalDateTime endTime	= startTime.plusHours(3);
		Reservation reservation = Reservation.builder()
										.roomName("A")
										.userName("mkh")
										.startDate(startTime)
										.endDate(endTime)
										.repeatCount(0)
										.build();
				
		//when
		boolean result = reservationService.reservation(reservations, reservation);

		//then
		assertTrue(result); 
	}
	
	@Test
	public void 중첩시간아닐때_주단위예약_테스트() {
		//given
		LocalDateTime startTime = LocalDateTime.of(LocalDate.of(2019, 11, 05), LocalTime.of(17, 0)); 
		LocalDateTime endTime	= startTime.plusHours(3);
		Reservation reservation = Reservation.builder()
										.roomName("A")
										.userName("mkh")
										.startDate(startTime)
										.endDate(endTime)
										.repeatCount(5)
										.build();
				
		//when
		boolean result = reservationService.reservation(reservations, reservation);
		
		//then
		assertTrue(result); 
	}
	
	@Test
	public void 중첩시간일때_주단위예약_테스트() {
		//given
		LocalDateTime startTime = LocalDateTime.of(LocalDate.of(2019, 11, 05), LocalTime.of(13, 0)); 
		LocalDateTime endTime	= startTime.plusHours(3);
		Reservation reservation = Reservation.builder()
										.roomName("A")
										.userName("mkh")
										.startDate(startTime)
										.endDate(endTime)
										.repeatCount(2)
										.build();
				
		//when
		boolean result = reservationService.reservation(reservations, reservation);
		
		//then
		assertFalse(result); 
	}
}
