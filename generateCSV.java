package crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class generateCSV {
	public static int g1=0, g2 = 0 ,g3=0, g4 = 0, g5 = 0;
	public void createCSV1(String data, int code) throws IOException{
//		int count = 0;
		try {
			
    		File file1 = new File ("C:\\Users\\RJ\\workspace\\crawler\\fetch_Newssite2.csv");
			if (file1.exists()){
				
				FileWriter fp = new FileWriter(file1, true);
				fp.write(data);
				fp.write(",");
				String statuscode = new Integer(code).toString();
				fp.write(statuscode);
				fp.write("\n");
				fp.flush();
				fp = null;
			}
			
		} catch (IOException e){
			
			e.printStackTrace();
		}
		
	}
	
	
	public void createCSV2(String url, int contentSize, int outlinks, String contentType) throws IOException{
//		int count = 0;
		try {
			File file2 = new File ("C:\\Users\\RJ\\workspace\\crawler\\visit_Newssite2.csv");
			
			if(contentSize < 1024){
				g1 += 1; 
			}else if(contentSize>= 1024 && contentSize < 10240){
				g2 += 1;
			}else if(contentSize>= 10240 && contentSize < 102400){
				g3 += 1;
			}else if(contentSize>= 102400 && contentSize < 1024000){
				g4 += 1;
			}else if(contentSize>= 1024000){
				g5 += 1;
			}
			
//			System.out.println(g1 + " " + g2 + " " + g3 + " " + g4 + " "+ g5 + " ");
			if (file2.exists()){
				FileWriter fp = new FileWriter(file2, true);
				fp.write(url);
				fp.write(",");
				String size = new Integer(contentSize).toString();
				fp.write(size);
				fp.write(",");
				String out = new Integer(outlinks).toString();
				fp.write(out);
				fp.write(",");
				fp.write(contentType);
				fp.write("\n");
				fp.flush();
				fp = null;
			}
			
		} catch (IOException e){
			
			e.printStackTrace();
		}
		
	}
	
	public void createCSV3(String data, String status) throws IOException{
//		int count = 0;
		try {
			File file3 = new File ("C:\\Users\\RJ\\workspace\\crawler\\urls_Newssite2.csv");
			if (file3.exists()){
				FileWriter fp = new FileWriter(file3, true);
				fp.write(data);
				fp.write(",");
				fp.write(status);
				fp.write("\n");
				fp.flush();
				fp = null;
			}
			
		} catch (IOException e){
			
			e.printStackTrace();
		}
		
	}
}
