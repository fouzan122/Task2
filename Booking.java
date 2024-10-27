public class Booking {
    private String guestName;
    private Room room;
    private int nights;
    private double totalCost;

    public Booking(String guestName, Room room, int nights) {
        this.guestName = guestName;
        this.room = room;
        this.nights = nights;
        this.totalCost = room.getPricePerNight() * nights;
        room.setAvailable(false);  // Mark room as unavailable after booking
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Guest Name: " + guestName + "\nRoom: " + room.getRoomNumber() +
                "\nCategory: " + room.getCategory() + "\nNights: " + nights + 
                "\nTotal Cost: $" + totalCost;
    }
}
