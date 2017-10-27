import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Client extends Application {

    @FXML
    private TextField userField;
    @FXML
    private TextField passField;
    @FXML
    private Button loginButton;
    public static DataOutputStream outToServer;
    public static  DataInputStream inFromServer ;
    public static Socket clientSocket;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("ATM Login");
        primaryStage.setScene(new Scene(root, 360, 318));
        primaryStage.show();
    }
    @FXML
    public void checkLogin(ActionEvent event) throws Exception {
        String getUser = userField.getText();
        String getPass = passField.getText();

        outToServer = new DataOutputStream(clientSocket.getOutputStream());
        outToServer.writeBytes(getUser+" "+getPass);
        inFromServer = new DataInputStream(clientSocket.getInputStream());
        String status = inFromServer.readLine();
        System.out.println(status);
        if(status.equals("111 > login success")){
            System.out.println("login success");
        }


    }


    public static void main(String args[]) throws Exception {
        clientSocket = new Socket("localhost",6789);

        launch(args);

        clientSocket.close();

    }

}