package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.LineItem;

import java.util.List;

public interface LineItemService {
    LineItem addLineItem(LineItem lineItem);
    boolean deleteLineItem(String id);
    LineItem updateLineItem(LineItem lineItem);
    LineItem getLineItem(String id);
//    public List<LineItem> getListItemOfFavorite(String userId); favorite chi chua product k co quantity phai dat ham o class khac
    List<LineItem> getListItemOfCart(String userId);
}
