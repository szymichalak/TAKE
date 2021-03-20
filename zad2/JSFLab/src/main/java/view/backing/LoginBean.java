/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.ResourceBundle;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Szymek
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public String login() {
        if(getUsername().equals("scott") && getPassword().equals("tiger")){
            FacesContext context = FacesContext.getCurrentInstance();  
            context.addMessage("form", new FacesMessage(
                            ResourceBundle
                                    .getBundle("ApplicationMessages")
                                    .getString("validation.oracle")
                                    .toString()
                        )
                    );
            context.renderResponse();
            return null;
        }
        if (username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }
    
    public void activateButton(ValueChangeEvent e)
    {
        if (acceptCheckbox.isSelected())
            loginButton.setDisabled(false);
        else
            loginButton.setDisabled(true);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse(); 
    }

    
    private String username = new String();
    private String password = new String();
    private HtmlSelectBooleanCheckbox acceptCheckbox = new HtmlSelectBooleanCheckbox();
    private HtmlCommandButton loginButton = new HtmlCommandButton();

    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the acceptCheckbox
     */
    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    /**
     * @param acceptCheckbox the acceptCheckbox to set
     */
    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    /**
     * @return the loginButton
     */
    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }

    
}
