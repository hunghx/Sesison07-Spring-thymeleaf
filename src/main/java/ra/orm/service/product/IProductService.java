package ra.orm.service.product;

import ra.orm.dto.request.CreateProductForm;
import ra.orm.entity.Category;
import ra.orm.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(CreateProductForm request);
}
