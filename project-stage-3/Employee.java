public class Employee {
    //variable definition
    private String name;
    private int age;
    private double wage;
    private double timeWorked;
    //constructors
    public Employee(){
        name = " ";
        age = 0;
        wage = 15;
        timeWorked = 0;
    }
    public Employee(String s, int i){
        name = s;
        age = i;
        wage = 15;
        timeWorked = 0;
    }
    public Employee(String s, int i, double d){
        name = s;
        age = i;
        wage = d;
        timeWorked = 0;
    }
    //get and set methods
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getWage(){
        return wage;
    }
    public void setName(String s){
        name = s;
    }
    public void setAge(int i){
        age = i;
    }
    public void setWage(double d){
        wage = d;
    }
    public void setTimeWorked(double d){
        timeWorked = d;
    }
    public double getTimeWorked(){
        return timeWorked;
    }
    public void getPaid(double d){
        timeWorked = 0;
        //subtract from financial system?
        //OR subtract from manager expenses: ie the manager is responsible for paying their employees
    }
}