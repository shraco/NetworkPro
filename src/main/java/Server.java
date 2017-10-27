import javafx.fxml.FXML;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Server {
    private static SQLiteJDBCDriverConnection connection = new SQLiteJDBCDriverConnection();

    public static BufferedReader inputFromClient;
    public static PrintStream outputToClient;
    public static Socket connectionSocket;


    public void initialize(URL location, ResourceBundle resources) {
        connection = new SQLiteJDBCDriverConnection();
    }


    @FXML
    public static void checkLogin(String input)throws Exception{
        String[] in = input.split(" ");
        if(connection.checkUserPassword(in[0],in[1])){
            outputToClient = new PrintStream(connectionSocket.getOutputStream());
            outputToClient.println("111 > login success");


        }
        else{
            System.out.println("Wrong Username or Password");
        }
    }
    public static void main(String args[]) throws Exception {
        ServerSocket welcomeSocket = new ServerSocket(6789);

        while(true) {
            connectionSocket = welcomeSocket.accept();
            System.out.println("Connect to server");
            connection.getConnect();
            inputFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            String input = inputFromClient.readLine();
            checkLogin(input);








        }
    }
}