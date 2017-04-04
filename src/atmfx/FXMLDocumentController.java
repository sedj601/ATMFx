/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmfx;

import DataBaseHandler.*;
import SedsValidateFx.*;
import java.net.*;
import java.util.*;
import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import org.controlsfx.control.textfield.*;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private GridPane gpKeyboard, gpNumberPad;
    @FXML
    private AnchorPane apWelcomeScreen, apSetupAccountOne;
    @FXML
    private Button btnRightOne, btnRightTwo, btnRightThree, btnRightFour, btnLeftOne, btnLeftTwo, btnLeftThree, btnLeftFour;
    //add check balance screen

    @FXML
    private TextField tfCAFirstName, tfCALastName, tfCAStreetAddress, tfCACity, tfCAState, tfCAZip,
            tfCACheckingInitialDeposit, tfCASavingsInitialDeposit;
    @FXML
    private ChoiceBox cbCreateChecking, cbCreateSavings;

    @FXML
    private CustomTextField ctfTest;

    Map<String, Button> buttons = new HashMap<>();

    ValidateTextField vtf;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        cbCreateChecking.setItems(FXCollections.observableArrayList("No", "Yes"));
        cbCreateSavings.setItems(FXCollections.observableArrayList("No", "Yes"));
        cbCreateChecking.setValue("No");
        cbCreateSavings.setValue("No");

        btnLeftOne.setOnAction((event) -> {
            System.out.println("Loading Setup Account Screen");
            showSetupAccountScreen();
        });
        btnLeftTwo.setOnAction(null);
        btnLeftThree.setOnAction(null);
        btnLeftFour.setOnAction(null);

        btnRightOne.setOnAction((event) -> {
            System.out.println("Loading Withdrawal Screen");
            showWithdrawalScreen();
        });
        btnRightTwo.setOnAction((event) -> {
            System.out.println("Loading Deposit Screen");
            showDepositScreen();
        });
        btnRightThree.setOnAction(null);
        btnRightFour.setOnAction(null);

        gpKeyboard.getChildren().stream().filter((tempNode)
                -> (tempNode instanceof Button)).map((
                tempNode) -> (Button) tempNode).forEachOrdered((tempButton) -> {
            buttons.put(tempButton.getText().toLowerCase(), tempButton);
        });

    }

    @FXML
    private void handleOnKeyReleased(KeyEvent event)
    {
        System.out.println();
        Button tempButton = buttons.get(event.getText());
        System.out.println("Released key text: " + event.getText());
        System.out.println("Released key code: " + event.getCode());

        if (tempButton != null) {
            tempButton.disarm();
            tempButton.setStyle("");
        }
        else if (event.getCode().equals(KeyCode.ENTER)) {
            tempButton = buttons.get("enter");
            tempButton.disarm();
            tempButton.setStyle("");
        }
        else if (event.getCode().equals(KeyCode.BACK_SPACE)) {
            tempButton = buttons.get("backspace");
            tempButton.disarm();
            tempButton.setStyle("");
        }
        else if (event.getCode().equals(KeyCode.SPACE)) {
            tempButton = buttons.get("space");
            tempButton.disarm();
            tempButton.setStyle("");
        }
    }

    @FXML
    private void handleOnKeyPressed(KeyEvent event)
    {
        Button tempButton = buttons.get(event.getText());
        System.out.println("Pressed key text: " + event.getText());
        System.out.println("Pressed key code: " + event.getCode());
        if (tempButton != null) {
            tempButton.arm();
            tempButton.setStyle("-fx-background-color: blue");
        }
        else if (event.getCode().equals(KeyCode.ENTER)) {
            tempButton = buttons.get("enter");
            tempButton.arm();
            tempButton.setStyle("-fx-background-color: blue");
        }
        else if (event.getCode().equals(KeyCode.BACK_SPACE)) {
            tempButton = buttons.get("backspace");
            tempButton.arm();
            tempButton.setStyle("-fx-background-color: blue");
        }
        else if (event.getCode().equals(KeyCode.SPACE)) {
            tempButton = buttons.get("space");
            tempButton.arm();
            tempButton.setStyle("-fx-background-color: blue");
        }
    }

    private void showWelcomeScreen()
    {
        apWelcomeScreen.setVisible(true);
        gpKeyboard.setVisible(true);
        btnLeftOne.setOnAction((event) -> {
            showSetupAccountScreen();
        });
        btnRightOne.setOnAction((event) -> {
            showWithdrawalScreen();
        });
        btnRightTwo.setOnAction((event) -> {
            showDepositScreen();
        });

        gpNumberPad.setVisible(false);
        btnLeftTwo.setOnAction(null);
        btnLeftThree.setOnAction(null);
        btnLeftFour.setOnAction(null);
        btnRightThree.setOnAction(null);
        btnRightFour.setOnAction(null);
    }

    private void showSetupAccountScreen()
    {
        apSetupAccountOne.setVisible(true);
        gpKeyboard.setVisible(true);
        btnLeftOne.setOnAction((event) -> {
            createAccount();
        });
        btnRightOne.setOnAction((event) -> {
            cancelAccountCreation();
        });

        apWelcomeScreen.setVisible(false);
        gpNumberPad.setVisible(false);
        btnLeftTwo.setOnAction(null);
        btnLeftThree.setOnAction(null);
        btnLeftFour.setOnAction(null);
        btnRightTwo.setOnAction(null);
        btnRightThree.setOnAction(null);
        btnRightFour.setOnAction(null);

    }
//        ctfTest.textProperty().addListener(new InvalidationListener() {
//            @Override public void invalidated(Observable arg0) {
//                String text = inputField.getText();
//                boolean isTextEmpty = text == null || text.isEmpty();
//                boolean isButtonVisible = fader.getNode().getOpacity() > 0;
//
//                if (isTextEmpty && isButtonVisible) {
//                    setButtonVisible(false);
//                } else if (!isTextEmpty && !isButtonVisible) {
//                    setButtonVisible(true);
//                }
//            }
//    });

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

    private void createAccount()
    {
        Boolean createSavingsAccount = false;
        Boolean createCheckingAccount = false;

        if (cbCreateSavings.getValue().toString().equals("Yes")) {
            createSavingsAccount = true;
        }

        if (cbCreateChecking.getValue().toString().equals("Yes")) {
            createCheckingAccount = true;
        }
        if (createSavingsAccount || createCheckingAccount) {
            DBHandler dbHandler = new DBHandler();
            dbHandler.createNewAccount(tfCAFirstName.getText(), tfCALastName.getText(), tfCAStreetAddress.getText(), tfCACity.getText(), tfCAState.getText(),
                    tfCAZip.getText(), createCheckingAccount, createSavingsAccount);
        }
    }

    private void cancelAccountCreation()
    {

    }
}
