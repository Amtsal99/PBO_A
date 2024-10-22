import java.io.*;
public class Customer {
    private BankAccount acc;

    public Customer() {
        acc = new BankAccount();
    }

    public void deposit(int amount) {
        acc.deposit(amount);
    }
    public void withdraw(int amount) {
        acc.withdraw(amount);
    }

    public static void main(String[] args) throws IOException  {

        Customer customer = new Customer();
        
        InputStreamReader inp = new InputStreamReader(System.in);
        
        int amount;
        char c = ' ';

        while (true) {
            // c = ' ';
            System.out.println("Deposit/Withdraw? (d/w)");
            c = (char)inp.read();
            while (c > 'z' || c < 'a') {
                c = (char)inp.read();
            }

            if (c == 'd') {
                System.out.println("Enter amount to deposit: ");
                amount = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                customer.deposit(amount);
            } else if (c == 'w') {
                System.out.println("Enter amount to withdraw: ");
                amount = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
                customer.withdraw(amount);
            }
            else {return;}
        }
    }

}

class BankAccount {
    private int saldo;

    public void deposit(int amount) {
        this.saldo += amount;
        System.out.println("Saldo anda sekarang: " + this.saldo);
    }
    public void withdraw(int amount) {
        this.saldo -= amount;
        System.out.println("Saldo anda sekarang: " + this.saldo);
    }
}