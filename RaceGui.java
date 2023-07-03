
package za.ac.cput.marathon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import za.ac.cput.marathon.RaceDAO;
/**
 *
 * @author zaihd
 */
public class RaceGui extends JFrame implements ActionListener
{
    private JPanel panelNorth;
    private JPanel panelCenter, panelClub;
    private JPanel panelSouth;
    
    private JLabel lblLogo;
    private JLabel lblHeading;
    private JLabel lblPadding0, lblPadding01, lblPadding1, lblPadding2, lblPadding3, lblPadding4, lblPadding5;
    
    private JLabel lblraceCode;
    private JTextField txtraceCode;
    
    private JLabel lblfirstName;
    private JTextField txtfirstName;
    
    private JLabel lbllastName;
    private JTextField txtlastName;
    
    private JLabel lblraceType;
    private JComboBox cboraceType;
    
    private JLabel lblClub;
    private JRadioButton radYes;
    private JRadioButton radNo;
    private ButtonGroup clubGroup;
    
    private JButton btnSave;
    private JButton btnReset;
    private JButton btnExit;
    
    ArrayList<Race> raceList = new ArrayList<>();
    
    String code;
    Race race;
    RaceDAO dao;
    
    private Font ft1, ft2, ft3, ft4;
    
    public RaceGui()
    {
        super("Marathon Event Registration App version 10");
        
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelClub = new JPanel();
        panelSouth = new JPanel();
        
        lblLogo = new JLabel();
        lblHeading = new JLabel("Marathon Event Registration");
        
        lblraceCode = new JLabel("Race Code");
        txtraceCode = new JTextField();
        
        lblfirstName = new JLabel("First Name");
        txtfirstName = new JTextField();
        
        lbllastName = new JLabel("Last Name");
        txtlastName = new JTextField();
        
        lblraceType = new JLabel("Race Type");
        cboraceType = new JComboBox(new String [] {"Ultra Marathon", "Full Marathon", "Half Marathon"});
        
        lblClub = new JLabel("Do you belong to a club");
        radYes = new JRadioButton("Yes");
        radNo = new JRadioButton("No");
        clubGroup = new ButtonGroup(); 
        
        lblPadding0 = new JLabel("");
        lblPadding01 = new JLabel("");
        lblPadding1 = new JLabel("");
        lblPadding2 = new JLabel("");
        lblPadding3 = new JLabel("");
        lblPadding4 = new JLabel("");
        lblPadding5 = new JLabel("");
        
        btnSave = new JButton("Save");
        btnReset = new JButton("Reset");
        btnExit = new JButton("Exit");
        
        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.PLAIN, 22);
        ft3 = new Font("Arial", Font.PLAIN, 24);
        ft4 = new Font("Arial", Font.ITALIC, 16);
    }
    
    public void setGUI()
    {
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(7,3));
        panelClub.setLayout(new GridLayout(1,2));
        panelSouth.setLayout(new GridLayout(1,3));
        
        panelNorth.add(lblHeading);
        panelNorth.add(lblLogo);
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.white);
        panelNorth.setBackground(new Color(0,106, 255));
        
        lblraceCode.setFont(ft2);
        lblraceCode.setHorizontalAlignment(JLabel.RIGHT);
        txtraceCode.setFont(ft2);
        panelCenter.add(lblraceCode);
        panelCenter.add(txtraceCode);
        panelCenter.add(lblPadding2);
        
        lblfirstName.setFont(ft2);
        lblfirstName.setHorizontalAlignment(JLabel.RIGHT);
        txtfirstName.setFont(ft2);
        panelCenter.add(lblfirstName);
        panelCenter.add(txtfirstName);
        panelCenter.add(lblPadding2);
        
        lbllastName.setFont(ft2);
        lbllastName.setHorizontalAlignment(JLabel.RIGHT);
        txtlastName.setFont(ft2);
        panelCenter.add(lbllastName);
        panelCenter.add(txtlastName);
        panelCenter.add(lblPadding2);
        
        lblraceType.setFont(ft2);
        lblraceType.setHorizontalAlignment(JLabel.RIGHT);
        cboraceType.setFont(ft2);
        panelCenter.add(lblraceType);
        panelCenter.add(cboraceType);
        panelCenter.add(lblPadding2);
        
        lblClub.setFont(ft2);
        lblClub.setHorizontalAlignment(JLabel.RIGHT);
        radYes.setFont(ft2);
        radYes.setHorizontalAlignment(JRadioButton.CENTER);
        radYes.setBackground(new Color(12, 145, 255));
        radNo.setFont(ft2);
        radNo.setHorizontalAlignment(JRadioButton.LEFT);
        radNo.setBackground(new Color(12, 145, 255));
        
        clubGroup.add(radYes);
        clubGroup.add(radNo);
        
        panelCenter.add(lblClub);
        panelClub.add(radYes);
        panelClub.add(radNo);
        panelClub.setBackground(new Color(36, 145, 255));
        panelCenter.add(panelClub);
        panelCenter.add(lblPadding4);
        
        btnSave.setFont(ft3);
        btnReset.setFont(ft3);
        btnExit.setFont(ft3);
        
        panelSouth.add(btnSave);
        panelSouth.add(btnReset);
        panelSouth.add(btnExit);
        
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnSave.addActionListener(this);
        btnReset.addActionListener(this);
        btnExit.addActionListener(this);
        
        this.setBackground(Color.blue);
        this.setSize(600, 600);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void resetFields()
    {
        txtraceCode.setText("");
        txtfirstName.setText("");
        txtlastName.setText("");
        clubGroup.clearSelection();
    }
        
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == btnSave)
        {
        String raceCode = txtraceCode.getText();
        String firstName = txtfirstName.getText();
        String lastName = txtlastName.getText();
        //String raceType = cboraceType.getSelectedIndex();
        
        Race rac = new Race(raceCode, firstName, lastName);
        
        race = dao.save(rac);
        if(race.equals(rac))
        {
            JOptionPane.showMessageDialog(null, "Success!");
        }else
        {
            JOptionPane.showMessageDialog(null, "Error!");
        }
        
        }else if(e.getActionCommand().equals("Reset"))
        {
            resetFields();
        }else if(e.getActionCommand().equals("Exit"))
        {
            System.exit(0);
        }    
    }
    
}
