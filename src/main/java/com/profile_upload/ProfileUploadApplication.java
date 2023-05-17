package com.profile_upload;

import com.profile_upload.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@SpringBootApplication
@RequestMapping("/profile")
public class ProfileUploadApplication {
	@Autowired
	private StorageService service;
     @PostMapping
	public ResponseEntity<?> uploadProfile(@RequestParam("profile")MultipartFile file) throws IOException {
		String uploadProfile = service.uploadProfile(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadProfile);
	}
	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadProfile(@PathVariable String fileName){
		byte[] profileData = service.downloadProfile(fileName);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("profile/png")).body(profileData);
	}


	public static void main(String[] args) {
		SpringApplication.run(ProfileUploadApplication.class, args);
	}

}
