# Tutorial APAP
## Authors
* **Muhammad Marsha Prawira** - *1906353864* - *C*
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