import java.util.ArrayList;
public class Financial {
    ArrayList<Employee> Pay;
    private double total;
    private double totalExpenses;
    // Constructor
    public Financial(){
        
    }
    //getter
    public double getTotalProfit(ArrayList<Sale> sales, boolean b){
        for(int i = 0; i<sales.size();i++){
            Sale sale_i = sales.get(i);
            total =+ sale_i.getTotalCost(b);
        }
        return total;
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
   
