import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  static double money = 0; //create a variable to hold the amount of money
  static ArrayList<String> transactions = new ArrayList<String>(); //create an arraylist to hold the transactions
  static Scanner scanner = new Scanner(System.in);
  
  public static void income(){
      System.out.println("\nHow much money would you like to deposit? \n");
      double input = Double.valueOf(scanner.nextLine());
      money += input; //add the input to the money variable
      
      System.out.println("\nWhat is the source of this income? \n");
      String iSource = scanner.nextLine();
      
      System.out.println("\nWhat is the year of this transaction? (YYYY)\n");
      String iYear = scanner.nextLine();

      System.out.println("\nWhat is the month of this transaction? (MM)\n");
      String iMonth = scanner.nextLine();

      System.out.println("\nWhat is the day of this transaction? (DD)\n");
      String iDay = scanner.nextLine();
    
    
    transactions.add("Date of transaction: " + iMonth + "/" + iDay + "/" + iYear + ". Source of income: " + iSource + ". Current balance: $" + money); //add the transaction to the arraylist
  }

  public static void expense(){
    while(true){ //create a loop to keep asking for input until the user enters a valid input
      System.out.println("How much money would you like to spend? \n \n");
      int output = Integer.parseInt(scanner.nextLine());
      
      if(output <= money){ //if the output is less than or equal to the money variable, subtract the output from the money variable, otherwise, print an error message
        money -= output;
        System.out.println("\nWhat is the source of this expense? \n");
        String eSource = scanner.nextLine();

        System.out.println("\nWhat is the year of this transaction? (YYYY)\n");
        String eYear = scanner.nextLine();

        System.out.println("\nWhat is the month of this transaction? (MM)\n");
        String eMonth = scanner.nextLine();

        System.out.println("\nWhat is the day of this transaction? (DD)\n");
        String eDay = scanner.nextLine();

        transactions.add("Date of transaction: " + eMonth + "/" + eDay + "/" + eYear + ". Source of expense: " + eSource + ". Current balance: $" + money);

        break;
        
      }
      else{
        System.out.println("\nYou don't have enough money to spend that much, try again. \n");
      }

  }
    System.out.println(money);

  }
  public static void balance(){
    System.out.println(money);
  }

  public static void search(){ //create a method to search for a transaction
    System.out.println("What transaction would you like to search for?");
    int count = 0;
    String resonse = scanner.nextLine();
    for(int i = 0; i < transactions.size(); i++){ //loop through the arraylist and check if the input is in the arraylist
      if(transactions.get(i).contains(resonse)){
        System.out.println("Transaction found! Transaction #" + (i + 1) + ": " + transactions.get(i));
        count++;
      }
    }
    if(count == 0){
      System.out.println("Transaction not found.");
    }
  }
  public static void summary(){
    System.out.println("Over what time period would you like to see your summary? (1: month, 2: year)\n"); //create a method to summarize the transactions
    String response = scanner.nextLine();
    if(transactions.size() == 0){ //if the arraylist is empty, print an error message
      System.out.println("No transactions able to be summarized.");
    }
    if(response.equals("1")){
      System.out.println("What is the month of your desired summary? (MM)\n");
      String month = scanner.nextLine();
      int iCount = 0;
      int eCount = 0;
      for(int i = 0; i < transactions.size(); i++){
        if(transactions.get(i).contains(month)){
          System.out.println(transactions.get(i));
          if(transactions.get(i).contains("income"))
            iCount++;
          else if(transactions.get(i).contains("expense"))
            eCount++;
          
        }
      }
      System.out.println("You had " + iCount + " income transactions and " + eCount + " expense transactions. ");
    }
      else if(response.equals("2")){
        System.out.println("What is the year of your desired summary? (YYYY)\n");
        String year = scanner.nextLine();
        int iCount = 0;
        int eCount = 0;
        for(int x = 0; x < transactions.size(); x++){
          if(transactions.get(x).contains(year)){
            System.out.println(transactions.get(x));
            if(transactions.get(x).contains("income"))
              iCount++;
            else if(transactions.get(x).contains("expense"))
              eCount++;
          }
        }
        System.out.println("You had " + iCount + " income transactions and " + eCount + " expense transactions.");
      }
      else{
        System.out.println("Invalid input, try again.\n");
        summary();
      }
    }
  
  public static void main(String[] args) {
    while(true){
      System.out.println("What would you like to do? (i: income, e: expense, b: balance, s: search, sum: summary)\n \n");
      String response = scanner.nextLine();
      if(response.equals("i")){
        income();
        System.out.println(transactions);
      }
      else if(response.equals("e")){
        expense();
        System.out.println(transactions);
      }
      else if(response.equals("b")){
        balance();
      }
      else if(response.equals("s"))
        search();
      else if(response.equals("sum"))
        summary();
      else
        System.out.println("Invalid input, try again.");
    }
  }
}
