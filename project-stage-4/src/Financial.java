import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
public class Financial {
    ArrayList<Employee> Pay;
    private static ArrayList expenses;
    private static double totalExpenses;
    private static ArrayList<Employee> employees = new ArrayList<>();
    public static ListIterator<Employee> eIter = employees.listIterator();
    private static ArrayList<Manager> managers = new ArrayList<>();
    private static LinkedList<Customer> customers = new LinkedList<>();
    public static ListIterator<Customer> cIter = customers.listIterator();
    private static LinkedList<Item> items = new LinkedList<>();
    public static ListIterator<Item> iIter = items.listIterator();
    public static Sale newSale = new Sale();
    private static ArrayList<Double> allSales =  new ArrayList<>();
    // Constructor
    public Financial(){
    }
    //getter
    public static void getTotalProfit(ArrayList<Double> d){
        for(int i=0; i<d.size();i++){
            System.out.println("Sale of: "+ d.get(i));
            totalExpenses =totalExpenses+(double)d.get(i);
        }
        System.out.println("With a total of: "+totalExpenses);
    }
    public static double getTotalExpenses(ArrayList<Employee> Pay){
        for(int i = 0; i<Pay.size();i++){
            Employee aPay = Pay.get(i);
            double employee_timeWorked = aPay.getTimeWorked();
            totalExpenses = totalExpenses+ aPay.getPay();
        }
        return totalExpenses;
    }
    
    //variables to store other class information
    public static LinkedList<Customer> getCustomers(){
        return customers;
    }
    public static void addCustomer(Customer c){
        customers.add(c);
    }
    public static void removeCustomer(Customer c){
        customers.remove(c);
    }
    public static ArrayList<Employee> getEmployees(){
        return employees;
    }
    public static void addEmployee(Employee e){
        employees.add(e);
    }
    public static void removeEmployee(Employee e){
        employees.remove(e);
    }
    public static LinkedList<Item> getItems(){
        return items;
    }
    public static void addItem(Item i){
        items.add(i);
    }
    public static void removeItem(Item i){
        items.remove(i);
    }
}