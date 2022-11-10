import java.util.ArrayList;
public class Financial {
    ArrayList<Employee> Pay;
    private static ArrayList<Double> totalProfit = new ArrayList<>(); 
    private static double totalExpenses;
    // Constructor
    public Financial(){
    }
    public void addToTotal(double d){
        totalProfit.add(d);
    }
    //getter
    public static ArrayList getTotalProfit(){
        return totalProfit;
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
   
