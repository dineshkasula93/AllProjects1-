package com.Bellinfo.Example;

	import java.lang.StringBuffer;
	import java.util.HashMap;
	public class Strings {

		public static void main(String[] args) {
			// no. of words
			String s = "This is a java class";
			int c= s.trim().split(" ").length;
			System.out.println("no. of words:"  +c);
	        //length of a string
			int l= s.length();
	        System.out.println("length of the string:" +l);
	       // reverse entire string
	        String r = new StringBuffer(s).reverse().toString();
	        System.out.println(r);
	        //replacing java with SQL
	        System.out.println(s.replace("java", "SQL"));
	       // changed to uppercase
	        String su = s.toUpperCase();
	        System.out.println("Changed to uppercase:" + su);
	        // reverse each word in a string
	        StringBuilder sa = new StringBuilder(s);
	        String[] words = s.split(" ");
	        int i = 0;
	        for (String word : words) {
	            words[i] = (new StringBuilder(word)).reverse().toString();
	            i++;
	        }
	        System.out.print("rev = ");
	        for (String word: words) {
	            sa.append(new StringBuilder(word).toString());
	            sa.append(" ");
	        }

	        String rev = sa.toString();
	        System.out.println(rev);
	        // no. of occurances
	        String count="";
	        StringBuilder sb = new StringBuilder(s);
	        while(sb.length() != 0){
	            int ct = 0;
	            char test = sb.charAt(0);
	            while(sb.indexOf(test+"") != -1){
	                sb.deleteCharAt(sb.indexOf(test+""));
	                ct++;
	            }
	            //System.out.println(test+" is repeated "+count+" number of times");
	            count=count+test+ct;
	        }
	        System.out.println(count);    
	        // not repeated
	        char rpt=NonRepeated(s);
	        System.out.println("Non-Repeated Character :  " + rpt);
		}
	public static Character NonRepeated(String str){
		HashMap<Character,Integer>  chhashtable=  new HashMap<Character ,Integer>();
	int i,length ;
	Character rpt ;
	length= str.length();  
	for (i=0;i < length;i++)
	{
	   rpt=str.charAt(i);
	   if(chhashtable.containsKey(rpt))
	   {
	       chhashtable.put(  rpt ,  chhashtable.get(rpt) +1 );
	   }
	   else
	   {
	       chhashtable.put( rpt , 1 ) ;
	   }
	}
	for (i =0 ; i < length ; i++ )
	{
	   rpt= str.charAt(i);
	   if( chhashtable.get(rpt)  == 1 )
	   return rpt;
	}
	return null ;
	}
	} 

