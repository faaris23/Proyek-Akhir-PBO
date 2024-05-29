CREATE DATABASE rpg_game;

USE rpg_game;

CREATE TABLE akun_db (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    has_character BOOLEAN DEFAULT 0
);

CREATE TABLE karakter_db (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    job VARCHAR(50),
    hp INT,
    def INT,
    atk INT,
    gold INT,
    FOREIGN KEY (account_id) REFERENCES akun_db(id)
);
