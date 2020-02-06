package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;

class Calc extends JFrame {
    //Making labels, input-fields, radio-buttons, button, result-display
    JLabel labelxs = new JLabel("x start:");
    JTextField inputxs = new JTextField("", 1);

    JLabel labelxe = new JLabel("x end:");
    JTextField inputxe = new JTextField("", 1);

    JLabel labela = new JLabel("a:");
    JTextField inputa = new JTextField("", 1);

    JLabel labelb = new JLabel("b:");
    JTextField inputb = new JTextField("", 1);

    JLabel labelc = new JLabel("c:");
    JTextField inputc = new JTextField("", 1);

    JLabel labelStep = new JLabel("step:");
    JTextField inputStep = new JTextField("", 1);

    JRadioButton radio1 = new JRadioButton("y=ax^2+bx+c");
    JRadioButton radio2 = new JRadioButton("y=ax^3+bx^2+c");
    JRadioButton radio3 = new JRadioButton("y=2ax+bx+c");

    JButton calcButton = new JButton("Calculate");

    JLabel labelArea = new JLabel("Result:");
    JTextArea display = new JTextArea(1, 5);
    JScrollPane scroll = new JScrollPane();

    public Calc() {
        //Setting positions for swing widgets
        super("OOP 2");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(null);
        ButtonGroup group = new ButtonGroup();
        //inputs
        container.add(labelxs);
        labelxs.setBounds(20, 40, 80, 30);
        container.add(inputxs);
        inputxs.setBounds(100, 40, 50, 30);

        container.add(labelxe);
        labelxe.setBounds(20, 70, 80, 30);
        container.add(inputxe);
        inputxe.setBounds(100, 70, 50, 30);

        container.add(labela);
        labela.setBounds(20, 100, 80, 30);
        container.add(inputa);
        inputa.setBounds(100, 100, 50, 30);

        container.add(labelb);
        labelb.setBounds(20, 130, 80, 30);
        container.add(inputb);
        inputb.setBounds(100, 130, 50, 30);

        container.add(labelc);
        labelc.setBounds(20, 160, 80, 30);
        container.add(inputc);
        inputc.setBounds(100, 160, 50, 30);

        container.add(labelStep);
        labelStep.setBounds(20, 190, 80, 30);
        container.add(inputStep);
        inputStep.setBounds(100, 190, 50, 30);
        //radio-buttons
        group.add(radio1);
        radio1.setBounds(20, 270, 160, 30);

        group.add(radio2);
        radio2.setBounds(20, 300, 160, 30);

        group.add(radio3);
        radio3.setBounds(20, 330, 160, 30);

        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(radio3);
        //start-button
        container.add(calcButton);
        calcButton.setBounds(20, 370, 230, 30);
        calcButton.addActionListener(new ButtonEventListener());
        container.add(calcButton);
        //result-display
        container.add(labelArea);
        labelArea.setBounds(260, 10, 80, 30);
        container.add(scroll);
        scroll= new JScrollPane(display);
        scroll.setBounds(260, 40, 500, 360);
        getContentPane().add(scroll);
        setLocationRelativeTo ( null );
    }

    class ButtonEventListener implements ActionListener {
        String xs, xe, a, b, c, step;
        float fxs, fxe, fstep;
        int ia, ib, ic;

        public void actionPerformed(ActionEvent e) {
            //Getting text and converting
            try {
                xs = inputxs.getText();
                xe = inputxe.getText();
                a = inputa.getText();
                b = inputb.getText();
                c = inputc.getText();
                step = inputStep.getText();

                fxs = Float.parseFloat(xs);
                fxe = Float.parseFloat(xe);
                ia = Integer.parseInt(a);
                ib = Integer.parseInt(b);
                ic = Integer.parseInt(c);
                fstep = Float.parseFloat(step);

            } catch (Exception event) {
                display.setText("SOMETHING WRONG...");
            }
            //Checking input data
            if (fxe <= fxs || fstep <= 0) {
                display.setText("ERROR:  Xend <= Xstart ! OR YOU ENTERED WRONG DATA ! ");
            } else {
                float sx;
                if (radio1.isSelected()) {
                    display.setText("x:    y: \n");

                    float i = fxs;
                    while (i <= fxe) {
                        sx = i;
                        float y = (ia * (int) Math.pow(i, 2)) + (ib * sx) + ic;
                        String sy = String.valueOf(y);
                        display.setText(display.getText() + sx + "   " + sy + "\n");
                        i += fstep;
                    }
                } else if (radio2.isSelected()) {
                    display.setText("x:    y: \n");
                    float i = fxs;
                    while (i <= fxe) {
                        sx = i;
                        float y = (ia * (int) Math.pow(i, 3)) + (ib * i * i) + ic;
                        String sy = String.valueOf(y);
                        display.setText(display.getText() + sx + "   " + sy + "\n");
                        i += fstep;
                    }
                } else if (radio3.isSelected()) {
                    display.setText("x:    y: \n");
                    float i = fxs;
                    while (i <= fxe) {
                        sx = i;
                        float y = (2 * ia * i) + (ib * i) + ic;
                        String sy = String.valueOf(y);
                        display.setText(display.getText() + sx + "   " + sy + "\n");
                        i += fstep;
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Calc app = new Calc();
        app.setVisible(true);
        app.setSize(800, 500);
    }
}


