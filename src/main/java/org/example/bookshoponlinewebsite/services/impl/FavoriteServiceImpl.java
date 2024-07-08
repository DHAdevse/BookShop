package org.example.bookshoponlinewebsite.services.impl;

import org.example.bookshoponlinewebsite.models.Favorite;
import org.example.bookshoponlinewebsite.repositories.FavoriteRepository;
import org.example.bookshoponlinewebsite.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Override
    public Favorite findByUserid(String userId) {
        return favoriteRepository.getReferenceById(userId);
    }

    @Override
    public Favorite saveAndFlush(Favorite favorite) {
        return favoriteRepository.saveAndFlush(favorite);
    }

    @Override
    public Favorite getFavoriteByUserId(String userId) {
        return favoriteRepository.getFavoriteByUserId(userId);
    }
}
