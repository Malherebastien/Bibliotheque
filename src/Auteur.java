import java.util.ArrayList;

/**
 * La classe représentant un auteur.
 * @author Bastien Malhere, Gabin Pruvost--Couvreur
 * @version 3.0
 * @since 1.0
 * @see Livre
 */
public class Auteur {
    /*
    En mettant cet attribut en static, il est partagé par toute les instances de la classe Auteur.
    Si un auteur est supprimé, son numéro ne sera jamais réattribué. On considère qu'il n'y aura pas plus de 2^32 auteurs.
    */
    private static int nbrAuteur;
    private int refAuteur;
    private String nom;
    private String prenom;
    private ArrayList<Livre> livresEcrits;

    /**
     * Constructeur d'auteur sans aucuns livres
     * @param nom Nom de l'auteur
     * @param prenom Prénom de l'auteur
     */
    public Auteur(String nom, String prenom) {
        Auteur.nbrAuteur++;
        this.refAuteur = Auteur.nbrAuteur;
        this.nom = nom;
        this.prenom = prenom;
        this.livresEcrits = new ArrayList<>();
    }

    /**
     * Constructeur d'auteur avec l'ensemble des livres dans une ArrayList passé en paramètre.
     * @param nom Nom de l'auteur
     * @param prenom Prénom de l'auteur
     * @param livresEcrits L'ensemble des livres écrit par l'auteur
     */
    public Auteur(String nom, String prenom, ArrayList<Livre> livresEcrits) {
        Auteur.nbrAuteur++;
        this.refAuteur = Auteur.nbrAuteur;
        this.nom = nom;
        this.prenom = prenom;
        this.livresEcrits = livresEcrits;
    }

    /**
     * Constructeur d'auteur avec un seul livre
     * @param nom Nom de l'auteur
     * @param prenom Prénom de l'auteur
     * @param livre Un livre écrit par l'auteur, il sera le premier dans l'ArrayList
     */
    public Auteur(String nom, String prenom, Livre livre) {
        Auteur.nbrAuteur++;
        this.refAuteur = Auteur.nbrAuteur;
        this.nom = nom;
        this.prenom = prenom;
        this.livresEcrits = new ArrayList<>();
        this.livresEcrits.add(livre);
    }

    public static int getNbrAuteur() {
        return nbrAuteur;
    }

    /*
    Le mutateur est 'private' car il ne doit pas être modifié. Il ne faut pas que 2 auteurs ai la même référence.
     */
    private static void setNbrAuteur(int nbrAuteur) {
        Auteur.nbrAuteur = nbrAuteur;
    }

    public int getRefAuteur() {
        return refAuteur;
    }

    public void setRefAuteur(int refAuteur) {
        this.refAuteur = refAuteur;
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

    public ArrayList<Livre> getLivresEcrits() {
        return livresEcrits;
    }

    public void setLivresEcrits(ArrayList<Livre> livresEcrits) {
        this.livresEcrits = livresEcrits;
    }

    /**
     * Ajoute un livre à la liste de livres
     * @param livre Le livre à ajouté à la liste
     * @return false si le livre est déjà dans la liste, true sinon
     */
    public boolean addLivreEcrit(Livre livre) {
        if (this.livresEcrits.contains(livre))
            return false;
        this.livresEcrits.add(livre);
        return true;
    }
}
