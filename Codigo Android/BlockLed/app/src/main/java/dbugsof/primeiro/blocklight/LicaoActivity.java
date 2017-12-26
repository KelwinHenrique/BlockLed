package dbugsof.primeiro.blocklight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LicaoActivity extends AppCompatActivity {
    Intent it;
    static int help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_licao);
        help = 0;
    }

    public void irLicao1(View view){

        it = new Intent(LicaoActivity.this, Licao1Activity.class);
        startActivity(it);
    }

    public void irLicao2(View view){

       it = new Intent(LicaoActivity.this, Licao2Activity.class);
        startActivity(it);
    }

    public void irl3(View view){

      it = new Intent(LicaoActivity.this, Licao3Activity.class);
        startActivity(it);
    }

}
