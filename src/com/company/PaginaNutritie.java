package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaginaNutritie extends JFrame {
    private JLabel labelBackground, labelAlimente, labelCalorii, labelProteine, labelCarbohidrati, labelGrasimi;
    private JTextField textCalorii, textProteine,textCarbohidrati, textGrasimi;
    private JButton butonSuma, butonIntoarcere, butonAdauga;
    private JCheckBox[] listaCheckBox;
    private List<Aliment> listaAlimente = new ArrayList<Aliment>();
    private String aux;

    public PaginaNutritie() throws FileNotFoundException {

        setTitle("Nutritie");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font fontLabel = new Font("Comic Sans", Font.BOLD, 20);
        Font fontTextField = new Font("Comic Sans", Font.BOLD, 14);

        Scanner s = null;
        s = new Scanner(new BufferedReader(new FileReader("Alimente.txt")));
        while(s.hasNextLine()){//populez lista de alimente cu valorile din Alimente.txt
            String[] data = s.nextLine().split(", ");
            Aliment aliment = new Aliment(data[0], Short.parseShort(data[1]), Short.parseShort(data[2]),
                    Short.parseShort(data[3]), Short.parseShort(data[4]), Short.parseShort(data[5]));
            listaAlimente.add(aliment);
        }

        labelBackground = new JLabel(new ImageIcon("poza14.png"));
        labelAlimente = new JLabel("Selectati alimentele");
        labelCalorii = new JLabel("Calorii");
        labelProteine = new JLabel("Proteine");
        labelCarbohidrati = new JLabel("Carbohidrati");
        labelGrasimi = new JLabel("Grasimi");
        listaCheckBox = new JCheckBox[listaAlimente.size()];

        butonIntoarcere = new JButton("Inapoi");
        butonSuma = new JButton("Calculeaza!");
        butonAdauga = new JButton("Adauga aliment");

        labelBackground.setBounds(1,1,800,600);
        labelAlimente.setBounds(50, 70, 200, 40);
        labelAlimente.setFont(fontLabel);
        labelAlimente.setForeground(Color.BLACK);

        labelCalorii.setBounds(300, 70, 150,40);
        labelCalorii.setFont(fontLabel);
        labelCalorii.setForeground(Color.BLACK);

        labelProteine.setBounds(300, 135, 150,40);
        labelProteine.setFont(fontLabel);
        labelProteine.setForeground(Color.BLACK);

        labelCarbohidrati.setBounds(300, 205, 150,40);
        labelCarbohidrati.setFont(fontLabel);
        labelCarbohidrati.setForeground(Color.BLACK);

        labelGrasimi.setBounds(300, 275, 150,40);
        labelGrasimi.setFont(fontLabel);
        labelGrasimi.setForeground(Color.BLACK);

        textCalorii = new JTextField();
        textProteine = new JTextField();
        textCarbohidrati = new JTextField();
        textGrasimi = new JTextField();

        textCalorii.setBounds(300, 110, 150, 30);
        textProteine.setBounds(300, 175, 150, 30);
        textCarbohidrati.setBounds(300, 245, 150, 30);
        textGrasimi.setBounds(300, 315, 150, 30);

        textCalorii.setFont(fontTextField);
        textProteine.setFont(fontTextField);
        textCarbohidrati.setFont(fontTextField);
        textGrasimi.setFont(fontTextField);

        textCalorii.setForeground(Color.BLACK);
        textProteine.setForeground(Color.BLACK);
        textCarbohidrati.setForeground(Color.BLACK);
        textGrasimi.setForeground(Color.BLACK);



        butonSuma.setBounds(300, 360, 150, 30);
        butonIntoarcere.setBounds(50, 30, 100, 30 );
        butonAdauga.setBounds(300, 401, 150, 30);

        butonSuma.setForeground(Color.BLACK);
        butonSuma.setBackground(Color.WHITE);
        butonIntoarcere.setBackground(Color.WHITE);
        butonIntoarcere.setForeground(Color.BLACK);
        butonAdauga.setBackground(Color.WHITE);
        butonAdauga.setForeground(Color.BLACK);
        butonAdauga.setFont(fontTextField);
        butonSuma.setFont(fontTextField);
        butonIntoarcere.setFont(fontTextField);

        int i = 0;
        for(Aliment al : listaAlimente){
            aux = al.numeAliment + " (" + al.gramaj + "g)";
            listaCheckBox[i] = new JCheckBox(aux);
            listaCheckBox[i].setBounds(50, 110 + i * 20, 200, 20);
            listaCheckBox[i].setFont(fontTextField);
            listaCheckBox[i].setForeground(Color.BLACK);
            listaCheckBox[i].setBackground(Color.WHITE);
            labelBackground.add(listaCheckBox[i]);
            i++;
            aux = null;
        }

//        for(i = 0; i < listaAlimente.size(); i++){
//            add(listaCheckBox[i]);
//        }

        labelBackground.add(labelAlimente);
        labelBackground.add(labelCalorii);
        labelBackground.add(labelProteine);
        labelBackground.add(labelCarbohidrati);
        labelBackground.add(labelGrasimi);

        labelBackground.add(textCalorii);
        labelBackground.add(textProteine);
        labelBackground.add(textCarbohidrati);
        labelBackground.add(textGrasimi);

        labelBackground.add(butonSuma);
        labelBackground.add(butonIntoarcere);
        labelBackground.add(butonAdauga);
        add(labelBackground);

        butonSuma.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int sumaCalorii = 0, sumaProteine = 0, sumaCarbohidrati = 0, sumaGrasimi = 0;
                String alerta = new String("Recomandam ca numarul total de calorii sa fie sub 2500 de kcal!");
                for(int i = 0; i < listaAlimente.size(); i++){
                    if(listaCheckBox[i].isSelected()){
                        sumaCalorii+=listaAlimente.get(i).valoareNutritiva;
                        sumaProteine+=listaAlimente.get(i).proteine;
                        sumaCarbohidrati+=listaAlimente.get(i).carbohidrati;
                        sumaGrasimi+=listaAlimente.get(i).grasimi;
                    }
                }

                textCalorii.setText(String.valueOf(sumaCalorii));
                textProteine.setText(String.valueOf(sumaProteine));
                textCarbohidrati.setText(String.valueOf(sumaCarbohidrati));
                textGrasimi.setText(String.valueOf(sumaGrasimi));
            }
        });

        butonAdauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameAdauga = new PaginaAdaugaAliment();
                frameAdauga.setSize(800, 600);
                frameAdauga.setVisible(true);
                PaginaNutritie.this.dispose();
            }
        });

        butonIntoarcere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fereastraMeniu = new Meniu();
                fereastraMeniu.setSize(800,600);
                fereastraMeniu.setVisible(true);
                PaginaNutritie.this.dispose();
            }
        });

        setVisible(true);
    }

//    public static void main(String[] args) throws FileNotFoundException {
//        PaginaNutritie fereastra = new PaginaNutritie();
//    }
}
