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
//userName : ��� �������� �� ��������
//password : ��������  �� ��������

//sender : ��� ������ ���� ����� ��� ����� �������

//message : 							SendSMS ����� ������� ����� ��������� ��� ����� ������� ���� ������� 
/*										������� �������  70 ���
										������� ���������� 160 ���
										�� ��� ����� ���� �� ����� ����� ��� ������� ������� ���� 67
										�������� ��������� 158
*/

//numbers : 							��� ����� ����� ������� ������� ��� 96650555555 ���� ������� ��� ���� �� ��� ��� ��� ������� (,) ��� ���� ��� ��� ����� ��� �� ����� 

// ������� ���  ����� ������� � ���� ������ ��� ��� ������ ������� �� �������
	public void sendMessage(String username,String password,String numbers,String message,String sender) throws UnsupportedEncodingException{
     
		String message1=URLEncoder.encode(message, "UTF-8");
        System.out.println(message1);
		    String para ="username="+username+"&password="+password+"&message="+message1+"&numbers="+numbers+"&sender="+sender+"&unicode=e";
		   
	        sendURL("http://www.4jawaly.net/api/sendsms.php?",para,1);
	        
	}




//check balance method
//userName : ��� �������� ������ �� ���� ��������
//password : ���� ������ ������ �� ���� ��������
// ������� ���  ����� ������� � ���� ������ ��� ��� ������ ������� �� �������
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
			   case 100:msg= "�� ������ ������� �����";break;
			   case 101:msg= "�������� �����";break;
	           case 102:msg= "��� �������� ��� ����";break;
	           case 103:msg="���� ������ ��� �����";break;
	           case 104:msg="��� �� ����� ��������";break;
	           case 105:msg="�� ���� ���� �� ������";break;
	           case 106:msg= "��� ������ ���";break;
	           case 107:msg= "��� ������ �����";break;
	           case 108:msg="�� ���� ����� ����� �������";break;
	           case 109:msg="�� ������ ����� ���� �� 8 ����� �� �������";break;
	           case 110:msg="��� �� ��� ����� �������";break;
	           case 111:msg="������� ����";break;
	           case 112:msg= "������� ����� ��� ����� ������";break;
	           case 113:msg= "������ ��� ����";break;
	           case 114:msg="������ �����";break;
	           case 115:msg="������ ��� ����";break;
	           case 116:msg="������ ���������� ��� ����";break;
	           case 117:msg="������� ����� �� ���� �������";break;
	           case 1010:msg="��� �� ����� �������";break;
	           case 1011:msg="��� �������� ��� �����";break;
	           case 1012:msg="���� ������ ��� ������";break;
	           case 1013:msg="�� ������� ��� �����";break;
	           case 1014:msg="������� ������ ����� ��� ������";break;
	           case 1015:msg="��� ������ ��� �����";break;
						default:msg="";break;
				   }break;
			case 2:switch(value){
			     case 101:msgb= "�������� �����";break;
	             case 102:msgb= "��� �������� ��� ����";break;
	             case 103:msgb="���� ������ ��� �����";break;
	             case 104:msgb="�� ���� ���� �� ������";break;
	             case 111:msgb="������� ����";break;
	             case 113:msgb= "������ ��� ����";break;
	             case 114:msgb= "������ �����";break;
		         case 115:msgb="��� ���� ����";break;
	 	         case 116:msgb="��� ���� ���� ��������";break;
	 	         case 117:msgb="�� ������ ��� ������";break;
	 	        default:msgb="";break;
				   }break;
			
				   
			case 3:switch(value){
			           case 101:msg= "�������� �����";break;
			           case 102:msg= "��� �������� ��� ����";break;
			           case 103:msg="���� ������ ��� �����";break;
			           case 104:msg="�� ���� ���� �� ������";break;
			           case 105:msg="������� ����";break;
			           case 106:msg= "������ ��� ����";break;
			           case 107:msg= "������ �����";break;
			           case 108:msg="��� ���� ����";break;
		 	           case 109:msg="��� ���� ���� ��������";break;
			           case 110:msg="�� ����� ��� ������ ����� ���� ��� ������ �� ���� ���";break;
			           case 111:msg= "�� ���� ���� ��� ���� ����";break;
			           case 112:msg= "������ ��� ���� ��� ���� 15 ��� �� 11 ��� ���� - _. ����� ��������";break;
			           case 113:msg="��� ������ �� ������� �������� �� ����� ���� �� ������� ��������";break;
			           case 114:msg="��� ������ ����� �� ���";break;
			           case 115:msg="��� ���� ���� ���� ��� ���� ����";break;
			           case 116:msg="��� �� ������� ���� ��� ���� �� ���� ������ �����";break;
			           case 117:msg="�� ����� ��� ������ ����� ��� ����� ��� ����� ��� �����";break;
			           default:msg="";break;
	   }break;
	   
			case 4:switch(value){
	           case 101:msg= "�������� �����";break;
	           case 102:msg= "��� �������� ��� ����";break;
	           case 103:msg="���� ������ ��� �����";break;
	           case 104:msg="�� ���� ���� �� ������";break;
	           case 105:msg="������� ����";break;
	           case 106:msg= "������ ��� ����";break;
	           case 107:msg= "������ �����";break;
	           case 108:msg="��� ���� ����";break;
	           case 109:msg="��� ���� ���� ��������";break;
	           case 110:msg="�� ����� ��� ������ �����";break;
	           case 111:msg= "�������� �����";break;
	           case 112:msg= "���� ������� �� ��� ������ �� ������ �� ���";break;
	           case 113:msg="��� �� �������";break;
	           case 114:msg="��� �� ������� ��� ��� ��� ������ ����� ��� ���� ������";break;
	           case 115:msg="���� ������� ��� �� ���� ��� ���� ����� �����";break;
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