package mate.team2.winelibrary.repository;

import mate.team2.winelibrary.model.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WineRepository extends JpaRepository<Wine, Integer>,
        JpaSpecificationExecutor<Wine> {
   /*
   @Query(value = "SELECT c.id id, c.name countryname, SUM(sm.quantity) totalQuantity " +
            "FROM wines w LEFT JOIN countries c ON w.country_id = c.id  " +
            "INNER JOIN stock_movements sm ON w.id = sm.wine_id  " +
            "GROUP BY c.id, c.name", nativeQuery = true)
    public List<WineRepository.QuantityByCountries> quantityByCountries();
    */

    /*
    @Query("SELECT w.country AS countryName, COUNT(w.country) AS totalQuantity "
        + "FROM Wine AS w GROUP BY w.country")
     */
    @Query(value = "SELECT c.id id, c.name name, COUNT(w.country_id) totalQuantity " +
            "FROM wines w LEFT JOIN countries c ON w.country_id = c.id  " +
            "GROUP BY c.id, c.name", nativeQuery = true)
    List<WineRepository.QuantityByCountries> quantityByCountries();

    interface QuantityByCountries {

        Integer getId();

        String getName();

        Integer getTotalquantity();

    }

}
