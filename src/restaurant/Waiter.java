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
public class Waiter extends User {

    public static void display() throws JAXBException {
        
        
        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        Restaurant reastaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));
        Restaurant savedrestaurant = new Restaurant();

        Group g2 = new Group();
        Label welcome = new Label("WELCOME SIR");
        welcome.setLayoutX(300);
        welcome.setAlignment(Pos.CENTER);
        welcome.setFont(Font.font("Tahoma", FontWeight.BLACK, 30));
        g2.getChildren().add(welcome);

        Scene scene = new Scene(g2, 800, 700);

        TextArea reservedtables = new TextArea();
        reservedtables.setEditable(false);
        g2.getChildren().add(reservedtables);
        reservedtables.setLayoutX(150);
        reservedtables.setLayoutY(150);
        reservedtables.setPrefSize(500, 400);

        
        Label label1 = new Label("TABLES RESERVED");
        label1.setFont(Font.font("Tahoma", FontWeight.BLACK, 17));
        g2.getChildren().add(label1);
        label1.setLayoutX(310);
        label1.setLayoutY(60);
       
        

             reastaurant.getTables().gettables().stream().forEach((TABLE) -> {
             reservedtables.appendText("\n");
             reservedtables.appendText("     "+ TABLE.getTusn());
             reservedtables.appendText("\t \t \t");
             reservedtables.appendText("      "+ TABLE.getNumber());
             reservedtables.appendText("\t \t \t");
             reservedtables.appendText("          "+ TABLE.getNumber_of_seats());
             reservedtables.appendText("\t");
             reservedtables.appendText("        \t  \t   "+TABLE.getSmoking());
             reservedtables.appendText("\n");
        });
        
         Label name1 = new Label("CLIENT");
        Label dishl = new Label("Table");
        Label quantity = new Label("Seat");
        Label price = new Label("Smoking");
        
        
        name1.setLayoutX(170);
        name1.setLayoutY(125);
        name1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        
        dishl.setLayoutX(290);
        dishl.setLayoutY(125);
        dishl.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        
        quantity.setLayoutX(390);
        quantity.setLayoutY(125);
        quantity.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        
        price.setLayoutX(505);
        price.setLayoutY(125);
        price.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
        
        g2.getChildren().add(name1);
        g2.getChildren().add(dishl);
        g2.getChildren().add(quantity);
        g2.getChildren().add(price);
        
        
        
         
        
        

      
        Stage window2 = new Stage();
        window2.setTitle("WAITER DASHBOARD");
        window2.setScene(scene);
        window2.show();
        
        
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
