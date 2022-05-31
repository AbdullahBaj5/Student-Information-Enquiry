package App;

import App.Client.InstructorClient;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class InstructorInfo extends javax.swing.JFrame{
    private javax.swing.JButton BackwardButton;
    private javax.swing.JComboBox<String> comboBoxList;
    private javax.swing.JLabel coursesLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JList<String> studentsInfoList;
    private Instructor instructor;
    private String [] students;

    public void centeredFrame(javax.swing.JFrame objFrame) {
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY);
    }

    public InstructorInfo(Instructor instructor) {
        this.instructor = instructor;

        initComponents();
        centeredFrame(this);

        this.jLabel1.setText("Welcome, Dr." + instructor.getName());
        addingListElements(instructor);
    }

    public void displayStudent(Instructor instructor) {
        studentsInfoList.setModel(new DefaultListModel<>());
        DefaultListModel listModel = new DefaultListModel();
        ArrayList <Student> students = instructor.searchCourse(String.valueOf(comboBoxList.getSelectedItem()).trim());
        for (int i = 0; i < students.size(); i++) {
            String studentElement = students.get(i).getName() + ", GPA: " + students.get(i).getGpa() + "\n";
            listModel.addElement(studentElement);
        }
        studentsInfoList.setModel(listModel);
    }

    public void addingListElements(Instructor instructor) {
        HashSet <Course> courses = instructor.getCourses();
        for(Course course: courses) {
            comboBoxList.addItem(course.getName());
        }
    }

    public void selectItem() {
        String selectedCourse = comboBoxList.getSelectedItem().toString();
        if (selectedCourse.equalsIgnoreCase("Select Course")) {
            studentsInfoList.setModel(new DefaultListModel<>());
            return;
        }
        displayStudent(instructor);
        ArrayList<Student> students = instructor.searchCourse(selectedCourse);
    }

    private void BackwardButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        studentNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsInfoList = new javax.swing.JList<>();
        coursesLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxList = new javax.swing.JComboBox<>();
        BackwardButton = new javax.swing.JButton();

        BackwardButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        BackwardButton.setText("Back");

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(770, 760));

        studentNameLabel.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        studentNameLabel.setText("Course");

        studentsInfoList.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(studentsInfoList);

        coursesLabel.setFont(new java.awt.Font("Dubai", 0, 18)); // NOI18N
        coursesLabel.setText("Students List");

        jLabel1.setFont(new java.awt.Font("Dubai", 1, 36)); // NOI18N
        jLabel1.setText("Welcome, Dr.");

        comboBoxList.setFont(new java.awt.Font("Dubai", 0, 12)); // NOI18N
        comboBoxList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Select Course"}));
        comboBoxList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectItem();
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
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(coursesLabel)
                                                        .addComponent(studentNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(88, 88, 88)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboBoxList, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(212, 212, 212)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(BackwardButton)))
                                .addContainerGap(190, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(BackwardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1)
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(studentNameLabel)
                                        .addComponent(comboBoxList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(156, 156, 156)
                                                .addComponent(coursesLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }


}
