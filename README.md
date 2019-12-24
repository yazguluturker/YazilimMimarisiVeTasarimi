# YazilimMimarisiVeTasarimi
Prototip Tasarım Deseni
Merhaba,
Bu yazımda Creational Patterns(Oluşturucu Kalıplar) kategorisine giren Prototype Design Pattern üzerine konuşacağım.
Tasarım deseni yaklaşımlarından Prototype Design Pattern sayesinde elimizdeki mevcut nesnelerin prototiplerini oluşturabilmekte, birnevi bu nesnelerin kopyalarını elde edebilmekteyiz. Prototip deseninin tasarlanmasının asıl sebebi, ilgili nesne üzerinden aynı tipte başka bir nesneyi hızlıca üretebilmektir. Haliyle üretimi esnasında maliyetli olabilecek nesneleri(ki burada maliyetten kasıt, parametreli constructer vs. olabilir) var olan nesne üzerinden “new” anahtar sözcüğünü kullanmadan bir şekilde oluşturulmasını sağlayabilmektedir.


Biliyoruz ki, Shallow Copy ve Deep Copy olmak üzere iki tür nesne kopyalama işlemi mevcuttur. Shallow Copy ile nesnelerin bellekteki adresleri kopyalanmakta dolayısıyla yüzeysel olarak bir kopyalama işlemi gerçekleştirileceği için yeni bir nesne üretilmemekte, var olan nesne üzerine referanslar ile işaretleme yapılmaktadır. Anlayacağınız Shallow Copy, Prototip Tasarım Deseni için uygun tercih olmayacaktır.
Lakin Deep Copy ile nesneler birebir kopyalanabilmekte ve bu kopya sonucu ile asıl nesne farklı referanslar ile işaretlenebilmektedir. İşte Prototip Tasarım Desenin’de bu kopyalama yaklaşımında bulunmak en doğrusudur.
Prototip Tasarım Deseni uygularken aşağıdaki diyagram mantığında hareket etmekteyiz.
Prototip Tasarım Deseni uygularken aşağıdaki diyagram mantığında hareket etmekteyiz.
Prototip Tasarım Deseni uygularken aşağıdaki diyagram mantığında hareket etmekteyiz.
<br/>
<br/>
<br/>
<br/>

<br/>

![proxy](https://user-images.githubusercontent.com/34074096/71422223-2a4ca180-2691-11ea-9caf-1dac9e2720b5.png)
<br/>
<br/>
Yukarıdaki diyagramda Prototip bir abstract class yahut interface yapısı olabilir. İçerisinde kendisinden miras alınan sınıfa zorla uygulatacağı Clone metodu mevcuttur. İlgili abstract class veya interface yapımızdan türeyecek olan sınıflarımızdaki Clone metodu sayesinde maliyetsiz bir üretim gerçekleştirebileceğiz.

Yani bu diyagramı net bir şekilde izah etmemiz gerekirse eğer, Prototype Design Pattern’de üç temel yapı bulunmaktadır. Bu yapılara aşağıda değinilmiştir.
⦁	Soyut Sınıf
Yeni nesnelerin kopyalanmasını sağlayan ve bu işlem için Clone metodunu barındıran bir sınıftır. abstract class yahut interface olarak tasarlanabilir.
⦁	Somut Prototip Nesneleri
Soyut sınıfı uygulayacak olan ve projede herhangi bir amaç için kullanılacak olan nesnelerdir. Yani Prototype Design Pattern’i uygulayacağımız projedeki sınıflarımızdır.
⦁	İstemci(Client) Uygulama
Bunu talebi oluşturacak ve deseni kullanacak katman olarak tanımlayabiliriz.

Şimdi pratikte bir örneklendirme yapalım.
Örneğimizde amacımız bir oyun  projesinde  oyunlarımızı prototip tasarım desenini  uygulayarak  üretmektir
<br/>
<br/>
''' C#
class Oyun
{
    public int OyunID { get; set; }
    public string OyunAdi { get; set; }
    public string OyunTuru { get; set; }
    public bool Durum { get; set; }
    public Oyun(int OyunID, string OyunAdi, string OyunTuru, bool Durum)
    {
        this.OyunID = OyunID;
        this.OyunAdi = OyunAdi;
        this.OyunTuru = OyunTuru;
        this.Durum = Durum;
    }
}
'''
<br/>
<br/>
Gördüğünüz gibi yukarıda “Oyun” sınıfımızı tanımlamış bulunmaktayız ve bu sınıftan parametreli constructer ile nesne yaratılmaktadır. İşte maliyetten bahsettiğimiz durum budur ki, ben bir “Oyun” nesnesi yaratmaya çalıştığımda new Oyun(3,”Oyun Adı”,”Oyun Türü”,true) gibi bir parametrik kod zorunluluğu getirmektedir. Haliyle kodsal maliyet bu sınıfın new keywordü ile nesne üretiminde arttırılmıştır.
<br/>
<br/>
'''C# 
abstract class PrototypeOyun
{
    public abstract PrototypeOyun Clone();
}
'''
<br/>
<br/>
Soyut sınıfımız tanımlanarak içine gene aynı tipte dönen Clone metodu eklenmiştir. “Oyun” sınıfımızı bu soyut sınıftan türettiğimiz zaman, ilgili “Oyun” nesnesini Clone metodu ile kopyalayacak ve çok biçimlilik ile “PrototypeOyun” tipinde bir referansa atayabileceğiz.

<br/>
<br/>
'''C#

class Oyun : PrototypeOyun
{
    public int OyunID { get; set; }
    public string OyunAdi { get; set; }
    public string OyunTuru { get; set; }
    public bool Durum { get; set; }
    public Oyun(int OyunID, string OyunAdi, string OyunTuru, bool Durum)
    {
        this.OyunID = OyunID;
        this.OyunAdi = OyunAdi;
        this.OyunTuru = OyunTuru;
        this.Durum = Durum;
    }
 
    public override PrototypeOyun Clone()
    {
        return this.MemberwiseClone() as PrototypeOyun;}}

'''
<br/>
<br/>
Yukarıdaki kod bloğunu incelerseniz eğer soyut sınıfımızdan türetilen “Oyun” sınıfı Clone metodunu implement etmiştir. O anki nesnenin MemberwiseClone metodu ile bir kopyası oluşturularak “PrototypeOyun” tipinde geri gönderilmektedir.

<br/>
<br/>
   '''C#
   
static void Main(string[] args)
{
    Oyun o1 = new Oyun(3, "Oyun Adı", "Oyun Türü", true);
    Oyun o2 = (Oyun)o1.Clone();
 
    if (o1.Equals(o2))
    {
        Console.WriteLine("Eşit");
    }
    else
    {
        Console.WriteLine("Değil");
    }
 
    Console.Read();}

    '''
    <br/>
<br/>
 <br/>
    
    En son Client(İstemci) tarafından bir talep gerçekleştirilmiştir. Gördüğünüz gibi ikinci nesneyi new keywordü ile oluşturmaya kalkmayarak maliyeti göz ardı edip, var olan nesne üzerinden kopyalama işlemi gerçekleştirebiliyoruz.
Burada dikkat etmeniz gereken husus, Prototype tasarım desenini uygulayabilmek için ilgili sınıftan öncelikle new keywordü ile bir nesne üretilmeli, ardından desenimiz üzerinden kopya üretimi tetiklenmelidir.
 <br/>
  <br/>
   <br/>
    <br/>
     <br/>
     
   Strateji Tasarım Deseni
Behavioral Patterns(Davranışsal Kalıplar) kategorisine girer
Bir işlem için birden fazla farklı yöntemlerin uygulanabileceği durumlar mevcuttur. İşte bu tarz durumlarda hangi yöntemin uygulanacağını, hangisinin devreye sokulacağını Strateji Tasarım Deseni ile gerçekleştirebiliyoruz.
Strateji Tasarım Deseninin Class Diyagramı aşağıdaki gibidir
<br/>
     <br/>
     


















