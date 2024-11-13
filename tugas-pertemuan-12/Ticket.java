public abstract class Ticket {
    protected double baseFare;

    public Ticket(double baseFare) {
        this.baseFare = baseFare;
    }

    // Metode abstrak untuk menghitung tarif akhir tiket
    public abstract double calculateFare();

    // Menampilkan info tiket dasar
    public void printTicketInfo() {
        System.out.println("Tarif dasar: " + baseFare);
    }
}
