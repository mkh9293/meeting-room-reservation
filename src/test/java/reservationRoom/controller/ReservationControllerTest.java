package reservationRoom.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import reservationRoom.entity.Reservation;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ReservationControllerTest {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
    private WebApplicationContext ctx;

	@InjectMocks
	private ReservationRoomController reservationRoomController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).alwaysDo(print()).build();
	}
	
	@Test
	public void 예약현황_성공테스트_200() throws Exception {
		mockMvc.perform(get("/reservation/2019-11-17"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void 예약하기_성공테스트_200() throws Exception {
		mockMvc.perform(post("/reservation")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(getShortReservation()))
				.andExpect(status().isOk());
	}
	
	private String getShortReservation() throws JsonProcessingException {
        LocalDateTime startDate = LocalDateTime.of(LocalDate.of(2019, 11, 17), LocalTime.of(13, 0));
        LocalDateTime endDate = startDate.plusHours(3);
        
        Reservation reservation = Reservation.builder()
											.roomName("A")
											.userName("mkh")
											.startDate(startDate)
											.endDate(endDate)
											.repeatCount(0)
											.build();
        return objectMapper.writeValueAsString(reservation);
    }
}
