package bookstore.avn.avnbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bookstore.avn.avnbookstore.entity.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
}
