package com.tools.test.hepler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	// User for Only My Computer
	String UPLOAD_DIR = "E:\\University_work\\Software\\WebSoftware\\Spring Boot Problem\\learn-spring-boot\\SpringBootRestAPI\\src\\main\\resources\\static\\image";
	// User for MultiComputer
	//final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException
	{
		
	}
	public boolean uploadFile(MultipartFile file) {
		boolean f = false;

		try {
			f = true;
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
