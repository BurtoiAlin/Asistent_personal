package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PaginaAntrenamente extends JFrame {
    private JScrollPane text;
    private JLabel labelIntensitate, labelAntrenament, labelBackground;
    private JButton butonIntoarcere;
    private JComboBox cbIntensitate;
    private String[] antrenamentUsor, antrenamentModerat, antrenamentGreu;

    public PaginaAntrenamente() throws IOException {
        setTitle("Antrenamente");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);
        Font fontTitlu = new Font("Old London", Font.BOLD, 28);
        Font fontLabel = new Font("Comic Sans", Font.BOLD, 22);
        Font fontTextField = new Font("Comic Sans", Font.BOLD, 18);
        Font fontButon = new Font("Comic Sans", Font.BOLD, 16);

        antrenamentUsor = readLines("AntrenamenteUsoare.txt");
        antrenamentModerat = readLines("AntrenamenteModerate.txt");
        antrenamentGreu = readLines("AntrenamenteIntense.txt");

        //Afisare initiala ca JScrollPane-ul sa nu fie gol inainte de alegerea utilizatorului
        DefaultListModel dlm = new DefaultListModel();
        JList list = new JList(dlm);
        text = new JScrollPane(list);
        for (String cuvant : antrenamentUsor) {
            dlm.addElement(cuvant);
        }

        String[] intensitate = {"Usor", "Intermediar", "Avansat"};
        cbIntensitate = new JComboBox(intensitate);

        ItemListener listen = new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getSource()==cbIntensitate) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {

                        if (cbIntensitate.getSelectedItem().equals("Usor")) {
                            dlm.removeAllElements();
                            for (String cuvant : antrenamentUsor) {
                                dlm.addElement(cuvant);
                            }
                            text.revalidate();
                            text.repaint();
                        } else if (cbIntensitate.getSelectedItem().equals("Intermediar")) {
                            dlm.removeAllElements();
                            for (String cuvant : antrenamentModerat) {
                                dlm.addElement(cuvant);
                            }
                            text.revalidate();
                            text.repaint();
                            labelBackground.repaint();
                        } else {
                            dlm.removeAllElements();
                            for (String cuvant : antrenamentGreu) {
                                dlm.addElement(cuvant);
                            }
                            text.revalidate();
                            text.repaint();
                        }
                    }
                }
            }
        };

        cbIntensitate.addItemListener(listen);

        labelBackground = new JLabel(new ImageIcon("poza12.png"));
        labelAntrenament = new JLabel("Antrenamente");
        labelIntensitate = new JLabel("Intensitate antrenament:");
        butonIntoarcere = new JButton("Inapoi");


        labelBackground.setBounds(1, 1, 800, 600);
        labelAntrenament.setBounds(50, 160, 300, 40);
        labelIntensitate.setBounds(50, 220, 350, 40);
        cbIntensitate.setBounds(330, 230, 130, 30);
        text.setBounds(50, 270, 600, 250);
        butonIntoarcere.setBounds(50, 30, 100, 30 );

        labelAntrenament.setFont(fontTitlu);
        labelIntensitate.setFont(fontLabel);
        text.getViewport().getView().setFont(fontTextField); //varianta corecta, nu functioneaza pe text.setFont()
        text.getViewport().getView().setBackground(Color.lightGray);
        text.getViewport().getView().setForeground(Color.BLACK);
        labelAntrenament.setForeground(Color.BLACK);
        labelIntensitate.setForeground(Color.BLACK);
        cbIntensitate.setBackground(Color.lightGray);
        cbIntensitate.setForeground(Color.BLACK);
        butonIntoarcere.setBackground(Color.lightGray);
        butonIntoarcere.setForeground(Color.BLACK);
        butonIntoarcere.setFont(fontButon);

        butonIntoarcere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fereastraMeniu = new Meniu();
                fereastraMeniu.setSize(800,600);
                fereastraMeniu.setVisible(true);
                PaginaAntrenamente.this.dispose();
            }
        });

        labelBackground.add(butonIntoarcere);
        labelBackground.add(cbIntensitate);
        labelBackground.add(labelAntrenament);
        labelBackground.add(labelIntensitate);
        cbIntensitate.setFont(fontLabel);
        labelBackground.add(text);

        add(labelBackground);

        setVisible(true);
    }

    public String[] readLines(String filename) throws IOException
    {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;

        while ((line = bufferedReader.readLine()) != null)
        {
            lines.add(line);
        }
        bufferedReader.close();

        return lines.toArray(new String[lines.size()]);
    }

//    public static void main(String[] args) throws IOException {
//        PaginaAntrenamente window = new PaginaAntrenamente();
//    }
}