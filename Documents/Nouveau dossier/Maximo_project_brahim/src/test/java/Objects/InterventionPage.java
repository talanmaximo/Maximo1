package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InterventionPage {
    public WebDriver ldriver;

    public InterventionPage(WebDriver driver) {
    }


    public void InterventionPage(WebDriver rdriver){
        ldriver= rdriver;
        PageFactory.initElements(ldriver,this);

    }



    public String getPageTitle(){
        return ldriver.getTitle();
    }

}
