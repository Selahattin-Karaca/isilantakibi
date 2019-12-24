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
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import static sosyalmedyaişilanıtakibi.isilanPencere.kategoriliste;
import static sosyalmedyaişilanıtakibi.İsİlani.basvurudurum;

/**
 *
 * @author dell
 */
public class İsİlani {
     baglan bgl=new baglan();
    Random rand = new Random(); 
    Scanner giris=new Scanner(System.in);
    Connection c1;
    private String user="";
    
    static ArrayList<String> baslık=new ArrayList();
    static ArrayList<String> basvurudurum=new ArrayList();
    static ArrayList<String> isil=new ArrayList();
   
    public void setUser(String ad)
    {
        user=ad;
    }
   
    public void isekle(String [] parcala) throws SQLException
    {
        
       System.out.print("isekledeyiz\n");
       int i=0;
       String il;
        //String parcala[]=new String[7];
       // parcala=dizi.split("-");
        c1=bgl.databaglan();
         try
        {
        Statement stmt=c1.createStatement();
        //ResultSet rs=stmt.executeQuery("select * from ISILANLARI");
        String sorgu="insert into isilanlari(ilanveren,kategori,ilanbasligi,il,maas,telefon,istenilenler) values(?,?,?,?,?,?,?)";
         
        PreparedStatement ps;  
         ps = c1.prepareStatement(sorgu);
             
             System.out.print(Arrays.toString(parcala));
             ps.setString(1, user);         
             ps.setString(2, parcala[0]);
             ps.setString(3, parcala[1]);
            ps.setString(4, parcala[2]);
             ps.setString(5, parcala[3]);
             ps.setString(6, parcala[4]);
             ps.setString(7, parcala[5]);
            
           for(i=0;i<parcala.length;i++)
               System.out.println(parcala[i]);
        ps.executeUpdate();
           
        }
         catch(Exception e)
        {
            System.out.println("Bir sorun yaşadık");
            System.out.println(e);
            
        }
    }
    public void kategoriListesi()
    {
        String tutucu;
        c1=bgl.databaglan();
         try
        {
        Statement stmt=c1.createStatement();
        //ResultSet rs=stmt.executeQuery("select * from ISILANLARI");
       
         ResultSet rs=stmt.executeQuery("select kategori from isilanlari ");
           
          while(rs.next())
            {
                 tutucu=rs.getString("kategori");
                 if(kategoriliste.indexOf(tutucu)==-1)
                     kategoriliste.add(tutucu);
                
            }
            
           
           
        }
         catch(Exception e)
        {
            System.out.println("Bir sorun yaşadık");
            System.out.println(e);
            
        }
    }
     public void issil(String silinecekis,Kategoriler k1)
    {
        int i;
        for(i=0;i<k1.bilisim.size();i++)
        {
            if(silinecekis==k1.bilisim.get(i))
            {
                k1.bilisim.remove(i);
                break;
            }
        }
        for(i=0;i<k1.satis.size();i++)
        {
            if(silinecekis==k1.bilisim.get(i))
            {
                k1.bilisim.remove(i);
                break;
            }
        }
        for(i=0;i<k1.sağlik.size();i++)
        {
            if(silinecekis==k1.sağlik.get(i))
            {
                k1.sağlik.remove(i);
                break;
            }
        }
    }
   
     public  void ilangöster(String dizi) throws SQLException
    {
         int sayi=0,i=0;
        for(i=0;i<baslık.size();i++)
            {
                 baslık.remove(i);
                 isil.remove(i);
            }
       
        Connection c2=bgl.databaglan();
        Statement stmt=c2.createStatement();
         ResultSet rs=stmt.executeQuery("select ilanbaslıgı,ıl from isilanlari where kategori='"+dizi+"'");
            while(rs.next())
            {
                 baslık.add(rs.getString("ilanbaslıgı"));
                 isil.add(rs.getString("ıl"));
            }
           //System.out.println(baslık);
          // System.out.println(isil);
        
    }
     
     public  void ilangöster() throws SQLException
    {
         int sayi=0,i=0;
        for(i=0;i<baslık.size();i++)
            {
                 baslık.remove(i);
                
            }
       
        Connection c2=bgl.databaglan();
        Statement stmt=c2.createStatement();
        System.out.print(user);
         ResultSet rs=stmt.executeQuery("select ilanbasligi from isilanlari where ilanveren='"+user+"'");
            while(rs.next())
            {
                 baslık.add(rs.getString("ilanbasligi"));
                 
            }
           //System.out.println(baslık);
          // System.out.println(isil);
        
    }
      
     public  void basvurugöster() throws SQLException
    {
         int sayi=0,i=0;
       //  basvurudurum.add("0");
        for(i=0;i<baslık.size();i++)
            {
                 baslık.remove(i);
                 basvurudurum.remove(i);
                
            }
       
        Connection c2=bgl.databaglan();
        Statement stmt=c2.createStatement();
        System.out.print(user);
         ResultSet rs=stmt.executeQuery("select * from basvurular where basvuran='"+user+"'");
            while(rs.next())
            {
                 baslık.add(rs.getString("isbasligi"));
                 basvurudurum.add(rs.getString("basvurudurumu"));
                 
            }
        System.out.println(baslık.get(0));
        System.out.println(basvurudurum.get(0));
        
    }
     @SuppressWarnings("empty-statement")
     public String basvuranlar(String bslk) throws SQLException
     {
         String basvruankullanıcılar="";
          int i=0;
      
       
       
        Connection c2=bgl.databaglan();
        Statement stmt=c2.createStatement();
        System.out.print(user);
         ResultSet rs=stmt.executeQuery("select * from basvurular where isbasligi='"+bslk+"'");
            while(rs.next())
            {
                basvruankullanıcılar+=rs.getString("basvuran")+"-";
                
                 
            }
         return basvruankullanıcılar;
     }
     @SuppressWarnings("empty-statement")
     public String ise_al(String bslk,String kisi) throws SQLException
     {
          int i=0;
          String sayi="1";
          boolean varmi=false;
        Connection c2=bgl.databaglan();
        Statement stmt=c2.createStatement();
        
        String sil="delete from isilanlari where isbasligi='"+bslk+"'";
        String sorgu="update basvurular set basvurudurumu='"+sayi+"' where basvuran='"+kisi+"'";
         ResultSet rs=stmt.executeQuery("select * from basvurular where basvuran='"+user+"'");
           while(rs.next())
            {
                 varmi=rs.getString("basvurudurumu").equals("1");
                 
            }
           if(varmi==false)
           {
               stmt.executeUpdate(sorgu);
              
              int executeUpdate = stmt.executeUpdate("Delete FROM  isilanlari where ilanbasligi='" + bslk+"'");

                return "Eleman işe alındı";
           }
           
           else
               return "Hata eleman yok yada işe zaten alınmış";
         
          
     }
     public String basvuruekle(int basvuruindis)
     {
         
         String ara,kullanıcı="";
          c1=bgl.databaglan();
          kullanıcı=user;
          boolean varmi=false;
         try
        {
            
            if(c1==null )
            {
                System.out.println("veritabanı bağlı değil ,bağlanıyorum...");
                c1=bgl.databaglan();
            }
             
            ara=(baslık.get(basvuruindis));
            System.out.print("basvuru ekledeyiz sonraki ara\n");
            System.out.print(ara);
            Statement stmt=c1.createStatement();
            System.out.print("stmt sonrası\n");
            ResultSet rs;
             rs = stmt.executeQuery("select basvuran from basvurular where isbasligi='"+ara+"'");
            while(rs.next())
            {
                 varmi=rs.getString("basvuran").equals(kullanıcı);
                 
            }
            //varmi=rs.getString("isbasligi").equals(baslık.get(basvuruindis));
           // System.out.print(rs.getString("isbasligi"));
            if(varmi==false)
            {
                String sorgu="insert into basvurular(basvuran,isbasligi,basvurudurumu) values('"+kullanıcı+"','"+ara+"','0')";
                stmt.executeUpdate(sorgu);
               
                return "Basvurunuz başarıyla gerçeklenmiştir";
            }
            else
                return "Zaten bu ilana başvuru yaptınız";
        }
 
         catch(Exception e)
        {
            System.out.println("Bir sorun yaşadık");
            System.out.println(e);
            return "Bir sorun yaşadık";
        }
     }
    
     /*void ilangöster()
     {
         System.out.print("\nİŞ BAŞLIĞI   \t\t\t\tİL\tMAAŞ\tİLETİŞİM\n");
     }*/
       public void yakala()
     {
         System.out.print("isilani yakalandı");
     }

    void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
     
}
