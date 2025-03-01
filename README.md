# QR Koder - Java ile QR Kod Oluşturucu  

Selam! Bu proje, Java kullanarak QR kodları oluşturmanı sağlıyor. Bir metin giriyorsun, QR kodunu oluşturuyor ve istersen kaydediyorsun. Tamamen basit, işlevsel ve kullanışlı bir uygulama!  

## 📌 Özellikler  
✅ Metni QR koduna çevirir  
✅ QR kodunu anında ekranda gösterir  
✅ QR kodunu `.png` formatında kaydetme seçeneği sunar  

## 🔧 Gerekli Kütüphaneler  
Bu projede **ZXing** kütüphanesini kullanıyorum. Java'da QR kod oluşturmak için en popüler kütüphanelerden biri. Projeyi çalıştırabilmek için aşağıdaki JAR dosyalarını indirip proje klasörüne eklemen gerekiyor:  

📥 **[core-3.4.1.jar](https://repo1.maven.org/maven2/com/google/zxing/core/3.4.1/core-3.4.1.jar)**  
📥 **[javase-3.4.1.jar](https://repo1.maven.org/maven2/com/google/zxing/javase/3.4.1/javase-3.4.1.jar)**  

## 🚀 Nasıl Çalıştırırsın?  
ZXing JAR dosyalarını ekledikten sonra terminal veya komut satırında şu komutları çalıştır:  

```sh
javac -cp ".;core-3.4.1.jar;javase-3.4.1.jar" QRKoder.java
java -cp ".;core-3.4.1.jar;javase-3.4.1.jar" QRKoder
```

📌 **Eğer hata alırsan** ZXing JAR dosyalarının proje klasöründe olup olmadığını kontrol et. Windows'ta `;`, Linux/Mac'te `:` kullanman gerekebilir.  

## 🎨 Arayüz ve Kullanım  
Bu uygulama **Java Swing** kullanarak basit bir arayüze sahip. Bir metin kutusu, QR kodunu üretmek için bir buton ve oluşturulan QR kodunu göstermek için bir alan var. QR kodu başarılı şekilde oluşturulduğunda, kaydetmek istersen ek bir buton da var.  

## 💡 Sonuç  
Bu proje, Java ile basit ama işlevsel bir QR kod oluşturucu yapmak isteyenler için güzel bir başlangıç. **İndirin, deneyin, geliştirin!** Hatalar veya öneriler için çekinmeden issue açabilirsin. 🚀
