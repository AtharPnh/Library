package run;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import manager.BooksManager;

import java.io.IOException;

public class  DeleteBook{

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnBack;

    @FXML
    private TextField txtUserName;

    @FXML
    void pressBtnDelete(ActionEvent event) {

        String bookName=txtUserName.getText();

        BooksManager manager=new BooksManager();

        manager.deleteBook(bookName);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("حذف کتاب");
        alert.setContentText("کتاب مورد نظر با موفقیت حذف شد");
        alert.showAndWait();
    }

    @FXML
    void pressBtnBack(ActionEvent event) throws IOException {

        Stage stage=(Stage) btnBack.getScene().getWindow();
        stage.close();

        Stage primaryStage=new Stage();
        AnchorPane root=(AnchorPane) FXMLLoader.load(getClass().getResource("ManagerPage.fxml"));

        Scene scene=new Scene(root, 611, 290);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
