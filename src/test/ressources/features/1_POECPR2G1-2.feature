@REQ_POECPR2G1-2
Feature: US2: Gestion des commandes et des informations personnelles. 
	#*L’application doit gérer les commandes et les informations personnelles.*

		#*@POECPR2G1-33 @TESTSET_POECPR2G1-120 @PGR1*
	Scenario: Vérifier que la page "My Account" présente un pavé Login.
		Given je suis sur la page MyAccount
		When je verifie le pavé Login
		Then le pavé Login est existe
		
	@POECPR2G1-45 @TESTSET_POECPR2G1-120 @PGR1
	Scenario: Vérifier qu’un Dashboard est présent après connexion.
		Given je suis sur la page d'acceuil 
		When je saisie email
		And je saisie Password 
		And je clique Login
		Then je suis sur la page Dashboard
		
	@POECPR2G1-47 @TESTSET_POECPR2G1-120 @PGR1
	Scenario: Vérifier que la page “My Account” contient un  lien  qui redirige vers la page Order.
		Given je suis sur la page de mon compte
		When je vérifie qu'un lien Orders existe et redirige vers la page Orders
		Then un lien Orders existe est redirige vers la page Orders
		
	@POECPR2G1-48 @TESTSET_POECPR2G1-120 @PGR1
	Scenario: Vérifier que la page “My Account” contient un  lien  qui redirige vers la page Download
		Given je suis sur la page MyAccount 
		When je verifie la presence du lien Downloads
		And je clique sur le lien Downloads
		Then JE redirige vers la page Downloads
		
	@POECPR2G1-49 @TESTSET_POECPR2G1-120 @PGR1
	Scenario: Vérifier que la page “My Account” contient un  lien  qui redirige vers la page Adresses.
		Given je suis sur la page MyAccount 
		When je verifie la presence de lien Adresses
		And je clique sur le lien Adresses
		Then JE redirige vers la page Adresses
		
	@POECPR2G1-50 @TESTSET_POECPR2G1-120 @PGR1
	Scenario: Vérifier que la page “My Account” contient un  lien  qui redirige vers la page Account Details.
		Given je suis sur la page de mon compte
		When je vérifie qu'un lien qui redirige vers la page Account detail existe
		Then le lien Account existe et redirige vers la page Account détails
		
	@POECPR2G1-51 @TESTSET_POECPR2G1-120 @PGR1
	Scenario: Vérifier que la page “My Account” contient un  lien Logout qui redirige vers la page Login.
		Given je suis sur la page de mon compte
		When je vérifie si un lien LogOut existe et redirige vers la page My Account
		Then le lien Logout existe sur la page et redirige vers la page My Account
		
	@POECPR2G1-52 @TESTSET_POECPR2G1-120 @PGR1
	Scenario:  La page "My Account"doit afficher un  message d'erreur lors de la connexion avec un mot de passe incorrect.
		Given je suis sur le pavé Login
		When je saisie un email
		And je saisie un mot passe incorrect
		Then Un message d'erreur s'affiche dans la page MyAccount
		
	@POECPR2G1-53 @TESTSET_POECPR2G1-120 @PGR1
	Scenario: La page “My Account” doit contenir une case à cocher “Remember me”
		Given je suis sur la page My Account
		When je vérifie si une case à cocher "Remmember me" existe sur la page
		Then une case à cocher "Remmember me" existe sur la page
		
	@POECPR2G1-102 @TESTSET_POECPR2G1-120 @PGR1
	Scenario: Vérifier qu'un bouton Login est cliquable.
		Given je suis sur la page My Account 
		When je vérifie que le bouton "login" est cliquable
		Then le bouton "login" est cliquable
		
	#Tests *L’application doit gérer les commandes et les informations personnelles.*
	@POECPR2G1-125 @PGR1
	Scenario: vérifier que en cochant "Remember me"" permet de garder son login pré-rempli à la prochaine connexion
		Given je suis sur la page My Account
		When je saisi mon mail
		And je saisi mon mot de passe
		And je coche la case remember me
		And je clique sur login
		And je suis sur la page de mon compte 
		And je clique sur logout pour me deconnecter
		And je suis sur la page de My Account
		And je vérifie que la case les champs Mail et Mot de passe sont prérempli
		Then les champs mail et password sont préremplis
		
