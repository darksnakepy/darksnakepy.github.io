<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        for($i = 0; $i < 5; $i++){
            $array[$i] = rand(10, 100);
            $second_array[$i] = $array[$i]; 
        }
        echo "First array: <br/>";
        for($i = 0; $i < 5; $i++){
            echo  "$array[$i] <br/>";    
        }
        echo "Second array: <br/>";
        for($i = 0; $i < 5; $i++){
            echo "$second_array[$i] <br/>";    
        }
    ?>    
</body>
</html>
