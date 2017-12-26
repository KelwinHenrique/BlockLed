package dbugsof.primeiro.blocklight;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Created by kelwi on 06/11/2017.
 */

public class Copilando {

    private StringBuilder codigo;
    private String[] linhaporlinha;
    static Context contexto;
    ConnectionThread connect;
    protected static int[] variaveis;
    /*
    pos0 = lapada1
    pos2 = lapada2
    pos3 = lapada3
    pos4 = lapada4
    pos5 = lapada5
    pos6 = lapada6
    pos7 = chave1
    pos8 = chave2
    pos9 = chave3
    pos10 = chave4
    pos11 = tempo
     */

    public Copilando(Context contextoact, String codigogerado, int chave1, int chave2, int chave3, int chave4, int tempo, ConnectionThread connect1) throws InterruptedException {
        codigo = new StringBuilder(codigogerado);
        variaveis = new int[12];
        variaveis[0] = 0;
        variaveis[1] = 0;
        variaveis[2] = 0;
        variaveis[3] = 0;
        variaveis[4] = 0;
        variaveis[5] = 0;
        variaveis[6] = chave1;
        variaveis[7] = chave2;
        variaveis[8] = chave3;
        variaveis[9] = chave4;
        variaveis[10] = 0;
        contexto = contextoact;
        this.connect = connect1;

        linhaporlinha = codigogerado.split("\n");
        //System.out.println(linhaporlinha[0]);









        copila();

    }

    public void copila() throws InterruptedException {

        for (int i = 0; i < linhaporlinha.length; i++) {
            linhaporlinha[i] = linhaporlinha[i].replaceAll(" ", "");
            linhaporlinha[i] = linhaporlinha[i].replaceAll(";", "");


            StringBuilder auxiliar = new StringBuilder(linhaporlinha[i]);

            if (auxiliar.indexOf("if") != -1) {
                System.out.println("Olá, entrou no IF");
                int cont = 1;
                int auxi = i;
                while (cont != 0) {
                    auxi++;
                    if (linhaporlinha[auxi].indexOf("}") != -1) {
                        cont--;
                    } else if (linhaporlinha[auxi].indexOf("{") != -1) {
                        cont++;
                    }
                }
                System.out.println("i: " + i);
                System.out.println("auxi: " + auxi);
                StringBuilder auxiliar1 = new StringBuilder(linhaporlinha[auxi]);
                if (verificarCondicao(auxiliar)) {
                    oif(i + 1, auxi);

                    if (auxiliar1.indexOf("else") != -1) {

                        cont = 1;
                        while (cont != 0) {
                            auxi++;
                            if (linhaporlinha[auxi].indexOf("}") != -1) {
                                cont--;
                            } else if (linhaporlinha[auxi].indexOf("{") != -1) {
                                cont++;
                            }
                        }

                    }

                } else if (auxiliar1.indexOf("else") != -1) {
                    oif(i + 1, auxi);
                }
                i = auxi;
                } else if (auxiliar.indexOf("while") != -1) {
                System.out.println("Olá, entrou no WHILE");
                int cont = 1;
                int auxi = i;
                while (cont != 0) {
                    auxi++;
                    if (linhaporlinha[auxi].indexOf("{") != -1) {
                        cont++;
                    }
                    if (linhaporlinha[auxi].indexOf("}") != -1) {
                        cont--;
                    }
                }

                if (verificarCondicao(auxiliar)) {
                    owhile(i + 1, auxi, auxiliar);

                }
                i = auxi;

            } else if (auxiliar.indexOf("var") == -1){
                System.out.println("Olá, entrou no NÃO VAR");
                String[] atribuicao = linhaporlinha[i].split("=");
                switch (atribuicao[0]) {
                    case "lampada1":
                        variaveis[0] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada2":
                        variaveis[1] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada3":
                        variaveis[2] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada4":
                        variaveis[3] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada5":
                        variaveis[4] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada6":
                        variaveis[5] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                }

            }

        }


        enviardados();
        System.out.println(variaveis[0] +" "+  variaveis[1] +" "+ variaveis[2] +" "+  variaveis[3] +" "+  variaveis[4] +" "+  variaveis[5] +" "+  variaveis[6] +" "+ variaveis[7] +" "+  variaveis[8] +" "+  variaveis[9] +" "+  variaveis[10]);

    }

    public boolean verificarCondicao(StringBuilder linhaif) {
        String condicao = null;
        if(linhaif.lastIndexOf("if") != -1){
            condicao = linhaif.substring(3, linhaif.length()-2);
        }else{
            condicao = linhaif.substring(6, linhaif.length()-2);
        }


//        condicao= condicao.replaceAll(" ", "");
//
//        condicao= condicao.replaceAll("{", "");
//        condicao =condicao.replaceAll(")", "");

        if (condicao.indexOf("==") != -1) {
            String[] comparacao = condicao.split("==");

            switch (comparacao[0]) {
                case "lampada1":
                    if (variaveis[0] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada2":
                    if (variaveis[1] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada3":
                    if (variaveis[2] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada4":
                    if (variaveis[3] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada5":
                    if (variaveis[4] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada6":
                    if (variaveis[5] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "chave1":
                    if (variaveis[6] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {

                        return true;
                    } else {
                        return false;
                    }
                case "chave2":
                    if (variaveis[7] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }
                case "chave3":
                    if (variaveis[8] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }
                case "chave4":
                    if (variaveis[9] == (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }
                case "tempo":
                    if (variaveis[10] == Integer.parseInt(comparacao[1])) {
                        return true;
                    } else {
                        return false;
                    }
            }

        } else if (condicao.indexOf("!=") != -1) {
            String[] comparacao = condicao.split("!=");
            switch (comparacao[0]) {
                case "lampada1":
                    if (variaveis[0] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada2":
                    if (variaveis[1] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada3":
                    if (variaveis[2] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada4":
                    if (variaveis[3] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada5":
                    if (variaveis[4] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "lampada6":
                    if (variaveis[5] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }

                case "chave1":
                    if (variaveis[6] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }
                case "chave2":
                    if (variaveis[7] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }
                case "chave3":
                    if (variaveis[8] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }
                case "chave4":
                    if (variaveis[9] != (comparacao[1].compareTo("true") == 0 ? 1 : 0)) {
                        return true;
                    } else {
                        return false;
                    }
                case "tempo":
                    if (variaveis[10] != Integer.parseInt(comparacao[1])) {
                        return true;
                    } else {
                        return false;
                    }
            }

        } else if (condicao.indexOf("<=") != -1) {
            String[] comparacao = condicao.split("<=");
            switch (comparacao[0]) {
                case "tempo":
                    if (variaveis[10] <= Integer.parseInt(comparacao[1])) {
                        return true;
                    } else {
                        return false;
                    }
            }

        } else if (condicao.indexOf(">=") != -1) {
            String[] comparacao = condicao.split(">=");
            switch (comparacao[0]) {
                case "tempo":
                    if (variaveis[10] >= Integer.parseInt(comparacao[1])) {
                        return true;
                    } else {
                        return false;
                    }
            }

        } else if (condicao.indexOf("<") != -1) {
            String[] comparacao = condicao.split("<");
            switch (comparacao[0]) {
                case "tempo":
                    if (variaveis[10] < Integer.parseInt(comparacao[1])) {
                        return true;
                    } else {
                        return false;
                    }
            }

        } else if (condicao.indexOf(">") != -1) {
            String[] comparacao = condicao.split(">");
            switch (comparacao[0]) {
                case "tempo":
                    if (variaveis[10] > Integer.parseInt(comparacao[1])) {
                        return true;
                    } else {
                        return false;
                    }
            }

        }

        return false;
    }

    public void owhile(int inicio, int fim, StringBuilder auxiliardaauxiliar) throws InterruptedException {
        int ka=0;
        for (int i = inicio; i <= fim; i++) {
            if (i == fim) {
               

                enviardados();
                try {
                    Thread.sleep(500);
                } catch (Exception E) {
                    E.printStackTrace();
                }

                ka++;

                if(ka==2){variaveis[10] = variaveis[10] + 1; ka=0;}

                if (verificarCondicao(auxiliardaauxiliar)) {
                    i = inicio;
                }

               // System.out.println(variaveis[0] +" "+  variaveis[1] +" "+ variaveis[2] +" "+  variaveis[3] +" "+  variaveis[4] +" "+  variaveis[5] +" "+  variaveis[6] +" "+ variaveis[7] +" "+  variaveis[8] +" "+  variaveis[9] +" "+  variaveis[10]);

            }
            linhaporlinha[i] = linhaporlinha[i].replaceAll(" ", "");
            linhaporlinha[i] = linhaporlinha[i].replaceAll(";", "");
            StringBuilder auxiliar = new StringBuilder(linhaporlinha[i]);
            if (auxiliar.indexOf("if") != -1) {
               // System.out.println("Olá, entrou no IF");
                int cont = 1;
                int auxi = i;
                while (cont != 0) {
                    auxi++;
                    if (linhaporlinha[auxi].indexOf("}") != -1) {
                        cont--;
                    } else if (linhaporlinha[auxi].indexOf("{") != -1) {
                        cont++;
                    }
                }
                System.out.println("i: " + i);
                System.out.println("auxi: " + auxi);
                StringBuilder auxiliar1 = new StringBuilder(linhaporlinha[auxi]);
                if (verificarCondicao(auxiliar)) {
                    oif(i + 1, auxi);

                    if (auxiliar1.indexOf("else") != -1) {

                        cont = 1;
                        while (cont != 0) {
                            auxi++;
                            if (linhaporlinha[auxi].indexOf("}") != -1) {
                                cont--;
                            } else if (linhaporlinha[auxi].indexOf("{") != -1) {
                                cont++;
                            }
                        }

                    }

                } else if (auxiliar1.indexOf("else") != -1) {
                    oif(i + 1, auxi);
                }
                i = auxi;

            } else if (auxiliar.indexOf("while") != -1) {

                int cont = 1;
                int auxi = i;
                while (cont != 0) {
                    auxi++;
                    if (linhaporlinha[auxi].indexOf("{") != -1) {
                        cont++;
                    }
                    if (linhaporlinha[auxi].indexOf("}") != -1) {
                        cont--;
                    }
                }
                if (verificarCondicao(auxiliar)) {
                    owhile(i + 1, auxi, auxiliar);

                }
                i = auxi;

            } else {
                String[] atribuicao = linhaporlinha[i].split("=");
                switch (atribuicao[0]) {
                    case "lampada1":
                        variaveis[0] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada2":
                        variaveis[1] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada3":
                        variaveis[2] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada4":
                        variaveis[3] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada5":
                        variaveis[4] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada6":
                        variaveis[5] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                }

            }

        }

    }

    public void oif(int inicio, int fim) throws InterruptedException {

        for (int i = inicio; i < fim; i++) {
            linhaporlinha[i] = linhaporlinha[i].replaceAll(" ", "");
            linhaporlinha[i] = linhaporlinha[i].replaceAll(";", "");
            StringBuilder auxiliar = new StringBuilder(linhaporlinha[i]);

            if (auxiliar.indexOf("if") != -1) {

                System.out.println("Olá, entrou no IF");
                int cont = 1;
                int auxi = i;
                while (cont != 0) {
                    auxi++;
                    if (linhaporlinha[auxi].indexOf("}") != -1) {
                        cont--;
                    } else if (linhaporlinha[auxi].indexOf("{") != -1) {
                        cont++;
                    }
                }
                System.out.println("i: " + i);
                System.out.println("auxi: " + auxi);
                StringBuilder auxiliar1 = new StringBuilder(linhaporlinha[auxi]);
                if (verificarCondicao(auxiliar)) {
                    oif(i + 1, auxi);

                    if (auxiliar1.indexOf("else") != -1) {

                        cont = 1;
                        while (cont != 0) {
                            auxi++;
                            if (linhaporlinha[auxi].indexOf("}") != -1) {
                                cont--;
                            } else if (linhaporlinha[auxi].indexOf("{") != -1) {
                                cont++;
                            }
                        }

                    }

                } else if (auxiliar1.indexOf("else") != -1) {
                    oif(i + 1, auxi);
                }
                i = auxi;

            } else if (auxiliar.indexOf("while") != -1) {

                int cont = 1;
                int auxi = i;
                while (cont != 0) {
                    auxi++;
                    if (linhaporlinha[auxi].indexOf("{") != -1) {
                        cont++;
                    }
                    if (linhaporlinha[auxi].indexOf("}") != -1) {
                        cont--;
                    }
                }
                if (verificarCondicao(auxiliar)) {
                    owhile(i + 1, auxi, auxiliar);

                }
                i = auxi;
            } else {
                String[] atribuicao = linhaporlinha[i].split("=");
                switch (atribuicao[0]) {
                    case "lampada1":
                        variaveis[0] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada2":
                        variaveis[1] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada3":
                        variaveis[2] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada4":
                        variaveis[3] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada5":
                        variaveis[4] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                    case "lampada6":
                        variaveis[5] = atribuicao[1].compareTo("true") == 0 ? 1 : 0;
                        break;
                }

            }

        }

    }



    public void enviardados(){


        String a = "$" + variaveis[0] +""+  variaveis[1] +""+ variaveis[2] +""+  variaveis[3] +""+  variaveis[4] +""+  variaveis[5] +"#";
        System.out.println(a +" enviou essa");
        //if(connect.isConnected)
        MainActivity.connect.write(a.getBytes());


      /*  Toast.makeText(contexto, a,
                Toast.LENGTH_LONG).show();
*/

    }


}




