package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.fxml.Initializable;

public class Screen1Controller implements Initializable {

	@FXML
	private Button btnBetun;

	@FXML
	void holis(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "si buenas");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
