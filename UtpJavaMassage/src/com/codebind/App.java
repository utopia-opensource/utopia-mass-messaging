package com.codebind;

import com.company.libUtp;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private JTextField tokenField;
    private JTextField portField;
    private JLabel amountLabel;
    private JLabel balanceLabel;
    private JButton updateButton;
    private JPanel panelMain;
    private JLabel pkLabel;
    private JTextField pkField;
    private JTextField muchField;
    private JButton sendButton;


    public App() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                libUtp kek = new libUtp();

                String PORTIO = portField.getText();
                String TOKENIO = tokenField.getText();

               // kek.port = "20000";
               // kek.token = "2928E4C1435847EAC35E186D640A04A4";

                 kek.port = PORTIO;
                 kek.token = TOKENIO;

                String RESOLT = null;

                //last contact PK
                JSONObject PKeyJO = null; //full json string
                try {
                    PKeyJO = new JSONObject(kek.getOwnContact());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }


                System.out.println(PKeyJO); //CHECK FULL

                JSONObject PKeyOut; // result string

                PKeyOut = PKeyJO.getJSONObject("result");

                System.out.println(PKeyOut); // chek result

                // :)))

                //SONObject PKFinal = new JSONObject(PKeyOut);

                String PKey = PKeyOut.getString("pk");

                System.out.println(PKey);

                pkLabel.setText(PKey);

                //balance







            }
        });


        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                libUtp kek = new libUtp();



                String PORTIO = portField.getText();
                String TOKENIO = tokenField.getText();






             //   kek.port = "20000";
             //    kek.token = "2928E4C1435847EAC35E186D640A04A4";

              kek.port = PORTIO;
                kek.token = TOKENIO;

                String RESOLT = null;





                try {
                    getPKArray();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }




            }
        });
    }

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();


        frame.setSize(1080,170);
        frame.setVisible(true);




    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


    public void getPKArray() throws IOException {

        String balancio ="finished";

        System.out.println(balancio);

        amountLabel.setText(balancio);


        System.out.println("puk" );
        String outJs = null;

        libUtp kek = new libUtp();
       String PORTIO = portField.getText();
       String TOKENIO = tokenField.getText();

        String toMass = pkField.getText();

        kek.port = PORTIO;
        kek.token = TOKENIO;

        //kek.port = "20000";
        // kek.token = "2928E4C1435847EAC35E186D640A04A4";

        JSONObject pkArr = null;

        JSONArray pkArrO = new JSONArray();
        try {
            pkArr = new JSONObject(kek.getContacts(null));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        System.out.println("THIS IS SPARTA");
        System.out.println(pkArr);

        outJs = pkArr.get("result").toString();
        System.out.println( outJs );

       // pkArrO.put(pkArr.getJSONArray("result"));


        System.out.println( pkArr.getJSONArray("result").get(1));

        //System.out.println( pkArrO.get(0));

        Boolean XX = true;

        int n = 1;

        while (XX) {


            System.out.println( n);

            JSONObject TWP = new JSONObject(pkArr.getJSONArray("result").get(n).toString());

            System.out.println("good");
            System.out.println(TWP);

            String lPK = TWP.getString("pk");
            kek.sendInstantMessage(lPK, toMass);

            n++;
            System.out.println( n);


        }



    }




}
