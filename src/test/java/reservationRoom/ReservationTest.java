package reservationRoom;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reservationRoom.entity.Reservation;
import reservationRoom.repository.ReservationRepository;

@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class ReservationTest {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Test
    public void 예약불러오기_테스트() {
        //given
		reservationRepository.save(Reservation.builder()
                .roomName("A")
                .userName("mkh")
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusHours(2))
                .build());

        //when
        List<Reservation> reservationList = reservationRepository.findAll();

        //then
        Reservation reservation = reservationList.get(0);
        assertThat(reservation.getRoomName(), is("A"));
        assertThat(reservation.getUserName(), is("mkh"));
    }
	

}
