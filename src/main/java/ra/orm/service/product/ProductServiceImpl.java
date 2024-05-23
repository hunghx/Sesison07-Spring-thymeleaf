package ra.orm.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.orm.dto.request.CreateProductForm;
import ra.orm.entity.Category;
import ra.orm.entity.Product;
import ra.orm.repository.ICategoryRepository;
import ra.orm.repository.IProductRepository;
import ra.orm.service.UploadService;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService{
    @Autowired
    private UploadService uploadService;
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(CreateProductForm request) {
        // chuyển đổi dto -> entity
        Product product = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .stock(request.getStock())
                .createdAt(new Date())
                .isDeleted(false)
                .build();

        // chuyển đoi category id
        Category category = null;
        if (request.getCategoryId()!=0){
            category = categoryRepository.findById(request.getCategoryId());
        }
        product.setCategory(category);
        // upload ảnh
        if (request.getFile().getSize()!=0){
            String url = uploadService.uploadFileToServer(request.getFile());
            product.setImageUrl(url);
        }
        productRepository.save(product);
    }
}
