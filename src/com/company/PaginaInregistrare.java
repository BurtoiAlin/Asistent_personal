package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PaginaInregistrare extends JFrame {
    private JTextField[] text;
    private JPasswordField parolaF;
    private JLabel labelBackground, labelInregistrare, labelNume, labelPrenume, labelUsername,
            labelParola, labelVarsta, labelInaltime, labelGreutate, labelSex;
    private JButton buton, butonIntoarcere;
    private JComboBox comboBoxSex;
    private String aux, nume, prenume, userName, parola;
    private byte varsta;
    private short inaltime;
    private float greutate;
    private boolean sex;

    public PaginaInregistrare(){
        setTitle("Pagina de inregistrare");
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);
        Font fontTitlu = new Font("Comic Sans", Font.BOLD, 26);
        Font fontLabel = new Font("Comic Sans",Font.BOLD,22);
        Font fontTextField = new Font("Comic Sans",Font.BOLD, 18);
        Font fontButon = new Font("Comic Sans", Font.BOLD, 16);

        text = new JTextField[6];
        parolaF = new JPasswordField();

        for(int i = 0; i < 6; i++){
            text[i] = new JTextField(20);
            text[i].setFont(fontTextField);
        }

        labelBackground = new JLabel(new ImageIcon("poza11.png"));
        labelInregistrare = new JLabel("Inregistrare");

        labelNume = new JLabel("Nume");
        labelPrenume = new JLabel("Prenume");
        labelUsername = new JLabel("Username");
        labelParola = new JLabel("Parola");
        labelVarsta = new JLabel("Varsta");
        labelInaltime = new JLabel("Inaltime (cm)");
        labelGreutate = new JLabel("Greutate");
        labelSex = new JLabel("Sex");
        buton = new JButton("Inregistrare");
        butonIntoarcere = new JButton("Inapoi");
        parolaF = new JPasswordField();
        parolaF.setFont(fontTextField);

        labelBackground.setBounds(1,1,800,600);//cel mai important
        labelInregistrare.setBounds(310, 25, 305,40);
        labelNume.setBounds(210, 75,200,40);
        labelPrenume.setBounds(210, 120, 200, 40);
        labelUsername.setBounds(210, 165, 200, 40);
        labelParola.setBounds(210, 210, 200, 40);
        labelVarsta.setBounds(210, 255, 200, 40);
        labelInaltime.setBounds(210, 300, 200, 40);
        labelGreutate.setBounds(210, 345, 200, 40);
        labelSex.setBounds(210, 390, 200, 40);

        labelInregistrare.setFont(fontTitlu);
        labelNume.setFont(fontLabel);
        labelPrenume.setFont(fontLabel);
        labelUsername.setFont(fontLabel);
        labelParola.setFont(fontLabel);
        labelVarsta.setFont(fontLabel);
        labelInaltime.setFont(fontLabel);
        labelGreutate.setFont(fontLabel);
        labelSex.setFont(fontLabel);

        labelInregistrare.setForeground(Color.black);
        labelNume.setForeground(Color.black);
        labelPrenume.setForeground(Color.black);
        labelUsername.setForeground(Color.black);
        labelParola.setForeground(Color.black);
        labelVarsta.setForeground(Color.black);
        labelInaltime.setForeground(Color.black);
        labelGreutate.setForeground(Color.black);
        labelSex.setForeground(Color.black);

        String[] gen = {"Masculin", "Feminin"};
        comboBoxSex = new JComboBox(gen);

        text[0].setBounds(375, 80, 200, 30);
        text[1].setBounds(375, 125, 200, 30);
        text[2].setBounds(375, 170, 200, 30);
        parolaF.setBounds(375, 215, 200, 30);
        text[3].setBounds(375, 260, 200, 30);
        text[4].setBounds(375, 305, 200, 30);
        text[5].setBounds(375, 350, 200, 30);
        comboBoxSex.setBounds(375,395,200,30);
        comboBoxSex.setFont(fontTextField);

        buton.setBounds(240, 470, 305, 30);
        buton.setBackground(Color.WHITE);
        buton.setForeground(Color.BLACK);
        buton.setFont(fontButon);

        butonIntoarcere.setBounds(50, 30, 100, 30 );
        butonIntoarcere.setBackground(Color.WHITE);
        butonIntoarcere.setForeground(Color.BLACK);
        butonIntoarcere.setFont(fontButon);

        labelBackground.add(comboBoxSex);
        labelBackground.add(labelInregistrare);
        labelBackground.add(buton);
        labelBackground.add(butonIntoarcere);
        labelBackground.add(labelNume);
        labelBackground.add(labelPrenume);
        labelBackground.add(labelUsername);
        labelBackground.add(labelParola);
        labelBackground.add(labelVarsta);
        labelBackground.add(labelInaltime);
        labelBackground.add(labelGreutate);
        labelBackground.add(labelSex);

        for(int i = 0; i < 6; i++) {
            labelBackground.add((text[i]));
        }

        add(parolaF);
        add(labelBackground);

        setVisible(true);

        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nume = text[0].getText();
                prenume = text[1].getText();
                userName = text[2].getText();

                parola = new String(parolaF.getPassword());
                aux = text[3].getText();
                varsta = Byte.parseByte(aux);
                aux = null;
                aux = text[4].getText();
                greutate = Float.parseFloat(aux);
                aux = null;
                aux = text[5].getText();
                inaltime = Short.parseShort(aux);
                aux = null;
                aux = String.valueOf(comboBoxSex.getSelectedItem());
                if(aux.equals("Masculin")){
                    sex = true;
                }
                else{
                    sex = false;
                }
                aux = null;
                try {
                    Salvare();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                JFrame frameLogare = new PaginaLogare();
                frameLogare.setVisible(true);
                frameLogare.setSize(800, 600);
                PaginaInregistrare.this.dispose();//inchide fereastra PaginaInregistrare
            }
        });

        butonIntoarcere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fereastraMeniu = new PaginaLogare();
                fereastraMeniu.setSize(800,600);
                fereastraMeniu.setVisible(true);
                PaginaInregistrare.this.dispose();
            }
        });
    }

    public void Salvare() throws IOException {
        String str = this.nume + ", " + this.prenume + ", " + this.userName + ", " + this.parola + ", "
                + this.varsta + ", " + this.greutate + ", " + this.inaltime + ", " + this.sex;

        BufferedWriter scrie = new BufferedWriter(new FileWriter("Utilizator.txt", true));
        scrie.append("\n");
        scrie.append(str);
        scrie.close();
    }

//    public static void main(String[] args){
//        PaginaInregistrare window = new PaginaInregistrare();
//    }
}
