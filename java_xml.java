import java.io.*;
import java.util.Iterator;
import java.util.List;
	
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
	  
public class java_xml { 
    public static Document initialize(String url) { 
		String xmlInfo  =java_http.reqForGet(url);
		SAXReader saxReader = new SAXReader();
		Document document=null;    
		try {
			document = saxReader.read(new ByteArrayInputStream(xmlInfo.getBytes()));		
	    	
       } catch (DocumentException e) {
			e.printStackTrace();
		}  
	  //System.out.print(document.asXML());
      return document;
    }   
    public static String get(String getElement, String url){
    	String tabletmp=url.substring(0,url.lastIndexOf("/"));
    	String table=tabletmp.substring(tabletmp.lastIndexOf("/"));
    	Document document=initialize(url);
    	Element root = document.getRootElement();
        String result="";
        List list = document.selectNodes("/Resources"+table+"/record"); 
        Iterator iter = list.iterator();
        while(iter.hasNext()){
           Element bookElement = (Element)iter.next();
           Iterator iterator = bookElement.elementIterator(getElement);
           while(iterator.hasNext()){
               Element titleElement=(Element)iterator.next();
               result+=titleElement.getText()+"\n";
           }
        }  
        return result;
    }
    public static void post(String uri,String description,String attributeName,String primarykey,String column,String postURL){
        Document document = DocumentHelper.createDocument();
        Element singleElement = document.addElement("single");
        singleElement.addAttribute("uri",uri);
        singleElement.addAttribute("description",description);
        Element recordElement = singleElement.addElement("record");
        Element primarykeyElement = recordElement.addElement("primarykey");
        primarykeyElement.setText(primarykey);
        Element columnElement = recordElement.addElement("column");
        columnElement.addAttribute("attributeName",attributeName);
        columnElement.setText(column);
        System.out.print(java_http.reqForPost(postURL, document.asXML()));
        
        
    }
}  
