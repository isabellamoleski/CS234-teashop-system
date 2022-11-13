import java.util.ArrayList;
public class Financial {
    ArrayList<Employee> Pay;
    private static ArrayList expenses;
    private static double totalExpenses;
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
}
   
