<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php 
        for($i=0; $i<10; $i++){
            $number[$i] = rand(10, 100);
        }

        for($i=0; $i<10; $i++){
            echo " $number[$i]";
        }
        echo "<br/>";
        for($i=0; $i<10; $i++){
            $numbers_reversed = array_reverse($number);
            echo " $numbers_reversed[$i]";
        }
    ?>
</body>
</html>


