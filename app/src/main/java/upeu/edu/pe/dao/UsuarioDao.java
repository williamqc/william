package upeu.edu.pe.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import upeu.edu.pe.db.DBExterno;
import upeu.edu.pe.db.DBconnExterno;



public class UsuarioDao extends DBExterno {
    DBconnExterno con;
    Context contex;
    SQLiteDatabase db;
    Cursor cur;
    String sql;

    public UsuarioDao(Context context) {
        super(context);
        this.contex=context;
    }

    public boolean validarUsuario(String usuario, String clave){
        con= new DBconnExterno(contex);
        db=con.getReadableDatabase();
        sql=" select * from usuario where usuario='"+usuario+"' and clave='"+clave+"'";
        cur=db.rawQuery(sql, null);
        if(cur.getCount()==1){
            return true;
        }else{
        return false;
        }
    }

    public Cursor listarUsuario(String usuario){
        con= new DBconnExterno(contex);
        db=con.getReadableDatabase();
        sql=" select * from usuario where usuario='"+usuario+"'";
        cur=db.rawQuery(sql, null);
        return cur;
    }


}
