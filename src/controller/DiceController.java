package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Dice;
import model.DicePlayer;

import java.util.Scanner;


public class DiceController {
    private int selection;
    private DicePlayer player;
    private boolean play = true;
    private Parent root;
    private Scene scene;
    private Stage stage;

    public void playDice(ActionEvent e) throws Exception {

        Scanner input = new Scanner(System.in);
        Dice dice = new Dice();
        while (play) {
            System.out.println("1.add player");
            System.out.println("2.play game");
            System.out.println("3.exit");
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    dice.Player();
                    break;
                case 2:
                    dice.diceGame();
                    break;
                case 3:
                    System.out.println("to continue go to the gui form...");
                    play = false;
                    break;


            }


        }
    }
    public void openDashboardView(ActionEvent e){
        try
        {
            root = FXMLLoader.load(getClass().getResource("../view/DashboardView.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show(); }
        catch (Exception ex) {
            System.out.println("Please End Game First");
        }
    }
}