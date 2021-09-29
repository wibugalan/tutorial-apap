package apap.tutorial.cineplux.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "bioskop")
public class BioskopModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noBioskop;

    @NotNull
    @Size(max = 30)
    @Column(nullable = false)
    private String namaBioskop;

    @NotNull
    @Column(nullable = false)
    private String alamatBioskop;

    @NotNull
    @Column(nullable = false)
    private Integer jumlahStudio;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuBuka;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime waktuTutup;
    //Relasi dengan penjagaModel
    @OneToMany(mappedBy = "bioskop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PenjagaModel> listPenjaga;

    //Relasi dengan FilmModel
    @ManyToMany
    @JoinTable(
            name = "file_bioskop",
            joinColumns = @JoinColumn(name = "no_bioskop"),
            inverseJoinColumns = @JoinColumn(name = "no_film")
    )
    List<FilmModel> listFilm;
}