package reservationRoom.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reservationRoom.entity.Reservation;
import reservationRoom.repository.ReservationRepository;
import reservationRoom.util.ReservationUtil;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Transactional
	public boolean reservation(List<Reservation> list, Reservation reservation) {
		if(ReservationUtil.checkDateTime(list, reservation)) {
			// TODO : 날짜 부분만 저장하는 코드 추가 필요
			reservationRepository.save(reservation);
			return true;
		}
		
		return false;
	}
	
	public List<Reservation> getReservationList() {
		return Optional.ofNullable(reservationRepository.findAll())
						.orElseGet(() -> Collections.EMPTY_LIST);
	}
	
	public List<Reservation> getReservationListToDate(String date) {
		LocalDate lDate = LocalDate.parse(date);

		return Optional.ofNullable(reservationRepository.findAllByDate(lDate))
				.orElseGet(() -> Collections.EMPTY_LIST);
	}
}
