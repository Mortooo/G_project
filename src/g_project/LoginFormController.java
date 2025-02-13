/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package g_project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author afrotech
 */
public class LoginFormController implements Initializable {

    private Connection con;
    private ResultSet resultSet;
    private PreparedStatement pre;
    @FXML
    private TextField txtf_user_name;
    @FXML
    private PasswordField txtf_password;
    @FXML
    private Button btn_logIn;
    @FXML
    private Button ex;
    @FXML
    private Text txt_result;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void press(ActionEvent event) throws SQLException, IOException {
        if (getUser().getUserName().isEmpty() || getUser().getPassword().isEmpty()) {

            txt_result.setText("الرجاء ادخال اسم المستخدم وكلمة المرور");

        } else {

            if (getUser().isExist()) {

                btn_logIn.getScene().getWindow().hide();
                
                Stage stage=new Stage();
                Parent parent = FXMLLoader.load(getClass().getResource("MainForm.fxml"));
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();

            } else {
                Alert alertError = new Alert(AlertType.ERROR);
                alertError.setTitle("خطأ");
                alertError.setHeaderText("خطأ");
                alertError.setContentText("خطأ في اسم المستخدم أو كلمة المرور");
                alertError.showAndWait();
//                txt_result.setText("اسم المستخدم او كلمة المرور غير صحيحة");

            }
        }
    }

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }

    private Users getUser() {

        Users user = new Users();

        user.setUserName(txtf_user_name.getText());
        user.setPassword(txtf_password.getText());

        return user;
    }
}
