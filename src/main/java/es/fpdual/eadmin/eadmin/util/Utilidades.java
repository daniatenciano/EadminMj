package es.fpdual.eadmin.eadmin.util;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.*;

public class Utilidades {
	
	public static Date asDate(LocalDate localdate) {
		return Date.from(localdate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

}
