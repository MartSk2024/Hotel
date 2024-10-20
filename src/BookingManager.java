import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private final List<Booking> listOfBookings = new ArrayList<>();

    public List<Booking> getListOfBookings() {
        return listOfBookings;
    }

    public void addBooking(Booking booking) {
        listOfBookings.add(booking);
    }

    public Booking getBooking(int index) {
        return listOfBookings.get(index);
    }

    public void clearListOfBookings() {
        listOfBookings.clear();
    }

    public int getNumberOfWorkingBookings() {
        int sum = 0;
        for (Booking bookingItem : listOfBookings) {
            if (! bookingItem.isVacation()) {
               sum = sum + 1;
            }
        }
        return sum;
    }

    public double getAverageGuests() {
        double sum = 0;
        for (Booking bookingItem : listOfBookings) {
            sum = sum + bookingItem.getSumOfPeopleInRoom();
        }
        return sum / getListOfBookings().size();
    }

    public void getTopNHolidayBookings() {
        System.out.println("Prvních 8 rekreačních pobytů:");
        int i = 1;
        for (Booking bookingItem : listOfBookings) {
            if (bookingItem.isVacation() & i <= 8) {
                System.out.println(bookingItem.getFormattedVacation());
                i = i + 1;
            }
        }
    }

    public void getGuestStatistics() {
        int sum1 = 0;
        int sum2 = 0;
        int sumMore = 0;
        for (Booking bookingItem : listOfBookings) {
            if (bookingItem.getSumOfPeopleInRoom() == 1) {
                sum1 = sum1 + 1;
            }
            if (bookingItem.getSumOfPeopleInRoom() == 2) {
                sum2 = sum2 + 1;
            }
            if (bookingItem.getSumOfPeopleInRoom() >= 3) {
                sumMore = sumMore + 1;
            }
        }
        System.out.println("Statistiky hostů:");
        System.out.println("Počet rezervací s jedním hostem: "+sum1);
        System.out.println("Počet rezervací se dvěma hosty: "+sum2);
        System.out.println("Počet rezervací se třemi a více hosty: "+sumMore);
   }
}//konec třídy
