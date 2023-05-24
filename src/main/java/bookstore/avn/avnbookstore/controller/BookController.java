package bookstore.avn.avnbookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import bookstore.avn.avnbookstore.entity.Book;
import bookstore.avn.avnbookstore.services.CategoryServices;
import bookstore.avn.avnbookstore.services.BookServices;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServices bookServices;

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public String showAllBooks(Model model){
        List<Book> books = bookServices.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryServices.getAllCategories());
        return "book/add";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute("book") Book book){
        bookServices.addBook(book);
        return "redirect:/books";
    }
}

