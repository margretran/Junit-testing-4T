package Hotel;

import java.time.LocalDate;
import java.util.Arrays;

public class HotelRoom {

    /* GETTERS AND SETTERS */

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Integer pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public int getNrOfBeds() {
        return nrOfBeds;
    }

    public void setNrOfBeds(int nrOfBeds) {
        this.nrOfBeds = nrOfBeds;
    }

    public LocalDate[] getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(LocalDate[] availableDates) {
        this.availableDates = availableDates;
    }

    /* FIELDS */

    private String HotelName;
    private String location;
    private int nrOfBeds;
    private Integer pricePerNight;  // Integer (ekki integer) leyfir null values
    private LocalDate[] availableDates;

    /* Constructor */

    public HotelRoom(String HotelName, String location, int nrOfBeds, LocalDate[] availableDates, Integer pricePerNight) {
        this.HotelName = HotelName;
        this.location = location;
        this.nrOfBeds = nrOfBeds;
        this.pricePerNight = pricePerNight;
        this.availableDates = availableDates;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "HotelName='" + HotelName + '\'' +
                ", location='" + location + '\'' +
                ", nrOfBeds=" + nrOfBeds +
                ", pricePerNight=" + pricePerNight +
                ", availableDates=" + Arrays.toString(availableDates) +
                '}';
    }
}
