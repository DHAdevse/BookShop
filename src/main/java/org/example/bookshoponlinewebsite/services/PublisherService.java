package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Publisher;

import java.util.List;

public interface PublisherService {
    //CRUD
    Publisher addPublisher(Publisher publisher);
    Publisher getPublisherById(String id);
    Publisher getPublisherByName(String name);
    Publisher updatePublisher(Publisher publisher);
    List<Publisher> getListPublisher();
    boolean deletePublisher(String id);
}
