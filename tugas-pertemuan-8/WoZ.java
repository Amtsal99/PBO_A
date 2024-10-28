import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;

public class WoZ {
    private Ruang ruangSekarang;

    public static void main(String[] args) {
        WoZ game = new WoZ();
        game.bermain();
    }

    public WoZ() {
        buatRuangan();
    }

    private void buatRuangan() {
        Ruang luar, teater, pub, lab, kantor;

        luar = new Ruang("outside the main entrance of the university");
        teater = new Ruang("in a lecture theater");
        pub = new Ruang("in the campus pub");
        lab = new Ruang("in a computing lab");
        kantor = new Ruang("in the computing admin office");

        luar.setKeluar("east", teater);
        luar.setKeluar("south", lab);
        luar.setKeluar("west", pub);

        teater.setKeluar("west", luar);

        pub.setKeluar("east", luar);

        lab.setKeluar("north", luar);
        lab.setKeluar("east", kantor);

        kantor.setKeluar("west", lab);

        ruangSekarang = luar;
    }

    public void bermain() {
        selamatDatang();

        Scanner scanner = new Scanner(System.in);
        boolean selesai = false;
        while (!selesai) {
            System.out.print("> ");
            String command = scanner.nextLine();
            selesai = processCommand(command);
        }
        scanner.close();    
        System.out.println("Thank you for playing. Good bye.");
    }

    private void selamatDatang() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(ruangSekarang.getDeskripsiPanjang());
    }

    private boolean processCommand(String command) {
        if (command.equals("help")) {
            printHelp();
        } else if (command.startsWith("go ")) {
            periKeRuangan(command.substring(3));
        } else if (command.equals("quit")) {
            return true;
        } else {
            System.out.println("I don't know what you mean...");
        }
        return false;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    private void periKeRuangan(String direction) {
        Ruang nextRoom = ruangSekarang.getKeluar(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            ruangSekarang = nextRoom;
            System.out.println(ruangSekarang.getDeskripsiPanjang());
        }
    }
}

class Ruang {
    private String deskripsi;
    private HashMap<String, Ruang> exits;

    public Ruang(String deskripsi) {
        this.deskripsi = deskripsi;
        exits = new HashMap<>();
    }

    public void setKeluar(String direction, Ruang neighbor) {
        exits.put(direction, neighbor);
    }

    public String getDeskripsiPanjang() {
        return "You are " + deskripsi + ".\n" + getStringKeluar();
    }

    private String getStringKeluar() {
        StringBuilder returnString = new StringBuilder("Exits:");
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString.append(" ").append(exit);
        }
        return returnString.toString();
    }

    public Ruang getKeluar(String direction) {
        return exits.get(direction);
    }
}