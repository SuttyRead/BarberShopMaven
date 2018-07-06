package barbershop.repository;

import barbershop.domain.MasterHand;

import java.util.List;

public interface MasterHandDAO {

    void addMasterHand(MasterHand masterHand);

    List<MasterHand> getAllMasterHand();

    MasterHand findMasterHand(MasterHand masterHand);

    MasterHand findMasterHandById(int id);

    void updateMasterHand(MasterHand masterHand);

    void deleteMasterHand(int id);

}
