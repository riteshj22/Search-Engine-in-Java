package csci572_Index.network_graph_webpages;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class extract {

	public static void main(String[] args)  throws Exception {
		String line = "";
		Map<String, String> fileUrlMap = new HashMap<String, String>();
		Map<String, String> urlFileMap = new HashMap<String, String>();
		
		BufferedReader fileReader = new BufferedReader(new FileReader("C:\\Users\\RJ\\Downloads\\FoxNewsABCNewsData\\mapABCNewsFile.csv"));
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

		BufferedReader fileReader1 = new BufferedReader(new FileReader("C:\\Users\\RJ\\Downloads\\FoxNewsABCNewsData\\mapFoxNewsFile.csv"));
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
			
						
		
		Writer writer = new FileWriter("C:\\Users\\RJ\\Downloads\\FoxNewsABCNewsData\\output.txt");
		Writer writer1 = new FileWriter("C:\\Users\\RJ\\Downloads\\FoxNewsABCNewsData\\output1.txt");
		// TODO Auto-generated method stub
		File dir = new File("C:\\Users\\RJ\\Downloads\\FoxNewsABCNewsData\\html1");
		Set<String> edges = new HashSet<String>();
		for(File file: dir.listFiles()){
			String uri = fileUrlMap.get(file.getName());
			if (uri != null){
				Document doc = Jsoup.parse(file,"UTF-8", uri);
				Elements links = doc.select("a[href]");
				Elements pngs = doc.select("[src]");
				String str = "";
				str += file.getName();
				for(Element link : links){
					String url = link.attr("abs:href").trim();
					if(urlFileMap.containsKey(url)){
//						System.out.println(url);
//						System.out.println(urlFileMap.get(url));
//						System.out.println(1);
//						System.out.println(file.getName());;
						str += " " + urlFileMap.get(url);
						edges.add(file.getName() + " " + urlFileMap.get(url));
//						System.out.println(file.getName() + " " + urlFileMap.get(url));
						
					}
					
			}
				writer1.write(str);
				writer1.write("\n");
//			print( " * a: <%s> (%s)", link.attr("abs:href"), trim(link.text(),35));
			}
		
		}
		
		for(String s: edges){
			writer.write(s);
			writer.write("\n");
//			System.out.println(s);
		}
		
		writer.flush();
		writer.close();
		
	}
//		Elements imports =doc.select("link[href]");
//		
//		print("\nMedia: (%d)", media.size());
//		for (Element src : media) {
//			if(src.tagName().equals("img"))
//				print(" * %s: <%s> %sx%s (%s)",
//						src.tagName(),src.attr("abs:src"),src.attr("width"),src.attr("height"),
//						trim(src.attr("alt"),20));
//			else
//				print("* %s <%s>", src.tagName(),src.attr("abs:src"));
//					
//		}
//		
//		print("\nImports: (%d)", imports.size());
//		for(Element link : imports){
//			print(" * a: <%s> (%s)", link.tagName(), link.attr("abs:href"), link.attr("rel"));
//		}
//		
//		print("\nLinks: (%d)", links.size());
//		
//	}
//	
//	private static void print(String msg, Object... args){
//		System.out.println(String.format(msg, args));
//	}
//	
//	private static String trim(String s, int width){
//		if(s.length()> width)
//			return s.substring(0,width - 1) + ".";
//		else
//			return s;			
//	}
}

