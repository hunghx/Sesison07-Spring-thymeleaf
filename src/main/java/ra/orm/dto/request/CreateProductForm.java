package ra.orm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateProductForm {
    private String name;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private Integer categoryId;
    private MultipartFile file;
}
