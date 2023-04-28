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
import java.io.File;
import static java.sql.JDBCType.NULL;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class CLIENT {

    public static void display(String nus) throws JAXBException {
        reservedish awel = new reservedish();
        reservedish tany = new reservedish();
        reservedish talet = new reservedish();
        reservedish rabe = new reservedish();
        reservedish khams = new reservedish();
        reservedish sads = new reservedish();
        reservedish sabe = new reservedish();
        reservedish floos = new reservedish();
        Stage window = new Stage();
        Scene scene2;
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("CLIENT DASHBOARD");

        Group g1 = new Group();
       

        reserveTable first = new reserveTable();
        reserveTable second = new reserveTable();
        reserveTable third = new reserveTable();
        reserveTable forth = new reserveTable();
        reserveTable fifth = new reserveTable();
        reserveTable sixth = new reserveTable();
        reserveTable seventh = new reserveTable();

        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        Restaurant reastaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\input.xml"));

        
        Label title1 = new Label("AVAILABLE TABLES");
        g1.getChildren().add(title1);
        title1.setPrefWidth(300);
        title1.setAlignment(Pos.TOP_LEFT);
        title1.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));
        title1.setLayoutX(100);
        title1.setLayoutY(90);

        Button t1, t2, t3, t4, t5, t6, t7;

        t1 = new Button("select");
        t1.setPrefSize(100, 50);
        t1.setLayoutX(290);
        t1.setLayoutY(160);
        t1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        t1.setAlignment(Pos.CENTER);
        g1.getChildren().add(t1);
        t1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                first.setReserved(true);
                if (first.isReserved()) {

                    try {
                        ArrayList<TABLE> TableList = new ArrayList<>();
                        Restaurant saved = new Restaurant();
                        File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml");
                        System.out.println(file.length());
                        if (file.length() == 0) {
                            Marshaller marshaller = jaxbcontext.createMarshaller();
                            TABLES tables = new TABLES();
                            TABLE table1 = new TABLE();
                            table1.setNumber(first.getNumber());
                            table1.setNumber_of_seats(first.getNumber_of_seats());
                            table1.setSmoking(first.getSmoking());
                            table1.setTusn(nus);
                            TableList.add(table1);
                            tables.settables(TableList);
                            saved.setTables(tables);
                            marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));
                        } else {
                            JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                            Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                            saved = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));
                            saved.getTables().gettables().stream().forEach((TABLE) -> {
                                TableList.add(TABLE);
                            });
                            Marshaller marshaller = jaxbcontext.createMarshaller();
                            TABLES tables = new TABLES();
                            TABLE table1 = new TABLE();
                            table1.setNumber(first.getNumber());
                            table1.setNumber_of_seats(first.getNumber_of_seats());
                            table1.setSmoking(first.getSmoking());
                            table1.setTusn(nus);
                            TableList.add(table1);
                            tables.settables(TableList);
                            saved.setTables(tables);
                            marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));
                        }

                    } catch (JAXBException ex) {
                        Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });

        t2 = new Button("select");
        t2.setPrefSize(100, 50);
        g1.getChildren().add(t2);
        t2.setLayoutX(290);
        t2.setLayoutY(260);
        t2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        t2.setAlignment(Pos.CENTER);
        t2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                second.setReserved(true);
                if (second.isReserved()) {
                    try {
                        ArrayList<TABLE> TableList = new ArrayList<>();
                        Restaurant saved = new Restaurant();
                        File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml");
                        System.out.println(file.length());
                        if (file.length() == 0) {
                            Marshaller marshaller = jaxbcontext.createMarshaller();
                            TABLES tables = new TABLES();
                            TABLE table2 = new TABLE();
                            table2.setNumber(second.getNumber());
                            table2.setNumber_of_seats(second.getNumber_of_seats());
                            table2.setSmoking(second.getSmoking());
                             table2.setTusn(nus);
                            TableList.add(table2);
                            tables.settables(TableList);
                            saved.setTables(tables);

                            marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));
                        } else {
                            JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                            Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                            saved = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));

                            saved.getTables().gettables().stream().forEach((TABLE) -> {
                                TableList.add(TABLE);
                            });
                            Marshaller marshaller = jaxbcontext.createMarshaller();
                            TABLES tables = new TABLES();
                            TABLE table2 = new TABLE();
                            table2.setNumber(second.getNumber());
                            table2.setNumber_of_seats(second.getNumber_of_seats());
                            table2.setSmoking(second.getSmoking());
                             table2.setTusn(nus);
                            TableList.add(table2);
                            tables.settables(TableList);
                            saved.setTables(tables);

                            marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));
                        }
                    } catch (JAXBException ex) {
                        Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        t3 = new Button("select");
        t3.setPrefSize(100, 50);
        g1.getChildren().add(t3);
        t3.setLayoutX(290);
        t3.setLayoutY(360);
        t3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        t3.setAlignment(Pos.CENTER);
        t3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                third.setReserved(true);
                if (third.isReserved()) {

                    try {
                         ArrayList<TABLE> TableList = new ArrayList<>();
                        Restaurant saved = new Restaurant();
                        File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml");
                        System.out.println(file.length());
                        if (file.length() == 0) { Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table3 = new TABLE();
                        table3.setNumber(third.getNumber());
                        table3.setNumber_of_seats(third.getNumber_of_seats());
                        table3.setSmoking(third.getSmoking());
                         table3.setTusn(nus);
                        TableList.add(table3);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));}
                        
                        else{
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                         saved = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));


                        saved.getTables().gettables().stream().forEach((TABLE) -> {
                            TableList.add(TABLE);
                        });
                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table3 = new TABLE();
                        table3.setNumber(third.getNumber());
                        table3.setNumber_of_seats(third.getNumber_of_seats());
                        table3.setSmoking(third.getSmoking());
                         table3.setTusn(nus);
                        TableList.add(table3);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));}

                    } catch (JAXBException ex) {
                        Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t4 = new Button("select");
        t4.setPrefSize(100, 50);
        g1.getChildren().add(t4);
        t4.setLayoutX(290);
        t4.setLayoutY(460);
        t4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        t4.setAlignment(Pos.CENTER);
        t4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                forth.setReserved(true);
                if (forth.isReserved()) {

                    try {
                          ArrayList<TABLE> TableList = new ArrayList<>();
                        Restaurant saved = new Restaurant();
                        File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml");
                        System.out.println(file.length());
                        if (file.length() == 0) { Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table4 = new TABLE();
                        table4.setNumber(forth.getNumber());
                        table4.setNumber_of_seats(forth.getNumber_of_seats());
                        table4.setSmoking(forth.getSmoking());
                         table4.setTusn(nus);
                        TableList.add(table4);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));}
                        
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                        saved = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));
                        saved.getTables().gettables().stream().forEach((TABLE) -> {
                            TableList.add(TABLE);
                        });
                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table4 = new TABLE();
                        table4.setNumber(forth.getNumber());
                        table4.setNumber_of_seats(forth.getNumber_of_seats());
                        table4.setSmoking(forth.getSmoking());
                         table4.setTusn(nus);
                        TableList.add(table4);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));

                    } catch (JAXBException ex) {
                        Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t5 = new Button("select");
        t5.setPrefSize(100, 50);
        g1.getChildren().add(t5);
        t5.setLayoutX(290);
        t5.setLayoutY(560);
        t5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        t5.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                fifth.setReserved(true);
                if (fifth.isReserved()) {

                    try {
                        ArrayList<TABLE> TableList = new ArrayList<>();
                        Restaurant saved = new Restaurant();
                        File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml");
                        System.out.println(file.length());
                        if (file.length() == 0) { Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table5 = new TABLE();
                        table5.setNumber(fifth.getNumber());
                        table5.setNumber_of_seats(fifth.getNumber_of_seats());
                        table5.setSmoking(fifth.getSmoking());
                         table5.setTusn(nus);
                        TableList.add(table5);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));}
                        else{
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                         saved = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));
                        saved.getTables().gettables().stream().forEach((TABLE) -> {
                            TableList.add(TABLE);
                        });
                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table5 = new TABLE();
                        table5.setNumber(fifth.getNumber());
                        table5.setNumber_of_seats(fifth.getNumber_of_seats());
                        table5.setSmoking(fifth.getSmoking());
                         table5.setTusn(nus);
                        TableList.add(table5);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));}

                    } catch (JAXBException ex) {
                        Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t6 = new Button("select");
        t6.setAlignment(Pos.CENTER);
        t6.setPrefSize(100, 50);
        g1.getChildren().add(t6);
        t6.setLayoutX(290);
        t6.setLayoutY(660);
        t6.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        t6.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                sixth.setReserved(true);
                if (sixth.isReserved()) {

                    try {
                        ArrayList<TABLE> TableList = new ArrayList<>();
                        Restaurant saved = new Restaurant();
                        File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml");
                        System.out.println(file.length());
                        if (file.length() == 0) { Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table6 = new TABLE();
                        table6.setNumber(sixth.getNumber());
                        table6.setNumber_of_seats(sixth.getNumber_of_seats());
                        table6.setSmoking(sixth.getSmoking());
                         table6.setTusn(nus);
                        TableList.add(table6);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));}
                        else{
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                         saved = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));
                        saved.getTables().gettables().stream().forEach((TABLE) -> {
                            TableList.add(TABLE);
                        });
                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table6 = new TABLE();
                        table6.setNumber(sixth.getNumber());
                        table6.setNumber_of_seats(sixth.getNumber_of_seats());
                        table6.setSmoking(sixth.getSmoking());
                         table6.setTusn(nus);
                        TableList.add(table6);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));}
                    } catch (JAXBException ex) {
                        Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        t7 = new Button("select");
        t7.setLayoutX(290);
        t7.setLayoutY(760);
        t7.setAlignment(Pos.CENTER);
        t7.setPrefSize(100, 50);
        g1.getChildren().add(t7);
        t7.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        t7.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                seventh.setReserved(true);
                if (seventh.isReserved()) {

                    try {
                        ArrayList<TABLE> TableList = new ArrayList<>();
                        Restaurant saved = new Restaurant();
                        File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml");
                        System.out.println(file.length());
                        if (file.length() == 0) { Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table7 = new TABLE();
                        table7.setNumber(seventh.getNumber());
                        table7.setNumber_of_seats(seventh.getNumber_of_seats());
                        table7.setSmoking(seventh.getSmoking());
                         table7.setTusn(nus);
                        TableList.add(table7);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));}
                        else{
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                         saved = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));

                        saved.getTables().gettables().stream().forEach((TABLE) -> {
                            TableList.add(TABLE);
                        });
                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        TABLES tables = new TABLES();
                        TABLE table7 = new TABLE();
                        table7.setNumber(seventh.getNumber());
                        table7.setNumber_of_seats(seventh.getNumber_of_seats());
                        table7.setSmoking(seventh.getSmoking());
                         table7.setTusn(nus);
                        TableList.add(table7);
                        tables.settables(TableList);
                        saved.setTables(tables);
                        marshaller.marshal(saved, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\Reservation.xml"));}

                    } catch (JAXBException ex) {
                        Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        reastaurant.getTables().gettables().stream().forEach((table) -> {
            if (table.getNumber() == 1) {
                first.setNumber(table.getNumber());
                first.setNumber_of_seats(table.getNumber_of_seats());
                first.setSmoking(table.getSmoking());
            } else if (table.getNumber() == 2) {
                second.setNumber(table.getNumber());
                second.setNumber_of_seats(table.getNumber_of_seats());
                second.setSmoking(table.getSmoking());
            } else if (table.getNumber() == 3) {
                third.setNumber(table.getNumber());
                third.setNumber_of_seats(table.getNumber_of_seats());
                third.setSmoking(table.getSmoking());
            } else if (table.getNumber() == 4) {
                forth.setNumber(table.getNumber());
                forth.setNumber_of_seats(table.getNumber_of_seats());
                forth.setSmoking(table.getSmoking());
            } else if (table.getNumber() == 5) {
                fifth.setNumber(table.getNumber());
                fifth.setNumber_of_seats(table.getNumber_of_seats());
                fifth.setSmoking(table.getSmoking());
            } else if (table.getNumber() == 6) {
                sixth.setNumber(table.getNumber());
                sixth.setNumber_of_seats(table.getNumber_of_seats());
                sixth.setSmoking(table.getSmoking());
            } else if (table.getNumber() == 7) {
                seventh.setNumber(table.getNumber());
                seventh.setNumber_of_seats(table.getNumber_of_seats());
                seventh.setSmoking(table.getSmoking());
            }

        });
   

        Label l1 = new Label("Table Number: " + first.getNumber());
        Label l2 = new Label("Seats: " + first.getNumber_of_seats());
        Label l3 = new Label("Smoking: " + first.getSmoking());

        l1.setLayoutX(80);
        l1.setLayoutY(150);
        g1.getChildren().add(l1);
        l1.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l2.setLayoutX(80);
        l2.setLayoutY(170);
        g1.getChildren().add(l2);
        l2.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l3.setLayoutX(80);
        l3.setLayoutY(190);
        g1.getChildren().add(l3);
        l3.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        Label l4 = new Label("\nTable Number: " + second.getNumber());
        Label l5 = new Label("\nSeats: " + second.getNumber_of_seats());
        Label l6 = new Label("\nSmoking: " + second.getSmoking());

        l4.setLayoutX(80);
        l4.setLayoutY(230);
        g1.getChildren().add(l4);
        l4.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l5.setLayoutX(80);
        l5.setLayoutY(250);
        g1.getChildren().add(l5);
        l5.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l6.setLayoutX(80);
        l6.setLayoutY(270);
        g1.getChildren().add(l6);
        l6.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        Label l7 = new Label("\nTable Number: " + third.getNumber());
        Label l8 = new Label("\nSeats: " + third.getNumber_of_seats());
        Label l9 = new Label("\nSmoking: " + third.getSmoking());

        l7.setLayoutX(80);
        l7.setLayoutY(330);
        g1.getChildren().add(l7);
        l7.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l8.setLayoutX(80);
        l8.setLayoutY(350);
        g1.getChildren().add(l8);
        l8.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l9.setLayoutX(80);
        l9.setLayoutY(370);
        g1.getChildren().add(l9);
        l9.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        Label l10 = new Label("\nTable Number: " + forth.getNumber());
        Label l11 = new Label("\nSeats: " + forth.getNumber_of_seats());
        Label l12 = new Label("\nSmoking: " + forth.getSmoking());

        l10.setLayoutX(80);
        l10.setLayoutY(430);
        g1.getChildren().add(l10);
        l10.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l11.setLayoutX(80);
        l11.setLayoutY(450);
        g1.getChildren().add(l11);
        l11.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l12.setLayoutX(80);
        l12.setLayoutY(470);
        g1.getChildren().add(l12);
        l12.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        Label l13 = new Label("\nTable Number: " + fifth.getNumber());
        Label l14 = new Label("\nSeats: " + fifth.getNumber_of_seats());
        Label l15 = new Label("\nSmoking: " + fifth.getSmoking());

        l13.setLayoutX(80);
        l13.setLayoutY(530);
        g1.getChildren().add(l13);
        l13.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l14.setLayoutX(80);
        l14.setLayoutY(550);
        g1.getChildren().add(l14);
        l14.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l15.setLayoutX(80);
        l15.setLayoutY(570);
        g1.getChildren().add(l15);
        l15.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        Label l16 = new Label("\nTable Number: " + sixth.getNumber());
        Label l17 = new Label("\nSeats: " + sixth.getNumber_of_seats());
        Label l18 = new Label("\nSmoking: " + sixth.getSmoking());

        l16.setLayoutX(80);
        l16.setLayoutY(630);
        g1.getChildren().add(l16);
        l16.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l17.setLayoutX(80);
        l17.setLayoutY(650);
        g1.getChildren().add(l17);
        l17.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l18.setLayoutX(80);
        l18.setLayoutY(670);
        g1.getChildren().add(l18);
        l18.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        Label l19 = new Label("\nTable Number: " + seventh.getNumber());
        Label l20 = new Label("\nSeats: " + seventh.getNumber_of_seats());
        Label l21 = new Label("\nSmoking: " + seventh.getSmoking());

        l19.setLayoutX(80);
        l19.setLayoutY(730);
        g1.getChildren().add(l19);
        l19.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l20.setLayoutX(80);
        l20.setLayoutY(750);
        g1.getChildren().add(l20);
        l20.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        l21.setLayoutX(80);
        l21.setLayoutY(770);
        g1.getChildren().add(l21);
        l21.setFont(Font.font("Tahoma", FontWeight.LIGHT, 20));

        reastaurant.getDishes().getdishes().stream().forEach(new Consumer<DISH>() {

            public void accept(DISH dish) {
                if (dish.getName().replaceAll("\\s+", "").equalsIgnoreCase("GRILLEDCHICKEN")) {
                    awel.setName(dish.getName());
                    awel.setPrice(dish.getPrice());
                    awel.setType(dish.getType());

                } else if (dish.getName().replaceAll("\\s+", "").equalsIgnoreCase("MUSHROOMSOUP")) {

                    tany.setName(dish.getName());
                    tany.setPrice(dish.getPrice());
                    tany.setType(dish.getType());

                } else if (dish.getName().replaceAll("\\s+", "").equalsIgnoreCase("BEEFSTEAK")) {
                    talet.setName(dish.getName());
                    talet.setPrice(dish.getPrice());
                    talet.setType(dish.getType());

                } else if (dish.getName().replaceAll("\\s+", "").equalsIgnoreCase("FRIEDPOTATOS")) {
                    rabe.setName(dish.getName());
                    rabe.setPrice(dish.getPrice());
                    rabe.setType(dish.getType());

                } else if (dish.getName().replaceAll("\\s+", "").equalsIgnoreCase("GREEKSALADE")) {
                    khams.setName(dish.getName());
                    khams.setPrice(dish.getPrice());
                    khams.setType(dish.getType());

                } else if (dish.getName().replaceAll("\\s+", "").equalsIgnoreCase("APPLEPIE")) {
                    sads.setName(dish.getName());
                    sads.setPrice(dish.getPrice());
                    sads.setType(dish.getType());

                } else if (dish.getName().replaceAll("\\s+", "").equalsIgnoreCase("MOLTENCAKE")) {
                    sabe.setName(dish.getName());
                    sabe.setPrice(dish.getPrice());
                    sabe.setType(dish.getType());

                }
            }
        });

        Label title = new Label("WELCOME");
        g1.getChildren().add(title);
        title.setPrefWidth(400);
        title.setAlignment(Pos.CENTER);
        title.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 30));
        title.setLayoutX(490);
        title.setLayoutY(30);

        Label title2 = new Label("DISHES");
        g1.getChildren().add(title2);
        title2.setPrefWidth(300);
        title2.setAlignment(Pos.TOP_RIGHT);
        title2.setFont(Font.font("Tahoma", FontWeight.BOLD, 24));
        title2.setLayoutX(805);
        title2.setLayoutY(90);

        Label title3 = new Label("*MAIN COURSE*");
        g1.getChildren().add(title3);
        title3.setPrefWidth(350);
        title3.setAlignment(Pos.TOP_RIGHT);
        title3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title3.setLayoutX(719);
        title3.setLayoutY(140);

        Label title4 = new Label("NAME");
        g1.getChildren().add(title4);
        title4.setPrefWidth(300);
        title4.setAlignment(Pos.TOP_RIGHT);
        title4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title4.setLayoutX(450);
        title4.setLayoutY(180);

        Label title5 = new Label("PRICE");
        g1.getChildren().add(title5);
        title5.setPrefWidth(300);
        title5.setAlignment(Pos.TOP_RIGHT);
        title5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title5.setLayoutX(700);
        title5.setLayoutY(180);

        Label title6 = new Label("QUANTITY");
        g1.getChildren().add(title6);
        title6.setPrefWidth(300);
        title6.setAlignment(Pos.TOP_RIGHT);
        title6.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title6.setLayoutX(870);
        title6.setLayoutY(180);

        Label title7 = new Label("Grilled Chicken");
        g1.getChildren().add(title7);
        title7.setPrefWidth(300);
        title7.setAlignment(Pos.TOP_RIGHT);
        title7.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title7.setLayoutX(490);
        title7.setLayoutY(230);

        Label title8 = new Label();
        title8.setText(String.valueOf(awel.getPrice()));
        g1.getChildren().add(title8);
        title8.setPrefWidth(300);
        title8.setAlignment(Pos.TOP_RIGHT);
        title8.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title8.setLayoutX(680);
        title8.setLayoutY(230);

        TextField title9 = new TextField();
        g1.getChildren().add(title9);
        title9.setPrefSize(70, 30);
        title9.setAlignment(Pos.CENTER);
        title9.setLayoutX(1090);
        title9.setLayoutY(230);

        Button a1 = new Button("ADD");
        a1.setPrefSize(150, 20);
        g1.getChildren().add(a1);
        a1.setLayoutX(1200);
        a1.setLayoutY(230);
        a1.setAlignment(Pos.CENTER);
        a1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int s = Integer.parseInt(title9.getText());
                double test = floos.cashmoney(s, 0.15, awel.getPrice());
                floos.setCash(test);
             
                try {

                    ArrayList<DISH> userList = new ArrayList<>();
                    Restaurant savedRestaurant = new Restaurant();
                    File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml");
                  
                    if (file.length() == 0) {
                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(awel.getName());
                        sevdi.setPrice(awel.getPrice());
                        sevdi.setQuantity(s);
                        sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    } else {
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);

                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                        savedRestaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                        savedRestaurant.getDishes().getdishes().stream().forEach((DISH) -> {

                            userList.add(DISH);

                        });

                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(awel.getName());
                        sevdi.setPrice(awel.getPrice());
                        sevdi.setQuantity(s);
                        sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    }

                } catch (JAXBException ex) {
                    Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        Label titl1 = new Label("Mushroom Soup");
        g1.getChildren().add(titl1);
        titl1.setPrefWidth(300);
        titl1.setAlignment(Pos.TOP_RIGHT);
        titl1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        titl1.setLayoutX(490);
        titl1.setLayoutY(280);

        Label titl2 = new Label();
        titl2.setText(String.valueOf(tany.getPrice()));
        g1.getChildren().add(titl2);
        titl2.setPrefWidth(300);
        titl2.setAlignment(Pos.TOP_RIGHT);
        titl2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        titl2.setLayoutX(680);
        titl2.setLayoutY(280);

        TextField titl3 = new TextField();
        g1.getChildren().add(titl3);
        titl3.setPrefSize(70, 30);
        titl3.setAlignment(Pos.CENTER);
        titl3.setLayoutX(1090);
        titl3.setLayoutY(280);

        Button a2 = new Button("ADD");
        a2.setPrefSize(150, 20);
        g1.getChildren().add(a2);
        a2.setLayoutX(1200);
        a2.setLayoutY(280);
        a2.setAlignment(Pos.CENTER);
        a2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int s = Integer.parseInt(titl3.getText());
                double test = floos.cashmoney(s, 0.15, tany.getPrice());
                floos.setCash(test);
              
                try {
                    ArrayList<DISH> userList = new ArrayList<>();
                    Restaurant savedRestaurant = new Restaurant();
                    File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml");
                 
                    if (file.length() == 0) {

                        Marshaller marshaller = jaxbcontext.createMarshaller();

                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(tany.getName());
                        sevdi.setPrice(tany.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));

                    } else {
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                        savedRestaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));

                        savedRestaurant.getDishes().getdishes().stream().forEach((DISH) -> {
                            userList.add(DISH);

                        });

                    
                        Marshaller marshaller = jaxbcontext.createMarshaller();

                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(tany.getName());
                        sevdi.setPrice(tany.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    }

                } catch (JAXBException ex) {
                    Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Label titl4 = new Label("Beef Steak");
        g1.getChildren().add(titl4);
        titl4.setPrefWidth(300);
        titl4.setAlignment(Pos.TOP_RIGHT);
        titl4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        titl4.setLayoutX(490);
        titl4.setLayoutY(330);

        Label titl5 = new Label();
        titl5.setText(String.valueOf(talet.getPrice()));
        g1.getChildren().add(titl5);
        titl5.setPrefWidth(300);
        titl5.setAlignment(Pos.TOP_RIGHT);
        titl5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        titl5.setLayoutX(680);
        titl5.setLayoutY(330);

        TextField titl6 = new TextField();
        g1.getChildren().add(titl6);
        titl6.setPrefSize(70, 30);
        titl6.setAlignment(Pos.CENTER);
        titl6.setLayoutX(1090);
        titl6.setLayoutY(330);

        Button a3 = new Button("ADD");
        a3.setPrefSize(150, 20);
        g1.getChildren().add(a3);
        a3.setLayoutX(1200);
        a3.setLayoutY(330);
        a3.setAlignment(Pos.CENTER);
        a3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int s = Integer.parseInt(titl6.getText());
                double test = floos.cashmoney(s, 0.15, talet.getPrice());
                floos.setCash(test);
            
                try {
                    ArrayList<DISH> userList = new ArrayList<>();
                    Restaurant savedRestaurant = new Restaurant();
                    File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml");
             
                    if (file.length() == 0) {
                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(talet.getName());
                        sevdi.setPrice(talet.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    } else {

                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                        savedRestaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                        savedRestaurant.getDishes().getdishes().stream().forEach((DISH) -> {

                            userList.add(DISH);

                        });

                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(talet.getName());
                        sevdi.setPrice(talet.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    }

                } catch (JAXBException ex) {
                    Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Label tit = new Label("*APPETIZER*");
        g1.getChildren().add(tit);
        tit.setPrefWidth(350);
        tit.setAlignment(Pos.TOP_RIGHT);
        tit.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tit.setLayoutX(719);
        tit.setLayoutY(370);

        Label tit1 = new Label("NAME");
        g1.getChildren().add(tit1);
        tit1.setPrefWidth(300);
        tit1.setAlignment(Pos.TOP_RIGHT);
        tit1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tit1.setLayoutX(450);
        tit1.setLayoutY(410);

        Label tit2 = new Label("PRICE");
        g1.getChildren().add(tit2);
        tit2.setPrefWidth(300);
        tit2.setAlignment(Pos.TOP_RIGHT);
        tit2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tit2.setLayoutX(700);
        tit2.setLayoutY(410);

        Label tit3 = new Label("QUANTITY");
        g1.getChildren().add(tit3);
        tit3.setPrefWidth(300);
        tit3.setAlignment(Pos.TOP_RIGHT);
        tit3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tit3.setLayoutX(870);
        tit3.setLayoutY(410);

        Label tit4 = new Label("Greek salade");
        g1.getChildren().add(tit4);
        tit4.setPrefWidth(300);
        tit4.setAlignment(Pos.TOP_RIGHT);
        tit4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tit4.setLayoutX(490);
        tit4.setLayoutY(460);

        Label tit5 = new Label();
        tit5.setText(String.valueOf(khams.getPrice()));
        g1.getChildren().add(tit5);
        tit5.setPrefWidth(300);
        tit5.setAlignment(Pos.TOP_RIGHT);
        tit5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tit5.setLayoutX(680);
        tit5.setLayoutY(460);

        TextField tit6 = new TextField();
        g1.getChildren().add(tit6);
        tit6.setPrefSize(70, 30);
        tit6.setAlignment(Pos.CENTER);
        tit6.setLayoutX(1090);
        tit6.setLayoutY(460);

        Button a4 = new Button("ADD");
        a4.setPrefSize(150, 20);
        g1.getChildren().add(a4);
        a4.setLayoutX(1200);
        a4.setLayoutY(460);
        a4.setAlignment(Pos.CENTER);
        a4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int s = Integer.parseInt(tit6.getText());
                double test = floos.cashmoney(s, 0.10, khams.getPrice());
                floos.setCash(test);
              
                try {
                    ArrayList<DISH> userList = new ArrayList<>();
                    Restaurant savedRestaurant = new Restaurant();
                    File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml");
                
                    if (file.length() == 0) {
                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(khams.getName());
                        sevdi.setPrice(khams.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));

                    } else {
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                        savedRestaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                        savedRestaurant.getDishes().getdishes().stream().forEach((DISH) -> {

                            userList.add(DISH);

                        });

                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(khams.getName());
                        sevdi.setPrice(khams.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    }

                } catch (JAXBException ex) {
                    Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Label tit7 = new Label("Fried Potatos");
        g1.getChildren().add(tit7);
        tit7.setPrefWidth(300);
        tit7.setAlignment(Pos.TOP_RIGHT);
        tit7.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tit7.setLayoutX(490);
        tit7.setLayoutY(510);

        Label tit8 = new Label();
        tit8.setText(String.valueOf(rabe.getPrice()));
        g1.getChildren().add(tit8);
        tit8.setPrefWidth(300);
        tit8.setAlignment(Pos.TOP_RIGHT);
        tit8.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tit8.setLayoutX(680);
        tit8.setLayoutY(510);

        TextField tit9 = new TextField();
        g1.getChildren().add(tit9);
        tit9.setPrefSize(70, 30);
        tit9.setAlignment(Pos.CENTER);
        tit9.setLayoutX(1090);
        tit9.setLayoutY(510);

        Button a5 = new Button("ADD");
        a5.setPrefSize(150, 20);
        g1.getChildren().add(a5);
        a5.setLayoutX(1200);
        a5.setLayoutY(510);
        a5.setAlignment(Pos.CENTER);
        a5.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int s = Integer.parseInt(tit9.getText());
                double test = floos.cashmoney(s, 0.10, rabe.getPrice());
                floos.setCash(test);
              
                try {
                    ArrayList<DISH> userList = new ArrayList<>();
                    Restaurant savedRestaurant = new Restaurant();
                    File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml");
                  
                    if (file.length() == 0) {

                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(rabe.getName());
                        sevdi.setPrice(rabe.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    } else {
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                        savedRestaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                        savedRestaurant.getDishes().getdishes().stream().forEach((DISH) -> {

                            userList.add(DISH);

                        });

                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(rabe.getName());
                        sevdi.setPrice(rabe.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    }

                } catch (JAXBException ex) {
                    Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Label tt = new Label("*DESSERTS*");
        g1.getChildren().add(tt);
        tt.setPrefWidth(350);
        tt.setAlignment(Pos.TOP_RIGHT);
        tt.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tt.setLayoutX(719);
        tt.setLayoutY(550);

        Label tt1 = new Label("NAME");
        g1.getChildren().add(tt1);
        tt1.setPrefWidth(300);
        tt1.setAlignment(Pos.TOP_RIGHT);
        tt1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tt1.setLayoutX(450);
        tt1.setLayoutY(590);

        Label tt2 = new Label("PRICE");
        g1.getChildren().add(tt2);
        tt2.setPrefWidth(300);
        tt2.setAlignment(Pos.TOP_RIGHT);
        tt2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tt2.setLayoutX(700);
        tt2.setLayoutY(590);

        Label tt3 = new Label("QUANTITY");
        g1.getChildren().add(tt3);
        tt3.setPrefWidth(300);
        tt3.setAlignment(Pos.TOP_RIGHT);
        tt3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tt3.setLayoutX(870);
        tt3.setLayoutY(590);

        Label tt4 = new Label("Apple Pie");
        g1.getChildren().add(tt4);
        tt4.setPrefWidth(300);
        tt4.setAlignment(Pos.TOP_RIGHT);
        tt4.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tt4.setLayoutX(480);
        tt4.setLayoutY(630);

        Label tt5 = new Label();
        tt5.setText(String.valueOf(sads.getPrice()));
        g1.getChildren().add(tt5);
        tt5.setPrefWidth(300);
        tt5.setAlignment(Pos.TOP_RIGHT);
        tt5.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tt5.setLayoutX(680);
        tt5.setLayoutY(630);

        TextField tt6 = new TextField();
        g1.getChildren().add(tt6);
        tt6.setPrefSize(70, 30);
        tt6.setAlignment(Pos.CENTER);
        tt6.setLayoutX(1090);
        tt6.setLayoutY(630);

        Button a6 = new Button("ADD");
        a6.setPrefSize(150, 20);
        g1.getChildren().add(a6);
        a6.setLayoutX(1200);
        a6.setLayoutY(630);
        a6.setAlignment(Pos.CENTER);
        a6.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int s = Integer.parseInt(tt6.getText());
                double test = floos.cashmoney(s, 0.2, sads.getPrice());
                floos.setCash(test);
            
                try {
                    ArrayList<DISH> userList = new ArrayList<>();
                    Restaurant savedRestaurant = new Restaurant();
                    File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml");
                  
                    if (file.length() == 0) {
                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(sads.getName());
                        sevdi.setPrice(sads.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    } else {
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                        savedRestaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                        savedRestaurant.getDishes().getdishes().stream().forEach((DISH) -> {

                            userList.add(DISH);

                        });

                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(sads.getName());
                        sevdi.setPrice(sads.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    }

                } catch (JAXBException ex) {
                    Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        Label tt7 = new Label("Molten Cake");
        g1.getChildren().add(tt7);
        tt7.setPrefWidth(300);
        tt7.setAlignment(Pos.TOP_RIGHT);
        tt7.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tt7.setLayoutX(490);
        tt7.setLayoutY(680);

        Label tt8 = new Label();
        tt8.setText(String.valueOf(sabe.getPrice()));
        g1.getChildren().add(tt8);
        tt8.setPrefWidth(300);
        tt8.setAlignment(Pos.TOP_RIGHT);
        tt8.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        tt8.setLayoutX(680);
        tt8.setLayoutY(680);

        TextField tt9 = new TextField();
        g1.getChildren().add(tt9);
        tt9.setPrefSize(70, 30);
        tt9.setAlignment(Pos.CENTER);
        tt9.setLayoutX(1090);
        tt9.setLayoutY(680);

        Button a7 = new Button("ADD");
        a7.setPrefSize(150, 20);
        g1.getChildren().add(a7);
        a7.setLayoutX(1200);
        a7.setLayoutY(680);
        a7.setAlignment(Pos.CENTER);
        a7.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int s = Integer.parseInt(tt9.getText());
                double test = floos.cashmoney(s, 0.2, sabe.getPrice());
                floos.setCash(test);
               
                try {
                    ArrayList<DISH> userList = new ArrayList<>();
                    Restaurant savedRestaurant = new Restaurant();
                    File file = new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml");
                   
                    if (file.length() == 0) {

                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(sabe.getName());
                        sevdi.setPrice(sabe.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));

                    } else {
                        JAXBContext jaxbcontext = JAXBContext.newInstance(Restaurant.class);
                        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
                        savedRestaurant = (Restaurant) unmarshaller.unmarshal(new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                        savedRestaurant.getDishes().getdishes().stream().forEach((DISH) -> {

                            userList.add(DISH);

                        });

                        Marshaller marshaller = jaxbcontext.createMarshaller();
                        DISHES savedi = new DISHES();
                        DISH sevdi = new DISH();
                        sevdi.setName(sabe.getName());
                        sevdi.setPrice(sabe.getPrice());
                        sevdi.setQuantity(s);
                          sevdi.setUsname(nus);
                        userList.add(sevdi);
                        savedi.setdishes(userList);
                        savedRestaurant.setDishes(savedi);
                        marshaller.marshal(savedRestaurant, new File("C:\\Users\\Mohamed\\Documents\\NetBeansProjects\\restaurant\\src\\restaurant\\save.xml"));
                    }

                } catch (JAXBException ex) {
                    Logger.getLogger(CLIENT.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        TextField mon = new TextField("CASH");
        mon.setPrefSize(200, 100);
        g1.getChildren().add(mon);
        mon.setLayoutX(900);
        mon.setLayoutY(780);
        mon.setFont(Font.font("Tahoma", FontWeight.THIN, 20));
        mon.setAlignment(Pos.CENTER);
        mon.setPromptText("CASH MONEY");

        Button save = new Button("RESERVE");
        save.setPrefSize(200, 100);
        g1.getChildren().add(save);
        save.setLayoutX(1150);
        save.setLayoutY(780);
        save.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        save.setAlignment(Pos.CENTER);
        save.setOnAction(new EventHandler<ActionEvent>() {
MANAGER monn=new MANAGER();
            @Override
            public void handle(ActionEvent event) {
                  JOptionPane.showMessageDialog(null, "RESERVATION DONE SUCCESSFULLY!\nyour cash is going to appear once you click OK");
                  
                mon.setText(String.valueOf(floos.getCash()));
              monn.setMncost(floos.getCash());

            }
        });

        

        
        
        
        
        
        
        Button log = new Button("LOG OUT");
        log.setPrefSize(200, 100);
        g1.getChildren().add(log);
        log.setLayoutX(600);
        log.setLayoutY(780);
        log.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        log.setAlignment(Pos.CENTER);
        log.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                JOptionPane.showMessageDialog(null, "ARE you sure??");

                window.close();

            }
        });
      

        scene2 = new Scene(g1, 1500, 1000);
      
        window.setScene(scene2);
        window.setTitle("CLIENT DASHBOARD");
        window.showAndWait();
    }

}
