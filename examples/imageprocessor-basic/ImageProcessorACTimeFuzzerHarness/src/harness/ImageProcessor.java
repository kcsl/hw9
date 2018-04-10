package harness;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import harness.utils.Utils;

public class ImageProcessor {

	private static final String clean = "clean";
	private static final String initialize = "default-tags";
	private static final String classify = "classify";
	private static final long timeout = 100000;

	public static void main(String args[]) {
		try {
//			String filename = args[0];
			String filename = "classification_images/blue.jpg";
			
			File script = new File("challenge.sh");
			String command = script.getAbsolutePath() + " ";
			try {
				Utils.executeCommandLine(command + clean, false, false, timeout);
				Utils.executeCommandLine(command + initialize, false, false, timeout);
				Utils.executeCommandLine(command + classify + filename, false, false, timeout);
			}  catch (IOException e) {
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
