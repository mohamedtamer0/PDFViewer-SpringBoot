package com.tamer.pdfviewer.controller;

import com.tamer.pdfviewer.Entity.PDFFile;
import com.tamer.pdfviewer.service.PDFFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/pdf")
public class PDFController {

    @Autowired
    private PDFFileService pdfFileService;

    @GetMapping("/upload")
    public String uploadForm(Model model) {
        List<PDFFile> files = pdfFileService.getAllFiles();
        model.addAttribute("files", files);
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            PDFFile pdfFile = pdfFileService.storeFile(file);
            redirectAttributes.addFlashAttribute("message", "File uploaded successfully: " + pdfFile.getId());
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("message", "Error uploading file");
        }
        return "redirect:/pdf/upload";
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Resource> viewFile(@PathVariable("id") Long id) {
        PDFFile pdfFile = pdfFileService.getFile(id);
        if (pdfFile != null) {
            ByteArrayResource resource = new ByteArrayResource(pdfFile.getData());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + pdfFile.getFileName() + "\"")
                    .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                    .contentLength(pdfFile.getData().length)
                    .body(resource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PostMapping("/delete/{id}")
    public String deleteFile(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            pdfFileService.deleteFile(id);
            redirectAttributes.addFlashAttribute("message", "File deleted successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error deleting file");
        }
        return "redirect:/pdf/upload";
    }
}