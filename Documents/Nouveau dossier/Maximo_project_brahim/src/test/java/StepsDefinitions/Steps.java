package StepsDefinitions;
import Objects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Steps extends BaseClass {
    public static String x ;
    @Given("user launch chrome browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
        driver=new ChromeDriver();
        lp= new LoginPage(driver);



    }
    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
    @When("User enters Nom d'utilisateur as {string} and Mot de passe  as {string}")
    public void user_enters_nom_d_utilisateur_as_and_mot_de_passe_as(String username, String password) throws InterruptedException {
        lp.setUseName(username);
        Thread.sleep(1000);
        lp.setPassword(password);
        Thread.sleep(1000);


    }
    @When("Click on Ouvrir une session")
    public void click_on_ouvrir_une_session() throws InterruptedException {
        lp.clickLogin();
        Thread.sleep(2000);
    }

    @When("Accéder à l'application Interventions depuis le menu Favoris au niveau de l'écran d'accueil ou en cliquant sur Mes Applications puis Interventions puis suivis des interventions")
    public void Accéder_à_l_application_Interventions_depuis_le_menu_Favoris_au_niveau_de_l_écran_d_accueil() throws InterruptedException {
       // alller à (menu)
        driver.findElement(By.xpath("//*[@id='titlebar-tb_gotoButton']")).click();
        Thread.sleep(1500);
        //intervention
        driver.findElement(By.xpath("//*[@id='menu0_WO_MODULE_a']")).click();
        Thread.sleep(1500);
        // suivi interventions
        driver.findElement(By.xpath("//*[@id='menu0_WO_MODULE_sub_changeapp_WOTRACK_a_tnode']")).click();
        Thread.sleep(1500);


    }



    @When("Cliquer sur l'icône Nouvelle intervention")
    public void Cliquer_sur_l_icône_Nouvelle_intervention() throws InterruptedException {
        // nouvellle intervention
       driver.findElement((By.xpath("//*[@id='toolactions_INSERT-tbb_image']"))).click();
       Thread.sleep(1500);
    }


    @Given("Checker les champs renseignes par défaut ci-dessous ce numéro est généré automatiquement et il est unique")
    public void checker_les_champs_renseignes_par_défaut_ci_dessous_ce_numéro_est_généré_automatiquement_et_il_est_unique() {

        //numero intervention

        x= driver.findElement(By.xpath("//*[@id=\"mad3161b5-tb\"]")).getAttribute("value");
        if (x!="null") {
            System.out.println("l'id est :  " + x);
        }
        else {
            System.out.println("le numero n'est pas généré");
            driver.quit();
        }

    }
    @Given("Statut : DICREEE")
    public void statut_dicreee() throws InterruptedException {
        // la valeur du statut a verifier :
        String y=" DICREEE";
        String z;
        z=driver.findElement(By.xpath("//*[@id=\"md3801d08-tb\"]")).getAttribute("value");
        if(y!=z ){
            System.out.println("la valeur de statut est differente a DICREE et eagle à "+z);

        }
        else {
            System.out.println("la valeur de statut est verifier");
        }
        Assert.assertEquals(z,y);
        Thread.sleep(1000);
        driver.quit();



    }
    @Given("Date du statut : Date du jour")
    public void date_du_statut_date_du_jour() {

        String da;
        final Date date = new Date();
        da = new SimpleDateFormat("dd.MM.yyyy").format(date);
        System.out.println("la valeur du date d'aujourdhui est : "+ da);
        driver.findElement(By.id("m77f96917-tb")).click();
       //String date_aujrd = driver.findElement((By.xpath("//*[@id=\"m77f96917-tb\"]"))).getText();
        String date_aujrd = driver.findElement(By.id("m77f96917-tb")).getAttribute("title");
       // System.out.println(driver.findElement(By.id("m77f96917-tb")).getText());


        SoftAssert softAssert = new SoftAssert();
        date_aujrd= new SimpleDateFormat("dd.MM.yyyy").format(date);
        System.out.println(date_aujrd);
        System.out.println("*** test started ***");
        softAssert.assertEquals(date_aujrd, da,"fileeeeed la date est erroné");
        System.out.println(date_aujrd);
        System.out.println("*** test finished ***");

        softAssert.assertAll();


        }





    @Then("Renseigner le champ obligatoire Clé actif Exemple : \"1002\" et sauvegarder")
    public void sRenseigner_le_champ_obligatoire_Clé_actif_Exemple_1002_et_sauvegarder() throws InterruptedException {
        //click sur champ actif
        driver.findElement(By.xpath("//*[@id='m3b6a207f-tb']")).click();
        Thread.sleep(1000);
        //inserer la valier 1002
        driver.findElement(By.xpath("//*[@id='m3b6a207f-tb']")).sendKeys("1002");
        Thread.sleep(1000);
        x= driver.findElement(By.xpath("//*[@id=\"mad3161b5-tb\"]")).getAttribute("value");

    }





    @Then("Renseigner le champ obligatoire Clé GMAO Exemple : {string}")
    public void renseigner_le_champ_obligatoire_clé_gmao_exemple(String string) {

    }



    @Then("Accéder à la section Journal et cliquer sur Nouvelle ligne")
    public void accéder_à_la_section_Journal_et_cliquer_sur_nouvelle_ligne() throws InterruptedException {
        //acceder a journal
        driver.findElement(By.xpath("//*[@id=\"m8f3f68c5-tab_anchor\"]")).click();
        Thread.sleep(1000);
        //acceder a nouvelle ligne
        driver.findElement(By.xpath("//*[@id='m524afe2e_bg_button_addrow-pb']")).click();
        Thread.sleep(1000);

    }



    @Then("Cliquer sur la loupe du type")
    public void cliquer_sur_la_loupe_du_type() throws InterruptedException {
        //loupe type
        driver.findElement(By.xpath("//*[@id='mad477c8d-img']")).click();

        Thread.sleep(1500);



    }



    @Then("Choisir un type dans la liste de valeur")
    public void choisir_un_type_dans_la_liste_de_valeur() throws InterruptedException {
         // valeur update
        driver.findElement(By.xpath("//*[@id='lookup_page1_tdrow_[C:1]_ttxt-lb[R:2]']")).click();
        Thread.sleep(1500);
        driver.findElement((By.xpath("//*[@id='ma9bc1d07-tb2']"))).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='ma9bc1d07-tb2']")).sendKeys("4001");
        Thread.sleep(1500);
        //revenir a intervention
        driver.findElement(By.xpath("//*[@id='mbf28cd64-tab_anchor']")).click();
        Thread.sleep(2000);



    }









    @Then("Saisir un Libellé pour votre intervention champ Libellé exemple: \"2001\" à partir de l'onglet journal")
    public void saisir_un_libellé_pour_votre_intervention_champ_libellé() throws InterruptedException {
        //libelle intervention


    }




    @Then("Sauvegarder l'intervention en cliquant sur la disquette sur la barre d'outil")
    public void sauvegarder_l_intervention_en_cliquant_sur_la_disquette_sur_la_barre_d_outil() throws InterruptedException  {
        //bttn sauvgarder
        driver.findElement(By.xpath("//*[@id='toolactions_SAVE-tbb_anchor']")).click();
        Thread.sleep(1500);
        // verification de sortie de message

       }
    @When("verifier le message de  sauvgarde")
    @Test
    public void verifier_le_message_de_sauvgarde() throws InterruptedException {

    // String actual_message = driver.findElement(By.xpath("//*[@id='titlebar_error_table']")).getText();
       String actual_message = driver.findElement(By.id("titlebar_error")).getText().trim();

        driver.findElement(By.id("titlebar_error")).click();

       driver.findElement(By.xpath("//td[contains(text(),'Enregistrement sauvegardé')]")).click();

       String excepted_message =" BMXAA4205I - Enregistrement sauvegardé "  ;
       excepted_message = excepted_message.trim();
       actual_message= actual_message.trim();
       System.out.println(driver.findElement(By.id("titlebar_error")).getText().trim());


       SoftAssert softAssert = new SoftAssert();
           System.out.println("*** test started ***");
           softAssert.assertEquals(actual_message, excepted_message,"fileeeeed message de sauvgarde erroné");
           System.out.println(excepted_message);

           System.out.println("*** test finished ***");
           softAssert.assertAll();
           Thread.sleep(1000);
          // driver.quit();


    }
    @When("verifier le message de statut")
    public void verifier_le_message_de_statut()  throws InterruptedException {
       // String actual_message = driver.findElement(By.id("md3801d08-tb")).getText().trim();
        driver.findElement(By.xpath("//*[@id=\"m8f3f68c5-tab_anchor\"]")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("md70d61ba-tb")).click();
        Thread.sleep(2000);
       String actual_message= driver.findElement(By.id("md70d61ba-tb")).getAttribute("value");
        System.out.println(actual_message);
        Assert.assertEquals(actual_message,"PROPOSEE");

    }

    @Given("selectionner l'intervention intervention")
    public void selectionner_l_intervention_intervention() throws InterruptedException {
       //  recherche de l'intervention deja crée dans le scenario precedent
      driver.findElement(By.id("quicksearch")).click();
      Thread.sleep(1000);
      System.out.println("la valeur de x est: "+x);
        driver.findElement(By.id("quicksearch")).sendKeys(x);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"quicksearchQSImage\"]")).click();
        Thread.sleep(1000);

    }



    @When("Changer le statut de l'intervention à Non-Affecter et  pour cela:Cliquer sur l'icône de changement de statut sur la barre d'outil")
    public void changer_le_statut_de_l_intervention_à_non_affecter_et_pour_cela_cliquer_sur_l_icône_de_changement_de_statut_sur_la_barre_d_outil() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"toolactions_STATUS-tbb_image\"]")).click();
        Thread.sleep(1500);
    }


    @Then("Sur le pop-up qui s'ouvre: Renseigner le champ {string} en sélectionnant le statut : {string}")
    public void sur_le_pop_up_qui_s_ouvre_renseigner_le_champ_en_sélectionnant_le_statut(String string, String string2) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"mc927149a-img\"]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"menu0_WSCH_OPTION_a\"]")).click();
        Thread.sleep(1500);
    }

    @Then("Cliquer sur le bouton Valider")
    public void cliquer_sur_le_bouton_valider() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"m60bd6d91-pb\"]")).click();
        Thread.sleep(4000);
    }


    @Then("verifier le message du changement de statut")
    public void verifier_le_message_du_changement_de_statut() {
        String actual_message = driver.findElement(By.id("titlebar_error")).getText().trim();
        System.out.println(driver.findElement(By.id("titlebar_error")).getText().trim());
        String excepted_message =" BMXAA4591I - Changement de statut effectué sans erreur. "  ;
        excepted_message = excepted_message.trim();
        SoftAssert softAssert = new SoftAssert();
        System.out.println("*** test started ***");
        softAssert.assertEquals(actual_message, excepted_message,"fileeeeed message de changement du statut erroné");
        System.out.println(excepted_message);
        System.out.println("*** test finished ***");
        softAssert.assertAll();
    }



    @Given("Cliquer sur la liste Sélectionner une action puis choisir Sélectionner le propriétaire")
    public void Cliquer_sur_la_liste_Sélectionner_une_action_puis_choisir_Sélectionner_le_propriétaire() throws InterruptedException {

        driver.findElement(By.xpath("//a[@id='toolactions_OWNER-tbb_anchor']")).click();
        Thread.sleep(1500);
    }



    @Given("Cliquer sur Filtre puis écrire \"CA\" puis cliquer sur loop")
    public void clique_sur_filtre_puis_ecrire_puis_cliquer_sur_loop() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='m2578bad6-lb2']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='m2578bad6_tfrow_[C:0]_txt-tb']")).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='m2578bad6_tfrow_[C:0]_txt-tb']")).sendKeys("CA");
        Thread.sleep(1500);
       driver.findElement(By.xpath("//*[@id='m2578bad6-hb_header_5']")).click();
        Thread.sleep(1500);
    }




    @Given("Sélectionner le site")
    public void sélectionner_le_site() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='m1b98b707-pb']")).click();
        Thread.sleep(2000);
    }




    @When("Cliquer sur l'icône de changement de statut sur la barre d'outil")
    public void cliquer_sur_l_icône_de_changement_de_statut_sur_la_barre_d_outil() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='toolactions_STATUS-tbb_image']")).click();
        Thread.sleep(2000);
    }




    @Then("Sur le pop-up qui s'ouvre:Renseigner le champ {string} en sélectionnant le statut :terminé")
    public void sur_le_pop_up_qui_s_ouvre_renseigner_le_champ_en_sélectionnant_le_statut_affecté(String string) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"mc927149a-img\"]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"menu0_COMP_OPTION_a\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"m60bd6d91-pb\"]")).click();
        Thread.sleep(5000);

    }


    @Then("Se déconnecter de GMAO\\/Osmose en cliquant sur le bouton Se Déconnecter en haut à droite")
    public void se_déconnecter_de_gmao_osmose_en_cliquant_sur_le_bouton_se_déconnecter_en_haut_à_droite() throws InterruptedException {
        Thread.sleep(1500);
        driver.findElement(By.id("titlebar_hyperlink_8-lbsignout_image")).click();
        Thread.sleep(2000);
        driver.quit();
    }


}
