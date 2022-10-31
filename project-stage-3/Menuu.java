import java.util.Scanner;
import java.util.ArrayList;
public class Menuu {
    private static ArrayList<Customer> customers = new ArrayList<>();
    public static void main(String[] args) {
        //dummy customer info
        Customer mary = new Customer("Mary", 0001, false);
        customers.add(mary);
        Customer joseph = new Customer("Joseph", 0002, true);
        customers.add(joseph);
        Customer jose = new Customer("Jose", 2341, true);
        customers.add(jose);
        //call main menu
        Menu();
    }
    public static void Menu(){
        System.out.println("---------------------\nTea Shop: Main Menu \n---------------------");
        System.out.println("Select a menu option: \n1. Employees\n2. Managers\n3. Customers\n4. New Sale \n5. Print Reports \n6. Items \n7. Quit" );
        System.out.print("Enter your selection: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option){
            case 1:
                //EmployeeMenu();
                break;
            case 2: 
                //ManagerMenu();
                break;
            case 3: 
                CustomerMenu();
                break;
            case 4: 
                SaleMenu();
                break;
            case 5: 
                //ReportsMenu
                break;
            case 6: 
                //ItemsMenu
                break;
            case 7: 
                System.out.println("Bye");
                break;
            default: 
                System.out.println("Please select a valid menu option: ");
                Menu();
                break;
        }
    }
    
    public static void CustomerMenu(){
        System.out.println("---------------------\nCustomer Menu\n---------------------");
        System.out.println("Select a menu option: \n1. New Customer\n2. Remove Customer\n3. Modify Customer Info\n4. Print Customer Info\n5. Main Menu \n6. Quit");
        System.out.print("Enter your selection: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option){
            case 1: //add customer
                System.out.println("Enter the customer's name: ");
                String customerName = scan.next();
                System.out.println("Enter the customer's ID number: ");
                int customerID = scan.nextInt();
                System.out.println("Is this customer a member? (true/false): ");
                boolean isMember = scan.nextBoolean();
                Customer newC = new Customer(customerName,customerID,isMember);
                customers.add(newC);
                CustomerMenu();
                break;
                
            case 2: //remove customer
                System.out.print("Enter the customer's name: ");
                String removeThisOne = scan.next();
                //found = customer exists
                boolean found = false;
                //iterate through array, see if the customer name the user entered exists
                for (int i = 0; i<customers.size();i++){
                   //variables to get specific information about the customer at that index
                   Customer customer_i = customers.get(i); 
                   String Ename = customer_i.getName(); 
                       if (removeThisOne.equals(Ename)){ //if customer is found, remove
                           found = true;
                           customers.remove(i);
                       }
                }
                if (found == false){ //if no match is found, let the user know
                    System.out.println("The Customer "+removeThisOne+" does not exist.");
                }
                else{
                    System.out.println("The Customer " + removeThisOne+ " has been successfully removed.");
                }
                CustomerMenu();
                break;
                
            case 3: //modify customer
                System.out.print("Enter the customer's name: ");
                String modifyThisOne = scan.next();
                //found = customer exists
                boolean Modfound = false;
                //iterate through array, see if the customer name the user entered exists
                for (int i = 0; i<customers.size();i++){
                   //variables to get specific information about the customer at that index
                   Customer customer_i = customers.get(i); 
                   String Ename = customer_i.getName(); 
                       if (modifyThisOne.equals(Ename)){ //if customer is found, modify
                           Modfound = true;
                           System.out.println("Enter an updated name: ");
                           String nName = scan.next();
                           customer_i.setName(nName);
                           System.out.println("Enter an updated ID: ");
                           int newID = scan.nextInt();
                           customer_i.setID(newID);
                           if (customer_i.isMember()){
                               System.out.println("Would you like to cancel membership? (y/n)");
                               char yn = scan.next().charAt(0);
                               if (yn == 'y'){
                                   customer_i.cancelMembership();
                               }
                               else if(yn == 'n'){
                                   System.out.println("Membership for "+ modifyThisOne+ " will continue");
                               }
                               else{
                                   System.out.println("Invalid character entered: "+yn);
                               }
                           }
                           else if(!customer_i.isMember()){
                               System.out.println("Would you like to buy membership? (y/n)");
                               char yn = scan.next().charAt(0);
                               if (yn == 'y'){
                                   customer_i.buyMembership();
                               }
                               else if(yn == 'n'){
                                   System.out.println(modifyThisOne+ " is not a member.");
                               }
                               else{
                                   System.out.println("Invalid character entered: "+yn);
                               }
                           }
                       }
                }
                if (Modfound == false){ //if no match is found, let the user know
                    System.out.println("The Customer "+modifyThisOne+" does not exist.");
                }
                else{
                    System.out.println("The customer " + modifyThisOne + "has been successfully modified.");
                }
                CustomerMenu();
                break;
                
            case 4: //print customer info
                System.out.print("Enter the customer's name: ");
                String printThisOne = scan.next();
                //found = customer exists
                boolean printfound = false;
                //iterate through array, see if the customer name the user entered exists
                for (int i = 0; i<customers.size();i++){
                   //variables to get specific information about the customer at that index
                   Customer customer_i = customers.get(i); 
                   String Ename = customer_i.getName(); 
                       if (printThisOne.equals(Ename)){ //if customer is found, print
                           printfound = true;
                           System.out.println("The customer's name is: "+customer_i.getName());
                           System.out.println("The customer's ID is: "+customer_i.getID());
                           if (customer_i.isMember()){
                               System.out.println("The customer is a member.");
                           }
                           else{
                               System.out.println("The customer is not a member.");
                           }
                       }
                }
                if (printfound == false){ //if no match is found, let the user know
                    System.out.println("The Customer "+printThisOne+" does not exist.");
                }
                CustomerMenu();
                break;
                
            case 5: 
                Menu();
                break;
                
            case 6: 
                System.out.println("Bye.");
                break;
                
            default: 
                System.out.println("Please enter a valid menu option: ");
                CustomerMenu();
        }
    }
    
    public static void SaleMenu(){
        System.out.println("---------------------\nNew Sale\n---------------------");
        System.out.println("Select a menu option: \n1. Add Item\n2. Remove Item\n3. Cancel Sale\n4. Print Receipt\n5. Main Menu \n6. Quit");
        System.out.print("Enter your selection: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option){
            case 1:
                SaleMenu();
                break;
            case 2: 
                SaleMenu();
                break;
            case 3: 
                SaleMenu();
                break;
            case 4: 
                SaleMenu();
                break;
            case 5: 
                Menu();
                break;
            case 6: 
                System.out.println("Bye.");
                break;
            default: 
                System.out.println("Please enter a valid menu option: ");
                SaleMenu();
        }
    }

}
