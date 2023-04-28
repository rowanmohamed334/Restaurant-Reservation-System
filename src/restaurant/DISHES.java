/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohamed
 */
@XmlRootElement(name="dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class DISHES {
    @XmlElement(name="dish")
    private List<DISH> dishes;

    public List<DISH> getdishes() {
        return dishes;
    }

    public void setdishes(List<DISH> dishes) {
        this.dishes = dishes;
    }
    
    
}
