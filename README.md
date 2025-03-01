# QR Koder - Java ile QR Kod Oluşturucu ve Okuyucu  

Merhaba! Bu proje, **Java** kullanarak QR kodları **oluşturmanı** ve **okuyabilmeni** sağlar. Bir metin giriyorsun, QR kodunu oluşturuyor ve istersen kaydediyorsun. Ayrıca, bir QR kodu okutarak içeriğini görebilirsin. Tamamen basit, işlevsel ve kullanışlı bir uygulama!

## Özellikler  
- **Metni QR koduna çevirir**  
- **QR kodunu anında ekranda gösterir**  
- **QR kodunu `.png` formatında kaydetme seçeneği sunar**  
- **QR kodunu okuma ve içeriğini gösterme**  

## Gerekli Kütüphaneler  
Bu projede **ZXing** kütüphanesini kullanıyorum. Java'da QR kod oluşturmak ve okumak için en popüler kütüphanelerden biridir. Projeyi çalıştırabilmek için aşağıdaki JAR dosyalarını indirip proje klasörüne eklemen gerekiyor:

- **[core-3.4.1.jar](https://repo1.maven.org/maven2/com/google/zxing/core/3.4.1/core-3.4.1.jar)**  
- **[javase-3.4.1.jar](https://repo1.maven.org/maven2/com/google/zxing/javase/3.4.1/javase-3.4.1.jar)**  

## Nasıl Çalıştırılır?  
ZXing JAR dosyalarını ekledikten sonra terminal veya komut satırında şu komutları çalıştır:

```sh
javac -cp ".;core-3.4.1.jar;javase-3.4.1.jar" QRKoder.java
java -cp ".;core-3.4.1.jar;javase-3.4.1.jar" QRKoder
```
Eğer hata alırsan, ZXing JAR dosyalarının proje klasöründe olup olmadığını kontrol et. Windows'ta ;, Linux/Mac'te ise : kullanman gerekebilir.

# Arayüz ve Kullanım

Bu uygulama, Java Swing kullanarak basit bir arayüze sahip. İçerisinde bir metin kutusu, QR kodunu üretmek için bir buton ve oluşturulan QR kodunu göstermek için bir alan bulunuyor. QR kodu başarıyla oluşturulduğunda, kaydetmek istersen ek bir buton da mevcut. Ayrıca, QR kodunu okutabilmen için ek bir okuma butonu da bulunmaktadır.

# Sonuç

Bu proje, Java ile basit ama işlevsel bir QR kod oluşturucu ve okuyucu yapmak isteyenler için mükemmel bir başlangıç. İndirin, deneyin, geliştirin! Herhangi bir hata veya öneri için çekinmeden issue açabilirsiniz.
