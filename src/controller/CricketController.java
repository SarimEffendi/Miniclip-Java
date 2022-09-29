package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CricketModel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CricketController{
    private int selection;
    private Parent root;
    private Scene scene;
    private Stage stage;
    private boolean play;

    public void playCricket(ActionEvent e)throws Exception {
        try {
            Scanner input = new Scanner(System.in);
            CricketModel cricketModel = new CricketModel();
            play = true;
            while (play) {
                System.out.println(catalog());
                selection = input.nextInt();
                switch (selection) {
                    case 1:
                        cricketModel.addPlayers();
                        break;
                    case 2:
                        cricketModel.twoPlayerAuto();
                        break;
                    case 3:
                        System.out.println(cricketModel.showCricketers());
                        break;
                    case 4:
                        System.out.println("to continue go to the gui form...");
                        play = false;
                        break;

                }
            }
        } catch (InputMismatchException ex) {

            Scanner input = new Scanner(System.in);
            CricketModel cricketModel = new CricketModel();
            play = true;
            while (play) {
                System.out.println(catalog());
                selection = input.nextInt();
                switch (selection) {
                    case 1:
                        cricketModel.addPlayers();
                        break;
                    case 2:
                        cricketModel.twoPlayerAuto();
                        break;
                    case 3:
                        System.out.println(cricketModel.showCricketers());
                        break;
                    case 4:
                        play = false;
                        break;
                }

            }}
            }
            private String catalog() {
                return "1. Add Players\n" +
                        "2. Play Game\n" +
                        "3. Show Players\n" +
                        "4. End Game\n" +
                        "Please select an option: ";
            }
            public void openDashboardView (ActionEvent e){
                try {
                    root = FXMLLoader.load(getClass().getResource("../view/DashboardView.fxml"));
                    stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (Exception ex) {
                    System.out.println("Please End Game First");
                }
            }
        }

