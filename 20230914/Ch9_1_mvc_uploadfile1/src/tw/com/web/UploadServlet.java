package tw.com.web;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 Part part =  req.getPart("photo");
		 String fileName = part.getSubmittedFileName();
		//System.out.println(fileName);
		//改變了路徑
		 String fileDir = "C:\\upload_images"+File.separator+fileName;
		 File outFile = new File(fileDir);
		 try(InputStream st = part.getInputStream();
			FileOutputStream fout = new FileOutputStream(outFile)){
			byte[] cache = new byte[1024];
			int index = -1;
			while( (index = st.read(cache)) != -1 ) {
				fout.write(cache, 0, index);
			}
		 }
		 resp.sendRedirect("view_images");
	}
}
