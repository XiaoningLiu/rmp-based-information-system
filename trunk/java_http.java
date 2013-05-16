import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.net.URLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;


public class java_http {
	public static String reqForPost(String postURL, String context) {
		try {
    		URL url = new URL(postURL);
    		URLConnection urlConn = url.openConnection();
    		HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
    		httpUrlConn.setDoOutput(true);
    		httpUrlConn.setDoInput(true);
    		httpUrlConn.setUseCaches(false);
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
	
	public static String reqForGet(String getURL) {
		try {
    		URL url = new URL(getURL);
    		URLConnection urlConn = url.openConnection();
    		HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
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
	public static String readBuffer(InputStreamReader in) {
		try {
			BufferedReader reader = new BufferedReader(in);
			String line = "";
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			return StringUtils.trimToEmpty(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public static void res2Client(HttpServletRequest req,
			HttpServletResponse res, String s) {
		try {
			res.setContentType("text/plain;charset=UTF-8");
			PrintWriter out = res.getWriter();
			out.print(s);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String getRemoteAddr(HttpServletRequest req) {
		String ip = req.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = req.getRemoteAddr();
		}
		return ip;
	}

}
