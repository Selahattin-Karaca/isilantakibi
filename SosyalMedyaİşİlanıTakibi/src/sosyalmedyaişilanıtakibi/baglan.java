/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosyalmedyaişilanıtakibi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class baglan implements IDaatabase {
    private Connection conn;
    Scanner giris=new Scanner(System.in);
    String user="selo";
    String url="jdbc:derby://localhost:1527/ilandata";
    String password="6736";
    String kullanıcıadi;
    int sifre;
    boolean varmi=false;
    String yenisifre; 
    public Connection databaglan()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            System.out.println("baglanti basarılı");
            conn=DriverManager.getConnection(url,user,password);
        }
        catch(Exception e)
        {
            System.out.println("baglantıda sorun var");
        }
        return conn;
    }
    public boolean kullanicilistesi() throws SQLException
    {
        if(conn==null )
        {
            System.out.println("veritabanı bağlı değil ,bağlanıyorum...");
            databaglan();
        }
        try
        {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select kullanıcıadı from kullanici where kullanıcıadı='"+kullanıcıadi+"'");
            System.out.println("Kullanıcı adınızı giriniz.");
            kullanıcıadi=giris.nextLine();
            while(rs.next())
            {
                 varmi=rs.getString("kullanıcıadı").equals(kullanıcıadi);
            }
            
            if(varmi==false)
            {
                System.out.println("Kullanici adi bulunamadi");
                return false;
            }
            
            System.out.println("sifre  giriniz.");
            sifre=giris.nextInt();
           
            rs=stmt.executeQuery("select kullanıcısıfre from kullanici where kullanıcıadı='"+kullanıcıadi+"'");
            yenisifre=String.valueOf(sifre);
            while(rs.next())
            {
               varmi= rs.getString(1).equals(yenisifre);
            }
               
        }
        catch(Exception e)
        {
            System.out.println("Bir sorun yaşadık");
            return false;
        }
        if(varmi==false)
        {
            System.out.println("Kullanici adi bulunamadi");
            return false;
        }
        else
            return true;
    }

    
   

    
    
}
