package com.profile_upload.repository;

import com.profile_upload.entity.ProfileData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ProfileData, Long> {

    Optional<ProfileData> findByName(String fileName);
}
