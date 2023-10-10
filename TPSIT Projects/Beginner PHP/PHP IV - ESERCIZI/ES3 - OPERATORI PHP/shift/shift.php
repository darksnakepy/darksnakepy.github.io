<?php
 $number = $_POST["number"];
 $operation = $_POST["operation"];


 switch($operation){
     case "shift_right":
         $result = $number >> 1;
         break;
     case "shift_left":
         $result = $number << 1;
         break;
     case "bit_not":
         $result = ~$number;
         break;
     default:
         echo "error";
 }

 echo decbin($result);
echo "<div> $result </div>";
 ?>

