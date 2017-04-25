package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 25.4.17..
 */

@DatabaseTable(tableName = "vagon")
public class Vagon {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_OZNAKA , canBeNull = false)
    private String oznaka;

    @DatabaseField(columnName = POLJE_OPIS , canBeNull = false)
    private String opis;

    @DatabaseField(columnName = POLJE_NOSIVOST , canBeNull = false)
    private double nosivost;

    @DatabaseField(columnName = POLJE_TERET , canBeNull = false)
    private double teret;

    @DatabaseField(foreign = true)
    private Voz voz;


    public Vagon(){

    }

    public Vagon(String oznaka,String opis,double nosivost){
        this.oznaka = oznaka;
        this.opis = opis;
        this.nosivost = nosivost;

    }


    public int getId() {return id;}
    public String getOznaka() {return oznaka;}
    public String  getOpis() {return opis;}
    public double getNosivost() {return nosivost;}
    public double getTeret() {return teret;}

    public void setId(int id) {this.id = id;}
    public void setOznaka(String oznaka) {this.oznaka = oznaka;}
    public void setOpis(String opis) {this.opis = opis;}
    public void setNosivost(double nosivost) {this.nosivost = nosivost;}
    public void setTeret(double teret) {this.teret = teret;}

    public void setVoz(Voz voz) {
        this.voz = voz;
    }

    public static final String POLJE_OZNAKA = "oznaka";
    public static final String POLJE_OPIS = "opis";
    public static final String POLJE_NOSIVOST = "nosivost";
    public static final String POLJE_TERET = "teret";

    @Override
    public String toString() {
        return "Vagon{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", opis='" + opis + '\'' +
                ", nosivost=" + nosivost +
                ", teret=" + teret +
                '}';
    }
}
