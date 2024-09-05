/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.htn.service;

import com.htn.pojo.Document;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface DocumentService {
    List<Document> getDocuments(Map<String, String> params);
    Document getDocumentById(int id);
    boolean deleteDocumentByDocumentId(int id);
    void addOrUpdate(Document docu);
}
