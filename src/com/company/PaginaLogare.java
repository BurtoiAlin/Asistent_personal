package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;//"D:\\Facultate\\Info_2\\Programare_Orientata_Obiect\\Poze\\poza8.png"

public class PaginaLogare extends JFrame {

    public JLabel labelNume, labelParola, labelBackground;
    public JButton butonLogare, butonInregistrare;
    public JTextField textNume;
    public JPasswordField textParola;
    public String nume;
    public String parola;

    public PaginaLogare(){

        setTitle("Pagina logare");

        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font fontLabel = new Font("Comic Sans", Font.BOLD, 20);
        Font fontTextField = new Font("Comic Sans", Font.PLAIN, 18);

        labelBackground = new JLabel(new ImageIcon("poza8.png"));

        labelNume = new JLabel("Nume de utilizator");
        labelNume.setFont(fontLabel);
        labelParola = new JLabel("Parola");
        labelParola.setFont(fontLabel);

        textNume = new JTextField();
        textParola = new JPasswordField();

        butonLogare = new JButton("Logare");
        butonLogare.setForeground(Color.BLACK);
        butonLogare.setBackground(Color.white);

        butonInregistrare = new JButton("Nu ai inca cont?");
        butonInregistrare.setForeground(Color.BLACK);
        butonInregistrare.setBackground(Color.WHITE);

        labelBackground.setBounds(1,1,800,600);
        labelNume.setBounds(115, 100, 200, 40);
        textNume.setBounds(100, 140, 200, 35); //100 + 40 de la labelNume
        textNume.setFont(fontTextField);
        labelParola.setBounds(170, 200, 200, 40);
        textParola.setBounds(100, 240, 200, 35);
        textParola.setFont(fontTextField);
        butonLogare.setBounds(110,350,180, 40);
        butonInregistrare.setBounds(110, 400, 180, 40);

        labelBackground.add(labelNume);
        labelBackground.add(butonLogare);
        labelBackground.add(butonInregistrare);
        labelBackground.add(textNume);
        labelBackground.add(labelParola);
        labelBackground.add(textParola);

        add(labelBackground);


        setVisible(true);

        butonLogare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nume = textNume.getText();
                parola = new String(textParola.getPassword());
                boolean semafor = false;
                Scanner s = null;
                try{
                    final String numeCautat = nume;

                    semafor = false;
                    try {
                        s = new Scanner(new BufferedReader(new FileReader("Utilizator.txt")));
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }

                    while(s.hasNextLine() && semafor != true){
                        String[] data = s.nextLine().split(", ");
                        if(data[2].equals(numeCautat) && data[3].equals(parola)){
                            semafor = true;
                        }
                    }
                }finally {
                    s.close();
                }if(semafor == true){//daca gaseste datele corecte merge la fereastra maine
                    JFrame frameMeniu = new Meniu();
                    frameMeniu.setVisible(true);
                    frameMeniu.setSize(800, 600);
                    PaginaLogare.this.dispose();
                }
                else{
                    JFrame frameLogare = new PaginaLogare();
                    frameLogare.setVisible(true);
                    frameLogare.setSize(800, 600);
                    PaginaLogare.this.dispose();
                }
            }
        });
        butonInregistrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameInregistrare = new PaginaInregistrare();
                frameInregistrare.setVisible(true);
                frameInregistrare.setSize(800, 600);
                PaginaLogare.this.dispose();
            }
        });


    }

    public static void main(String[] args){
        PaginaLogare fereastra = new PaginaLogare();
    }
}

