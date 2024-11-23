
package guilibrarysystem;

import DataBase.User;
import DataBase.user_CRUD;
import java.awt.Color;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 96650
 */
public class User_Account_window extends javax.swing.JFrame {
 private User currentUser;
    /**
     * Creates new form User_Account_window
     */
 
    public User_Account_window(User currentUser) throws ParseException {
        initComponents();
        this.currentUser = currentUser;
        initialize();
        Color backgroundColor = new Color(51,51,51);
        getContentPane().setBackground(backgroundColor);
    }
    public void initialize() throws ParseException {
    if (currentUser != null) {
        userNamelabel.setText("Hi, " + currentUser.getUsername());
    } else {
        userNamelabel.setText("Hi, Guest");
    }
    User_Name.setText(currentUser.getUsername());
    User_Email.setText(currentUser.getEmail());
    
 // Initialize user profile data
if (currentUser.getSex() != null) {
    String userSex = currentUser.getSex();
    sexCombox.setSelectedItem(userSex);
} else {
    sexCombox.setSelectedItem("Female");
}

if (currentUser.getNationality() != null) {
    NationalityTextField.setText(currentUser.getNationality());
} else {
    NationalityTextField.setText("Unknown");
}

if (currentUser.getBirthday() != null) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    BirthdayTextField.setText(dateFormat.format(currentUser.getBirthday()));
} else {
    BirthdayTextField.setText("2025-01-01"); // Default placeholder
}

    
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back3 = new javax.swing.JLabel();
        userNamelabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Edit_Profile_Button = new javax.swing.JButton();
        User_Nationality1 = new javax.swing.JLabel();
        Logout_Button = new javax.swing.JButton();
        NameLable = new javax.swing.JLabel();
        EmailLable = new javax.swing.JLabel();
        BdLable = new javax.swing.JLabel();
        NationalityLable = new javax.swing.JLabel();
        SexLable = new javax.swing.JLabel();
        User_Name = new javax.swing.JLabel();
        User_Email = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        sexCombox = new javax.swing.JComboBox<>();
        NationalityTextField = new javax.swing.JTextField();
        BirthdayTextField = new javax.swing.JTextField();
        Submitbtn = new javax.swing.JButton();
        back4 = new javax.swing.JLabel();

        back3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back3MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userNamelabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        userNamelabel.setForeground(java.awt.Color.white);
        userNamelabel.setText("Hi Shjoon Almutairi");
        userNamelabel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                userNamelabelPropertyChange(evt);
            }
        });

        jPanel1.setBackground(java.awt.Color.white);

        Edit_Profile_Button.setBackground(new java.awt.Color(255, 204, 153));
        Edit_Profile_Button.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Edit_Profile_Button.setText("Edit info");
        Edit_Profile_Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 153)));
        Edit_Profile_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Edit_Profile_ButtonActionPerformed(evt);
            }
        });

        User_Nationality1.setBackground(new java.awt.Color(255, 255, 255));
        User_Nationality1.setForeground(new java.awt.Color(51, 51, 51));
        User_Nationality1.setText("User Information:");
        User_Nationality1.setToolTipText("");

        Logout_Button.setBackground(new java.awt.Color(51, 51, 51));
        Logout_Button.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Logout_Button.setForeground(new java.awt.Color(204, 204, 204));
        Logout_Button.setText("LogOut");
        Logout_Button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Logout_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Logout_ButtonActionPerformed(evt);
            }
        });

        NameLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NameLable.setForeground(new java.awt.Color(51, 51, 51));
        NameLable.setText("Name:");

        EmailLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmailLable.setForeground(new java.awt.Color(51, 51, 51));
        EmailLable.setText("Email:");

        BdLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BdLable.setForeground(new java.awt.Color(51, 51, 51));
        BdLable.setText("Birthdate:");

        NationalityLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NationalityLable.setForeground(new java.awt.Color(51, 51, 51));
        NationalityLable.setText("Nationality:");

        SexLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SexLable.setForeground(new java.awt.Color(51, 51, 51));
        SexLable.setText("Sex:");

        User_Name.setBackground(new java.awt.Color(255, 255, 255));
        User_Name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        User_Name.setForeground(new java.awt.Color(51, 51, 51));
        User_Name.setText("Shjoon Almutairi");
        User_Name.setToolTipText("");

        User_Email.setBackground(new java.awt.Color(255, 255, 255));
        User_Email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        User_Email.setForeground(new java.awt.Color(51, 51, 51));
        User_Email.setText("Shjoon.ns.al@gmail.com");
        User_Email.setToolTipText("");

        sexCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        sexCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexComboxActionPerformed(evt);
            }
        });

        NationalityTextField.setText("Ex: Saudi");
        NationalityTextField.setToolTipText("");
        NationalityTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NationalityTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                NationalityTextFieldFocusLost(evt);
            }
        });
        NationalityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NationalityTextFieldActionPerformed(evt);
            }
        });

        BirthdayTextField.setText("(yyyy-MM-dd)");
        BirthdayTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BirthdayTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BirthdayTextFieldFocusLost(evt);
            }
        });

        Submitbtn.setBackground(new java.awt.Color(255, 204, 153));
        Submitbtn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Submitbtn.setText("Submit");
        Submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(User_Nationality1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Edit_Profile_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BirthdayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(sexCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(User_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BdLable, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SexLable, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(User_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EmailLable, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Logout_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NationalityLable, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NationalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(User_Nationality1)
                    .addComponent(Edit_Profile_Button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(EmailLable)
                        .addGap(4, 4, 4)
                        .addComponent(User_Email))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(NameLable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(User_Name)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BdLable)
                    .addComponent(SexLable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BirthdayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(NationalityLable)
                .addGap(8, 8, 8)
                .addComponent(NationalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Submitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Logout_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        back4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/left-arrow (2).png"))); // NOI18N
        back4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back4)
                        .addGap(18, 18, 18)
                        .addComponent(userNamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(userNamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back4)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Edit_Profile_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edit_Profile_ButtonActionPerformed
        this.toBack();
        Edit_Profile GoTo_Edit_Profile = new Edit_Profile(currentUser);
        GoTo_Edit_Profile.setVisible(true);
        GoTo_Edit_Profile.toFront();
    }//GEN-LAST:event_Edit_Profile_ButtonActionPerformed

    private void Logout_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Logout_ButtonActionPerformed
        int response = JOptionPane.showConfirmDialog(null,"you will logout!","Are you sure?",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Logged out successfully!");
             currentUser = null;
             Login log = new Login();
             log.setVisible(true);
             this.dispose();
        }else{  
        }
    }//GEN-LAST:event_Logout_ButtonActionPerformed

    private void back3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_back3MouseClicked

    private void back4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back4MouseClicked
        // TODO add your handling code here:
        MainD main = new MainD(currentUser);
        main.initialize(); 
        main.setVisible(true);
        main.pack();
        main.setLocationRelativeTo(null);//to the center
        this.dispose();
    }//GEN-LAST:event_back4MouseClicked

    private void userNamelabelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_userNamelabelPropertyChange
        // TODO add your handling code here:
       
    }//GEN-LAST:event_userNamelabelPropertyChange

    private void sexComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexComboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexComboxActionPerformed

    private void NationalityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NationalityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NationalityTextFieldActionPerformed

    private void BirthdayTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BirthdayTextFieldFocusGained
        // TODO add your handling code here:
         if (BirthdayTextField.getText().equals("Enter date (yyyy-MM-dd)")) {
                    BirthdayTextField.setText("");
                    BirthdayTextField.setForeground(Color.BLACK); // Change text color for input
                }
    }//GEN-LAST:event_BirthdayTextFieldFocusGained

    private void BirthdayTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BirthdayTextFieldFocusLost
        // TODO add your handling code here:
                 if (BirthdayTextField.getText().isEmpty()) {
                    BirthdayTextField.setText("Enter date (yyyy-MM-dd)");
                    BirthdayTextField.setForeground(Color.GRAY); // Placeholder text color
                }
    }//GEN-LAST:event_BirthdayTextFieldFocusLost

    private void NationalityTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NationalityTextFieldFocusGained
        // TODO add your handling code here:
          if (NationalityTextField.getText().equals("Ex: Saudi")) {
            NationalityTextField.setText("");
            NationalityTextField.setForeground(Color.BLACK); // Change color for user input
        }
    }//GEN-LAST:event_NationalityTextFieldFocusGained

    private void NationalityTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NationalityTextFieldFocusLost
        // TODO add your handling code here:
        if (NationalityTextField.getText().isEmpty()) {
            NationalityTextField.setText("Ex: Saudi");
            NationalityTextField.setForeground(Color.GRAY); // Reset color to placeholder
        }
    }//GEN-LAST:event_NationalityTextFieldFocusLost

    private void SubmitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitbtnActionPerformed
        // TODO add your handling code here:
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sex = sexCombox.getSelectedItem().toString();
        java.util.Date utilDate;
        utilDate = dateFormat.parse(BirthdayTextField.getText());
        Date sqlDate = new Date(utilDate.getTime());
        String nationality = NationalityTextField.getText().trim();
        user_CRUD userCrud = new user_CRUD();
        userCrud.updateUserProfile(currentUser.getId(), sex, sqlDate, nationality);
        JOptionPane.showMessageDialog(this, "Profile updated successfully!");
            
            currentUser.setSex(sex);
            currentUser.setBirthday(sqlDate);
            currentUser.setNationality(nationality);
            
            initialize();
     }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating profile: " + e.getMessage());
     }
    }//GEN-LAST:event_SubmitbtnActionPerformed

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
            java.util.logging.Logger.getLogger(User_Account_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Account_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Account_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Account_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BdLable;
    private javax.swing.JTextField BirthdayTextField;
    private javax.swing.JButton Edit_Profile_Button;
    private javax.swing.JLabel EmailLable;
    private javax.swing.JButton Logout_Button;
    private javax.swing.JLabel NameLable;
    private javax.swing.JLabel NationalityLable;
    private javax.swing.JTextField NationalityTextField;
    private javax.swing.JLabel SexLable;
    private javax.swing.JButton Submitbtn;
    private javax.swing.JLabel User_Email;
    private javax.swing.JLabel User_Name;
    private javax.swing.JLabel User_Nationality1;
    private javax.swing.JLabel back3;
    private javax.swing.JLabel back4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> sexCombox;
    private javax.swing.JLabel userNamelabel;
    // End of variables declaration//GEN-END:variables
}


