import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customers")
@NoArgsConstructor
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @OneToOne
        private ProductSpringDTO productSpringDTO;

        @OneToMany(mappedBy = "customer")
        private List<LineItem> products;

    }

