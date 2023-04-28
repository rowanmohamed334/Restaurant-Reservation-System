/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author Mohamed
 */
public class reserveTable extends TABLE{
    
     private int number;
  private Boolean smoking;
  private String number_of_seats;

    @Override
    public void setSmoking(Boolean smoking) {
        super.setSmoking(smoking); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean getSmoking() {
        return super.getSmoking(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumber_of_seats(String number_of_seats) {
        super.setNumber_of_seats(number_of_seats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNumber_of_seats() {
        return super.getNumber_of_seats(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNumber(int number) {
        super.setNumber(number); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumber() {
        return super.getNumber(); 
    }
     public boolean Reserved;

    public boolean isReserved() {
        return Reserved;
    }

    public void setReserved(boolean Reserved) {
        this.Reserved = Reserved;
    }
  
    
}
