import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
	public static String Line="";
	public static void Reader(){
	try {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(Constants.fileName)));
		String Line = bufferedReader.readLine();
	}
	catch (Exception e) {

	}

	}
	public static void Write(String t, String fd){
		try
		{
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(Constants.fileName, true));
			bufferedWriter.write(Constants.split +t+Constants.lastUpdate+fd);
			bufferedWriter.close();
		}
		catch (Exception e)
		{

		}
	}

	public static void main(String[] args)
	{

//		Check arguments
		if(args[0].equals(Constants.showNames))
		{
			System.out.println(Constants.loadingData);
			Reader();
			String students[] = Line.split(",");
			for(String student : students)
			{
				System.out.println(student);
			}

			System.out.println(Constants.loadedData);
		}
		else if(args[0].equals(Constants.randomName))
		{
			System.out.println(Constants.loadingData);

			//System.out.println(r);
			String students[] = Line.split(Constants.split);
			Random x = new Random();
				int y = x.nextInt(4);
					System.out.println(students[y]);

			System.out.println(Constants.loadedData);
		}
		else if(args[0].contains(Constants.addName))
		{
			System.out.println(Constants.loadingData);
			String t = args[0].substring(1);
	        Date d = new Date();
	        String df = Constants.dateFormat;
	        DateFormat dateFormat = new SimpleDateFormat(df);
	        String fd= dateFormat.format(d);
			Write(t,fd);


							
			System.out.println(Constants.loadedData);
		}
		else if(args[0].contains(Constants.query))
		{
			System.out.println(Constants.loadingData);
			Reader();
			String students[] = Line.split(Constants.split);
			//boolean done = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<students.length ; idx++) {
				if(students[idx].equals(t))

				{
					System.out.println(Constants.found);
					break;
						//done=true;
				}
			}

			System.out.println(Constants.loadedData);
		}
		else if(args[0].contains(Constants.CountWords))
		{
			System.out.println(Constants.loadingData);
			Reader();
			char students[] = Line.toCharArray();
			//boolean in_word = false;
			int count=0;
			for(char ch:students)
			{
				if(ch ==' ')
				{
					count++;
				}
			}
			System.out.println(count +Constants.wordsFound + Line);

			System.out.println(Constants.loadedData);
		}
		else
		{
			System.out.println("nothing else");
		}
	}
}