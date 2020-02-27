package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Grafika extends JFrame {
    JRadioButton radio1 = new JRadioButton("y=ax^2+bx+c");
    JRadioButton radio2 = new JRadioButton("y=ax^3+bx^2+c");
    JRadioButton radio3 = new JRadioButton("y=ax^4+bx+c");

    JLabel labela = new JLabel("Input a:");
    JTextField inputa = new JTextField("", 1);

    JLabel labelb = new JLabel("Input b:");
    JTextField inputb = new JTextField("", 1);

    JLabel labelc = new JLabel("Input c:");
    JTextField inputc = new JTextField("", 1);

    JLabel labelxs = new JLabel("x(start):");
    JTextField inputxs = new JTextField("", 1);

    JLabel labelxe = new JLabel("x(end)  :");
    JTextField inputxe = new JTextField("", 1);

    JButton button = new JButton("calculate");

    ButtonGroup group = new ButtonGroup();
    Pan pan = new Pan(this);

    Grafika() {
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        group.add(radio1);
        radio1.setBounds(15, 20, 150, 20);

        group.add(radio2);
        radio2.setBounds(15, 50, 150, 20);

        group.add(radio3);
        radio3.setBounds(15, 80, 150, 20);

        this.add(radio1);
        radio1.setSelected(true);
        this.add(radio2);
        this.add(radio3);

        this.add(labela);
        labela.setBounds(15, 110, 60, 20);
        this.add(inputa);
        inputa.setBounds(70, 110, 90, 20);

        this.add(labelb);
        labelb.setBounds(15, 140, 60, 20);
        this.add(inputb);
        inputb.setBounds(70, 140, 90, 20);

        this.add(labelc);
        labelc.setBounds(15, 170, 60, 20);
        this.add(inputc);
        inputc.setBounds(70, 170, 90, 20);

        this.add(labelxs);
        labelxs.setBounds(15, 200, 60, 20);
        this.add(inputxs);
        inputxs.setBounds(70, 200, 90, 20);

        this.add(labelxe);
        labelxe.setBounds(15, 230, 60, 20);
        this.add(inputxe);
        inputxe.setBounds(70, 230, 90, 20);

        this.add(button);
        button.setBounds(15, 260, 150, 20);
        button.addActionListener(pan);
    }

    class Pan implements ActionListener {
        int a = 0, b = 0, c = 0, xs = 0, xe = 0;

        Pain pain = new Pain(this);
        Grafika gl;

        Pan(Grafika p) {
            this.gl = p;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                a = Integer.parseInt(gl.inputa.getText());
                b = Integer.parseInt(gl.inputb.getText());
                c = Integer.parseInt(gl.inputc.getText());
                xs = Integer.parseInt(gl.inputxs.getText());
                xe = Integer.parseInt(gl.inputxe.getText());
            } catch (NumberFormatException event) {
                System.out.println("Error");
            }

            if (gl.radio1.isSelected()) {


                if (e.getSource() == gl.button) {
                    pain.setBounds(350, 0, 400, 400);
                    gl.add(pain);
                    gl.repaint();
                }
            }
            if (gl.radio2.isSelected()) {

                if (e.getSource() == gl.button) {
                    pain.setBounds(350, 0, 400, 400);
                    gl.add(pain);
                    gl.repaint();
                }

            } else if (gl.radio3.isSelected()) {
                if (e.getSource() == gl.button) {
                    pain.setBounds(350, 0, 400, 400);
                    gl.add(pain);
                    gl.repaint();
                }

            }
            if (xs > xe) {
                if (e.getSource() == gl.button) {
                    System.out.println("Error");
                    JOptionPane.showMessageDialog(null, "X start is big than X end");
                }
            }


        }
    }

    class Pain extends JPanel {
        Pan pn;

        Pain(Pan p) {
            this.pn = p;

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.drawLine(200, 50, 200, 350);
            g.setColor(Color.BLACK);
            g.drawLine(0, 200, 400, 200);

            if (pn.gl.radio1.isSelected()) {
                for (int i = pn.xs; i <= pn.xe; i++) {
                    int y1 = pn.a * (i * i) + pn.b * i + pn.c;
                    ;
                    int y2 = pn.a * (i + 1) * (i + 1) + pn.b * (i + 1) + pn.c;


                    g.setColor(Color.BLUE);
                    g.drawLine(200 + i, 200 - y1, 200 + i, 200 - y2);
                }
            } else if (pn.gl.radio2.isSelected()) {
                for (int i = pn.xs; i <= pn.xe; i++) {
                    int y1 = (pn.a * (i * i * i)) + (pn.b * (i * i)) + pn.c;
                    int y2 = (pn.a * (i + 1) * (i + 1) * (i + 1)) + (pn.b * (i + 1) * (i + 1)) + pn.c;
                    g.setColor(Color.BLUE);
                    g.drawLine(200 + i, 200 - y1, 200 + i, 200 - y2);
                }

            } else if (pn.gl.radio3.isSelected()) {
                for (int i = pn.xs; i <= pn.xe; i++) {
                    int y1 = (pn.a * (i * i * i * i)) + (pn.b * i) + pn.c;
                    int y2 = (pn.a * (i + 1) * (i + 1) * (i + 1) * (i + 1)) + (pn.b * (i + 1) + pn.c);
                    g.setColor(Color.BLUE);
                    g.drawLine(200 + i, 200 - y1, 200 + i, 200 - y2);
                }
            }
        }
    }
}
