import java.util.ArrayList;

/**
 * La classe représentant un livre de la collection de la bibliothèque.
 * @author Bastien Malhere
 * @version 1.0
 * @since 1.0
 * @see Auteur
 */
public class Livre {
    private static int nbrLivre = 0;
    /* En mettant cet attribut en static, il est partagé par toute les instances de la classe Livre.
    Si un livre sors du stock, son numéro ne sera jamais réattribué. On considère qu'il n'y aura pas plus de 2^31 - 1 livres.
    */

    private String refLivre;
    private String titre;
    private ArrayList<Auteur> auteurs;
    private String editeur;
    private int anneeEdition;
    private boolean estDisponible; // Pour des raisons de clarté, j'ai choisi d'implementé cette variable sous forme de booleen.
    private Adherent emprunteur; // null si estDisponible est false, sinon contient l'Adherent qui à emprunter le livre.

    /**
     * Constructeur complet prenant une Liste d'auteurs et met la disponibilité à "true".
     * @param titre Le titre du livre
     * @param auteurs La liste contenant les auteurs
     * @param editeur L'editeur du livre
     * @param anneeEdition L'année d'édition du livre
     */
    public Livre(String titre, ArrayList<Auteur> auteurs, String editeur, int anneeEdition) {
        Livre.nbrLivre++;
        this.refLivre = "L" + nbrLivre;
        this.titre = titre;
        this.auteurs = auteurs;
        this.editeur = editeur;
        this.anneeEdition = anneeEdition;
        this.estDisponible = true;
    }

    /**
     * Constructeur complet prenant une Liste d'auteurs et met la disponibilité à "true".
     * @param titre Le titre du livre
     * @param auteur L'auteur du livre. Il est donc le seul membre de l'ArrayList auteurs
     * @param editeur L'editeur du livre
     * @param anneeEdition L'année d'édition du livre
     */
    public Livre(String titre, Auteur auteur, String editeur, int anneeEdition) {
        Livre.nbrLivre++;
        this.refLivre = "L" + nbrLivre;
        this.titre = titre;
        this.auteurs = new ArrayList<>();
        this.auteurs.add(auteur);
        this.editeur = editeur;
        this.anneeEdition = anneeEdition;
        this.estDisponible = true;
    }

    /*
    Le mutateur est 'private' car il ne doit pas être modifié. Il ne faut pas que 2 livres ai la même référence.
     */
    private void setRefLivre(String refLivre) {
        this.refLivre = refLivre;
    }

    public String getRefLivre(){return this.refLivre;}

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ArrayList<Auteur> getAuteurs() {
        return auteurs;
    }

    public void setAuteurs(ArrayList<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    public void addAuteur(Auteur auteur) {
        this.auteurs.add(auteur);
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public int getAnneeEdition() {
        return anneeEdition;
    }

    public void setAnneeEdition(int anneeEdition) {
        this.anneeEdition = anneeEdition;
    }

    public boolean isEstDisponible() {
        return estDisponible;
    }

    public void setEstDisponible(boolean estDisponible) {
        this.estDisponible = estDisponible;
    }

    public Adherent getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Adherent emprunteur) {
        this.emprunteur = emprunteur;
    }
}
