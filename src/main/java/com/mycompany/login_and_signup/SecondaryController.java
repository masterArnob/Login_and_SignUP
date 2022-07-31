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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SecondaryController implements Initializable{

    @FXML
    private Hyperlink secondaryButton;
    @FXML
    private TextField username;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    
      @FXML
    private Button SignUp;
    @FXML
    private Label Status2;
    @FXML
    private TextField tEmail;
    @FXML
    private TextField tAge;
    @FXML
    private PasswordField tPassword;
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
    private void doSignUp(ActionEvent event) 
    {
        String UserName = username.getText();
        String email = tEmail.getText();
        String pass = tPassword.getText();
        String Age = tAge.getText();
        
        //String sql = "insert into test1 values( '" +UserName +"', '"+email +"', '"+pass +"', '" +Age +"'";   
        
        if(UserName.length()>0 && email.length()>0 && pass.length()>0 && Age.length()>0)
        {
        
            String sql = "insert into test1 values( '" +UserName +"', '"+email +"', '"+pass+"','"+Age +" ' )";
          try{
            
            
            
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection(url, userName, password);
             st = con.createStatement();
            
             
            
            st.executeUpdate(sql);
         
            Status2.setText("Successfully SginUp ...");
        }catch(Exception e)
        {
            Status2.setText("" +e);
             //showAlert();        
        }
        }
        

              
            else
              {
                    Status2.setText("Please enter all the information ...");
              }
        
    
        
        
    
    }
}
    
    
