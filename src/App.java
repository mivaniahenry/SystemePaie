import java.util.Scanner;
import payeAuberge.*;

public class App {

    public static void main(String[] args) throws Exception { 
        
        Scanner sc = new Scanner(System.in);
        int choix;

        // Création de l'objet SystemePaye.
        SystemePaye systemePaye = new SystemePaye();

        do{
            System.out.print("\n ========== Bienvenue à l'Auberge Fleur de Lys ! ==========  \n" + "\n" +
                            
            "1- Ajouter un employé \n" +
            "2- Ajouter une paye \n" +
            "3- Afficher le total des contributions au Régime de Retraite du Canada \n" +
            "4- Afficher le total des contributions à l'assurance emploi \n" +
            "5- Liste des employés à taux fixe (ID, nom et heures supplémentaires) \n" +
            "6- Liste des employés à commission (ID, nom et ventes brutes) \n" +
            "7- Afficher tous les employés \n" +
            "8- Quitter \n \n" + 
            "Veuillez choisir une option : ");
            choix = sc.nextInt();

            // Options aux choix de l'utilisateur
            switch(choix){

                case 1:

                String reponse = "";

                // La boucle continue tant et aussi longtemps que l'utilisateur choisi un option autre que "n".
                while(!reponse.equalsIgnoreCase("n")) { 
                // Ajout d'un employé
                System.out.println("***** Ajouter un employé ***** \n");
                System.out.print("ID : ");
                String idEmploye = sc.nextLine();
                sc.nextLine();
                System.out.print("Prénom : ");
                String prenom = sc.nextLine();
                System.out.print("Nom : ");
                String nom = sc.nextLine();
                System.out.println("Numéro de département : \n" + "\n" +
                                   "1. Restaurants - 8.50$ \n" +
                                   "2. Maintenance - 12.50$ \n" +
                                   "3. Commis/Paysagiste - 15.75$ \n" +
                                   "4. Ventes - $15.00");
                int idDepartement = sc.nextInt();
                sc.nextLine();
                
                // Sélection du département par l'utilisateur.
                switch (idDepartement) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Saisie invalide.");
                        return;
                        }
                        
                //Création de l'objet emp et ajout d'un employé, à l'aide de la classe SystemePaye.
                Employe emp = new Employe(idEmploye, prenom, nom, idDepartement, null);
                systemePaye.ajouterEmploye(emp);
                
                System.out.println("L'employé a été ajouté avec succès !");
                
                // Option d'ajout d'un autre employé.
                System.out.print("Voulez-vous ajouter un autre employé ? (o/n)");
                reponse = sc.nextLine();
                }
                    

                    // Option de revenir au menu si l'utilisateur décide de ne plus faire d'ajout d'employé.
                    System.out.print("Voulez-vous retourner au menu? (o/n)");
                    String menu = sc.nextLine();

                    // Si l'utilisateur sélectionne autre chose que "o", sortie de la boucle et fin du programme.
                    if(!menu.equalsIgnoreCase("o")) { 
                        choix = 8;
                        System.out.println("Vous avez quitté. Au revoir !");
                    }        
                break;

                case 2:
                    
                    // Appel de la méthode d'ajout de la paie située dans la classe SystemePaye.
                    reponse = "";

                    // La boucle continue tant et aussi longtemps que l'utilisateur choisi un option autre que "n".
                    while(!reponse.equalsIgnoreCase("n")) { 
            
                        // Ajout d'une paye
                        System.out.println("***** Ajouter une paye ***** \n");
                        System.out.print("Numéro de semaine :");
                        int numSemaine = sc.nextInt();
                        sc.nextLine();
            
                        // Variable vérificatrice afin de 
                        boolean empTrouve = false;
            
                        do{
                            System.out.print("ID de l'employé : ");
                            String idEmploye = sc.nextLine();
            
                            // Confirmation de la présence de l'employé dans le système.
                            Employe emp = systemePaye.trouverIdEmploye(idEmploye);
                            if (emp == null) {
                                System.out.println("Impossible de retrouver cet employé.");
                                } else {
                                empTrouve = true;
            
                                System.out.print("Nombre d'heures travaillées : ");
                                Double nbHeures = sc.nextDouble();
                                sc.nextLine();
            
                                // Établissement du taux horaire par département.
                                Double tauxHoraire = systemePaye.tauxHoraireDep(emp.getIdDepartement());
            
                                // Calcul du temps supplémentaire pour tous les départements excluant celui de la Vente.
                                Double heuresSup = 0.0;
                                if (emp.getIdDepartement() != 4) {
                                    if (nbHeures > 44) {
                                        heuresSup = nbHeures - 44;
                                        nbHeures = (double) 44;
                                    }
            
                                System.out.print("Total des ventes pour la période :");
                                Double totalVentes = sc.nextDouble();
                                sc.nextLine();
            
            
                                double RRC = 0.0495 * (nbHeures * tauxHoraire + heuresSup * tauxHoraire * 1.5);
                                double AE = 0.0198 * (nbHeures * tauxHoraire + heuresSup * tauxHoraire * 1.5);
                                double salaireBrut = nbHeures * tauxHoraire + heuresSup * tauxHoraire * 1.5 + totalVentes * 0.015;
                                double salaireNet = salaireBrut - (RRC + AE);

                                // Création de l'objet Paye.
                                Paye paye = new Paye(numSemaine, emp, tauxHoraire, nbHeures, totalVentes, heuresSup, 0.0, 0.0, 0.0);
            
                                // Compilation de la paye.
                                systemePaye.ajouterPaye(paye);
            
                                System.out.println("\n La paye a été ajoutée avec succès ! \n");
                                System.out.println("");
                                System.out.println("Numéro de semaine : " + paye.getNumSemaine());
                                System.out.println("Id de l'employé : " + paye.getIdEmploye());
                                System.out.println("Prénom et nom de l'employé : " + emp.getPrenom() + " " + emp.getNom());
                                System.out.println("Salaire brut de l'employé : " + String.format("%.2f", salaireBrut)); // Troncaturé à 2 décimales.
                                System.out.println("Contribution au RRC : " + String.format("%.2f", RRC));
                                System.out.println("Contribution à l'AE : " + String.format("%.2f", AE) + "\n");
                                System.out.println("************************************ \n");
                                System.out.println("Salaire net : " + String.format("%.2f", salaireNet) + " $. \n");
                                System.out.println("************************************");

                                }else{
                                    System.out.println("Impossible de retrouver cet employé.");
                                }
                            }
            
                        } while (!empTrouve);
            
                        // Option d'ajout d'un autre employé.
                        System.out.print("Voulez-vous ajouter un autre paye? (o/n)");
                        reponse = sc.nextLine();
                    }
                
                    // Option de revenir au menu.
                    System.out.print("Voulez-vous retourner au menu? (o/n)");
                    menu = sc.nextLine();
            
                    // Si l'utilisateur sélectionne autre chose que "o", sortie de la boucle et fin du programme.
                    if(!menu.equalsIgnoreCase("o")) { 
                        choix = 8;
                        System.out.println("Vous avez quitté. Au revoir !");
                    } 
                break;

                case 3:

                    // Appel de la méthode d'affichage des contributions au RRC.
                    systemePaye.afficherRRC();

                    // Option de revenir au menu.
                    System.out.print("Voulez-vous retourner au menu? (o/n)");
                    sc.nextLine();
                    menu = sc.nextLine();
            
                    // Si l'utilisateur sélectionne autre chose que "o", sortie de la boucle et fin du programme.
                    if(!menu.equalsIgnoreCase("o")) { 
                        choix = 7;
                        System.out.println("Vous avez quitté. Au revoir !");
                    } 
                break;

                case 4:

                    // Appel de la méthode d'affichage des contributions à l'AE.
                    systemePaye.afficherAE();

                    // Option de revenir au menu.
                    System.out.print("Voulez-vous retourner au menu? (o/n)");
                    sc.nextLine();
                    menu = sc.nextLine();
            
                    // Si l'utilisateur sélectionne autre chose que "o", sortie de la boucle et fin du programme.
                    if(!menu.equalsIgnoreCase("o")) { 
                        choix = 8;
                        System.out.println("Vous avez quitté. Au revoir !");
                    } 
                break;

                case 5:

                    // Affichage de la liste des employés à taux fixe.
                    systemePaye.afficherEmpFixe();

                    // Option de revenir au menu.
                    System.out.print("Voulez-vous retourner au menu? (o/n)");
                    sc.nextLine();
                    menu = sc.nextLine();
            
                    // Si l'utilisateur sélectionne autre chose que "o", sortie de la boucle et fin du programme.
                    if(!menu.equalsIgnoreCase("o")) { 
                        choix = 8;
                        System.out.println("Vous avez quitté. Au revoir !");
                    } 
                break;

                case 6:

                    // Affichage de la liste des employés à la commission.
                    systemePaye.afficherEmpCom();

                    // Option de revenir au menu.
                    System.out.print("Voulez-vous retourner au menu? (o/n)");
                    sc.nextLine();
                    menu = sc.nextLine();
          
                    // Si l'utilisateur sélectionne autre chose que "o", sortie de la boucle et fin du programme.
                    if(!menu.equalsIgnoreCase("o")) { 
                        choix = 8;
                        System.out.println("Vous avez quitté. Au revoir !");
                    } 
                break;

                case 7:
                    // Affichage de tous les employés
                    systemePaye.afficherEmployes();
                    
                    // Option de revenir au menu.
                    System.out.print("Voulez-vous retourner au menu? (o/n)");
                    sc.nextLine();
                    menu = sc.nextLine();
            
                    // Si l'utilisateur sélectionne autre chose que "o", sortie de la boucle et fin du programme.
                    if(!menu.equalsIgnoreCase("o")) { 
                        choix = 8;
                        System.out.println("Vous avez quitté. Au revoir !");
                    } 
                break;

                case 8:
                    // Sortie du programme.
                    System.out.println("Vous avez quitté. Au revoir !");
                break;

                default: 
                    // Si toutes autre données sont saisies que les cases 1 à 8.
                    System.out.println("Entrée invalide. Veuillez choisir à nouveau.");
            }

        }while(choix !=8);

        sc.close();
    }
}
