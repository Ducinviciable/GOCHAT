package com.example.gochat;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class LoginController {

    @FXML
    private AnchorPane AnchorLeft;

    @FXML
    private AnchorPane AnchorRight;

    @FXML
    private Button Btn_sign;

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
    private PasswordField Text_P;

    @FXML
    private TextField Text_U;

    @FXML
    void open_signup(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Sign-up.fxml"));
    }

}
