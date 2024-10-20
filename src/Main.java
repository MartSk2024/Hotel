import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();
        fillBookings(bookingManager);
    }

    private static void fillBookings(BookingManager bookingManager) {
        Guest guest1 = new Guest("Karel", "Dvořák", LocalDate.of(1990, 5, 15));
        Guest guest2 = new Guest("Karel", "Dvořák", LocalDate.of(1979, 1, 3));
        Guest guest3 = new Guest("Karolína", "Tmavá", LocalDate.of(1989, 6, 1));

        Room room1 = new Room(1);
        Room room2 = new Room(2);
        Room room3 = new Room(3, BigDecimal.valueOf(2400));

        Booking booking1 = new Booking(room3, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), guest1, 1,false);
        bookingManager.addBooking(booking1);
        Booking booking2 = new Booking(room2, LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), guest2, 1,true);
        bookingManager.addBooking(booking2);
        Booking booking3 = new Booking(room3, LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), guest3, 2,false);
        booking3.addRoomMate(guest1);
        bookingManager.addBooking(booking3);
        for (int i = 1; i <= 10; i++) {
            Booking booking4 = new Booking(room2, LocalDate.of(2023, 8, 2 * i - 1), LocalDate.of(2023, 8, 2 * i), guest3, 1,true);
            bookingManager.addBooking(booking4);
        }

        System.out.println("Počet pracovních pobytů: "+bookingManager.getNumberOfWorkingBookings());
        System.out.println("Průměrný počet hostů na rezervaci: "+bookingManager.getAverageGuests());
        System.out.println();

        bookingManager.getTopNHolidayBookings();
        System.out.println();

        bookingManager.getGuestStatistics();
        System.out.println();

        System.out.println("Formátovaný výpis všech rezervací v systému:");
        for (Booking bookingItem : bookingManager.getListOfBookings()) {
            System.out.println(bookingItem.getFormattedSummary());
        }
    }
}//konec třídy