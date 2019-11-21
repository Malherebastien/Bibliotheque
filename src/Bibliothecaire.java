/**
 * @author Bastien Malhere
 * @version 2.0
 * @since 2.0
 */
public class Bibliothecaire extends Personnel implements Personne{
    private final int MONTANT_COT = 15;

    /**
     * Le constructeur de la classe personnel
     *
     * @param nom    Son nom
     * @param prenom Son prenom
     * @param age    Son age
     */
    public Bibliothecaire(String nom, String prenom, int age) {
        super(nom, prenom, age);
    }

    @Override
    public int calculerCot() {
        System.out.println("La cotisation d'une bibliothecaire est de " + this.MONTANT_COT + " €.");
        return this.MONTANT_COT;
    }
}
