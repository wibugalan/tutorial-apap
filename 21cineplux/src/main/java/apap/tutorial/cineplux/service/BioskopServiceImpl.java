package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.List;

@Service
@Transactional
public class BioskopServiceImpl implements BioskopService {
    @Autowired
    BioskopDB bioskopDB;

    @Override
    public void addBioskop(BioskopModel bioskop){
        bioskopDB.save(bioskop);
    }

    @Override
    public void updateBioskop(BioskopModel bioskop){
        bioskopDB.save(bioskop);
    }

    @Override
    public List<BioskopModel> getBioskopList(){
        // referensi: https://stackoverflow.com/questions/25486583/how-to-use-orderby-with-findall-in-spring-data
        return bioskopDB.findAll(Sort.by("namaBioskop").ascending());
    }

    @Override
    public BioskopModel getBioskopByNoBioskop(Long noBioskop){
        Optional<BioskopModel> bioskop = bioskopDB.findByNoBioskop(noBioskop);
        if(bioskop.isPresent()){
            return bioskop.get();
        }
        return null;
    }

    @Override
    public boolean cekBuka(BioskopModel bioskop) {
        LocalTime localTime = LocalTime.now();
        if ((bioskop.getWaktuTutup().isAfter(localTime)) && (bioskop.getWaktuBuka().isBefore(localTime))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean cekPenjaga(BioskopModel bioskop) {
        if(bioskop.getListPenjaga().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteBioskop(BioskopModel bioskop) {
        bioskopDB.delete(bioskop);
    }
}