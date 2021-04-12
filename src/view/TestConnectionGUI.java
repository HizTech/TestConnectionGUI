package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.GridBagConstraints;
import model.ConnectionDB;

public class TestConnectionGUI extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;

    private JPanel mainContainer = new JPanel();
    private JLabel labelTitle = new JLabel("PRUEBA CONEXIÓN");
    private JLabel labelIcon = new JLabel();
    private JButton btnConnect = new JButton("connectionDB");

    private GridBagLayout layout = new GridBagLayout();
    private GridBagConstraints config = new GridBagConstraints(); 

    public TestConnectionGUI(){

        this.setResizable(false);
        this.setSize(new Dimension(650, 600));
        this.setTitle("Conexión");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(mainContainer, BorderLayout.CENTER);

        mainContainer.setBackground(Color.WHITE);
        mainContainer.setLayout(layout);

        labelTitle.setFont(new Font("arial", Font.BOLD, 30) );
        labelTitle.setHorizontalAlignment(JLabel.CENTER);

        config.gridx=0;
        config.gridy=0;
        config.gridwidth=1;
        config.gridheight=1;
        config.anchor = GridBagConstraints.CENTER;
        config.fill = GridBagConstraints.BOTH;
        mainContainer.add(labelTitle, config);

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/icono.jpg"));
        labelIcon.setIcon(icon);
        labelIcon.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        config.gridy=1;
        config.insets = new Insets(10, 0, 0, 0);
        mainContainer.add(labelIcon, config);

        btnConnect.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnConnect.setFont(new Font("Arial", Font.BOLD, 20));
        btnConnect.addActionListener(this);

        config.gridy=2;
        config.ipady=20;
        config.insets = new Insets(10, 0, 10, 0);
        mainContainer.add(btnConnect, config);

    }

    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        TestConnectionGUI frame = new TestConnectionGUI();
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        Object evt = e.getSource();

        if(evt.equals(btnConnect)){

            ConnectionDB connectionDB = new ConnectionDB();
            Connection connect = connectionDB.openConnection();

            if(connect!=null){
            
                JOptionPane.showMessageDialog(null, "La Conexión con la base de datos, ha sido un éxito",
                 "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
            
            }else{

                JOptionPane.showMessageDialog(null, "No pudimos establecer conexión con la Base de datos", 
                "ERROR", JOptionPane.ERROR_MESSAGE);

            }

            

        }

    }

}
