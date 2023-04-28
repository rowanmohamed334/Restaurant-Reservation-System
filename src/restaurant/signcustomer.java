/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.io.File;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Mohamed
 */
public class signcustomer {

    public static void DISPLAY() throws JAXBException {
        Stage window = new Stage();
        Scene scene3;
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("NEW CLIENT");
        Group g2 = new Group();

        Button btn1, btn2;
        TextField s1, s2;
        PasswordField s3;
        Label usern, pass, nn;

        usern = new Label("NAME:");
        g2.getChildren().add(usern);
        usern.setPrefWidth(200);
        usern.setAlignment(Pos.CENTER);
        usern.setFont(Font.font("Tahoma", FontWeight.LIGHT, 18));
        usern.setLayoutY(100);
        usern.setLayoutX(80);

        pass = new Label("USERNAME:");
        g2.getChildren().add(pass);
        pass.setPrefWidth(200);
        pass.setAlignment(Pos.CENTER);
        pass.setFont(Font.font("Tahoma", FontWeight.LIGHT, 18));
        pass.setLayoutY(160);
        pass.setLayoutX(80);

        nn = new Label("PASSWOERD:");
        g2.getChildren().add(nn);
        nn.setPrefWidth(200);
        nn.setAlignment(Pos.CENTER);
        nn.setFont(Font.font("Tahoma", FontWeight.LIGHT, 18));
        nn.setLayoutY(220);
        nn.setLayoutX(80);

        s1 = new TextField();
        s1.setPrefSize(250, 40);
        s1.setLayoutX(240);
        s1.setLayoutY(90);
        g2.getChildren().add(s1);
        s1.setPromptText("ENTER YOUR NAME");

        s2 = new TextField();
        s2.setPrefSize(250, 40);
        s2.setLayoutX(240);
        s2.setLayoutY(150);
        g2.getChildren().add(s2);
        s2.setPromptText("ENTER YOUR USERNAME");

        s3 = new PasswordField();
        s3.setPrefSize(250, 40);
        s3.setLayoutX(240);
        s3.setLayoutY(210);
        g2.getChildren().add(s3);
        s3.setPromptText("ENTER YOUR PASSWORD");

        btn1 = new Button();
        g2.getChildren().add(btn1);
        btn1.setAlignment(Pos.CENTER);
        btn1.setText("SAVE");
        btn1.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 18));
        btn1.setPrefSize(200, 50);
        btn1.setLayoutX(230);
        btn1.setLayoutY(300);

        //customer clie = new customer();

        btn1.setOnAction(new EventHandler<ActionEvent>() {
         

            @Override
            public void handle(ActionEvent event) {

                try {

                     ArrayList<User> userist = new ArrayList();
                     Restaurant savedperson = new Restaurant();
                    JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                     File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\CLACCEPTED.xml");
                     System.out.println(file.length());
                     if (file.length() == 0) {
                    Marshaller marshaller = jaxbcontext.createMarshaller();
                    Users uers = new Users();
                    User uer = new User();

                    uer.setName(s1.getText());
                    uer.setUsername(s2.getText());
                    uer.setRole("client");
                    uer.setPassword(s3.getText());
                    userist.add(uer);
                    uers.setusers(userist);
                    savedperson.setUsers(uers);
                    marshaller.marshal(savedperson, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\CLACCEPTED.xml"));
                     } else {
                    
                    Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();

                    savedperson = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\CLACCEPTED.xml"));

                    savedperson.getUsers().getusers().stream().forEach((User) -> {

                        userist.add(User);
                    });

                    Marshaller marshaller = jaxbcontext.createMarshaller();
                    Users uers = new Users();
                    User uer = new User();

                    uer.setName(s1.getText());
                    uer.setUsername(s2.getText());
                    uer.setRole("client");
                    uer.setPassword(s3.getText());
                    userist.add(uer);
                    uers.setusers(userist);
                    savedperson.setUsers(uers);
                    marshaller.marshal(savedperson, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\CLACCEPTED.xml"));
                    }
                } catch (JAXBException ex) {
                    Logger.getLogger(NewFXMain1.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                
                
                

                JOptionPane.showMessageDialog(null, "YOU CAN NOW MAKE A RESERVATION");
                try {
                    CLIENT.display(s2.getText());
                } catch (JAXBException ex) {
                    Logger.getLogger(signcustomer.class.getName()).log(Level.SEVERE, null, ex);
                }

                window.close();
              
            }
        });

        scene3 = new Scene(g2, 700, 500);

        window.setScene(scene3);
        window.setTitle("NEW CLIENT");
        window.showAndWait();

    }
}
