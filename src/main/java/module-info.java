module com.mycompany.login_and_signup {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    opens com.mycompany.login_and_signup to javafx.fxml;
    exports com.mycompany.login_and_signup;
}
