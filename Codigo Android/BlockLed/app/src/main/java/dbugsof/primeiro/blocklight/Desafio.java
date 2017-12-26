package dbugsof.primeiro.blocklight;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;

public class  Desafio extends AppCompatActivity {

    private boolean lamp1=false;
    private boolean lamp2=false;
    private boolean lamp3=false;
    private boolean lamp4=false;
    private boolean lamp5=false;
    private boolean lamp6=false;
    private AlertDialog alerta;
    private static Desafio desafio;
    private TextView ganhou;
    private TextView c1;
    private TextView c2;
    private TextView c3;
    private TextView c4;
    private Button gn;
    Connection connect;
   // static public String lamps="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_desafio);
        ganhou = (TextView) findViewById(R.id.ganhou);
        c1 = (TextView) findViewById(R.id.chave1);
        c2 = (TextView) findViewById(R.id.chave2);
        c3 = (TextView) findViewById(R.id.chave3);
        c4 = (TextView) findViewById(R.id.chave4);
        gn = (Button) findViewById(R.id.gan);
        desafio = this;
        MainActivity.desafio = this.desafio;

        //lamp135.setOnClickListener(mButtonChangeImageListener)

        //parte do bt


       MainActivity.a = true;
      //  mudaLampadas(MainActivity.lamps);
        MainActivity.lamps = "";

    }

    private void simples(String msg){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        //builder.setMessage("Parabéns você conseguiu!!");
        builder.setMessage(msg);
        alerta = builder.create();
    }




    public void Enviar(){






    }
    public  void mudaLampadas(String dataString){



        mudaLamp1(MainActivity.lamps);
        mudaLamp2(MainActivity.lamps);
        mudaLamp3(MainActivity.lamps);
        mudaLamp4(MainActivity.lamps);
        mudaLamp5(MainActivity.lamps);
        mudaLamp6(MainActivity.lamps);
        if(lamp1&&lamp2&&lamp3&&lamp4&&lamp5&lamp6){
            ganhou.setVisibility(View.VISIBLE);
            c1.setVisibility(View.INVISIBLE);
            c2.setVisibility(View.INVISIBLE);
            c3.setVisibility(View.INVISIBLE);
            c4.setVisibility(View.INVISIBLE);

            gn.setVisibility(View.VISIBLE);



        }
    }
    public void Ganhao(View view){
        this.finish();
    }

    public  void mudaLamp1(String dataString){
        if(dataString.charAt(1)=='1'){
            lamp1=true;
            ImageView img1 = (ImageView) findViewById(R.id.lamp1);
            img1.setImageResource(R.drawable.vermelha);

        }else{
            lamp1=false;
            ImageView img1 = (ImageView) findViewById(R.id.lamp1);
            img1.setImageResource(R.drawable.apagada);
        }
    }
    public void mudaLamp2(String dataString){
        if(dataString.charAt(2)=='1'){
            lamp2=true;
            ImageView img2 = (ImageView) findViewById(R.id.lamp2);
            img2.setImageResource(R.drawable.amarela);

        }else{
            lamp2=false;
            ImageView img2 = (ImageView) findViewById(R.id.lamp2);
            img2.setImageResource(R.drawable.apagada);

        }
    }
    public void mudaLamp3(String dataString){
        if(dataString.charAt(3)=='1'){
            lamp3=true;
            ImageView img3 = (ImageView) findViewById(R.id.lamp3);
            img3.setImageResource(R.drawable.azul);

        }else{
            lamp3=false;
            ImageView img3 = (ImageView) findViewById(R.id.lamp3);
            img3.setImageResource(R.drawable.apagada);

        }
    }
    public void mudaLamp4(String dataString){
        if(dataString.charAt(4)=='1'){
            lamp4=true;
            ImageView img4 = (ImageView) findViewById(R.id.lamp4);
            img4.setImageResource(R.drawable.azul);

        }else{
            lamp4=false;
            ImageView img4 = (ImageView) findViewById(R.id.lamp4);
            img4.setImageResource(R.drawable.apagada);

        }
    }
    public void mudaLamp5(String dataString){
        if(dataString.charAt(5)=='1'){
            lamp5=true;
            ImageView img5 = (ImageView) findViewById(R.id.lamp5);
            img5.setImageResource(R.drawable.verde);

        }else{
            lamp5=false;
            ImageView img5 = (ImageView) findViewById(R.id.lamp5);
            img5.setImageResource(R.drawable.apagada);

        }
    }
    public void mudaLamp6(String dataString){
        if(dataString.charAt(6)=='1'){
            lamp6=true;
            ImageView img6 = (ImageView) findViewById(R.id.lamp6);
            img6.setImageResource(R.drawable.vermelha);

        }else{
            lamp6=false;
            ImageView img6 = (ImageView) findViewById(R.id.lamp6);
            img6.setImageResource(R.drawable.apagada);

        }

    }



//    public void acender135(){
//
//        if(lamp1==true){
//            lamp1=false;
//            img1.setImageResource(R.drawable.apagada);
//        }else{
//            lamp1=true;
//            img1.setImageResource(R.drawable.vermelha);
//        }
//        if(lamp3==true){
//            lamp3=false;
//            img3.setImageResource(R.drawable.apagada);
//        }else{
//            lamp3=true;
//            img3.setImageResource(R.drawable.amarela);
//        }
//        if(lamp5==true){
//            lamp5=false;
//            img5.setImageResource(R.drawable.apagada);
//        }else{
//            lamp5=true;
//            img5.setImageResource(R.drawable.azul);
//        }
//    }
//    public void acender246(){
//
//        if(lamp2==true){
//            lamp2=false;
//            img2.setImageResource(R.drawable.apagada);
//        }else{
//            lamp2=true;
//            img2.setImageResource(R.drawable.azul);
//        }
//        if(lamp4==true){
//            lamp4=false;
//            img4.setImageResource(R.drawable.apagada);
//        }else{
//            lamp4=true;
//            img4.setImageResource(R.drawable.veerde);
//        }
//        if(lamp6==true){
//            lamp6=false;
//            img6.setImageResource(R.drawable.apagada);
//        }else{
//            lamp6=true;
//            img6.setImageResource(R.drawable.vermelha);
//        }
//
//    }

//    View.OnClickListener mButtonChangeImageListener = new View.OnClickListener() {
//        public void onClick(View v) {
//            // setImageResource will change image in ImageView
//            acender135();
//        }
//    };


}
