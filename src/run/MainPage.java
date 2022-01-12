package run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPage {

    @FXML
    private RadioButton rbtnManager;

    @FXML
    private RadioButton rbtnMember;

    @FXML
    private TextField txtWelcome;

    @FXML
    void pressRbtnManager(ActionEvent event) throws IOException {
        if(rbtnManager.isSelected()){
            Stage stage=(Stage) rbtnManager.getScene().getWindow();
            stage.close();

            Stage primaryStage=new Stage();
            AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("ManagerLogin.fxml"));

            Scene scene=new Scene(root, 317, 431);

            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    @FXML
    void pressRbtnMember(ActionEvent event) throws IOException {

        if(rbtnMember.isSelected()){
            Stage stage=(Stage) rbtnMember.getScene().getWindow();
            stage.close();

            Stage primaryStage=new Stage();
            AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("MemberLogin.fxml"));

            Scene scene=new Scene(root, 317, 431);

            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

}
