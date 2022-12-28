package com.gosmart.usercontact.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;



public class FileUploadUtil 
{
	
	public static String saveFile(String fileName, MultipartFile multipartFile) throws IOException
	{
		
		Path uploadPath=Paths.get("fileUpload");
		
		
		if (!Files.exists(uploadPath))
		{
			Files.createDirectories(uploadPath);
		}
		
		String fileCode=RandomStringUtils.randomAlphanumeric(8);
		
		try(InputStream inputStream=multipartFile.getInputStream())
		{
			Path filePath=uploadPath.resolve(fileCode+"_"+fileName);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
			System.out.println("filePath:"+filePath);
			
		} 
		catch (IOException ioe) 
		{
			throw new IOException("could Not SaveFile"+ fileName, ioe);
			
		}
			
		
				
		return fileCode;
	}
	
}
