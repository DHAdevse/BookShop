package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Publisher;
import org.example.bookshoponlinewebsite.repositories.PublisherRepository;
import org.example.bookshoponlinewebsite.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;
    @Override
    public Publisher addPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(String id) {
        return publisherRepository.getReferenceById(id);
    }

    @Override
    public Publisher getPublisherByName(String name) {
         return publisherRepository.getPublisherByPublisherName(name);
    }

    @Override
    public Publisher updatePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> getListPublisher() {
         return publisherRepository.findAll();
    }

    @Override
    public boolean deletePublisher(String id) {
        if(publisherRepository.existsById(id))
        {
            publisherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
