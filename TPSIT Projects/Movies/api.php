<?php
    require_once("db.php");
    
    if($_SERVER["REQUEST_METHOD"] == "GET"){
        if($_SERVER["PATH_INFO"] == "/movies"){
            http_response_code(200);
            header("Content-Type: application/json");
            $movieTitle = $_GET["title"];
            
            echo json_encode([
                "status" => 200,
                "message" => "",
                "payload" => $
            ])
        }

    }else{
        http_response_code(405)
        header("Content-Type: application/json");
        echo json_encode([
            "status" => 405,
            "message" => "Method not allowed",
            "payload" => []
        ]);
    }
?>