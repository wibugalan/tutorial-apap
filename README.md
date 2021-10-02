# Tutorial APAP
## Authors
* **Muhammad Marsha Prawira** - *1906353864* - *C*
---
## Tutorial 4
### What I have learned today
Saya belajar mengenai pengaplikasian thymleaf yang menurut saya cukup advanced apabila dibandingkan dengan tutorial sebelumnya
### Pertanyaan
1. Jelaskan perbedaan th:include dan th:replace!
= include memanggil isi dari fragment kedalam tempat th:include diletakan, sedangkan replace akan menggantikan elemen didalamnya dan menjadi parent dari lokasinya diletakan.

2. Jelaskan apa fungsi dari th:object!
= saat mengerjakan tutor ini, th:object berperan untuk mengoper objek pada spring dan template html.

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
= * digunakan saat menyatakan sebuah selection, sedangkan $ untuk menyatakan sebuah variabel atau nilai. * digunakan setelah objek ditentukan sebelumnya, sedangkan $ digunakan untuk menyatakan variabel(lebih luas dan tergeneralisasi).
Referensi: https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html
### What I did not understand
saya sedikit kebingungan dalam mengoper-oper list film.
---
## Tutorial 3
### What I have learned today
Saya belajar mengenai pengaplikasian konsep MVC(Model View Controller) pada Springboot serta CRUD data dengan menggunakan database pada MySql.
### Pertanyaan
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
= @AllArgsConstructor digunakan untuk membuat konstruktor yang membutuhkan argumen untuk setiap field.
@NoArgsConstructor digunakan untuk membuat konstruktor yang tidak membutuhkan argumen atau parameter untuk fieldnya.
@Setter membuat fungsi setter pada objek (menentukan nilai parameter)
@Getter membuat fungsi getter pada objek (mendapatkan nilai parameter)
@Entity membuat entitas agar dapat direkognisi oleh JPA dengan nama default sesuai nama class. entity ini akan mengisi row pada tabel
referensi: https://www.baeldung.com/jpa-entities
@Table membuat sebuah tabel dari yang akan berisi entitas-entitas

2. Pada class BioskopDB, terdapat method findByNoBioskop, apakah kegunaan dari method tersebut?
= Method tersebut akan mengembalikan bioskop dengan parameter noBioskop dari database

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
= @JoinTable itu kita gunakan apabila kita ingin membuat sebuah hubungan antar entity a dengan entity b, sedangkan @JoinColumn hanya pada salah satu kolom dengan menggunakan foreign key antar entitas a dan entitas b.
referensi: https://stackoverflow.com/questions/30288464/when-should-i-use-joincolumn-or-jointable-with-jpa

4. Pada class PenjagaModel, digunakan anotasi @JoinColumn pada atribut bioskop, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull
= @JoinColumn tersebut akan membuat foreign key yang diambil dari tabel. name akan menentukan nama kolom, referencedColumnName akan menentukan kolom tujuan yang menjadi referensi foreign key, nullable berarti isi dari kolom tersebut dapat berisi null. nullable mengatur definisi restriksi pada tabel, sedangnkan @NotNull mengatur restriksi saat mengisi entity.
referensi: https://thorben-janssen.com/hibernate-tips-whats-the-difference-between-column-nullable-false-and-notnull

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
= 
FetchType.LAZY atau Lazy Loading merupakan pola desain yang digunakan untuk menunda inisialisasi objek selama mungkin dan baru diinisialisasi saat dibutuhkan
FetchType.EAGER atau Eager Loading merupakan pola desain yang digunakan untuk melakukan inisialisasi objek secepat mungkin 
CascadeType.ALL akan melakukan semua operasi yang diperintahkan
referensi: https://qastack.id/programming/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api

### What I did not understand
Konsep penggunaan repository.

---
## Tutorial 2
### What I have learned today
Saya belajar mengenai pengaplikasian konsep MVC(Model View Controller) pada Springboot serta CRUD data tanpa database.
### Pertanyaan
1. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx jumlahStudio=10 
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
= Saat menjalankan step ini, kita belum membuat komponen view yaitu file HTML padahal sudah kita panggil melalui controller. Hal tersebut menyebabkan error.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
= Anotasi @Autowired membuat kita tidak perlu melakukan wiring sendiri pada file XML atau yang lainnya dan melakukan untuk kita apa yang perlu untuk di inject.
referensi: https://stackoverflow.com/questions/19414734/understanding-spring-autowired-usage 

3. Cobalah untuk menambahkan sebuah Bioskop dengan mengakses link berikut:
http://localhost:8080/bioskop/add?idBioskop=1&namaBioskop=Bioskop%20PAPA%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
= Saat mengakses link tersebut akan keluar pesan error karena kita belum mendefinisikan jumlah studio pada url. Sehingga saat object dibuat akan kekurangan 1 parameter sehingga menjadi error.

4. Jika Papa APAP ingin melihat Bioskop dengan nama Bioskop Maung, link apa yang harus diakses?
= http://localhost:8080/bioskop/view/id-bioskop/1

5. Tambahkan 1 contoh Bioskop lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/bioskop/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
= [berikut]https://ibb.co/wpDQ5gP

### What I did not understand
Konsep pada penggunaan autowiring pada controller.

---
## Tutorial 1
### What I have learned today
Saya belajar command2 dasar dan yang sedikit advance dari github serta membuat program springboot pertama saya.
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Kita bisa menuliskan masalah yang ada seperti improvement, bug, fitur baru, dan semacamnya pada issue tracker agar bisa memantaunya dengan mudah karena terdapat lognya.

2. Apa perbedaan dari git merge dan git merge --squash?
Git merge adalah perintah default pada git untuk menggabungkan commit dari sebuah branch yang dilakukan pull request untuk digabungkan dengan branch utama. Sedangkan untuk --squash sama namun setiap commit yang berbeda akan dijadikan menjadi 1 commit pada branch utama.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
Dalam mengembangkan aplikasi, dibutuhkan version control seperti git agar dapat mengontrol perubahan yang ada. Apabila terjadi kesalahan dalam mengerjakan kode yang sudah terlalu jauh, kita dapat melakukan revert terhadap kode kita. Dalam berkolaborasi, version control juga sangat berguna agar kode yang dibuat dapat digabungkan secara rapih.

### Spring
4. Apa itu library & dependency?
Library merupakan sekelompok fungsi yang dikelompokan menjadi satu untuk dapat dipanggil dan digunakan secara mudah. Dependency merupakan sebuah kebutuhan atas sebuah library atau kode untuk sebuah kode yang kita buat yang harus ada agar dapat berjalan secara lengkap.

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?


6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Maven merupakan Java Build Tools yang digunakan untuk pembuatan modul, dependency injection, core container, data access, pengembangan website, dan lain-lainnya.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
Pada @RequestParam kita menggunakan parameter sebagai data yang dibutuhkan suatu fungsi, seadangkan untuk @PathVariable urlnya yang akan digunakan.

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [x] Kenapa saya harus belajar APAP?
Karena APAP merupakan mata kuliah yang wajib dan juga sangat menarik. Kenapa menarik? karena APAP merupakan salah satu dari matkul SI yang ngoding dan saya cukup gemar dalam ngoding walau tidak sesenang itu.
- [x] Kenapa kita sebaiknya menggunakan Intelij atau IDE lainnya dalam mengembangkan aplikasi springboot?
Dalam penggunaannya, IDE dapat membantu kita dalam mengembangkan aplikasi. Terdapat fitur autocomplete, debugging, refactoring, dan lain-lainnya.

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu
lebih dalam tentang penulisan README.md di GitHub pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))