/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service.impl;

import com.htn.pojo.Document;
import com.htn.repository.DocumentRepository;
import com.htn.service.DocumentService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author DELL
 */
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository docuRepo;

    @Override
    public List<Document> getDocuments(Map<String, String> params) {
        return this.docuRepo.getDocuments(params);
    }

    @Override
    public Document getDocumentById(int id) {
        return this.docuRepo.getDocumentById(id);
    }

    @Override
    public boolean deleteDocument(int id) {
        return this.docuRepo.deleteDocument(id);
    }
    
    @Override
    public void addOrUpdate(Document docu) {
        this.docuRepo.addOrUpdate(docu);
    }
    
}
