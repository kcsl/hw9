package harness;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import harness.utils.Utils;

public class TextCrunchr2 {

	private static final long TIMEOUT = 300000;

	public static void main(String args[]) {
		try {
			String filename = args[0];
			String command = new File("scripts" + File.separator + "challenge.sh").getAbsolutePath() + " ";
			try {
				Utils.executeCommandLine(command + args[0], false, false, TIMEOUT);
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
