package Hotel;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class HotelController {
    private final LocalDate currentDate = LocalDate.now();
    private final searchInterface hotelSearchObj;

    public HotelController(searchInterface hotelSearchObj) {
        this.hotelSearchObj = hotelSearchObj;
    }

    private boolean validateSearchData(LocalDate arrival, LocalDate departure, String location) {
        if (arrival == null || departure == null || location == null) {
            throw new IllegalArgumentException("Valid arrival date, departure date or location missing.");
        }
        if (arrival.isBefore(currentDate) || arrival.isAfter(departure) || arrival.isEqual(departure)) {
            throw new IllegalArgumentException("Arrival date should be before departure date and the current date");
        }
        return true;
    }

    public HotelRoom[] getSearchResults(String location, LocalDate arrival, LocalDate departure, Integer maxPrice) {
        HotelRoom[] searchResults = null;
        if (validateSearchData(arrival, departure, location)) {
            searchResults = hotelSearchObj.searchHotels(location, arrival, departure, maxPrice);
        }
        if (searchResults == null || searchResults.length == 0) {
            System.out.println("No available hotels found");
            return new HotelRoom[0];
        }
        // Sorts search results, first by price, then hotel name alphabetically
        Arrays.sort(searchResults, Comparator.nullsLast(Comparator.comparing(HotelRoom::getPricePerNight))
                .thenComparing(HotelRoom::getHotelName));

        System.out.println(Arrays.toString(searchResults)); // henda
        return searchResults;
    }
}