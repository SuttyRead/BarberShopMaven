package barbershop.repository;

import barbershop.domain.Hairdresser;

import java.util.List;

public interface HairdresserDAO {

    void addHairdresser(Hairdresser hairdresser);

    List<Hairdresser> getAllHairdresser();

    Hairdresser findHairdresser(Hairdresser hairdresser);

    Hairdresser findHairdresserById(int id);

    void updateHairdresser(Hairdresser hairdresser);

    void deleteHairdresser(int id);


}
