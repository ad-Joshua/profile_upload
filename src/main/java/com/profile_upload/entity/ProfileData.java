package com.profile_upload.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ProfileData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;
    @Lob
    @Column(name= "ProfileData", length = 100000)
    private byte[] profileData;




}
