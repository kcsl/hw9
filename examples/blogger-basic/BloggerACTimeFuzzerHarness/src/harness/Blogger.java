package harness;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import harness.utils.Utils;

public class Blogger {

	public static void main(String[] args) {
		try {
			String filename = args[0];
			String input = "";
			try {
				Scanner scanner = new Scanner(new File(filename));
				if(scanner.hasNextLine()) {
					input = scanner.nextLine();
				}
			} catch (Exception e) {
				System.out.println("Error reading file.");
				return;
			}
			
			try {
				Utils.executeCommandLine("curl -i http://localhost:8080/" + input, true, true, 20000);
			} catch (IOException e) {
				System.out.println("Error executing shell command...");
				e.printStackTrace();
			} catch (TimeoutException t) {
				System.out.println("Timed out...");
				throw new RuntimeException("Timeout!");
			}
		} catch (InterruptedException ie) {
			System.out.println("Interrupted...");
		}
	}

}
