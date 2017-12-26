package dbugsof.primeiro.blocklight;

import android.content.Intent;


import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;


public class TodasLicoesActivity extends AppCompatActivity {
    VideoView vv;
    VideoView vv1;
    VideoView vv2;
    VideoView vvLx;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_todas_licoes);
        Uri src = Uri.parse("android.resource://dbugsof.primeiro.blocklight/" + R.raw.acendendol);
        Uri src1 = Uri.parse("android.resource://dbugsof.primeiro.blocklight/" + R.raw.ifelse);
        Uri src2 = Uri.parse("android.resource://dbugsof.primeiro.blocklight/" + R.raw.lacoif);
        Uri srclx = Uri.parse("android.resource://dbugsof.primeiro.blocklight/" + R.raw.lixeira);

        vv = (VideoView) findViewById(R.id.vv);
        vv1 = (VideoView) findViewById(R.id.vv1);
        vv2 = (VideoView) findViewById(R.id.vv2);
        vvLx = (VideoView) findViewById(R.id.vvLixeira);

        vv.setVideoURI(src);
        vv1.setVideoURI(src1);
        vv2.setVideoURI(src2);
        vvLx.setVideoURI(srclx);

        vv.setMediaController(new MediaController(this));
        vv1.setMediaController(new MediaController(this));
        vv2.setMediaController(new MediaController(this));
        vvLx.setMediaController(new MediaController(this));

        vv.start();
      //  vv1.start();
      //  vv2.start();
        vvLx.start();
    }

    public void licoes(View view){

        Intent it = new Intent(TodasLicoesActivity.this, LicaoActivity.class);
        startActivity(it);
    }

    public void irLicao1(View view){

        Intent it = new Intent(TodasLicoesActivity.this, Licao1Activity.class);
        startActivity(it);
    }

    public void irLicao2(View view){

        Intent it = new Intent(TodasLicoesActivity.this, Licao2Activity.class);
        startActivity(it);
    }

    public void irLicao3(View view){

        Intent it = new Intent(TodasLicoesActivity.this, Licao3Activity.class);
        startActivity(it);
    }

}
