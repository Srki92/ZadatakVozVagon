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
public class Zadatak4BrisanjeVrednosti {

    static Dao<Voz, Integer> vozDao;
    static Dao<Vagon, Integer>vagonDao;

    public static void main(String[] args) {


        ConnectionSource connectionSource = null;
        try{
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:vozVagon.db" );


            vozDao = DaoManager.createDao(connectionSource, Voz.class);
            vagonDao = DaoManager.createDao(connectionSource, Vagon.class);


            List<Vagon> pronadjenVagon = vagonDao.queryForEq(Vagon.POLJE_NOSIVOST , 10);
            Vagon vagonZaBrisanje = pronadjenVagon.get(0);
            vagonDao.delete(vagonZaBrisanje);

            List<Vagon> vagon=vagonDao.queryForAll();
            for(Vagon va:vagon)
                System.out.println("Vagon = " + va);





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
