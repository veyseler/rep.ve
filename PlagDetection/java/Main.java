import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;



public class Main {

	public static void print  (ArrayList<ArrayList <Integer>> windows) throws Exception
	{
		int rows=windows.size();
		int cols=windows.get(0).size();
		FileWriter writer=new FileWriter ("001-Short.txt");
		BufferedWriter bw=new BufferedWriter (writer);
		
		
		for (int i = 0; i < rows; i++) {
			bw.write("(");
			for (int j = 0; j < cols; j++) {
				if(j!= cols-1)
					bw.write(windows.get(i).get(j) + ", " );
				else
					bw.write(windows.get(i).get(j)  );
			}
		
			bw.write(")\n");
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileReader read=new FileReader("001.txt");
		BufferedReader bRead = new BufferedReader(read);
		
		String tokens=bRead.readLine();
		String tokensArr[] =tokens.split(",");
		ArrayList<String> k_grams =new ArrayList<String>() ;
		
		bRead.close();
		//Putting k grams in to an ArrayList
		int tokenLen=tokensArr.length;
		
		for(int i=0;i<=tokenLen-10;i++)
		{
			String k_gram="";
			StringBuilder builder=new StringBuilder(k_gram);
			for (int j = i; j < i+10; j++) {
				builder.append(tokensArr[j]);  //a k- gram will look like 2,22,23 where k=3
				
				builder.append(",");
			}
			builder.deleteCharAt(builder.length()-1);
			k_grams.add(builder.toString());
		}
		
		ArrayList<ArrayList <Integer>> windows=new ArrayList<ArrayList <Integer>> ();
		
		int prevVal=0;
		String prevFirstVal="";
		boolean isFinished=false;
		for(int i=0;!isFinished && i<=k_grams.size();i++)
		{
			ArrayList<Integer> window =new ArrayList<>();
			for (int j = i; !isFinished && j < i+10; j++) {
				
			
				int hashed=(hashTrials.hash(k_grams.get(j), prevVal, prevFirstVal));
				window.add(hashed);
				prevFirstVal=k_grams.get(j).substring(0,
														k_grams.get(j).indexOf(','));
				prevVal=hashed;
				
				if(j==k_grams.size()-1)
				{
					isFinished=true;
					
					
				}
			}
			windows.add(window);
			
		}
		
		print(windows);
		
	
	
	}

}
