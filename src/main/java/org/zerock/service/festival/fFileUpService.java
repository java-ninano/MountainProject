package org.zerock.service.festival;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class fFileUpService {
	@Setter(onMethod_ =@Autowired )
	private String ociConfigPath;
	
	//jar -->pom.xml 수정
	public void transfer(MultipartFile file, String fileName) throws Exception {
		String profile = "DEFAULT";

		String objectName = file.getOriginalFilename();
		
		if (fileName != null) {
			objectName = fileName;
		}
	}
	public void write(MultipartFile file) {
		write(file,null);
	}
	public void write(MultipartFile file, String filename) {
		String path="/temp2/" + filename;
		
		if(filename == null) {
			path="/temp2/" + file.getOriginalFilename();
		}
		try (
				InputStream is = file.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);
				
				FileOutputStream os = new FileOutputStream(path);
				BufferedOutputStream bos = new BufferedOutputStream(os);
				) {
				
				byte[] buffer = new byte[1024];
				int b = 0;
				while ((b = bis.read(buffer)) != -1) {
					bos.write(buffer, 0, b);
				}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
