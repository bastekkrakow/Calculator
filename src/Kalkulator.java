import java.util.Arrays;
import java.util.Scanner;
// Program Kalkulator naukowy, napisany przez: Sebastian Płonka.
public class Kalkulator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final String USER_ID = "Ania";
        final String PASS = "Sekret";
        int opcja = 0;
        boolean zalogowany = false;

        System.out.println("Witam w programie kalkulator.\nProszę podać login oraz hasło: \n");

        do {

            System.out.println("Wpisz login: ");

            String login = sc.nextLine();
            System.out.println("Wpisz hasło: ");

            String haslo = sc.nextLine();

            if (USER_ID.equals(login) && PASS.equals(haslo)) zalogowany = true;
            else System.out.println("Hasło dane logowania niepoprawne, próbuj dalej...");
        } while (zalogowany != true);
        System.out.println("\nBrawo! Dane logowania poprawne. Witamy w programie Kalkulator v1.0\n");
        do {
            System.out.println("\nWybierz opcję: \n");
            System.out.println("1) Dodawanie N elementów do siebie");
            System.out.println("2) Odejmowanie N elementów do siebie");
            System.out.println("3) Mnożenie N elementów do siebie");
            System.out.println("4) Dzielenie N elementów do siebie");
            System.out.println("5) Pierwiastek dowolnego stopnia ");
            System.out.println("6) Potęga dowolnego stopnia, pozwalająca podawać ułamki jako wykładnik");
            System.out.println("7) Zamiana liczby podanej w systemie dziesiętnym na systemy dwójkowy, ósemkowy, szestanstkowy");
            System.out.println("8) Obliczanie mediany i średniej z podanego zbioru liczb");
            System.out.println("9) Wyjście z progamu");


            opcja = sc.nextInt();

            switch (opcja) {
                case 1:
                    System.out.println("Opcja nr 1. Dodawanie");
                    double[] doubles = getNumbers();
                    double dodane = doubles[0];
                    for (int i = 1; i < doubles.length; i++) {
                        dodane += doubles[i];
                    }
                    System.out.println("Wynik to: " + dodane);
                    break;
                case 2:
                    System.out.println("Opcja nr 2. Odejmowanie");
                    double[] doubles2 = getNumbers();
                    double odejmij=doubles2[0];
                    for (int i = 1; i < doubles2.length; i++) {
                        odejmij -= doubles2[i];
                    }
                    System.out.println("Wynik to: " + odejmij);

                    break;
                case 3:
                    System.out.println("Opcja nr 3. Mnożenie");
                    double[] doubles3 = getNumbers();
                    double pomnoz=doubles3[0];
                    for (int i = 1; i < doubles3.length; i++) {
                        pomnoz *= doubles3[i];
                    }
                    System.out.println("Wynik to: " + pomnoz);
                    break;
                case 4:
                    System.out.println("Opcja nr 4. Dzielenie");
                    double[] doubles4 = getNumbers();
                    double podziel=doubles4[0];
                    for (int i = 1; i < doubles4.length; i++) {
                        podziel /= doubles4[i];
                    }
                    /* brak obsługi dzielenia przez zero, gdyż po napisaniu pętli i warunku sprawdzającego nie można przetestować jej działania,
                     gdyż java sama podaje w takim przypadku wynik dzielenia przez zero jako "Infinity" */
                    System.out.println("Wynik to: " + podziel);
                    break;
                case 5:
                    System.out.println("Opcja nr 5. Pierwiastek");
                    Scanner sd = new Scanner(System.in);
                    System.out.println("Podaj liczbę do pierwiastka" );
                    double pierw1=sd.nextDouble();
                    System.out.println("Podaj stopień" );
                    double pierw2=sd.nextDouble();
                    if (pierw1>0) {System.out.println("Wynik to: " + Math.pow(pierw1, 1.0/pierw2));}
                    else if (pierw1<0){System.out.println("Wynik to: " + -Math.pow(Math.abs(pierw1),1.0/pierw2));
                    }
                    break;
                case 6:
                    System.out.println("Opcja nr 6. Potęga. ");
                    Scanner se = new Scanner(System.in);
                    System.out.println("Podaj podstawe potegi" );
                    double pot1=se.nextDouble();
                    System.out.println("Podaj wykladnik potegi (ułamki z przecinkiem)" );
                    double pot2=se.nextDouble();
                    double potega=1.0;
                    if(pot2>=0){
                        for(double i=pot2;i>0;i--)
                            potega=potega*pot1;
                    }
                    else if(pot2<0){
                        for(double i=pot2;i<0;i++)
                            potega=potega*pot1;
                        potega=1/potega;
                    }
                    System.out.println(pot1+" do potegi "+pot2+" wynosi "+potega);
                    break;
                case 7:
                    System.out.println("Opcja nr 5. Zamiana na system dwójkowy, ósemkowy, szesnastkowy");
                    Scanner sf = new Scanner(System.in);
                    System.out.println("Podaj liczbę do zamiany: " );
                    int liczbaKonwertowana=sf.nextInt();
                    System.out.println("Liczba " + liczbaKonwertowana +" w systemie dwójkowym to: " + Integer.toString(liczbaKonwertowana,2)); // decimal to octal
                    System.out.println("Liczba " + liczbaKonwertowana +" w systemie ósemkowym to: " + Integer.toString(liczbaKonwertowana,8));
                    System.out.println("Liczba " + liczbaKonwertowana +" w systemie szesnastkowym to: " + Integer.toString(liczbaKonwertowana,16));
                    break;
                case 8:
                    System.out.println("Obliczanie mediany i średniej");
                    double[] srednia = getNumbers();
                    double sredniaCiagu=0;
                    for (int i = 0; i < srednia.length; i++) {
                        sredniaCiagu = sredniaCiagu + srednia[i];
                    }
                    Arrays.sort(srednia);
                    double mediana;
                    if (srednia.length % 2 == 0)
                        mediana = ((double)srednia[srednia.length/2] + (double)srednia[srednia.length/2 - 1])/2;
                    else
                        mediana = (double) srednia[srednia.length/2];

                    System.out.println("Mediana to: " + mediana);

                    System.out.println("Srednia arytmetyczna to: " + sredniaCiagu/srednia.length);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Zły wybór, podaj proszę numer opcji\n");
            }

        } while (opcja != 9);
        System.out.printf("Wybrano 9 - Program zakończył działanie.");

    }
    private static double[] getNumbers() {
        System.out.println("Podaj liczby podając je w odstępach po spacji (np. 1 8 12 33) i naciśnij enter");
        Scanner sn = new Scanner(System.in);
        String suma = sn.nextLine();
        String[] stringArray = suma.split(" ");
        double[] doubles = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            doubles[i] = Double.parseDouble(stringArray[i]);
        }
        return doubles;
    }
}