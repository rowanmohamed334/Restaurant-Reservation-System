/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Mohamed
 */
public class Cook extends User{
     public static void display() throws JAXBException {
         JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        Restaurant reastaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
        
        
          Group g2 = new Group();
          Stage window2 = new Stage();
          
        window2.setTitle("COOK DASHBOARD");
        Scene scene = new Scene(g2, 800, 700);
       window2.setScene(scene);
        window2.show();
        
        
          Label welcome = new Label("WELCOME");
          welcome.setLayoutX(300);
           welcome.setAlignment(Pos.CENTER);
            welcome.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
          g2.getChildren().add(welcome);
        
          
         TextArea reservedtables = new TextArea();
         reservedtables.setEditable(false);
         g2.getChildren().add(reservedtables);
         reservedtables.setLayoutX(200);
         reservedtables.setLayoutY(150);
         reservedtables.setPrefSize(400, 400);
        
         
         Label label1 = new Label("DISHES RESERVED");
         label1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 24));
         g2.getChildren().add(label1);
         label1.setLayoutX(280);
         label1.setLayoutY(60);
         
      
         
         Label ds = new Label("Dish");
         ds.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
         g2.getChildren().add(ds);
         ds.setLayoutX(220);
         ds.setLayoutY(125);
         
         Label qn = new Label("Quantity");
         qn.setFont(Font.font("Tahoma", FontWeight.NORMAL,18));
         g2.getChildren().add(qn);
         qn.setLayoutX(380);
         qn.setLayoutY(125);
        
         

       
         reastaurant.getDishes().getdishes().stream().forEach((DISH) -> {
             reservedtables.appendText("\n");
            
               reservedtables.appendText(" "+DISH.getName()+" ");
                reservedtables.appendText("\t\t\t\t");
                reservedtables.appendText(" "+DISH.getQuantity());
                reservedtables.appendText("\n");
                 
                 
          
        });
         
          Button log = new Button("LOG OUT");
        log.setPrefSize(200, 50);
        g2.getChildren().add(log);
        log.setLayoutX(300);
        log.setLayoutY(600);
        log.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        log.setAlignment(Pos.CENTER);
        log.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                JOptionPane.showMessageDialog(null, "Are you sure you want to logout ?");
                
         window2.close();
               
            }
        });
        
 
     }
    
}
