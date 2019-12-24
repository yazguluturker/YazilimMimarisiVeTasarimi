# YazilimMimarisiVeTasarimi
Prototip Tasarım Deseni
Merhaba,
Bu yazımda Creational Patterns(Oluşturucu Kalıplar) kategorisine giren Prototype Design Pattern üzerine konuşacağım.
Tasarım deseni yaklaşımlarından Prototype Design Pattern sayesinde elimizdeki mevcut nesnelerin prototiplerini oluşturabilmekte, birnevi bu nesnelerin kopyalarını elde edebilmekteyiz. Prototip deseninin tasarlanmasının asıl sebebi, ilgili nesne üzerinden aynı tipte başka bir nesneyi hızlıca üretebilmektir. Haliyle üretimi esnasında maliyetli olabilecek nesneleri(ki burada maliyetten kasıt, parametreli constructer vs. olabilir) var olan nesne üzerinden “new” anahtar sözcüğünü kullanmadan bir şekilde oluşturulmasını sağlayabilmektedir.


Biliyoruz ki, Shallow Copy ve Deep Copy olmak üzere iki tür nesne kopyalama işlemi mevcuttur. Shallow Copy ile nesnelerin bellekteki adresleri kopyalanmakta dolayısıyla yüzeysel olarak bir kopyalama işlemi gerçekleştirileceği için yeni bir nesne üretilmemekte, var olan nesne üzerine referanslar ile işaretleme yapılmaktadır. Anlayacağınız Shallow Copy, Prototip Tasarım Deseni için uygun tercih olmayacaktır.
Lakin Deep Copy ile nesneler birebir kopyalanabilmekte ve bu kopya sonucu ile asıl nesne farklı referanslar ile işaretlenebilmektedir. İşte Prototip Tasarım Desenin’de bu kopyalama yaklaşımında bulunmak en doğrusudur.
Prototip Tasarım Deseni uygularken aşağıdaki diyagram mantığında hareket etmekteyiz.
<br/>
![proxy](https://user-images.githubusercontent.com/34074096/71422223-2a4ca180-2691-11ea-9caf-1dac9e2720b5.png)
