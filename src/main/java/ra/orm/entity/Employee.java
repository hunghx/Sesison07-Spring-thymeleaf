package ra.orm.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // @NotEmpty // mảng , collection , ko được null, size > 0
    @NotBlank(message = "ko được để trống") //  ko để trống ,""
//    @NotNull // ko đc mang giá trị null
    private String name;
    @Column(columnDefinition = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    private Boolean sex;
    private Boolean isDelete;
}
