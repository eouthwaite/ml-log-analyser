package com.marklogic.analyser.resources;

import com.marklogic.analyser.FileProcessManager;
import com.sun.jersey.api.view.Viewable;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ableasdale
 * Date: 4/6/14
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */

@Path("/upload")
public class UploadResource extends BaseResource {

    private static final Logger LOG = LoggerFactory.getLogger(UploadResource.class);

    private Map<String, Object> createModel() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "Upload ErrorLog");
        return map;
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable uploadPage() {
        return new Viewable("/upload", createModel());
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadHandler(
            @FormDataParam("file") InputStream fileInputStream,
            @FormDataParam("file") FormDataContentDisposition contentDispositionHeader
    ) {

        String filePath = contentDispositionHeader.getFileName();

        LOG.info(String.format("Handling the upload of a new ErrorLog / Messages file: %s", filePath));
        FileProcessManager fpm = new FileProcessManager();
        try {
            fpm.processUploadedFile(fileInputStream, filePath);
        } catch (IOException e) {
            LOG.error(MessageFormat.format("IO Exception caught processing file {0}: {1}", filePath, e.getMessage()));
        }
        return Response.ok().build();
    }

}
