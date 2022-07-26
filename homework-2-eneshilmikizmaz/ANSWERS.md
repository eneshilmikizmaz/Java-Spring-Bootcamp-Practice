# HW2 Cevaplar

## Java dünyasındaki framework’ler ve çözdükleri problemler nedir?

- ``Spring :``  Bu framework Java EE uygulamalarını geliştirmeyi kolaylaştırır. Temelde IOC prensibi üzerine kurulmuştur. IOC prensipi basit bir anlatımla kontrolün uygulamadan alınıp framework e devredilmesi denebilir. Peki buna neden ihtiyacımız var ? Sebebi ise Dependecy Injection'ı sağlamasıdır. Bu yapıyı düşündüğümüz de spring framework ü temel olarak bağımlılık yönetimine bir çözümdür.
- ``JSP :`` Java Server Page, HTML kodları içerisine Java komutlarını kolay bir şekilde yerleştirmek için kullanılan Java EE API kütüphanesidir. Uzun HTMl kodları server ve client haberleşmesini karmaşık ve zor hale getirebilir, bu duruma çözüm olarak JSP çıkmıştır. JSP etiketleriyle daha dinamik web sayfaları oluşturmamıza olanak sağlar.
- ``Struts :`` Struts bir tür web uygulama geliştirme framework üdür. JSP sayfaları ile sunucu tarafı Java kodlarının bağlanması için çok faydalı aynı zaman da MVC mimarisini temel aldığı için tekrar kullanılabilir bir yapı kurmamıza olanak sağlıyor.
- ``Vaadin :`` Vaadin bir UI frameworktür.Web ortamında swing programlama modeliyle geliştirme yapmamızı sağlar ve bakımı, yeniden kullanılabilirliği kolaydır. Vaadin Framework ü sadece Java kodu yazarak zengin içerikli ve etkileşimli web uygulamaları geliştirmeye olanak sağlar.

## Katmanlı mimari nedir ?

- Katmanlı mimari temelde projemizi belirli bir düzene göre geliştirmemizi sağlayan, daha okunabilir ve yönetilebilir bir mimari yapıdır. Gereksiz kod tekrarını engeller, projemizde güncelleme yapmamız gerektiğinde bütün projede güncelleme yapmak yerine belli katmanlarda değişkliklerle kod tekrarını engeller bakımını, okunabilirliğini ve yönetimini kolaylaştırır. Temel olarak 3 katmandan oluşur. (Data Access, Business, Presentation)
- ``Data Access Layer :`` Veritabanı işlemlerinin yapıldığı katman. (Ekleme, silme, güncelleme vb.)
- ``Busines Layer :`` Veritabanına direk erişimi engeller gelen veriyi işlediğimiz, yönettiğimiz veritabanı ile iletişimde olan katmandır.
- ``Presentation Layer :`` Kullanıcının gördüğü etkileşim yapabildiği katmandır.(view) Kullanıcının etkisine göre diğer katmanlarla iletişim sağlar.
- ``Entities :`` Bu katmanlara ek olarak bu katmanda da temel olarak Nesnelerimizi ve Propertylerini belirdiğimiz katman.

## Garbage collector nedir, nasıl çalışır? Diğer C++ ile karşılaştırın.

- GC bellek yönetimini sağlayan yapıdır. Temel de bellek kontrol edilir ve refere edilmeyen objelerin silinmesi üzerinedir. Java da bu yapı JVM içerisinde bulunur ve bizim yerimize memory allocation ve deallocation işlemlerini yapar. Daha efektif bir bellek yönetimi sağlar. C++ da ise bu mekanizmanın kontrolü bizim elimizdedir. Bu durum da yazılımda hata çıkma ihtimalini arttırır. Bu yüzden GC Java nın en ayırt edici özelliklerinden birisidir.

##  Spring frameworkünün kullandığı design patternlar neler?

- Spring Framework ünde yaygın olarak kullanılan 4 adet DP vardır. Bunlar; 
- ``Singleton pattern :`` Bir nesneden sadece bir tane olmasını sağlayan modeldir. Örneğin, global bir service nesnesi gibi düşünebiliriz.
- ``Factory Method pattern :`` Nesneyi oluşturmak için bir arayüz kullanılan modeldir. Bu model de oluşturulacak nesnelerin benzer olması, aynı interfaceden implemente edilmiş olması gerekmektedir. Temel de üst sınıfta nesneleri oluşturmaya izin veren alt sınıftda bu nesne türünün değişimine olanak sağlayan bir metottur. (CustomerFactory clasında örneklemesini görebilirsiniz.)
- ``Proxy pattern :`` Temel de bir objeyi temsilen başka bir obje oluşturulmasıdır. Örneğin, bir obje deki bütün propertylere erişmek istemediğimiz durumlarda sadece belli propertylerine erişim izni vererek client tarafında orjinal nesnenin kullanılmasına göre daha az maliyetli bir yapı oluşturmamızı sağlar.
- ``Template pattern :`` Standart olarak yürütülen algoritma adımlarını bir şablon haline getiren pattern dir. Üst sınıfta algoritmanın bir iskeleti oluşturulur, alt sınıfların yapıyı değiştirmeden bu algoritmanın belirli adımlarını değiştirmesine izin veren bir tasarım desenidir. Örnek olarak DB Connection algoritması düşünebiliriz. 

## Creational Patterns neler?

- Nesnelerin nasıl yaratılacağını belirleyen patternlerdir.
- ``1. Abstract Factory :`` Factory design pattern’de tek bir ürün ailesine ait tek bir arayüz mevcutken,abstract factory’de farklı ürün aileleri için farklı arayüzler mevcuttur. Bu tasarımda önemli olan yapısal olarak birbirine  benzeyen ürünlerin ortak bir ara katman üzerinden yönetilebilmesini sağlamaktır. Tek bir arayüzle benzer ürün gruplarının ürün nesnelerini ortak bir ara katman üzerinden oluşturmamızı sağlar.
- ``2. Factory Method :`` Nesnenin nasıl yaratılacağını kalıtım yoluyla alt sınıflara bırakıp nesne yaratımı için tek ara yüz kullanarak, ara yüzle nesne yaratım işlevlerini temelde birbirinden ayırmaya yarayan yaratımsal tasarım kalıbıdır.
- ``3. Builder :`` Nesne yaratım sürecini adımlara parçalar. Bu sayde farklı kombinasyonlarda nesneler oluşturmamız olanak sağlar. Birden fazla karmaşık kurucu metot kullanmamıza gerek kalmaz.
- ``4. Prototype :`` Bir objeyi objenin sınıflarına bağımlı hale gelmeden kopyalamamıza yarayan methottur. Bu metotta klonlamayı destekleyen nesneler için ortak bir arayüz belirlenerek yapılır. Klonlamaya izin veren nesnelere de prototype denir.
- ``5. Singleton :`` Nesnenin sadece bir defa oluşturulmasını öngören bir mekanizma kurulmak istenildiğinde etkin bir biçimde kullanılabilen bir tasarım desenidir. 

