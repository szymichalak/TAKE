/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managebeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Szymek
 */
@Named(value = "sumBean")
@RequestScoped
public class sumBean {
    
    private Integer firstNum;
    private Integer secondNum;
    private Integer result;

    /**
     * Creates a new instance of sumBean
     */
    public sumBean() {
    }
    
    public void calculate() {
        result = firstNum + secondNum;
        
        String op = firstNum.toString() + " + " + secondNum.toString() + " = " + result.toString();
        
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(op);
        context.addMessage("growl", msg);
        
    }
    
    public String getCurrentDateTime(){
        return new java.util.Date().toString();
    }

    /**
     * @return the first_num
     */
    public Integer getFirstNum() {
        return firstNum;
    }

    /**
     * @param firstNum the first_num to set
     */
    public void setFirstNum(Integer firstNum) {
        this.firstNum = firstNum;
    }

    /**
     * @return the secondNum
     */
    public Integer getSecondNum() {
        return secondNum;
    }

    /**
     * @param secondNum the secondNum to set
     */
    public void setSecondNum(Integer secondNum) {
        this.secondNum = secondNum;
    }

    /**
     * @return the result
     */
    public Integer getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Integer result) {
        this.result = result;
    }
    
}