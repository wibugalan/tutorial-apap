# Tutorial APAP
## Authors
* **Muhammad Marsha Prawira** - *1906353864* - *C*
## Tutorial 8
### What I have learned today
Saya belajar mengintegrasikan react dengan springboot
### Pertanyaan
1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?
Saya memberikan kode this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            }) yang akan mengosongkan nilai-nilai tersebut setelah fungsi dijalankan.
2. Jelaskan fungsi dari async dan await!
= async menandakan bahwa fungsi tersebut bersifat asinkronus dan tidak perlu loading. Await merupakan penanda bahwa javascript akan memberikan jeda sampai hasil diberikan pada fungsi async.
3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle pada pertanyaan ini.
![Screenshot (2376)](https://user-images.githubusercontent.com/75771815/144437568-0f7a736d-4426-4a35-b594-d9a578178440.png)
![Screenshot (2377)](https://user-images.githubusercontent.com/75771815/144437590-39b7a5ac-51e6-4a22-95d9-5772465d090f.png)
![Screenshot (2378)](https://user-images.githubusercontent.com/75771815/144437598-19efef14-1dc3-42c6-9160-6731e7861f43.png)

![Screenshot (2379)](https://user-images.githubusercontent.com/75771815/144437602-be9139dc-566f-4196-9c48-c5476ea804a7.png)
![Screenshot (2380)](https://user-images.githubusercontent.com/75771815/144437609-710c44bc-a46d-4186-9f40-831044ba26b7.png)
![Screenshot (2381)](https://user-images.githubusercontent.com/75771815/144437617-dfe51a80-d366-4289-a448-506aace8f6f5.png)
![Screenshot (2382)](https://user-images.githubusercontent.com/75771815/144437621-589dc66c-32a6-4474-a570-c393a442b826.png)

![Screenshot (2383)](https://user-images.githubusercontent.com/75771815/144437637-a70a47fe-273f-45c3-98a8-343d06858887.png)
![Screenshot (2384)](https://user-images.githubusercontent.com/75771815/144437645-ded1f99d-7c23-485c-8c06-23e8d8812e5c.png)
![Screenshot (2385)](https://user-images.githubusercontent.com/75771815/144437653-5b56a42b-f6b3-464f-8267-df386ff4a5ea.png)


4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount. 

componentDidMount = Fungsi yang akan dijalankan saat website akan dirender, usecase yang biasa digunakan adalah saat setelah endpoint get dipanggil sebelum dirender.

shouldComponentUpdate = fungsi yang mengeluarkan boolean untuk menentukan apakah rendering pada komponen akan berjalan atau tidak, use casenya adalah saat ingin mengetahui perubahan porps/state dari komponen terkait 

componentDidUpdate = fungsi yang dipanggil setelah component dirender, use casenya adalah saat ingin melakukan perubahan dari sisi user seperti pengisian text atau klik button

componentWillReceiveProps = fungsi yang dipanggil sebelum komponen menerima nilai props baru. use casenya adalah saat ingin mengubah isi komponen 

componentWillUnmount = fungsi yang dipanggil ketika komponen akan dihapus, use case yang digunakan biasanya adalah saat penghapusan salah satu bagian komponen
### What I did not understand
---
## Tutorial 7
### What I have learned today
Saya belajar menggunakan react dengan functional serta class based.
### Pertanyaan
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
= 
Latihan pertama:
Pada latihan pertama saya mengerjakan penghapusan item dari cart dengan menggunakan cara yang cukup mirip dengan menambahkan item ke cart. Pertama saya membuat class handleDeleteItemFromCart ![handleDeleteItemFromCart](https://user-images.githubusercontent.com/75771815/143243058-9273fa06-d50a-4ec4-8668-86c03a74199a.jpg) yang akan mengubah inCart dari sebuah item menjadi false (balik ke list item) dan mengeluarkannya dari cartItems APABILA targetInd atau index pada cartItems 0 atau lebih besar (item ada pada cartItems). Setelah itu, isi property onItemClick dengan this.handleDeleteItemFromCart ![onItemClick](https://user-images.githubusercontent.com/75771815/143243844-eafe4baf-33db-4f00-87a2-64ac5d7ddf21.jpg)

Latihan kedua:
Pada latihan kedua, saya perlu untuk memodifikasi fungsi tambah dan hapus item dari cart. Pada fungsi tambah ![tambah](https://user-images.githubusercontent.com/75771815/143244580-60fe647d-b44e-4eca-b32b-0fd8aeee1312.jpg)
saya menambahkan baris yang dicentang. Baris yang dicentang pertama akan mengkalkulasi balance setelah dikurangi item yang dimasukan ke cart. Baris centang kedua akan mengeset state dari balance menjadi hasil kalkulasi tersebut.
Pada fungsi kurang, saya juga menambahkan 2 baris ![kurang](https://user-images.githubusercontent.com/75771815/143245076-52a4acb6-7902-412c-98e8-45c573c29804.jpg)
Baris pertama akan mengkalkulasikan balance setelah ditambah item yang dihapus dari cart. Baris centang kedua akan mengeset state dari balance menjadi hasil kalkulasi tersebut.

Latihan ketiga:
Pada latihan ketiga saya memodifikasi method tambah dengan menambahkan kode yang saya tandai ![latihan 3](https://user-images.githubusercontent.com/75771815/143245561-1082b60b-cc9f-4dd4-a9c8-9d1af6e2cc47.jpg)
blok kode tersebut akan mengecek apakah balance setelah dikurangi item yang akan dipindahkan menjadi kurang dari 0. Apabila kurang dari 0, maka akan mengeluarkan alert.

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
= State adalah data yang dimiliki oleh suatu class atau function, sedangkan props adalah data yang dipassing antar fungsi/class menuju fungsi/class lainnya.
3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
= Iya. Karena react mendukung code splitting. Kita dapat menggunakan paradigma membangun suatu aplikasi dari komponen-komponen yang kecil. Sehingga apabila terdapat perubahan pada salah satu komponen, kita tidak perlu mengubah secara keseluruhan.
4. Apa perbedaan class component dan functional component?
= Class adalah paradigma dengan menggunakan OOP dan merupakan metode lama yang digunakan di react. Sedangkan di update react 16.8 dikenalkan functional component untuk meminimalisir this.state yang berlebih dengan menggunakan react hook.
5. Dalam react, apakah perbedaan component dan element?
= React elemen adalah objek yang merepresentasikan DOM yang terdiri dari element-element HTML seperti button, div, dan lain-lain. Sedangkan Component adalah kumpulan dari element yang akan membentuk aplikasi kita. Saat menamakan component itu harus selalu diawali dengan kapital, sedangkan element tidak kapital.
### What I did not understand
---
## Tutorial 6
### What I have learned today
Saya belajar penggunaan login dan keamanan lainnya pada springboot.
### Pertanyaan
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
= 
- Otentikasi adalah sebuah mekanisme untuk mengidentifikasikan input pada form login menghasilkan pengguna yang tepat. konsep ini di implementasikan di websecurityconfig yang ada di package security.
- Otorisasi adalah sebuah mekanisme yang menentukan apakah pengguna memiliki akses terhadap suatu fitur atau tidak. contoh konsep ini pada tutorial ada pada akses user yang hanya bisa oleh ADMIN atau ubah pegawai dengan MANAGER.
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
= BCryptPasswordEncoder merupakan password encoder yang kita gunakan pada tutorial kali ini untuk decoding dan encoding password. Sistem ini menggunakan cara pembuatan objek BCryptPasswordEncoder yang dapat digunakan method encode atau decode untuk memproses password.
3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
= Hashing. apabila menggunakan enkripsi, mekanisme tersebut membutuhkan key untuk memprosesnya. Apabila key tersebut tercuri, maka pencurian data sangat mudah dilakukan.
4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
= UUID atau universally unique identifier merupakan karakter identifikasi yang digunakan untuk mengidentifikasi informasi. Penggunaan UUID adalah untuk menjaga keamanan karena karakter UUID ini unik untuk mengakses sebuah informasi.
5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java
= UserDetail digunakan untuk mengatur mekanisme otentikasi pengguna.Hal tersebut karena class ini extend dari spring security.
### What I did not understand
Postmapping pada login diatur di mana ya? karena form menggunakan method POST sedangkan pada controller tidak ada Postmapping.
---
---
## Tutorial 5
### What I have learned today
Saya belajar penggunaan API dan bagaimana mengeceknya melalui POSTMAN
### Pertanyaan
1. Apa itu Postman? Apa kegunaannya?
= Postman dapat digunakan untuk menguji atau testing endpoint (API). Postman juga memberikan kemudahan lain seperti penyimpanan endpoint pada collection, environment yang diubah-ubah, dan lain-lainnya.
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
= 
@JsonIgnoreProperties digunakan untuk mengabaikan pemrosesan properti JSON yang dibaca saat deserialisasi atau serialisasi JSON.
@JsonProperty digunakan untuk memetakan property dengan JSON saat deserialisasi atau serialisasi JSON. By default, if you try to 
3. Apa kegunaan atribut WebClient?
= WebClient memberikan cara untuk melakukan pengiriman atau penerimaan data dari lokal, intranet, atau Internet yang teridentifikasi oleh URL yang diberikan.
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
= 
ResponseEntity berguna untuk memberikan response HTTP dari sebuah panggilan fungsi.
BindingResult berguna untuk memberikan informasi mengenai kesalahan dalam melakukan pemanggilan fungsi.
### What I did not understand
saya sedikit kebingungan dalam konsep webclient.
---
=======
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