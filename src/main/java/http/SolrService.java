package http;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import dao.QueryItem;

public class SolrService 
{
	private static String solrUrl = "http://211.87.234.13:9999/solr/test";
	private static SolrClient solr = new HttpSolrClient(solrUrl);
	
	public static List<SolrDocument> query1(String query)
	{
		SolrQuery parameters = new SolrQuery();
		parameters.setQuery(query);
		parameters.setFields("id");
		parameters.setHighlight(true).setHighlightSnippets(1);
		parameters.setParam("hl.fl", "content");
		
		List<QueryItem> resList = new ArrayList<QueryItem>();
		SolrDocumentList docList = null;
		
		try {
			QueryResponse response = solr.query(parameters);
			docList = response.getResults();
			System.out.println("num found ~~~~~~~~~~~~~~~~~~~~ > \t" + docList.getNumFound());
			Iterator<SolrDocument> iter = response.getResults().iterator();
			QueryItem qitem = new QueryItem();
			while (iter.hasNext()) {
				SolrDocument resultDoc = iter.next();
				String id = (String) resultDoc.getFieldValue("id"); //id is the uniqueKey field
				qitem.setId(id);
				if (response.getHighlighting().get(id) != null) {
					List<String> highlightSnippets = response.getHighlighting().get(id).get("content");
					qitem.setText(highlightSnippets.toString());
					System.out.println("highlightSnippets:\t"+highlightSnippets);
					System.out.println("-----------> list size : \t" + highlightSnippets.size());
					resList.add(qitem);
				}
				System.out.println("title:\t"+(String) resultDoc.getFieldValue("title"));
				System.out.println("id:\t"+id);
				System.out.println("========================");
			}
			
//			for(SolrDocument sc : list)
//			{
//				System.out.println(sc);
//				System.out.println("========================");
//			}

			
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return docList;
	}
	
	public static List<QueryItem> query(String query)
	{
		SolrQuery parameters = new SolrQuery();
		parameters.setQuery(query);
		parameters.setFields("id");
		parameters.setRows(100);
		parameters.setHighlight(true).setHighlightSnippets(1);
		parameters.setParam("hl.fl", "content");
		parameters.setHighlightSimplePre("<font color=\"red\">");
		parameters.setHighlightSimplePost("</font>");
		
		List<QueryItem> resList = new ArrayList<QueryItem>();
		SolrDocumentList docList = null;
		
		try 
		{
			QueryResponse response = solr.query(parameters);
			docList = response.getResults();
			
			System.out.println("num found ~~~~~~~~~~~~~~~~~~~~ > \t" + docList.getNumFound());
			Iterator<SolrDocument> iter = response.getResults().iterator();
			
			while (iter.hasNext()) 
			{
				SolrDocument resultDoc = iter.next();
				String id = (String) resultDoc.getFieldValue("id"); //id is the uniqueKey field
				System.out.println("id:\t"+id);
				
				if (response.getHighlighting().get(id).get("content") != null) 
				{
					QueryItem qitem = new QueryItem();
					qitem.setId(id);
					List<String> highlightSnippets = response.getHighlighting().get(id).get("content");
					System.out.println("highlightSnippets:\t"+highlightSnippets);
					if(highlightSnippets!=null)
						qitem.setText(highlightSnippets.toString().replaceAll("[\\[\\]]", ""));
//					System.out.println("highlightSnippets:\t"+highlightSnippets);
//					System.out.println("-----------> list size : \t" + highlightSnippets.size());
					resList.add(qitem);
				}
//				System.out.println("title:\t"+(String) resultDoc.getFieldValue("title"));
				
				System.out.println("========================");
			}
			
//			for(SolrDocument sc : list)
//			{
//				System.out.println(sc);
//				System.out.println("========================");
//			}

			
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resList;
	}
	
	public static void index(File upfile, String type, String id)
	{
		ContentStreamUpdateRequest up = new ContentStreamUpdateRequest("/update/extract");
		try {
			//System.out.println("=====>" + upfile.length());
			up.addFile(upfile,type);
			up.setParam("literal.id", id);
			System.out.println("~~~~~~~~~~~~~>>>>" + id);
			up.setAction(ContentStreamUpdateRequest.ACTION.COMMIT, true, true);	
			solr.request(up);
			
			upfile.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
//		SolrService solr = new SolrService();
//		File tfile = new File("/Users/xianhe/");
//		if(tfile.exists())
//		{
//			//System.out.println("=====>" + tfile.length());
//		}
//		//solr.query("鏂规硶");
//		solr.index(tfile);
		
		File transferFile = new File("/Users/xianhe/doc/"+"woca");
		try {
			transferFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
