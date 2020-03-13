/**
 * Le modele de l'application graphique avec le pattern MVC
 * @author Bastien Malhere, Gabin Pruvost-Couvreur
 * @version 3.0
 * @since 3.0
 * @see View
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Controller extends Observable {

    private Modele model;
    private View view;

    public Controller() {
        this.model = new Modele();
        this.view = new View(this);
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
        this.model.addEtudiant(nom, prenom, adresse, numEtu, tel);
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
        this.model.addSalarie(nom, prenom, adresse, salaireBrut, tel);
    }

    /**
     * Ajoute un adherent Sans-Emploi
     * @param nom Nom du sans-emploi
     * @param prenom Prenom du sans-emploi
     * @param adresse Adresse du sans-emploi
     * @param tel Le téléphone du sans-emploi
     */
    public void addSansEmploi(String nom, String prenom, Adresse adresse, String tel){
        this.model.addSansEmploi(nom, prenom, adresse, tel);
    }


    /**
     * Ajoute un personnel Directeur
     * @param nom Nom du personnel
     * @param prenom Prenom du personnel
     * @param age Age du personnel
     */
    public void addDirecteur(String nom, String prenom, String age) {
        this.model.addDirecteur(nom, prenom, age);
    }

    /**
     * Ajoute un personnel Secretaire
     * @param nom Nom du personnel
     * @param prenom Prenom du personnel
     * @param age Age du personnel
     */
    public void addSecretaire(String nom, String prenom, String age) {
        this.model.addSecretaire(nom, prenom, age);
    }

    /**
     * Ajoute un personnel Bibliothecaire
     * @param nom Nom du personnel
     * @param prenom Prenom du personnel
     * @param age Age du personnel
     */
    public void addBibliothecaire(String nom, String prenom, String age) {
        this.model.addBibliothecaire(nom, prenom, age);
    }


    /**
     * Crée un livre et l'ajoute à la hashmap de livres si le livre à un seul auteur
     * @param titre Le titre du livre
     * @param auteur L'auteur du livre
     * @param editeur L'editeur du livre
     * @param anneeEdition l'année d'edition du livre
     */
    public void addLivre(String titre, Auteur auteur, String editeur, String anneeEdition){
        this.model.addLivre(titre, auteur, editeur, anneeEdition);
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
        return this.model.demandeEmprunt(refAdherent, refLivre, titre, auteur, editeur, anneeEdition);
    }

    /**
     * Fait un emprunt en passant la ref d'un adherent et celle d'un livre
     * @param refLivre Reference d'un livre
     * @param refAdherent Reference d'un adherent
     */
    public void empruntRefRef(String refLivre, String refAdherent) {
        this.model.empruntRefRef(refLivre, refAdherent);
    }

    /**
     * Rends un livre en passant la ref d'un adherent et celle d'un livre
     * @param refAdherent La reference de l'adherent
     * @param refLivre La reference du livre
     */
    public void deposerLivre(String refAdherent, String refLivre) {
        this.model.deposerLivre(refAdherent, refLivre);
    }

    /**
     * Supprime un livre des stocks de la bibliotheque
     * @param refL La reference du livre à supprimer
     */
    public void suppLivre(String refL){
        this.model.suppLivre(refL);
    }

    /**
     * Désinscrit un adherent si il n'a aucun livres emprunté.
     * @param numA Le numéro de l'adherent à supprimer.
     */
    public void desinscriptionAdh(String numA){
        this.model.desinscriptionAdh(numA);
    }

    public HashMap<String, Livre> getHmLivres(){ return this.model.getHmLivres(); }

    public HashMap<String, Adherent> getHmAdherent(){ return this.model.getHmAdherent(); }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Controller();
            }
        });
    }
}
