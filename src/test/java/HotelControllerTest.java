import Hotel.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class HotelControllerTest {

    private searchInterface mockHotelInterface;
    private HotelController hotelController;
    
    @BeforeEach
    void setUp() {
        // Mock the searchInterface
        mockHotelInterface = mock(searchInterface.class);
        hotelController = new HotelController(mockHotelInterface);
    }
    @AfterEach
    void tearDown() {
        hotelController = null;
    }    
    
    
    @Test
    public void testGetSearchResults() {
        searchInterface mockHotelInterface = mock(searchInterface.class);
        HotelController hotelController = new HotelController(mockHotelInterface);

        // Test data
        LocalDate arrival = LocalDate.of(2024, 4, 1);
        LocalDate departure = LocalDate.of(2024, 4, 7);
        String location = "New York";
        Integer maxPrice = 200;
        HotelRoom[] mockSearchResults = new HotelRoom[2];

        when(mockHotelInterface.searchHotels(eq(location), eq(arrival), eq(departure), eq(maxPrice)))
                .thenReturn(mockSearchResults);

        HotelRoom[] searchResults = hotelController.getSearchResults(location, arrival, departure, maxPrice);

        assertSame(mockSearchResults, searchResults);
        assertEquals(2, searchResults.length);
        verify(mockHotelInterface).searchHotels(location, arrival, departure, maxPrice);
    }

    @Test
    public void testGetSearchResultsWithIncorrectDates() {
        searchInterface mock = new Mock();
        HotelController hotelController = new HotelController(mock);

        // Test data with incorrect dates (departure before arrival)
        LocalDate arrival = LocalDate.of(2024, 4, 7);
        LocalDate departure = LocalDate.of(2024, 4, 1);
        String location = "New York";
        Integer maxPrice = 3333;

        assertThrows(IllegalArgumentException.class, () -> hotelController.getSearchResults(location, arrival, departure, maxPrice));
    }

    @Test
    public void testGetSearchResultsWithEmptyResults() {
        // Mock object returning empty array
        searchInterface mockEmpty = new MockEmpty();
        HotelController hotelController = new HotelController(mockEmpty);

        // Test data
        LocalDate arrival = LocalDate.of(2024, 4, 1);
        LocalDate departure = LocalDate.of(2024, 4, 7);
        String location = "New York";
        Integer maxPrice = 200;

        // Call the method under test
        HotelRoom[] searchResults = hotelController.getSearchResults(location, arrival, departure, maxPrice);

        // Assertions
        assertNotNull(searchResults);
        assertEquals(0, searchResults.length);
    }

    @Test
    public void testGetSearchResultsWithNullResults() {
        // Mock object returning null
        searchInterface mockNull = new MockNull();
        HotelController hotelController = new HotelController(mockNull);

        // Test data
        LocalDate arrival = LocalDate.of(2024, 4, 1);
        LocalDate departure = LocalDate.of(2024, 4, 7);
        String location = "New York";
        Integer maxPrice = 200;

        // Call the method under test
        HotelRoom[] searchResults = hotelController.getSearchResults(location, arrival, departure, maxPrice);

        // Assertions
        assertNotNull(searchResults);
        assertEquals(0, searchResults.length);
    }
    @Test
    public void testGetSearchResultsWithMockObject() {
        searchInterface mockHotelInterface = new Mock();
        HotelController hotelController = new HotelController(mockHotelInterface);

        // Test data
        LocalDate arrival = LocalDate.of(2024, 4, 1);
        LocalDate departure = LocalDate.of(2024, 4, 7);
        String location = "New York";
        Integer maxPrice = 7777;

        // Expected search results
        HotelRoom[] expectedSearchResults = {
                new HotelRoom("Palla Pleis", location, 1, Mock.getTimeframe(arrival, departure), 222),
                new HotelRoom("Nonna Hótel", location, 3, Mock.getTimeframe(arrival, departure), 333),
                new HotelRoom("Tótu Mótel", location, 7, Mock.getTimeframe(arrival, departure), 333)
        };

        // Call the method under test
        HotelRoom[] searchResults = hotelController.getSearchResults(location, arrival, departure, maxPrice);

        // Assertions
        assertEquals(expectedSearchResults.length, searchResults.length);
        for (int i = 0; i < expectedSearchResults.length; i++) {
            assertEquals(expectedSearchResults[i].getHotelName(), searchResults[i].getHotelName());
            assertEquals(expectedSearchResults[i].getLocation(), searchResults[i].getLocation());
            assertEquals(expectedSearchResults[i].getNrOfBeds(), searchResults[i].getNrOfBeds());
            assertEquals(expectedSearchResults[i].getPricePerNight(), searchResults[i].getPricePerNight());
            assertEquals(expectedSearchResults[i].getAvailableDates().length, searchResults[i].getAvailableDates().length);
            for (int j = 0; j < expectedSearchResults[i].getAvailableDates().length; j++) {
                assertEquals(expectedSearchResults[i].getAvailableDates()[j], searchResults[i].getAvailableDates()[j]);
            }
        }
    }
}
