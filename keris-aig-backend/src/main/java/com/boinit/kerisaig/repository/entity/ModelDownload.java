package com.boinit.kerisaig.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MODEL_DOWNLOAD")
public class ModelDownload implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -3282196495330420672L;

    @Column(name = "ID")
    @Id
    @GeneratedValue
    private int Id;

    @Column(name = "MODEL_ID")
    private String modelID;

    @Column(name = "DOWNLOAD_COUNT")
    private int downloadCount;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getModelID() {
        return modelID;
    }

    public void setModelID(String modelID) {
        this.modelID = modelID;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }
}