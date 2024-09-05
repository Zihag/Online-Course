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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Service
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
    public boolean deleteDocumentByDocumentId(int id) {
        Document d = this.docuRepo.getDocumentById(id);
        if(d == null) {
            return false;
        }
        this.docuRepo.deleteDocument(d);
        return true;
    }
    
    @Override
    public void addOrUpdate(Document docu) {
        this.docuRepo.addOrUpdate(docu);
    }
    
}
