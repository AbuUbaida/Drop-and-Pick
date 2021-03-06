
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))
                    == false) {
                return false;
            }
        }

        return true;
    }

    ArrayList<String> ItemList = new ArrayList<String>();
    public String path;

    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pair = new javax.swing.ButtonGroup();
        message = new javax.swing.JOptionPane();
        jPanel1 = new javax.swing.JPanel();
        inputField = new javax.swing.JTextField();
        inputButton = new javax.swing.JButton();
        outputField = new javax.swing.JTextField();
        outputButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Drop and Pick");
        setLocationByPlatform(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inputField.setEditable(false);
        inputField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        inputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFieldActionPerformed(evt);
            }
        });
        jPanel1.add(inputField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 350, 30));

        inputButton.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        inputButton.setText("Choose file");
        inputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputButtonActionPerformed(evt);
            }
        });
        jPanel1.add(inputButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 110, 30));

        outputField.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        outputField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        outputField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        outputField.setEnabled(false);
        jPanel1.add(outputField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 470, 82));

        outputButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        outputButton.setText("Pick");
        outputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputButtonActionPerformed(evt);
            }
        });
        jPanel1.add(outputButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 252, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 19)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Drop and Pick");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFieldActionPerformed

    }//GEN-LAST:event_inputFieldActionPerformed

    private void inputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputButtonActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(jPanel1);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            inputField.setText(path);
        }
        try {
            FileReader inputFile = new FileReader(path);
            try {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine()) {
                    String line = parser.nextLine();
                    ItemList.add(line);

                }

            } finally {
                inputFile.close();
            }
        } catch (FileNotFoundException exception) {
            System.out.println(" not found");
        } catch (IOException exception) {
            System.out.println("Unexpected I/O error occured.");
        }

//        if (isNumber(inputField.getText())) {
//            NumberList.add(inputField.getText());
//        } else {
//            ItemList.add(inputField.getText());
//        }
//        inputField.setText("");

    }//GEN-LAST:event_inputButtonActionPerformed

    private void outputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputButtonActionPerformed

            try {

                if (ItemList.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All the items are picked up!", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
                int randomIndex = (int) (Math.random() * ItemList.size());
                outputField.setText(ItemList.get(randomIndex));
                ItemList.remove(randomIndex);
            } catch (Exception e) {

            }
    }//GEN-LAST:event_outputButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inputButton;
    private javax.swing.JTextField inputField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JOptionPane message;
    private javax.swing.JButton outputButton;
    private javax.swing.JTextField outputField;
    private javax.swing.ButtonGroup pair;
    // End of variables declaration//GEN-END:variables
}
