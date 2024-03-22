package Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Mock object for HotelController.getSearchResults
// returns search results matching the input criteria for location and dates

public class Mock implements searchInterface {
    @Override
    public HotelRoom[] searchHotels(String location, LocalDate arrival, LocalDate departure, Integer maxPrice) {
        LocalDate[] dates = getTimeframe(arrival, departure);
        HotelRoom[] rooms = {
                new HotelRoom("Nonna Hótel", location, 3, dates, 333),
                new HotelRoom("Palla Pleis", location, 1, dates, 222),
                new HotelRoom("Tótu Mótel", location, 7, dates, 333)
        };
        return rooms;
    }

    public static LocalDate[] getTimeframe(LocalDate start, LocalDate end) {
        long numOfDays = start.until(end.plusDays(1)).getDays();

        List<LocalDate> dateList = new ArrayList<>();

        for (int i = 0; i < numOfDays; i++) {
            LocalDate currentDate = start.plusDays(i);
            dateList.add(currentDate);
        }
        return dateList.toArray(new LocalDate[0]);
    }
}