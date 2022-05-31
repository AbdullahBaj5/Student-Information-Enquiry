package App.Client;

import App.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class InstructorClient extends javax.swing.JFrame {
    private static PrintWriter out;
    private Socket socket;
    private javax.swing.JButton BackwardButton;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordPanel;
    private javax.swing.JButton resetBtn;
    private javax.swing.JCheckBox showPasswordCheck;
    private javax.swing.JLabel sidLabel;
    private javax.swing.JTextField usernameField;

    public InstructorClient() {
        initComponents();
        centeredFrame(this);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        sidLabel = new javax.swing.JLabel();
        passwordPanel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        loginLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        showPasswordCheck = new javax.swing.JCheckBox();
        loginBtn = new javax.swing.JButton();
        resetBtn = new javax.swing.JButton();
        BackwardButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(619, 478));
        setSize(new java.awt.Dimension(619, 478));

        sidLabel.setText("Instructor UID");

        passwordPanel.setText("Password");


        loginLabel.setFont(new java.awt.Font("Dubai", 1, 24)); // NOI18N
        loginLabel.setText("Login");


        showPasswordCheck.setText("Show Password");
        showPasswordCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckActionPerformed(evt);
            }
        });

        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        resetBtn.setText("Reset");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        BackwardButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        BackwardButton.setText("Back");
        BackwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackwardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(180, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(loginBtn).addGap(73, 73, 73).addComponent(resetBtn)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(passwordPanel).addComponent(sidLabel).addComponent(usernameField).addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(showPasswordCheck))).addGap(99, 99, 99)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(BackwardButton)).addGroup(layout.createSequentialGroup().addGap(263, 263, 263).addComponent(loginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(9, 9, 9).addComponent(BackwardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(19, 19, 19).addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGap(11, 11, 11).addComponent(sidLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(35, 35, 35).addComponent(passwordPanel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(showPasswordCheck)).addGap(27, 27, 27).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(loginBtn).addComponent(resetBtn)).addGap(91, 91, 91)));

        pack();
    }

    public void centeredFrame(javax.swing.JFrame objFrame) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            socket = new Socket("localhost", 5555);
            out = new PrintWriter(socket.getOutputStream(), true);

            JDialog box;
            JFrame errorDialog; // To let server know this connection type (student not instructor)
            JButton btn;
            
            // To let server know this connection type (instructor not student)
            out.println("Instructors");

            String sid = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (sid.equals("") || password.equals("")) {
                errorDialog = new JFrame();
                box = new JDialog(errorDialog, "Error: Empty Inputs", true);
                box.setLayout(new FlowLayout());
                btn = new JButton("OK");
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        box.setVisible(false);
                    }
                });
                box.add(new JLabel("ERROR: Inputs Cannot be Empty."));
                box.add(btn);
                btn.setBounds(65, 145, 20, 10);
                box.setSize(300, 150);
                box.setLocationRelativeTo(null);
                box.setVisible(true);
                return;
            }
            
            out.println(sid);
            out.println(password);

            DataInputStream in = new DataInputStream(socket.getInputStream());

            String line = null;
            line = in.readLine().trim();
            // If login has been successful or not
            if (line.equalsIgnoreCase("success")){
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Instructor instructor = (Instructor)objectInputStream.readObject();
                InstructorInfo ins = new InstructorInfo(instructor);
                if (evt.getSource() == loginBtn){
                    SuccessDialog successful = new SuccessDialog(this, true);
                    JOptionPane.showMessageDialog(successful, "You have successfully logged into the system");
                    successful.setVisible(false);
                    ins.setVisible(true);
                }
            } else if (line.equalsIgnoreCase("Error: File is Not Found.")) {
                errorDialog = new JFrame();
                box = new JDialog(errorDialog, "Error: Instructor is Not Found.", true);
                box.setLayout(new FlowLayout());
                btn = new JButton("OK");
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        box.setVisible(false);
                    }
                });
                box.add(new JLabel("ERROR: Instructor is Not Found in The System."));
                box.add(btn);
                btn.setBounds(65, 145, 20, 10);
                box.setSize(300, 150);
                box.setLocationRelativeTo(null);
                box.setVisible(true);
                return;
            }else if (line.equalsIgnoreCase("FAILURE")){
                errorDialog = new JFrame();
                box = new JDialog(errorDialog, "Error: Wrong password.", true);
                box.setLayout(new FlowLayout());
                btn = new JButton("OK");
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        box.setVisible(false);
                    }
                });
                box.add(new JLabel("ERROR: Wrong password."));
                box.add(btn);
                btn.setBounds(65, 145, 20, 10);
                box.setSize(300, 150);
                box.setLocationRelativeTo(null);
                box.setVisible(true);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }


    }

    private void showPasswordCheckActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == showPasswordCheck) {
            if (showPasswordCheck.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt.getSource() == resetBtn) {
            usernameField.setText("");
            passwordField.setText("");
        }

    }

    private void BackwardButtonActionPerformed(java.awt.event.ActionEvent evt) {
        App backwardFrame = new App();
        this.setVisible(false);
        backwardFrame.setVisible(true);
    }
}
