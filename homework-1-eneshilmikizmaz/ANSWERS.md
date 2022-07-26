# Bootcamp HW1

## 1. Java’nın platform bağımsızlığını nasıl sağladığını anlatınız.

- Java platform bağımsız bir dildir çünkü Java yazılan kodu direk olarak makine diline çevirmez aracı olarak Java ya
  özgü JVM yani java sanal makinesi kullanır ve kodlarımız JVM'in yorumlayabileceği bytecode'a derlenir. Her işletim
  sistemine özgü bir JVM vardır fakat üretilen bytecode çalışıtırdığında bütün JVM ler aynı çıktıyı verir.

## 2. Java neden çoklu kalıtım desteklemez? Hangi diller bu duruma neden izin verir?

- Çoklu kalıtım desteklemez çünkü çoklu kalıtım yapıldığında method overriding işleminde java hangi sınıfa ait metotu
  kullanacağını seçemez. Bu karışıklık istenmediği için ve Java daha anlaşılır ve basit kodlamayı desteklediği için
  çoklu kalıtım desteklemez.
- C ++, Python, Perl gibi diller çoklu kalıtımı destekler. Bu duruma neden izin verir çünkü bazı durumlarda bir classın
  özellikleri diğer classın özelliklerine bağlı olmadığında asimetrik olarak classın türetilmesine olanak sağlar.

## 3.Build Tool Nedir? Java ekosistemindeki toollar nedir?

- Build tool ihtiyaç duyulan kütüphaneleri kod derlenince derlenen kodla birleştirmesini sağlar. Aynı zaman kütüphane
  haricinde projenin bağımlılıklarını kolaylıkla yönetmemize olanak sağlar. ihtiyacımız olan kütüphaneleri, pluginleri
  projeye manuel olarak entegre edip bağımlılıklarını yönetmemize gerek kalmaz.
- Java ekosistemin de en çok Maven kullanılır ona ek olarak Gradle ve Ant build toolları kullanılır.

## 4.Java Collection Framework içerisindeki yapıları örnekleyip açıklayınız.

### 1.List

List temel olarak eklenen değerleri hafızasında sıralı bir şekilde tutar ve tekrarlanan değer atamaları yapılabilir.
List in ArrayList, LinkedList ve Vector olmak üzere 3 farklı implemantsyonu vardır.

`` ArrayList :`` Dinamik bir dizi gibi davranır ve boyut sınırlaması yoktur.

````
        List<String> exampleList = new ArrayList<>(2);
        exampleList.add("Cem Dirman");
        exampleList.add("Ümit Taş");
        exampleList.add("Hüseyin Altun");

        System.out.println(exampleList.get(0));
        exampleList.set(2,"Enes");
        exampleList.forEach(System.out::println);
        exampleList.clear();
        System.out.println(exampleList.size());
````

`` Output : ``

````
        Cem Dirman
        Cem Dirman
        Ümit Taş
        Enes
        0
````

`` LinkedList :`` ArrayList ten farklı olarak node yapısı vardır her bir node hem datayı hemde bir sonraki datanın adresini tutar. Bir nevi pointer şeklinde çalışır. ArrayList arama işlemlerinde daha avantajlıyken LinkedList ekleme, çıkarma işlemlerinde daha avantajlıdır.
````
        List<String> exampleList = new LinkedList<>();
        exampleList.add("Cem Dirman");
        exampleList.add("Ümit Taş");
        exampleList.add("Hüseyin Altun");
        exampleList.add(3, "Enes");
        exampleList.forEach(System.out::println);
        System.out.println(exampleList.size());
````
`` Output : ``

````
        Cem Dirman
        Ümit Taş
        Hüseyin Altun
        Enes
        4
````
`` Vector :`` Vector, senkronize bir collection'dır. Kapasitesi dolduğunda belli bir kural çerçevesinde kapasitesini arttırabilir.
````
        Vector<String> exampleList = new Vector<>(2,5);
        exampleList.add("Cem Dirman");
        exampleList.add("Ümit Taş");
        System.out.println("Size :" + exampleList.size());
        System.out.println("Capacity :" +exampleList.capacity());
        exampleList.add("Hüseyin Altun");
        System.out.println("Size :" + exampleList.size());
        System.out.println("Capacity :" +exampleList.capacity());
        exampleList.forEach(System.out::println);
````
`` Output : ``

````
        Size :2
        Capacity :2
        Size :3
        Capacity :7
        Cem Dirman
        Ümit Taş
        Hüseyin Altun
````

### 2.Set

Set'in diğerlerinden ayırt edici özelliği uniqe data bulundurması data tekrarına izin vermemesidir. Set'in HashSet, LinkedHashSet ve TreeSet olmak üzere 3 farklı implementasyonu vardır.

`` HashSet :`` Uniqe verileri, düzensiz şekilde saklar, performans olarak tasarrufludur.
````
        Set<String> exampleSet = new HashSet<>();
        exampleSet.add("Cem Dirman");
        exampleSet.add("Ümit Taş");
        exampleSet.add("Hüseyin Altun");
        //Aynı datayı tekrar eklemeye çalışıyoruz.
        exampleSet.add("Hüseyin Altun");
        exampleSet.forEach(System.out::println);
````
`` Output : ``

````
        Cem Dirman
        Ümit Taş
        Hüseyin Altun
````
`` LinkedHashSet :`` HashSetten farklı olarak Uniqe verileri, düzenli şekilde saklar, performans olarak maliyetlidir.
````
        Set<String> exampleSet = new LinkedHashSet<>();
        exampleSet.add("Cem Dirman");
        exampleSet.add("Ümit Taş");
        exampleSet.add("Hüseyin Altun");
        //Aynı datayı tekrar eklemeye çalışıyoruz.
        exampleSet.add("Hüseyin Altun");

        Iterator<String> i= exampleSet.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
````
`` Output : ``

````
        Cem Dirman
        Ümit Taş
        Hüseyin Altun
````
`` TreeSet :`` Verilerin eklenme sırasını korumaz fakat TreeSet yapısındaki doğal sıralamaya göre sıralar. 
````
        TreeSet<String> exampleSet = new TreeSet<>();
        exampleSet.add("Cem Dirman");
        exampleSet.add("Ümit Taş");
        exampleSet.add("Hüseyin Altun");
        //Aynı datayı tekrar eklemeye çalışıyoruz.
        exampleSet.add("Hüseyin Altun");
        //Verilerin eklenme sırasına göre sıralanmadığı görülür.
        exampleSet.forEach(System.out::println);
````
`` Output : ``

````
        Cem Dirman
        Hüseyin Altun
        Ümit Taş
````

### 3.Map

Map aslında bir eşleştirme tablosudur. Map her bir data karşılığında unique bir key tutar ve bu key ile data çağırılır. Map in HashMap, LinkedHashMap, HashTable ve TreeMap olmak üzere 4 farklı implementasyonu vardır.

`` HashMap :`` Temel olarak mapin özelliklerini barındırır. Verilerin sıralamasını garanti etmez.
````
        Map<Integer, String> exampleMap = new HashMap<>();
        exampleMap.put(1, "Cem Dirman");
        exampleMap.put(2, "Ümit Taş");
        exampleMap.put(3, "Enes Kızmaz");
        exampleMap.put(4, "Onur Özbay");
        exampleMap.put(5, "Ufuk Dikkülah");
        System.out.println(exampleMap);
        System.out.println(exampleMap.get(3));
        exampleMap.remove(4);
        System.out.println(exampleMap);
````
`` Output : ``

````
        {1=Cem Dirman, 2=Ümit Taş, 3=Enes Kızmaz, 4=Onur Özbay, 5=Ufuk Dikkülah}
        Enes Kızmaz
        {1=Cem Dirman, 2=Ümit Taş, 3=Enes Kızmaz, 5=Ufuk Dikkülah}
````
`` LinkedHashMap :`` LinkedList temeliyle ve HashMap özellikleriyle çalışır. Verilerin sırası korunur.
````
        LinkedHashMap<Integer, String> exampleMap = new LinkedHashMap<>();
        exampleMap.put(1, "Cem Dirman");
        exampleMap.put(2, "Ümit Taş");
        exampleMap.put(3, "Enes Kızmaz");
        exampleMap.put(4, "Onur Özbay");
        exampleMap.put(5, "Ufuk Dikkülah");
        System.out.println(exampleMap);
        System.out.println(exampleMap.get(3));
        exampleMap.remove(4);
        System.out.println("Keys : "+ exampleMap.keySet());
        System.out.println("Values : "+ exampleMap.values());
````
`` Output : ``

````
        {1=Cem Dirman, 2=Ümit Taş, 3=Enes Kızmaz, 4=Onur Özbay, 5=Ufuk Dikkülah}
        Enes Kızmaz
        Keys : [1, 2, 3, 5]
        Values : [Cem Dirman, Ümit Taş, Enes Kızmaz, Ufuk Dikkülah]
````
`` HashTable :`` HashMap ile benzerdir fakat kendine özgü hashing metoduyla çalışır performansı düşüktür. Null değer almaz.
````
        Hashtable<Integer, String> exampleHashTable = new Hashtable<>();
        exampleHashTable.put(1, "Cem Dirman");
        exampleHashTable.put(2, "Ümit Taş");
        exampleHashTable.put(3, "Enes Kızmaz");
        exampleHashTable.put(4, "Onur Özbay");
        exampleHashTable.put(5, "Ufuk Dikkülah");
        System.out.println(exampleHashTable);
        System.out.println(exampleHashTable.get(3));
        exampleHashTable.remove(4);
        System.out.println("Keys : "+ exampleHashTable.keySet());
        System.out.println("Values : "+ exampleHashTable.values());
````
`` Output : ``

````
        {5=Ufuk Dikkülah, 4=Onur Özbay, 3=Enes Kızmaz, 2=Ümit Taş, 1=Cem Dirman}
        Enes Kızmaz
        Keys : [5, 3, 2, 1]
        Values : [Ufuk Dikkülah, Enes Kızmaz, Ümit Taş, Cem Dirman]
````
`` TreeMap :`` Farklı olarak elementleri sadece artan sıra ile tutar.
````
        TreeMap<Integer, String> exampleHashTable = new TreeMap<>();
        exampleHashTable.put(1, "Cem Dirman");
        exampleHashTable.put(2, "Ümit Taş");
        exampleHashTable.put(3, "Enes Kızmaz");
        exampleHashTable.put(4, "Onur Özbay");
        exampleHashTable.put(5, "Ufuk Dikkülah");
        System.out.println(exampleHashTable);
        System.out.println(exampleHashTable.get(3));
        exampleHashTable.remove(4);
        System.out.println("Keys : "+ exampleHashTable.keySet());
        System.out.println("Values : "+ exampleHashTable.values());
````
`` Output : ``

````
        {1=Cem Dirman, 2=Ümit Taş, 3=Enes Kızmaz, 4=Onur Özbay, 5=Ufuk Dikkülah}
        Enes Kızmaz
        Keys : [1, 2, 3, 5]
        Values : [Cem Dirman, Ümit Taş, Enes Kızmaz, Ufuk Dikkülah]
````

## 5. Maven komutları ve çıktıları nelerdir ?

`` clean :``  Projenin derlenmesi sırasında oluşan target klasörünün(build işlemi sonucunda üretilen) silinmesini sağlar.
`` Output : ``
````
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.1.0:clean (default-clean) @ JavaSpringBootcampHW1 ---
[INFO] Deleting C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.404 s
[INFO] Finished at: 2022-06-16T10:08:20+03:00
[INFO] ------------------------------------------------------------------------
````
`` validate :`` Projenin target dosyasını siler ve daha sonra hatalı kısımları tarayarak Projenin doğruluğunu kontrol eder.
`` Output : ``
````
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] Deleting C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.404 s
[INFO] Finished at: 2022-06-16T10:08:20+03:00
[INFO] ------------------------------------------------------------------------
PS C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz> mvn validate
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.107 s
[INFO] Finished at: 2022-06-16T10:08:53+03:00
[INFO] ------------------------------------------------------------------------    
````
`` compile :`` Projeyi clean ve validate eder ardından Kaynak kodu derler.
`` Output : ``
````
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ JavaSpringBootcampHW1 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 12 source files to C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\target\classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.858 s
[INFO] Finished at: 2022-06-16T10:09:32+03:00
[INFO] ------------------------------------------------------------------------
````
`` test :`` Unit testleri çalışıtırmak için kullanılır.
`` Output : ``
````
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ JavaSpringBootcampHW1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ JavaSpringBootcampHW1 ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\target\test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ JavaSpringBootcampHW1 ---
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit4/2.22.1/surefire-junit4-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit4/2.22.1/surefire-junit4-2.22.1.pom (3.1 kB at 5.5 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/2.22.1/surefire-providers-2.22.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-providers/2.22.1/surefire-providers-2.22.1.pom (2.5 kB at 24 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit4/2.22.1/surefire-junit4-2.22.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit4/2.22.1/surefire-junit4-2.22.1.jar (85 kB at 489 kB/s)
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.044 s - in org.example.AppTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.884 s
[INFO] Finished at: 2022-06-16T10:10:03+03:00
[INFO] ------------------------------------------------------------------------
    
````
`` package :`` Projeyi testlerini yapar ve eğer hata yoksa projeyi paketler. jar dosyasını oluşturur.
`` Output : ``
````
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ JavaSpringBootcampHW1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ JavaSpringBootcampHW1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ JavaSpringBootcampHW1 ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.032 s - in org.example.AppTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ JavaSpringBootcampHW1 ---
[INFO] Building jar: C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\target\JavaSpringBootcampHW1-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.420 s
[INFO] Finished at: 2022-06-16T10:11:08+03:00
[INFO] ------------------------------------------------------------------------
````
`` verify :`` Entegrasyon teslerinin sonuçlarını kontrol ederek kalite kriterine ulaşıldığından emin olur.
`` Output : ``
````
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ JavaSpringBootcampHW1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ JavaSpringBootcampHW1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ JavaSpringBootcampHW1 ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.035 s - in org.example.AppTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ JavaSpringBootcampHW1 ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.328 s
[INFO] Finished at: 2022-06-16T10:12:01+03:00
[INFO] ------------------------------------------------------------------------
````
`` install :`` Diğer projelerde dependency olarak kullanmak için paketleri local depoya yükler.
`` Output : ``
````
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ JavaSpringBootcampHW1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ JavaSpringBootcampHW1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ JavaSpringBootcampHW1 ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.026 s - in org.example.AppTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO]
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ JavaSpringBootcampHW1 ---
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ JavaSpringBootcampHW1 ---
[INFO] Installing C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\target\JavaSpringBootcampHW1-1.0-SNAPSHOT.jar to C:\Users\testinium\.m2\repository\org\example\JavaSpringBootcampHW1\1.0-SNAPSHOT\
JavaSpringBootcampHW1-1.0-SNAPSHOT.jar
[INFO] Installing C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\pom.xml to C:\Users\testinium\.m2\repository\org\example\JavaSpringBootcampHW1\1.0-SNAPSHOT\JavaSpringBootcampHW1-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.366 s
[INFO] Finished at: 2022-06-16T10:12:25+03:00
[INFO] ------------------------------------------------------------------------       
````
`` site :``  Projenin site dökümantasyonunu oluşturur
`` Output : ``
````
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-site-plugin:3.7.1:site (default-site) @ JavaSpringBootcampHW1 ---
[INFO] configuring report plugin org.apache.maven.plugins:maven-project-info-reports-plugin:3.0.0
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-project-info-reports-plugin/3.0.0/maven-project-info-reports-plugin-3.0.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-project-info-reports-plugin/3.0.0/maven-project-info-reports-plugin-3.0.0.pom (20 kB at 40 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-project-info-reports-plugin/3.0.0/maven-project-info-reports-plugin-3.0.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-project-info-reports-plugin/3.0.0/maven-project-info-reports-plugin-3.0.0.jar (300 kB at 1.3 MB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/reporting/maven-reporting-impl/3.0.0/maven-reporting-impl-3.0.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/reporting/maven-reporting-impl/3.0.0/maven-reporting-impl-3.0.0.pom (7.6 kB at 76 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.2.0/maven-shared-utils-3.2.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.2.0/maven-shared-utils-3.2.0.pom (4.9 kB at 52 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sink-api/1.7/doxia-sink-api-1.7.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sink-api/1.7/doxia-sink-api-1.7.pom (1.5 kB at 17 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia/1.7/doxia-1.7.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia/1.7/doxia-1.7.pom (15 kB at 150 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.7/doxia-logging-api-1.7.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-logging-api/1.7/doxia-logging-api-1.7.pom (1.5 kB at 16 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.7.4/doxia-decoration-model-1.7.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-decoration-model/1.7.4/doxia-decoration-model-1.7.4.pom (3.4 kB at 36 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sitetools/1.7.4/doxia-sitetools-1.7.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-sitetools/1.7.4/doxia-sitetools-1.7.4.pom (14 kB at 127 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-core/1.7/doxia-core-1.7.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-core/1.7/doxia-core-1.7.pom (4.1 kB at 39 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/xmlunit/xmlunit/1.5/xmlunit-1.5.pom
Downloaded from central: https://repo.maven.apache.org/maven2/xmlunit/xmlunit/1.5/xmlunit-1.5.pom (3.0 kB at 33 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-site-renderer/1.7.4/doxia-site-renderer-1.7.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-site-renderer/1.7.4/doxia-site-renderer-1.7.4.pom (6.7 kB at 72 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-skin-model/1.7.4/doxia-skin-model-1.7.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-skin-model/1.7.4/doxia-skin-model-1.7.4.pom (3.0 kB at 34 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-xhtml/1.7/doxia-module-xhtml-1.7.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-module-xhtml/1.7/doxia-module-xhtml-1.7.pom (1.6 kB at 18 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-modules/1.7/doxia-modules-1.7.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/doxia/doxia-modules/1.7/doxia-modules-1.7.pom (2.6 kB at 24 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-dependency-tree/2.2/maven-dependency-tree-2.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-dependency-tree/2.2/maven-dependency-tree-2.2.pom (7.3 kB at 74 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-components/20/maven-shared-components-20.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-components/20/maven-shared-components-20.pom (5.1 kB at 52 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-jar/1.2/maven-shared-jar-1.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-jar/1.2/maven-shared-jar-1.2.pom (4.4 kB at 47 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.9/maven-shared-utils-0.9.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/0.9/maven-shared-utils-0.9.pom (6.2 kB at 66 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/bcel/bcel/6.2/bcel-6.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/bcel/bcel/6.2/bcel-6.2.pom (20 kB at 205 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-artifact-transfer/0.9.1/maven-artifact-transfer-0.9.1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-artifact-transfer/0.9.1/maven-artifact-transfer-0.9.1.pom (7.6 kB at 67 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-api/1.10.0/maven-scm-api-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-api/1.10.0/maven-scm-api-1.10.0.pom (1.6 kB at 17 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm/1.10.0/maven-scm-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm/1.10.0/maven-scm-1.10.0.pom (26 kB at 247 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-manager-plexus/1.10.0/maven-scm-manager-plexus-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-manager-plexus/1.10.0/maven-scm-manager-plexus-1.10.0.pom (2.2 kB at 24 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-managers/1.10.0/maven-scm-managers-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-managers/1.10.0/maven-scm-managers-1.10.0.pom (1.5 kB at 17 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-hg/1.10.0/maven-scm-provider-hg-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-hg/1.10.0/maven-scm-provider-hg-1.10.0.pom (2.4 kB at 25 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-providers/1.10.0/maven-scm-providers-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-providers/1.10.0/maven-scm-providers-1.10.0.pom (3.6 kB at 38 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-perforce/1.10.0/maven-scm-provider-perforce-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-perforce/1.10.0/maven-scm-provider-perforce-1.10.0.pom (2.6 kB at 28 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-starteam/1.10.0/maven-scm-provider-starteam-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-starteam/1.10.0/maven-scm-provider-starteam-1.10.0.pom (2.7 kB at 14 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-svn-commons/1.10.0/maven-scm-provider-svn-commons-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-svn-commons/1.10.0/maven-scm-provider-svn-commons-1.10.0.pom (2.8 kB at 29 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-providers-svn/1.10.0/maven-scm-providers-svn-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-providers-svn/1.10.0/maven-scm-providers-svn-1.10.0.pom (2.2 kB at 23 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-svnexe/1.10.0/maven-scm-provider-svnexe-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-svnexe/1.10.0/maven-scm-provider-svnexe-1.10.0.pom (2.7 kB at 25 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvs-commons/1.10.0/maven-scm-provider-cvs-commons-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvs-commons/1.10.0/maven-scm-provider-cvs-commons-1.10.0.pom (2.4 kB at 25 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-providers-cvs/1.10.0/maven-scm-providers-cvs-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-providers-cvs/1.10.0/maven-scm-providers-cvs-1.10.0.pom (1.8 kB at 19 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvsexe/1.10.0/maven-scm-provider-cvsexe-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvsexe/1.10.0/maven-scm-provider-cvsexe-1.10.0.pom (2.8 kB at 31 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvsjava/1.10.0/maven-scm-provider-cvsjava-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvsjava/1.10.0/maven-scm-provider-cvsjava-1.10.0.pom (2.7 kB at 29 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/netbeans/lib/cvsclient/20060125/cvsclient-20060125.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/netbeans/lib/cvsclient/20060125/cvsclient-20060125.pom (459 B at 4.9 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/ch/ethz/ganymed/ganymed-ssh2/build210/ganymed-ssh2-build210.pom
Downloaded from central: https://repo.maven.apache.org/maven2/ch/ethz/ganymed/ganymed-ssh2/build210/ganymed-ssh2-build210.pom (710 B at 6.7 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-git-commons/1.10.0/maven-scm-provider-git-commons-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-git-commons/1.10.0/maven-scm-provider-git-commons-1.10.0.pom (2.7 kB at 27 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-providers-git/1.10.0/maven-scm-providers-git-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-providers-git/1.10.0/maven-scm-providers-git-1.10.0.pom (2.2 kB at 24 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-gitexe/1.10.0/maven-scm-provider-gitexe-1.10.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-gitexe/1.10.0/maven-scm-provider-gitexe-1.10.0.pom (2.6 kB at 27 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-http-lightweight/3.1.0/wagon-http-lightweight-3.1.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-http-lightweight/3.1.0/wagon-http-lightweight-3.1.0.pom (2.6 kB at 26 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-providers/3.1.0/wagon-providers-3.1.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-providers/3.1.0/wagon-providers-3.1.0.pom (2.8 kB at 31 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon/3.1.0/wagon-3.1.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon/3.1.0/wagon-3.1.0.pom (21 kB at 200 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-http-shared/3.1.0/wagon-http-shared-3.1.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-http-shared/3.1.0/wagon-http-shared-3.1.0.pom (2.6 kB at 28 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/jsoup/jsoup/1.11.2/jsoup-1.11.2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/jsoup/jsoup/1.11.2/jsoup-1.11.2.pom (8.2 kB at 89 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpclient/4.5.5/httpclient-4.5.5.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpclient/4.5.5/httpclient-4.5.5.pom (6.2 kB at 66 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-client/4.5.5/httpcomponents-client-4.5.5.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-client/4.5.5/httpcomponents-client-4.5.5.pom (15 kB at 156 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-parent/10/httpcomponents-parent-10.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-parent/10/httpcomponents-parent-10.pom (34 kB at 298 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcore/4.4.9/httpcore-4.4.9.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcore/4.4.9/httpcore-4.4.9.pom (5.1 kB at 51 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-core/4.4.9/httpcomponents-core-4.4.9.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-core/4.4.9/httpcomponents-core-4.4.9.pom (13 kB at 128 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-parent/9/httpcomponents-parent-9.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/httpcomponents/httpcomponents-parent/9/httpcomponents-parent-9.pom (34 kB at 349 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/3.1.0/wagon-provider-api-3.1.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/3.1.0/wagon-provider-api-3.1.0.pom (1.9 kB at 9.8 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/reporting/maven-reporting-impl/3.0.0/maven-reporting-impl-3.0.0.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-8/plexus-container-default-1.0-alpha-8.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-dependency-tree/2.2/maven-dependency-tree-2.2.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-jar/1.2/maven-shared-jar-1.2.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.2.0/maven-shared-utils-3.2.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/reporting/maven-reporting-impl/3.0.0/maven-reporting-impl-3.0.0.jar (18 kB at 193 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/3.1/commons-collections-3.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-jar/1.2/maven-shared-jar-1.2.jar (38 kB at 134 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/bcel/bcel/6.2/bcel-6.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-dependency-tree/2.2/maven-dependency-tree-2.2.jar (64 kB at 143 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-artifact-transfer/0.9.1/maven-artifact-transfer-0.9.1.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-shared-utils/3.2.0/maven-shared-utils-3.2.0.jar (165 kB at 297 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-api/1.10.0/maven-scm-api-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/shared/maven-artifact-transfer/0.9.1/maven-artifact-transfer-0.9.1.jar (123 kB at 163 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-manager-plexus/1.10.0/maven-scm-manager-plexus-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-api/1.10.0/maven-scm-api-1.10.0.jar (110 kB at 132 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-hg/1.10.0/maven-scm-provider-hg-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/codehaus/plexus/plexus-container-default/1.0-alpha-8/plexus-container-default-1.0-alpha-8.jar (195 kB at 228 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-perforce/1.10.0/maven-scm-provider-perforce-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-manager-plexus/1.10.0/maven-scm-manager-plexus-1.10.0.jar (11 kB at 13 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-starteam/1.10.0/maven-scm-provider-starteam-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-hg/1.10.0/maven-scm-provider-hg-1.10.0.jar (69 kB at 69 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-svn-commons/1.10.0/maven-scm-provider-svn-commons-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-starteam/1.10.0/maven-scm-provider-starteam-1.10.0.jar (73 kB at 68 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-svnexe/1.10.0/maven-scm-provider-svnexe-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-perforce/1.10.0/maven-scm-provider-perforce-1.10.0.jar (86 kB at 80 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvs-commons/1.10.0/maven-scm-provider-cvs-commons-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-svn-commons/1.10.0/maven-scm-provider-svn-commons-1.10.0.jar (38 kB at 33 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvsexe/1.10.0/maven-scm-provider-cvsexe-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/commons-collections/commons-collections/3.1/commons-collections-3.1.jar (559 kB at 481 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvsjava/1.10.0/maven-scm-provider-cvsjava-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-svnexe/1.10.0/maven-scm-provider-svnexe-1.10.0.jar (81 kB at 65 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/netbeans/lib/cvsclient/20060125/cvsclient-20060125.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvsexe/1.10.0/maven-scm-provider-cvsexe-1.10.0.jar (31 kB at 24 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/ch/ethz/ganymed/ganymed-ssh2/build210/ganymed-ssh2-build210.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvs-commons/1.10.0/maven-scm-provider-cvs-commons-1.10.0.jar (79 kB at 60 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-cvsjava/1.10.0/maven-scm-provider-cvsjava-1.10.0.jar (45 kB at 34 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/bcel/bcel/6.2/bcel-6.2.jar (674 kB at 509 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.2/commons-io-2.2.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-gitexe/1.10.0/maven-scm-provider-gitexe-1.10.0.jar
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-git-commons/1.10.0/maven-scm-provider-git-commons-1.10.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-git-commons/1.10.0/maven-scm-provider-git-commons-1.10.0.jar (35 kB at 23 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/scm/maven-scm-provider-gitexe/1.10.0/maven-scm-provider-gitexe-1.10.0.jar (69 kB at 44 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-http-lightweight/3.1.0/wagon-http-lightweight-3.1.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/commons-io/commons-io/2.2/commons-io-2.2.jar (174 kB at 107 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-http-shared/3.1.0/wagon-http-shared-3.1.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-http-lightweight/3.1.0/wagon-http-lightweight-3.1.0.jar (17 kB at 10 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/jsoup/jsoup/1.11.2/jsoup-1.11.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-http-shared/3.1.0/wagon-http-shared-3.1.0.jar (36 kB at 20 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/3.1.0/wagon-provider-api-3.1.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/ch/ethz/ganymed/ganymed-ssh2/build210/ganymed-ssh2-build210.jar (245 kB at 136 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/wagon/wagon-provider-api/3.1.0/wagon-provider-api-3.1.0.jar (55 kB at 29 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/netbeans/lib/cvsclient/20060125/cvsclient-20060125.jar (619 kB at 311 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/commons/commons-lang3/3.5/commons-lang3-3.5.jar (480 kB at 228 kB/s)
Downloaded from central: https://repo.maven.apache.org/maven2/org/jsoup/jsoup/1.11.2/jsoup-1.11.2.jar (392 kB at 186 kB/s)
[INFO] 15 reports detected for maven-project-info-reports-plugin:3.0.0: ci-management, dependencies, dependency-info, dependency-management, distribution-management, index, issue-management, licenses, mailing-lists, modules, plugin-
management, plugins, scm, summary, team
[INFO] Rendering site with default locale English (en)
[INFO] Relativizing decoration links with respect to localized project URL: http://www.example.com
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/skins/maven-default-skin/1.2/maven-default-skin-1.2.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/skins/maven-default-skin/1.2/maven-default-skin-1.2.jar (14 kB at 141 kB/s)
[INFO] Rendering content with org.apache.maven.skins:maven-default-skin:jar:1.2 skin.
[INFO] Generating "Dependencies" report  --- maven-project-info-reports-plugin:3.0.0:dependencies
[INFO] Generating "Dependency Information" report --- maven-project-info-reports-plugin:3.0.0:dependency-info
[INFO] Generating "About" report         --- maven-project-info-reports-plugin:3.0.0:index
[INFO] Generating "Plugin Management" report --- maven-project-info-reports-plugin:3.0.0:plugin-management
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-antrun-plugin/1.3/maven-antrun-plugin-1.3.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-antrun-plugin/1.3/maven-antrun-plugin-1.3.pom (4.7 kB at 18 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/12/maven-plugins-12.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/12/maven-plugins-12.pom (12 kB at 113 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/9/maven-parent-9.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/9/maven-parent-9.pom (33 kB at 304 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-assembly-plugin/2.2-beta-5/maven-assembly-plugin-2.2-beta-5.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-assembly-plugin/2.2-beta-5/maven-assembly-plugin-2.2-beta-5.pom (15 kB at 131 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/16/maven-plugins-16.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-plugins/16/maven-plugins-16.pom (13 kB at 126 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-dependency-plugin/2.8/maven-dependency-plugin-2.8.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-dependency-plugin/2.8/maven-dependency-plugin-2.8.pom (11 kB at 117 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-release-plugin/2.5.3/maven-release-plugin-2.5.3.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-release-plugin/2.5.3/maven-release-plugin-2.5.3.pom (11 kB at 103 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/release/maven-release/2.5.3/maven-release-2.5.3.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/release/maven-release/2.5.3/maven-release-2.5.3.pom (5.0 kB at 51 kB/s)
[INFO] Generating "Plugins" report       --- maven-project-info-reports-plugin:3.0.0:plugins
[INFO] Generating "Summary" report       --- maven-project-info-reports-plugin:3.0.0:summary
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  13.149 s
[INFO] Finished at: 2022-06-16T10:13:09+03:00
[INFO] ------------------------------------------------------------------------   
````
`` deploy :`` Üretilen siteyi belirtilen web sunucusuna yerleştirir, (komut çalıştığında hata alınıyor çünkü deploy için bir url belirtilmedi.)
`` Output : ``
````
[INFO] Scanning for projects...
[INFO] 
[INFO] -----------------< org.example:JavaSpringBootcampHW1 >------------------
[INFO] Building JavaSpringBootcampHW1 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.0.2:resources (default-resources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:compile (default-compile) @ JavaSpringBootcampHW1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:3.0.2:testResources (default-testResources) @ JavaSpringBootcampHW1 ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.0:testCompile (default-testCompile) @ JavaSpringBootcampHW1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.22.1:test (default-test) @ JavaSpringBootcampHW1 ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running org.example.AppTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.032 s - in org.example.AppTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] 
[INFO] --- maven-jar-plugin:3.0.2:jar (default-jar) @ JavaSpringBootcampHW1 ---
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ JavaSpringBootcampHW1 ---
[INFO] Installing C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\target\JavaSpringBootcampHW1-1.0-SNAPSHOT.jar to C:\Users\testinium\.m2\repository\org\example\JavaSpringBootcampHW1\1.0-SNAPSHOT\
JavaSpringBootcampHW1-1.0-SNAPSHOT.jar
[INFO] Installing C:\Users\testinium\Desktop\LogoYazilimJavaSpringBootcamp\homework-1-eneshilmikizmaz\pom.xml to C:\Users\testinium\.m2\repository\org\example\JavaSpringBootcampHW1\1.0-SNAPSHOT\JavaSpringBootcampHW1-1.0-SNAPSHOT.pom
[INFO] 
[INFO] --- maven-deploy-plugin:2.8.2:deploy (default-deploy) @ JavaSpringBootcampHW1 ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.465 s
[INFO] Finished at: 2022-06-16T10:13:53+03:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-deploy-plugin:2.8.2:deploy (default-deploy) on project JavaSpringBootcampHW1: Deployment failed: repository element was not specified in the POM inside distributionManage
ment element or in -DaltDeploymentRepository=id::layout::url parameter -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
````




