package Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScenarioObj {

    WebDriver ldriver;

    public ScenarioObj(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "//*[@id='username']")
    public WebElement txtuser;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement txtpsw;

    @FindBy(xpath = "//*[@id='loginbutton']")
    public WebElement btnlogin;

    @FindBy(xpath = "//*[@id='titlebar-tb_gotoButton']")
    public WebElement menu;

    @FindBy(xpath = "//*[@id='menu0_WO_MODULE']")
    public WebElement ItemMenuInterventions;

    @FindBy(xpath = "//*[@id='menu0_WO_MODULE_sub_changeapp_WOTRACK_a']")
    public WebElement ItemMenuSuivi_des_Interventions;

    @FindBy(xpath = "//*[@id='toolactions_INSERT-tbb_anchor']")
    public WebElement Nouvelle_Intervention;

    @FindBy(xpath = "//*[@id='m3b6a207f-tb']")
    public WebElement clé_actif;

    @FindBy(xpath = "//*[@id='toolactions_SAVE-tbb']")
    public WebElement sauvegarder;

    @FindBy(xpath = "//*[@id='m8f3f68c5-tab']")
    public WebElement section_journal;

    @FindBy(xpath = "//*[@id='m524afe2e_bg_button_addrow-pb']")
    public WebElement nouvelle_ligne;

    @FindBy(xpath = "//*[@id='m524afe2e_tdrow_[C:5]_txt-img[R:0]']")
    public WebElement loop_du_type;

    @FindBy(xpath = "//*[@id='lookup_page1_tdrow_[C:0]_ttxt-lb[R:1]']")
    public WebElement Type;

    @FindBy(xpath = "//*[@id='ma9bc1d07-tb2']")
    public WebElement libelle;

    @FindBy(xpath = "//*[@id='toolactions_STATUS-tbb']")
    public WebElement changer_statut_etape_1;

    @FindBy(xpath = "//img[@id='mc927149a-img']")
    public WebElement nouveau_statut_etape_1;

    @FindBy(xpath = "//span[@id='menu0_WSCH_OPTION_a_tnode']")
    public WebElement nouveau_statut_etape_2;

    @FindBy(xpath = "//button[@id='m60bd6d91-pb']")
    public WebElement btnOK_changer_le_statut;

    @FindBy(xpath = "//img[@id='toolbar2_tbs_1_tbcb_0_action-img']")
    public WebElement selectionner_une_action;

    @FindBy(xpath = "//span[@id='menu0_OWNER_OPTION_a_tnode']")
    public WebElement selectionner_le_propriétaire;

    @FindBy(xpath = "//*[@id='m2578bad6-lb2']")
    public WebElement filtre;

    @FindBy(xpath = "//*[@id='m2578bad6_tfrow_[C:0]_txt-tb']")
    public WebElement groupe_de_personnes;

    @FindBy(xpath = "//*[@id='m2578bad6-ti2_img']")
    public WebElement loop_groupe;

    @FindBy(xpath = "//*[@id='m2578bad6_tdrow_[C:0]_ttxt-lb[R:0]']")
    public WebElement selectionner_site;

    @FindBy(xpath = "//*[@id=\"menu0_COMP_OPTION_a\"]")
    public WebElement nouveau_statut_affecté;

    @FindBy(xpath = "//*[@id=\"titlebar_hyperlink_8-co_0\"]")
    public WebElement deconnecter;

    public void setTxtemail(String email) throws InterruptedException {
        txtuser.clear();
        txtuser.sendKeys(email);
        Thread.sleep(2000);
    }

    public void setTxtpsw(String psw) throws InterruptedException {
        txtpsw.clear();
        txtpsw.sendKeys(psw);
        Thread.sleep(2000);
    }

    public void setBtnlogin() throws InterruptedException {
        btnlogin.click();
        Thread.sleep(2000);
    }

    public void setMenu() throws InterruptedException {
        menu.click();
        Thread.sleep(3000);
        ItemMenuInterventions.click();
        Thread.sleep(3000);
        ItemMenuSuivi_des_Interventions.click();
        Thread.sleep(3000);
    }

    public void setNouvelle_Intervention() throws InterruptedException {
        Nouvelle_Intervention.click();
        Thread.sleep(3000);
    }

    public void setClé_actif(String clé) throws InterruptedException {
        clé_actif.click();
        Thread.sleep(3000);
        clé_actif.sendKeys(clé);
        Thread.sleep(3000);
        sauvegarder.click();
        Thread.sleep(3000);
    }

    public void setSection_journal() throws InterruptedException {
        section_journal.click();
        Thread.sleep(3000);
        nouvelle_ligne.click();
        Thread.sleep(3000);
    }

    public void setLoop_du_type() throws InterruptedException {
        loop_du_type.click();
        Thread.sleep(3000);
    }

    public void setType() throws InterruptedException {
        Type.click();
        Thread.sleep(3000);
    }

    public void setlibelle(String lib) throws InterruptedException {
        libelle.click();
        Thread.sleep(3000);
        libelle.sendKeys(lib);
    }

    public void setSauvegarder() throws InterruptedException {
        sauvegarder.click();
        Thread.sleep(3000);
    }

    public void setNouveau_statut() throws InterruptedException {
        nouveau_statut_etape_1.click();
        Thread.sleep(3000);
        nouveau_statut_etape_2.click();
        Thread.sleep(3000);
    }

    public void setChanger_statut() throws InterruptedException {
        changer_statut_etape_1.click();
        Thread.sleep(3000);
    }

    public void setBtnOK_changer_le_statut() throws InterruptedException {
        btnOK_changer_le_statut.click();
        Thread.sleep(3000);
    }

    public void setSelectionner_une_action() throws InterruptedException {
        selectionner_une_action.click();
        Thread.sleep(3000);
        selectionner_le_propriétaire.click();
        Thread.sleep(3000);
    }

    public void setfiltre(String groupe) throws InterruptedException {
        filtre.click();
        Thread.sleep(3000);
        groupe_de_personnes.click();
        Thread.sleep(3000);
        groupe_de_personnes.sendKeys(groupe);
        Thread.sleep(3000);
        loop_groupe.click();
        Thread.sleep(3000);
    }

    public void setSelectionner_site() throws InterruptedException {
        selectionner_site.click();
        Thread.sleep(3000);
    }

    public void setNouveau_statut_affecté() throws InterruptedException {
        nouveau_statut_etape_1.click();
        Thread.sleep(3000);
        nouveau_statut_affecté.click();
        Thread.sleep(3000);
    }

    public void setDeconnecter() throws InterruptedException {
        deconnecter.click();
        Thread.sleep(1000);
        ldriver.quit();
    }

}
