@REQ_POECPR2G1-1
Feature: US1: Création de compte client 
	#L’application doit permettre la création du compte client


	@POECPR2G1-27 @TESTSET_POECPR2G1-117 @PGR1
	Scenario: Vérifier qu’un pavé “register” existe sur la page
		Given j'ouvre la page My Account
		When je verifie si le pavé "Register" existe
		Then le pavé "Register" existe sur la pag

	####################################
	@POECPR2G1-44 @TESTSET_POECPR2G1-120 @TESTSET_POECPR2G1-117 @PGR1
	Scenario: Vérifier que l'utilisateur peut créer un compte en cliquant sur le bouton “REGISTER”
	    Given j'ouvre la page My Account
		When Je saisie mon nom
		And je saisie mon prenom
		And je saisie mon email "yassvega@outlook.fr"
		And je saisie mon password  "Groupe01/2024"
		And je clique sur la le boutton "REGISTER"
		Then la création de compte est validée

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