package reservationRoom.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import reservationRoom.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	@Query(value = "SELECT * FROM Reservations WHERE start_date = :date", nativeQuery=true)
	List<Reservation> findAllByDate(@Param("date") LocalDate date);
}
