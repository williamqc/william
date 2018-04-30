package upeu.edu.pe.william;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import upeu.edu.pe.dao.EventoDao;
import upeu.edu.pe.utils.ListaEventoAdapter;

public class ActivarEventoActivity extends AppCompatActivity {

    EventoDao dao;
    Button btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(upeu.edu.pe.william.R.layout.activity_activar_evento);
        ListView lista=(ListView)findViewById(upeu.edu.pe.william.R.id.listEvento);
        btnRegresar=(Button)findViewById(upeu.edu.pe.william.R.id.btnRegresar);
        dao=new EventoDao(this);
        ListaEventoAdapter adapter=new ListaEventoAdapter(this, dao.ListarEvento());
        lista.setAdapter(adapter);



        //super.finish();
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp=getSharedPreferences("key", Context.MODE_PRIVATE);
                Intent intent=new Intent();
                intent.putExtra("idUsuario",sp.getInt("value",0));
                intent.putExtra("txtUsuarioNombre",sp.getString("valNombre","No muestra datos"));
                intent.setClass(view.getContext(), MainQRActivity.class);
                startActivity(intent);
            }
        });
    }
}
