/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz52021001;
import java.io.*;
/**
 *
 * @author HP VICTUS
 */
public class process {
    private int stambuk, count1, count2, count3;
    private String nama,nhuruf;
    private double tugas,quiz, uts, uas, nangka;
    
    public process(){
        stambuk=12345678;
        nama="NAMA";
        tugas=0.0;
        quiz=0.0;
        uts=0.0;
        uas=0.0;
        nangka=((0.2*tugas)+(0.2*quiz)+(0.3*uts)+(0.3*uas));
        nhuruf="E";
        count1=0;
        count2=0;
        count3=0;
    }
    
    public void SimpanData(String stambuk,String nama, String tugas, String quiz, String uts, String uas, String nangka, String nhuruf){
        try{
            File fout=new File("Quiz52021001.dat");
            BufferedWriter out=new BufferedWriter(new FileWriter(fout,true));
            out.write(stambuk+";");
            out.write(nama+";");
            out.write(tugas+";");
            out.write(quiz+";");
            out.write(uts+";");
            out.write(uas+";");
            out.write(nangka+";");
            out.write(nhuruf+";");
            out.write(";");
            out.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }
    public String ReadShow(){
        String line;
        String temp="";
        String[] aray={"NIM = ","Nama = ","Nilai Tugas = ","Nilai Quiz = ","Nilai UTS = ","Nilai UAS = ","Nilai Angka = ","Nilai Huruf= "};
        try{
            File file=new File("Quiz52021001.dat");
            BufferedReader input=new BufferedReader(new FileReader(file));
            while((line=input.readLine())!=null){
                String[] str = line.split(";", 9);
                for (int i = 0; i < aray.length; i++)
                    temp+=aray[i]+str[i]+"\n";
                temp=temp+"\n";
                if(!temp.isEmpty()) {
                    count1++;
                }if(str[7].equals("E")){
                    count3++;
                }if(!str[7].equals("E")){
                    count2++;
                }
            }   
            input.close();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        return(temp+"\n");
    }
    
    public void setNangka(double a, double b, double c, double d){
        nangka=(0.2*a)+(0.2*b)+(0.3*c)+(0.3*d);
    }
    public void setNhuruf(double x){
        if(x>=80){
            nhuruf="A";
        }else if(x>=70&&x<80){
            nhuruf="B";
        }else if(x>=60&&x<70){
            nhuruf="C";
        }else if(x>=50&&x<60){
            nhuruf="D";
        }else{
            nhuruf="E";
        }
    }
    
    public double getNangka(){
        return nangka;
    }
    public String getNhuruf(){
        return nhuruf;
    }
    public int getCount() {
        return count1;
    }
    public int getCount2() {
        return count2;
    }
    public int getCount3() {
        return count3;
    }
} 