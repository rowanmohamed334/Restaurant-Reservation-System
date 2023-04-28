/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohamed
 */
@XmlRootElement(name="table")
@XmlAccessorType(XmlAccessType.FIELD)
public class TABLE {
    private String tusn;

    public String getTusn() {
        return tusn;
    }

    public void setTusn(String tusn) {
        this.tusn = tusn;
    }
    
    
    
    
    @XmlElement(name="number")
    private int number;
     @XmlElement(name="number_of_seats")
    private String number_of_seats;
      @XmlElement(name="smoking")
    private Boolean smoking;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNumber_of_seats() {
        return number_of_seats;
    }

    public void setNumber_of_seats(String number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public Boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(Boolean smoking) {
        this.smoking = smoking;
    }
       
}
