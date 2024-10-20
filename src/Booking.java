import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Room room;
    private LocalDate start;
    private LocalDate end;
    private Guest guest;
    private Guest roomMate;
    private int sumOfPeopleInRoom;
    private boolean isVacation;
    private List<Guest> roomMates = new ArrayList<>();

    public Booking(Room room, LocalDate start,
                   LocalDate end, Guest guest, int sumOfPeopleInRoom,boolean isVacation) {
        this.room = room;
        this.start = start;
        this.end = end;
        this.guest = guest;
        this.sumOfPeopleInRoom = sumOfPeopleInRoom;
        this.isVacation = isVacation;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public int getSumOfPeopleInRoom() {
        return sumOfPeopleInRoom;
    }

    public void setSumOfPeopleInRoom(int sumOfPeopleInRoom) {
        this.sumOfPeopleInRoom = sumOfPeopleInRoom;
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

    public String getFormattedSummary() {
        Guest guest = getGuest();
        return  getStart()+" až "+getEnd()+": "+guest.getGuestFirstname()+" "
                +guest.getGuestSurname()+" ("+ guest.getBirthdate()+")["
                +getSumOfPeopleInRoom()+", "+(getRoom().isSeaView()?"ano":"ne")+"] za "
                +getTotalPrice()+" Kč";
    }

    public String getFormattedVacation() {
        Guest guest = getGuest();
        return "Rezervace pro: "+guest.getGuestFirstname()+" "
                +guest.getGuestSurname()+" ("+ guest.getBirthdate()+"), na pokoj č."
                +getRoom().getRoomNumber()+", termín: "+getStart()+" až "+getEnd()+".";
    }

    public int getBookingLength() {
        int daysBetween;
        return daysBetween = getStart().until(getEnd()).getDays();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice;
        return totalPrice = getRoom().getPrice().multiply(BigDecimal.valueOf(getBookingLength()));
    }
}//konec třídy
