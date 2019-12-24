
Prototip Tasarım Deseni
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
abstract class PrototypeOyun
{
    public abstract PrototypeOyun Clone();
}
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
	
	
	
	Strateji Tasarım Deseni
class Opel
{
    public Opel(string UretimTipi)
    {
        Console.WriteLine($"Opel {UretimTipi} üretilmiştir.");
    }
    public string Marka { get; set; }
    public string Model { get; set; }
    public int KM { get; set; }}
adet üretim yöntemimiz olsun.
class SeriUret
{
    public Opel Uret()
    {
        return new Opel("seri");}}
    

class OzelYapimUret
{
    public Opel Uret()
    {
        return new Opel("özel yapım");
    }
}

class SiparisUzerineUret
{
    public Opel Uret()
    {
        return new Opel("sipariş üzerine");}}
class Uretici
{
    public Uretici()
    {
        SeriUret sUret = new SeriUret();
        sUret.Uret();}}
static void Main(string[] args)
{
    Uretici uret = new Uretici();
    Console.Read();}

class Uretici
{
    public Uretici()
    {
        SiparisUzerineUret suUret = new SiparisUzerineUret();
        suUret.Uret();
    }}
abstract class Strategy
{
    public abstract Opel Uret();}

class SeriUret : Strategy
{
    public override Opel Uret()
    {
        return new Opel("seri");}}
    
class OzelYapimUret : Strategy
{
    public override Opel Uret()
    {
        return new Opel("özel yapım");}}
    
class SiparisUzerineUret : Strategy
{
    public override Opel Uret()
    {
        return new Opel("sipariş üzerine");}}
class Uretici
{
    public Uretici(Strategy Yontem){
    Yontem.Uret();}}
    
static void Main(string[] args)
{
    OzelYapimUret oyUret = new OzelYapimUret();
    SeriUret sUret = new SeriUret();
    SiparisUzerineUret suUret = new SiparisUzerineUret();
    Uretici uret1 = new Uretici(oyUret);
    Uretici uret2 = new Uretici(sUret);
    Uretici uret3 = new Uretici(suUret);
    Console.Read();
}






		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
