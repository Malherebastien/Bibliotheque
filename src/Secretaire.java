/**
 * @author Bastien Malhere
 * @version 2.0
 * @since 2.0
 */

public class Secretaire extends Personnel implements Personne {
    private final int MONTANT_COT = 20;
    /**
     * Le constructeur de la classe personnel
     *
     * @param nom    Son nom
     * @param prenom Son prenom
     * @param age    Son age
     */
    public Secretaire(String nom, String prenom, int age) {
        super(nom, prenom, age);
    }

    @Override
    public int calculerCot() {
        System.out.println("La cotisation d'une secrétaire est de " + this.MONTANT_COT + " €.");
        return this.MONTANT_COT;
    }
}
