package payeAuberge;

// Création de la classe Paye.
public class Paye {
    
    // Création du constructeur de la classe.

    public Paye(int numSemaine, Employe emp, Double tauxHoraire, Double nbHeures, Double totalVentes,
    Double heuresSup, Double RRC, Double AE, Double salaireBrut){
        
        this.numSemaine = numSemaine;
        // Accès à la variable idEmploye par l'objet emp.
        this.idEmploye = emp.getIdEmploye(); 
        this.tauxHoraire = tauxHoraire;
        this.nbHeures = nbHeures;
        this.totalVentes = totalVentes;
        this.heuresSup = heuresSup;
        this.RRC = RRC;
        this.AE = AE;
        this.salaireBrut = salaireBrut;

    }

    // Getters et setters de la classe.
    public int getNumSemaine() {
        return numSemaine;
    }
    public void setNumSemaine(int nbSemaine) {
        this.numSemaine = nbSemaine;
    }
    public Double getTauxHoraire() {
        return tauxHoraire;
    }
    public void setTauxHoraire(Double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }
    public Double getNbHeures() {
        return nbHeures;
    }
    public void setNbHeures(Double nbHeures) {
        this.nbHeures = nbHeures;
    }
    public Double getTotalVentes() {
        return totalVentes;
    }
    public void setTotalVentes(Double totalVentes) {
        this.totalVentes = totalVentes;
    }
    public Double getHeuresSup() {
        return heuresSup;
    }
    public void setHeuresSup(Double heuresSup) {
        this.heuresSup = heuresSup;
    }
    public Double getRRC() {
        return RRC;
    }

    public Double getAE() {
        return AE;
    }
 
    public Double getSalaireBrut() {
        return salaireBrut;
    }
    public void setSalaireBrut(Double salaireBrut) {
        this.salaireBrut = salaireBrut;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    // Variables membres de la classe.
    private int numSemaine;
    private String idEmploye;
    private Double tauxHoraire;
    private Double nbHeures;
    private Double totalVentes;
    private Double heuresSup;
    private Double RRC;
    private Double AE;
    private Double salaireBrut;
}
