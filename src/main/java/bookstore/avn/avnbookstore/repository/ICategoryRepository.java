package bookstore.avn.avnbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bookstore.avn.avnbookstore.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
