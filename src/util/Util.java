package util;

import javafx.util.converter.DateTimeStringConverter;
import model.*;
import view.MainView;

import javax.swing.text.DateFormatter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.zip.DataFormatException;

public class Util {

    public static void initKorisnik(){
        Korisnik korisnik = new Korisnik("GoJo","12345");
        Baza.getInstance().dodajKorisnika(korisnik);
    }

    public static void ispisUFajl(){
        try {
            FileOutputStream fos = new FileOutputStream("baza.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            for(Transakcije t: Baza.getInstance().getTransakcije()){
                bw.append(t.toString());
                bw.newLine();
            }
            bw.close();
            osw.close();
            fos.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void ucitajIzFajla()  {
        try {
            FileInputStream fis = new FileInputStream("baza.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String linija;
            while((linija = br.readLine()) != null){
                String splitovano[] = linija.split(",");
                String naziv = splitovano[0];
                Double iznos = Double.parseDouble(splitovano[1]);

                String datum1 = splitovano[2];
                datum1.trim();
                LocalDate datum = LocalDate.parse(datum1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                Tip tip = Tip.valueOf(splitovano[3]);
                Nacin nacin = Nacin.valueOf(splitovano[4]);

                Transakcije t = new Transakcije(naziv,iznos,datum,tip,nacin);
                Baza.getInstance().dodajTransakciju(t);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ArrayIndexOutOfBoundsException e){
            return;
        }
    }


}
