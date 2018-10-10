/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas03;

import tugas03.Participant;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class tugas3_Server {

    public final static int service = 13;

    public static void main(String[] args) {
        try {
            String pesan;
            ServerSocket server = new ServerSocket(service);
            for (;;) {
                Socket nextClient = server.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
//                BufferedReader in1 = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
//                BufferedReader in2 = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));
//                BufferedReader in3 = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));

                pesan = in.readLine();
                

                SerializationDemo demo = new SerializationDemo();
                List<Participant> participants = new ArrayList<Participant>();
                participants.add(new Participant(pesan, null, null, null));
                demo.serialize(participants, "d:/participantData.ser");

                System.out.println("pesan dari \t :" + nextClient.getInetAddress() + " " + nextClient.getPort());
                System.out.println("Nim\t : " + pesan);
//                System.out.println("Nama\t : " + in1.readLine());
//                System.out.println("Asal\t : " + in2.readLine());
//                System.out.println("Kelas\t : " + in3.readLine());

                System.out.println("serialization is done");

                nextClient.close();

            }
        } catch (BindException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
    }
}
