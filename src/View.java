import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class View {

    private JFrame mainFrame;
    private Controller model;
    private JTabbedPane jtp;

    //Page Accueil
    private JButton bAccInscription;
    private JButton bAccEmprunt;
    private JButton bAccDepot;
    private JButton bAccListeLivres;
    private JButton bAccListeUtilisateurs;
    private JButton bAccDesinscription;
    private JButton bAccSuppLivre;
    private JButton bAccInscriptionInterne;

    //Inscription
    private JTextField tfInsNom;
    private JTextField tfInsPrenom;
    private JTextField tfInsRue;
    private JTextField tfInsNumRue;
    private JTextField tfInsVille;
    private JTextField tfInsCodePostal;
    private JTextField tfInsTel;
    private JTextField tfInsNumEtuSal;
    private JButton bValiderAjoutAdherent;
    private CheckboxGroup cbgStatut;

    //Inscription interne
    private JTextField tfInsINom;
    private JTextField tfInsIPrenom;
    private JTextField tfInsIAge;
    private JButton bValiderInsInterne;
    private CheckboxGroup cbgStatutI;

    //Ajout Livre
    private JTextField tfAddLTitre;
    private JTextField tfAddLAuteur;
    private JTextField tfAddLEditeur;
    private JTextField tfAddLAnneeEdition;
    private JButton bValiderAjoutLivre;

    //Suppression Livre
    private JTextField tfRefSupp;
    private JButton bValiderSupLivre;

    //Desincription
    private JTextField tfNumSupp;
    private JButton bValiderSupAdherent;

    //Emprunt Livre
    private JTextField tfEmpARef;
    private JTextField tfEmpLRef;
    private JTextField tfEmpLTitre;
    private JTextField tfEmpLAuteur;
    private JTextField tfEmpLEditeur;
    private JTextField tfEmpLAnneeEdition;
    private JButton bValiderEmprunt;

    //Depot Livre
    private JTextField tfDepotARef;
    private JTextField tfDepotLRef;
    private JButton bValiderRendu;

    private JButton bTrier;
    private JComboBox<String> cbTrier;


    public View() {
        createModel();
        createView();
        placeComponents();
        createController();

        model.addAdherent("Pruvost---Couvreur", "Gabin", new Adresse(), "1234", "0000000000", "Etudiant");
        model.addAdherent("Malherbe", "Bastien", new Adresse(), "4321", "111111111111", "Etudiant");
        model.addAdherent("Duvalon", "Paul", new Adresse(), "1111", "2222222222", "Salarié");
        model.addAdherent("Levesque", "Paulinette", new Adresse(), "1000000", "3333333333", "Salarié");

        model.addLivre("20 milieux sous la Terre", new Auteur("Julien", "Verni"), "La marmotte de milka", "1984");
        model.addLivre("Le bleu du ciel", new Auteur("Un", "oiseau"), "Les aut' oiseaux", "2015");
    }


    /**
     * Rend l'application visible au centre de l'ecran.
     */
    public void display() {
        refresh();
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    /**
     * Initialise le model
     */
    private void createModel() {
        model = new Controller();
    }

    /**
     * Initialise tous les éléments graphiques
     */
    private void createView() {
        final int frameWidth = 700;
        final int frameHeight = 500;

        mainFrame = new JFrame("Librairie");
        mainFrame.setPreferredSize(new Dimension(frameWidth, frameHeight));
        mainFrame.setResizable(false);

        jtp = new JTabbedPane();

        this.bAccInscription = new JButton("S'inscrire");
        this.bAccEmprunt = new JButton("Emprunter un livre");
        this.bAccDepot = new JButton("Déposer un livre");
        this.bAccListeLivres = new JButton("Liste des livres");
        this.bAccDesinscription = new JButton("Désinscription");
        this.bAccListeUtilisateurs = new JButton("Liste des utilisateurs");
        this.bAccInscriptionInterne = new JButton("Incription d'utilisateur interne");
        this.bAccSuppLivre = new JButton("Suppression de livre");

        this.bValiderAjoutLivre = new JButton("Valider");
        this.bValiderSupAdherent = new JButton("Valider");



        //Inscriptoin
        this.tfInsNom = new JTextField();
        this.tfInsNom.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfInsPrenom = new JTextField();
        this.tfInsPrenom.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfInsRue = new JTextField();
        this.tfInsRue.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfInsNumRue = new JTextField();
        this.tfInsNumRue.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfInsVille = new JTextField();
        this.tfInsVille.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfInsCodePostal = new JTextField();
        this.tfInsCodePostal.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfInsTel = new JTextField();
        this.tfInsTel.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfInsNumEtuSal = new JTextField();
        this.tfInsNumEtuSal.setPreferredSize( new Dimension( 200, 24 ) );
        this.bValiderAjoutAdherent = new JButton("Valider");
        this.cbgStatut = new CheckboxGroup();

        //Emprunt
        this.tfEmpARef = new JTextField();
        this.tfEmpARef.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfEmpLRef = new JTextField();
        this.tfEmpLRef.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfEmpLTitre = new JTextField();
        this.tfEmpLTitre.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfEmpLAuteur = new JTextField();
        this.tfEmpLAuteur.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfEmpLEditeur = new JTextField();
        this.tfEmpLEditeur.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfEmpLAnneeEdition = new JTextField();
        this.tfEmpLAnneeEdition.setPreferredSize( new Dimension( 200, 24 ) );
        this.bValiderEmprunt = new JButton("EMPRUNTER");

        //Depot
        this.tfDepotARef = new JTextField();
        this.tfDepotARef.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfDepotLRef = new JTextField();
        this.tfDepotLRef.setPreferredSize( new Dimension( 200, 24 ) );
        this.bValiderRendu = new JButton("RENDRE");

        //Suppression livre
        this.tfRefSupp = new JTextField();
        this.tfRefSupp.setPreferredSize( new Dimension( 200, 24 ) );
        this.bValiderSupLivre = new JButton("Valider");

        //Desinscription
        this.tfNumSupp = new JTextField();
        this.tfNumSupp.setPreferredSize( new Dimension( 200, 24 ) );
        this.bValiderSupAdherent = new JButton("Valider");

        //Inscription interne
        this.tfInsINom = new JTextField();
        this.tfInsINom.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfInsIPrenom = new JTextField();
        this.tfInsIPrenom.setPreferredSize( new Dimension( 200, 24 ) );
        this.tfInsIAge = new JTextField();
        this.tfInsIAge.setPreferredSize( new Dimension( 200, 24 ) );
        this.bValiderInsInterne = new JButton("Valider");
        this.cbgStatutI = new CheckboxGroup();
    }

    /**
     * Organise la fenêtre graphique et l'affiche
     */
    private void placeComponents() {
        JPanel pAcceuil = new JPanel(new BorderLayout());{
            JLabel jlAccueil = new JLabel(" Bienvenue à la bibliothèque BIBLIO TOC");
            jlAccueil.setFont(new Font("Arial", Font.BOLD, 16));
            pAcceuil.add(jlAccueil, BorderLayout.NORTH);
            JPanel pa_0 = new JPanel(new GridLayout(9, 1));{
                JPanel pa_1 = new JPanel(new FlowLayout());{
                    pa_1.add(this.bAccInscription);
                }
                JPanel pa_2 = new JPanel(new FlowLayout());{
                    pa_2.add(this.bAccEmprunt);
                }
                JPanel pa_3 = new JPanel(new FlowLayout());{
                    pa_3.add(this.bAccDepot);
                }
                JPanel pa_4 = new JPanel(new FlowLayout());{
                    pa_4.add(this.bAccListeLivres);
                }
                JPanel pa_5 = new JPanel(new FlowLayout());{
                    pa_5.add(this.bAccDesinscription);
                }
                JPanel pa_6 = new JPanel(new BorderLayout());{
                    pa_6.add(new JLabel("Commandes Administrateur"));
                }
                JPanel pa_7 = new JPanel(new FlowLayout());{
                    pa_7.add(this.bAccListeUtilisateurs);
                }
                JPanel pa_8 = new JPanel(new FlowLayout());{
                    pa_8.add(this.bAccInscriptionInterne);
                }
                JPanel pa_9 = new JPanel(new FlowLayout());{
                    pa_9.add(this.bAccSuppLivre);
                }
                pa_0.add(pa_1);
                pa_0.add(pa_2);
                pa_0.add(pa_3);
                pa_0.add(pa_4);
                pa_0.add(pa_5);
                pa_0.add(pa_6);
                pa_0.add(pa_7);
                pa_0.add(pa_8);
                pa_0.add(pa_9);
            }
            pAcceuil.add(pa_0, BorderLayout.CENTER);
        }
        JPanel pIns = new JPanel(new BorderLayout()); {
            JPanel pIns_1 = new JPanel(new GridLayout(2, 1));{
                JPanel pIns_1_0 = new JPanel();{
                    JLabel jlTop = new JLabel("Formulaire d'inscription");
                    jlTop.setFont(new Font("Arial", Font.BOLD, 16));
                    pIns_1_0.add(jlTop);
                }

                JPanel pIns_1_1 = new JPanel(new GridLayout(2, 1));{
                    JPanel pIns_1_1_1 = new JPanel();{
                        JLabel jlStatut = new JLabel("Statut");
                        pIns_1_1_1.add(jlStatut);
                    }
                    JPanel pIns_1_1_2 = new JPanel(new GridLayout(1, 3));{
                        pIns_1_1_2.add(new Checkbox("Etudiant", this.cbgStatut, false));
                        pIns_1_1_2.add(new Checkbox("Salarié", this.cbgStatut, false));
                        pIns_1_1_2.add(new Checkbox("Sans emploi", this.cbgStatut, false));
                    }
                    pIns_1_1.add(pIns_1_1_1);
                    pIns_1_1.add(pIns_1_1_2);
                }
                pIns_1.add(pIns_1_0);
                pIns_1.add(pIns_1_1);
            }

            JPanel pIns_2 = new JPanel(new GridLayout(11, 2));{
                JPanel pIns_2_1 = new JPanel(new BorderLayout());{
                    pIns_2_1.add(new JLabel("Nom : "), BorderLayout.EAST);
                }
                pIns_2.add(pIns_2_1);
                JPanel pIns_2_2 = new JPanel();{
                    pIns_2_2.add(this.tfInsNom);
                }
                pIns_2.add(pIns_2_2);
                JPanel pIns_2_3 = new JPanel(new BorderLayout());{
                    pIns_2_3.add(new JLabel("Prénom : "), BorderLayout.EAST);
                }
                pIns_2.add(pIns_2_3);
                JPanel pIns_2_4 = new JPanel();{
                    pIns_2_4.add(this.tfInsPrenom);
                }
                pIns_2.add(pIns_2_4);

                pIns_2.add(new JLabel(""));
                pIns_2.add(new JLabel("Adresse : "));

                JPanel pIns_2_5 = new JPanel(new BorderLayout());{
                    pIns_2_5.add(new JLabel("Rue :"), BorderLayout.EAST);
                }
                JPanel pIns_2_6 = new JPanel(new FlowLayout());{
                    pIns_2_6.add(this.tfInsRue);
                }
                JPanel pIns_2_7 = new JPanel(new BorderLayout());{
                    pIns_2_7.add(new JLabel("Numéro :"), BorderLayout.EAST);
                }
                JPanel pIns_2_8 = new JPanel(new FlowLayout());{
                    pIns_2_8.add(this.tfInsNumRue);
                }
                JPanel pIns_2_9 = new JPanel(new BorderLayout());{
                    pIns_2_9.add(new JLabel("Ville :"), BorderLayout.EAST);
                }
                JPanel pIns_2_10 = new JPanel(new FlowLayout());{
                    pIns_2_10.add(this.tfInsVille);
                }
                JPanel pIns_2_11 = new JPanel(new BorderLayout());{
                    pIns_2_11.add(new JLabel("Code postal :"), BorderLayout.EAST);
                }
                JPanel pIns_2_12 = new JPanel(new FlowLayout());{
                    pIns_2_12.add(this.tfInsCodePostal);
                }
                pIns_2.add(pIns_2_5);
                pIns_2.add(pIns_2_6);
                pIns_2.add(pIns_2_7);
                pIns_2.add(pIns_2_8);
                pIns_2.add(pIns_2_9);
                pIns_2.add(pIns_2_10);
                pIns_2.add(pIns_2_11);
                pIns_2.add(pIns_2_12);

                pIns_2.add(new JLabel(""));
                pIns_2.add(new JLabel("------"));

                JPanel pIns_2_13 = new JPanel(new BorderLayout()); {
                    pIns_2_13.add(new JLabel("Téléphone :"), BorderLayout.EAST);
                }
                pIns_2.add(pIns_2_13);
                JPanel pIns_2_14 = new JPanel();{
                    pIns_2_14.add(this.tfInsTel);
                }
                pIns_2.add(pIns_2_14);
                JPanel pIns_2_15 = new JPanel(new BorderLayout()); {
                    pIns_2_15.add(new JLabel("Numéro étudiant / Salaire :"), BorderLayout.EAST);
                }
                pIns_2.add(pIns_2_15);
                JPanel pIns_2_16 = new JPanel();{
                    pIns_2_16.add(this.tfInsNumEtuSal);
                }
                pIns_2.add(pIns_2_16);
            }
            JPanel pIns_3 = new JPanel(new FlowLayout());{
                pIns_3.add(this.bValiderAjoutAdherent);
            }
            pIns.add(pIns_1, BorderLayout.NORTH);
            pIns.add(pIns_2, BorderLayout.CENTER);
            pIns.add(pIns_3, BorderLayout.SOUTH);
        }
        JPanel pEmprunt = new JPanel(new BorderLayout());{
            JPanel pe_1 = new JPanel(new FlowLayout());{
                pe_1.add(new JLabel("Formulaire d'Emprunt"));
            }
            JPanel pe_2 = new JPanel(new GridLayout(8, 2));{
                JPanel pe_2_1 = new JPanel(new BorderLayout());{
                    pe_2_1.add(new JLabel("Entrez votre code adhérent :  "), BorderLayout.EAST);
                }
                JPanel pe_2_2 = new JPanel(new FlowLayout());{
                    pe_2_2.add(this.tfEmpARef);
                }
                JPanel pe_2_3 = new JPanel(new BorderLayout());{
                    pe_2_3.add(new JLabel("----------------------"), BorderLayout.EAST);
                }
                JPanel pe_2_4 = new JPanel(new BorderLayout());{
                    pe_2_4.add(new JLabel("----------------------"), BorderLayout.WEST);
                }
                JPanel pe_2_5 = new JPanel(new BorderLayout());{
                    pe_2_5.add(new JLabel("Référence du livre : "), BorderLayout.EAST);
                }
                JPanel pe_2_6 = new JPanel(new FlowLayout());{
                    pe_2_6.add(this.tfEmpLRef);
                }
                JPanel pe_2_7 = new JPanel(new BorderLayout());{
                    pe_2_7.add(new JLabel("Ou "), BorderLayout.EAST);
                }
                JPanel pe_2_8 = new JPanel(new BorderLayout());{
                    pe_2_8.add(new JLabel(" recherche"), BorderLayout.WEST);
                }
                JPanel pe_2_9 = new JPanel(new BorderLayout());{
                    pe_2_9.add(new JLabel("Titre : "), BorderLayout.EAST);
                }
                JPanel pe_2_10 = new JPanel(new FlowLayout());{
                    pe_2_10.add(this.tfEmpLTitre);
                }
                JPanel pe_2_11 = new JPanel(new BorderLayout());{
                    pe_2_11.add(new JLabel("Auteur : "), BorderLayout.EAST);
                }
                JPanel pe_2_12 = new JPanel(new FlowLayout());{
                    pe_2_12.add(this.tfEmpLAuteur);
                }
                JPanel pe_2_13 = new JPanel(new BorderLayout());{
                    pe_2_13.add(new JLabel("Editeur : "), BorderLayout.EAST);
                }
                JPanel pe_2_14 = new JPanel(new FlowLayout());{
                    pe_2_14.add(this.tfEmpLEditeur);
                }
                JPanel pe_2_15 = new JPanel(new BorderLayout());{
                    pe_2_15.add(new JLabel("Date d'édition : "), BorderLayout.EAST);
                }
                JPanel pe_2_16 = new JPanel(new FlowLayout());{
                    pe_2_16.add(this.tfEmpLAnneeEdition);
                }

                pe_2.add(pe_2_1);
                pe_2.add(pe_2_2);
                pe_2.add(pe_2_3);
                pe_2.add(pe_2_4);
                pe_2.add(pe_2_5);
                pe_2.add(pe_2_6);
                pe_2.add(pe_2_7);
                pe_2.add(pe_2_8);
                pe_2.add(pe_2_9);
                pe_2.add(pe_2_10);
                pe_2.add(pe_2_11);
                pe_2.add(pe_2_12);
                pe_2.add(pe_2_13);
                pe_2.add(pe_2_14);
                pe_2.add(pe_2_15);
                pe_2.add(pe_2_16);
            }
            JPanel pe_3 = new JPanel(new FlowLayout()); {
                pe_3.add(this.bValiderEmprunt);
            }
            pEmprunt.add(pe_1, BorderLayout.NORTH);
            pEmprunt.add(pe_2, BorderLayout.CENTER);
            pEmprunt.add(pe_3, BorderLayout.SOUTH);
        }
        JPanel pDepot = new JPanel(new BorderLayout());{
            JPanel pde_1 = new JPanel(new FlowLayout());{
                pde_1.add(new JLabel("Formulaire de dépot"));
            }
            JPanel pde_2 = new JPanel(new GridLayout(2, 2));
            {
                JPanel pde_2_1 = new JPanel(new FlowLayout());
                {
                    pde_2_1.add(new JLabel("Entrez votre code adhérent :  "), BorderLayout.EAST);
                }
                JPanel pde_2_2 = new JPanel(new FlowLayout());
                {
                    pde_2_2.add(this.tfDepotARef);
                }
                JPanel pde_2_5 = new JPanel(new FlowLayout());
                {
                    pde_2_5.add(new JLabel("Référence du livre : "), BorderLayout.EAST);
                }
                JPanel pde_2_6 = new JPanel(new FlowLayout());
                {
                    pde_2_6.add(this.tfDepotLRef);
                }

                pde_2.add(pde_2_1);
                pde_2.add(pde_2_2);
                pde_2.add(pde_2_5);
                pde_2.add(pde_2_6);
            }
            JPanel pde_3 = new JPanel(new FlowLayout()); {
                pde_3.add(this.bValiderRendu);
            }
            pDepot.add(pde_1, BorderLayout.NORTH);
            pDepot.add(pde_2, BorderLayout.CENTER);
            pDepot.add(pde_3, BorderLayout.SOUTH);
        }

        JPanel pListeLivres = new JPanel();{
            JScrollPane pLL_1 = new JScrollPane();{
                HashMap<String, Livre> hml = model.getHmLivres();
                String entete[] = {"Titre", "Auteur(s)", "Editeur", "Année édition", "Disponibilité"};


            }
        }

        JPanel pDesinscription = new JPanel();{
            JPanel pSuppL_1 = new JPanel();{
                JLabel jlTop = new JLabel("Desinscription d'utilisateur");
                jlTop.setFont(new Font("Arial", Font.BOLD, 16));
                pSuppL_1.add(jlTop);
            }
            JPanel pSuppL_2 = new JPanel(new GridLayout(1, 2));{
                JPanel pSuppL_2_1 = new JPanel(new FlowLayout());
                {
                    pSuppL_2_1.add(new JLabel("Référence d'utilisateur : "), BorderLayout.EAST);
                }
                JPanel pSuppL_2_2 = new JPanel(new FlowLayout());
                {
                    pSuppL_2_2.add(this.tfNumSupp);
                }

                pSuppL_2.add(pSuppL_2_1);
                pSuppL_2.add(pSuppL_2_2);
            }
            JPanel pSuppL_3 = new JPanel(new FlowLayout());
            {
                pSuppL_3.add(this.bValiderSupAdherent);
            }

            pDesinscription.add(pSuppL_1, BorderLayout.NORTH);
            pDesinscription.add(pSuppL_2, BorderLayout.CENTER);
            pDesinscription.add(pSuppL_3, BorderLayout.SOUTH);
        }

        JPanel pListeUtilisateurs = new JPanel(); {
            JScrollPane pLU_1 = new JScrollPane();{

            }
        }

        //-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        JPanel pInscriptionInterne = new JPanel(); {
            JPanel pInsI_1 = new JPanel(new GridLayout(2, 1));
            {
                JPanel pInsI_1_0 = new JPanel();
                {
                    JLabel jlTop = new JLabel("Formulaire d'inscription interne");
                    jlTop.setFont(new Font("Arial", Font.BOLD, 16));
                    pInsI_1_0.add(jlTop);
                }

                JPanel pInsI_1_1 = new JPanel(new GridLayout(2, 1));
                {
                    JPanel pInsI_1_1_1 = new JPanel();
                    {
                        JLabel jlStatut = new JLabel("Statut");
                        pInsI_1_1_1.add(jlStatut);
                    }
                    JPanel pInsI_1_1_2 = new JPanel(new GridLayout(1, 3));
                    {
                        pInsI_1_1_2.add(new Checkbox("Directeur", this.cbgStatutI, false));
                        pInsI_1_1_2.add(new Checkbox("Bibliothécaire", this.cbgStatutI, false));
                        pInsI_1_1_2.add(new Checkbox("Secrétaire", this.cbgStatutI, false));
                    }
                    pInsI_1_1.add(pInsI_1_1_1);
                    pInsI_1_1.add(pInsI_1_1_2);
                }
                pInsI_1.add(pInsI_1_0);
                pInsI_1.add(pInsI_1_1);
            }

            JPanel pInsI_2 = new JPanel(new GridLayout(3, 2));
            {
                JPanel pInsI_2_1 = new JPanel(new BorderLayout());
                {
                    pInsI_2_1.add(new JLabel("Nom : "), BorderLayout.EAST);
                }
                pInsI_2.add(pInsI_2_1);
                JPanel pInsI_2_2 = new JPanel();
                {
                    pInsI_2_2.add(this.tfInsINom);
                }
                pInsI_2.add(pInsI_2_2);
                JPanel pIns_2_3 = new JPanel(new BorderLayout());
                {
                    pIns_2_3.add(new JLabel("Prénom : "), BorderLayout.EAST);
                }
                pInsI_2.add(pIns_2_3);
                JPanel pInsI_2_4 = new JPanel();
                {
                    pInsI_2_4.add(this.tfInsIPrenom);
                }
                pInsI_2.add(pInsI_2_4);
                JPanel pInsI_2_5 = new JPanel(new BorderLayout());
                {
                    pInsI_2_5.add(new JLabel("Age : "), BorderLayout.EAST);
                }
                pInsI_2.add(pInsI_2_5);
                JPanel pInsI_2_6 = new JPanel();
                {
                    pInsI_2_6.add(this.tfInsIAge);
                }
                pInsI_2.add(pInsI_2_6);
            }

            JPanel pInsI_3 = new JPanel(new FlowLayout()); {
                pInsI_3.add(this.bValiderSupAdherent);
            }

            pInscriptionInterne.add(pInsI_1, BorderLayout.NORTH);
            pInscriptionInterne.add(pInsI_2, BorderLayout.CENTER);
            pInscriptionInterne.add(pInsI_3, BorderLayout.SOUTH);
        }

        JPanel pSuppressionLivre = new JPanel(new BorderLayout());{
            JPanel pSuppL_1 = new JPanel();{
                JLabel jlTop = new JLabel("Suppression de livre");
                jlTop.setFont(new Font("Arial", Font.BOLD, 16));
                pSuppL_1.add(jlTop);
            }
            JPanel pSuppL_2 = new JPanel(new GridLayout(1, 2));{
                JPanel pSuppL_2_1 = new JPanel(new FlowLayout());
                {
                    pSuppL_2_1.add(new JLabel("Référence du livre : "), BorderLayout.EAST);
                }
                JPanel pSuppL_2_2 = new JPanel(new FlowLayout());
                {
                    pSuppL_2_2.add(this.tfRefSupp);
                }

                pSuppL_2.add(pSuppL_2_1);
                pSuppL_2.add(pSuppL_2_2);
            }
            JPanel pSuppL_3 = new JPanel(new FlowLayout());
            {
                pSuppL_3.add(this.bValiderSupLivre);
            }

            pSuppressionLivre.add(pSuppL_1, BorderLayout.NORTH);
            pSuppressionLivre.add(pSuppL_2, BorderLayout.CENTER);
            pSuppressionLivre.add(pSuppL_3, BorderLayout.SOUTH);
        }

        jtp.addTab("Accueil", pAcceuil);
        jtp.addTab("Inscription", pIns);
        jtp.addTab("Emprunt", pEmprunt);
        jtp.addTab("Dépot", pDepot);
        jtp.addTab("Liste des livres", pListeLivres);
        jtp.addTab("Desinscription", pDesinscription);
        jtp.addTab("Liste des utilisateurs", pListeUtilisateurs);
        jtp.addTab("Inscrip. user interne", pInscriptionInterne);
        jtp.addTab("Suppression livres", pSuppressionLivre);

        jtp.setEnabledAt(1, false);
        jtp.setEnabledAt(2, false);
        jtp.setEnabledAt(3, false);
        jtp.setEnabledAt(4, false);
        jtp.setEnabledAt(5, false);
        jtp.setEnabledAt(6, false);
        jtp.setEnabledAt(7, false);
        jtp.setEnabledAt(8, false);

        mainFrame.add(jtp);
    }

    /**
     * Création des observers pour les différents composants
     */
    private void createController() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        model.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                refresh();
            }
        });

        bValiderAjoutAdherent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    model.addAdherent(tfInsNom.getText(), tfInsPrenom.getText(), new Adresse(tfInsRue.getText(), Integer.parseInt(tfInsNumRue.getText()), tfInsVille.getText(), Integer.parseInt(tfInsCodePostal.getText())), tfInsTel.getText(), tfInsNumEtuSal.getText(), cbgStatut.getSelectedCheckbox().getLabel());
            }
        });
        bValiderEmprunt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.demandeEmprunt(tfEmpARef.getText(), tfEmpLRef.getText(), tfEmpLTitre.getText(),
                        tfEmpLAuteur.getText(), tfEmpLEditeur.getText(), tfEmpLAnneeEdition.getText());
            }
        });
        bValiderRendu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.deposerLivre(tfDepotARef.getText(), tfDepotLRef.getText());
            }
        });
        bValiderSupLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.suppLivre(tfRefSupp.getText());
            }
        });
        bValiderSupAdherent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.desinscriptionAdh(tfNumSupp.getText());
            }
        });

        bAccInscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTable(1);
            }
        });

        bAccEmprunt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTable(2);
            }
        });
        bAccDepot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTable(3);
            }
        });
        bAccListeLivres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               switchTable(4);
            }
        });
        bAccDesinscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTable(5);
            }
        });
        bAccListeUtilisateurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTable(6);
            }
        });
        bAccInscriptionInterne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTable(7);
            }
        });
        bAccSuppLivre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTable(8);
            }
        });
    }

    private void switchTable(int i){
        for (int j = 1; j < 9; j++){
            if (i != j) jtp.setEnabledAt(j, false);
        }
        jtp.setEnabledAt(i, true);
        jtp.setSelectedIndex(i);
    }

    private void refresh() {
        //set le text avec les méthodes du model
    }

    /**
     * Point d'entrée du programme
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View().display();
            }
        });
    }
}
