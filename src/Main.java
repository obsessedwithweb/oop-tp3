import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        System.out.println("Welcome to our Bank\n");

        System.out.println("Creating the first account:");
        Bank account1 = creatingAccount();

        System.out.println("Creating the second account:");
        Bank account2 = creatingAccount();

        System.out.println("Creating accounts done as successfully.");

        while (true){
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println("Select your account:");
            System.out.println("1- First account");
            System.out.println("2- Second account");
            System.out.println("3- Exit");
            String choice = input.nextLine();
            if(choice.equals("1")){
                bankTools(account1, account2);
            }
            else if (choice.equals("2")){
                bankTools(account2, account1);
            }
            else if (choice.equals("3")){
                break;
            }
            else {
                System.out.println("Wrong choice, bye ...");
                break;
            }
        }
        input.close();
    }

    private static Bank creatingAccount() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of the account: ");
        String name = input.nextLine();

        System.out.print("Enter your code: ");
        int code = input.nextInt();

        System.out.print("Enter your number: ");
        int number = input.nextInt();

        return new Bank(name, code, number);
    }

    private static void bankTools(Bank main, Bank receiver) {
        Scanner input = new Scanner(System.in);
        while (true){
            System.out.println("""
                    Bank Account Menu
                    1. Cash In
                    2. Cash Out
                    3. Check Balance
                    4. Display Account Information
                    5. Transfer money to another account
                    6. Monthly automatic transfer account
                    7. Exit
                    """
            );
            int option = input.nextInt();
            if (option == 1){
                System.out.println("Enter the amount you need: ");
                int size = input.nextInt();
                main.cashIn(size);
            }
            if (option == 2){
                System.out.println("Enter the amount you want to withdraw: ");
                int size = input.nextInt();
                main.cashOut(size);
            }
            if (option == 3){
                main.checkBalance();
            }
            if (option == 4){
                main.customerInfo();
            }
            if (option == 5){
                System.out.println("Enter the amount you need to transfer: ");
                int size = input.nextInt();
                main.transferTo(receiver, size);
            }
            if (option == 6){
                System.out.println("Enter the amount you need to transfer: ");
                int size = input.nextInt();
                int day = input.nextInt();
                main.autoTransfer(receiver, size, day);
            }
            if (option >= 7)
                break;
        }
    }
}
