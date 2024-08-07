package org.example.bookshoponlinewebsite.repositories;

import org.example.bookshoponlinewebsite.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,String> {
    public Favorite getFavoriteByUserId(String userId);
}
