package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.Favorite;

public interface FavoriteService {
    public Favorite addFavorite (Favorite favorite);
    public Favorite findByUserid(String userId);
    public Favorite saveAndFlush(Favorite favorite);
    public Favorite getFavoriteByUserId(String userId);
}
