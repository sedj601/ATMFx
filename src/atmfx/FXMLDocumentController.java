/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmfx;

import java.net.*;
import java.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private GridPane gpKeyboard, gpNumberPad;
    @FXML
    private AnchorPane apWelcomeScreen;
    @FXML
    private Button btnRightOne, btnRightTwo, btnRightThree, btnRightFour, btnLeftOne, btnLeftTwo, btnLeftThree, btnLeftFour;
    //add check balance screen

    Map<String, Button> buttons = new HashMap<>();
    boolean isWelcomeScreenShowingi;
    boolean isDepositScreenShowing;
    boolean isWithdrawalScreenShowing;
    boolean isSetupAccountScreenShowing;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        isWelcomeScreenShowingi = true;
        isDepositScreenShowing = false;
        isWithdrawalScreenShowing = false;
        isSetupAccountScreenShowing = false;

        btnLeftOne.setOnAction((event) ->
        {
            System.out.println("Loading Setup Account Screen");
            showSetupAccountScreen();
        });
        btnLeftTwo.setOnAction(null);
        btnLeftThree.setOnAction(null);
        btnLeftFour.setOnAction(null);

        btnRightOne.setOnAction((event) ->
        {
            System.out.println("Loading Withdrawal Screen");
            showWithdrawalScreen();
        });
        btnRightTwo.setOnAction((event) ->
        {
            System.out.println("Loading Deposit Screen");
            showDepositScreen();
        });
        btnRightThree.setOnAction(null);
        btnRightFour.setOnAction(null);

        gpKeyboard.getChildren().stream().filter((tempNode)
                -> (tempNode instanceof Button)).map((
                tempNode) -> (Button) tempNode).forEachOrdered((tempButton) ->
        {
            buttons.put(tempButton.getText().toLowerCase(), tempButton);
        });
    }

    @FXML
    private void handleOnKeyReleased(KeyEvent event)
    {

        Button tempButton = buttons.get(event.getText());
        System.out.println("Released: " + event.getText());

        if (tempButton != null)
        {
            tempButton.disarm();
            tempButton.setStyle("");
        }
        else if (event.getCode().equals(KeyCode.ENTER))
        {
            tempButton = buttons.get("enter");
            tempButton.disarm();
            tempButton.setStyle("");
        }
        else if (event.getCode().equals(KeyCode.BACK_SPACE))
        {
            tempButton = buttons.get("backspace");
            tempButton.disarm();
            tempButton.setStyle("");
        }
    }

    @FXML
    private void handleOnKeyPressed(KeyEvent event)
    {
        Button tempButton = buttons.get(event.getText());
        System.out.println("Pressed: " + event.getText());
        if (tempButton != null)
        {
            tempButton.arm();
            tempButton.setStyle("-fx-background-color: blue");
        }
        else if (event.getCode().equals(KeyCode.ENTER))
        {
            tempButton = buttons.get("enter");
            tempButton.arm();
            tempButton.setStyle("-fx-background-color: blue");
        }
        else if (event.getCode().equals(KeyCode.BACK_SPACE))
        {
            tempButton = buttons.get("backspace");
            tempButton.arm();
            tempButton.setStyle("-fx-background-color: blue");
        }
    }

    private void showWelcomeScreen()
    {
        apWelcomeScreen.setVisible(true);
        gpKeyboard.setVisible(true);
        isWelcomeScreenShowingi = true;

        gpNumberPad.setVisible(false);
        isDepositScreenShowing = false;
        isWithdrawalScreenShowing = false;
        isSetupAccountScreenShowing = false;

        btnLeftOne.setOnAction((event) ->
        {
            showSetupAccountScreen();
        });
        btnLeftTwo.setOnAction(null);
        btnLeftThree.setOnAction(null);
        btnLeftFour.setOnAction(null);

        btnRightOne.setOnAction((event) ->
        {
            showWithdrawalScreen();
        });
        btnRightTwo.setOnAction((event) ->
        {
            showDepositScreen();
        });
        btnRightThree.setOnAction(null);
        btnRightFour.setOnAction(null);
    }

    private void showSetupAccountScreen()
    {
//        apWelcomeScreen.setVisible(true);
//        gpKeyboard.setVisible(true);
//        isWelcomeScreenShowingi = true;
//
//        gpNumberPad.setVisible(false);
//        isDepositScreenShowing = false;
//        isWithdrawalScreenShowing = false;
//        isSetupAccountScreenShowing = false;
//
//        btnLeftOne.setOnAction((event)->{showSetupAccountScreen();});
//        btnLeftTwo.setOnAction(null);
//        btnLeftThree.setOnAction(null);
//        btnLeftFour.setOnAction(null);
//
//        btnRightOne.setOnAction((event)->{showWithdrawalScreen();});
//        btnRightTwo.setOnAction((event)->{showDepositScreen();});
//        btnRightThree.setOnAction(null);
//        btnRightFour.setOnAction(null);
    }

    private void showDepositScreen()
    {
//        apWelcomeScreen.setVisible(true);
//        gpKeyboard.setVisible(true);
//        isWelcomeScreenShowingi = true;
//
//        gpNumberPad.setVisible(false);
//        isDepositScreenShowing = false;
//        isWithdrawalScreenShowing = false;
//        isSetupAccountScreenShowing = false;
//
//        btnLeftOne.setOnAction((event)->{showSetupAccountScreen();});
//        btnLeftTwo.setOnAction(null);
//        btnLeftThree.setOnAction(null);
//        btnLeftFour.setOnAction(null);
//
//        btnRightOne.setOnAction((event)->{showWithdrawalScreen();});
//        btnRightTwo.setOnAction((event)->{showDepositScreen();});
//        btnRightThree.setOnAction(null);
//        btnRightFour.setOnAction(null);
    }

    private void showWithdrawalScreen()
    {
//        apWelcomeScreen.setVisible(true);
//        gpKeyboard.setVisible(true);
//        isWelcomeScreenShowingi = true;
//
//        gpNumberPad.setVisible(false);
//        isDepositScreenShowing = false;
//        isWithdrawalScreenShowing = false;
//        isSetupAccountScreenShowing = false;
//
//        btnLeftOne.setOnAction((event)->{showSetupAccountScreen();});
//        btnLeftTwo.setOnAction(null);
//        btnLeftThree.setOnAction(null);
//        btnLeftFour.setOnAction(null);
//
//        btnRightOne.setOnAction((event)->{showWithdrawalScreen();});
//        btnRightTwo.setOnAction((event)->{showDepositScreen();});
//        btnRightThree.setOnAction(null);
//        btnRightFour.setOnAction(null);
    }
}
