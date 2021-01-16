----- SOKOBAN -----

Jenis : Game

Sokoban adalah sebuah puzzle game dimana player mendorong kotak atau peti menuju ke lokasi tujuannya. Sokoban dibuat pertama kali pada tahun 1981 oleh Hiroyuki Imabayashi dan untuk game komersialnya dipublikasikan pada Desember 1982 oleh Thinking Rabbit.

Kelas Diagram :



Kelas-Kelas yang digunakan :

1. Actor.java

merupakan kelas induk untuk beberapa kelas lain, yaitu Player.java, Baggage.java, Area.java, dan Wall.java. 
pada kelas ini terdapat beberapa variable:

SPACE adalah variable final yang bertipe data integer, menunjukkan ukuran panel dari object-object dari kelas Actor. 
x dan y adalah variable bertipe integer dan berfungsi untuk menyimpan koordinat posisi dari setiap objek kelas Actor. 
image dari kelas Image berfungsi untuk menyimpan image yang akan digunakan oleh objek.

pada kelas Actor juga terdapat beberapa method:

terdapat getter dan setter untuk masing-masing variable. 
terdapat juga method boolean untuk menentukan apakah suatu objek dengan objek yang lain terjadi collision.

2. Player.java

merupakan anak kelas dari Actor. 
memiliki sebuah method move() dimana memungkinkan objek Player dapat bergerak. 
Player inilah yang akan digerakkan oleh User. 

3. Baggage.java

merupakan anak kelas dari Actor. 
memiliki sebuah method move() dimana memungkinkan objek Baggage dapat bergerak.
Baggage dapat digerakkan dengan collision. Jika terjadi collision antara Player dan Baggage maka selama tidak ada objek lain yang terjadi collision dengan Baggage tersebut, Baggage akan bergerak sesuai dengan pergerakan Player.

4. Area.java

Area merupakan anak kelas dari Actor. 
objek dari kelas ini berperan sebagai titik tujuan dalam menggerakkan Baggage. Untuk menyelesaikan permainan Player harus bisa meletakkan seluruh Baggage ke dalam Area.

5. Wall.java

Wall merupakan anak kelas dari Actor. 
Wall berperan sebagai pembatas world dan pembentuk tingkat kesulitan dalam permainan.

6. Board.java

merupakan papan utama tempat semua objek Actor diletakkan. 
Terdapat beberapa variable yang digunakan di kelas ini :
        1. OFFSET berfungsi untuk menentukan batas dari Frame dan Board.
        2. SPACE berfungsi untuk menunjukkan besar Panel dari masing-masing objek Actor.
        3. LEFT_COLLISION, RIGHT_COLLISION, TOP_COLLISION, dan BOTTOM_COLLISION berfungsi untuk menentukan dimanakah Collision terjadi apakah di atas, bawah, kanan, atau kiri.
        4. cols rows berfungsi untuk menentukan banyaknya kolom dan baris dari array map.
        5. pCol dan pRow merupakan koordinat awal dari objek Player.
        6. map[][] adalah map level yang akan digunakan.
        7. ArrayList<> untuk masing-masing objek Wall, Baggage, dan Area digunakan untuk menyimpan objek-objek dari Kelas tersebut.
        8. p adalah variable untuk menunjukkan Player.
        9. isCompleted untuk menentukan apakah level terselesaikan.

Untuk method terdapat 
        1. constructor, 
        2. loadMap(String str) untuk me-load level yang akan digunakan, 
        3. initBoard() untuk menginisialisasikan Board, 
        4. getBoardWdth() dan getBoardHeight() untuk mendapatkan lebar dan tinggi Board, 
        5. initWorld() untuk menginisialisasikan World yang akan digunakan, 
        6. buildWorld(Graphics g) untuk merender asset yang digunakan, 
        7. sebuah Kelas TAdapter sebagai manajemen KeyEvent, 
        8. checkWallCollision(Actor, int) untuk mengecek collision dengan Wall, 
        9. checkBagColision(int) untuk mengecek collision dengan Baggage, 
        10. isCompleted() untuk mengecek apakah level sudah selesai, dan 
        11. restartLevel() untuk memulai ulang level yang sama.

7. MainMenu.java

merupakan kelas yang berfungsi untuk menampilkan menu utama sebelum memulai permainan. 
terdapat beberapa Button yakni Play dan Exit, kemudian juga terdapat ComboBox yang berisi list Level yang tersedia.

8. Sokoban.java

merupakan kelas yang memiliki fungsi main() dimana ketika di-run fungsi tersebut akan memanggil constructor MainMenu().
selain itu kelas ini juga yang menyediakan Frame untuk game ini.

Fitur Utama dalam Game SOKOBAN ini adalah memiliki 30 level dengan tingkat kesulitan yang semakin bertambah yang dapat dimainkan.

Referensi:
https://zetcode.com/javagames/sokoban/

dari referensi tersebut kami menambahkan kemampuan untuk meload level yang berasal dari file .txt dan juga menambahkan main menu

