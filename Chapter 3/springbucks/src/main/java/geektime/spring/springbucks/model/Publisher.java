package geektime.spring.springbucks.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_PUBLISHER")
@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publisher extends BaseEntity implements Serializable {
    private String name;
}
