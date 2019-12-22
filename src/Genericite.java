/**
 * Une classe servant à prouver que nous connaissons la généricité. Dans notre modele l'utilisation de la généricité ne
 * nous semblait pas utile, c'est pourquoi nous avons choisi de réaliser cette classe à part.
 * @param <T> Premiere valeure
 * @param <S> Seconde valeure
 */
public class Genericite<T, S> {
    private T valeur1;
    private S valeur2;

    public Genericite(T valeur1, S valeur2) {
        this.valeur1 = valeur1;
        this.valeur2 = valeur2;
    }

    public T getValeur1() {
        return valeur1;
    }

    public void setValeur1(T valeur1) {
        this.valeur1 = valeur1;
    }

    public S getValeur2() {
        return valeur2;
    }

    public void setValeur2(S valeur2) {
        this.valeur2 = valeur2;
    }

    @Override
    public String toString() {
        return "Genericite{" +
                "valeur1=" + valeur1 +
                ", valeur2=" + valeur2 +
                '}';
    }
}
