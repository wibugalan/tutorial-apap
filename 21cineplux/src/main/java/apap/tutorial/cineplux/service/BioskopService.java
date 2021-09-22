package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;

import java.util.List;

public interface BioskopService {
    // method untuk menambah Bioskop
    void addBioskop(BioskopModel bioskop);

    List<BioskopModel> getBioskopList();

    BioskopModel getBioskopByIdBioskop(String idBioskop);

    void deleteBioskop(String idBioskop);
}
