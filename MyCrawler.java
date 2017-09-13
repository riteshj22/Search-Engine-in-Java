package crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class MyCrawler extends WebCrawler {
	static int html1 =0 ,gif = 0,png = 0, jpg = 0, pdf = 0,success = 0, three =0 , unauthorized =0,forbidden = 0, not_found = 0;
	static int fetch_success = 0,fetch_aborted = 0, fetch_failed = 0,uniqueDomain = 0,uniqueNonDomain = 0;
	
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|mp3|zip|gz))$");
	   /** 
     * This method receives two parameters. The first parameter is the page 
     * in which we have discovered this new URL and the second parameter is
     * the new URL. You should implement this function to specify whether
     * the given URL should be crawled or not (based on your crawling logic).
     * In this example, we are instructing the crawler to ignore urls that
     * have css, js, git, ... extensions and to only accept urls that start
     * with "http://www.viterbi.usc.edu/". In this case, we didn't need the
     * referringPage parameter to make the decision.
	 * @return 
	 * @throws IOException 
     */ 
	
		

	@Override
	public boolean shouldVisit(Page referringPage, WebURL url){
		
		String href = url.getURL().toLowerCase();
//		try{
//			URL url1 = new URL(url.getURL());
//			HttpURLConnection conn = (HttpURLConnection)url1.openConnection();
//			int statusCode = conn.getResponseCode();
			generateCSV CSVObject = new generateCSV();
			String url2 = url.toString();
			String status;
//    		File file3 = new File ("C:\\Users\\RJ\\workspace\\crawler\\urls_Newssite1.csv");
//			HashMap<String, Integer> hashURL = new HashMap<String, Integer>();
//			Hashtable<Integer, String> source = new Hashtable<Integer,String>();
//			HashMap<Integer, String>  map = new HashMap(source);
//			String key = href;
//			Integer value = hashURL.get(key);
			
		 


    		if(url2.startsWith("http://abcnews.go.com/")){
    			status = "OK";
//    			if(value == null){
//    				hashURL.put(href, 1);
//    				uniqueDomain += 1;
////    				System.out.println("domain " + uniqueDomain);
//    			}
    			
//    			in_domain += 1;
    		}
    		else{
    			status = "N_OK";
//    			if(value == null){
//    				hashURL.put(href, 1);
//    				uniqueNonDomain += 1;
////    				System.out.println("nondomain" + uniqueNonDomain);
    			}
//    			out_domain += 1;
//    		}
			
			try {
				
					CSVObject.createCSV3(url2, status);
					
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			if(statusCode >=300 && statusCode < 400){
//				redirections += 1;
//			}
//			else if(statusCode >=400 && statusCode < 500){
//				client += 1;
//			}
//			else{
//				other += 1;
//			}
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		return !FILTERS.matcher(href).matches()
			&& href.startsWith("http://abcnews.go.com/");
	}
	
	/** 
     * This function is called when a page is fetched and ready
     * to be processed by your program.
     */
    @Override
    public void visit(Page page) {
    	
    	generateCSV CSVObject = new generateCSV();
    	String url = page.getWebURL().getURL();
    	

//   	System.out.println("URL:" + url);
    	int count = 0;
    	if(page.getParseData() instanceof HtmlParseData) {
    		HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
    		String text = htmlParseData.getText();
    		String html = htmlParseData.getHtml();
    		Set<WebURL> links = htmlParseData.getOutgoingUrls();
//    		String contentType = htmlParseData.getTitle();
//    		String content = htmlParseData.getMetaTags().get("content-type");
//    		String contentType = content.replaceAll(";.*$","");
    		String content = page.getContentType();
    		String contentType = content.replaceAll(";.*$","");
    		byte[] contentSize = page.getContentData();
    		Integer code = page.getStatusCode();
    		String pageURL = page.getWebURL().toString();
    		if(contentType == "text/html"){
    			html1 += 1;
    		}else if(contentType == "image/gif"){
    			gif += 1;
    		}else if(contentType == "image/jpeg"){
    			jpg += 1;
    		}else if(contentType == "image/png"){
    			png += 1;
    		}else if(contentType == "application/pdf"){
    			pdf += 1;
    		}
    		URL url1;
//    		try {
//				int statusCode = page.getStatusCode();
////				url1 = new URL(url);
////				HttpURLConnection conn = (HttpURLConnection)url1.openConnection();
////				int statusCode = conn.getResponseCode();
//	    		if(statusCode >= 200 && statusCode < 300){
//	    	
    		if(code == 200){
    			success += 1;
    		}
    		if(code >= 200 && code < 300){
    			fetch_success += 1;
    		}
    		try {
    			CSVObject.createCSV1(url, code);
    			CSVObject.createCSV2(url, contentSize.length, links.size(), contentType);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//	    				CSVObject.createCSV2(url, contentSize.length, links.size(), contentType);
//	    		}
//	    		else{
//	    			
//	    				System.out.println("gotcha");
//	        			CSVObject.createCSV1(url, statusCode);
////	    				CSVObject.createCSV2(url, contentSize.length, links.size(), contentType, "visit_Newssite1.csv", file2);	        		
//	    		}
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
    		

    		
    		
//    		System.out.println("Text length" + text.length());
//    		System.out.println("HTML length" + html.length());
//    		System.out.println("Number of Outgoing Links" + links.size());
//    		System.out.println("Content " + contentType);
//    		System.out.println("Size " + contentSize.length);
//        	System.out.println(count);
//        	System.out.println(count2);
    	}
    }
    
    protected void handlePageStatusCode(WebURL webUrl, int statusCode, String statusDescription) {
        // Do nothing by default
        // Sub-classed can override this to add their custom functionality
    	generateCSV CSVObject = new generateCSV();
    
    	
    	String url = webUrl.toString();
    	if(statusCode >= 200 && statusCode < 300){
    		
    		
			
//    		System.out.println(url);
//        		try {
//					CSVObject.createCSV1(url, statusCode);
////					CSVObject.createCSV2(url, contentSize.length, links.size(), contentType);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
        		
    	}
    	else{
    		
//    		File file = new File ("C:\\Users\\RJ\\workspace\\crawler\\fetch_Newssite2.csv");
    		
//    		try {
//    			FileWriter fp = new FileWriter(file, true);
//				fp.write(statusCode);
//				fp.write("\n");
//				fp.flush();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("gotcha");
//    		if(statusCode == 200){
//    			success += 1;
//    		}
    		if(statusCode == 301){
    			three += 1;
    		}
    		if(statusCode == 401){
    			unauthorized += 1;
    		}
    		if(statusCode == 403){
    			forbidden += 1;
    		}
    		if(statusCode == 404){
    			not_found += 1;
    		}
    		if(statusCode >= 300 && statusCode < 400){
    			fetch_aborted += 1;
    		}else{
    			fetch_failed += 1;
    		}
    		
    		
			try {
				CSVObject.createCSV1(url, statusCode);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			CSVObject.createCSV2(url, contentSize.length, links.size(), contentType, "visit_Newssite1.csv", file2);	        		
    	}
    	
    }
    }

	

