import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Date;

public class Bank {
    public int balance = 0;
    public int number = 0;
    public String Name;
    public int code;

    public Bank(String name, int code, int number) {
        this.Name = name.toUpperCase();
        this.code = code;
        this.number = number;
    }

    public void cashOut (int amount){
        if (this.balance >=  amount) {
            this.balance = this.balance - amount;
            System.out.println("Withdrawing from "+ this.Name + " is done as successfully");
            this.checkBalance();
        }
        else
            System.out.println("Sorry, you don't have enough money");
    }
    public void cashIn(int amount){
        this.balance = this.balance + amount;
            System.out.println("Depositing into "+ this.Name + " is done as successfully");
            this.checkBalance();
    }

    public void checkBalance(){
        System.out.println(String.format("Hi " + this.Name + "," + " You've: " + NumberFormat.getCurrencyInstance().format(this.balance)));
    }

    public void customerInfo(){
        System.out.println("This is your information\n" +
                            "Name: "  + this.Name + " \n" +
                            "Number: "  + this.number + " \n" +
                            "code: "  + this.code + " \n"
        );
    }

    public void transferTo(Bank recipient, double amount){
        if (amount <= this.balance) {
            recipient.cashIn((int) amount);
            this.cashOut((int) amount);
            System.out.println("Transfer to " + recipient.Name + " is done as successfully.");
            return;
        }
        System.out.println("Sorry you don't have enough money");
    }

    public void autoTransfer(Bank recipient, double amount, int day){
        LocalDate localDate = LocalDate.now();
        int currentMonth = localDate.getMonthValue();
        int currentYear = localDate.getYear();
        LocalDate targetDate = LocalDate.of(currentYear,currentMonth, day);
        if (localDate.isEqual(targetDate)){
            System.out.println("Today is the day!");
            System.out.println("Sending Money to "+recipient.Name+" ...");
            transferTo(recipient, amount);
            return;
        }
        System.out.println("You will have to wait until "+ targetDate.plusMonths(1)+" to send Money!");
    }

}