package ra.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String name;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private Integer stock;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "created_at", columnDefinition = "date")
    private Date createdAt;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "is_deleted")
    private boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
