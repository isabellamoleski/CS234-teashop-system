/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author isabe
 */
import java.util.ArrayList;

public class Manager extends Employee {
    //Variable definition
    ArrayList<Employee> manages = new ArrayList<>();
    private double expenses;

 public Manager(Employee aEmployee){
        this.setWage(19.00);
    }
public void addEmployee(Employee aEmployee){
    manages.add(aEmployee);
}
public void removeEmployee(Employee aEmployee){
    manages.remove(aEmployee);
}
public double getExpenses() {
    return expenses;
    
}
public void setExpenses(double expenses){
    this.expenses = expenses;
}
public void giveRaise(Employee aEmployee){
    if(manages.contains(aEmployee)){
        double currentpay = aEmployee.getWage();
        aEmployee.setWage(currentpay+1.50);
    }
}
public void getEmployees(){
    System.out.println(manages);
}
}
