@REQ_POECPR2G1-2
Feature: US2: Gestion des commandes et des informations personnelles.
	#*L’application doit gérer les commandes et les informations personnelles.*

  @POECPR2G1-33 @TESTSET_POECPR2G1-120 @PGR1
  Scenario: Vérifier que la page "My Account" présente un pavé Login.
    Given je suis sur la page MyAccount
    When je verifie le pavé Login
    Then le pavé Login est existe

  @POECPR2G1-45 @TESTSET_POECPR2G1-120 @PGR1
  Scenario: Vérifier qu’un Dashboard est présent après connexion.
    Given je suis sur la page d'acceuil
    When je saisie email "yassvega@outlook.fr"
    And je saisie Password "Groupe01/2024"
    And je clique Login
    Then je suis sur la page Dashboard

  @POECPR2G1-49 @TESTSET_POECPR2G1-120 @PGR1
  Scenario: Vérifier que la page “My Account” contient un  lien  qui redirige vers la page Adresses.
    Given je suis connectée a mon compte
    When je verifie la presence de lien Adresses
    And je clique sur le lien Adresses
    Then JE redirige vers la page Adresses

  @POECPR2G1-51 @TESTSET_POECPR2G1-120 @PGR1
  Scenario: Vérifier que la page “My Account” contient un  lien Logout qui redirige vers la page Login.
    Given je suis connectée à mon compte
    When je vérifie si un lien LogOut existe
    And je clique sur le lien Logout
    Then je redirige vers la page Login
