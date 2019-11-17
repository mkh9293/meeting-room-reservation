package reservationRoom.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reservationRoom.entity.Reservation;
import reservationRoom.service.ReservationService;

@RestController
@RequestMapping("/reservation/**")
public class ReservationRoomController {
	
	@Autowired
	private ReservationService reservationRoomService;
	
	// 예약하기 컨트롤러
	@PostMapping
	ResponseEntity<Reservation> reservation(@RequestBody @Valid Reservation reservation) {
		boolean result = reservationRoomService.reservation(
											reservationRoomService.getReservationList(),
											reservation);
		
		if(!result) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(reservation, HttpStatus.OK);
	}
	
	
	// 예약현황 컨트롤러
	// date : 2019-11-17 
	@GetMapping("/{date}")
	ResponseEntity<List<Reservation>> getReservation(@PathVariable String date) {
		return new ResponseEntity<>(reservationRoomService.getReservationListToDate(date), HttpStatus.OK);
	}

}
