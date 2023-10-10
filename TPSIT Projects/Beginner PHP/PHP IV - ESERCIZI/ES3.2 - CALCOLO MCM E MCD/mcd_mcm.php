<?php

    function mcd($firstNumber, $secondNumber){
        while($secondNumber != 0){
            $i = $secondNumber;
            $secondNumber = $firstNumber % $secondNumber;
            $firstNumber = $i;
        }
        return $firstNumber;
    }

    function mcm($firstNumber, $secondNumber) {
        return ($firstNumber * $secondNumber) / mcd($firstNumber,$secondNumber);
    }

    $firstNumber = $_POST["firstNumber"];
    $secondNumber = $_POST  ["secondNumber"];

    echo "m.c.m = ", mcm($firstNumber, $secondNumber), "<br />";
    echo "M.C.D = ", mcd($firstNumber, $secondNumber);


?>