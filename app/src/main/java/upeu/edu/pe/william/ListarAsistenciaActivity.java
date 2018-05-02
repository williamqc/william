package upeu.edu.pe.william;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import upeu.edu.pe.dao.AsistenciaDao;
import upeu.edu.pe.utils.ListaAsisAdapter;

public class ListarAsistenciaActivity extends AppCompatActivity {

    AsistenciaDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(upeu.edu.pe.william.R.layout.activity_listar_asistencia);
        ListView lista=(ListView)findViewById(upeu.edu.pe.william.R.id.idListaAsis);
        dao=new AsistenciaDao(this);

        ListaAsisAdapter adapter=new ListaAsisAdapter(this,dao.listerAssistanceArray());
        lista.setAdapter(adapter);
    }
}
