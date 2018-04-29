// Hung Le
// C00181055
// CMPS 360
// Programming Project : #8
// Problem Number: #3
// Due Date : 4/30/2018 4:30 PM
// Program Description: A program that displays the date and time with the locale and timezone the user enters
// Certificate of Authenticity: I certify that the code of this project are entirely my own work.
package p8_3_c00181055;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.*;
import java.text.DateFormat;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.util.Duration;

/**
 * FXML Controller class for the date and time.
 *
 * @author hql0510
 */
public class FXMLController implements Initializable {

    @FXML
    private Label timeField;
    @FXML
    private Label dateField;
    @FXML
    private ComboBox<String> timeZoneBox;
    @FXML
    private ComboBox<String> timeStyleBox;
    @FXML
    private ComboBox<String> dateStyleBox;
    @FXML
    private ComboBox<String> localeBox;

    private Locale[] availableLocales = Locale.getAvailableLocales();
    private String[] availableTimeZones = TimeZone.getAvailableIDs();
    private int dateFormat = DateFormat.MEDIUM;
    private int timeFormat = DateFormat.MEDIUM;
    
    private TimeZone timeZone = TimeZone.getDefault();
    private Locale locale = Locale.getDefault();

    /**
     * Initializes the controller class.
     * Initializes the UI elements.
     * Starts a Timeline instance and runs it every 1000ms.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (int i = 0; i < availableLocales.length; i++) {
            localeBox.getItems().add(availableLocales[i]
                    .getDisplayName() + " " + availableLocales[i].toString());
        }
        localeBox.getSelectionModel().select(locale.getDisplayName());

        Arrays.sort(availableTimeZones);
        for (int i = 0; i < availableTimeZones.length; i++) {
            timeZoneBox.getItems().add(availableTimeZones[i]);
        }
        timeZoneBox.getSelectionModel().select(timeZone.getDisplayName());

        dateStyleBox.getItems().add("Full");
        dateStyleBox.getItems().add("LONG");
        dateStyleBox.getItems().add("MEDIUM");
        dateStyleBox.getItems().add("SHORT");
        dateStyleBox.getSelectionModel().select(dateFormat);

        timeStyleBox.getItems().add("Full");
        timeStyleBox.getItems().add("LONG");
        timeStyleBox.getItems().add("MEDIUM");
        timeStyleBox.getItems().add("SHORT");
        timeStyleBox.getSelectionModel().select(timeFormat);

        EventHandler<ActionEvent> eventHandler = e -> {
            setCurrentTime(); // Set a new clock time
        };
        
        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    //Grabs the time zone from the combo box whenever it changes and
    //changes the time zone.
    @FXML
    private void changeTimeZone(ActionEvent event) {
        timeZone = TimeZone.getTimeZone(timeZoneBox.getValue());
    }

    //Grabs the time style from the time format box and changes the format.
    @FXML
    private void changeTimeStyle(ActionEvent event) {
        switch(timeStyleBox.getValue())
        {
            case "Full":
                timeFormat = DateFormat.FULL;
                break;
            case "LONG":
                timeFormat = DateFormat.LONG;
                break;
            case "MEDIUM":
                timeFormat = DateFormat.MEDIUM;
                break;
            case "SHORT":
                timeFormat = DateFormat.SHORT;
                break;
        }
    }

    //Grabs the date style from the date style box and changes the format.
    @FXML
    private void changeDateStyle(ActionEvent event) {
        switch(dateStyleBox.getValue())
        {
            case "Full":
                dateFormat = DateFormat.FULL;
                break;
            case "LONG":
                dateFormat = DateFormat.LONG;
                break;
            case "MEDIUM":
                dateFormat = DateFormat.MEDIUM;
                break;
            case "SHORT":
                dateFormat = DateFormat.SHORT;
                break;
        }
    }

    //Grabs the locale from the locale box and changes them.
    //Since the locale has 2 values, the name and then the tag
    //It splits the string and grabs the first two characters from the
    //tag.
    @FXML
    private void changeLocale(ActionEvent event) {
        String str = localeBox.getValue();
        String[] splitStr = str.split(" ");
        locale = Locale.forLanguageTag(splitStr[splitStr.length - 1].substring(0, 2));
    }

    //Function that gets called every second.
    //Grabs the format and locale and updates the labels.
    private void setCurrentTime() {
        Calendar calendar = new GregorianCalendar(timeZone, locale);
        DateFormat formatter = DateFormat.getTimeInstance(timeFormat, locale);
        formatter.setTimeZone(timeZone);
        timeField.setText(formatter.format(calendar.getTime()));
        formatter = DateFormat.getDateInstance(dateFormat, locale);
        dateField.setText(formatter.format(calendar.getTime()));
    }
}
