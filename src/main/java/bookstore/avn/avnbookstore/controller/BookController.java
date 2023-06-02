package bookstore.avn.avnbookstore.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import bookstore.avn.avnbookstore.entity.Book;
import bookstore.avn.avnbookstore.services.CategoryServices;
import bookstore.avn.avnbookstore.services.BookServices;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult binndingresult, Model model){
        if (binndingresult.hasErrors()){
            model.addAttribute("categories",categoryServices.getAllCategories());
            return "book/add";
        }

        bookServices.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id, Model model){
        bookServices.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model){
        Book book = bookServices.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("selected", book.getCategory().getId());
        model.addAttribute("categories", categoryServices.getAllCategories());

        return "book/edit";
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) throws IOException {
        if(result.hasErrors()){
            model.addAttribute("selected", book.getCategory().getId());
            model.addAttribute("categories", categoryServices.getAllCategories());
            return "book/edit";
        }
        else {
            bookServices.updateBook(book);
        }
        return "redirect:/books";
    }

}
