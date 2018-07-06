package barbershop.repository;

import barbershop.domain.Manicurist;

import java.util.List;

public interface OwnerDAO {

    List<Manicurist> getOwner();

    void updateOwner();

    void layOff();

}
