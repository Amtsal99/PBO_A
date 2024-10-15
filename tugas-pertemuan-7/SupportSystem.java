import java.util.Scanner;
import java.util.Random;

public class SupportSystem {
    private InputReader inputReader;
    private Responder responder;
    private boolean active;

    public SupportSystem() {
        inputReader = new InputReader();
        responder = new Responder();
        active = true;
    }

    public void start() {
        printWelcomeMessage();
        while (active) {
            String input = inputReader.getInputCuaca();
            String kota = "";
            if(new String(input).equals("bye")){}
            else{
                kota = inputReader.getInputKota();
            }
            if (input.equalsIgnoreCase("bye")) {
                active = false;
                System.out.println("Terima kasih telah menggunakan sistem cuaca kami. Selamat tinggal!");
            } else {
                String response = responder.generateResponse(input,kota);
                System.out.println(response);
            }
        }
    }

    private void printWelcomeMessage() {
        System.out.println("Selamat datang di Sistem Chat Support Cuaca.");
        System.out.println("Anda dapat menanyakan cuaca hari ini dan mendapatkan rekomendasi pakaian.");
        System.out.println("Ketik 'bye' untuk keluar dari sistem.");
    }

    public static void main(String[] args) {
        SupportSystem supportSystem = new SupportSystem();
        supportSystem.start();
    }
}

class InputReader {
    private Scanner scanner;

    public InputReader() {
        scanner = new Scanner(System.in);
    }

    // Read input from the user
    public String getInputCuaca() {
        System.out.print("> Query : ");
        return scanner.nextLine();
    }
    public String getInputKota() {
        System.out.print("> Tempat : ");
        return scanner.nextLine();
    }
}

class Responder {
    private WeatherService weatherService;
    private String weather;
    private String kota;
    private String clothingRecommendation;
    private int flag;

    public Responder() {
        weatherService = new WeatherService();
        flag=0;
    }

    public String generateResponse(String input,String kota) {
        if (input.toLowerCase().contains("cuaca")) {
            if(flag==1){
                // continue;
                return "Cuaca hari ini di " + this.kota + " adalah: " + this.weather + ". Rekomendasi pakaian: " + this.clothingRecommendation;
            }
            else{
                String weather = weatherService.getWeather();
                String clothingRecommendation = weatherService.getClothingRecommendation(weather);
                this.flag=1;
                this.weather=weather;
                this.kota = kota;
                this.clothingRecommendation=clothingRecommendation;
                return "Cuaca hari ini di " + kota + " adalah: " + weather + ". Rekomendasi pakaian: " + clothingRecommendation;
            }
        } else {
            return "Maaf, saya hanya bisa memberikan informasi tentang cuaca dan rekomendasi pakaian.";
        }
    }
}

class WeatherService {
    private String[] weathers = {"cerah", "hujan", "berawan", "berangin", "panas"};
    private Random random;

    public WeatherService() {
        random = new Random();
    }

    public String getWeather() {
        int index = random.nextInt(weathers.length);
        return weathers[index];
    }

    public String getClothingRecommendation(String weather) {
        switch (weather.toLowerCase()) {
            case "cerah":
                return "Kenakan pakaian ringan seperti kaos dan celana pendek.";
            case "hujan":
                return "Kenakan jaket tahan air dan bawa payung.";
            case "berawan":
                return "Kenakan pakaian yang nyaman, mungkin membawa jaket ringan.";
            case "berangin":
                return "Kenakan pakaian hangat, pastikan membawa jaket.";
            case "panas":
                return "Kenakan pakaian yang tipis dan jangan lupa kacamata hitam.";
            default:
                return "Kenakan pakaian yang nyaman.";
        }
    }
}
