package lombok;

import java.time.LocalDateTime;

// JavaBeans
// 1. Pola prywatne
// 2. gettery
// 3. settery
// 4. konstruktor/y
// 5. toString
@Getter // automatycznie dodaje gettery
@Setter // automatycznie dodaje settery do kodu
@NoArgsConstructor  // automatycznie dodaje konstruktor bezargumentowy
@AllArgsConstructor // automatycznie dodaje konstruktor z wysztkimi argumentami
@ToString           // automatycznie dodaje metodę toString
@EqualsAndHashCode  // automatycznie dodaje metodę equals & hashCode

public class User {
    private int userId;
    private String email;
    private String password;
    private LocalDateTime registrationDateTime;
    private boolean status;
    private boolean removed;
}
