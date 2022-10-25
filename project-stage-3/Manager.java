import java.util.ArrayList;
public class Manager extends Employee {
    //variable definition
    private ArrayList<Employee> manages = new ArrayList<Employee>();
    private double expenses;
    //constructor
    public Manager(Employee e){
        this.setWage(19.00);
    }
    //manager methods
    public void addEmployee(Employee e){
        manages.add(e);
    }
    public void removeEmployee(Employee e){
        manages.remove(e);
    }
    public ArrayList getEmployees(){
        return manages;
    }
    public void giveRaise(Employee e){
        if (manages.contains(e)){
            double currentpay = e.getWage();
            e.setWage(currentpay+1.50);
        }
    }
    public void setExpenses(double d ){
        expenses = d;
    }
    public double getExpenses(){
        return expenses;
    }
}