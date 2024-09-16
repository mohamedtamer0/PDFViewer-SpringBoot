package com.tamer.pdfviewer.service;

import com.tamer.pdfviewer.Entity.PDFFile;
import com.tamer.pdfviewer.dao.PDFFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PDFFileService {

    @Autowired
    private PDFFileRepository pdfFileRepository;

    public PDFFile storeFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String fileType = file.getContentType();
        byte[] data = file.getBytes();

        PDFFile pdfFile = new PDFFile(fileName, fileType, data);
        return pdfFileRepository.save(pdfFile);
    }

    public PDFFile getFile(Long fileId) {
        return pdfFileRepository.findById(fileId).orElse(null);
    }

    public List<PDFFile> getAllFiles() {
        return pdfFileRepository.findAll();
    }

    public void deleteFile(Long fileId) {
        pdfFileRepository.deleteById(fileId);
    }

}
