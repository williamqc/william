package upeu.edu.pe.william;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Reg_asistecia extends AppCompatActivity {
    int idUsuario=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_asistecia);

    }
    public void RegistroQR(View view){

        Intent intent=new Intent();
        intent.putExtra("idUsuario", idUsuario);
        intent.setClass(this, SimpleScannerActivity.class);
        startActivity(intent);
    }
}


