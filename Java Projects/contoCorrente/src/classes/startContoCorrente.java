package classes;
class startContoCorrente {

    float saldoCorrente = 0.0f;
    float inpSaldo = 0.0f;
    final Float FIDO = 3000.0f;

    Correntista cc = new Correntista();

    public float Versamento(float inpSaldo) {
        saldoCorrente += inpSaldo;
        return inpSaldo;
    }

    public float visualizzaSaldo() {
        return saldoCorrente;
    }

    public float Preleva(float inpSaldo) throws Exception {
        if (saldoCorrente - FIDO >= inpSaldo) {
            saldoCorrente -= inpSaldo;
            return inpSaldo;

        } else
            throw new Exception();
    }
}



