/**
 * Un Etudiant. Il hérite d'Adherent, et à un numéro d'étudiant et une méthode inscrire() différente
 * @author Bastien Malhere, Gabin Pruvost-Couvreur
 * @version 3.0
 * @since 1.0
 * @see Adherent
 * @see Adresse
 */
public class Etudiant extends Adherent implements Personne {
    private final int MONTANT_COT = 20;

    private int numeroEtudiant;

    /**
     * On crée un salarié avec un nombre d'emprunt et un salaire brut
     * @param nom Nom du salarié
     * @param prenom Prénom du salarié
     * @param adresse Adresse du salarié
     * @param telephone Téléphone du salarié
     * @param nombreEmprunts Nombres d'emprunts à la création du Salarié
     * @param numeroEtudiant Le numéro d'étudiant de l'Etudiant
     */
    public Etudiant(String nom, String prenom, Adresse adresse, String telephone, int nombreEmprunts, int numeroEtudiant) {
        super(nom, prenom, adresse, telephone, nombreEmprunts);
        this.numeroEtudiant = numeroEtudiant;
    }

    /**
     * On crée un salarié avec un salaire brut. Le nombre d'emprunt est initialisé à 0.
     * @param nom Nom du salarié
     * @param prenom Prénom du salarié
     * @param adresse Adresse du salarié
     * @param telephone Téléphone du salarié
     * @param numeroEtudiant Le numéro d'étudiant de l'Etudiant
     */
    public Etudiant(String nom, String prenom, Adresse adresse, String telephone, int numeroEtudiant) {
        super(nom, prenom, adresse, telephone);
        this.numeroEtudiant = numeroEtudiant;
    }

    @Override
    public int calculerCot() {
        System.out.println("La cotisation d'un etudiant est de " + this.MONTANT_COT + " €.");
        return this.MONTANT_COT;
    }

    public int getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(int numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }
}