import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
/**
 * Le controlleur de l'application graphique avec le pattern MVC
 * @author Bastien Malhere, Gabin Pruvost-Couvreur
 * @version 3.0
 * @since 3.0
 * @see View
 */

public class Modele extends Observable {

    private HashMap<String, Adherent> hmAdherents;
    private HashMap<String, Livre> hmLivres;
    private HashMap<String, Personnel> hmPersonnel;

    public Modele() {
        this.hmAdherents = new HashMap<String, Adherent>();
        this.hmLivres = new HashMap<String, Livre>();
        this.hmPersonnel = new HashMap<String, Personnel>();
    }

    /**
     * Ajoute un adherent Etudiant
     * @param nom Nom de l'etudiant
     * @param prenom Prenom de l'etudiant
     * @param adresse Adresse de l'etudiant
     * @param numEtu Le numéro de l'étudiant
     * @param tel Le téléphone de l'etudiant
     */
    public void addEtudiant(String nom, String prenom, Adresse adresse, String numEtu, String tel){
        String ref = "A" + String.format("%05d", hmAdherents.size() + 1);
        hmAdherents.put(ref, new Etudiant(nom, prenom, adresse, tel, Integer.parseInt(numEtu)));

        createJPanel(prenom, ref);
    }

    /**
     * Ajoute un adherent Salarie
     * @param nom Nom de l'etudiant
     * @param prenom Prenom de l'etudiant
     * @param adresse Adresse de l'etudiant
     * @param salaireBrut Le numéro de l'étudiant
     * @param tel Le téléphone de l'etudiant
     */
    public void addSalarie(String nom, String prenom, Adresse adresse, String salaireBrut, String tel){
        String ref = "A" + String.format("%05d", hmAdherents.size() + 1);
        hmAdherents.put(ref, new Salarie(nom, prenom, adresse, tel, Integer.parseInt(salaireBrut)));

        createJPanel(prenom, ref);
    }

    /**
     * Ajoute un adherent Sans-Emploi
     * @param nom Nom du sans-emploi
     * @param prenom Prenom du sans-emploi
     * @param adresse Adresse du sans-emploi
     * @param tel Le téléphone du sans-emploi
     */
    public void addSansEmploi(String nom, String prenom, Adresse adresse, String tel){
        String ref = "A" + String.format("%05d", hmAdherents.size() + 1);
        hmAdherents.put(ref, new SansEmploi(nom, prenom, adresse, tel));

        createJPanel(prenom, ref);
    }

    /**
     * Ajoute un personnel Directeur
     * @param nom Nom du personnel
     * @param prenom Prenom du personnel
     * @param age Age du personnel
     */
    public void addDirecteur(String nom, String prenom, String age) {
        String ref = "I" + String.format("%05d", hmPersonnel.size() + 1);
        hmPersonnel.put(ref, new Directeur(nom, prenom, Integer.parseInt(age)));

        createJPanel(prenom, ref);
    }

    /**
     * Ajoute un personnel Secretaire
     * @param nom Nom du personnel
     * @param prenom Prenom du personnel
     * @param age Age du personnel
     */
    public void addSecretaire(String nom, String prenom, String age) {
        String ref = "I" + String.format("%05d", hmPersonnel.size() + 1);
        hmPersonnel.put(ref, new Secretaire(nom, prenom, Integer.parseInt(age)));

        createJPanel(prenom, ref);
    }

    /**
     * Ajoute un personnel Bibliothecaire
     * @param nom Nom du personnel
     * @param prenom Prenom du personnel
     * @param age Age du personnel
     */
    public void addBibliothecaire(String nom, String prenom, String age) {
        String ref = "I" + String.format("%05d", hmPersonnel.size() + 1);
        hmPersonnel.put(ref, new Bibliothecaire(nom, prenom, Integer.parseInt(age)));

        createJPanel(prenom, ref);
    }

    /**
     * Cree le JPanel qui affiche le message indiquant la réussite de l'inscription et le code d'adhérent
     * @param prenom Prenom de la personne inscrite, afin de l'écrire
     * @param ref Reférence de l'adherent
     */
    private void createJPanel(String prenom, String ref) {
        final JPanel jp = new JPanel();
        JOptionPane.showMessageDialog(jp, "Incription réussie " + prenom + "! Le code d'adhérent qui vous a été attribué est : " +
                ref, "Inscription réussie", JOptionPane.INFORMATION_MESSAGE);
    }

    //TODO Cree une message d'affichage en cas d'erreur

    /**
     * Crée un livre et l'ajoute à la hashmap de livres si le livre à un seul auteur
     * @param titre Le titre du livre
     * @param auteur L'auteur du livre
     * @param editeur L'editeur du livre
     * @param anneeEdition l'année d'edition du livre
     */
    public void addLivre(String titre, Auteur auteur, String editeur, String anneeEdition){
        String ref = "L" + (hmLivres.size() + 1);
        hmLivres.put(ref, new Livre(titre, auteur, editeur, Integer.parseInt(anneeEdition)));
        final JPanel jp = new JPanel();
        JOptionPane.showMessageDialog(jp, titre + " ajouté à la bibliothèque avec la référence : " +
                ref, "Inscription réussie", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * L'adherent avec le numero refAdherent demande l'emprunt du livre refLivre. Si la reference du livre n'est pas
     * remplie on recherchera en fonction des autres paramètres (titre, auteur, editeur, annéeEdition)
     * @param refAdherent La référence de l'adhérent souhnaitant emprunter
     * @param refLivre La référence du livre demandant à être emprunté
     * @param titre Le titre du livre demandé
     * @param auteur L'auteur du livre demandé
     * @param editeur L'editeur du livre demandé
     * @param anneeEdition L'année d'edition du livre demandé
     * @return True si le livre existe et est disponible, false sinon
     */
    public boolean demandeEmprunt(String refAdherent, String refLivre, String titre, String auteur, String editeur, String anneeEdition){
        if(refAdherent.equals("")){
            errorMessage("refAEmprunt");
            return false;
        }
        if(!refLivre.equals("")){
            if(hmLivres.get(refLivre)!=null){
                if(hmAdherents.get(refAdherent)!= null){
                    empruntRefRef(refLivre, refAdherent);
                    return true;
                } else {
                    errorMessage("refAEmprunt");
                    return false;
                }
            } else {
                errorMessage("refLEmprunt");
                return false;
            }
        } else{
            if(titre.equals("") && auteur.equals("") && editeur.equals("") && anneeEdition.equals("")){
                errorMessage("infoEmprunt");
                return false;
            } else {
                rechercheLivre(refAdherent, titre, auteur, editeur, anneeEdition);
            }
        }
        return true;
    }

    /**
     * Recherche un livre
     * @param refAdherent La référence adhérent. Pas utilisé dans la recherche mais à passer
     * @param titre Le titre du livre recherché
     * @param auteur L'auteur du livre recherché
     * @param editeur L'editeur du livre recherché
     * @param anneeEdition L'annee d'édition du livre recherché
     */
    private void rechercheLivre(String refAdherent, String titre, String auteur, String editeur, String anneeEdition) {
        ArrayList<Livre> alLivresTrouve = new ArrayList<Livre>();
        for(Livre livre : hmLivres.values()) {
            boolean trouve = (!titre.equals("") && !titre.equals(livre.getTitre())) ||
                    (!auteur.equals("") && !auteur.equals(livre.getAuteurs().get(0).getNom())) ||
                    (!editeur.equals("") && !editeur.equals(livre.getEditeur())) ||
                    (!anneeEdition.equals("") && !anneeEdition.equals(livre.getAnneeEdition()+""));

            if(!trouve)
                alLivresTrouve.add(livre);
        }

        if (alLivresTrouve.size() == 0)
            errorMessage("AucunLivre");
        else
            new AffLivres(alLivresTrouve, this, refAdherent).display();
    }

    /**
     * Fait un emprunt en passant la ref d'un adherent et celle d'un livre
     * @param refLivre Reference d'un livre
     * @param refAdherent Reference d'un adherent
     */
    public void empruntRefRef(String refLivre, String refAdherent) {
        if(hmLivres.get(refLivre).isEstDisponible()){
            hmAdherents.get(refAdherent).getLivresEmpruntes().add(hmLivres.get(refLivre));
            hmLivres.get(refLivre).setEstDisponible(false);
            final JPanel jp = new JPanel();
            JOptionPane.showMessageDialog(jp, hmAdherents.get(refAdherent).getPrenom() + ", vous avez emprunté le livre : " +
                    hmLivres.get(refLivre).getTitre(), "Inscription réussie", JOptionPane.PLAIN_MESSAGE);
        } else errorMessage("dejaPris");
    }

    /**
     * Rends un livre en passant la ref d'un adherent et celle d'un livre
     * @param refAdherent La reference de l'adherent
     * @param refLivre La reference du livre
     */
    public void deposerLivre(String refAdherent, String refLivre) {
        if(!refAdherent.equals("") && hmAdherents.get(refAdherent)!=null){
            if(!refLivre.equals("") && hmLivres.get(refLivre)!=null){
                int index = verifyPossession(refAdherent, refLivre);
                if (index != -1) {
                    hmAdherents.get(refAdherent).getLivresEmpruntes().remove(index);
                    hmLivres.get(refLivre).setEstDisponible(true);
                    final JPanel jp = new JPanel();
                    JOptionPane.showMessageDialog(jp, hmAdherents.get(refAdherent).getPrenom() + ", le livre \"" +
                                    hmLivres.get(refLivre).getTitre() + "\" a bien été déposé.",
                            "Inscription réussie", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    errorMessage("presenceEmprunt");
                }
            } else {
                errorMessage("refLEmprunt");
            }
        } else {
            errorMessage("refAEmprunt");
        }
    }

    /**
     * Verifie si le livre est emprunté par un adherent
     * @param refAdherent La reference de l'adherent
     * @param refLivre La reference du livre
     * @return l'index du livre dans la hashMap de l'adherent
     */
    private int verifyPossession(String refAdherent, String refLivre) {
        int cpt = 0;
        for(Livre l : hmAdherents.get(refAdherent).getLivresEmpruntes()){
            if(l.getRefLivre().equals(refLivre)) return cpt;
            cpt++;
        }
        return -1;
    }

    /**
     * Supprime un livre des stocks de la bibliotheque
     * @param refL La reference du livre à supprimer
     */
    public void suppLivre(String refL){
        if(!refL.equals("") && hmLivres.get(refL)!=null){
            if(hmLivres.get(refL).isEstDisponible()){
                hmLivres.remove(refL);
                final JPanel jp = new JPanel();
                JOptionPane.showMessageDialog(jp, "Le livre de référence " + refL + " a bien été supprimé.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                errorMessage("livreEmprunte");
            }
        } else {
            errorMessage("refLEmprunt");
        }
    }

    /**
     * Désinscrit un adherent si il n'a aucun livres emprunté.
     * @param numA Le numéro de l'adherent à supprimer.
     */
    public void desinscriptionAdh(String numA){
        if(!numA.equals("") && hmAdherents.get(numA)!=null){
            if(hmAdherents.get(numA).getLivresEmpruntes().size() == 0){
                String p = hmAdherents.get(numA).getPrenom();
                String n = hmAdherents.get(numA).getNom();
                hmAdherents.remove(numA);
                final JPanel jp = new JPanel();
                JOptionPane.showMessageDialog(jp,  p + " " + n + ", vous avez bien été retiré de la liste des inscrits.", "Désinscription réussie", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                errorMessage("livreNonRendu");
            }
        } else {
            errorMessage("refAEmprunt");
        }
    }


    /**
     * Affiche un message d'erreur en fonction du code reçu
     * @param code Le code de l'erreur
     */
    private void errorMessage(String code){
        final JPanel panel = new JPanel();
        String mess;
        switch (code){
            case "refAEmprunt" :
                mess = "Le code adhérent est manquant ou erroné.";
                break;
            case "refLEmprunt" :
                mess = "La référence du livre est introuvable.";
                break;
            case "infoEmprunt" :
                mess = "Au moins un des champs concernant le livre doit être renseigné.";
                break;
            case "AucunLivre" :
                mess = "Aucun livre n'a été trouvé avec les informations fournies.";
                break;
            case "dejaPris" :
                mess = "Le livre que vous recherchez est déjà emprunté.";
                break;
            case "presenceEmprunt" :
                mess = "Aucun livre avec cette référence dans la liste d'emprunt de cet adhérent.";
                break;
            case "livreEmprunte" :
                mess = "Suppression impossible, le livre est en cours d'emprunt.";
                break;
            case "livreNonRendu" :
                mess = "Veuillez rendre tous les livres avant de vous désinscrire.";
                break;
            default :
                mess = "Erreur inconnue au bataillon";
                break;
        }

        JOptionPane.showMessageDialog(panel, mess, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public HashMap<String, Livre> getHmLivres(){ return this.hmLivres; }

    public HashMap<String, Adherent> getHmAdherent(){ return this.hmAdherents; }


}
