/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author isabe
 */
public class Customer {
    //var declaration
    private String name;
    private int memberID;
    private boolean membership;
    //constructors
    public Customer(){
        name = "";
        memberID = 0000;
        membership = false;
    }
    public Customer(String s, int i, boolean b){
        name = s;
        memberID = i;
        membership = b;
    }
    //get methods
    public String getName(){
        return name;
    }
    public int getID(){
        return memberID;
    }
    public boolean isMember(){
        return membership;
    }
    //set methods
    public void setName(String s){
        name = s;
    }
    public void setID(int i){
        memberID = i;
    }
    //methods to purchase/cancel membership
    public void setMembership(boolean b){
        membership = b;
    }
}
