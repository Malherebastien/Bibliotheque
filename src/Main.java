import java.util.ArrayList;

public class Main {
    public static void main(String arg[]) {
        ArrayList<Adherent> adherents = new ArrayList<>();

        adherents.add(new Salarie("Malhere", "Bastien", new Adresse("rue Malouet", 2, 1, "Rouen", 76100), "0001020304", 1270));
        adherents.add(new Salarie("Duval", "Paul", new Adresse("rue des bons enfants", 9, "Rouen", 76000), "0001020305", 900));
        adherents.add(new Etudiant("Baron", "Lucas", new Adresse("Boulevard Patrick Balkany", 420, "La Saussaye", 27420), "0801020305", 69));
        adherents.add(new SansEmploi("Deltenre", "Quentin", new Adresse("Sans la fibre", 46, "Caudebec", 76320), "0801020365"));

        /*for (Adherent ad : adherents) {
            ad.inscrire();
        }*/

        ArrayList<Personne> personnes = new ArrayList<>();

        personnes.add(new Secretaire("Huet", "Timothé", 19));
        personnes.add((Salarie)adherents.get(0));
        personnes.add((Etudiant)adherents.get(2));

        for (Personne p : personnes) {
            p.calculerCot();
        }
    }
}
