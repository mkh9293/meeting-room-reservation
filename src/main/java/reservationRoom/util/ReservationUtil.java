package reservationRoom.util;

import java.time.LocalDateTime;
import java.util.List;

import reservationRoom.entity.Reservation;

public class ReservationUtil {
	public static boolean checkDateTime(List<Reservation> t1, Reservation t2) {
		// 30분 단위 체크
		if(!checkOnTime(t2)) return false;
		
		// 중복 체크
		long count = t1.stream()
				.filter(r -> r.getRoomName().equals(t2.getRoomName()))
				.filter(r -> checkOverlap(r, t2))
				.count();
		
		return count < 1;
	}
	
	private static boolean checkOnTime(Reservation r) {
		int startMin = r.getStartDate().getMinute();
		int endMin = r.getEndDate().getMinute();
		
		if(startMin != 0 && startMin != 30)
			return false;
		
		if(endMin != 0 && endMin != 30)
			return false;
		
		return true;
	}
	
	private static boolean checkOverlap(Reservation t1, Reservation t2) {
		int repeatCount = t2.getRepeatCount();
		LocalDateTime startDate = t2.getStartDate();
		LocalDateTime endDate = t2.getEndDate();
		
		do {
		
			if(t1.getStartDate().isAfter(startDate) && t1.getEndDate().isBefore(startDate) ||
					t1.getStartDate().isBefore(endDate) && t1.getEndDate().isAfter(endDate)) {
				return true;
			}
			
			startDate = startDate.plusDays(1);
			endDate = endDate.plusDays(1);
			repeatCount--;
		} while(repeatCount > 0);
		
		return false;
	}
}
