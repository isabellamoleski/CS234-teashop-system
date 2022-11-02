public class Employee {
    //variable definition
    private String name;
    private int age;
    private double wage;
    private double timeWorked;
    // Constructors
    public Employee(){
        name = " ";
        age = 0;
        wage = 15;
        timeWorked = 0;
    }
    public Employee(String name, int age){
        this.name = name;
        this.age = age;
        wage = 15;
        timeWorked = 0;
    }
    public Employee(String name, int age, double wage){
        this.name = name;
        this.age = age;
        this.wage = wage;
        timeWorked = 0;
    }
    public Employee(String name, int age, double wage, double timeWorked){
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.timeWorked = timeWorked;
    }
    // Get
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getWage(){
        return wage;
    }
    public double getTimeWorked(){
        return timeWorked;
    }
    // Set
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setWage(double wage){
        this.wage = wage;
    }
    public void setTimeWorked(double timeWorked){
        this.timeWorked = timeWorked;
    }
        public double getPay()
   {
      double pay = timeWorked * wage;
      if (timeWorked > 40)
      {
         // Add overtime
         pay = pay + ((timeWorked - 40) * 0.5) * wage;
      }
      return pay;
    }
}
