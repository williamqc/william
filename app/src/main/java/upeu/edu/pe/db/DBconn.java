package upeu.edu.pe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Docente on 6/02/2018.
 */

public class DBconn extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="asistenciadb.db";

    public DBconn(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE usuario (idUsuario INTEGER PRIMARY KEY autoincrement NOT NULL,usuario TEXT NOT NULL,clave TEXT NOT NULL,nombres TEXT NOT NULL,apellidos TEXT,dnicodigo TEXT NOT NULL,email TEXT,estadousuario TEXT NOT NULL,unique(usuario,dnicodigo)); ");
        db.execSQL(" INSERT INTO usuario VALUES (1,'davidmp','123456','David','Mamani Pari','43631917','mamanipari@gmail.com','1'); ");
        db.execSQL(" INSERT INTO usuario VALUES (2,'admin','admin','Dario','Mamani Pari','43631917','mamanipari@gmail.com','1'); ");
        db.execSQL(" CREATE TABLE evento (idEvento INTEGER PRIMARY KEY autoincrement NOT NULL,fecha TEXT NOT NULL,horainicio TEXT NOT NULL,horafin TEXT NOT NULL, nombreevento TEXT NOT NULL,lugarevento TEXT,tiempotolerancia TEXT NOT NULL,estado TEXT NOT NULL); ");
        db.execSQL(" insert into evento(fecha,horainicio,horafin,nombreevento,lugarevento,tiempotolerancia,estado) values(date('now'),strftime('%H','now'),strftime('%H','now'),'Cultura','juliaca',strftime('%H','now'),'1') ");
        db.execSQL(" insert into evento(fecha,horainicio,horafin,nombreevento,lugarevento,tiempotolerancia,estado) values(date('now'),strftime('%H','now'),strftime('%H','now'),'Simposio','juliaca',strftime('%H','now'),'0') ");
        db.execSQL(" insert into evento(fecha,horainicio,horafin,nombreevento,lugarevento,tiempotolerancia,estado) values(date('now'),strftime('%H','now'),strftime('%H','now'),'Apertura del Ciclo Academico','juliaca',strftime('%H','now'),'1') ");
        db.execSQL(" CREATE TABLE asistencia (idAsistencia INTEGER PRIMARY KEY autoincrement NOT NULL,idEvento INTEGER REFERENCES evento(idEvento) on delete restrict deferrable initially deferred NOT NULL,idUsuario INTEGER REFERENCES usuario(idUsuario) on delete restrict deferrable initially deferred NOT NULL,codigo TEXT NOT NULL,nombres TEXT NOT NULL,companhia TEXT NOT NULL,fechahora TEXT NOT NULL,ofline TEXT NOT NULL); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(" drop table if exists usuario; ");
            db.execSQL(" drop table if exists evento; ");
            db.execSQL(" drop table if exists asistencia; ");
            onCreate(db);
    }
}
