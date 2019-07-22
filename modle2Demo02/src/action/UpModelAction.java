package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.ActionForward;

public class UpModelAction implements Action{
	private static final String SAVE_DIR = "uploadFiles";


	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("UpSaveTest");
		try {
			update(request,response);
		}catch(ServletException e) {
			e.printStackTrace();
		}
		return new ActionForward("success.jsp", false);
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//현재 결로를 가져와서 파일에 객체로 생성
		String appPath = request.getServletContext().getRealPath("");
		System.out.println("getRealPath : "+appPath);
		// separator 운영체제의 경로 펴기
		String savePath = appPath + File.separator + SAVE_DIR;
		System.out.println("savePath : "+savePath);
		File fileSaveDir = new File(savePath);
		if(!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		for(Part part : request.getParts()) {
			System.out.println("Part : "+part.getName());
			if(part.getName().equals("file")) {
				String fileName = extractFileName(part);
				System.out.println("fileName : "+fileName);
				fileName = new File(fileName).getName();
				part.write(savePath+File.separator+fileName);
			}
		}
	}
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=")+2,s.length()-1);
			}
		}
		return "";
	}

}
