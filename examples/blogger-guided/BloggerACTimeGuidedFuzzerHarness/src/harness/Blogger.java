package harness;

import java.io.File;
import java.util.Scanner;

import fi.iki.elonen.URIVerifier;

public class Blogger {

	public static void main(String[] args) {
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
			String uri = input;
			String httpPrefix = "http://";
			if(uri.startsWith(httpPrefix)) {
				uri = uri.substring(httpPrefix.length());
			}
			String httpsPrefix = "https://";
			if(uri.startsWith(httpsPrefix)) {
				uri = uri.substring(httpsPrefix.length());
			}
			if(uri.startsWith("/")) {
				uri = uri.substring(1);
			}
			uri = uri.replaceAll("/", ".");
			new URIVerifier().verify(input);
		} catch (Exception e) {
			e.printStackTrace();
			// don't treat a crash as a crash
		}
	}
	
}
