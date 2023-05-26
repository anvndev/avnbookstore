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
    public String showAllBooks(Model model) {
        List<Book> books = bookServices.getAllBooks();
        model.addAttribute("books", books);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryServices.getAllCategories());
        return "book/add";
    }

    @GetMapping("/edit")
    public String editBook(@RequestParam("id") Long id, Model model) {
        Book book = bookServices.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("categories", categoryServices.getAllCategories());
        return "book/edit";
    }

    @GetMapping(value = "/delete", params = "id")
    public String deleteBook(@RequestParam("id") Long id){
        bookServices.deleteBook(id);
        return "redirect:/books";
    }

    @PostMapping("/save")
    public String saveBook(@Valid @ModelAttribute("book") Book book,
                           BindingResult bindingResult,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        String viewName = "book/add";
        if (book.getId() != null)
            viewName = "book/edit";

        if (bindingResult.hasErrors()) {
            model.addAttribute("pageTitle", (book.getId() != null) ? "Edit Book" : "Add Book");
            return viewName;
        }

        bookServices.addBook(book);
        redirectAttributes.addFlashAttribute("message", "Book saved successfully");
        return "redirect:/books";
    }
}

//tuan 2