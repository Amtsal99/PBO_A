public class EconomyTicket extends Ticket {
    public EconomyTicket(double baseFare) {
        super(baseFare);
    }

    @Override
    public double calculateFare() {
        return baseFare * 0.9;
    }

    @Override
    public void printTicketInfo() {
        super.printTicketInfo();
        System.out.println("Kelas: Ekonomi, Diskon: 10%, Tarif Akhir: " + calculateFare());
    }
}
