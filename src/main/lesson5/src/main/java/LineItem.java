import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "line_items")
@NoArgsConstructor
    public class LineItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private ProductSpringDTO productSpringDTO;

        @ManyToOne
        @JoinColumn(name = "customer_id")
        private Customer customer;

    private String productTitle;
    private int cost;
    private int amount;
    private String origin;
    }

