/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohamed
 */
@XmlRootElement(name="users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
    @XmlElement(name="user")
    private List<User> users;

    public List<User> getusers() {
        return users;
    }

    public void setusers(List<User> users) {
        this.users = users;
    }
    
}
