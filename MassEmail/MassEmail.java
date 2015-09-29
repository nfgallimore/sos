import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class MassEmail
{
    public static void main (String[] args) {
	String filename = "data.csv";
	BufferedReader fileReader = null;
	final String DELIMITER = ",";
	String subject = "\"Academic Coaches\"";
	String fromAddress = "rubyrodriguez@studentsofstrength.com";
	try {
	    String line = "";
	    fileReader = new BufferedReader(new FileReader(filename)); 
	    while ((line = fileReader.readLine()) != null) {
		String[] tokens = line.split(DELIMITER);
		for (int i = 0; i < tokens.length; i+=4) {
		    String fname = tokens[i];
		    String lname = tokens[i+1];
		    String address = " \"" + tokens[i+2] + "\"";
		    String state = tokens[i+3];
		    String message = "\"Howdy " + fname + "!\n\nRahsaan King here. Just checking in to let you know that my team and I have amassed the fastest growing network of Ivy League and Top Tier student leaders mentoring and tutoring youth grades 6th-12th. We connect thousands of students online and via our mobile app to help with core subjects, college apps, exam prep etc 24/7.\n\nI will be messaging you later this week to announce the Launch of our Indegogo campaign to sponsor 5k inner city youth.\n\nIn the meantime check out our website studentsofstrength.com and email \"SOS ME NOW\" to dgonzalez@studentsofstrength.com  for a free hour of tutoring for up to 3 of your favorite friends and students.\n\n--\nRahsaan King\nCEO & Founder\nStudents of Strength\nstudentsofstrength.com\"";
		    Process proc = null;
		    try {
			String command = "echo " + message + " |mailx -s " + subject + " " + address;
			proc = Runtime.getRuntime().exec(new String[] { "/bin/sh", "-c", command });
			if (proc != null) {
			    proc.waitFor();
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		} 
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		fileReader.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
}
