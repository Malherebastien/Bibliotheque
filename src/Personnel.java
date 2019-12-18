/**
 * @author Bastien Malhere, Gabin Pruvost-Couvreur
 * @version 3.0
 * @since 3.0
 */
public abstract class Personnel {
    private String nom;
    private String prenom;
    private int age;

    /**
     * Le constructeur de la classe personnel
     * @param nom Son nom
     * @param prenom Son prenom
     * @param age Son age
     */
    public Personnel(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
