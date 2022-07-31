package com.mycompany.login_and_signup;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable{

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    
     @FXML
    private Label Status;
    @FXML
    private TextField tEmail;
    @FXML
    private PasswordField tPassword;
    @FXML
    private Button Login;
    @FXML
    private Hyperlink primaryButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    Connection con;
    Statement st;
    ResultSet rs;
    
    String userName="root";
    String password="MiniSh03@";
    String dbMachine="localhost";
    String dbName="test1";
    String url="jdbc:mysql://" +dbMachine +  "/" + dbName;
    
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    
   
 

    @FXML
    private void doLogin(ActionEvent event) 
    {
          String email = tEmail.getText();
        String pass = tPassword.getText();
        
        if(email.length()>0 && pass.length()>0)
        {
            String sql = "select * from test1 where email = '" +email +"' and pass = '" +pass +"'"  ; 
        try{
            
            
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(url, userName, password);
             st = con.createStatement();
            
             
            
            rs = st.executeQuery(sql);
            if(rs.next())
            {
                alert.setContentText("Login Successful ...");
                alert.show();   
                Status.setText("");
            }          
            else
            {
                alert.setContentText("Login UnSuccessful ...");
                alert.show();
            }
            
            //Status.setText("Successfully saved ...");
        }catch(Exception e)
        {
            Status.setText("" +e);
             //showAlert();        
        }
        }
        else{
            Status.setText("Please enter email and password ...");
        }
    }

}
