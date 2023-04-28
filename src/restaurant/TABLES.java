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
@XmlRootElement(name="tables")
@XmlAccessorType(XmlAccessType.FIELD)
public class TABLES {
    
    @XmlElement(name="table")
    private List<TABLE> tables;

    public List<TABLE> gettables() {
        return tables;
    }

    public void settables(List<TABLE> tables) {
        this.tables = tables;
    }
    
    
}
