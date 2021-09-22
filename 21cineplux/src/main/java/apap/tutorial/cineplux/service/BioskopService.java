package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;

import java.util.List;

public interface BioskopService {
    void addBioskop(BioskopModel bioskop);
    List<BioskopModel> getBioskopList();
    void updateBioskop(BioskopModel bioskop);
    BioskopModel getBioskopByNoBioskop(Long noBioskop);
//    void getPenjaga(BioskopModel bioskop);
}
