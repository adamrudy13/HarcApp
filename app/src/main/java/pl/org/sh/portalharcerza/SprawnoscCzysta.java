package pl.org.sh.portalharcerza;

import java.util.List;

/**
 * Created by Komputer Adam on 16.10.2017.
 */

public class SprawnoscCzysta {

    public SprawnoscCzysta ( String nzw, String kat, int poz, List wym ){

        this.nazwa = nzw;
        this.kategoria = kat;
        this.poziom = poz;
        this.wymagania = wym;
    }

    public SprawnoscCzysta (){
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getKategoria() {
        return kategoria;
    }

    public int getPoziom() {
        return poziom;
    }

    public List getWymagania() {
        return wymagania;
    }

    public void setWymagania(List wymagania) {
        this.wymagania = wymagania;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public void setPoziom(int poziom) {
        this.poziom = poziom;
    }

    private List wymagania;
    private String nazwa;
    private String kategoria;
    private int poziom;
}
