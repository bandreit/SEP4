package via.sep4.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * The interface Product repository. It contains methods for performing CRUD operations,
 * sorting and paginating data
 */
@Component
public interface ProductRepository extends JpaRepository<Product, Long> {
}
