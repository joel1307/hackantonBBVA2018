#include <SoftwareSerial.h>

SoftwareSerial SIM900(7, 8); // Configura el puerto serial para el SIM900
//String numero = "5572938972";
String numero = "";
int input = 0;

void setup()
{
  SIM900.begin(19200); //Configura velocidad del puerto serie para el SIM900
  
  Serial.begin(9600); //Configura velocidad del puerto serie del Arduino
  Serial.println("OK");
  delay (500);
  
  SIM900.println("AT+CPIN=\"1867\""); //Comando AT para introducir el PIN de la tarjeta
  delay(200); //Tiempo para que encuentre una RED
}

void mensaje_sms()
{
  Serial.println("Enviando SMS...");
  SIM900.print("AT+CMGF=1\r"); //Comando AT para mandar un SMS
  delay(200);
  //SIM900.println("AT+CMGS=\"5572938972\""); //Numero al que vamos a enviar el mensaje
  SIM900.println("AT+CMGS=\"" + numero + "\""); //Numero al que vamos a enviar el mensaje
  delay(200);
  SIM900.println("Hey! ");// Texto del SMS
  delay(50);
  SIM900.println((char)26);//Comando de finalizacion ^Z
  delay(50);
  SIM900.println();
  delay(2000); // Esperamos un tiempo para que envíe el SMS
  Serial.println("SMS enviado");
}

void loop()
{
  
  if(Serial.available() > 0){
      input = Serial.read();
      numero = input;
      mensaje_sms(); //Envia SMS
      while (1); // Espera por tiempo indefinido
  }

}
