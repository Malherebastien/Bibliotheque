import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Controller extends Observable {

    private HashMap<String, Adherent> hmAdherents;
    private HashMap<String, Livre> hmLivres;

    public Controller() {
        this.hmAdherents = new HashMap<String, Adherent>();
        this.hmLivres = new HashMap<String, Livre>();
    }

    public void addEtudiant(String nom, String prenom, Adresse adresse, String numEtu, String tel){
        String ref = "E" + String.format("%05d", hmAdherents.size() + 1);
        hmAdherents.put(ref, new Etudiant(nom, prenom, adresse, tel, Integer.parseInt(numEtu)));
        final JPanel jp = new JPanel();
        JOptionPane.showMessageDialog(jp, "Incription réussie " + prenom + "! Le code d'adhérent qui vous a été attribué est : " +
                ref, "Inscription réussie", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addSalarie(String nom, String prenom, Adresse adresse, String salaire, String tel){
        String ref = "S" + String.format("%05d", hmAdherents.size() + 1);
        hmAdherents.put(ref, new Salarie(nom, prenom, adresse, tel, Integer.parseInt(salaire)));
        final JPanel jp = new JPanel();
        JOptionPane.showMessageDialog(jp, "Incription réussie " + prenom + "! Le code d'adhérent qui vous a été attribué est : " +
                ref, "Inscription réussie", JOptionPane.INFORMATION_MESSAGE);
    }

    public void addLivre(String titre, Auteur auteur, String editeur, String anneeEdition){
        String ref = "L" + (hmLivres.size() + 1);
        hmLivres.put(ref, new Livre(titre, auteur, editeur, Integer.parseInt(anneeEdition)));
        final JPanel jp = new JPanel();
        JOptionPane.showMessageDialog(jp, titre + " ajouté à la bibliothèque avec la référence : " +
                ref, "Inscription réussie", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean demandeEmprunt(String refAdherent, String refLivre, String titre, String auteur, String editeur, String anneEdition){
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
            if(titre.equals("") && auteur.equals("") && editeur.equals("") && anneEdition.equals("")){
                errorMessage("infoEmprunt");
                return false;
            } else {
                rechercheLivre(refAdherent, titre, auteur, editeur, anneEdition);
            }
        }
        return true;
    }

    private void rechercheLivre(String refA, String titre, String auteur, String editeur, String anneEdition) {
        ArrayList<Livre> alLivresTrouve = new ArrayList<Livre>();
        for(Livre l : hmLivres.values()){
            if((!titre.equals("") && !titre.equals(l.getTitre())) ||
                    (!auteur.equals("") && !auteur.equals(l.getAuteurs().get(0).getNom())) ||
                    (!editeur.equals("") && !editeur.equals(l.getEditeur())) ||
                    (!anneEdition.equals("") && !anneEdition.equals(l.getAnneeEdition()+""))){
                continue;
            } else {
                alLivresTrouve.add(l);
            }
        }

        if (alLivresTrouve.size() == 0) errorMessage("AucunLivre");
        else new AffLivres(alLivresTrouve, this, refA).display();
    }

    public void empruntRefRef(String refLivre, String refAdherent) {
        if(hmLivres.get(refLivre).isEstDisponible()){
            hmAdherents.get(refAdherent).getLivresEmpruntes().add(hmLivres.get(refLivre));
            hmLivres.get(refLivre).setEstDisponible(false);
            final JPanel jp = new JPanel();
            JOptionPane.showMessageDialog(jp, hmAdherents.get(refAdherent).getPrenom() + ", vous avez emprunté le livre : " +
                    hmLivres.get(refLivre).getTitre(), "Inscription réussie", JOptionPane.PLAIN_MESSAGE);
        } else errorMessage("dejaPris");
    }

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

    private int verifyPossession(String refAdherent, String refLivre) {
        int cpt = 0;
        for(Livre l : hmAdherents.get(refAdherent).getLivresEmpruntes()){
            if(l.getRefLivre().equals(refLivre)) return cpt;
            cpt++;
        }
        return -1;
    }

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
            default :
                mess = "Erreur de segmentation ;p";
                break;
        }

        JOptionPane.showMessageDialog(panel, mess, "Error", JOptionPane.ERROR_MESSAGE);
    }


}
