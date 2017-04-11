package com.michir.jee7.async;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

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
import org.apache.commons.fileupload.servlet.ServletRequestContext;

@Provider
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class MultipartFormdataReader implements MessageBodyReader<List<FileItem>> {

	@Context
	private Providers workers;

	@Context
	private HttpServletRequest req;

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return type.equals(List.class);
	}

	@Override
	public List<FileItem> readFrom(Class<List<FileItem>> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload();
		fileUpload.setFileItemFactory(factory);

		try {
			return fileUpload.parseRequest(new ServletRequestContext(req));
		} catch (FileUploadException e) {
			throw new IOException(e);
		}
	}
}