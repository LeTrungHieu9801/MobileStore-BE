package com.ecommerce.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ecommerce.repository.FileManager;

@Service
public class FileService implements IFileService {

	private FileManager fileManager = new FileManager();
	private String linkFolder = "D:\\Desktop\\project_mobile\\ecommerce\\web\\images";

	@Override
	public String uploadImage(MultipartFile image) throws IOException {

		String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());

		String path = linkFolder + "\\" + nameImage;

		fileManager.createNewMultiPartFile(path, image);

		return nameImage;
	}

	@Override
	public File dowwnloadImage(String nameImage) throws IOException {

		String path = linkFolder + "\\" + nameImage;

		return new File(path);
	}
}
