<?php
    function getAllMovies(){
        
        global $connection;

        $query = "
            SELECT 
                FILM.titolo, FILM.annoRilascio, CONCAT(PERSONA.nome, ' ', PERSONA.cognome) as director, GENERE.nome as genre, CONCAT(PERSONA_ATTORE.nome, ' ', PERSONA_ATTORE.cognome) as actor, FILM.descrizione
            FROM 
                FILM
            JOIN 
                REGISTA ON FILM.id = REGISTA.film
            JOIN 
                PERSONA ON REGISTA.regista = PERSONA.id
            JOIN 
                GENERI ON FILM.id = GENERI.film
            JOIN 
                GENERE ON GENERI.genere = GENERE.id
            JOIN 
                INTERPRETA ON FILM.id = INTERPRETA.film
            JOIN 
                PERSONA AS PERSONA_ATTORE ON INTERPRETA.attore = PERSONA_ATTORE.id
        ";

        $result = $connection->query($query);
        $movies = [];

        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                $movies[] = $row;
            }
        }

        return $movies;
    }


    function getAMovie($title){
        global $connection;

        $query = "
            SELECT 
                FILM.titolo, FILM.annoRilascio, CONCAT(PERSONA.nome, ' ', PERSONA.cognome) as director, GENERE.nome as genre, CONCAT(PERSONA_ATTORE.nome, ' ', PERSONA_ATTORE.cognome) as actor, FILM.descrizione
            FROM 
                FILM
            JOIN 
                REGISTA ON FILM.id = REGISTA.film
            JOIN 
                PERSONA ON REGISTA.regista = PERSONA.id
            JOIN 
                GENERI ON FILM.id = GENERI.film
            JOIN 
                GENERE ON GENERI.genere = GENERE.id
            JOIN 
                INTERPRETA ON FILM.id = INTERPRETA.film
            JOIN 
                PERSONA AS PERSONA_ATTORE ON INTERPRETA.attore = PERSONA_ATTORE.id 
            WHERE FILM.titolo = '$title'
        ";

        $result = $connection->query($query);
        $movies = [];

        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                $movies[] = $row;
            }
        }
        return $movies;
    }

    function getActor($name){
        global $connection;
        
        $query = "
            SELECT 
                FILM.titolo AS movie_title,
                FILM.annoRilascio AS release_year,
                PERSONA.categoria AS category
            FROM 
                PERSONA
            JOIN 
                INTERPRETA ON PERSONA.id = INTERPRETA.attore
            JOIN 
                FILM ON INTERPRETA.film = FILM.id
            WHERE 
                CONCAT(PERSONA.nome, ' ', PERSONA.cognome) = '$name'
        ";
    
        $result = $connection->query($query);
        $actor = [];
    
        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                $actor[] = $row;
            }
        }
        return $actor;
    }

    function getGenre($genre){
        $query = "
            SELECT GENERE.nome as genre, FILM.titolo as title, FILM.descrizione as description
            FROM
                FILM
            JOIN 
                GENERI as g ON FILM.id = g.film 
            JOIN 
                GENERE as g ON g.genere = GENERE.id 
            WHERE 
                GENERE.nome = '$genre'        
        ";

        $result = $connection->query($query);
        $genres = [];
    
        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                $genres[] = $row;
            }
        }
        return $genres;
    }

    $localhost = "127.0.0.1";
    $connection = mysqli_connect($localhost, "root", "", "movies");

    if ($connection->connect_error) {
        echo "Error" . $connection->connect_error;
    }
?>