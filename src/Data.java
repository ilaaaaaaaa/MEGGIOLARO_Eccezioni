import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.temporal.ChronoUnit;

public class Data {
    private int giorno;
    private int mese;
    private int anno;

    // Costruttore senza parametri
    public Data(){
        this.giorno = 1;
        this.mese = 1;
        this.anno = 2000;
    }

    // Costruttore con parametri
    public Data(int giorno, int mese, int anno) throws DataNonValidaException {
        try {
            // Provo a creare la data
            LocalDate data = LocalDate.of(anno, mese, giorno);
            this.giorno = giorno;
            this.mese = mese;
            this.anno = anno;
        } catch (DateTimeException e) {
            // Nel caso in cui non sia valida, lancio l'eccezione personalizzata
            throw new DataNonValidaException("Data non valida: " + e.getMessage());
        }
    }

    public void setData(int g, int m, int a) throws DataNonValidaException {
        try {
            // Provo a creare la data
            // L'oggetto LocalDate crea una data senza l'ora
            LocalDate data = LocalDate.of(a, m, g);
            this.giorno = g;
            this.mese = m;
            this.anno = a;
        } catch (DateTimeException e) {
            // Nel caso in cui non sia valida, lancio l'eccezione personalizzata
            throw new DataNonValidaException("Data non valida: " + e.getMessage());
        }
    }

    public String getData(){
        String g = "";
        String m = "";

        // Se il giorno ha solo una cifra
        if(giorno < 10){
            g = "0" + giorno; // aggiungo uno 0 davanti
        }else{
            g = "" + giorno;
        }

        // Se il mese ha solo una cifra
        if(mese < 10){
            m = "0" + mese; // aggiungo uno 0 davanti
        }else{
            m = "" + mese;
        }

        /* Si poteva usare anche:
         *  return String.format("%02d/%02d/%04d", giorno, mese, anno);
         *  in cui con:
         *  - %02d → intero su due cifre, con zeri davanti se serve
         *  - %04d → intero su quattro cifre (per l’anno)
        */
        return g + "/" + m + "/" + anno;
    }

    public long CalcoloDifferenzaGiorni(Data altraData) {
        LocalDate d1 = LocalDate.of(this.anno, this.mese, this.giorno);
        LocalDate d2 = LocalDate.of(altraData.anno, altraData.mese, altraData.giorno);

        /* ChronoUnit è un enumerazione della libreria java.time.temporal
        *  con .DAYS si specifica l'unità di misura in cui si vuole calcolare la differenza tra le due date
        */
        return ChronoUnit.DAYS.between(d1, d2);
    }
}
