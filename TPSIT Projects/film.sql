CREATE DATABASE movies;

CREATE TABLE GENERE (
    nome VARCHAR(50),
    id INT AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE FILM (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titolo VARCHAR(50),
    descrizione VARCHAR(50),
    annoRilascio int(4)
);

CREATE TABLE PERSONA (
    categoria ENUM('attore', 'regista'),
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    secondoNome VARCHAR(50) DEFAULT NULL,
    cognome VARCHAR(50),
    dataNascita DATE
);

CREATE TABLE INTERPRETA (
    attore INT,
    film INT,
    PRIMARY KEY (attore, film),
    FOREIGN KEY (film) REFERENCES FILM(id),
    FOREIGN KEY (attore) REFERENCES PERSONA(id)
);

CREATE TABLE DIRIGE (
    regista INT,
    film INT,
    PRIMARY KEY (regista, film),
    FOREIGN KEY (film), REFERENCES FILM(id),
    REFERENCES (regista), REFERENCES PERSONA(id)
);

CREATE TABLE REGISTA (
    regista INT,
    film INT,
    PRIMARY KEY (regista, film),
    FOREIGN KEY (film) REFERENCES FILM(id),
    FOREIGN KEY (regista) REFERENCES PERSONA(id)
);

CREATE TABLE GENERI (
    genere INT,
    film INT,
    PRIMARY KEY (genere, film),
    FOREIGN KEY (film) REFERENCES FILM(id),
    FOREIGN KEY (genere) REFERENCES GENERE(id)
);

