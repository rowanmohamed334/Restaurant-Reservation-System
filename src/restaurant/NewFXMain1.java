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
public class NewFXMain1 extends Application {

    TextArea eft;
    Button btn1, btn2;
    TextField s1;
    PasswordField s2;
    Label usern, pass;

    @Override
    public void start(Stage primaryStage) throws JAXBException {
        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        Restaurant reastaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\input.xml"));

        Group g = new Group();

       
        usern = new Label("USERNAME:");
        g.getChildren().add(usern);
        usern.setPrefWidth(200);
        usern.setAlignment(Pos.CENTER);
        usern.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 18));
        usern.setLayoutY(130);
        usern.setLayoutX(80);

        pass = new Label("PASSWOERD:");
        g.getChildren().add(pass);
        pass.setPrefWidth(200);
        pass.setAlignment(Pos.CENTER);
        pass.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 18));
        pass.setLayoutY(220);
        pass.setLayoutX(80);

        s1 = new TextField();
        s1.setPrefSize(250, 50);
        s1.setLayoutX(240);
        s1.setLayoutY(120);
        g.getChildren().add(s1);
        s1.setPromptText("PLEASE ENTER YOUR USERNAME");

        s2 = new PasswordField();
        s2.setPrefSize(250, 50);
        s2.setLayoutX(240);
        s2.setLayoutY(210);
        g.getChildren().add(s2);
        s2.setPromptText("PLEASE ENTER YOUR PASSWORD");

        btn1 = new Button();
        g.getChildren().add(btn1);
        btn1.setAlignment(Pos.CENTER);
        btn1.setText("SIGN IN");
        btn1.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 18));
        btn1.setPrefSize(200, 50);
        btn1.setLayoutX(230);
        btn1.setLayoutY(300);

        btn2 = new Button();
        g.getChildren().add(btn2);
        btn2.setAlignment(Pos.CENTER);
        btn2.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 18));
        btn2.setPrefSize(200, 50);
        btn2.setText("SIGN UP");
        btn2.setLayoutX(230);
        btn2.setLayoutY(370);

        customer clie = new customer();
        customer mang = new customer();
        customer coo = new customer();
        customer wait = new customer();

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            int  flage = 0;

            @Override
            public void handle(ActionEvent event) {
               
                String testu = s1.getText();
                String testp = s2.getText();
                reastaurant.getUsers().getusers().stream().forEach((user) -> {

                    if (user.getUsername().equals(testu) && user.getPassword().equals(testp)) {

                        if (user.getRole().equals("​Client​")) {

                            clie.setRole(user.getRole());
                            clie.setName(user.getName());
                            clie.setUsername(user.getUsername());
                            clie.setPassword(user.getPassword());
                           
                            try {
                                CLIENT.display(clie.getUsername());
                            } catch (JAXBException ex) {
                                Logger.getLogger(NewFXMain1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                               
                                ArrayList<User> userist = new ArrayList();
                                Restaurant savedperson = new Restaurant();

                                File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\CLACCEPTED.xml");
                                
                                if(file.length()==0){ 
                                Marshaller marshaller = jaxbcontext.createMarshaller();
                                Users uers = new Users();
                                User uer = new User();

                                uer.setName(clie.getName());
                                uer.setUsername(clie.getUsername());
                                uer.setRole(clie.getRole());
                                uer.setPassword(clie.getPassword());
                                userist.add(uer);
                                uers.setusers(userist);
                                savedperson.setUsers(uers);
                                marshaller.marshal(savedperson, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\CLACCEPTED.xml"));}
                                else{ 
                                    
                                    
                                   JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                                 Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                                
                                  savedperson = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\CLACCEPTED.xml"));
                                 
                                 savedperson.getUsers().getusers().stream().forEach((User) -> {

                                 userist.add(User); });
                                
                                 Marshaller marshaller = jaxbcontext.createMarshaller();
                                Users uers = new Users();
                                User uer = new User();

                                uer.setName(clie.getName());
                                uer.setUsername(clie.getUsername());
                                uer.setRole(clie.getRole());
                                uer.setPassword(clie.getPassword());
                                userist.add(uer);
                                uers.setusers(userist);
                                savedperson.setUsers(uers);
                                marshaller.marshal(savedperson, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\CLACCEPTED.xml"));}
                                
                                
                                
                                }
                                

                             catch (JAXBException ex) {
                                Logger.getLogger(NewFXMain1.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        } else if (user.getRole().equals("Manager")) {

                            mang.setRole(user.getRole());
                            
                            try {
                                MANAGER.display();
                            } catch (JAXBException ex) {
                                Logger.getLogger(NewFXMain1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        } else if (user.getRole().equals("​Waiter​")) {

                            wait.setRole(user.getRole());
                            
                            try {
                                Waiter.display();
                            } catch (JAXBException ex) {
                                Logger.getLogger(NewFXMain1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        } else if (user.getRole().equals("​Cooker​")) {

                            coo.setRole(user.getRole());
                          
                            try {
                                Cook.display();
                            } catch (JAXBException ex) {
                                Logger.getLogger(NewFXMain1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                            flage=1;
                     
                    }
                    s1.clear();
                    s2.clear();
           
                });
            if (flage!=1){ JOptionPane.showMessageDialog(null, "WRONG PASSWORD PLEASE TRY AGAIN");}
            }
        });

         btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                
                try {
                    signcustomer.DISPLAY();
                   
                } catch (JAXBException ex) {
                    Logger.getLogger(NewFXMain1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Scene scene = new Scene(g, 700, 500);

        primaryStage.setTitle("LOGIN FORM");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
