/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmfx;

import java.net.URL;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{
    
   
    @FXML private GridPane gpKeyboard, gpNumberPad;
    
    
    Map<String, Button> buttons = new HashMap<>();

    
    @FXML
    private void handleOnKeyReleased(KeyEvent event)
    {
        Button tempButton = buttons.get(event.getText());
        System.out.println("Released: " + event.getText());
        
        if(tempButton != null)
        {
            tempButton.disarm();
            tempButton.setStyle("-fx-background-color: yellow");          
        }        
        else if(event.getCode().equals(KeyCode.ENTER))
        {
            tempButton = buttons.get("enter");
            tempButton.disarm();
            tempButton.setStyle("-fx-background-color: yellow");
        }
    }
    
    @FXML
    private void handleOnKeyPressed(KeyEvent event)
    {
        Button tempButton = buttons.get(event.getText());
        System.out.println("Pressed: " + event.getText());
        if(tempButton != null)
        {
            tempButton.arm();
            tempButton.setStyle("-fx-background-color: blue");
        }
        
        else if(event.getCode().equals(KeyCode.ENTER))
        {
            tempButton = buttons.get("enter");
            tempButton.arm();
            tempButton.setStyle("-fx-background-color: blue");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        for(Node tempNode : gpKeyboard.getChildren())
        {
            if(tempNode instanceof Button)
            {
                Button tempButton = (Button)tempNode;
                buttons.put(tempButton.getText().toLowerCase(), tempButton);
            }          
        }
    }       
}
