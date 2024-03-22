package Hotel;

import java.time.LocalDate;
// Mock object for HotelController.getSearchResults
// returns null
public class MockNull implements searchInterface {

    @Override
    public HotelRoom[] searchHotels(String location, LocalDate arrival, LocalDate departure, Integer maxPrice) {
        return null;
    }
}