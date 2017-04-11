package com.michir.jee7.async;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@Provider
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class MapMultipartFormdataReader implements MessageBodyReader<Map<String, List<FileItem>>> {

	@Context
	private Providers workers;

	@Context
	private HttpServletRequest req;

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return type.equals(Map.class);
	}

	@Override
	public Map<String, List<FileItem>> readFrom(Class<Map<String, List<FileItem>>> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload();
		fileUpload.setFileItemFactory(factory);

		System.out.println("content-type: "+req.getContentType());
		System.out.println("default charset: "+Charset.defaultCharset());
		
		
		try {
			return fileUpload.parseParameterMap(req);
		} catch (FileUploadException e) {
			throw new IOException(e);
		}
	}
}