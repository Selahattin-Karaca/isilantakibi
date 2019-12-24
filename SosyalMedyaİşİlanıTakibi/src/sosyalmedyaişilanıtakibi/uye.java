/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosyalmedyaişilanıtakibi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class uye extends baglan{
    Connection con;
    public boolean oturumkontrol;   
    Scanner giris=new Scanner(System.in);
    //private ArrayList<String> üye=new ArrayList();
   // private  ArrayList sifre=new ArrayList();
    
    String kullanıcıadi;
    int kullanicisifre;
    boolean varmi=false;
    String yenisifre; 
    
     uye()
    {
       
        
        this.oturumkontrol=false;
    }
    
   
    public int kacbasamakli(int sayi)
    {
         int adet = 0;
 
        while(sayi != 0)
        {
            
            sayi /= 10;
            ++adet;
        }
        return adet;
    }
    int i=0;
    public boolean kullanicilistesi(String kullanıcıadi,int kullanicisifre) 
    {
         varmi=false;
         con=databaglan();
         System.out.print(i);
        try
        {
             if(con==null )
            {
                System.out.println("veritabanı bağlı değil ,bağlanıyorum...");
                databaglan();
            }
             
            Statement stmt=con.createStatement();
           
            //System.out.println("Kullanıcı adınızı giriniz.");
            //kullanıcıadi=giris.nextLine();
            i++;
            ResultSet rs=stmt.executeQuery("select kullanıcıadı from kullanici where kullanıcıadı='"+kullanıcıadi+"'");
            while(rs.next())
            {
                 varmi=rs.getString("kullanıcıadı").equals(kullanıcıadi);
                
            }
            System.out.print("varmi kontrol");
            System.out.println(varmi);
            if(varmi==false)
            {
                System.out.println("Kullanici adi bulunamadi");
                return oturumkontrol=varmi;
            }
            
            //System.out.println("sifre  giriniz.");
            //kullanicisifre=giris.nextInt();
           
            rs=stmt.executeQuery("select kullanıcısıfre from kullanici where kullanıcıadı='"+kullanıcıadi+"'");
            yenisifre=String.valueOf(kullanicisifre);
            while(rs.next())
            {
               System.out.print(varmi);
               varmi= rs.getString("kullanıcısıfre").equals(yenisifre);
            }
            System.out.print("varmi kontrol");
            System.out.println(varmi);
            if(varmi==false)
            {
            System.out.println("Kullanici sifre bulunamadi");
            return oturumkontrol=varmi;
            }
            else
                return oturumkontrol=varmi;
           
       
        }
        catch(Exception e)
        {
            System.out.println("Bir sorun yaşadık");
            return oturumkontrol=varmi;
        }
        
    }    
    
    
     public boolean kullanıcıkayıt(String kullanıcıadi,int kullanicisifre,int kullanicisifretekrar,kayitPencere k1) 
    {
         con=databaglan();
          varmi=false;
        try
        {
             if(con==null )
            {
                System.out.println("veritabanı bağlı değil ,bağlanıyorum...");
                databaglan();
            }
             
            Statement stmt=con.createStatement();
           
           
            
            ResultSet rs=stmt.executeQuery("select kullanıcıadı from kullanici where kullanıcıadı='"+kullanıcıadi+"'");
            while(rs.next())
            {
                 varmi=rs.getString("kullanıcıadı").equals(kullanıcıadi);
                 
            }
            
            if(varmi==false)
            {
                String sorgu="insert into kullanıcı(kullanıcıadı,kullanıcısıfre) values(?,?)";
               
                if(kullanicisifre==kullanicisifretekrar)
                {
                    yenisifre=String.valueOf(kullanicisifre);
                    
                    PreparedStatement ps=con.prepareStatement(sorgu);           
                    ps.setString(1, kullanıcıadi);
                    ps.setString(2, yenisifre);
                  
                    // 4 tane ? ile gösterilen parametreye değerlerini aktarıyoruz.
                    //Değerleri ogrenciKaydet metodumuza gönderilen ogrenci nesnesinden alıyoruz.
                    ps.executeUpdate();
                    return oturumkontrol=true;
                }
             /*   else
                {
                    String mesaj="Girilen iki sifre birbirinden farklı yeniden gir";
                    k1.hatamesaj(mesaj);
                }*/
            }
            else
                System.out.println("Girdiğiniz kullanıcı ");
           
       
        }
        catch(Exception e)
        {
            System.out.println("Bir sorun yaşadık");
            System.out.println(e);
            return oturumkontrol=false;
        }
        return oturumkontrol=false;
    }  
   
  
    //oşuşturulan kullanıcı şifresini onaylatıyoruz
     public boolean sifreonay(int sifre,int sifretekrar)
     {
         boolean sayac=false;
        
            
             if(sifre==sifretekrar)
             {
                 sayac=true;
                 
             }     
         return sayac;
     }
}
