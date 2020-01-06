package com.boinit.kerisaig.jpa;

import java.util.Optional;

import com.boinit.kerisaig.repository.entity.ModelDownload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelDownloadRepository extends JpaRepository<ModelDownload, Integer> {
    public Optional<ModelDownload> findByModelID(String modelID);
}