import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{
	public static String Line=" ";
	//create reader method
	public static void Reader()
	{
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.FILE_NAME)));
			Line = bufferedReader.readLine();
		}
		catch (Exception e)
		{

		}
	}
	//create writer method
	public static void Writer(String t, String fd)
	{
		try
		{
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(Constants.FILE_NAME, true));
			bufferedWriter.write(Constants.SPILT+t+Constants.LAST_UPDATE_MESSAGE+fd);
			bufferedWriter.close();
		}
		catch (Exception e)
		{

		}
	}
	public static void main(String[] args)
	{

//  Check arguments
		if(args[0].equals(Constants.ALL))
		{
			System.out.println(Constants.LOADING_DATA);
			//calling reader method
			Reader();
			String students[] = Line.split(Constants.SPILT);
			for(String student : students)
			{
				System.out.println(student);
			}

			System.out.println(Constants.LOADED_DATA);
		}
		else if(args[0].equals(Constants.RANDOM))
		{
			System.out.println(Constants.LOADING_DATA);
			//calling reader method
			Reader();

			//System.out.println(Line);
			String students[] = Line.split(Constants.SPILT);
			Random x = new Random();
			int y = x.nextInt(Constants.BOUND);
			System.out.println(students[y]);
			//change random variable

			System.out.println(Constants.LOADED_DATA);
		}
		else if(args[0].contains(Constants.ADD))
		{
			System.out.println(Constants.LOADING_DATA);
			//Writer(t,fd);
			String t = args[0].substring(1);
			Date d = new Date();
			String df = Constants.DATE_FORMAT;
			DateFormat dateFormat = new SimpleDateFormat(df);
			String fd= dateFormat.format(d);
//calling writer method
			Writer(t,fd);

			System.out.println(Constants.LOADED_DATA);
		}
		else if(args[0].contains(Constants.QUERY))
		{
			System.out.println(Constants.LOADING_DATA);
			//calling reader
			Reader();
			String students[] = Line.split(Constants.SPILT);
			//done variable eliminate
			//boolean done = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<students.length ; idx++)
			{
				if(students[idx].equals(t))
				{
					System.out.println(Constants.FOUND_MESSAGE);
					//done=true;
				}
			}

			System.out.println(Constants.LOADED_DATA);
		}
		else if(args[0].contains(Constants.COUNT))
		{
			System.out.println(Constants.LOADING_DATA);
			Reader();//not necessary
			//String D = bufferedReader.readLine();
			char a[] = Line.toCharArray();
			//boolean in_word = false;
			//count simplify
			int count=0;
			for(char ch:a)
			{
				if(ch ==Constants.GAP)
				{
					count++;
				}
			}
			System.out.println(count/2 + Constants.WORD_FOUND + a.length);

			System.out.println(Constants.LOADED_DATA);
		}
		else
			//pass invalid argument
			System.out.println(Constants.INVALID);
	}
}
