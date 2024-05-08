<?php
    function getAllMovies(){
        
        global $connection;

        $query = "
            SELECT 
                FILM.titolo, FILM.annoRilascio, CONCAT(PERSONA.nome, ' ', PERSONA.cognome) as director, GENERE.nome as genre, CONCAT(PERSONA_ATTORE.nome, ' ', PERSONA_ATTORE.cognome) as actor, FILM.descrizione
            FROM 
                FILM
            INNER JOIN 
                REGISTA ON FILM.id = REGISTA.film
            INNER JOIN 
                PERSONA ON REGISTA.regista = PERSONA.id
            INNER JOIN 
                GENERI ON FILM.id = GENERI.film
            INNER JOIN 
                GENERE ON GENERI.genere = GENERE.id
            INNER JOIN 
                INTERPRETA ON FILM.id = INTERPRETA.film
            INNER JOIN 
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
            INNER JOIN 
                REGISTA ON FILM.id = REGISTA.film
            INNER JOIN 
                PERSONA ON REGISTA.regista = PERSONA.id
            INNER JOIN 
                GENERI ON FILM.id = GENERI.film
            INNER JOIN 
                GENERE ON GENERI.genere = GENERE.id
            INNER JOIN 
                INTERPRETA ON FILM.id = INTERPRETA.film
            INNER JOIN 
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
            INNER JOIN 
                INTERPRETA ON PERSONA.id = INTERPRETA.attore
            INNER JOIN 
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

    $localhost = "127.0.0.1";
    $connection = mysqli_connect($localhost, "root", "", "movies");

    if ($connection->connect_error) {
        echo "Error" . $connection->connect_error;
    }
?>