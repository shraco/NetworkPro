import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.event.ActionEvent;

public class MenuController {

    @FXML
    private Label username;
    @FXML
    private Label balance;
    @FXML
    private Button logoutButton;


    @FXML
    public void setUsername(String user){
        username.setText(user);
    }
    public void setBalance(int amount){
        balance.setText(""+amount);
    }

    @FXML
    public void logoutAction(ActionEvent event){
        System.out.println("logout");
    }

}
