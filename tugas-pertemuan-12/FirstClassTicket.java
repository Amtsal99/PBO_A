public class FirstClassTicket extends Ticket {
    public FirstClassTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 1.5;
    }

    @Override
    public void printTicketInfo() {
        super.printTicketInfo();
        System.out.println("Kelas: First Class, Biaya Tambahan: 50%, Tarif Akhir: " + calculateFare());
    }
}
