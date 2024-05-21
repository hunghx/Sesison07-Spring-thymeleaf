package ra.orm.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ra.orm.entity.Product;
import ra.orm.repository.IProductRepository;

import javax.transaction.Transactional;

@Component
@Transactional
public class ProductNameValidator implements Validator {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) { // là đối tượng request nhận về
        Product product = (Product) target;

    }
}
