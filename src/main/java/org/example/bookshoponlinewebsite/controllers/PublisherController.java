package org.example.bookshoponlinewebsite.controllers;

import org.example.bookshoponlinewebsite.models.Publisher;
import org.example.bookshoponlinewebsite.services.PublisherService;
import org.example.bookshoponlinewebsite.utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublisherController {
    @Autowired
    private PublisherService publisherService;
    @Autowired
    private GenerateID generateID;
//    @GetMapping("all")
//    public String getAllPublishers(Model model)
//    {
//        try {
//            List<Publisher> publisherList = publisherService.getListPublisher();
//            model.addAttribute("publishers",publisherList);
//            return "index";
//        }catch(Exception e)
//        {
//            return "index";
//        }
//    }
    //CRUD
    @PostMapping("admin/addPublisher")
    public String addPublisher(@ModelAttribute Publisher publisher)
    {
        Publisher publisherCreate = new Publisher();
        publisherCreate.setPublisherId(generateID.generatePublisherId());
        publisherCreate.setPublisherName(publisher.getPublisherName());
        publisherService.addPublisher(publisherCreate);
        return "redirect:/admin/table";
    }
    @GetMapping("admin/removePublisher/{id}")
    public String removePublisher(@PathVariable("id") String publisherId)
    {
        publisherService.deletePublisher(publisherId);
        return "redirect:/admin/table";
    }
    @PostMapping("admin/updatePublisher")
    public String updatePublisher(@RequestParam("publisherId") String id,@RequestParam("newPublisherName") String publisherName)
    {
        Publisher publisher = publisherService.getPublisherById(id);
        publisher.setPublisherName(publisherName);
        publisherService.saveandFlush(publisher);
        return "admin/table";
    }
}
