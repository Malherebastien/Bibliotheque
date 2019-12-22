import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class AffLivres {

    private JFrame listFrame;
    private ArrayList<Livre> alLivre;
    private Controller controller;
    private String refAdherent;
    private JButton bVal;
    private JButton bAnnul;
    private JComboBox liste;

    public AffLivres(ArrayList<Livre> al, Controller ctrler, String refA){
        this.alLivre = al;
        this.controller = ctrler;
        this.refAdherent = refA;

        createView();
        placeComponents();
        createController();
    }

    public void display() {
        listFrame.pack();
        listFrame.setLocationRelativeTo(null);
        listFrame.setVisible(true);
    }

    private void createView() {
        final int frameWidth = 400;
        final int frameHeight = 150;

        listFrame = new JFrame("Liste des livres trouvés");
        listFrame.setPreferredSize(new Dimension(frameWidth, frameHeight));

        this.bAnnul = new JButton("Annuler");
        this.bVal = new JButton("Valider");
        Object[] compos = new Object[this.alLivre.size()];

        for (int i = 0; i < this.alLivre.size(); i++){
            compos[i] = this.alLivre.get(i).getTitre() + ", " + this.alLivre.get(i).getEditeur();
        }

        this.liste = new JComboBox(compos);
    }

    private void placeComponents(){
        JPanel p = new JPanel( new GridLayout(3, 1));{
            p.add(new JLabel("Sélectionnez un livre : "));
            p.add(this.liste);
            JPanel pb = new JPanel(new FlowLayout());{
                pb.add(bVal);
                pb.add(bAnnul);
            }
            p.add(pb);
        }
        listFrame.add(p);
    }

    private void createController(){
        listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        bVal.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("--> " + alLivre.get(liste.getSelectedIndex()).getRefLivre());
                controller.empruntRefRef(alLivre.get(liste.getSelectedIndex()).getRefLivre(), refAdherent);
                listFrame.dispose();
            }
        });
        bAnnul.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                listFrame.dispose();
            }
        });
    }
}
