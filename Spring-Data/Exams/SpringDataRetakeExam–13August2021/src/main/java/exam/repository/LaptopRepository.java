package exam.repository;

import exam.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {

    boolean existsByMacAddress(String macAddress);
//cpu speed in descending order, Then by the ram in descending order,
// then by the storage in descending order and finally by the MAC Address
    @Query("SELECT l FROM Laptop as l " +
            "ORDER BY l.cpuSpeed DESC, l.ram DESC, l.storage DESC, l.macAddress")
    Set<Laptop> findAllOrderByCpuSpeedDescRamDescStorageDescMaxAddress();
}
