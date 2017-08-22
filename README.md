# AwesomePhoneDirectory

# Amaç

1. Git - GitHub becerilerinin arttırılmasını sağlamak.
2. SQL üzerine beceriler kazanılmasını sağlamak.
3. Temel CRUD fonksiyonlarına hakim olmayı sağlamak.
4. SharedPrefference kullanımına aşina olmak.
5. Pull to Refresh ve ViewPager kullanımını öğrenmek ve deneyim kazanmak.
6. Toolbar ve TabLayout kullanımı konusunda deneyim kazanmak.

# İsterler

1. Projeyi "Fork" ediniz.
2. Master branch'inden yeni bir branch oluşturunuz.
3. Branch ismine kendi adınızı ve soyadınızı veriniz. Örn. ("GökhanÖztürk)
4. Activity - Fragment ikilisini, @string, @color, @style, @dimen gibi resource dosyalarını kullanmayı ihmal etmeyiniz.

# Uygulama

1. Uygulamaya girişte bir "Login Ekranı" tasarlayınız.
2. Bu ekranda "Kullanıcı Adı" ve "Kullanıcı Şifresi" isteyiniz.
3. Şifre alanını gizli yapınız. (Material Design Floating Labels kullanana bir kahve benden :) 
Bknz: https://www.androidhive.info/2015/09/android-material-design-floating-labels-for-edittext/)
4. "Kullanıcı Adı" ve "Kullanıcı Şifresi" ekranlarının altında bir Checkbox ile "Kullanıcı Adımı Hatırla!" yazdırınız.
5. Kullanıcı, bu Checkbox'ı seçerse "Kullanıcı Adı" hafızada tutulacaktır. 
Tick herhangi bir zamanda kaldırılırsa "Kullanıcı Adı" hafızadan silinecektir.
6. Bu Checkbox'ın altında ise "Giriş Yap" Buttonu yer alacaktır. "Kullanıcı Adı" ve "Kullanıcı Şifresi" girilmeden aktif olmayacaktır.
7. Giriş yaptığınızda 2 Tab'lı bir ekran gelecektir.
8. Bu tablardan ikincisi default olarak açık gelecektir.
9. İkinci Tab'da Kullanıcıdan sırasıyla; Ad, Soyad, Telefon, Mail, Adres ve Cinsiyet bilgileri istenecektir.
10. Cinsiyet bilgisini Spinner ile alınız.
11. Bu bilgilerin altında "Kaydet" Butonu yer alacak ve girilen bilgiler SQL'ta kayıt ettirilecektir.
12. Bu bilgilerden Ad, Soyad ve Telefon bilgisi zorunlu, diğer alanlar ise opsiyonel olacaktır.
13. Zorunlu alanlar doldurulmadan "Kaydet" butonu aktif olmayacaktır.
14. Mail doğruluğunu kontrol ettirene kahve ısmarlayacağım :) Email alanı girildiğinde ve Kaydet butonuna basıldığında, eğer Mail adresi
geçerli bir mail adresi değilse, kullanıcıya Toast mesaj verdirilecek ve Kayıt yaptırılmayacaktır.
15. Toast mesajda, "Girdiğiniz mail adresi geçerli bir mail adresi değildir!" yazdırılacaktır.
(Bknz: Regex kontrolü "How should I validate an e-mail address? + stackoverflow ) Bu adım zorunlu değildir.
16. İlk tab'da ise girilen kayıtlar yine Ad, Soyad, Telefon, Mail, Adres ve Cinsiyet olarak listelenecektir.
17. Bu kayıtların yerleşimi Ad Soyad yan yana solda, telefon solda ad ve soyad'ın altında, mail ise en sağda ve ortalı yer alacaktır.
Adres bilgisi ise tüm bunların en altında gözükecektir.
18. Kayıt girilmemiş olan opsiyonel alanların yerinde "---" yazdırılacaktır.
19. Bu liste RecyclerView içerisinde tutulacaktır.
20. Bu ekran aynı zamanda Pull to Refresh yapılabilecektir. Pull to Refresh yapılırsa SQL'dan tüm liste tekrar çekilip, 
liste güncellenecektir.
21. Toolbar'da bir tane "Refresh" butonu yer alacaktır. Bu butona basılırsa Pull to Refresh yine tetiklenecektir.
Pull to Refresh yapılırsa SQL'dan tüm liste tekrar çekilip, liste güncellenecektir.
22. Liste elemanlarından birine tek tıklama yapılırsa, yeni bir activity açılacak ve kullanıcı bilgileri bu ekrana taşınacaktır.
23. Bilgiler edittexlere yazılacak ve defaultta editlenemez olacaklardır (Bknz. enabled = false)
22. Bu ekranda altta 2 buton yer alacaktır. Güncelle ve Sil
23. Kullanıcı Güncelle butonuna basarsa yukarıdaki editlenemez alanlar artık editlenebilecektir.
24. Kullanıcı 2. kez bu butona basarsa, kullanıcı güncellenecek ve bir önceki ekrana dönecektir. Burada yeni güncellenmiş kayıt görülebilecektir.
25. Kullanıcı Sil butonuna basarsa, kayıt silinecektir ve bir önceki ekrana dönecektir. Burada silinen kullanıcı artık görülmemelidir.
26. Kullanıcı 2 tablı ekranda iken çıkmak için 2 kere geri tuşuna basmasını sağlayınız.
27. Yazdığınzı kodları Push'layınız. Ve bu adres üzerindeki ana projeye Pull Request (PR) atınız. Pull Request'lerinizi atarken artık master'ı değil, sizin kendi isminizde açılmış olan ana repodaki branch'lere atınız.

# Not : Master branch'e atılan PR'lar kabul edilmeyecektir.
