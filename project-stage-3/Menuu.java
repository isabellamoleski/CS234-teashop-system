import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;
public class Menuu {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Manager> managers = new ArrayList<>();
    private static LinkedList<Customer> customers = new LinkedList<>();
    private static LinkedList<Item> items = new LinkedList<>();
    private static Sale newSale = new Sale();
    private static ArrayList<Double> allSales =  new ArrayList<>();
    
    public static void main(String[] args) {
        //dummy employee info
        Employee stuart = new Employee("Stuart", 18, 15,20);
        employees.add(stuart);
        Employee barney = new Employee("Barney", 26, 16, 41);
        employees.add(barney);
        Employee mark = new Employee("Mark", 34, 15, 42);
        employees.add(mark);
        Manager m_mark = new Manager(mark);
        managers.add(m_mark);
        m_mark.addEmployee(stuart);
        m_mark.addEmployee(barney);
        //dummy customer info
        Customer mary = new Customer("Mary", 0001, false);
        customers.add(mary);
        Customer joseph = new Customer("Joseph", 0002, true);
        customers.add(joseph);
        Customer jose = new Customer("Jose", 2341, true);
        customers.add(jose);
        //dummy item info
        Item smallTea = new Item("Small_Tea", 2.00, 0123);
        items.add(smallTea);
        Item medTea = new Item("Medium_Tea", 2.50, 0124);
        items.add(medTea);
        Item largeTea = new Item("Large_Tea", 3.00, 0125);
        items.add(largeTea);
        Item sugarPack = new Item("Sugar", 0.10, 0211);
        items.add(sugarPack);
        Item milk = new Item("Milk", 0.20, 0212);
        items.add(milk);
        //dummy sale information
        newSale.order.add(milk);newSale.order.add(smallTea);allSales.add(newSale.getTotalCost(true)); newSale.order.clear();
        newSale.order.add(largeTea);newSale.order.add(smallTea);newSale.order.add(sugarPack);allSales.add(newSale.getTotalCost(false)); newSale.order.clear();
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
                EmployeeMenu();
                break;
            case 2: 
                ManagerMenu();
                break;
            case 3: 
                CustomerMenu();
                break;
            case 4: 
                SaleMenu();
                break;
            case 5: 
                ReportsMenu();
                break;
            case 6: 
                ItemsMenu();
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
    
    public static void EmployeeMenu(){
        System.out.println("---------------------\nEmployee menu\n---------------------");
        System.out.println("Select a menu option: \n1. List of Employees\n2. Employee enter timeworked\n3. Employee timeworked\n4. Employee Pay\n5. Main Menu \n6. Quit");
        System.out.print("Enter your selection: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option){
            case 1: //List out Employees and their information
               for( Employee newE: employees){
                   System.out.println("Employee: "+newE.getName()+ ", "+newE.getAge()+ ", $" + newE.getWage()+" an hour");
               } 
               EmployeeMenu();
               break;
            case 2: //Enter the employees time worked
                System.out.print("Enter the employees name: ");
                String modifyThisOne = scan.next();
                //found = employee exists
                boolean Modfound = false;
                //iterate through array, see if the employee name the user entered exists
                for (int i = 0; i<employees.size();i++){
                   //variables to get specific information about the employee at that index
                   Employee emp = employees.get(i); 
                   String Ename = emp.getName(); 
                       if (modifyThisOne.equals(Ename)){ //if employee is found, remove
                           Modfound = true;
                           System.out.println("Enter time worked: ");
                           Double newTimeWorked = scan.nextDouble();
                           emp.setTimeWorked(newTimeWorked);
                           }
                       }
                if (Modfound == false){ //if no match is found, let the user know
                    System.out.println("The employee "+modifyThisOne+" does not exist.");
                }
                else{
                    System.out.println("The employee " + modifyThisOne + "time worked has been added.");
                }
                EmployeeMenu();
                break;
            case 3: //Print the time worked for all employees
                for (int i = 0; i<employees.size();i++){
                    Employee emp = employees.get(i);
                   System.out.println("Name: " +emp.getName()+", "+emp.getTimeWorked()+" hours");
                }
                EmployeeMenu();
                
                break;
            case 4: //Print out the amount of pay for an employee
                for( Employee newE: employees){
                    //Employee emp = newE.get();
                   System.out.println("Name: "+newE.getName()+" $"+newE.getPay());
                }
                EmployeeMenu();
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
    
     public static void ManagerMenu(){
        System.out.println("---------------------\nManagment menu\n---------------------");
        System.out.println("Select a menu option: \n1. Add Employee\n2. Remove Employee\n3. Give Raise\n4. Expenses\n5. Main Menu \n6. Quit");
        System.out.print("Enter your selection: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        //this sets thisManager to Mark, who is at index 0 in the managers arraylist. could ask for user input for which manager it was if there are ever multiple
        Manager thisManager = managers.get(0);
        switch(option){
            case 1: //Add employee
                System.out.println("Enter the Employee's name: ");
                String employeeName = scan.next();
                System.out.println("Enter the Employee's age: ");
                int employeeAge = scan.nextInt();
                Employee newE = new Employee(employeeName,employeeAge);
               employees.add(newE);
                thisManager.addEmployee(newE);
                ManagerMenu();
                break;
            case 2: //Remove employee
                System.out.print("Enter the employee's name: ");
                String removeThisOne = scan.next();
                //found = employee exists
                boolean found = false;
                //iterate through array, see if the employee name the user entered exists
                for (int i = 0; i<employees.size();i++){
                   //variables to get specific information about the employee at that index
                   Employee emp_i = employees.get(i); 
                   String Ename = emp_i.getName(); 
                       if (removeThisOne.equals(Ename)){ //if employee is found, remove
                           found = true;
                           employees.remove(i);
                           thisManager.removeEmployee(emp_i);
                       }
                }
                if (found == false){ //if no match is found, let the user know
                    System.out.println("The Employee "+removeThisOne+" does not exist.");
                }
                else{
                    System.out.println("The Employee " + removeThisOne+ " has been successfully removed.");
                }
                ManagerMenu();
                break;
            case 3: //Give Raise
                System.out.print("Enter the employees name: ");
                String modifyThisOne = scan.next();
                //found = employee exists
                boolean Modfound = false;
                //iterate through the 'manages' arraylist within the manager object you want - in this case mark's
                for (int i = 0; i<thisManager.manages.size();i++){
                   //variables to get specific information about the employee at that index
                   Employee emp = thisManager.manages.get(i); 
                   String Ename = emp.getName(); 
                       if (modifyThisOne.equals(Ename)){ //if employee is found, give 'em a raise
                           Modfound = true;
                           thisManager.giveRaise(emp);
                           
                           }
                       }
                if (Modfound == false){ //if no match is found, let the user know
                    System.out.println("The employee "+modifyThisOne+" does not exist.");
                }
                else{
                    System.out.println("The employee " + modifyThisOne + " raise has been added.");
                } 
                ManagerMenu();
                break;
            case 4: //Expenses
                System.out.print("Enter the amount of expenses: ");
                double expenses = scan.nextDouble();
                thisManager.setExpenses(expenses);
                ManagerMenu();
                break;
            case 5: 
                Menu();
                break;
            case 6: 
                System.out.println("Bye.");
                break;
            default: 
                System.out.println("Please enter a valid menu option: ");
                ManagerMenu();
        }
    }
    
    public static void CustomerMenu(){
        System.out.println("---------------------\nCustomer Menu\n---------------------");
        System.out.println("Select a menu option: \n1. New Customer\n2. Remove Customer\n3. Modify Customer Info\n4. Print Customer Info\n5. Main Menu \n6. Quit");
        System.out.print("Enter your selection: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        ListIterator<Customer> cIter = customers.listIterator();
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
                while (cIter.hasNext()){
                   Customer customer_i = cIter.next(); 
                   String Ename = customer_i.getName(); 
                       if (removeThisOne.equals(Ename)){ //if customer is found, remove
                           found = true;
                           cIter.remove();
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
                while (cIter.hasNext()){
                   //variables to get specific information about the customer at that index
                   Customer customer_i = cIter.next(); 
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
                               switch (yn) {
                                   case 'y' -> customer_i.cancelMembership();
                                   case 'n' -> System.out.println("Membership for "+ modifyThisOne+ " will continue");
                                   default -> System.out.println("Invalid character entered: "+yn);
                               }
                           }
                           else if(!customer_i.isMember()){
                               System.out.println("Would you like to buy membership? (y/n)");
                               char yn = scan.next().charAt(0);
                               switch (yn) {
                                   case 'y' -> customer_i.buyMembership();
                                   case 'n' -> System.out.println(modifyThisOne+ " is not a member.");
                                   default -> System.out.println("Invalid character entered: "+yn);
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
                while (cIter.hasNext()){
                   //variables to get specific information about the customer at that index
                   Customer customer_i = cIter.next();  
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
    
    public static void ItemsMenu(){
        System.out.println("---------------------\nItems Menu\n---------------------");
        System.out.println("Select a menu option: \n1. New Item\n2. Remove Item\n3. Modify Price\n4. Print Item Info\n5. Main Menu \n6. Quit");
        System.out.print("Enter your selection: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        ListIterator<Item> iIter = items.listIterator();
        switch(option){
            case 1: //new item
                System.out.println("Enter the item's name: ");
                String itemName = scan.next();
                System.out.println("Enter item number: ");
                int itemNum = scan.nextInt();
                System.out.println("Enter the item cost: ");
                double itemCost = scan.nextDouble();
                Item newI = new Item(itemName,itemCost, itemNum);
                items.add(newI);
                ItemsMenu();
                break;
                
            case 2: //remove item
                System.out.println("Enter the item's name: ");
                String removeThisOne = scan.next();
                //found = item exists
                boolean removeFound = false;
                while(iIter.hasNext()){
                   //variables to get specific information about the item
                   Item item_i = iIter.next();
                   String Ename = item_i.getName(); 
                       if (removeThisOne.equals(Ename)){ //if item is found, remove
                           removeFound = true;
                           iIter.remove();
                       }
                }
                if (removeFound == false){ //if no match is found, let the user know
                    System.out.println("The Item "+removeThisOne+" does not exist.");
                }
                else{
                    System.out.println("The Item " + removeThisOne+ " has been successfully removed.");
                }
                ItemsMenu();
                break;
                
            case 3: //modify price
                System.out.println("Enter the item's name: ");
                String modifyThisOne = scan.next();
                //found = item exists
                boolean Modfound = false;
                //iterate through array, see if the item exists
                while(iIter.hasNext()){
                   //variables to get specific information about the item at that index
                   Item item_i = iIter.next(); 
                   String Ename = item_i.getName(); 
                       if (modifyThisOne.equals(Ename)){ 
                           Modfound = true;
                           System.out.println("Enter the item's updated price: ");
                           double newPrice = scan.nextDouble();
                           item_i.setCost(newPrice);
                           }
                       }
                if (Modfound == false){ //if no match is found, let the user know
                    System.out.println("The Item "+modifyThisOne+" does not exist.");
                }
                else{
                    System.out.println("The item " + modifyThisOne + " has had it's price updated.");
                }
                ItemsMenu();
                break;
                
            case 4: //print item info
                System.out.print("Enter the item's name: ");
                String printThisOne = scan.next();
                //found = item exists
                boolean printfound = false;
                //iterate through array, see if the item the user entered exists
                while(iIter.hasNext()){
                   //variables to get specific information about the item at that index
                   Item item_i = iIter.next();
                   String Ename = item_i.getName(); 
                       if (printThisOne.equals(Ename)){ //if item is found, print
                           printfound = true;
                           System.out.println("The item's name is: "+item_i.getName());
                           System.out.println("The item's number is: "+item_i.getNumber());
                           System.out.println("The item's cost is: $"+item_i.getCost());
                       }
                }
                if (printfound == false){ //if no match is found, let the user know
                    System.out.println("The Item "+printThisOne+" does not exist.");
                }
                ItemsMenu();
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
        ListIterator<Item> sIter = newSale.order.listIterator();
        switch(option){
            case 1: //add item
                System.out.println("Enter the item's name: ");
                String addThisOne = scan.next();
                //found = item exists
                boolean found = false;
                for(int i=0; i<items.size(); i++){
                   //variables to get specific information about the item
                   Item item_i = items.get(i);
                   String Ename = item_i.getName(); 
                       if (addThisOne.equals(Ename)){ //if item is found, add
                           found = true;
                           sIter.add(item_i);
                       }
                }
                if (found == false){ //if no match is found, let the user know
                    System.out.println("The Item "+addThisOne+" does not exist.");
                }
                SaleMenu();
                break;
            case 2: //remove item
                System.out.println("Enter the item's name: ");
                String removeThisOne = scan.next();
                //found = item exists
                boolean removeFound = false;
                while(sIter.hasNext()){
                   //variables to get specific information about the item
                   Item item_i = sIter.next(); 
                   String Ename = item_i.getName(); 
                       if (removeThisOne.equals(Ename)){ //if item is found, remove
                           removeFound = true;
                           sIter.remove();
                       }
                }
                if (removeFound == false){ //if no match is found, let the user know
                    System.out.println("The Item "+removeThisOne+" does not exist or is not part of this order.");
                }
                SaleMenu();
                break;
            case 3: //cancel sale
                System.out.println("Are you sure you want to cancel this sale? \nThis will remove all items in the sale(y/n): ");
                char yesno = scan.next().charAt(0);
                switch (yesno) {
                    case 'y' -> newSale.order.clear();
                    case 'n' -> System.out.println("Your sale will not be cancelled. ");
                    default -> System.out.println("Invalid character entered: "+yesno+" . Your sale will not be cancelled.");
                }
                SaleMenu();
                break;

            case 4: //print receipt
                System.out.println("Item Name | Item Number | Item Cost");
                while(sIter.hasNext()){
                   //variables to get specific information about the item
                   Item item_i = sIter.next();
                   String eName = item_i.getName();
                   int eNum = item_i.getNumber();
                   double eCost = item_i.getCost();
                   System.out.println(eName+"   |   "+eNum+"   |   "+eCost);
                }
                System.out.println("Is this customer a member? (true/false):");
                boolean mem = scan.nextBoolean();
                System.out.println("Total Cost: "+newSale.getTotalCost(mem));
                allSales.add(newSale.getTotalCost(mem));
                newSale.order.clear();
                SaleMenu();
                break;
            case 5: //main menu
                Menu();
                break;
            case 6: //quit
                System.out.println("Bye.");
                break;
            default: 
                System.out.println("Please enter a valid menu option: ");
                SaleMenu();
        }
    }
    
    public static void ReportsMenu(){
     System.out.println("---------------------\nReport Menu \n---------------------");
        System.out.println("Select a menu option: \n1. Total Profit report\n2. Total Expenses Report\n3. Main Menu \n4. Quit" );
        System.out.print("Enter your selection: ");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch(option){
            case 1: //report of total profit
                System.out.println("Total Profits Report \n--------------------");
                Financial.getTotalProfit(allSales);
                ReportsMenu();
                break;
            case 2: //Report on total expenses
                System.out.println("Total Expenses Report \n--------------------");
                for(int i=0;i<employees.size();i++){
                    Employee employee_i = employees.get(i);
                    System.out.println("The employee "+employee_i.getName()+" worked for "+employee_i.getTimeWorked()+" hours at $"+employee_i.getWage()+" per hour, and earned "+employee_i.getPay());
                }
                System.out.println("The total expenses are: "+Financial.getTotalExpenses(employees));
                ReportsMenu();
                break;
            case 3: //Main menu
                Menu();
                break;
            case 4: 
                System.out.println("Bye");
                break;
            default: 
                System.out.println("Please select a valid menu option: ");
                Menu();
                break;
        }
    }

}
