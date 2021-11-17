package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.BioskopDB;
import apap.tutorial.cineplux.service.BioskopService;
import apap.tutorial.cineplux.service.PenjagaService;
import apap.tutorial.cineplux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PenjagaController {
    @Qualifier("penjagaServiceImpl")
    @Autowired
    PenjagaService penjagaService;

    @Qualifier("bioskopServiceImpl")
    @Autowired
    BioskopService bioskopService;

    @Qualifier("userServiceImpl")
    @Autowired
    UserService userService;

    @GetMapping("/penjaga/add/{noBioskop}")
    public String addPenjagaForm(
            @PathVariable Long noBioskop,
            Model model
    ) {
        PenjagaModel penjaga = new PenjagaModel();
        BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
        penjaga.setBioskop(bioskop);
        model.addAttribute("penjaga",penjaga);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().toString().equals("[MANAGER]")) {
            return "form-add-penjaga";
        }
        return "access-denied";
    }

    @PostMapping("/penjaga/add")
    public String addPenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        penjagaService.addPenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("namaPenjaga",penjaga.getNamaPenjaga());
        return "add-penjaga";
    }

    @GetMapping("/penjaga/update/{noBioskop}/{noPenjaga}")
    public String updatePenjagaForm(
            @PathVariable Long noPenjaga,
            @PathVariable Long noBioskop,
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().toString().equals("[MANAGER]")) {
            BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
            if (bioskopService.cekBuka(bioskop)) {
                return "error-penjaga-related";
            }
            for (PenjagaModel p: bioskop.getListPenjaga()) {
                if (p.getNoPenjaga() == noPenjaga) {
                    penjaga = p;
                }
            }
            model.addAttribute("penjaga", penjaga);
            return "form-update-penjaga";
        }
        return "access-denied";

    }

    @PostMapping("/penjaga/update")
    public String updatePenjagaSubmit(
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {
        penjagaService.updatePenjaga(penjaga);
        model.addAttribute("noBioskop", penjaga.getBioskop().getNoBioskop());
        model.addAttribute("noPenjaga",penjaga.getNoPenjaga());
        return "update-penjaga";
    }

    @GetMapping("/penjaga/delete/{noBioskop}/{noPenjaga}")
    public String deletePenjagaForm(
            @PathVariable Long noPenjaga,
            @PathVariable Long noBioskop,
            @ModelAttribute PenjagaModel penjaga,
            Model model
    ) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getAuthorities().toString().equals("[MANAGER]")) {
            BioskopModel bioskop = bioskopService.getBioskopByNoBioskop(noBioskop);
            if (bioskopService.cekBuka(bioskop)) {
                return "error-penjaga-related";
            }
            for (PenjagaModel p: bioskop.getListPenjaga()) {
                if (p.getNoPenjaga() == noPenjaga) {
                    penjaga = p;
                }
            }
            model.addAttribute("penjaga", penjaga);
            return "form-delete-penjaga";
        }
        return "access-denied";

    }

    @PostMapping("/penjaga/delete")
    public String deletePenjagaSubmit(
            @ModelAttribute BioskopModel bioskop,
            Model model
    ) {
        System.out.println(bioskop.getNoBioskop());
        model.addAttribute("noBioskop", bioskop.getNoBioskop());
        for (PenjagaModel p : bioskop.getListPenjaga()) {
            penjagaService.deletePenjaga(p);
        }
        return "delete-penjaga";
    }

}