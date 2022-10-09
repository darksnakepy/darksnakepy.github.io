package classes;

public class startContoCorrente {

    float saldoCorrente = 0.0f;
    float inpSaldo = 0.0f;
    float prelievo;


    public float Versamento(float inpSaldo) {
        saldoCorrente += inpSaldo;
        return inpSaldo;
    }

    public float visualizzaSaldo() {
        return saldoCorrente;
    }

    public float Preleva(float inpSaldo){
        saldoCorrente -= inpSaldo;
        return inpSaldo;
    }
}


