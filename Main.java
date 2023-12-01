import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

public class Main{
	
	public static void main(String args[]) {

	

	String [] start   = {"sudo","systemctl","start","ssh"};	
	String [] enable  = {"sudo","systemctl","enable","ssh"};
	String [] stop    = {"sudo","systemctl","stop","ssh"};
	String [] status  = {"sudo","systemctl","status","ssh"};
	
loop : while(true){
	try{
	
		File f = new File("new.txt");
		ProcessBuilder pb = new ProcessBuilder(status);
		pb.redirectOutput(f);
		pb.start().waitFor();
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<String> lines = new ArrayList<>();
		String line ;
		int i = 0;
		while ((line = br.readLine()) != null)
		{	
			lines.add(line);
			i++;
			if(i == 3)
				break;
		}		
		
		if (lines.get(2).contains(" active"))
			System.out.println(Colors.GREEN + "the ssh is ON ." + Colors.RESET);
		if (lines.get(2).contains("inactive"))
			System.out.println(Colors.RED + "the ssh is OFF ." + Colors.RESET);
				
		}catch(Exception  e){}
	
		try{
			System.out.println("chose 1 to enable the ssh service.");
			System.out.println("chose 2 to stop  the ssh service.");
			System.out.println("chose 3 to quit.");
			
			int c  = new Scanner(System.in).nextInt();
			
			
				if(c==1)	
				{

					ProcessBuilder pb = new ProcessBuilder(start);
					Process pr = pb.start();
					pr.waitFor();
					pb  = new ProcessBuilder(enable);
					pr  = pb.start();
					pr.waitFor();
					
				} 	
			 	else if (c== 2) 
				{
					ProcessBuilder pb = new ProcessBuilder(stop);
				       	Process pr = pb.start();
					pr.waitFor();
				}
				else if (c== 3) 
					break loop;
		 }catch(Exception e){

		 }
	 }
							
	}
}
