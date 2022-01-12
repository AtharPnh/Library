package run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import manager.BooksManager;
import manager.MembersManager;

import java.io.IOException;

public class EditMemberForm {

    @FXML
    private Button btnDone;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnVerify;

    @FXML
    private Label lblMessage;

    @FXML
    private Label lblMessage1;

    @FXML
    private Label lblregistration;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtRegistryDate;

    @FXML
    private TextField txtPassword;

    @FXML
    void pressDone(ActionEvent event) {

        MembersManager manager=new MembersManager();

        String name=txtFirstName.getText();
        String lastName=txtLastName.getText();
        String age=txtAge.getText();
        String id=txtID.getText();
        String regDate=txtRegistryDate.getText();
        String password=txtPassword.getText();


        manager.updateMember(id,name,lastName,age,regDate,password);

        if(txtFirstName.getText().equals("") || txtID.getText().equals("") ||
                txtLastName.getText().equals("") || txtAge.getText().equals("") ||
                txtRegistryDate.getText().equals("")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("هشدار !!!");
            alert.setContentText("لطفا همه ی قسمت ها را پر کنید.");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("تغییرات مورد نظر ثبت شد");
            alert.showAndWait();
        }
    }

    @FXML
    void pressVerify(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnVerify.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("ManagerPage.fxml"));

        Scene scene=new Scene(root, 611, 290);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void pressSearch(ActionEvent event) {

        String name=txtFirstName.getText();

        MembersManager manager=new MembersManager();

        boolean find=manager.searchMemberByName(name);

        if(find==true){
            lblMessage.setVisible(true);
            lblMessage1.setVisible(false);
        }else{
            lblMessage.setVisible(false);
            lblMessage1.setVisible(true);
        }

    }

}


