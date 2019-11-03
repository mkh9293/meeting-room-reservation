package reservationRoom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import reservationRoom.entity.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{
}
