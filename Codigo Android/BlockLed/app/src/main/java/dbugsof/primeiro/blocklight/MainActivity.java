package dbugsof.primeiro.blocklight;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static ConnectionThread connect;
    static Context contexto;
    static Desafio desafio;
    static boolean a= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        btAdapter.enable();


        connect = new ConnectionThread("20:14:05:19:35:86");
        connect.start();

        try {
            Thread.sleep(1200);
        } catch (Exception E) {
            E.printStackTrace();
        }
        contexto = getApplicationContext();


    }

    public void sobre(View view) {
        Intent it = new Intent (MainActivity.this, Sobre.class);
        startActivity(it);
    }
    public void desafio(View view) {
        String a = "$chaves#";
        connect.write(a.getBytes());

        try {
            Thread.sleep(2000);
        } catch (Exception E) {
            E.printStackTrace();
        }
        Intent it = new Intent (MainActivity.this, Desafio.class);
        startActivity(it);

    }

    public void irLicao(View view){
        Intent it = new Intent(MainActivity.this, TodasLicoesActivity.class);
        startActivity(it);
    }
    public void livreParaVoar(View view){
        Intent it = new Intent(MainActivity.this, Licao3Activity.class);
        startActivity(it);
    }

    static String lamps = "";
    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            /* Esse método é invocado na Activity principal
                sempre que a thread de conexão Bluetooth recebe
                uma mensagem.
             */
            Bundle bundle = msg.getData();
            byte[] data = bundle.getByteArray("data");
            String dataString= new String(data);

            /* Aqui ocorre a decisão de ação, baseada na string
                recebida. Caso a string corresponda à uma das
                mensagens de status de conexão (iniciadas com --),
                atualizamos o status da conexão conforme o código.
             */
            if(dataString.equals("---N"))
                Toast.makeText(contexto, "Ocorreu um erro durante a conexão D:", Toast.LENGTH_LONG).show();

            else if(dataString.equals("---S"))
                Toast.makeText(contexto, "Conectado :D", Toast.LENGTH_LONG).show();
            else {

                /* Se a mensagem não for um código de0 status,
                    então ela deve ser tratada pelo aplicativo
                    como uma mensagem vinda diretamente do outro
                    lado da conexão. Nesse caso, simplesmente
                    atualizamos o valor contido no TextView do
                    contador.
                 */

                // Toast.makeText(contexto, dataString, Toast.LENGTH_LONG).show();
                System.out.println(dataString + "\n");

                StringBuilder opc = new StringBuilder(dataString);

                if(opc.charAt(0)=='#'){
                    System.out.println(opc +" entrei");
                    lamps = opc.toString();
                    if(a){
                        desafio.mudaLampadas(lamps);
                    }


                   /* lamps = "#";
                    lamps += opc.charAt(1)+ "";
                    lamps += opc.charAt(2)+ "";
                    lamps += opc.charAt(3)+ "";
                    lamps += opc.charAt(4)+ "";
                    lamps += opc.charAt(5)+ "";
                    lamps += opc.charAt(6)+ "";
                    lamps += opc.charAt(7)+ "";*/
                   // System.out.println(lamps + " oi");
                   // String teste = Desafio.lamps;


                }else {

                    Copilando.variaveis[6] = opc.charAt(1) - 48;
                    Copilando.variaveis[7] = opc.charAt(2) - 48;
                    Copilando.variaveis[8] = opc.charAt(3) - 48;
                    Copilando.variaveis[9] = opc.charAt(4) - 48;
                }

            }

        }
    };

}
