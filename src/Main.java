public class Main {
    public static void main(String[] args) {
        try {
            // Creo una data valida
            Data d1 = new Data(5, 10, 2025);
            System.out.println("Data 1: " + d1.getData());

            // Creo un'altra data valida
            Data d2 = new Data(10, 10, 2025);
            System.out.println("Data 2: " + d2.getData());

            // Calcolo la differenza in giorni
            long giorni = d1.CalcoloDifferenzaGiorni(d2);
            System.out.println("Differenza in giorni: " + giorni);

            // Provo a creare una data sbagliata
            Data d3 = new Data(32, 13, 2025);

        } catch (DataNonValidaException e) {
            System.out.println(e.getMessage());
        }
    }
}