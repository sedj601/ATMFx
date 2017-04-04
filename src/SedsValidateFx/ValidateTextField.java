/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SedsValidateFx;

import javafx.scene.control.*;

/**
 *
 * @author Sedrick
 */
public class ValidateTextField {

    TextField textField;
    Boolean containsText;
    int textFieldLength = 0;

    public ValidateTextField(TextField textField)
    {
        this.textField = textField;
    }

    public void ValidateContainsText()
    {
        textField.textProperty().addListener((obs, oldVal, newVal) ->
        {
            if (newVal.length() > 0)
            {
                containsText = true;
            }
            else
            {
                containsText = false;
            }
        });
    }

    public boolean containsText()
    {
        return containsText;
    }
}
