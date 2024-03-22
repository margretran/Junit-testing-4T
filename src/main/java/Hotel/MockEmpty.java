package Hotel;

import java.time.LocalDate;
// Mock object for HotelController.getSearchResults
// returns an empty array
public class MockEmpty implements searchInterface {

    @Override
    public HotelRoom[] searchHotels(String location, LocalDate arrival, LocalDate departure, Integer maxPrice) {
        return new HotelRoom[0];
    }
}