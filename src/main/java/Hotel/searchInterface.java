package Hotel;

import java.time.LocalDate;

public interface searchInterface {
    HotelRoom[] searchHotels(String location, LocalDate arrival, LocalDate departure, Integer maxPrice);
}
