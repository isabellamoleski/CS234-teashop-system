/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author isabe
 */
public class Item {
    private String name;
    private double cost;
    private int itemNumber;
    //constructors
    public Item(){
        name = " ";
        cost = 0;
        itemNumber = 0;
    }
    public Item(String s, double d, int i){
        name = s;
        cost = d;
        itemNumber = i;
    }
    //get methods
    public double getCost(){
        return cost;
    }
    public String getName(){
        return name;
    }
    public int getNumber(){
        return itemNumber;
    }
    //set methods
    public void setName(String s){
        name = s;
    }
    public void setCost(double d){
        cost = d;
    }
    public void setNumber(int i){
        itemNumber = i;
    }
}
