/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author isabe
 */
import java.util.ArrayList;
public class Sale {
    //arraylist storing items in sale
    ArrayList<Item> order = new ArrayList<>();
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
        boolean isMember = b;
        for (int i = 0; i<order.size();i++){
                   //get cost of all items in order, add them to total
                   Item item_i = order.get(i); 
                   totalCost = totalCost + item_i.getCost(); 
                }
        if (isMember){
            return totalCost*.95;
        }
        else{
            return totalCost;
        }
    }
}

