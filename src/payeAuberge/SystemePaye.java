package payeAuberge;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Création de la classe SystemePaye.
public class SystemePaye {

    Scanner sc = new Scanner(System.in);

    // Variables membres de la classe.
    private List<Employe> mesEmployes;
    private List<Paye> mesPayes;

    public SystemePaye(){

        // Création de la liste mesEmployes
        mesEmployes = new ArrayList<>();
        
        // Création des objets emmagasinés dans la liste mesEmployes.
        Employe emp1 = new Employe("E0001", "Mivania", "Henry", 1, null);
        Employe emp2 = new Employe("E0002", "Sandra", "Léger", 2, null);
        Employe emp3 = new Employe("E0003", "Bob", "Gratton", 3, null);
        Employe emp4 = new Employe("E0004", "Sylvie", "Lamarre", 4, null);

        mesEmployes.add(emp1);
        mesEmployes.add(emp2);
        mesEmployes.add(emp3);
        mesEmployes.add(emp4);

    // Création de la liste mesPayes
        mesPayes = new ArrayList<>();

        // Création des objets emmagasinés dans la liste mesEmployes.
        Paye paie1 = new Paye(1, emp1, 8.50, 25.00, null, 0.0, 10.52, 4.20, 212.50);
        Paye paie2 = new Paye(1, emp2, 12.50, 35.00, null, 0.0, 21.65, 8.66, 437.50);
        Paye paie3 = new Paye(1, emp3, 15.75, 45.00, null, 1.00, 35.32, 14.12, 716.63);
        Paye paie4 = new Paye(1, emp4, 15.00, 37.50, 10000.00, 0.0, null, null, 712.00);

        mesPayes.add(paie1);
        mesPayes.add(paie2);
        mesPayes.add(paie3);
        mesPayes.add(paie4);

    }

    // ********************** Méthodes de la classe *********************

    public void afficherEmployes() {
        System.out.println("***** Liste des employés *****\n");
        if (mesEmployes.isEmpty()) {
            System.out.println("Aucun employé trouvé.");
        } else {
            for (Employe emp : mesEmployes) {
                System.out.println("ID : " + emp.getIdEmploye());
                System.out.println("Prénom : " + emp.getPrenom());
                System.out.println("Nom : " + emp.getNom());
                System.out.println("Numéro de département : " + emp.getIdDepartement());
                System.out.println("______________________________");
            }
        }  
    }

    // Ajout d'un employé dans le système.
    public boolean ajouterEmploye(Employe emp){
        for(Employe employe : mesEmployes){
            if (employe.getIdEmploye().equals(emp.getIdEmploye())){
                return false;
            }
        }
        return mesEmployes.add(emp);
    }

    // Ajouter une paye dans le système.
    public boolean ajouterPaye(Paye paye){
        for(Paye paie : mesPayes){
            if (paie.getIdEmploye().equals(paye.getIdEmploye())){
                return false;
            }
        }
        return mesPayes.add(paye);
    }

    // Méthode créée afin de pouvoir vérifier si l'employé ajouté existe déjà dans le système.
    public Employe trouverIdEmploye(String idEmploye) {
        for (Employe emp : mesEmployes) {
            if (emp.getIdEmploye().equals(idEmploye)) {
                return emp;
            }
        }
        return null; // Si l'employé recherché n'est pas retrouvé.
    }

    // Établissement du taux horaire par département.
    public double tauxHoraireDep(int idDepartement) {
        
        switch (idDepartement) {
            
            case 1:
                return 8.50;
            case 2:
                return 12.50;
            case 3:
                return 15.75;
            case 4:
                return 15.00;
            default:
                return 0.0;
        }
    }

    // Affichage du total des contributions au RRC.
    public void afficherRRC() {
        double totalRRC = 0.0;
        for (Paye paye : mesPayes) {
            totalRRC += paye.getRRC();
        }

        System.out.println("Le total des contributions au Régime de Retraite du Canada est de : " + 
        String.format("%.2f", totalRRC) + " $."); //Garder le format à 2 décimales.
    }

    // Affichage du total des contributions à l'AE.
    public void afficherAE() {
        double totalAE = 0.0;
        for (Paye paye : mesPayes) {
            totalAE += paye.getAE();
        }
    
        System.out.println("Le total des contributions à l'assurance emploi est de : " + 
        String.format("%.2f", totalAE) + " $.");
    }

    // Établissement de la boucle qui va aller récupérer tous les employés à taux fixe.
    public void afficherEmpFixe(){

        System.out.println("***** Employés à taux fixe ***** \n");   
        for (Paye paye : mesPayes) {
            Employe emp = trouverIdEmploye(paye.getIdEmploye()); // Getter qui a été créé de la variable emp.getIdEmploye() qui découle de l'objet Employe.
            if (emp != null && emp.getIdDepartement() != 4) {
                System.out.println("Employee ID: " + emp.getIdEmploye());
                System.out.println("Employee Name: " + emp.getPrenom() + " " + emp.getNom());
                System.out.println("Heures supplémentaires : " + paye.getHeuresSup() + " heures");
                System.out.println("______________________________");
            }
        }
    }
    
    // Établissement de la boucle qui va aller récupérer tous les employés à la commission.
    public void afficherEmpCom(){
        
        System.out.println("***** Employés à la commission ***** \n"); 
        for (Paye paye : mesPayes) {
            Employe emp = trouverIdEmploye(paye.getIdEmploye()); // Getter qui a été créé de la variable emp.getIdEmploye() qui découle de l'objet Employe.
            if (emp != null && emp.getIdDepartement() == 4) {
                System.out.println("ID de l'employé : " + emp.getIdEmploye());
                System.out.println("Nom de l'employé : " + emp.getPrenom() + " " + emp.getNom());
                System.out.println("Ventes brutes " + paye.getTotalVentes() + " $");
                System.out.println("______________________________");
            }
        }
    }

}
