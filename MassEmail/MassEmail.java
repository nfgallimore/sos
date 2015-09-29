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
	//	String fromAddress = "rubyrodriguez@studentsofstrength.com";
	try {
	    String line = "";
	    fileReader = new BufferedReader(new FileReader(filename)); 
	    while ((line = fileReader.readLine()) != null) {
		String[] tokens = line.split(DELIMITER);
		for (int i = 0; i < tokens.length; i+=4) {
		    String fname = tokens[i];
		    String lname = tokens[i+1];
		    String address = "\"" + tokens[i+2] + "\"";
		    String state = tokens[i+3];
		    //	    String messageRuby = "\"Hi " + fname + ",\n\nMy name is Ruby Rodriguez, Chief Human Resources Officer for Students of Strength.  Here at Students of Strength we empower students in need with the tools they need to succeed, and we do this in two ways.\nFirstly, we have developed a robust and expansive curriculum for grades 6-12 - Language Arts and Social Studies, STEM, College Advising and Test Prep, and Social Skills/Character Building. The innovative character building course teaches students how to develop the soft skills necessary for succeeding in higher education, these skills are:\n\n· Networking\n· The importance of honesty\n· Communicating responsibly\n· Handling negative criticism\n· Time management\n\nThese curriculums are designed for students by students with direction from leading educational scholars from Harvard Ed School and experienced teachers, and it will prove to be an indispensable contribution to your students’ success!\nSecondly, we match your students with top university scholars from Harvard, Yale, Princeton, Stanford, MIT, Rice, and the University of Texas. We do this through a state of the art interactive platform that is available across devices. Our tutors are carefully screened and trained and are not so far removed from the experience of middle and high school themselves. This creates a dynamic relationship where our tutors relate better to students and are able to become both academic mentors and college advisors. They have all already navigated both high school and the college application process with great success and they are available 24/7 to help your students to do the same and to offer support when it is needed most. \n\nAs an advisor to your students I know how invested you are in their academic achievement and successful college admissions.  Our scholars are trained test prep tutors and have valuable insight into navigating the college application process that will help to make your students’ dreams a reality!  We already have 90,000 students in the Houston Independent School District, all of New Mexico, and all of LA unified schools, and many other school districts spread across the United States. We are also working with partnering with the University of Arkansas and we have already partnered with West Point US Military Academy! We have researched your school in particular and feel as though it would be a perfect fit for our program. We would also like to reach out to your school to not only aid your students, but to help us reach out to all schools in " + state + " and get them on board as we have with other areas.\n\nCheck out our website at studentsofstrength.com to learn more about our partners, sponsors, and all of our philanthropic services we offer! Let’s partner together to promote " + state + "'s students’ academic achievement. Contact me with your questions at the e-mail or number listed below. I look forward to working with you!\n\nThank you,\nRuby Rodriguez\nChief Human Resources Officer, Students of Strength\n" + fromAddress + "\"";
		    String message = "\"Hello " + fname + ",\n\nRahsaan King here.  Just checking in to let you know that my team and I have amassed the fastest growing network of Ivy League and Top Tier student leaders mentoring and tutoring youth grades 6th-12th. We connect thousands of students online and via our mobile app to help with core subjects, college apps, exam prep etc 24/7.\n\nI will be messaging you later this week to announce the Launch of our Indegogo campaign to sponsor 5k inner city youth.\n\nIn the meantime check out our website studentsofstrength.com and email \"SOS ME NOW\" to dgonzalez@studentsofstrength.com for a free hour of tutoring for up to 3 of your favorite friends and students\n\nCEO & Founder\"";
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
