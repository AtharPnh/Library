package run;

import commons.Member;
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
import manager.MembersManager;

import java.io.IOException;

public class Registration {

    @FXML
    private Button btnDone;

    @FXML
    private Button btnVerify;

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
        if(txtAge.getText().equals("") || txtID.getText().equals("")
           || txtRegistryDate.getText().equals("") || txtFirstName.getText().equals("") ||
                txtLastName.getText().equals("") || txtPassword.getText().equals("")){

            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setTitle("هشدار !!!");
            alert.setContentText("لطفا همه ی قسمت ها را پر کنید.");
            alert.showAndWait();

        }else{

            /* set the member's properties that user inputs in the
            registration form.

             */

            Member member=new Member();

            member.setRegisteryDate(txtRegistryDate.getText());
            member.setAge(txtAge.getText());
            member.setFirstName(txtFirstName.getText());
            member.setLastName(txtLastName.getText());
            member.setId(txtID.getText());
            member.setPassword(txtPassword.getText());

            /*
                insert the member into members file
             */
            MembersManager manager=new MembersManager();
            manager.insert(member);

            /*
            send a massage to user for add member to file
             */

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ثبت اطلاعات !!!");
            alert.setContentText("عضو مورد نظر ذخیره شد.");
            alert.showAndWait();

        }
    }

    @FXML
    void pressVerify(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnVerify.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("MemberLogin.fxml"));

        Scene scene=new Scene(root, 317, 431);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
