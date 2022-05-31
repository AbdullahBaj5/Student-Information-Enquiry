package App;

import App.Client.InstructorClient;
import App.Client.StudentClient;

import java.awt.*;

public class App extends javax.swing.JFrame {
    private javax.swing.JButton aboutBtn;
    private javax.swing.JButton instructorBtn;
    private javax.swing.JLabel mainLabel;
    private javax.swing.JButton studentBtn;

    public App() {
        initComponents();
        centeredFrame(this);
    }

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    public void centeredFrame(javax.swing.JFrame objFrame) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        studentBtn = new javax.swing.JButton();
        instructorBtn = new javax.swing.JButton();
        mainLabel = new javax.swing.JLabel();
        aboutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Information Enquiry ");

        studentBtn.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        studentBtn.setText("Student");
        studentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentBtnActionPerformed(evt);
            }
        });

        instructorBtn.setFont(new java.awt.Font("Dubai", 0, 14)); // NOI18N
        instructorBtn.setText("Instructor");
        instructorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorBtnActionPerformed(evt);
            }
        });

        mainLabel.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        mainLabel.setText("Student Information Enquiry ");
        mainLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        aboutBtn.setFont(new java.awt.Font("Dubai", 0, 12)); // NOI18N
        aboutBtn.setText("About Us");
        aboutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(studentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(instructorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(mainLabel)
                                .addContainerGap(253, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aboutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(mainLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentBtn)
                                        .addComponent(instructorBtn))
                                .addGap(81, 81, 81)
                                .addComponent(aboutBtn)
                                .addGap(17, 17, 17))
        );

        pack();
    }

    private void instructorBtnActionPerformed(java.awt.event.ActionEvent evt) {
        InstructorClient inst = new InstructorClient();
        inst.setTitle("Login ( Instructor )");
        this.setVisible(false);
        inst.setVisible(true);
    }

    private void aboutBtnActionPerformed(java.awt.event.ActionEvent evt) {
        AboutUsPanel aboutPanel = new AboutUsPanel();
        aboutPanel.setTitle("About Us");
        aboutPanel.setVisible(true);
    }

    private void studentBtnActionPerformed(java.awt.event.ActionEvent evt) {
        StudentClient stu = new StudentClient();
        stu.setTitle("Login ( Student )");
        this.setVisible(false);
        stu.setVisible(true);
    }
}