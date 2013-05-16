import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.net.URLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringUtils;

/**
 * HTTP通讯组件
 * 
 * @author <a href="mailto:cairenxi@viewlinecn.com">蔡仁西</a>
 * @version 1.0
 */
public class java_http {
	
	/**
	 * 客户端用Post方法向服务器提交请求,并获取服务器响应信息
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
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
    		// http正文内，因此需要设为true, 默认情况下是false;
    		httpUrlConn.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true
    		httpUrlConn.setDoInput(true);
            // Post 请求不能使用缓存
    		httpUrlConn.setUseCaches(false);
    		// 设定请求的方法为"POST"，默认是GET
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
	 * 客户端用Put 方法向服务器提交请求,并获取服务器响应信息
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
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
    		// http正文内，因此需要设为true, 默认情况下是false;
    		httpUrlConn.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true
    		httpUrlConn.setDoInput(true);
            // Post 请求不能使用缓存
    		httpUrlConn.setUseCaches(false);
    		// 设定请求的方法为"PUT"，默认是GET
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
	 * 客户端用Get方法向服务器提交请求,并获取服务器响应信息
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
            // 默认情况下是false;
    		httpUrlConn.setDoOutput(false);
            // 设置是否从httpUrlConnection读入，默认情况下是true
    		httpUrlConn.setDoInput(true);
            // Get 请求不能使用缓存
    		httpUrlConn.setUseCaches(false);
    		// 设定请求的方法为"GET"，默认是GET
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
	 * 客户端用Delete 方法向服务器提交请求,并获取服务器响应信息
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
            // 默认情况下是false;
    		httpUrlConn.setDoOutput(false);
            // 设置是否从httpUrlConnection读入，默认情况下是true
    		httpUrlConn.setDoInput(true);
            // Get 请求不能使用缓存
    		httpUrlConn.setUseCaches(false);
    		// 设定请求的方法为"DELETE"，默认是DELETE
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
