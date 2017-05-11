import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.04.2017
  * @author 
  */

public class gui extends JFrame {
  // Anfang Attribute
  private JLabel jLabelMain = new JLabel();
  private JLabel jLabelCopyright = new JLabel();
  private JLabel jLabelWohnungsnummer = new JLabel();
  private JNumberField jNumberFieldWohnungsnummer = new JNumberField();
  private JButton jButtonBuchungenAbfragen = new JButton();
  private JLabel jLabelTagAuswaehlen = new JLabel();
  private JLabel jLabelMonatAuswaehlen = new JLabel();
  private JSpinner jSpinnerTag = new JSpinner();
    private SpinnerNumberModel jSpinnerTagModel = new SpinnerNumberModel(1, 1, 31, 1);
  private JComboBox<String> jComboBox1 = new JComboBox<String>();
    private DefaultComboBoxModel<String> jComboBox1Model = new DefaultComboBoxModel<String>();
  private JButton jButtonBuchungenAbfragen1 = new JButton();
  private JLabel jLabelAusgabeBuchung = new JLabel();
  // Ende Attribute
  
  public gui() {   
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1778; 
    int frameHeight = 746;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("test");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabelMain.setBounds(760, 24, 254, 49);
    jLabelMain.setText("Ferienwohnungverwaltung");
    jLabelMain.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(jLabelMain);
    jLabelCopyright.setBounds(1552, 664, 203, 33);
    jLabelCopyright.setText("© Riechling, Hasse, Lüssem (FS63)");
    cp.add(jLabelCopyright);
    jLabelWohnungsnummer.setBounds(32, 88, 115, 41);
    jLabelWohnungsnummer.setText("Wohnungsnummer");
    cp.add(jLabelWohnungsnummer);
    jNumberFieldWohnungsnummer.setBounds(160, 93, 49, 33);
    jNumberFieldWohnungsnummer.setText("");
    cp.add(jNumberFieldWohnungsnummer);
    jButtonBuchungenAbfragen.setBounds(224, 88, 121, 41);
    jButtonBuchungenAbfragen.setText("Buchung abfragen");
    jButtonBuchungenAbfragen.setMargin(new Insets(2, 2, 2, 2));
    jButtonBuchungenAbfragen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonBuchungenAbfragen_ActionPerformed(evt);
      }
    });
    cp.add(jButtonBuchungenAbfragen);
    jLabelTagAuswaehlen.setBounds(32, 280, 115, 41);
    jLabelTagAuswaehlen.setText("Tag auswählen:");
    cp.add(jLabelTagAuswaehlen);
    jLabelMonatAuswaehlen.setBounds(32, 320, 115, 41);
    jLabelMonatAuswaehlen.setText("Monat auswählen:");
    cp.add(jLabelMonatAuswaehlen);

    jSpinnerTag.setBounds(160, 288, 46, 24);
    jSpinnerTag.setValue(1);
    jSpinnerTag.setModel(jSpinnerTagModel);
    cp.add(jSpinnerTag);


    jComboBox1.setModel(jComboBox1Model);
    jComboBox1.setBounds(160, 331, 150, 20);
    jComboBox1Model.addElement("Januar");
    jComboBox1Model.addElement("Februar");
    jComboBox1Model.addElement("März");
    jComboBox1Model.addElement("April");
    jComboBox1Model.addElement("Mai");
    jComboBox1Model.addElement("Juni");
    jComboBox1Model.addElement("Juli");
    jComboBox1Model.addElement("August");
    jComboBox1Model.addElement("September");
    jComboBox1Model.addElement("Oktober");
    jComboBox1Model.addElement("November");
    jComboBox1Model.addElement("Dezember");
    cp.add(jComboBox1);
    jButtonBuchungenAbfragen1.setBounds(360, 296, 121, 41);
    jButtonBuchungenAbfragen1.setText("Buchung abfragen");
    jButtonBuchungenAbfragen1.setMargin(new Insets(2, 2, 2, 2));
    jButtonBuchungenAbfragen1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButtonBuchungenAbfragen1_ActionPerformed(evt);
      }
    });
    cp.add(jButtonBuchungenAbfragen1);
    jLabelAusgabeBuchung.setBounds(32, 144, 323, 41);
    jLabelAusgabeBuchung.setText("");
    cp.add(jLabelAusgabeBuchung);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public gui
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new gui();  
  } // end of main
  
  public void jButtonBuchungenAbfragen_ActionPerformed(ActionEvent evt) {
    String wohnungen[]={"A","B","C","D"}; 
    int wahl = jNumberFieldWohnungsnummer.getInt();
    jLabelAusgabeBuchung.setText("Wohnung: " + wohnungen[wahl]);                                                   
  } // end of jButtonBuchungenAbfragen_ActionPerformed

  public void jButtonBuchungenAbfragen1_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of jButtonBuchungenAbfragen1_ActionPerformed

  // Ende Methoden
} // end of class gui
