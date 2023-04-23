package com.example.lab6_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import simulationElements.TimeFlow.TimeFlow;
import simulationElements.arena.Arena;
import simulationElements.arena.Snapshot;

import java.util.ArrayList;

public class Controller {
    Arena arena;
    TimeFlow time;
    ArrayList<Snapshot> snapshots;
    @FXML
    private Button Button;

    @FXML
    private TextField loadTextField;

    @FXML
    private Pane mainPanel;

    @FXML
    private Label savesLabel;

    @FXML
    void ButtonClick(ActionEvent event) {
        arena = new Arena(mainPanel);
        snapshots = new ArrayList<>();
        time = new TimeFlow(arena, snapshots);
    }

    @FXML
    void moveClick(ActionEvent event) {
        time.start();
    }

    @FXML
    void loadClick(ActionEvent event) {
        Snapshot tmp;
        try {
            tmp = snapshots.get(Integer.parseInt(loadTextField.getText()));
        } catch (IndexOutOfBoundsException i){
            tmp = null;
        }
        if(tmp != null){
            mainPanel.getChildren().clear();
            tmp.restore();
        }
        savesLabel.setText(Integer.toString(snapshots.size()));
    }

}
