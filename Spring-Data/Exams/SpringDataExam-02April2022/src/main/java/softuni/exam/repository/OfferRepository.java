package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Offer;

import java.util.Set;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    boolean existsByAgent_FirstName(String firstName);

    @Query("SELECT o FROM Offer as o WHERE o.apartment.apartmentType = 'THREE_ROOMS'" +
            "ORDER BY o.apartment.area DESC, o.price")
    Set<Offer> findAllWithTreeRoomsOrderByAreaDescThenByPrice();
}
