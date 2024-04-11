package payeAuberge;

// Création de la classe Departement.
public class Departement {
    
    //Création du contructeur de la classe.
    public Departement(String nomDepartement, Double tauxHoraire){
        
        this.nomDepartement = nomDepartement;
        this.tauxHoraire = tauxHoraire;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }
    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }
    public Double getTauxHoraire() {
        return tauxHoraire;
    }
    public void setTauxHoraire(Double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    //Variables membres de la classe.
    private String nomDepartement;
    private Double tauxHoraire;

}
