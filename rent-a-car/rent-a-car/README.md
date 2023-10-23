## Proje Kurulumu

- frontend klasörü içerisinde `npm install` komutunu çalıştırınız.
- frontend/.env dosyası içerisindeki REACT_APP_API_URL değişkeni ile backend adresi değiştiriniz.
- application.properties dosyası içerisindeki spring.datasource değişkenleri ile veritabanı bağlantı bilgilerini değiştiriniz.
- varsayılan olan backend api localhost:3000 portuna cors desteği ile çalışmaktadır. eğer frontend başka bir portta çalışıyorsa `src/main/java/com/example/rentacar/CorsConfig.java` dosyası içerisindeki `allowedOrigins` değişkenini değiştiriniz.



