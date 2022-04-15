package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver ldriver;
    public LoginPage(WebDriver rdriver){
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "//*[@id=\"username\"]")
    @CacheLookup
    WebElement txtusername;


    @FindBy(xpath = "//*[@id=\"password\"]")
    @CacheLookup
    WebElement txtpassword;


    @FindBy(xpath ="//*[@id=\"loginbutton\"]")
    @CacheLookup
    WebElement btnLogin;

    public void setUseName(String uname){
        txtusername.clear();
        txtusername.sendKeys(uname);
    }
    public void setPassword(String pwd){
        txtpassword.clear();
        txtpassword.sendKeys(pwd);
    }
    public void clickLogin(){
        btnLogin.click();
    }



}
