package model;

import java.time.LocalDate;
import java.util.Date;

public class Transakcije {

    private String naziv;
    private Double iznos;
    private LocalDate datum;
    private Tip tip;
    private Nacin nacin;

    public Transakcije(String naziv, Double iznos, LocalDate datum, Tip tip, Nacin nacin) {
        this.naziv = naziv;
        this.iznos = iznos;
        this.datum = datum;
        this.tip = tip;
        this.nacin = nacin;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Double getIznos() {
        return iznos;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }

    public Nacin getNacin() {
        return nacin;
    }

    public void setNacin(Nacin nacin) {
        this.nacin = nacin;
    }

    @Override
    public String toString() {
        return naziv + ", " + iznos + "," + datum + "," + tip + "," + nacin;
    }
}
