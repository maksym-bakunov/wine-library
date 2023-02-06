package mate.team2.winelibrary.model;

import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "wines")
public class Wine extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    private Color color;
    @ManyToOne
    @JoinColumn(name = "sort_id", referencedColumnName = "id")
    private Sort sort;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    private Manufacturer manufacturer;
    @ManyToOne
    @JoinColumn(name = "sweetness_id", referencedColumnName = "id")
    private Sweetness sweetness;
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;
    private BigDecimal price;
    private BigDecimal volume;
    private Integer year;
    private String composition;
    private Integer rang;
    private Integer discount;
    @Column(name = "picture_id")
    private Integer pictureId;
    @Column(name = "description")
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "wines_dishes",
            joinColumns = { @JoinColumn(name = "wine_id") },
            inverseJoinColumns = { @JoinColumn(name = "dish_id") }
    )
    private Set<Dish> dishes;
}
