package java_xml;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.net.URLConnection;
import org.apache.commons.lang.StringUtils;

/**
 * HTTPͨѶ���
 * 
 * @author <a href="mailto:cairenxi@viewlinecn.com">������</a>
 * @version 1.0
 */
public class java_http {
	
	/**
	 * �ͻ�����Post������������ύ����,����ȡ��������Ӧ��Ϣ
	 * 
	 * @param request
	 * @param response
	 * @param s
	 */
	public static String reqForPost(String postURL, String context) {
		try {
    		URL url = new URL(postURL);
    		URLConnection urlConn = url.openConnection();
    		HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
            // �����Ƿ���httpUrlConnection�������Ϊ�����post���󣬲���Ҫ����
    		// http�����ڣ������Ҫ��Ϊtrue, Ĭ���������false;
    		httpUrlConn.setDoOutput(true);
            // �����Ƿ��httpUrlConnection���룬Ĭ���������true
    		httpUrlConn.setDoInput(true);
            // Post ������ʹ�û���
    		httpUrlConn.setUseCaches(false);
    		// �趨����ķ���Ϊ"POST"��Ĭ����GET
    		httpUrlConn.setRequestMethod("POST");    		
    		OutputStreamWriter wr = new OutputStreamWriter(httpUrlConn.getOutputStream());
    		wr.write(context);
    		wr.flush();
    		BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConn
    				.getInputStream()));
    		String line;
    		StringBuffer sb = new StringBuffer();
    		while ((line = in.readLine()) != null) {
    			sb.append(line);
    		}
    		wr.close();
    		in.close();
    		
    		return StringUtils.trimToEmpty(sb.toString());
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}	
	
	/**
	 * �ͻ�����Put ������������ύ����,����ȡ��������Ӧ��Ϣ
	 * 
	 * @param request
	 * @param response
	 * @param s
	 */
	public static String reqForPut(String postURL, String context) {
		try {
    		URL url = new URL(postURL);
    		URLConnection urlConn = url.openConnection();
    		HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
            // �����Ƿ���httpUrlConnection�������Ϊ�����post���󣬲���Ҫ����
    		// http�����ڣ������Ҫ��Ϊtrue, Ĭ���������false;
    		httpUrlConn.setDoOutput(true);
            // �����Ƿ��httpUrlConnection���룬Ĭ���������true
    		httpUrlConn.setDoInput(true);
            // Post ������ʹ�û���
    		httpUrlConn.setUseCaches(false);
    		// �趨����ķ���Ϊ"PUT"��Ĭ����GET
    		httpUrlConn.setRequestMethod("PUT");    		
    		OutputStreamWriter wr = new OutputStreamWriter(httpUrlConn.getOutputStream());
    		wr.write(context);
    		wr.flush();
    		BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConn
    				.getInputStream()));
    		String line;
    		StringBuffer sb = new StringBuffer();
    		while ((line = in.readLine()) != null) {
    			sb.append(line);
    		}
    		wr.close();
    		in.close();
    		
    		return StringUtils.trimToEmpty(sb.toString());
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}	
	

	
	/**
	 * �ͻ�����Get������������ύ����,����ȡ��������Ӧ��Ϣ
	 * 
	 * @param request
	 * @param response
	 * @param s
	 */
	public static String reqForGet(String getURL) {
		try {
    		URL url = new URL(getURL);
    		URLConnection urlConn = url.openConnection();
    		HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
            // Ĭ���������false;
    		httpUrlConn.setDoOutput(false);
            // �����Ƿ��httpUrlConnection���룬Ĭ���������true
    		httpUrlConn.setDoInput(true);
            // Get ������ʹ�û���
    		httpUrlConn.setUseCaches(false);
    		// �趨����ķ���Ϊ"GET"��Ĭ����GET
    		httpUrlConn.setRequestMethod("GET");
    		BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConn
    				.getInputStream()));
    		String line;
    		StringBuffer sb = new StringBuffer();
    		while ((line = in.readLine()) != null) {
    			sb.append(line);
    		}
    		in.close();
    		return StringUtils.trimToEmpty(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * �ͻ�����Delete ������������ύ����,����ȡ��������Ӧ��Ϣ
	 * 
	 * @param request
	 * @param response
	 * @param s
	 */
	public static String reqForDel(String getURL) {
		try {
    		URL url = new URL(getURL);
    		URLConnection urlConn = url.openConnection();
    		HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
            // Ĭ���������false;
    		httpUrlConn.setDoOutput(false);
            // �����Ƿ��httpUrlConnection���룬Ĭ���������true
    		httpUrlConn.setDoInput(true);
            // Get ������ʹ�û���
    		httpUrlConn.setUseCaches(false);
    		// �趨����ķ���Ϊ"DELETE"��Ĭ����DELETE
    		httpUrlConn.setRequestMethod("DELETE");
    		BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConn
    				.getInputStream()));
    		String line;
    		StringBuffer sb = new StringBuffer();
    		while ((line = in.readLine()) != null) {
    			sb.append(line);
    		}
    		in.close();
    		return StringUtils.trimToEmpty(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	

}
