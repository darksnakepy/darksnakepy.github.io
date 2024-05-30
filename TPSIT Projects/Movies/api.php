<?php
    require_once("db.php");
    
    if($_SERVER["REQUEST_METHOD"] == "GET"){
        if($_SERVER["PATH_INFO"] == "/movies"){
            http_response_code(200);
            header("Content-Type: application/json");
            $result = getAllMovies();            
            echo json_encode([
                "status" => 200,
                "message" => "",
                "payload" => $result
            ]);
        }

        else if($_SERVER["PATH_INFO"] == "/actors"){
            http_response_code(200);
            header("Content-Type: application/json");
            $actor = $_GET["actor"];    
            $result = getActor($actor);            
            echo json_encode([
                "status" => 200,
                "message" => "",
                "payload" => $result
            ]);
        }

        else if($_SERVER["PATH_INFO"] == "/getmovie"){
            $movie = $_GET["movie"];
            http_response_code(200);
            header("Content-Type: application/json");
            $result = getAMovie($movie); 
            echo json_encode([
                "status" => 200,
                "message" => "",
                "payload" => $result
            ]);
        }

        else if($_SERVER["PATH_INFO"] == "/getgenres"){
            http_response_code(200); 
            header("Content-Type: application/json");
            $result = getGenre("Action"); 
            echo json_encode([
                "status" => 200,
                "message" => "",
                "payload" => $result
            ]);
        }


    }
        
?>