//Base is assumed as 2 since we are working with 32 bit integers and parameters which are smaller than 143 there is no way 
//we can overflow

public class hashTrials {
	
	public static int hash (String str,int prevVal,String prevFirstVal)
	{
		String toHash [] = str.split(",");
		int result=0;
		
		if(prevVal==0)
		{
			
			for (int i = toHash.length-1 ; i >=0 ; i--) {
				result += (Integer.parseInt(toHash[i]))  * (Math.pow(2, 9-i));
			}
		}
		
		else
		{
			int prevIntVal=Integer.parseInt(prevFirstVal);
			result=(int) ( (prevVal -(prevIntVal*(Math.pow(2, 9)) ) ) *2 ) + (Integer.parseInt(toHash[toHash.length-1])) 	;
			
		}
		return result;
	}
	
	
	
}