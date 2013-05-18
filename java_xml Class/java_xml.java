import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
	
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
	  
public class java_xml { 
	public static String serverUrl = "Http://localhost:8080/rmp/resource/papermanagement/";
	
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
    /**
     * Return the available index
     * PS: Only for tables using integer as index
     * @param tableName
     * letter case sensitive
     * @return 
     * return available index， return "-1" when errors
     */
    public static String getTableIndex(String tableName){
    	int index = 0;
    	
    	// get whole xml document
    	Document doc = initialize(serverUrl + tableName + "/*");
    	if( doc.getRootElement().getName() == "Errors"){
    		return "-1";
    	}  	
    	
    	// get and check the list of 'record' elements in xml
    	List recordList = doc.selectNodes("//" + tableName + "/record");    	
    	for(Iterator recordIter = recordList.iterator(); recordIter.hasNext();){
    		Element recordElement = (Element)recordIter.next(); 
    		Iterator primarykeyIter = recordElement.elementIterator("primarykey");  
    		
    		// get primarykey in this record element
    		if(primarykeyIter.hasNext()){
    			String sIndex = ( (Element)primarykeyIter.next() ).getText();
    			
    			index = Integer.parseInt(sIndex) >= index ? Integer.parseInt(sIndex) + 1 : index;
    		}else{
    			return "-1";
    		}
    	}
    	
    	return "" + index;
    }
    
    /**
     * post new row to a table
     * @param tableName
     * case-sensitive
     * @param idStr
     * eg. For composite and single, "1" or "12"; 
     * For association, use "1@2"
     * @param columns
     * @param values
     * @return
     */
    public static boolean postTableRow(String tableName, String idStr, Vector<String> columns, Vector<String> values){
    	// check the arguments
    	if(columns.size() != values.size()){
    		return false;
    	}
    	
        Document doc = DocumentHelper.createDocument();
        
        // get database name from serverUrl
        String []tokens = serverUrl.split("/");
        String serverName = tokens[tokens.length - 1];
        
        // add root element
        Element rootEle = doc.addElement(tableName);
        rootEle.addAttribute("uri", serverName + "/" + tableName + "/" + idStr);
        
        // add record element
        Element recordEle = rootEle.addElement("record");
        
        // add columns
        for(int i = 0; i < columns.size(); i++){
        	Element ele = recordEle.addElement(columns.get(i));
        	ele.setText(values.get(i));
        }
        
        // post the xml
        System.out.print(java_http.reqForPost(serverUrl + tableName + "/" + idStr, doc.asXML()));       
    	return true;
    }
    
    /**
     * delete the row using it's id
     * @param tableName
     * case-sensitive
     * @param idStr
     * "1", "2", "2@3"
     * @return
     */
    public static boolean delTableRow(String tableName, String idStr){
    	System.out.print(java_http.reqForDel(serverUrl + tableName + "/" + idStr));       
    	return true;
    }
    
    /**
     * change the data using put
     * @param tableName
     * case-sensitive
     * @param idStr
     * such as "1", "1@2"
     * @param columns
     * the columns you want to modify
     * @param values
     * the new values
     * @return
     */
    public static boolean putTableRow(String tableName, String idStr, Vector<String> columns, Vector<String> values){
    	// check the arguments
    	if(columns.size() != values.size()){
    		return false;
    	}
    	
        Document doc = DocumentHelper.createDocument();
        
        // get database name from serverUrl
        String []tokens = serverUrl.split("/");
        String serverName = tokens[tokens.length - 1];
        
        // add root element
        Element rootEle = doc.addElement(tableName);
        rootEle.addAttribute("uri", serverName + "/" + tableName + "/" + idStr);
        
        // add record element
        Element recordEle = rootEle.addElement("record");
        
        // add columns
        for(int i = 0; i < columns.size(); i++){
        	Element ele = recordEle.addElement(columns.get(i));
        	ele.setText(values.get(i));
        }
        
        // post the xml
        System.out.print(java_http.reqForPut(serverUrl + tableName + "/" + idStr, doc.asXML()));       
    	return true;
    }

    /**
     * 
     * @param com
     * @param ass
     * @param columns
     * @param primaryKey
     * @return
     */
    public static Vector<String>[] getAssFromCom(String com, String ass, Vector<String> columns, String primaryKey){
    	//get XML document from server
    	Document doc = initialize(serverUrl + com + "/?primarykey=" + primaryKey);
    	
    	// create Vector<Vector<String>>
    	Vector<String> []result = new Vector[columns.size()];
    	for(int i = 0; i < columns.size(); i++){
    		//result.add(new Vector<String>());
    		result[i] = new Vector<String>();
    	}
    	
    	//get and go through all Association/record elements
    	List assRecordList = doc.selectNodes("//" + ass + "/record");
    	for(Iterator i = assRecordList.iterator(); i.hasNext();){
    		Element assRecordEle = (Element) i.next();
    		
    		// get the needed columns
    		for(int j = 0; j < columns.size(); j++){
    			// get column value
    			Iterator ii = assRecordEle.elementIterator(columns.get(j));
    			if(ii.hasNext()){
    				//result.get
    				result[j].add(  ((Element)ii.next()).getText()  );    
    				
    				System.out.print(result[j].lastElement() + " ");
    			}
    		}  		
    		System.out.println("");
    	}
    	    	
    	// return
    	return result;
    }
    
    public static Vector<String>[] getAssFromSig(String sig, String ass, Vector<String> columns, String primaryKey){
    	// get association XML document from server
    	Document doc = initialize(serverUrl + ass + "/*");
    	
    	// create Vector<String>[]
    	Vector<String> []result = new Vector[columns.size()];
    	for(int i = 0; i < columns.size(); i++){
    		//result.add(new Vector<String>());
    		result[i] = new Vector<String>();
    	}
    	
    	// get all the ass/record/rangekey equaling the single primary key
    	List rangeKeyList = doc.selectNodes("//" + ass + "/record/rangekey");
    	for(Iterator i = rangeKeyList.iterator(); i.hasNext();){
    		Element rangeKeyEle = (Element) i.next();
    		if(rangeKeyEle.getText().equals(primaryKey)){
    			// get rangeKey's father node
    			Element assRecordEle = rangeKeyEle.getParent();
    			
    			// get the needed columns
        		for(int j = 0; j < columns.size(); j++){
        			// get column value
        			Iterator ii = assRecordEle.elementIterator(columns.get(j));
        			if(ii.hasNext()){
        				result[j].add(  ((Element)ii.next()).getText()  );    
        				System.out.print(result[j].lastElement() + " ");
        			}
        		}  		
        		System.out.println("");			
    		}
    	}
    	
    	// return
    	return result;
    }
    
    public static Vector[] getTableRows(String table,Vector columns,String selectStr){
    	Vector result[]=new Vector[columns.size()];
    	for(int i=0;i<columns.size();i++)
    		result[i]=new Vector();
    	String url=serverUrl+table+"/"+selectStr;
    	
    	Document document=initialize(url);
    	for(int i=0;i<columns.size();i++){
    		List list = document.selectNodes("//"+table+"/record"); 
    		Iterator iter = list.iterator();
    		while(iter.hasNext()){
    			Element bookElement = (Element)iter.next();
    			Iterator iterator = bookElement.elementIterator(columns.get(i).toString());
    			while(iterator.hasNext()){
    				Element titleElement=(Element)iterator.next();
    				if(!titleElement.getText().isEmpty())
    				{
	    				result[i].add(titleElement.getText());
	    				System.out.print(titleElement.getText() + " ");
    				}
    			}
    		}  
			System.out.println("\n-------another column-------");
    	}
    	return result;
    }
    
    public static Vector[] getSigFromCom(String com,String ass,String sig,Vector columns,String comPrimaryKey){
    	Vector result[]=new Vector[columns.size()];
    	for(int i=0;i<columns.size();i++)
    		result[i]=new Vector();
    	String url=serverUrl+com+"/?primarykey="+comPrimaryKey;
    	
    	Document document=initialize(url);
    	for(int i=0;i<columns.size();i++){
    		List list = document.selectNodes("//"+com+"/"+ass+"/"+sig+"/record"); 
    		Iterator iter = list.iterator();
    		while(iter.hasNext()){
    			Element bookElement = (Element)iter.next();
    			Iterator iterator = bookElement.elementIterator(columns.get(i).toString());
    			while(iterator.hasNext()){
    				Element titleElement=(Element)iterator.next();
    				if(!titleElement.getText().isEmpty())
    				{
	    				result[i].add(titleElement.getText());
	    				System.out.print(titleElement.getText() + " ");
    				}
    			}
    		}  
    	}
    	return result;
    }
    
    public static Vector[] getComFromSig(String com,String ass,String sig,Vector columns,String sigPrimaryKey){
    	Vector result[]=new Vector[2];
    	for(int i=0;i<2;i++)
    		result[i]=new Vector();
    	String allurl=serverUrl+ass+"/*";

    	Vector forFor=new Vector();
    	forFor.add("domainkey");
    	forFor.add("rangekey");
    	Document document=initialize(allurl);
    	for(int i=0;i<2;i++){
    		List list = document.selectNodes("//"+ass+"/record"); 
    		Iterator iter = list.iterator();
    		while(iter.hasNext()){
    			Element bookElement = (Element)iter.next();
    			Iterator iterator = bookElement.elementIterator(forFor.get(i).toString());
    			while(iterator.hasNext()){
    				Element titleElement=(Element)iterator.next();
    				if(!titleElement.getText().isEmpty())
    				{
	    				result[i].add(titleElement.getText());
    				}
    			}
    		}  
    	}
    	Vector forFinal=new Vector();
    	for(int j=0;j<result[1].size();j++)
    		if(result[1].get(j).toString().equals(sigPrimaryKey))
    			forFinal.add(result[0].get(j));
    	
    	Vector finalResult[]=new Vector[columns.size()];
    	for(int i=0;i<columns.size();i++)
    		finalResult[i]=new Vector();
    	
    	for(int i=0;i<forFinal.size();i++)
    	{
        	Vector[] tmp=getTableRows(com,columns,"?primarykey="+forFinal.get(i).toString());
        	for(int j=0;j<columns.size();j++)
        		for(int ii=0;ii<tmp[j].size();ii++)
        			finalResult[j].add(tmp[j].get(ii));
    	}
    	for(int j=0;j<columns.size();j++)
    		for(int ii=0;ii<finalResult[j].size();ii++)
    			System.out.print(finalResult[j].get(ii).toString()+"\n");
    	return finalResult;
    }
    
}  
