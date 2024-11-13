public class BusinessTicket extends Ticket {
    public BusinessTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.25; 
    }

    @Override
    public void printTicketInfo() {
        super.printTicketInfo();
        System.out.println("Kelas: Bisnis, Biaya Tambahan: 25%, Tarif Akhir: " + calculateFare());
    }
}
