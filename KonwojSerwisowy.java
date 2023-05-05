import java.util.PriorityQueue;
import java.util.Queue;

public class KonwojSerwisowy {

    public static void main(String[] args) {
        // Tworzymy kolejke priorytetową
        Queue<ZgloszenieSerwisowe> kolejkaZlecen = new PriorityQueue<>();

        // Dodajemy standardowe zlecenia serwisowe
        kolejkaZlecen.add(new ZgloszenieSerwisowe("Wymiana taśmy magnetycznej", 3));
        kolejkaZlecen.add(new ZgloszenieSerwisowe("Czyszczenie czytnika kart", 2));
        kolejkaZlecen.add(new ZgloszenieSerwisowe("Konserwacja drukarki", 4));

        // Dodajemy priorytetowe zlecenia serwisowe
        kolejkaZlecen.add(new ZgloszenieSerwisowe("Zasilenie bankomatu", 1));
        kolejkaZlecen.add(new ZgloszenieSerwisowe("Zasilenie bankomatu", 1));
        kolejkaZlecen.add(new ZgloszenieSerwisowe("Zasilenie bankomatu", 1));

        // Dodajemy zgłoszenia niespodziewane
        kolejkaZlecen.add(new ZgloszenieSerwisowe("Niski stan gotówki w bankomacie", 5));
        kolejkaZlecen.add(new ZgloszenieSerwisowe("Awaria bankomatu", 0));

        // Wyświetlamy zlecenia z kolejki
        while (!kolejkaZlecen.isEmpty()) {
            System.out.println(kolejkaZlecen.remove());
        }
    }

    private record ZgloszenieSerwisowe(String opis, int priorytet) implements Comparable<ZgloszenieSerwisowe> {

        @Override
        public int compareTo(ZgloszenieSerwisowe other) {
            // Sortujemy malejąco wg priorytetów, a następnie alfabetycznie wg opisu
            int porownanie = Integer.compare(other.priorytet(), this.priorytet());
            if (porownanie == 0) {
                porownanie = this.opis().compareTo(other.opis());
            }
            return porownanie;
        }

        @Override
        public String toString() {
            return "Zlecenie serwisowe: " + opis + " (priorytet: " + priorytet + ")";
        }
    }
}