package com.michir.jee7.async;

import java.util.List;
import java.util.Map;

import javax.mail.search.MessageIDTerm;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.fileupload.FileItem;

@Path("/upload")
public class UploadServlet {

	@Context
	private HttpServletRequest req;
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void uploadFile(List<FileItem> files) {
		files.stream().forEach(f -> {
			System.out.println("============");
			System.out.println(f.getName());
			System.out.println(f.getSize());
			System.out.println(f.getHeaders());
			System.out.println(f.getFieldName());
			System.out.println(f.getContentType());
		});
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String onJson(Map<String, List<FileItem>> files) {
		files.forEach((k,v) -> {
			System.out.println("===map===map===map===map===map===map===");
			System.out.println(k);
			v.stream().forEach(f -> {
				System.out.println("============");
				System.out.println(f.getName());
				System.out.println(f.getSize());
				System.out.println(f.getHeaders());
				System.out.println(f.getFieldName());
				System.out.println(f.getContentType());
			});
		});
		return files.values().iterator().next().get(0).getName();
	}
}
