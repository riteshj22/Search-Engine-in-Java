package crawler;

import java.io.FileWriter;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class controller {

	public static void main(String[] args) throws Exception {
		String crawlStorageFolder = "data/crawl1";
		int numberOfCrawlers = 1; 
		int maxDepthOfCrawling = 16;
		int maxPagesToFetch = 10000;
		int politenessDelay = 400;
		/*  String userAgentString = "Ritesh";*/
		
		CrawlConfig config = new CrawlConfig();
		config.setCrawlStorageFolder(crawlStorageFolder);
		config.setMaxDepthOfCrawling(maxDepthOfCrawling);
		config.setMaxPagesToFetch(maxPagesToFetch);
		config.setPolitenessDelay(politenessDelay);
		config.setIncludeBinaryContentInCrawling(true);
		//config.setUserAgentString(userAgentString);*/
		/*
		 * Instantiate the controller for the crawl
		 */
		PageFetcher pageFetcher = new PageFetcher(config);
		RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		CrawlController controller =new CrawlController(config,pageFetcher,robotstxtServer);
		
		/* 
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */ 
		
		controller.addSeed("http://abcnews.go.com/");
		
		/* 
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
		
		FileWriter f1 = new FileWriter("fetch_Newssite2.csv");
		FileWriter f2 = new FileWriter("visit_Newssite2.csv");
		FileWriter f3 = new FileWriter("urls_Newssite2.csv");
		controller.start(MyCrawler.class,  numberOfCrawlers);
		
//		generateCSV obj = new generateCSV();
		System.out.println(generateCSV.g1 + " " + generateCSV.g2 + " " + generateCSV.g3 + " " + generateCSV.g4 + " "+ generateCSV.g5 + " ");
//		MyCrawler obj1 = new MyCrawler();
		System.out.println("fetch success " + MyCrawler.fetch_success);
		System.out.println("fetch aborted " + MyCrawler.fetch_aborted);
		System.out.println("fetch failed " + MyCrawler.fetch_failed);
		System.out.println("------------------------------");
		System.out.println("200 " + MyCrawler.success);
		System.out.println("301 " + MyCrawler.three);
		System.out.println("401 " + MyCrawler.unauthorized);
		System.out.println("403 " + MyCrawler.forbidden);
		System.out.println("404 " + MyCrawler.not_found);
		System.out.println("------------------------------");
		System.out.println("html " + MyCrawler.html1);
		System.out.println("gif " + MyCrawler.gif);
		System.out.println("jpeg " + MyCrawler.jpg);
		System.out.println("png " + MyCrawler.png);
		System.out.println("pdf " + MyCrawler.pdf);
//		System.out.println("domain " + MyCrawler.uniqueDomain);
//		System.out.println("nondomain" + MyCrawler.uniqueNonDomain);
	}

}
