package com.app.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;

public interface ImageHandlingService {

	ApiResponse uploadImage(Long empId, MultipartFile imageFile) throws IOException;
	byte[] serveImage(Long empId) throws IOException;

}
