public class TicketReservationSystem {
    public static void main(String[] args) {
        double baseFare = 1000;

        Ticket economyTicket = new EconomyTicket(baseFare);
        Ticket businessTicket = new BusinessTicket(baseFare);
        Ticket firstClassTicket = new FirstClassTicket(baseFare);

        System.out.println("Reservasi Tiket:");
        System.out.println("----------------------------");
        economyTicket.printTicketInfo();

        System.out.println("\n----------------------------");
        businessTicket.printTicketInfo();

        System.out.println("\n----------------------------");
        firstClassTicket.printTicketInfo();
    }
}
