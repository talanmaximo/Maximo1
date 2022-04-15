Feature: Intervention
  Scenario: Authentification sur Maximo
    Given user launch chrome browser
    When User opens URL " http://10.4.1.197/maximo"
    And User enters Nom d'utilisateur as "POCTESTING" and Mot de passe  as "p0cTESTING"
    And Click on Ouvrir une session
  Scenario: creation de nouvelle intervention
    Given user launch chrome browser
    And User opens URL " http://10.4.1.197/maximo"
    And User enters Nom d'utilisateur as "POCTESTING" and Mot de passe  as "p0cTESTING"
    And Click on Ouvrir une session
    Given Accéder à l'application Interventions depuis le menu Favoris au niveau de l'écran d'accueil ou en cliquant sur Mes Applications puis Interventions puis suivis des interventions
    And Cliquer sur l'icône Nouvelle intervention
    And Checker les champs renseignes par défaut ci-dessous ce numéro est généré automatiquement et il est unique
    And Statut : DICREEE
  Scenario: verif des données
    Given user launch chrome browser
    And User opens URL " http://10.4.1.197/maximo"
    And User enters Nom d'utilisateur as "POCTESTING" and Mot de passe  as "p0cTESTING"
    And Click on Ouvrir une session
    Given Accéder à l'application Interventions depuis le menu Favoris au niveau de l'écran d'accueil ou en cliquant sur Mes Applications puis Interventions puis suivis des interventions
    And Cliquer sur l'icône Nouvelle intervention
    And Date du statut : Date du jour
    And Renseigner le champ obligatoire Clé actif Exemple : "1002" et sauvegarder
    And Accéder à la section Journal et cliquer sur Nouvelle ligne
    And Cliquer sur la loupe du type
    And Choisir un type dans la liste de valeur
    And Saisir un Libellé pour votre intervention champ Libellé exemple: "2001" à partir de l'onglet journal
    And Sauvegarder l'intervention en cliquant sur la disquette sur la barre d'outil
    When verifier le message de  sauvgarde
    And verifier le message de statut
  Scenario: changement du statut
    Given user launch chrome browser
    And User opens URL " http://10.4.1.197/maximo"
    And User enters Nom d'utilisateur as "POCTESTING" and Mot de passe  as "p0cTESTING"
    And Click on Ouvrir une session
    Given Accéder à l'application Interventions depuis le menu Favoris au niveau de l'écran d'accueil ou en cliquant sur Mes Applications puis Interventions puis suivis des interventions
    And selectionner l'intervention intervention
    When Changer le statut de l'intervention à Non-Affecter et  pour cela:Cliquer sur l'icône de changement de statut sur la barre d'outil
    Then Sur le pop-up qui s'ouvre: Renseigner le champ "Nouveau statut" en sélectionnant le statut : "En attente de planification"
    And Cliquer sur le bouton Valider
    And verifier le message du changement de statut
    Given Cliquer sur la liste Sélectionner une action puis choisir Sélectionner le propriétaire
    And Cliquer sur Filtre puis écrire "CA" puis cliquer sur loop
    And Sélectionner le site
    When  Cliquer sur l'icône de changement de statut sur la barre d'outil
    Then   Sur le pop-up qui s'ouvre:Renseigner le champ "Nouveau statut" en sélectionnant le statut :terminé
    And  verifier le message du changement de statut
    And Se déconnecter de GMAO/Osmose en cliquant sur le bouton Se Déconnecter en haut à droite