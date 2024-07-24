package org.example.bookshoponlinewebsite.controllers;

import jakarta.servlet.http.HttpSession;
import org.example.bookshoponlinewebsite.models.*;
import org.example.bookshoponlinewebsite.services.BookService;
import org.example.bookshoponlinewebsite.services.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private BookService bookService;
    @GetMapping("")
    public String viewFavorite(HttpSession session)
    {
//        Favorite favorite = (Favorite) session.getAttribute("favorite");
        return "wishlist";
    }
    @GetMapping("/add-to-favorite/{bookId}")
    public String addFavorite(HttpSession session, @PathVariable("bookId") String bookId) {
        if (session.getAttribute("authUser") == null) {
            return "redirect:/login?redirectUrl=/book/" + bookId;
        }

        Favorite favorite = (Favorite) session.getAttribute("favorite");
        if (favorite == null) {
            favorite = new Favorite();
            session.setAttribute("favorite", favorite);
        }

        // Tìm sách từ cơ sở dữ liệu
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            // Xử lý trường hợp không tìm thấy sách
            return "redirect:/error";
        }

        // Kiểm tra xem sách đã có trong favorite chưa
        if (favorite.getBookList().stream().anyMatch(b -> b.getBookId().equals(bookId))) {
            // Sách đã tồn tại trong favorite
            return "redirect:/wishlist";
        }

        // Thêm sách vào favorite
        favorite.addBook(book);
        favoriteService.saveAndFlush(favorite);

        return "redirect:/wishlist";
    }
    @GetMapping("remove-favorite/{bookId}")
    public String removeFavorite(HttpSession session, @PathVariable("bookId") String bookId, RedirectAttributes redirect)
    {
        Favorite favorite = (Favorite) session.getAttribute("favorite");
        if(favorite==null)
        {
            redirect.addFlashAttribute("error","Cart not found");
            return "redirect:/wishlist";
        }
       Book book = favorite.getBookList().stream()
               .filter(bookTemp -> bookTemp.getBookId().equals(bookId))
               .findFirst()
               .orElse(null);
        favorite.removeBook(book);
        favoriteService.saveAndFlush(favorite);
        return "wishlist";
    }
}
