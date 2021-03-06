import java.util.ArrayList;

/**
 * La classe représentant un adhérent de la bibliothèque. Elle est abstraite, car on ne veux pas qu'elle soit instanciable.
 * @author Bastien Malhere, Gabin Pruvost-Couvreur
 * @version 3.0
 * @since 1.0
 * @see Adresse
 * @see Livre
 */
public abstract class Adherent {
    private static int nbrAdherent;
    /* En mettant cet attribut en static, il est partagé par toute les instances de la classe Adherent.
    Si un adhérent est supprimé, son numéro ne sera jamais réattribué. On considère qu'il n'y aura pas plus de 2^32 adhérents.
    */

    private int refAdherent;
    private String nom;
    private String prenom;
    private Adresse adresse;
    private String telephone;
    private int nombreEmprunts;
    private ArrayList<Livre> livresEmpruntes;

    /**
     * Constructeur d'adherent avec tout les paramètres.
     * @param nom Nom de l'adhérent
     * @param prenom Prénom de l'adhérent
     * @param adresse Adresse de l'adhérent
     * @param telephone Numéro de telephone de l'adhérent
     * @param nombreEmprunts Le nombre d'emprunts lors de la création
     */
    public Adherent(String nom, String prenom, Adresse adresse, String telephone, int nombreEmprunts) {
        Adherent.nbrAdherent++;
        this.refAdherent = nbrAdherent;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.nombreEmprunts = nombreEmprunts;
        this.livresEmpruntes = new ArrayList<>();
    }

    /**
     * Constructeur d'adherent avec tout les paramètres.
     * @param nom Nom de l'adhérent
     * @param prenom Prénom de l'adhérent
     * @param adresse Adresse de l'adhérent
     * @param telephone Numéro de telephone de l'adhérent
     */
    public Adherent(String nom, String prenom, Adresse adresse, String telephone) {
        Adherent.nbrAdherent++;
        this.refAdherent = nbrAdherent;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.nombreEmprunts = 0;
        this.livresEmpruntes = new ArrayList<>();
    }

    public int getRefAdherent() {
        return refAdherent;
    }

    /*
    Le mutateur est 'private' car il ne doit pas être modifié. Il ne faut pas que 2 adhérents ai la même référence.
     */
    private void setRefAdherent(int refAdherent) {
        this.refAdherent = refAdherent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getNombreEmprunts() {
        return nombreEmprunts;
    }

    public void setNombreEmprunts(int nombreEmprunts) {
        this.nombreEmprunts = nombreEmprunts;
    }

    public ArrayList<Livre> getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public void setLivresEmpruntes(ArrayList<Livre> livresEmpruntes) {
        this.livresEmpruntes = livresEmpruntes;
    }
}
