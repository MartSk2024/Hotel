import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private int bookingNumber;
    private Room room;
    private LocalDate start;
    private LocalDate end;
    private Guest guest;
    private Guest roomMate;
    private boolean isVacation;
    private List<Guest> roomMates = new ArrayList<>();
    private List<Bookings> bookings = new ArrayList<>();

    public BookingManager(int bookingNumber,Room room, LocalDate start,
                   LocalDate end, Guest guest, boolean isVacation) {
        this.bookingNumber = bookingNumber;
        this.room = room;
        this.guest = guest;
        this.start = start;
        this.end = end;
        this.isVacation = isVacation;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Guest getRoomMate() {
        return roomMate;
    }

    public void setRoomMate(Guest roomMate) {
        this.roomMate = roomMate;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public boolean isVacation() {
        return isVacation;
    }

    public void setVacation(boolean vacation) {
        isVacation = vacation;
    }

    public List<Guest> getRoomMates() {
        return roomMates;
    }

    public void setRoomMates(List<Guest> roomMates) {
        this.roomMates = roomMates;
    }

    public void addRoomMate(Guest roomMate) {
        roomMates.add(roomMate);
    }

    public void removeOtherGuest(Guest roomMate) {
        roomMates.remove(roomMate);
    }
}
