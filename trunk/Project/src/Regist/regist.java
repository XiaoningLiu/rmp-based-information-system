/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Regist;

import PaperManagement.Infor;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author dianer
 */
public class regist extends javax.swing.JFrame {
    Infor infor = new Infor();
    

    /**
     * Creates new form regist
     */
    public regist(Infor inf) {
        infor = inf; 
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userid = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        education = new javax.swing.JLabel();
        useridtext = new javax.swing.JTextField();
        emailtext = new javax.swing.JTextField();
        nametext = new javax.swing.JTextField();
        educationtext = new javax.swing.JTextField();
        addresstext = new javax.swing.JTextField();
        regist = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        passwordtext = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Regist");
        setName(""); // NOI18N
        setResizable(false);

        userid.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        userid.setText("UserId");

        password.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        password.setText("Password");

        email.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        email.setText("Email");

        name.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        name.setText("Name");

        address.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        address.setText("Address");

        education.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        education.setText("Education");

        useridtext.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        useridtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useridtextActionPerformed(evt);
            }
        });
        useridtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                useridtextKeyTyped(evt);
            }
        });

        emailtext.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        emailtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtextActionPerformed(evt);
            }
        });

        nametext.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        nametext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametextActionPerformed(evt);
            }
        });

        educationtext.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        educationtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                educationtextActionPerformed(evt);
            }
        });

        addresstext.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        addresstext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addresstextActionPerformed(evt);
            }
        });

        regist.setText("Regist");
        regist.setMaximumSize(new java.awt.Dimension(63, 23));
        regist.setPreferredSize(new java.awt.Dimension(69, 28));
        regist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registMouseClicked(evt);
            }
        });
        regist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.setMaximumSize(new java.awt.Dimension(63, 23));
        cancel.setPreferredSize(new java.awt.Dimension(69, 28));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userid)
                    .addComponent(password)
                    .addComponent(education)
                    .addComponent(address)
                    .addComponent(name)
                    .addComponent(email))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(useridtext, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(emailtext)
                    .addComponent(nametext)
                    .addComponent(addresstext)
                    .addComponent(educationtext)
                    .addComponent(passwordtext))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(regist, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userid)
                    .addComponent(useridtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password)
                    .addComponent(passwordtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email)
                    .addComponent(emailtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(nametext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address)
                    .addComponent(addresstext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(education)
                    .addComponent(educationtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void useridtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useridtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useridtextActionPerformed

    private void emailtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtextActionPerformed

    private void nametextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametextActionPerformed

    private void educationtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_educationtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_educationtextActionPerformed

    private void addresstextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addresstextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addresstextActionPerformed

    private void registActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registActionPerformed
        Vector columns=new Vector();
        columns.add("primarykey");
        columns.add("psd");
        columns.add("email");
        columns.add("name");
        columns.add("address");
        columns.add("education");
        columns.add("type");
        Vector values=new Vector();
        values.add(useridtext.getText());
        values.add(passwordtext.getText());
        values.add(emailtext.getText());
        values.add(nametext.getText());
        values.add(addresstext.getText());
        values.add(educationtext.getText());
        values.add("common");
        if(infor.jx.getTableRows("User", columns, useridtext.getText())[0].isEmpty())
        {
            infor.jx.postTableRow("User", useridtext.getText(), columns, values);
            this.setVisible(false);         // TODO add your handling code here:
        }
           else
                JOptionPane.showMessageDialog(null, "Your UserId has been registed!", "Notice", JOptionPane.OK_OPTION);                         
   
    }//GEN-LAST:event_registActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
           // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void registMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_registMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
this.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_cancelActionPerformed

    private void useridtextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_useridtextKeyTyped
 if ((evt.getKeyChar() >= KeyEvent.VK_0 && evt.getKeyChar() <= evt.VK_9) 
      || evt.getKeyChar() == evt.VK_ENTER || evt.getKeyChar() == evt.VK_TAB
      || evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE 
      || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT 
      || evt.getKeyChar() == evt.VK_ESCAPE) 
      return;   
     evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_useridtextKeyTyped

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
            java.util.logging.Logger.getLogger(regist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(regist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(regist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(regist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new regist().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JTextField addresstext;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel education;
    private javax.swing.JTextField educationtext;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailtext;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nametext;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordtext;
    private javax.swing.JButton regist;
    private javax.swing.JLabel userid;
    private javax.swing.JTextField useridtext;
    // End of variables declaration//GEN-END:variables
}
