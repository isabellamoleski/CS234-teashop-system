import java.util.Scanner;
public class Menuu {

    public static void main(String[] args) {
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
            case 1:
                
                CustomerMenu();
                break;
            case 2: 
                CustomerMenu();
                break;
            case 3: 
                CustomerMenu();
                break;
            case 4: 
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