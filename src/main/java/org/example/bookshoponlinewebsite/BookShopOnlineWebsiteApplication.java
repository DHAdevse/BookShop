package org.example.bookshoponlinewebsite;

import org.example.bookshoponlinewebsite.models.*;
import org.example.bookshoponlinewebsite.services.*;
import org.example.bookshoponlinewebsite.utils.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BookShopOnlineWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookShopOnlineWebsiteApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ResourceLoader resourceLoader, GenerateID generateID,AuthorService authorService, UserService userService,
											   StockService stockService,CategoryService categoryService, PublisherService publisherService, BookService bookService)
	{
		return runner->{
			// ========================== AUTHOR ============================= //
//			Author author1 = new Author();
//			author1.setAuthorName("John Doe");
//			author1.setAuthorId("AUTH00002");
//			author1.setDob(new Date(70, 5, 15)); // Ngày 15 tháng 6 năm 1990
//			authorService.addAuthor(author1);
//
//			Author author2 = new Author();
//			author2.setAuthorName("Nguyen Nhat Anh");
//			author2.setAuthorId("AUTH00001");
//			author2.setDob(new Date(60, 6, 17)); // Ngày 15 tháng 6 năm 1990
//			authorService.addAuthor(author2);
//			Author author3 = new Author();
//			author3.setAuthorName("Kim Dong");
//			author3.setAuthorId("AUTH00003");
//			author3.setDob(new Date(90, 5, 15)); // Ngày 15 tháng 6 năm 1990
//			authorService.addAuthor(author3);
//
//			// ========================== USER ============================= //
//			// User 1
//
//			User user1 = new User();
//			user1.setUserId("USER00001");
//			user1.setFirstName("John");
//			user1.setLastName("Doe");
//			user1.setEmail("john.doe@example.com");
//			user1.setAddress("123 Main St, Anytown USA");
//			user1.setDob(new Date(88,3,30));
//			user1.setUsername("johndoe");
//			user1.setPassword("password123");
//			user1.setGender("Male");
//			user1.setPhoneNumber("555-1234");
//			userService.addUser(user1);
//
//			// User 2
//			User user2 = new User();
//			user2.setUserId("USER00002");
//			user2.setFirstName("Jane");
//			user2.setLastName("Smith");
//			user2.setEmail("jane.smith@example.com");
//			user2.setAddress("456 Oak Rd, Somewhere City");
//			user2.setDob(new Date(99,4,20));
//			user2.setUsername("janesmith");
//			user2.setPassword("qwerty456");
//			user2.setGender("Female");
//			user2.setPhoneNumber("555-5678");
//			userService.addUser(user2);
//			// User 3
//			User user3 = new User();
//			user3.setUserId("USER00003");
//			user3.setFirstName("Michael");
//			user3.setLastName("Johnson");
//			user3.setEmail("michael.johnson@example.com");
//			user3.setAddress("789 Elm St, Othertown");
//			user3.setDob(new Date(56,7,19));
//			user3.setUsername("michaelj");
//			user3.setPassword("abc123");
//			user3.setGender("Male");
//			user3.setPhoneNumber("555-9012");
//			userService.addUser(user3);
//			// User 4
//			User user4 = new User();
//			user4.setUserId("USER00004");
//			user4.setFirstName("Emily");
//			user4.setLastName("Brown");
//			user4.setEmail("emily.brown@example.com");
//			user4.setAddress("321 Oak St, Somewhere Else");
//			user4.setDob(new Date(87,5,24));
//			user4.setUsername("emilybrown");
//			user4.setPassword("pass456");
//			user4.setGender("Female");
//			user4.setPhoneNumber("555-3456");
//			userService.addUser(user4);
//			// User 5
//			User user5 = new User();
//			user5.setUserId("USER00005");
//			user5.setFirstName("David");
//			user5.setLastName("Lee");
//			user5.setEmail("david.lee@example.com");
//			user5.setAddress("654 Pine Rd, Anytown");
//			user5.setDob(new Date(104,8,18));
//			user5.setUsername("davidlee");
//			user5.setPassword("qwe123");
//			user5.setGender("Male");
//			user5.setPhoneNumber("555-7890");
//			userService.addUser(user5);
//
//			// ========================== CATEGORY ============================= //
//			Category category1 = new Category();
//			category1.setCategoryName("Drama");
//			category1.setCategoryId("CATE00001");
//
//			Category category2 = new Category();
//			category2.setCategoryName("Novel");
//			category2.setCategoryId("CATE00002");
//
//			Category category3 = new Category();
//			category3.setCategoryName("Poetry");
//			category3.setCategoryId("CATE00003");
//
//			Category category4 = new Category();
//			category4.setCategoryName("Science");
//			category4.setCategoryId("CATE00004");
//
//			Category category5 = new Category();
//			category5.setCategoryName("Mystery");
//			category5.setCategoryId("CATE00005");
//
//			categoryService.addCategory(category1);
//			categoryService.addCategory(category2);
//			categoryService.addCategory(category3);
//			categoryService.addCategory(category4);
//			categoryService.addCategory(category5);
//
//		// ========================== PUBLISHER ============================= //
//			Publisher publisher1 = new Publisher();
//			publisher1.setPublisherName("Random House");
//			publisher1.setPublisherId("PUBL00001");
//
//			Publisher publisher2 = new Publisher();
//			publisher2.setPublisherName("Penguin Random House");
//			publisher2.setPublisherId("PUBL00002");
//
//			Publisher publisher3 = new Publisher();
//			publisher3.setPublisherName("HarperCollins");
//			publisher3.setPublisherId("PUBL00003");
//
//			Publisher publisher4 = new Publisher();
//			publisher4.setPublisherName("Scholastic");
//			publisher4.setPublisherId("PUBL00004");
//
//			Publisher publisher5 = new Publisher();
//			publisher5.setPublisherName("Simon & Schuster");
//			publisher5.setPublisherId("PUBL00005");
//			publisherService.addPublisher(publisher1);
//			publisherService.addPublisher(publisher2);
//			publisherService.addPublisher(publisher3);
//			publisherService.addPublisher(publisher4);
//			publisherService.addPublisher(publisher5);

		// ========================== BOOK ============================= //
			// BOOK 1 : THE WOMEN : A NOVEL
//			Book the_women = new Book();
//
//			the_women.setBookId("BOOK00010");
//			the_women.setBookName("Hoàng Tử Bé");
//			the_women.setPublishDate(new Date(174,12,26));
//			the_women.setDescription("Cuốn sách đẹp như một bài thơ thanh sáng, một câu chuyện cổ tích về tình yêu thương, lòng nhân ái, ý nghĩa của sự tồn tại, về sự cảm thông giữa người với người");
//			double importPrice = 11.0;
//			the_women.setSellPrice(importPrice * 1.2);
//			the_women.setImageBook("hoangtube.png");
//			bookService.addBook(the_women);
//
//			List<Book> bookList1 = new ArrayList<>();
//			bookList1.add(the_women);
//			author1.setBookList(bookList1);
//			the_women.setAuthor(new ArrayList<>(Arrays.asList(author3, author2)));
//			the_women.setCategory(category1);
//			the_women.setPublisher(publisher1);
////			 add book to stock
//			Stock stock = new Stock();
//			stock.setStockId("STOC0003");
//			stock.setQuantity(100);
//			the_women.setStock(stock);
//			stockService.saveAndFlush(stock);

//			stock.setBook(the_women);
//			stock.setQuantity(100);
//			stock.setImportPrice(importPrice);
//			stockService.save(stock);
//			bookService.merge(the_women);



		};
	}
}
