package reservationRoom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservationRoom.dto.ReservationDto;
import reservationRoom.entity.Reservation;
import reservationRoom.repository.ReservationRepository;
import reservationRoom.util.ReservationUtil;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public boolean reservation(List<Reservation> list, Reservation reservation) {
		if(ReservationUtil.checkDateTime(list, reservation)) {
			reservationRepository.save(reservation);
			return true;
		}
		
		return false;
	}
}
