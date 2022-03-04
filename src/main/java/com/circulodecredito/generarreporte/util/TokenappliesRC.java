package com.circulodecredito.generarreporte.util;

/**
 * @author Carlos
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TokenappliesRC {

	public TokenappliesRC() {
		super();
	}

	public String CutToken(String varone)
	{
		int count=varone.length();
		
		String strng="";
		for(int i=0;i<count;i++){
			String vartwo=String.valueOf(varone.charAt(i));
			if(vartwo.equals(" "))
				return varone;
		}
		
		if(count>12){
			int newcount=count/2;
			String vartwo=String.valueOf(varone.charAt(newcount));
			if(vartwo.equals("A")||vartwo.equals("E")||vartwo.equals("I")||vartwo.equals("O")||vartwo.equals("U")){
				for(int i=0;i<count;i++){
					if(i+1==newcount) 
						strng+=" ";
					strng+=String.valueOf(varone.charAt(i));
				}
				return	strng;
			}
			
			vartwo=String.valueOf(varone.charAt(++newcount));
			if(vartwo.equals("A")||vartwo.equals("E")||vartwo.equals("I")||vartwo.equals("O")||vartwo.equals("U")){
				for(int i=0;i<count;i++){
					if(i+1==newcount) 
						strng+=" ";
					strng+=String.valueOf(varone.charAt(i));
				}
 				return	strng;
			}
			
			vartwo=String.valueOf(varone.charAt(++newcount));
			if(vartwo.equals("A")||vartwo.equals("E")||vartwo.equals("I")||vartwo.equals("O")||vartwo.equals("U")){
				for(int i=0;i<count;i++){
					if(i+1==newcount) 
						strng+=" ";
					strng+=String.valueOf(varone.charAt(i));
				}
				return	strng;
			}
		
		}
		else{
			return varone;
		}
		
		
		if(strng.equals(""))
			return varone;
		else
			return strng;
	}

	
	public String CutTokenNumbers(String varone)
	{
		int count=varone.length();
		String strng="";
		for(int i=0;i<count;i++){
			String vartwo=String.valueOf(varone.charAt(i));
			if(vartwo.equals(" "))
				return varone;
		}
	
		if(count>12){
			int newcount=count/2;
			for(int i=0;i<count;i++){
					if(i==newcount) 
						strng+=" ";
					strng+=String.valueOf(varone.charAt(i));
				}
				return	strng;
			}
		if(strng.equals(""))
			return varone;
		else
			return strng;
	}
}
