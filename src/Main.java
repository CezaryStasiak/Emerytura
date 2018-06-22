import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		Emerytura(new File("dane.txt"));
	}
	
	public static void Emerytura(File plik){
		
		String line;
		String[] data = new String[4];
		
		try {
			
			Scanner in = new Scanner(plik);
			PrintWriter writeM = new PrintWriter("mezczyzni.bin");
			PrintWriter writeK = new PrintWriter("kobiety.bin");
			
			while (in.hasNextLine()) {
				
			line = in.nextLine();
			data = line.split("-");
			
			if (data[2].matches("M")) {
				writeM.println(data[1]);
				writeM.println((67-Integer.parseInt(data[3]))*12);
			}
			
			if (data[2].matches("K")) {
				writeK.println(data[1]);
				writeK.println((65-Integer.parseInt(data[3]))*12);
			}
		
			}
			in.close();
			writeM.close();
			writeK.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Podany plik nie zostal znaleziony");
		}
		
}
}
