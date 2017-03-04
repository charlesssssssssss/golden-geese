/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;


/**
 *
 * @author atamarkin2
 */

public class ExchangeClient
{

	/**
	 * @param args
	 *            the command line arguments
	 * @throws java.io.IOException
	 */
	public static void main(String[] args) throws IOException
	{
		System.out.println(minDistance(5000, 5000, 0, 0));
		if (args.length < 5)
		{
			System.out.println("Usage: \nclientTask <host> <port> <user> <password> <command...>");
		}

		Socket socket = null;

		socket = new Socket("localhost", 17429);
		final PrintWriter pout = new PrintWriter(socket.getOutputStream());
		final BufferedReader bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// pout.println("GoldenGeese" + " " + "EyebrowGoose");
		// pout.flush();
		//
		// for (int i = 4; i < args.length; i++) {
		// pout.println(args[i]);
		// }

		// pout.flush();

		Scanner kbd = new Scanner(System.in);

		pout.println("d d");
		pout.flush();

	
		while (true)
		{
			String line = kbd.nextLine();
		
			if (line.equals("exit"))
				break;

			pout.println(line);
			pout.flush();
			
			line = bin.readLine();
			System.out.println(line);
			
			try
			{
				Thread.sleep(20);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		pout.println("CLOSE_CONNECTION");
		pout.close();
		bin.close();

	}
	
	public static double angleToMine (double pos_x, double pos_y, double mine_x, double mine_y)
	{
		return Math.atan((mine_y - pos_y)/(mine_x - pos_x));
	}
	
	public static double minDistance (double start_x, double start_y, double end_x, double end_y)
	{
		double distance1 = Math.sqrt(Math.pow(end_y-start_y, 2) + Math.pow (end_x-start_x, 2));
		double distance2 = Math.sqrt(Math.pow(end_y-start_y, 2) + Math.pow (end_x-start_x, 2));
		return Math.min(distance1, distance2); 
		
	}
	
	
}
