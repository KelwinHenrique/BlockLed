#include <SoftwareSerial.h>

/* Definição de um objeto SoftwareSerial.
 * Usaremos os pinos 8 e 9, como RX e TX, respectivamente.
 */
SoftwareSerial serial(0, 1);
 
/* A String data será utilizada para armazenar dados vindos
 *  do Android. O inteiro counter será incrementado a cada
 *  execução do loop principal e transmitido ao Android.
 *  O led conectado ao pino 2 é mais para debug. É útil.
 */
String data = "";
String chaves = "";
char aux="";
int counter = 0;
int led1 = 13;
int led2 = 12;
int led3 = 11;
int led4 = 10;
int led5 = 9;
int led6 = 6;
boolean modoJogo=false;

int ch1 = 4;
int ch2 = 5;
int ch3 = 8;
int ch4 = 7;

int lastButtonState1=0;

int lastButtonState2=0;

int lastButtonState3=0;

int lastButtonState4=0;

boolean a = false;
boolean b = false;
boolean c = false;
boolean d = false;
boolean f = false;
boolean g = false;
boolean h = false;
boolean ok = false;
 
/* Nosso setup inclui a inicialização do objeto SoftwareSerial,
 *  com uma baud rate de 9600 bps. A definição do pino do led
 *  como saída e um delay de 2 segundos, só para garantir que
 *  o módulo HC-06 iniciou direitinho.
 */
void setup() {
  
  serial.begin(9600);
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
  pinMode(led4, OUTPUT);
  pinMode(led5, OUTPUT);
  pinMode(led6, OUTPUT);
  
  pinMode(ch1, INPUT);
  pinMode(ch2, INPUT);
  pinMode(ch3, INPUT);
  pinMode(ch4, INPUT);
 
  delay(2000);
}
 
/* Vamos pelo loop passo a passo.
 */
void loop() {

    if(digitalRead(A5)) digitalWrite(led6, HIGH);
  else digitalWrite(led1, LOW);

  if(serial.available()==6){ 
    a=true;   
    aux = char(serial.read());
    data += aux;
    if(aux=='1')b=true;
    else if(aux=='0') b = false;
    else modoJogo=true;//definir a string do desafio

    aux = char(serial.read());
    data += aux;
    if(aux=='1')c=true;
    else if(aux=='0') c = false;
    else modoJogo=true;

    aux = char(serial.read());
    data += aux;
    if(aux=='1')d=true;
    else if(aux=='0') d = false;
    else modoJogo=true;


    aux = char(serial.read());
    data += aux;
    if(aux=='1')f=true;
    else if(aux=='0') f = false;
    else modoJogo=true;

    aux = char(serial.read());
    data += aux;
    if(aux=='1')g=true;
    else if(aux=='0') g = false;
    else modoJogo=true;
    
    aux = char(serial.read());
    data += aux;
    if(aux=='1')h=true;
    else if(aux=='0') h = false;
    else modoJogo=true;
    
    if(digitalRead(ch1==HIGH)) chaves+=1;
    else chaves+=0;

    if(digitalRead(ch2==HIGH)) chaves+=1;
    else chaves+=0;

    if(digitalRead(ch3==HIGH)) chaves+=1;
    else chaves+=0;

    if(digitalRead(ch4==HIGH)) chaves+=1;
    else chaves+=0;

  
  
    

   }




  


  /* No in ício de cada loop, verificamos se há algo no buffer
   *  da nossa serial. Se houver bytes disponíveis, significa 
   *  que o Android enviou algo, então faremos a leitura do 
   *  novo caractere e adicionamos ao final da string data.
   */

 /* while(serial.available() > 0) {
    data += char(serial.read());
    cont++;
    serial.print(cont);
    a=true;
  }*/

 

  //serial.print(String(data));
 
  /* Se o Arduino receber a string "restart" seguida de uma
   *  quebra de linha, reinicializamos o contador e ligamos
   *  o led por um segundo. Esse comando indicará que a 
   *  comunicação no sentido Android -> Arduino está sendo 
   *  realizada corretamente.
   */


 

if(b) digitalWrite(led1, HIGH);
else digitalWrite(led1, LOW);

if(c)digitalWrite(led2, HIGH);
else digitalWrite(led2, LOW);

if(d)digitalWrite(led3, HIGH);
else digitalWrite(led3, LOW);

if(f)digitalWrite(led4, HIGH);
else digitalWrite(led4, LOW);

if(g)digitalWrite(led5, HIGH);
else digitalWrite(led5, LOW);

if(h)digitalWrite(led6, HIGH);
else digitalWrite(led6, LOW);



serial.print((String)data);
serial.print(" \n");
a = false;

   
  /* Finalmente, incrementamos o contador e limpamos data.
   */
     data = "";
 
  /* Um pequeno delay para evitar bugs estranhos.
   */
  delay(10);



}


void desafio(){

  digitalWrite(led1, LOW);
  digitalWrite(led2, LOW);
  digitalWrite(led3, LOW);
  digitalWrite(led4, LOW);
  digitalWrite(led5, LOW);
  digitalWrite(led6, LOW);
  lastButtonState1  = digitalRead(chave1);
  lastButtonState2  = digitalRead(chave2);
  lastButtonState3  = digitalRead(chave3);
  lastButtonState4  = digitalRead(chave4);

while((digitalRead(led1) != HIGH)&&(digitalRead(led2) != HIGH)&&(digitalRead(led3) != HIGH)&&(digitalRead(led4) != HIGH)
&&(digitalRead(led5) != HIGH)&&(digitalRead(led6) != HIGH)){
    
    if(lastButtonState1 != digitalRead(chave1)){
    lastButtonState1  = digitalRead(chave1);
    chave1();
    
    //Passar valores das lampadas para o Android
  
  }
  if(lastButtonState2 != digitalRead(chave2)){
    lastButtonState2  = digitalRead(chave2);
    chave2();
    
    //Passar valores das lampadas para o Android
  
  }
  if(lastButtonState3 != digitalRead(chave3)){
    lastButtonState3  = digitalRead(chave3);
    chave3();
    
    //Passar valores das lampadas para o Android
  
  }
  if(lastButtonState4 != digitalRead(chave4)){
    lastButtonState4  = digitalRead(chave4);
    chave4();
    
    //Passar valores das lampadas para o Android
  
  }
}
  
}

void chave1(){
  //Controla Leds 1,2,3,6
  if(digitalRead(led1) == HIGH){
    digitalWrite(led1, LOW);
  }else{
    digitalWrite(led1, HIGH);
  }
  if(digitalRead(led2) == HIGH){
    digitalWrite(led2, LOW);
  }else{
    digitalWrite(led2, HIGH);
  }
  if(digitalRead(led3) == HIGH){
    digitalWrite(led3, LOW);
  }else{
    digitalWrite(led3, HIGH);
  }
  if(digitalRead(led6) == HIGH){
    digitalWrite(led6, LOW);
  }else{
    digitalWrite(led6, HIGH);
  }
}

void chave2(){
  //Controla Leds 1,2,5,6
  if(digitalRead(led1) == HIGH){
    digitalWrite(led1, LOW);
  }else{
    digitalWrite(led1, HIGH);
  }
  if(digitalRead(led2) == HIGH){
    digitalWrite(led2, LOW);
  }else{
    digitalWrite(led2, HIGH);
  }
  if(digitalRead(led4) == HIGH){
    digitalWrite(led4, LOW);
  }else{
    digitalWrite(led4, HIGH);
  }
  if(digitalRead(led5) == HIGH){
    digitalWrite(led5, LOW);
  }else{
    digitalWrite(led5, HIGH);
  }
}

void chave3(){
   //Controla Leds 3,4,5,6
  if(digitalRead(led3) == HIGH){
    digitalWrite(led3, LOW);
  }else{
    digitalWrite(led3, HIGH);
  }
  if(digitalRead(led4) == HIGH){
    digitalWrite(led4, LOW);
  }else{
    digitalWrite(led4, HIGH);
  }
  if(digitalRead(led6) == HIGH){
    digitalWrite(led6, LOW);
  }else{
    digitalWrite(led6, HIGH);
  }
  if(digitalRead(led5) == HIGH){
    digitalWrite(led5, LOW);
  }else{
    digitalWrite(led5, HIGH);
  }
}

void chave4(){
  //Controla Leds 1,3,5,6
   if(digitalRead(led3) == HIGH){
    digitalWrite(led3, LOW);
  }else{
    digitalWrite(led3, HIGH);
  }
  if(digitalRead(led1) == HIGH){
    digitalWrite(led1, LOW);
  }else{
    digitalWrite(led1, HIGH);
  }
  if(digitalRead(led6) == HIGH){
    digitalWrite(led6, LOW);
  }else{
    digitalWrite(led6, HIGH);
  }
  if(digitalRead(led5) == HIGH){
    digitalWrite(led5, LOW);
  }else{
    digitalWrite(led5, HIGH);
  }
}




