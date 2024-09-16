package com.tamer.pdfviewer.dao;

import com.tamer.pdfviewer.Entity.PDFFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PDFFileRepository extends JpaRepository<PDFFile, Long> {
}
