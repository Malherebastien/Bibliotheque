/**
 * Un Salarié. Il hérite d'Adherent, et à un salaire brut et une méthode inscrire() différente
 * @author Bastien Malhere
 * @version 2.0
 * @since 1.0
 * @see Adherent
 * @see Adresse
 */
public class Salarie extends Adherent implements Personne{
    private final int MONTANT_COT = 30;

    private int salaireBrut;

    /**
     * On crée un salarié avec un nombre d'emprunt et un salaire brut
     * @param nom Nom du salarié
     * @param prenom Prénom du salarié
     * @param adresse Adresse du salarié
     * @param telephone Téléphone du salarié
     * @param nombreEmprunts Nombres d'emprunts à la création du Salarié
     * @param salaireBrut Le salaire brut du Salarié
     */
    public Salarie(String nom, String prenom, Adresse adresse, String telephone, int nombreEmprunts, int salaireBrut) {
        super(nom, prenom, adresse, telephone, nombreEmprunts);
        this.salaireBrut = salaireBrut;
    }

    /**
     * On crée un salarié avec et un salaire brut. Le nombre d'emprunt est initialisé à 0
     * @param nom Nom du salarié
     * @param prenom Prénom du salarié
     * @param adresse Adresse du salarié
     * @param telephone Téléphone du salarié
     * @param salaireBrut Le salaire brut du Salarié
     */
    public Salarie(String nom, String prenom, Adresse adresse, String telephone, int salaireBrut) {
        super(nom, prenom, adresse, telephone);
        this.salaireBrut = salaireBrut;
    }

    /**
     * Inscrit un Salarié à la bibliothèque.
     * @return true si le salarié n'est pas déjà inscrit.
     */
    @Override
    public boolean inscrire() {
        // Pas encore implémenté correctement, du au manque de stockage des données de la bilbiothèque
        //TODO Implementer pour la version 2.0, avec un stockage de la Bibliothèque.
        //TODO Determiner le prix d'inscription en fonction du salaire brut
        System.out.println("Le salarié avec un salaire de : " + this.salaireBrut + " est bien inscrit");
        return true;
    }

    @Override
    public int calculerCot() {
        System.out.println("La cotisation d'un salarié est de " + this.MONTANT_COT + " €.");
        return this.MONTANT_COT;
    }
}
