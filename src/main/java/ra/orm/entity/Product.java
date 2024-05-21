package ra.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import ra.orm.validator.ProducNameUnique;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;
    @Column(length = 50)
    @Size(min = 4, max = 20) // độ dài chỗi
    private String name;
    @Pattern(regexp = "^[a-zA-Z0-9]{5,}$")
    private String description;
    @Column(precision = 10,scale = 2)
    private BigDecimal price;
    @Min(value = 10) // giá trị bé nhất  =10 / number
    @Max(value = 100)
    private Integer stock;
    @Enumerated(EnumType.STRING) // lấy tên của enum để làm giá trị cho enum trong sql
    @Column(columnDefinition = "enum('MALE','FEMALE')")
    private ProductType productType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private Date createdAt;
    private Boolean isDeleted;
}
