/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas03;

import java.io.BufferedReader;
import tugas03.Participant;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class tugas3_Client {

    public static final int service = 13;

    public static void main(String[] args) {

        try {
            for (;;) {
                String hostname = "localhost";//server
                Socket client = new Socket(hostname, service);
                System.out.println("Connection established");
                client.setSoTimeout(3000);
                String pesan;
                String pesan1;
                String pesan2;
                String pesan3;

                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in3 = new BufferedReader(new InputStreamReader(System.in));

                OutputStream out = client.getOutputStream();
                PrintStream pout = new PrintStream(out);

                System.out.print("Masukkan nim ");
                pesan = in.readLine();
                System.out.print("Masukkan nama ");
                pesan1 = in1.readLine();
                System.out.print("Masukkan asal ");
                pesan2 = in2.readLine();
                System.out.print("Masukkan kelas ");
                pesan3 = in3.readLine();

                int data = Integer.parseInt(pesan);

//                pout.println(pesan + "\nOn\t:" + new java.util.Date());
//                pout.println(pesan1 + "\nOn\t:" + new java.util.Date());
//                pout.println(pesan2 + "\nOn\t:" + new java.util.Date());
//                pout.println(pesan3 + "\nOn\t:" + new java.util.Date());

                List<Participant> participants = new ArrayList<Participant>();
                participants.add(new Participant(pesan, pesan1, pesan2, pesan3));
                parti pr = new parti();
                pr.setParti(participants);
                
                pout.println(participants);

                out.flush();
                out.close();
                client.close();
            }
        } catch (Exception e) {
            System.out.println("error pada " + e.getMessage());
        }
    }

}
