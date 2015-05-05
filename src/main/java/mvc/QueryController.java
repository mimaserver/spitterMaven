package mvc;

import http.SolrService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.QueryItem;

@Controller
public class QueryController
{
	@RequestMapping({"query"})
	public String  showSearchPage(@RequestParam("query") String query, Model model) throws UnsupportedEncodingException
	{
		System.out.println("================> query = "+query + "~~~~~\t:" + new String(query.getBytes("ISO-8859-1"),"UTF-8"));
		
		//query= new String(query.getBytes("ISO-8859-1"),"UTF-8");
		
		List<QueryItem> items = SolrService.query(query);
		model.addAttribute(items);

		return "query.jsp";
	}
}