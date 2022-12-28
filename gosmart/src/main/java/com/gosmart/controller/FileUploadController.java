package com.gosmart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import com.gosmart.controller.response.FileUploadResponse;
import com.gosmart.usercontact.util.FileUploadUtil;

@RestController
public class FileUploadController
{
	@PostMapping("/uploadfile")
	public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile multipartFile)
	{
		try
		{
			String fileName=StringUtils.cleanPath(multipartFile.getOriginalFilename());
			long size=multipartFile.getSize();
			String fileCode=FileUploadUtil.saveFile(fileName, multipartFile);
			
			FileUploadResponse fileUploadResponse=new FileUploadResponse();
			
			fileUploadResponse.setFileName(fileName);
			fileUploadResponse.setSize(size);
			fileUploadResponse.setDownloadUri("/downloadfile/"+ fileCode);
			
			return new ResponseEntity<>(fileUploadResponse, HttpStatus.OK);
			
			
		} 
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
