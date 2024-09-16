public class Main {
    public static void main(String[] args) {
        ClockDisplay clock = new ClockDisplay();
        
        clock.setTime(15, 23);
        System.out.println("Initial time: " + clock.getTime());

        clock.timeTick();
        System.out.println("After one minute: " + clock.getTime());
    }
}