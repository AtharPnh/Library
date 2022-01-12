package run;

import commons.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import manager.ManagersManager;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerLogin {

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnEnter;

    @FXML
    private Label lblAccount;

    @FXML
    private Label lblForget;

    @FXML
    private Label lblMember;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUserName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    @FXML
    void pressSignUp(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnSignUp.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("Registration.fxml"));

        Scene scene=new Scene(root, 447, 412);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressEnter(ActionEvent event) throws IOException {
        if(checkUserName()==true){
            Stage stage=(Stage) btnEnter.getScene().getWindow();
            stage.close();

            Stage primaryStage=new Stage();
            AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("ManagerPage.fxml"));

            Scene scene=new Scene(root, 611, 290);

            primaryStage.setScene(scene);
            primaryStage.show();
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("هشدار !!!");
            alert.setContentText("نام کاربری یا رمز عبور اشتباه است.");
            alert.showAndWait();
        }
    }

    /*
    check if the entered userName and password in login page are match
     */
    public boolean checkUserName(){

        boolean flag=false;

        ManagersManager manager=new ManagersManager();
        ArrayList<Manager> managers=manager.listOfManager();

        String userName=txtUserName.getText();
        String password=txtPassword.getText();

       for(Manager m : managers){
           if(m.getFirstName().equals(userName) && m.getPassword().equals(password)){
               flag=true;
           }
       }

        return flag;
    }

}
