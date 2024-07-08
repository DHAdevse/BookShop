package org.example.bookshoponlinewebsite.services;

import org.example.bookshoponlinewebsite.models.LineItem;

public interface LineItemService {
    public LineItem addLineItem(LineItem lineItem);
    public boolean deleteLineItem(String id);
    public LineItem updateLineItem(LineItem lineItem);
    public LineItem getLineItem(String id);
    public LineItem saveAndFlush(LineItem lineItem);

//    public List<LineItem> getListItemOfFavorite(String userId); favorite chi chua product k co quantity phai dat ham o class khac
//    List<LineItem> getListItemOfCart(String userId);
}
