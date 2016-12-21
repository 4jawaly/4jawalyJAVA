/**********************************************************************************************/
/**********************************************************************************************/
/************                               OperationNumber                        ************/
/************                               ---------------                        ************/
/************         1.Send SMS                                                   ************/
/************		  2.Send Status	                   							   ************/
/************ 		  3.ChangePassword											   ************/
/************		  4.ForgetPassword											   ************/
/************ 		  5.Balance                                                    ************/
/************ 		  6.Active Sender                                              ************/
/************ 		  7.Check Sender                                               ************/
/************ 		  8.Add Sender                                                 ************/
/**********************************************************************************************/
/**********************************************************************************************/

package mobily.sms.java;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
public class Jawaly {
	private String msg="";
	private String msgb="";
	private String balance="";
	static char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

//Send SMS Method
//userName : ÇÓã ÇáãÓÊÎÏã ãä İæÑÌæÇáì
//password : ÇáÈÇÓæÑÏ  ãä İæÑÌæÇáì

//sender : ÇÓã ÇáãÑÓá ÇáĞí ÓíÙåÑ ÚäÏ ÇÑÓÇá ÇáÑÓÇáå

//message : 							SendSMS ÇÑÓÇá ÇáÑÓÇáå ÈÕíÛÉ ÇáíæäíßæÏ íÊã ÊÍæíá ÇáÑÓÇáÉ ÏÇÎá ÇáİäßÔä 
/*										ÇáÑÓÇáå ÇáÚÑÈíå  70 ÍÑİ
										ÇáÑÓÇáå ÇáÇäÌáíÒíå 160 ÍÑİ
										İí ÍÇá ÇÑÓÇá ÇßËÑ ãä ÑÓÇáå ÚÑÈíå İÇä ÇáÑÓÇáå ÇáæÇÍÏå ÊÍÓÈ 67
										æÇáÑÓÇáå ÇáÇäÌáíÒí 158
*/

//numbers : 							íÌÈ ßÊÇÈÉ ÇáÑŞã ÈÇáÕíÛÉ ÇáÏæáíÉ ãËá 96650555555 æÚäÏ ÇáÅÑÓÇá Åáì ÃßËÑ ãä ÑŞã íÌÈ æÖÚ ÇáİÇÕáÉ (,) æåí ÇáÊí ÚäÏ ÍÑİ ÇáæÇæ Èíä ßá ÑŞãíä 

// ááÅØáÇÚ Úáì  äÊÇÆÌ ÇáÈæÇÈÉ ¡ íÑÌì ÇáÑÌæÚ Åáì ãáİ ÅŞÑÇäí ÇáãæÌæÏ ãÚ ÇáãáİÇÊ
	public void sendMessage(String username,String password,String numbers,String message,String sender) throws UnsupportedEncodingException{
     
		String message1=URLEncoder.encode(message, "UTF-8");
        System.out.println(message1);
		    String para ="username="+username+"&password="+password+"&message="+message1+"&numbers="+numbers+"&sender="+sender+"&unicode=e";
		   
	        sendURL("http://www.4jawaly.net/api/sendsms.php?",para,1);
	        
	}




//check balance method
//userName : ÇÓã ÇáãÓÊÎÏã áÍÓÇÈß İí ãæŞÚ İæÑÌæÇáì
//password : ßáãÉ ÇáãÑæÑ áÍÓÇÈß İí ãæŞÚ İæÑÌæÇáì
// ááÅØáÇÚ Úáì  äÊÇÆÌ ÇáÈæÇÈÉ ¡ íÑÌì ÇáÑÌæÚ Åáì ãáİ ÅŞÑÇäí ÇáãæÌæÏ ãÚ ÇáãáİÇÊ
	public String checkBalance(String userName,String password){
		String para="username="+userName+"&password="+password;//+"&hangedBalance=true";
		sendURL("http://www.4jawaly.net/api/getbalance.php?",para,2);
		return balance;
	}
	
	
public void AddSender (String username,String password,String sendername){
	String para="return=full"+"&username="+username+"&password="+password+"&Sendername="+sendername;
	System.out.println(username);
	sendURL("http://www.4jawaly.net/apiSjawaly/addSender.php?",para,3);
}

	public void ActiveSender(String username,String password,String sendername,String activeCode){
		String para="return=full"+"&username="+username+"&password="+password+"&sender_name="+sendername+"&Activecode="+activeCode;
		sendURL("http://www.4jawaly.net/apiSjawaly/ActiveSendername.php?",para,4);
	}


	public String getMessage(){
		return msg;
	}
	
	public String getMessageb(){
		return msgb;
	}
	//**********************************************************************************************//
	//*********************************							************************************//
	//*********************************conver to unicode Methods************************************//
	//********************************* 						************************************//
	//**********************************************************************************************//
	
	public static String convertUnicode(String str) {
        char[] chars = str.toCharArray();
        StringBuffer strBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            strBuffer.append(forDigits( Integer.toHexString((int) chars[i])));
        }
        return strBuffer.toString();
    }
        public static String bytesToHex(byte[] b, int off, int len) {
		StringBuffer buf = new StringBuffer();
		for (int j=0; j<len; j++)
			buf.append(byteToHex(b[off+j]));
			return buf.toString();
	}
	public static String byteToHex(byte b) {
		char[] a = { hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f] };
		return forDigits(new String(a));
	}
	public static String forDigits(String val){
		switch (val.length() ){
			case 1:return "000"+val;
			case 2:return "00"+val;
			case 3:return "0"+val;
			case 4:return ""+val;
			default:return val;
		}
	}
	//**********************************************************************************************//
	//**********************************************************************************************//
	//**********************************************************************************************//
	public void selectedMessage(int value,int operationNumber){
		
		System.out.println(value +" "+operationNumber);
		switch(operationNumber){
			case 1:switch(value){
			   case 100:msg= "Êã ÇÓÊáÇã ÇáÇÑŞÇã ÈäÌÇÍ";break;
			   case 101:msg= "ÇáÈíÇäÇÊ äÇŞÕÉ";break;
	           case 102:msg= "ÇÓã ÇáãÓÊÎÏã ÛíÑ ÕÍíÍ";break;
	           case 103:msg="ßáãÉ ÇáãÑæÑ ÛíÑ ÕÍíÍå";break;
	           case 104:msg="ÎØÇ İì ŞÇÚÏÉ ÇáÈíÇäÇÊ";break;
	           case 105:msg="áÇ íæÌÏ ÑÕíÏ İì ÇáÍÓÇÈ";break;
	           case 106:msg= "ÇÓã ÇáãÑÓá ÎØÇ";break;
	           case 107:msg= "ÇÓã ÇáãÑÓá ãæŞæİ";break;
	           case 108:msg="áÇ ÊæÌÏ ÇÑŞÇã ÕÍíÍå ááÇÑÓÇá";break;
	           case 109:msg="áÇ ÊÓÊØíÚ ÇÑÓÇá ÇßËÑ ãä 8 ãŞÇØÚ İì ÇáÑÓÇáå";break;
	           case 110:msg="ÎØÇ İì ÍİÙ äÊÇÆÌ ÇáÇÑÓÇá";break;
	           case 111:msg="ÇáÇÑÓÇá ãÛáŞ";break;
	           case 112:msg= "ÇáÑÓÇáÉ ÊÍÊæì Úáì ßáãÇÊ ãÍÙæÑå";break;
	           case 113:msg= "ÇáÍÓÇÈ ÛíÑ ãİÚá";break;
	           case 114:msg="ÇáÍÓÇÈ ãæŞæİ";break;
	           case 115:msg="ÇáÌæÇá ÛíÑ ãİÚá";break;
	           case 116:msg="ÇáÈÑíÏ ÇáÇáßÊÑæäì ÛíÑ ãİÚá";break;
	           case 117:msg="ÇáÑÓÇáå İÇÑÛå áÇ íãßä ÇáÇÑÓÇá";break;
	           case 1010:msg="ÎØÇ İì ÊÔİíÑ ÇáÑÓÇáå";break;
	           case 1011:msg="ÇÓã ÇáãÓÊÎÏã ÛíÑ ãæÌæÏ";break;
	           case 1012:msg="ßáãÉ ÇáãÑæÑ ÛíÑ ãæÌæÏå";break;
	           case 1013:msg="äÕ ÇáÑÓÇáå ÛíÑ ãæÌæÏ";break;
	           case 1014:msg="ÇáÇÑŞÇã ÇáãÑÓá ÇáíåÇ ÛíÑ ãæÌæÏå";break;
	           case 1015:msg="ÇÓã ÇáÑÇÓá ÛíÑ ãæÌæÏ";break;
						default:msg="";break;
				   }break;
			case 2:switch(value){
			     case 101:msgb= "ÇáÈíÇäÇÊ äÇŞÕÉ";break;
	             case 102:msgb= "ÇÓã ÇáãÓÊÎÏã ÛíÑ ÕÍíÍ";break;
	             case 103:msgb="ßáãÉ ÇáãÑæÑ ÛíÑ ÕÍíÍå";break;
	             case 104:msgb="áÇ íæÌÏ ÑÕíÏ İì ÇáÍÓÇÈ";break;
	             case 111:msgb="ÇáÇÑÓÇá ãÛáŞ";break;
	             case 113:msgb= "ÇáÍÓÇÈ ÛíÑ ãİÚá";break;
	             case 114:msgb= "ÇáÍÓÇÈ ãæŞæİ";break;
		         case 115:msgb="ÛíÑ ãİÚá ÌæÇá";break;
	 	         case 116:msgb="ÛíÑ ãİÚá ÈÑíÏ ÇáßÊÑæäì";break;
	 	         case 117:msgb="Êã ÇáÍÕæá Úáì ÇáÑÕíÏ";break;
	 	        default:msgb="";break;
				   }break;
			
				   
			case 3:switch(value){
			           case 101:msg= "ÇáÈíÇäÇÊ äÇŞÕÉ";break;
			           case 102:msg= "ÇÓã ÇáãÓÊÎÏã ÛíÑ ÕÍíÍ";break;
			           case 103:msg="ßáãÉ ÇáãÑæÑ ÛíÑ ÕÍíÍå";break;
			           case 104:msg="áÇ íæÌÏ ÑÕíÏ İì ÇáÍÓÇÈ";break;
			           case 105:msg="ÇáÇÑÓÇá ãÛáŞ";break;
			           case 106:msg= "ÇáÍÓÇÈ ÛíÑ ãİÚá";break;
			           case 107:msg= "ÇáÍÓÇÈ ãæŞæİ";break;
			           case 108:msg="ÛíÑ ãİÚá ÌæÇá";break;
		 	           case 109:msg="ÛíÑ ãİÚá ÈÑíÏ ÇáßÊÑæäì";break;
			           case 110:msg="Êã ÇÖÇİÉ ÇÓã ÇáãÑÓá ÈäÌÇÍ æÓæİ íÊã ÊİÚíáÉ İì ÇŞÑÈ æŞÊ";break;
			           case 111:msg= "ãä İÖáß ÇÏÎá ÇÓã ãÑÓá ÕÍíÍ";break;
			           case 112:msg= "ÇáÓäÏÑ äíã ÇáÈÏ æÇä íßæä 15 ÑŞã Çæ 11 ÍÑİ æÑŞã - _. ÔÇãÇá ÇáãÓÇİÇÊ";break;
			           case 113:msg="ÇÓã ÇáãÑÓá ãä ÇÇáÓãÇÁ ÇáãÍÌæÈÉ Çæ ãÔÇÈÉ ÇáÓã ãä ÇÇáÓãÇÁ ÇáãÍÌæÈÉ";break;
			           case 114:msg="ÇÓã ÇáãÑÓá ãæÌæÏ ãä ŞÈá";break;
			           case 115:msg="áíÓ áÏíß ÑÕíÏ áØáÈ ÇÓã ãÑÓá ÑŞãì";break;
			           case 116:msg="İÔá İì ÇÇáÑÓÇá ÍÇæá ãÑÉ ÇÎÑì Çæ ÇÊÕá ÈÇáÏÚã Çáİäì";break;
			           case 117:msg="Êã ÇÖÇİÉ ÇÓã ÇáãÑÓá ÈäÌÇÍ æÊã ÇÑÓÇá ßæÏ ÊİÚíá Çáì ÇáÑŞã";break;
			           default:msg="";break;
	   }break;
	   
			case 4:switch(value){
	           case 101:msg= "ÇáÈíÇäÇÊ äÇŞÕÉ";break;
	           case 102:msg= "ÇÓã ÇáãÓÊÎÏã ÛíÑ ÕÍíÍ";break;
	           case 103:msg="ßáãÉ ÇáãÑæÑ ÛíÑ ÕÍíÍå";break;
	           case 104:msg="áÇ íæÌÏ ÑÕíÏ İì ÇáÍÓÇÈ";break;
	           case 105:msg="ÇáÇÑÓÇá ãÛáŞ";break;
	           case 106:msg= "ÇáÍÓÇÈ ÛíÑ ãİÚá";break;
	           case 107:msg= "ÇáÍÓÇÈ ãæŞæİ";break;
	           case 108:msg="ÛíÑ ãİÚá ÌæÇá";break;
	           case 109:msg="ÛíÑ ãİÚá ÈÑíÏ ÇáßÊÑæäì";break;
	           case 110:msg="Êã ÊİÚíá ÇÓã ÇáãÑÓá ÈäÌÇÍ";break;
	           case 111:msg= "ÇáÈíÇäÇÊ äÇŞÕÉ";break;
	           case 112:msg= "ÊÔíÑ ÓÌÇáÊäÇ Çä ÇÓã ÇáãÑÓá Êã ÊİÚíáÉ ãä ŞÈá";break;
	           case 113:msg="İÔá İì ÇáÊİÚíá";break;
	           case 114:msg="İÔá İì ÇáÊÍÏíË æÊã ÍĞİ ÇÓã ÇáãÑÓá áÊÎØì ÚÏÏ ãÑÇÊ ÇáÓãÇÍ";break;
	           case 115:msg="ÊÔíÑ ÓÌÇáÊäÇ ÇäÉ Çá íæÌÏ ÇÓã ãÑÓá ãØÇÈŞ ááÈÍË";break;
	           default:msg="";break;
}break;	 
			}
		
	}
	public void sendURL(String URL,String parameters,int operationNumber){
		try {
	        URL url;
	        URLConnection urlConnection;
	        DataOutputStream outStream;
	        // Create connection
	        url = new URL(URL);
	        urlConnection = url.openConnection();
	        ((HttpURLConnection)urlConnection).setRequestMethod("POST");
	        urlConnection.setDoInput(true);
	        urlConnection.setDoOutput(true);
	        urlConnection.setUseCaches(false);
	        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        urlConnection.setRequestProperty("Content-Length", ""+ parameters.length());
	        urlConnection.setRequestProperty("User-agent","Mozilla/4.0");
	        // Create I/O streams
	        outStream = new DataOutputStream(urlConnection.getOutputStream());
	        // Send request
	        outStream.writeBytes(parameters);
	        outStream.flush();
	        outStream.close();
	        // Get Response
	        BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	        // - For debugging purposes only!
	        String buffer;
	        while((buffer = rd.readLine()) != null) {
	        	try{
	        		selectedMessage(Integer.parseInt(buffer),operationNumber);
	        		if (msgb.equals("") && operationNumber==2){balance=buffer;}
	        		else if(!msgb.equals("") && operationNumber==2)
	        		{balance=msgb;}
	        		
	        	}catch(Exception ex){
	        		balance=buffer;
	        	}
	        }
	        // Close I/O streams
	        rd.close();
	        outStream.close();
	    }
	    catch(Exception ex) {
	        System.out.println("Exception cought:\n"+ ex.toString());
	    }
	}
	
	
}