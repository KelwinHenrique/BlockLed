package dbugsof.primeiro.blocklight;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sobre);
    }

    public void voltar(View view) {
        Intent it = new Intent (Sobre.this, MainActivity.class);
        startActivity(it);
    }
}
