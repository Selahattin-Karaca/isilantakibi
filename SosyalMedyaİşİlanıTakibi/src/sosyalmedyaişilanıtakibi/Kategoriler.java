/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sosyalmedyaişilanıtakibi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Kategoriler extends İsİlani{
     
    Scanner giris=new Scanner(System.in);
    public ArrayList bilisim=new ArrayList();
    public  ArrayList satis =new ArrayList();
    public  ArrayList sağlik =new ArrayList();
    public ArrayList <String>kullanıcıbaşvuuları=new ArrayList();
    //yapıcı metotta iş ilanlarını yüklüyoruz
      Kategoriler()
     {
         System.out.print(" İlanları Bölmündesiniz.");
         bilisim.add("Kıdemli Yazılım Geliştirme Uzmanı\t-İstanbul\t-10000-\t05954565656\n\nİstenilen Kriterler\n-Tercihen üniversitelerin Bilgisayar,  Matematik, Endüstri Mühendisliği bölümlerinden mezun\n-Web development alanında 3+ yıllık tecrübeye sahip,\n-Tercihen  AngularJS, VueJS, vb. teknolojileri ile uygulama geliştirmiş\n,-Erkek adaylar için askerliğini tamamlamış.\n-Responsive design hakkında bilgisi olan ve tercihen uygulama geliştirmiş,");
         bilisim.add("Php Yazılım Uzmanı                \t-Kastamonu\t-4000\t-05954565656\n\nİş Detayı\n-TALENTSYS 1990 yılından itibaren insan kaynakları yönetimine yardımcı olmak üzere teknoloji çözümleri üretmekte ve yaklaşık 30 yıldır her sektörden Türkiye’nin önde gelen kuruluşlarına hizmet vermektedir.-E-Ticaret konusunda 20 yıllık deneyime sahip şirketimiz yazılım ekibinde,\n Türkiye'nin tanınmış perakende firmalarının E-Ticaret projelerinde görevlendirilecek, object oriented PHP programlama konusunda;\n\nİstenilen Kriterler\n-PHP Framework yapılarında deneyimli- MySQL kullanımında deneyimli\n- HTML, CSS, Jquery konularına hakim; React, Node.js konularında bilgi sahibi,\n");
         satis.add("Satış Danışmanı Gürel Optik San.Tic.Ltd.Şti.\t-Çanakkale\t-5000\t-05954565656\n\nİş Detayı\nMüşteri memnuniyetini sağlayarak gözlük, kontak gözlük camı v.b alış ve satış işlemlerini gerçekleştirmek.\n\nİstenilen Kriterler\n-Lise, ön lisans veya tercihen lisans mezunu,\n-Optik satışı ve satış konusunda en az 1 yıl tecrubeli,\n-Optik satışı ve satış konusunda en az 1 yıl tecrubeli,\n");
         sağlik.add("Yatılı Yada Gündüzlü Özel Bakım Hemşiresi\t-Tekirdağ\t-6000\t05765667767\n\nİş Detayı\nKadıköy Bostancıda 86 yasında kalçadan ameliyat olan teyzenin takibini yapacak,ilacını yemeğini takip edecek yatılı yada gündüzlü çalışacak\n tecrübeli ve referanslı en az 10 15 sene deneyimli profesyonel Türk hemşire arıyoruz.\n");
         bilisim.add(" Yazılım Geliştirme Uzmanı        \t-Karabük\t-5000-\t05954565656\n\nİstenilen Kriterler\n-Tercihen üniversitelerin Bilgisayar,  Matematik, Endüstri Mühendisliği bölümlerinden mezun\n-Web development alanında 3+ yıllık tecrübeye sahip,\n-Tercihen  AngularJS, VueJS, vb. teknolojileri ile uygulama geliştirmiş\n,-Erkek adaylar için askerliğini tamamlamış.\n-Responsive design hakkında bilgisi olan ve tercihen uygulama geliştirmiş,");
         bilisim.add("Yazılım Destek ve Eğitim Uzmanı   \t-İstanbul\t-6000-\t055555555\n\nİş Detayı\n-Yurt içinde ve yurt dışında;Proje süreçlerinde müşteri ihtiyaç analizini yapacak,Yazılımın müşteri ortamında\n kuruluşunu yapacak,Müşteri ihtiyaçlarına göre rapor tasarımı yapacak,Son kullanıcılarına eğitim ve destek hizmeti verecek,\n");
         bilisim.add("Web Tasarımcısı                   \t-İstanbul\t-5000-\t055555555\n\nİş Detayı\nEğitim Sektörüne yönelik web tabanlı yazılımlar geliştirmekte olan şirketimizde, yazılım altyapısı .NET tabanlı olup, C#, ASP.NET kullanılmaktadır. \n\nİstenilen Kriterler\n-HTML5, JAVASCRIPT, AJAX, XML, JQuery, JSON ve CSS3 teknolojilerine hakim,\n-W3C standartlarında, responsive kod yazabilen,\n- Mobil Sayfa teknolojisi konusunda bilgili,\n");
         satis.add("Satış Danışmanı                     \t-Edirne\t-4500\t-05954565656\n\nİş Detayı\nMüşteri memnuniyetini sağlayarak gözlük, kontak gözlük camı v.b alış ve satış işlemlerini gerçekleştirmek.\n\nİstenilen Kriterler\n-Lise, ön lisans veya tercihen lisans mezunu,\n-Optik satışı ve satış konusunda en az 1 yıl tecrubeli,\n-Optik satışı ve satış konusunda en az 1 yıl tecrubeli,\n");
         sağlik.add("Eczacı Teknisyeni                  \t-Bursa \t-5000\t-0505050505\n\nİş Detayı\nENAZ 2-3 YIL DENEYİMİ OLAN ,GÜLERYÜZLÜ,İŞİNİ SEVEREK VE TİTİZLİKLE YAPAN,TEMİZ TİTİZ BAYAN ÇALIŞMA ARKADAŞI ARIYORUZ\n");
     }
     
            
  /*  @Override
    public void ilangöster(ArrayList dizi )
     {
         super.ilangöster(dizi);
     }*/

      
     public void yakala()
     {
         System.out.print("kategori yakalandı");
     }
}
