package kartik.URL.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "urls")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String urlCode;


    @Column(nullable = false, unique = true)
    private String originalUrl;

}
