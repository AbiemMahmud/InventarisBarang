CREATE TABLE user
(
  id_user VARCHAR(32) NOT NULL,
  password VARCHAR(32) NOT NULL,
  posisi VARCHAR(16),
  PRIMARY KEY (id_user)
);

CREATE TABLE kategori
(
  id_kategori VARCHAR(10) NOT NULL,
  nama_kategori VARCHAR(16) NOT NULL,
  PRIMARY KEY (id_kategori)
);

CREATE TABLE barang
(
  id_barang VARCHAR(10) NOT NULL,
  jumlah_barang INT NOT NULL,
  harga_barang INT NOT NULL,
  nama_barang VARCHAR(32) NOT NULL,
  id_kategori VARCHAR(10),
  PRIMARY KEY (id_barang),
  FOREIGN KEY (id_kategori) REFERENCES kategori(id_kategori)
);

CREATE TABLE kelola
(
  kurang INT NOT NULL,
  tambah INT NOT NULL,
  tanggal DATE NOT NULL,
  id_user VARCHAR(32) NOT NULL,
  id_barang VARCHAR(10) NOT NULL,
  PRIMARY KEY (id_user, id_barang),
  FOREIGN KEY (id_user) REFERENCES user(id_user),
  FOREIGN KEY (id_barang) REFERENCES barang(id_barang)
);
