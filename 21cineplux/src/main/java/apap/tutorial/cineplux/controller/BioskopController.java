package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.FilmModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;

import java.util.List;

@Controller
public class BioskopController {

    @Qualifier("bioskopServiceImpl")
    @Autowired
    private BioskopService bioskopService;

    @Qualifier("filmServiceImpl")
    @Autowired
    private FilmService filmService;

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        List<FilmModel> listFilm =  filmService.getListFilm();
        model.addAttribute("jumlah", 0);
        model.addAttribute("bioskop", new BioskopModel());
        model.addAttribute("listFilm", listFilm);
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/again")
    public String addFilmBioskop(
            @ModelAttribute BioskopModel bioskop,
            @RequestParam(value = "jumlah") int jumlah,
            @RequestParam(value = "ops") String ops,
            Model model
    ) {
        List<FilmModel> listFilm =  filmService.getListFilm();
        if (ops.equals(",true")) {
            jumlah = jumlah + 1;
        }
        else if (ops.equals(",false")) {
            jumlah = jumlah -1;
        }
        if (jumlah <0) {
            jumlah = 0;
        }
        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listFilm", listFilm);
        model.addAttribute("jumlah", jumlah);
        return "form-add-bioskop";
    }

    @PostMapping("/bioskop/add")
    public String addBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.addBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "add-bioskop";
    }

    @GetMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        model.addAttribute("listBioskop", listBioskop);
        return "viewall-bioskop";
    }

    @GetMapping("/bioskop/view")
    public String viewDetailBioskop(
            @RequestParam(value = "noBioskop") Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        List<PenjagaModel> listPenjaga = bioskop.getListPenjaga();
        model.addAttribute("bioskop", bioskop);
        model.addAttribute("listPenjaga", listPenjaga);
        return "view-bioskop";
    }

    @GetMapping("/bioskop/update/{noBioskop}")
    public String updateBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        model.addAttribute("bioskop", bioskop);
        return "form-update-bioskop";
    }

    @PostMapping("/bioskop/update")
    public String updateBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        bioskopService.updateBioskop(bioskop);
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        return "update-bioskop";
    }

    @GetMapping("/bioskop/delete/{noBioskop}")
    public String deleteBioskopForm(
            @PathVariable Long noBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        if(bioskopService.cekBuka(bioskop)) {
            return "error-penjaga-related";
        }
        if(bioskopService.cekPenjaga(bioskop)) {
            model.addAttribute("bioskop", bioskop);
            return "form-delete-bioskop";
        }
        else {
            return "error-ada-penjaga";
        }
    }

    @PostMapping("/bioskop/delete")
    public String deleteBioskopSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        bioskopService.deleteBioskop(bioskop);
        return "delete-bioskop";
    }
}
