package services.book.impl;

import dao.DAOFactory;
import dao.book.BookDAO;
import entities.book.Book;
import services.book.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookServiceImpl implements BookService {
    private BookDAO bookDAO = DAOFactory.getInstance().getBookDAO();
    @Override
    public Book add(String bookName, String imageURL, int authorID, int categoryId, double price, int pageCount, String description) {
        Book book = new Book();
        book.setName(bookName);
        book.setImageURL(imageURL);
        book.setAuthorId(authorID);
        book.setCategoryId(categoryId);
        book.setPrice(price);
        book.setPageCount(pageCount);
        book.setDescription(description);
        bookDAO.createBook(book);
        return book;
    }

    @Override
    public Book get(String bookName, int authorID) {
        return bookDAO.readBook(bookName, authorID);
    }

    @Override
    public Book get(int bookId) {
        return  bookDAO.readBook(bookId);
    }

    @Override
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    public int getBooksCount() {
        return bookDAO.getBooks().size();
    }

    @Override
    public List<Book> getSliderBooks() {
        List<Book> books = bookDAO.getBooks();
        Random r = new Random();
        List<Book> sliderBook = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            sliderBook.add(books.get(r.nextInt(books.size())));
        }
        return sliderBook;
    }

    @Override
    public Book updateBook(Book book) {
        return bookDAO.updateBook(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookDAO.deleteBook(book);
    }
}
