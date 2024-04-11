package payeAuberge;

// Création de la classe, Employe.
public class Employe {

        // Création du constructeur pour la classe.
        public Employe(String idEmploye, String prenom, String nom, int idDepartement, String listePayes){
           
            this.idEmploye = idEmploye;
            this.prenom = prenom;
            this.nom = nom;
            this.idDepartement = idDepartement;
            this.listePayes = listePayes;
        }

        // Getters et setters de la classe.
        public String getIdEmploye() {
            return idEmploye;
        }
        public void setIdEmploye(String idEmploye) {
            this.idEmploye = idEmploye;
        }
        
        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public int getIdDepartement() {
            return idDepartement;
        }
        public void setIdDepartement(int idDepartement) {
            this.idDepartement = idDepartement;
        }

        public String getListePayes() {
            return listePayes;
        }

        public void setListePayes(String listePayes) {
            this.listePayes = listePayes;
        }

        // Méthodes de la classe.
        public void lierDepartement(){

        }

        public void ajouterPaye(){

        }

        //Variables membres de la classe.
        private String idEmploye;
        private String prenom;
        private String nom;
        private int idDepartement;
        private String listePayes;



}