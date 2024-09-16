public class Main {
    public static void main(String[] args) {
        TicketMachine machine = new TicketMachine(100);

        System.out.println("Ticket price: " + machine.getPrice() + " cents");

        machine.insertMoney(50);
        machine.printTicket();
        machine.insertMoney(60);
        machine.printTicket();        
        int refund = machine.refundBalance();
        System.out.println("Refunded: " + refund + " cents");
    }
}
