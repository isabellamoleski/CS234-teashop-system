import java.util.ArrayList;
public class Financial {
ArrayList<Employee> Pay;
    private static ArrayList<Double> totalProfit; 
    private double totalExpenses;
    // Constructor
    public Financial(){
        totalProfit.clear();
    }
    public void addToTotal(double d){
        totalProfit.add(d);
    }
    //getter
    public static ArrayList getTotalProfit(){
        return totalProfit;
    }
    public double getTotalExpenses(ArrayList<Employee> Pay){
        Pay.equals(Pay);
        for(int i = 0; i<Pay.size();i++){
            Employee aPay = Pay.get(i);
            double employee_timeWorked = aPay.getTimeWorked();
            totalExpenses =+ aPay.getPay();
            
        }
        totalExpenses = 0;
        return totalExpenses;
    }
}
   
