/**
 * La classe représentant une adresse. On considère que l'adresse est une adresse française.
 * @author Bastien Malhere, Gabin Pruvost--Couvreur
 * @version 3.0
 * @since 1.0
 */
public class Adresse {

    private String rue;
    private int numDeRue;
    private int etage;
    private String ville;
    private int codePostal;

    /**
     * Constructeur d'adresse prenant un étage.
     * @param rue
     * @param numDeRue
     * @param etage
     * @param ville
     * @param codePostal
     */
    public Adresse(String rue, int numDeRue, int etage, String ville, int codePostal) {
        this.rue = rue;
        this.numDeRue = numDeRue;
        this.etage = etage;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    /**
     * Constructeur d'adresse ne prenant pas d'étage. Etage est donc 0.
     * @param rue
     * @param numDeRue
     * @param ville
     * @param codePostal
     */
    public Adresse(String rue, int numDeRue, String ville, int codePostal) {
        this.rue = rue;
        this.numDeRue = numDeRue;
        this.etage = 0;
        this.ville = ville;
        this.codePostal = codePostal;
    }

    /**
     * Constructeur d'adresse vide
     */
    public Adresse(){
        this.rue = "";
        this.numDeRue = 0;
        this.etage = 0;
        this.ville = "";
        this.codePostal = 0;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumDeRue() {
        return numDeRue;
    }

    public void setNumDeRue(int numDeRue) {
        this.numDeRue = numDeRue;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresseString() {
        return getNumDeRue() + " " + getRue() + ", " + getCodePostal() + " - " + getVille();
    }
}
