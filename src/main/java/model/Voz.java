package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 25.4.17..
 */


@DatabaseTable(tableName = "voz")
public class Voz {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = POLJE_OZNAKA , canBeNull = false)
    private String oznaka;

    @DatabaseField(columnName = POLJE_NAZIV , canBeNull = false)
    private String naziv;


    @ForeignCollectionField(foreignFieldName = "vagon")
    private ForeignCollection<Vagon> vagon;

 public Voz(){

 }

 public Voz(int id,String naziv,String oznaka){
     this.id = id;
     this.naziv = naziv;
     this.oznaka = oznaka;
 }

 public int getId() {return id;}
 public String getOznaka() {return oznaka;}
 public String getNaziv() {return naziv;}

 public void setId(int id) {this.id = id;}
 public void setOznaka(String oznaka) {this.oznaka = oznaka;}
 public void setNaziv(String naziv) {this.naziv = naziv;}


 public static final String POLJE_OZNAKA = "oznaka";
 public static final String POLJE_NAZIV = "naziv";


    @Override
    public String toString() {
        return "Voz{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
