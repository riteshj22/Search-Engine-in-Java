package csci572_Index.network_graph_webpages;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class extract_big_text {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		String line = "";
		Map<String, String> fileUrlMap = new HashMap<String, String>();
		Map<String, String> urlFileMap = new HashMap<String, String>();
		
		BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\RJ\\Desktop\\csci 572\\assignments\\a3\\FoxNewsABCNewsData\\mapABCNewsFile.csv"));
		fileReader.readLine();
//		Integer i = 0;
		while((line = fileReader.readLine())!= null){
			
			String[] tokens = line.split(",");
			fileUrlMap.put(tokens[0], tokens[1]);
			urlFileMap.put(tokens[1], tokens[0]);
		}
		
		
		for (Map.Entry<String,String> entry : fileUrlMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
//			System.out.println(key + " " + value);
		}
//		System.out.println(i);

		BufferedReader fileReader1 = new BufferedReader(new FileReader("C:\\Users\\RJ\\Desktop\\csci 572\\assignments\\a3\\FoxNewsABCNewsData\\mapFoxNewsFile.csv"));
		fileReader1.readLine();
		Integer i = 0;
		while((line = fileReader1.readLine())!= null){
			i= i + 1;
			String[] tokens = line.split(",");
			fileUrlMap.put(tokens[0], tokens[1]);
			urlFileMap.put(tokens[1], tokens[0]);
		}
		
		
		for (Map.Entry<String,String> entry1 : fileUrlMap.entrySet()) {
			String key1 = entry1.getKey();
			String value1 = entry1.getValue();
//			System.out.println(key1 + " " + value1);
		}	
//		System.out.println(i);
			
						
		
		Writer writer = new FileWriter("C:\\Users\\RJ\\Desktop\\csci 572\\assignments\\a3\\big.txt");
//		Writer writer1 = new FileWriter("C:\\Users\\RJ\\Downloads\\FoxNewsABCNewsData\\output1.txt");
		// TODO Auto-generated method stub
		i = 0;
		File dir = new File("C:\\Users\\RJ\\Desktop\\csci 572\\assignments\\a3\\html1");
//		Set<String> edges = new HashSet<String>();
		for(File file: dir.listFiles()){
			System.out.println(i);
//			System.out.println(file.getName());	
			i = i + 1;
			String uri = fileUrlMap.get(file.getName());
//			System.out.println(uri);
			if (uri != null){
				Document doc = Jsoup.parse(file,"UTF-8", uri);
//				if (i == 1494){
//					System.out.println(doc);	
//				}
//				System.out.println(doc);
//				Elements links = doc.select("a[href]");
//				Elements pngs = doc.select("[src]");
//				if (doc != null){
				String text = doc.body().text();
				writer.write(text);
				}
//				else{
					
//				}
				

				
//				String str = "";
//				str += file.getName();
				
//				for(Element link : links){
//					String url = link.attr("abs:href").trim();
//					if(urlFileMap.containsKey(url)){
////						System.out.println(url);
////						System.out.println(urlFileMap.get(url));
////						System.out.println(1);
////						System.out.println(file.getName());;
//						str += " " + urlFileMap.get(url);
//						edges.add(file.getName() + " " + urlFileMap.get(url));
////						System.out.println(file.getName() + " " + urlFileMap.get(url));
//						
//					}
//				for(Element b : text){
////					System.out.println(1);
//					System.out.println(b.text());
//				}
				
//			}
//				writer1.write(str);
//				writer1.write("\n");
//			print( " * a: <%s> (%s)", link.attr("abs:href"), trim(link.text(),35));
			}
		
//		}
		
//		for(String s: edges){
//			writer.write(s);
//			writer.write("\n");
////			System.out.println(s);
//		}
//		
//		writer.flush();
//		writer.close();
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
