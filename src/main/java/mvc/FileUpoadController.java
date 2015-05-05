package mvc;

import http.SolrService;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller  
public class FileUpoadController {  

	@RequestMapping(value="form", method = RequestMethod.POST)  
	public String handleFormUpload(@RequestParam("file") MultipartFile file) throws IOException 
	{  
		if (!file.isEmpty()) 
		{  
			// 转存文件到本地
			File transferFile = new File("/home/xianhe/tmp/"+file.getOriginalFilename());
			file.transferTo(transferFile);
			
			// 索引文件
			SolrService.index(transferFile, file.getContentType(), new String(file.getOriginalFilename().getBytes("ISO8859-1"),"UTF-8"));

			return "upload.jsp";  
		} 
		else 
		{  
			return "search.jsp";  
		}  
	}  

}  