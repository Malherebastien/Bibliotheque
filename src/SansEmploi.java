/**
 * Un SansEmploi. Il hérite d'Adherent et une méthode inscrire() différente
 * @author Bastien Malhere
 * @version 1.0
 * @since 1.0
 * @see Adherent
 * @see Adresse
 */
public class SansEmploi extends Adherent {

    /**
     * On crée un salarié avec un nombre d'emprunt et un salaire brut
     * @param nom Nom du salarié
     * @param prenom Prénom du salarié
     * @param adresse Adresse du salarié
     * @param telephone Téléphone du salarié
     * @param nombreEmprunts Nombres d'emprunts à la création du Salarié
     */
    public SansEmploi(String nom, String prenom, Adresse adresse, String telephone, int nombreEmprunts) {
        super(nom, prenom, adresse, telephone, nombreEmprunts);
    }

    /**
     * On crée un salarié avec un salaire brut. Le nombre d'emprunt est initialisé à 0.
     * @param nom Nom du salarié
     * @param prenom Prénom du salarié
     * @param adresse Adresse du salarié
     * @param telephone Téléphone du salarié
     */
    public SansEmploi(String nom, String prenom, Adresse adresse, String telephone) {
        super(nom, prenom, adresse, telephone);
    }
}