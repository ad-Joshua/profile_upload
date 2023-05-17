package com.profile_upload.services;

import com.profile_upload.entity.ProfileData;
import com.profile_upload.repository.StorageRepository;
import com.profile_upload.utils.ProfileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

//    public StorageService(StorageRepository repository){
//        this.repository= repository;
//    }

    public String uploadProfile(MultipartFile file) throws IOException {
        ProfileData profileData = repository.save(ProfileData.builder()
                .name(file.getOriginalFilename())  //file details/image is compressed n stored in dB
                .type(file.getContentType())
                .profileData(ProfileUtils.compressProfile(file.getBytes())).build());
        if(profileData!=null){
            return "file upload successfully" +file.getOriginalFilename();
        }
        return null;
    }
    public byte[] downloadProfile(String fileName){
        Optional<ProfileData> dbProfileData = repository.findByName(fileName);
        byte[] profiles = ProfileUtils.decompressProfile(dbProfileData.get().getProfileData());
        return profiles;
    }

}
