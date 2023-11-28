<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        for($i=0;$i<20;$i++){
            $numbers[$i] = rand(1,100);
            if($numbers[$i]%2==0){
                $even[]=$numbers[$i];
            }else{
                $odd[] = $numbers[$i];
            }
        }

        for($i=0;$i<count($even);$i++){
            echo "Numeri pari: $even[$i] <br />"; 
        }
        echo "<br />";
        for($i=0;$i<count($odd);$i++){
            echo "Numeri dispari: $odd[$i] <br />"; 
        }
        echo "<br />";
        for($i=0;$i<count($numbers);$i++){
            echo "$numbers[$i] "; 
        }
    ?>    
</body>
</html>
