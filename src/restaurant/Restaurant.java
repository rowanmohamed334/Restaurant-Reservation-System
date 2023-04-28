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
@XmlRootElement(name="restaurant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Restaurant {
    @XmlElement(name="users")
    private Users users=null;

    public DISHES getDishes() {
        return dishes;
    }

    public void setDishes(DISHES dishes) {
        this.dishes = dishes;
    }
     @XmlElement(name="tables")
     private TABLES tables=null;
     @XmlElement(name="dishes")
     private DISHES dishes=null;

    public TABLES getTables() {
        return tables;
    }

    public void setTables(TABLES tables) {
        this.tables = tables;
    }
    

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    
    
    
}
