package com.example.gochat;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignupController {
    @FXML
    private AnchorPane AnchorLeft;

    @FXML
    private AnchorPane AnchorRight;

    @FXML
    private Button BTN_signup;

    @FXML
    private FontAwesomeIconView Icon_P;

    @FXML
    private FontAwesomeIconView Icon_U;

    @FXML
    private ImageView Img_Logo;

    @FXML
    private BorderPane LAYOUT;

    @FXML
    private Label Label_CN;

    @FXML
    private Label Label_CTN;

    @FXML
    private Label Label_WCB;

    @FXML
    private Label Label_WT;

    @FXML
    private PasswordField Text_P;

    @FXML
    private TextField Text_U;

    @FXML
    private TextField Text_gmail;

    public void signup() {
        String username = Text_U.getText();
        String password = Text_P.getText();
        String email = Text_gmail.getText();
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try {
            Connection con = dataConect.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (USERNAME, PASSWORD, EMAIL) VALUES (?, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, hashedPassword);
            ps.setString(3, email);
            ps.executeUpdate();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Account created successfully", ButtonType.OK);
            alert.show();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize() {
        BTN_signup.setOnAction(actionEvent -> signup());
    }
}
