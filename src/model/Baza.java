package model;

import view.MainView;

import java.util.ArrayList;
import java.util.List;

public class Baza {

    private static Baza instance;

    private List<Korisnik> korisnici;
    private List<Transakcije> transakcije;

    private Baza(){
        korisnici = new ArrayList<>();
        transakcije = new ArrayList<>();
    }

    public static Baza getInstance(){
        if(instance == null){
            instance = new Baza();
        }
        return instance;
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void dodajKorisnika(Korisnik korisnik){
        if(!korisnici.contains(korisnik))
            korisnici.add(korisnik);
    }

    public List<Transakcije> getTransakcije() {
        return transakcije;
    }

    public void dodajTransakciju(Transakcije transakcije){
        if(!getTransakcije().contains(transakcije))
            getTransakcije().add(transakcije);
    }

    public Double trenutnoStanjeKartica(){
        double stanje = 0;
            for(Transakcije t: getTransakcije()){
                if(t.getNacin().equals(Nacin.KARTICA)){
                    if(t.getTip().equals(Tip.UPLATA)){
                        stanje += t.getIznos();
                    }else{
                        stanje -= t.getIznos();
                    }
                }
            }
        return stanje;
    }

    public Double trenutnoStanjeKes(){
        double stanje = 0;
            for(Transakcije t: getTransakcije()) {
                if (t.getNacin().equals(Nacin.KES)) {
                    if (t.getTip().equals(Tip.UPLATA)) {
                        stanje += t.getIznos();
                    } else {
                        stanje -= t.getIznos();
                    }
                }
            }
        return stanje;
    }

    public void obrisiIzTrasakciju(Transakcije transakcije){
        for(Transakcije t: getTransakcije()){
            getTransakcije().remove(transakcije);
        }
    }

}
