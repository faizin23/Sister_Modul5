/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas03;

import java.io.Serializable;

/**
 *
 * @author LAB_TI
 */
public class Participant implements Serializable {

    private final String nama;
    private final String asal;
    private final String kelas;
    private String nim;

    public Participant(String nim, String nama, String asal, String kelas) {
        this.nama = nama;
        this.asal = asal;
        this.nim = nim;
        this.kelas = kelas;
    }

    public String getNama(){
        return nama;
    }

    public String getAsal(){
        return asal;
    }
    
    public String getKelas(){
        return kelas;
    }

    public String getNim(){
        return nim;
    }

    public void setNim(String nim){
        this.nim=nim;
    }

    @Override
    public String toString(){
        return "("+nim+") " + nama+" "+asal+" "+kelas+"";
    }
}
