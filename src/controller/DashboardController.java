package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController {
    private Parent root;
    private Scene scene;
    private Stage stage;

    public void openCricketView(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("../view/CricketView.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
        }
    }

    public void openDiceView(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("../view/DiceView.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
        }
    }

    public void openRpsView(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("../view/RPSView.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
        }
    }

    public void openHangmanView(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("../view/HangmanView.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
        }

    }public void openGTGView(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("../view/GTGView.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
        }

    }

}
