/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package g_project;

/**
 *
 * @author afrotech
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

public class MainClass extends  Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);  
    }

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
        Parent parent = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));

        stage.setScene(new Scene(parent));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    
}
