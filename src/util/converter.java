package util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class converter {
	  
	    public BigDecimal stringToBigdecimal( String string) {
	        if (string == null || "".equals(string)) {
	            return BigDecimal.ZERO;
	        }
	        //10,00 ~> 10.00 --- 1.000,00 ~> 1000.00
	        String valor = string.replace(".", "").replace(",", ".");
	        return new BigDecimal(valor);
	    }

	   
	    public String bigdecimalToString(BigDecimal o) {
	        
	            BigDecimal bd = (BigDecimal) o;
	            //10.00 ~> 10,00 --- 1000.00 ~> 1.000,00
	            return new DecimalFormat("#,##0.00").format(bd);
	       
	    }
}
