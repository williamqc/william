package upeu.edu.pe.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import upeu.edu.pe.db.DBconn;
import upeu.edu.pe.db.DBconnExterno;
import upeu.edu.pe.to.AsistenciaTO;



public class AsistenciaDao extends DBconnExterno {
    DBconnExterno con;
    Context contex;
    SQLiteDatabase db;
    Cursor cur;
    String sql;

    public AsistenciaDao(Context context) {
        super(context);
        this.contex=context;
    }

    public void registrarAsistencia(int idEvento, int idUsuario, String codigo, String nombre, String companhia){
        con=new DBconnExterno(contex);
        db=con.getWritableDatabase();
        db.execSQL("insert into asistencia(idEvento,idUsuario,codigo,nombres,companhia, fechahora,ofline) " +
                " values("+idEvento+","+idUsuario+",'"+codigo+"','"+nombre+"','"+companhia+"',datetime('now'),'0'); ");
    }

    public Cursor listarAsistencia(){
        con=new DBconnExterno(contex);
        db=con.getReadableDatabase();
        sql="select * from asistencia ";
        cur=db.rawQuery(sql,null);
        return cur;
    }

    public List listerAssistanceArray(){
        con=new DBconnExterno(contex);
        db=con.getReadableDatabase();
        sql=" select codigo,nombres,fechahora from asistencia ";
        cur=db.rawQuery(sql,null);
        ArrayList<AsistenciaTO> lista=new ArrayList<AsistenciaTO>();
        AsistenciaTO to=null;
        while (cur.moveToNext()){
            to=new AsistenciaTO();
            to.setCodigo(cur.getString(3));
            to.setNombres(cur.getString(4));
            to.setFechahora(cur.getString(6));
            lista.add(to);
        }

        return lista;
    }
}
