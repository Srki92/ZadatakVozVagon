package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Vagon;
import model.Voz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class Zadatak2DodavanjeVrednosti {


    static Dao<Voz,Integer > vozDao;
    static Dao<Vagon,Integer >vagonDao;

    public static void main(String[] args) {



        ConnectionSource connectionSource = null;
        try{
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:vozVagon.db" );

            vozDao = DaoManager.createDao(connectionSource, Voz.class);
            vagonDao = DaoManager.createDao(connectionSource, Vagon.class);

            Voz v1 = new Voz("Voz1" ,"Dizel");
            vozDao.create(v1);

            Voz v2 = new Voz("Voz2" ,"Elektricni");
            vozDao.create(v2);


            Vagon vagon1 = new Vagon ("Vagon1" , "Za prenos goriva" , 10);
            vagon1.setVoz(v1);
            vagonDao.create(vagon1);

            Vagon vagon2 = new Vagon ("Vagon2" ,"Za prenos toksicnih materija" , 5);
            vagon2.setVoz(v1);
            vagonDao.create(vagon2);

            Vagon vagon3 = new Vagon ("Vagon3" , "Za prenos psenice",  20);
            vagon3.setVoz(v1);
            vagonDao.create(vagon3);

            Vagon vagon4 = new Vagon ("Vagon4", "Za spavanje", 5);
            vagon4.setVoz(v2);
            vagonDao.create(vagon4);

            Vagon vagon5 = new Vagon ("Vagon5" ,"Restoran", 3 );
            vagon5.setVoz(v2);
            vagonDao.create(vagon5);



            List<Voz> voz=vozDao.queryForAll();
            for(Voz v:voz)
                System.out.println("Voz = " + v);

            List<Vagon> vagon=vagonDao.queryForAll();
            for (Vagon va:vagon)
                System.out.println("Voz = " + va);



        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connectionSource !=null){
                try{
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
