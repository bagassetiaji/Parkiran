package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.LoginModel;
import view.FormKendaraanMasuk;
import view.LoginForm;
import view.HomePage;

public class LoginController {
    LoginModel loginModel;
    LoginForm loginView;

    public LoginController(LoginForm loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
        
    /**
     *
     */
        
        
    }
    
    public void login() {
                String username = loginView.getUsername();
                String password = loginView.getPassword();
                
                if(loginModel.loginHandler(username, password)){
                    JOptionPane.showMessageDialog(null, "Login Success");
                    HomePage hom = new HomePage();
                    hom.setVisible(true);
                    hom.pack();
                    hom.setLocationRelativeTo(null);
                }else{
                    JOptionPane.showMessageDialog(null, "Login Failed");
                }
        }
    
}

