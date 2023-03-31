import jdk.dynalink.linker.support.CompositeTypeBasedGuardingDynamicLinker;
import java.util.ArrayList;
import java.sql.Struct;
import java.util.Scanner;


class Osoba {
    private String imie;
    private String nazwisko;
    private int id;
    private Osoba nastepna;
    private Osoba poprzednia;

    public Osoba(String imie, String nazwisko, int id) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
        this.poprzednia = null;
        this.nastepna = null;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getId() {
        return id;
    }

    public Osoba getPoprzednia() {
        return poprzednia;
    }

    public void setPoprzednia(Osoba poprzednia) {
        this.poprzednia = poprzednia;
    }

    public Osoba getNastepna() {
        return nastepna;
    }

    public void setNastepna(Osoba nastepna) {
        this.nastepna = nastepna;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Osoba> listaOsob = new ArrayList<Osoba>();

        System.out.print("Podaj ilość wprowadzanych osób: ");
        int iloscOsob = scanner.nextInt();
        for (int i = 1; i <= iloscOsob; i++) {
            System.out.print("Podaj imię osoby " + i + ": ");
            String imie = scanner.next();

            System.out.print("Podaj nazwisko osoby " + i + ": ");
            String nazwisko = scanner.next();

            System.out.print("Podaj ID osoby " + i + ": ");
            int id = scanner.nextInt();

            Osoba osoba = new Osoba(imie, nazwisko, id);
            listaOsob.add(osoba);
        }
        for (int i = 0; i < listaOsob.size() - 1; i++) {
            Osoba obecnaOsoba = listaOsob.get(i);
            Osoba nastepnaOsoba = listaOsob.get(i + 1);
            obecnaOsoba.setNastepna(nastepnaOsoba);
            nastepnaOsoba.setPoprzednia(obecnaOsoba);
        }
        for (Osoba osoba : listaOsob) {
            System.out.println(osoba.getImie() + " " + osoba.getNazwisko() + " (" + osoba.getId() + ")");
        }


    }
}