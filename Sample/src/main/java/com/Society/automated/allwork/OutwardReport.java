package com.Society.automated.allwork;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class OutwardReport
 * 
 * THIS CLASS IS FOR GENERATING OUTWARD REPORT
 * 
 */
public class OutwardReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static Logger logger=LoggerFactory.getLogger(OutwardReport.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutwardReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql=request.getParameter("sql");
		SqlReportDao sqlreportdao=new SqlReportDao();
		String name=sqlreportdao.createOutward(sql);
		String path="file:///D:/normal/"+name;
		ServletOutputStream out=response.getOutputStream();
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition",
                  "inline; filename" + name);
		String fileURL=path;
		BufferedInputStream  bis = null;
		BufferedOutputStream bos = null;
		try {
		URL url=new URL(fileURL);
//			URL url = new URL( "http", PROXY_HOST, 
//                    Integer.parseInt(PROXY_PORT), fileURL  );
		bis = new BufferedInputStream(url.openStream());
		bos= new BufferedOutputStream(out);
		    byte[] buff = new byte[2048];
		    int bytesRead; 
		    while(-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
		        bos.write(buff, 0, bytesRead);
		    }
		    logger.info("Outward Report {} Generated",name);
		}
		catch(final MalformedURLException e) {
			logger.error("MalformedURLException.");
	        System.out.println ( "MalformedURLException." );
	        throw e;
	    } catch(final IOException e) {
	    	logger.error("IOException.");
	        System.out.println ( "IOException." );
	        throw e;
	    } 
		finally {
			if (bis != null)
	            bis.close();
	        if (bos != null)
	            bos.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
