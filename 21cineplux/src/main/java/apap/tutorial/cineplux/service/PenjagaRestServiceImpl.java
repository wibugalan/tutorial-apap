package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.repository.PenjagaDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PenjagaRestServiceImpl implements PenjagaRestService{

    @Autowired
    private PenjagaDB penjagaDB;

    @Override
    public PenjagaModel createPenjaga(PenjagaModel penjaga) {
        return penjagaDB.save(penjaga);
    }

    @Override
    public List<PenjagaModel> retrieveListPenjaga() {
        return penjagaDB.findAll();
    }

    @Override
    public PenjagaModel getPenjagaByNoPenjaga(Long noPenjaga) {
        Optional<PenjagaModel> penjaga = penjagaDB.findByNoPenjaga(noPenjaga);
        if(penjaga.isPresent()){
            return penjaga.get();
        }else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public PenjagaModel updatePenjaga(Long noPenjaga, PenjagaModel penjagaUpdate) {
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        penjaga.setNamaPenjaga(penjagaUpdate.getNamaPenjaga());
        penjaga.setJenisKelamin(penjagaUpdate.getJenisKelamin());
        penjaga.setBioskop(penjagaUpdate.getBioskop());
        return penjagaDB.save(penjaga);
    }

    @Override
    public void deletePenjaga(Long noPenjaga) {
        LocalTime now = LocalTime.now();
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        BioskopModel bioskop = penjaga.getBioskop();
        if ((now.isBefore(bioskop.getWaktuBuka()) || now.isAfter(bioskop.getWaktuTutup()))) {
            penjagaDB.delete(penjaga);
        } else {
            throw new UnsupportedOperationException("Bioskop still Open!");
        }
    }

    @Override
    public PenjagaModel generateUmur(Long noPenjaga, PenjagaModel penjagaUpdate) {
        PenjagaModel penjaga = getPenjagaByNoPenjaga(noPenjaga);
        BioskopModel bioskop = penjaga.getBioskop();
        LocalTime now = LocalTime.now();
        final String uri = "https://api.agify.io/?name=" + String.valueOf(penjaga.getNamaPenjaga().split(" ")[0]);

        if(now.isBefore(bioskop.getWaktuBuka()) || now.isAfter(bioskop.getWaktuTutup())) {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            String umur = result.split(",")[1].substring(6, result.split(",")[1].length());
            penjaga.setUmur(umur);
            penjagaDB.save(penjaga);
        } else {
            throw new UnsupportedOperationException("Bioskop still open");
        }
        return penjagaDB.findByNoPenjaga(noPenjaga).get();
    }
}
