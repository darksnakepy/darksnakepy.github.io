<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

</head>
<body>
    <?php
        $inputNumber = 10; //$_GET["input"];
        $counter = 0;

        for($i = 0; $i < 20; $i++){
            $number[$i] = rand(10, 100);
            echo "<br>$number[$i] ";
        }

        for($i = 0; $i < count($number); $i++){
            if($number[$i] == $inputNumber){
                $counter++;
            }
        }
        echo "The number $inputNumber has been found $counter times";
    ?>
</body>
</html>