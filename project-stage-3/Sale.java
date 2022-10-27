import java.util.ArrayList;
public class Sale {
    //arraylist storing items in sale
    ArrayList<Item> order = new ArrayList<Item>();
    //constructor
    public Sale(){
        order.clear();
    }
    //add and remove items from sale
    public void addOrderItem(Item i){
        order.add(i);
    }
    public void deleteOrderItem(Item i){
        order.remove(i);
    }
    //get total cost of sale
    public double getTotalCost(boolean b){
        double totalCost = 0;
        for (int i = 0; i<order.size();i++){
                   //get cost of all items in order, add them to total
                   Item item_i = order.get(i); 
                   totalCost =+ item_i.getCost(); 
                }
        if (b==true){
            return totalCost*.95;
        }
        else{
            return totalCost;
        }
    }
}
