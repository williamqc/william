package upeu.edu.pe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import pe.edu.upeu.dbexterno.ExternalSQLiteOpenHelper;



public class DBExterno extends ExternalSQLiteOpenHelper{


    public DBExterno(Context context) {
        super(context, "asistenciadb.db", null, 1);
    }
}
