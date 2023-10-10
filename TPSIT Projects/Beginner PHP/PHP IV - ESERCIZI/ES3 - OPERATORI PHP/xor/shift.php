<?php

 $firstNumber = $_POST["number1"];
 $secondNumber= $_POST["number2"];
 $operation = $_POST["operation"];

 switch($operation){
     case "and":
         echo decbin((int)($firstNumber & $secondNumber));
         break;
     case "or":
         echo decbin((int)($firstNumber | $secondNumber));
         break;
     case "xor":
         echo decbin((int)($firstNumber ^ $secondNumber));
         break;
     default:
         echo "error";
 }
 ?>

