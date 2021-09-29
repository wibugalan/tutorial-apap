package apap.tutorial.cineplux.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "penjaga")
public class PenjagaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noPenjaga;

    @NotNull
    @Size(max = 30)
    @Column(nullable = false)
    private String namaPenjaga;

    @NotNull
    @Column(nullable = false)
    private Integer jenisKelamin;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "no_bioskop", referencedColumnName = "noBioskop", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BioskopModel bioskop;
}
