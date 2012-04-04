package com.epita.mti.plic.opensource.controlibclientsample;

import com.epita.mti.plic.opensource.controlibutility.beans.CLPressure;
import com.epita.mti.plic.opensource.controlibutility.serialization.ObjectSender;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App
{

  public static void main(String[] args) throws Exception
  {
    Socket socket = new Socket("127.0.0.1", 4200);
    ObjectSender sender = new ObjectSender(socket.getOutputStream());

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String s;
    while ((s = in.readLine()) != null && s.length() != 0)
    {
      CLPressure data = new CLPressure();
      String[] pair = s.split(";");
      
      data.setX(Integer.parseInt(pair[0]));
      data.setY(Integer.parseInt(pair[1]));
      sender.send(data);
    }
  }
}
