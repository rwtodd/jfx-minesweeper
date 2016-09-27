/*
 * Copyright Richard Todd. I put the code under the
 * GPL v2.0.  See the LICENSE file in the repository.
 * for more information.
 */
package rwt.game.minesweeper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 * FXML Controller class
 *
 * @author richa
 */
public class OptionsScreenController implements Initializable {

    private boolean wantsNewGame;  // did the user press "New Game"?
    @FXML private Slider rows, cols, bombs;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rows.valueProperty().addListener((obs, oldval, newVal) ->
          rows.setValue(Math.round(newVal.doubleValue())));
        cols.valueProperty().addListener((obs, oldval, newVal) ->
          cols.setValue(Math.round(newVal.doubleValue())));
        bombs.valueProperty().addListener((obs, oldval, newVal) ->
          bombs.setValue(Math.round(newVal.doubleValue())));
        wantsNewGame = false;
    }    

    @FXML private void okBtn(ActionEvent e) { 
        wantsNewGame = true;
        ((Stage)bombs.getScene().getWindow()).close(); // My eyes!  They burn!
    }    
    
    public void initValues(int nCols, int nRows, double nBombs) {
        rows.setValue(nRows);
        cols.setValue(nCols);
        bombs.setValue(nBombs * 100);
    }
    
    public boolean newGameRequested() { return wantsNewGame; }
    public int getRows() { return (int)(rows.getValue()); }
    public int getCols() { return (int)(cols.getValue()); }
    public double getPctBombs() { return bombs.getValue() / 100.0; }
}
