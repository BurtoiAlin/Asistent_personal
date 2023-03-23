package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class PaginaAdaugaAliment extends JFrame {
    private JTextField[] text;
    private JLabel labelBackground, labelNumeAliment, labelGramaj, labelCalorii, labelProteine, labelCarbohidrati, labelGrasimi, labelTitlu;
    private JButton buton, butonIntoarcere;
    private String nume, aux;
    private short gramaj;
    private short calorii;
    private short proteine;
    private short carbohidrati;
    private short grasimi;

    public PaginaAdaugaAliment(){
        setTitle("Aliment nou");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);
        Font fontTitlu = new Font("Comic Sans", Font.BOLD, 26);
        Font fontLabel = new Font("Comic Sans",Font.BOLD,22);
        Font fontTextField = new Font("Comic Sans",Font.BOLD, 18);
        Font fontButon = new Font("Comic Sans", Font.BOLD, 16);

        text = new JTextField[6];
        for(int i = 0; i < 6; i++){
            text[i] = new JTextField(20);
            text[i].setFont(fontTextField);
        }

        labelBackground = new JLabel(new ImageIcon("poza16.png"));
        labelTitlu = new JLabel("Aliment nou");

        labelNumeAliment = new JLabel("Nume aliment");
        labelGramaj = new JLabel("Gramaj (g)");
        labelCalorii = new JLabel("Calorii (Kcal)");
        labelProteine = new JLabel("Proteine (g)");
        labelCarbohidrati = new JLabel("Carbohidrati (g)");
        labelGrasimi = new JLabel("Grasimi (g)");
        buton = new JButton("Adauga aliment");
        butonIntoarcere = new JButton("Inapoi");

        labelBackground.setBounds(1,1,800,600);//cel mai important
        labelTitlu.setBounds(220, 25, 305,40);
        labelNumeAliment.setBounds(50, 75,200,40);
        labelGramaj.setBounds(50, 120, 200, 40);
        labelCalorii.setBounds(50, 165, 200, 40);
        labelProteine.setBounds(50, 210, 200, 40);
        labelCarbohidrati.setBounds(50, 255, 200, 40);
        labelGrasimi.setBounds(50, 300, 200, 40);

        labelTitlu.setFont(fontTitlu);
        labelNumeAliment.setFont(fontLabel);
        labelGramaj.setFont(fontLabel);
        labelCalorii.setFont(fontLabel);
        labelProteine.setFont(fontLabel);
        labelCarbohidrati.setFont(fontLabel);
        labelGrasimi.setFont(fontLabel);

        labelTitlu.setForeground(Color.black);
        labelNumeAliment.setForeground(Color.black);
        labelGramaj.setForeground(Color.black);
        labelCalorii.setForeground(Color.black);
        labelProteine.setForeground(Color.black);
        labelCarbohidrati.setForeground(Color.black);
        labelGrasimi.setForeground(Color.black);

        text[0].setBounds(215, 80, 200, 30);
        text[1].setBounds(215, 125, 200, 30);
        text[2].setBounds(215, 170, 200, 30);
        text[3].setBounds(215, 215, 200, 30);
        text[4].setBounds(215, 260, 200, 30);
        text[5].setBounds(215, 305, 200, 30);

        buton.setBounds(240, 470, 305, 30);
        buton.setBackground(Color.WHITE);
        buton.setForeground(Color.BLACK);
        buton.setFont(fontButon);

        butonIntoarcere.setBounds(50, 30, 100, 30 );
        butonIntoarcere.setBackground(Color.WHITE);
        butonIntoarcere.setForeground(Color.BLACK);
        butonIntoarcere.setFont(fontButon);

        labelBackground.add(labelTitlu);
        labelBackground.add(buton);
        labelBackground.add(butonIntoarcere);
        labelBackground.add(labelNumeAliment);
        labelBackground.add(labelGramaj);
        labelBackground.add(labelCalorii);
        labelBackground.add(labelProteine);
        labelBackground.add(labelCarbohidrati);
        labelBackground.add(labelGrasimi);

        for(int i = 0; i < 6; i++){
            labelBackground.add(text[i]);
        }

        add(labelBackground);

        setVisible(true);

        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nume = text[0].getText();

                aux = text[1].getText();
                gramaj = Short.parseShort(aux);
                aux = null;

                aux = text[2].getText();
                calorii = Short.parseShort(aux);
                aux = null;

                aux = text[3].getText();
                proteine = Short.parseShort(aux);
                aux = null;

                aux = text[4].getText();
                carbohidrati = Short.parseShort(aux);
                aux = null;

                aux = text[5].getText();
                grasimi = Short.parseShort(aux);
                aux = null;

                try {
                    Salvare();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JFrame frameNutritie = null;
                try {
                    frameNutritie = new PaginaNutritie();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                frameNutritie.setVisible(true);
                frameNutritie.setSize(800, 600);
                PaginaAdaugaAliment.this.dispose();
            }
        });

        butonIntoarcere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameNutritie = null;
                try {
                    frameNutritie = new PaginaNutritie();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                frameNutritie.setSize(800,600);
                frameNutritie.setVisible(true);
                PaginaAdaugaAliment.this.dispose();
            }
        });
    }
    public void Salvare() throws IOException {
        String str = this.nume + ", " + this.gramaj + ", " + this.calorii + ", " + this.proteine + ", " + this.carbohidrati + ", " + this.grasimi;

        BufferedWriter scrie = new BufferedWriter(new FileWriter("Alimente.txt", true));
        scrie.append("\n");
        scrie.append(str);
        scrie.close();
    }

    public static void main(String[] args){
        PaginaAdaugaAliment window = new PaginaAdaugaAliment();
    }
}
