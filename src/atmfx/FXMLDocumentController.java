/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmfx;

import DataBaseHandler.DBHandler;
import SedsValidateFx.*;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable {

    
    
    @FXML private Button btnRightOne, btnRightTwo, btnRightThree, btnRightFour, btnLeftOne, btnLeftTwo, btnLeftThree, btnLeftFour;
    @FXML private StackPane spCenterDisplay, spBottomDisplay;
    @FXML private AnchorPane apMain;
    
//add check balance screen

    Map<String, Button> buttons = new HashMap<>();

    DBHandler dbh = new DBHandler();
    
    ValidateTextField vtf;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        showWelcomeScreen();
        btnLeftOne.setOnAction((event) -> {
            showSetupAccountScreen();
        });       

        btnRightOne.setOnAction((event) -> {
            showWithdrawalScreen();
        });
        
        btnRightTwo.setOnAction((event) -> {
            showDepositScreen();
        });
        
        btnLeftTwo.setOnAction(null);
        btnLeftThree.setOnAction(null);
        btnLeftFour.setOnAction(null);
        btnRightThree.setOnAction(null);
        btnRightFour.setOnAction(null);
    }

    private void showWelcomeScreen()
    {
        try 
        {
            BorderPane root = FXMLLoader.load(getClass().getResource("SubWelcomeScreen.fxml"));
            spCenterDisplay.getChildren().add(root);
            
            btnLeftOne.setOnAction((event) -> {
                showSetupAccountScreen();
            });
            
            btnLeftTwo.setOnAction(null);
            btnLeftThree.setOnAction(null);
            btnLeftFour.setOnAction(null);
            btnRightThree.setOnAction(null);
            btnRightFour.setOnAction(null);
        }
        catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showSetupAccountScreen()
    {
        try 
        {
            spCenterDisplay.getChildren().remove(0);//remove old display            
            BorderPane root = FXMLLoader.load(getClass().getResource("SubSetupAccount.fxml"));
            spCenterDisplay.getChildren().add(root);//add new display
            GridPane tempDisplay = (GridPane)root.getChildren().get(1);//get Parent of the nodes I will be using in this controller
            loadQWERTYKeyboard();            
            
            TextField tfFirstName = (TextField)findNodeByID("tfFirstName", tempDisplay.getChildren());
            TextField tfLastName = (TextField)findNodeByID("tfLastName", tempDisplay.getChildren());
            TextField tfStreetAddress = (TextField)findNodeByID("tfStreetAddress", tempDisplay.getChildren());
            TextField tfCity = (TextField)findNodeByID("tfCity", tempDisplay.getChildren());
            TextField tfState = (TextField)findNodeByID("tfState", tempDisplay.getChildren());
            TextField tfZip = (TextField)findNodeByID("tfZip", tempDisplay.getChildren());
            TextField tfInitialDepositChecking = (TextField)findNodeByID("tfInitialDepositChecking", tempDisplay.getChildren());
            TextField tfInitialDepositSavings  = (TextField)findNodeByID("tfInitialDepositSavings", tempDisplay.getChildren());
            ChoiceBox cbChecking  = (ChoiceBox)findNodeByID("cbChecking", tempDisplay.getChildren());
            cbChecking.getItems().addAll("No", "Yes");
            cbChecking.setValue("No");
            ChoiceBox cbSavings  = (ChoiceBox)findNodeByID("cbSavings", tempDisplay.getChildren());
            cbSavings.getItems().addAll("No", "Yes");
            cbSavings.setValue("No");            
            
            if(true)//come back and check to make sure all info is in textfields
            {
                btnLeftOne.setOnAction((event) -> {
                    
                    boolean createChecking = cbChecking.getValue().equals("Yes");
                    boolean createSavings = cbSavings.getValue().equals("Yes");
                    
                    dbh.createNewAccount(tfFirstName.getText(), tfLastName.getText(), tfStreetAddress.getText(), tfCity.getText(), 
                                         tfState.getText(), tfZip.getText(), createChecking, Double.parseDouble(tfInitialDepositChecking.getText()),
                                         createSavings, Double.parseDouble(tfInitialDepositSavings.getText()));
                });
            }
            else
            {
                //create Alert 
            }
            
            btnRightOne.setOnAction((event) -> {
                cancelAccountCreation();
            });

            btnLeftTwo.setOnAction(null);
            btnLeftThree.setOnAction(null);
            btnLeftFour.setOnAction(null);
            btnRightTwo.setOnAction(null);
            btnRightThree.setOnAction(null);
            btnRightFour.setOnAction(null);
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

//    private void createAccount()
//    {
//        Boolean createSavingsAccount = false;
//        Boolean createCheckingAccount = false;
//
//        if (cbCreateSavings.getValue().toString().equals("Yes")) {
//            createSavingsAccount = true;
//        }
//
//        if (cbCreateChecking.getValue().toString().equals("Yes")) {
//            createCheckingAccount = true;
//        }
//        if (createSavingsAccount || createCheckingAccount) {
//            DBHandler dbHandler = new DBHandler();
//            dbHandler.createNewAccount(tfCAFirstName.getText(), tfCALastName.getText(), tfCAStreetAddress.getText(), tfCACity.getText(), tfCAState.getText(),
//                    tfCAZip.getText(), createCheckingAccount, createSavingsAccount);
//        }
//    }

    private void cancelAccountCreation()
    {
        
    }
    
    
    private void loadQWERTYKeyboard()
    {
        try 
        {
            AnchorPane keyboardRoot = FXMLLoader.load(getClass().getResource("KeyboardQWERTY.fxml"));
            System.out.println(keyboardRoot.getId());
            spBottomDisplay.getChildren().add(keyboardRoot);
            
            GridPane tempKeyboard = (GridPane)keyboardRoot.getChildren().get(0);
            
            tempKeyboard.getChildren().stream().filter((tempNode)
                    -> (tempNode instanceof Button)).map((
                            tempNode) -> (Button) tempNode).forEachOrdered((tempButton) -> {
                                buttons.put(tempButton.getText().toLowerCase(), tempButton);
                            });
            
            apMain.setOnKeyPressed((event) -> {
                Button tempButton = buttons.get(event.getText());
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
            });
            
            apMain.setOnKeyReleased((event) -> {
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
            });
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Node findNodeByID(String id, ObservableList<Node> observableList)
    {
        for(Node node : observableList)
        {
            if(node.getId().equals(id))
            {
                System.out.println("node found!");
                return node;
            }
            else
            {
                System.out.println("node not found yet!");
            }
        }
        
        return null;
    }
}
