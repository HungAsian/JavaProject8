// Hung Le
// C00181055
// CMPS 360
// Programming Project : #8
// Problem Number: #3
// Due Date : 4/30/2018 4:30 PM
// Program Description: A program that displays the date and time with the locale and timezone the user enters
// Certificate of Authenticity: I certify that the code of this project are entirely my own work.
package p8_3_c00181055;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX Application that displays a clock and date and allows
 * the user to change the locale and time zone.
 * @author hql0510
 */
public class JavaFXApplication1 extends Application {
    
    /**
     * Starts the JavaFX application.
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Empty main.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
