package upeu.edu.pe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import pe.edu.upeu.dbexterno.ExternalSQLiteOpenHelper;

/**
 * Created by William on 2/04/2018.
 */

public class DBconnExterno extends ExternalSQLiteOpenHelper{
    private final static String NAME_DATABASE="asistenciadb.db";
    private final static int version_DATAbase=1;

    public DBconnExterno(Context context) {
        super(context, NAME_DATABASE, null,version_DATAbase);
    }
}
