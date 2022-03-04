package com.circulodecredito.generarreporte.util;

import java.sql.Date;
import java.util.Calendar;

public class FechaFormatRC {


	Date hora_actual=null;
	int numday;
	int month;
	int year;
	String dia ="";
	String mes ="";
	int an;
	String fecha="";

	public FechaFormatRC() { super(); }

	public String init_fecha(String dato)
	{
	    Calendar cal=Calendar.getInstance();
	    cal.setTime( Date.valueOf(dato ));
		numday = cal.get( Calendar.DAY_OF_MONTH );
		month = cal.get( Calendar.MONTH );
		year = cal.get( Calendar.YEAR );

		an = year;

		String temp=null;
		temp=Integer.toString(an);
		String copia=null;
		copia=temp.substring(2,4);

		if(month == 0)
		{	mes = "ENE";   }

		if(month == 1)
		{	mes = "FEB";   }

		if(month == 2)
		{	mes = "MAR";   }

		if(month == 3)
		{	mes = "ABR";   }

		if(month == 4)
		{	mes = "MAY";   }

		if(month == 5)
		{	mes = "JUN";   }

		if(month == 6)
		{	mes = "JUL";   }

		if(month == 7)
		{	mes = "AGO";   }

		if(month == 8)
		{	mes = "SEP";   }

		if(month == 9)
		{	mes = "OCT";   }

		if(month == 10)
		{	mes = "NOV";   }

		if(month == 11)
		{	mes = "DIC";   }

		if ( numday >= 1 && numday < 10) {
			fecha = "0"+numday+"/"+mes+"/"+copia;
		} else {
			fecha = numday+"/"+mes+"/"+copia;
		}
		return fecha;
	}


}

