import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "contacts")
@NoArgsConstructor
public class CustomerContact {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private CustomerContactType type;

        @Column(nullable = false)
        private String value;

        @ManyToOne
        private ProductSpringDTO productSpringDTO;

        public CustomerContact(CustomerContactType type, String value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Contact{" +
                    "id=" + id +
                    ", type=" + type +
                    ", value='" + value + '\'' +
                    ", userId=" + productSpringDTO.getId() +
                    '}';
        }
    }

