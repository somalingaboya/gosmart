package com.gosmart.usercontact.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class FiledownloadUtil
{
	private Path foundFile;
	public Resource getFileAsResource(String fileCode) throws IOException
	{
		Path uploadedPath=Paths.get("fileUpload");
		
		Files.list(uploadedPath).forEach(file
				->{if(file.getFileName().toString().startsWith(fileCode))
				{
					foundFile=file;
					System.out.println(uploadedPath.toUri().getRawPath());
					
					return;
				}
				});
		
		if (foundFile!=null) 
		{
			return new UrlResource(foundFile.toUri());
			
		}
		return null;
	}
}
