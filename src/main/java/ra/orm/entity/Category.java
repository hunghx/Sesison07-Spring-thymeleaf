package ra.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@NoArgsConstructor@AllArgsConstructor
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "is_deleted")
    private boolean isDeleted;
}
