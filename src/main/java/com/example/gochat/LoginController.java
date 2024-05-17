package com.example.gochat;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import org.mindrot.jbcrypt.* ;


public class LoginController implements Initializable {
    @FXML
    private AnchorPane AnchorLeft;

    @FXML
    private AnchorPane AnchorRight;

    @FXML
    public Button Btn_sign;

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
    private Label Label_FG;

    @FXML
    private Label Label_SIGNUP;

    @FXML
    private Label Label_SL;

    @FXML
    private Label Label_WCB;

    @FXML
    private Label Label_WT;

    @FXML
    public PasswordField Text_P;

    @FXML
    public TextField Text_U;

//    @FXML
//    void open_signUp(MouseEvent event) throws IOException {
//        Parent fxml = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("Sign-up.fxml")));
//    }

    public void login() {
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = dataConect.getInstance().getConnection();
        try {
            st = con.prepareStatement("SELECT * FROM users WHERE USERNAME = ?");
            st.setString(1, Text_U.getText());
            rs = st.executeQuery();

            if (rs.next()) {
                String hashedPassword = rs.getString("PASSWORD");
                if (BCrypt.checkpw(Text_P.getText(), hashedPassword)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Login successfully", ButtonType.OK);
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Login error: incorrect password", ButtonType.OK);
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Login error: user not found", ButtonType.OK);
                alert.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Btn_sign.setOnAction(actionEvent -> login());
    }
}
