package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Meniu extends JFrame{

    private JPanel scindare;
    private JButton butonAntrenament, butonNutritie, butonIntoarcere;

    public Meniu(){
        super("Meniu");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scindare = new JPanel(new GridLayout(1,2,0,0));

        butonAntrenament = new JButton(new ImageIcon("poza1.png"));
        butonNutritie = new JButton(new ImageIcon("poza2.png"));

        butonIntoarcere = new JButton("Delogare");
        butonIntoarcere.setForeground(Color.BLACK);
        butonIntoarcere.setBackground(Color.WHITE);

        scindare.add(butonAntrenament);
        scindare.add(butonNutritie);

        add(scindare);
        add(butonIntoarcere, BorderLayout.SOUTH);
        setVisible(true);

        butonAntrenament.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAntrenamente = null;
                try {
                    frameAntrenamente = new PaginaAntrenamente();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frameAntrenamente.setVisible(true);
                Meniu.this.dispose();
            }
        });

        butonNutritie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameNutritie = null;
                try {
                    frameNutritie = new PaginaNutritie();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                frameNutritie.setVisible(true);
                Meniu.this.dispose();
            }
        });

        butonIntoarcere.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFrame frameLogare = null;
                frameLogare = new PaginaLogare();
                frameLogare.setVisible(true);
                Meniu.this.dispose();
            }
        });
    }

//    public static void main(String[] args){
//        Meniu fereastra = new Meniu();
//    }
}