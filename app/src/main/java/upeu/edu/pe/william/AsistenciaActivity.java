package upeu.edu.pe.william;


import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.api.Auth;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import upeu.edu.pe.dao.UsuarioDao;


public class AsistenciaActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private GoogleApiClient googleApíInClient;
    TextView msg;
    UsuarioDao usu;
    public  static  final int SIGN_IN_CODE =777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(upeu.edu.pe.william.R.layout.activity_asistencia);
        final EditText txtUsuario =(EditText) findViewById(upeu.edu.pe.william.R.id.idUsuario);
        final EditText txtClave =(EditText) findViewById(upeu.edu.pe.william.R.id.idClave);
        final Button btnIngresar=(Button)findViewById(upeu.edu.pe.william.R.id.IdIngresar);
       // msg=(TextView)findViewById(upeu.edu.pe.william.R.id.idMsg);
        usu=new UsuarioDao(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApíInClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso )
                .build();
        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= Auth.GoogleSignInApi.getSignInIntent(googleApíInClient);
                startActivityForResult(intent,SIGN_IN_CODE);
            }
        });



        btnIngresar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usu.validarUsuario(txtUsuario.getText().toString(), txtClave.getText().toString())){
                    ingresar();
                }else{
                   // msg.setText("Intente Nuevamente...!");
                }

            }
        });

    }


    public void ingresar(){
        final EditText txtUsuario =(EditText) findViewById(upeu.edu.pe.william.R.id.idUsuario);
        usu=new UsuarioDao(this);
        Cursor curx=usu.listarUsuario(txtUsuario.getText().toString());
        String nombre="";
        int idUsuario=0;
        if(curx.moveToNext()){
            nombre=curx.getString(3)+" "+curx.getString(4);
            idUsuario=curx.getInt(0);
        }
        Intent intent=new Intent();
        intent.putExtra("txtUsuarioNombre", nombre);
        intent.putExtra("idUsuario", idUsuario);
        intent.setClass(this, HomeActivity.class);
        startActivity(intent);
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    private void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess()){
            Intent intent = new Intent(this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);


        }else {
            Toast.makeText(this,"No se pudo iniciar sesion", Toast.LENGTH_SHORT).show();
        }
    }


}



