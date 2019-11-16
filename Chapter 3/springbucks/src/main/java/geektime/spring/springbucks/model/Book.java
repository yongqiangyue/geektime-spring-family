package geektime.spring.springbucks.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "T_BOOK")
@Builder
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Book extends BaseEntity implements Serializable {
    private String name;
    @ManyToMany
    @JoinTable(name = "T_BOOK_PUBLISHER")
    @OrderBy("id")
    private Set<Publisher> publishers;
}
