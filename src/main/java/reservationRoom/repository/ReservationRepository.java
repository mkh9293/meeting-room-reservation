package reservationRoom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reservationRoom.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
}
