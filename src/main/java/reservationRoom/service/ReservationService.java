package reservationRoom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reservationRoom.dto.ReservationDto;
import reservationRoom.repository.ReservationRepository;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;
	
	public void reservation(ReservationDto reservation) {
		reservationRepository.save(reservation);
	}
}
