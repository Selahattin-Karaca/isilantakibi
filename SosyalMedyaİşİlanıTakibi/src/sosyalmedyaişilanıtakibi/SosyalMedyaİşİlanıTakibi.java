/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosyalmedyaişilanıtakibi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import static sosyalmedyaişilanıtakibi.girisPencere.gp1;


/**
 *
 * @author dell
 */
public class SosyalMedyaİşİlanıTakibi {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) throws SQLException {
        System.out.print("\t Uygulamama Hoşgeldiniz\n");
        System.out.print("Uygulamada  İş İlanlarını Takip edebilirsiniz\n\n");
        uye u1=new uye();
        Scanner giris=new Scanner(System.in);
        İsİlani d1=new İsİlani();

 
         baglankont(u1);
        gp1.show();
        
      
  
        
    }
    static public void baglankont(baglan b)
    {
        System.out.print("Bağlantıyı deniyoruz...");
        b.databaglan();
    }
    
   static public void bul(İsİlani a)
    {
        a.yakala();
    }
}

