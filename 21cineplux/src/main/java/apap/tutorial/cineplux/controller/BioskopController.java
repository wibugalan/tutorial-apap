package apap.tutorial.cineplux.controller;

import apap.tutorial.cineplux.model.PenjagaModel;
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

    @GetMapping("/bioskop/add")
    public String addBioskopForm(Model model) {
        model.addAttribute("bioskop", new BioskopModel());
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

//    @RequestMapping("/bioskop/viewall")
//    public String listBioskop(Model model) {
//        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
//        model.addAttribute("listBioskop",listBioskop);
//        return "viewall-bioskop";
//    }
//
//    @RequestMapping("/bioskop/view")
//    public String detailBioskop(
//            @RequestParam(value = "idBioskop", required = true) String idBioskop,
//            Model model
//    ){
//        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
//        model.addAttribute("bioskop", bioskopModel);
//
//        return "view-bioskop";
//    }
//    @RequestMapping("/bioskop/view/id-bioskop/{idBioskop}")
//    public String viewDetailByID(
//            @PathVariable(value = "idBioskop") String idBioskop, Model model
//    ) {
//        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
//        if (bioskop == null) {
//            model.addAttribute("operasi", "View by Id");
//            return "error-id";
//        }
//        return detailBioskop(idBioskop, model);
//    }
//
//    @RequestMapping("/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
//    public String updateJumlahStudio (
//            @PathVariable(value = "idBioskop", required = true) String idBioskop,
//            @PathVariable(value = "jumlahStudio", required = true) int jumlahStudio,
//            Model model
//    ) {
//        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
//        if (bioskop == null) {
//            model.addAttribute("operasi", "Update");
//            return "error-id";
//        }
//        bioskop.setJumlahStudio(jumlahStudio);
//        model.addAttribute("idBioskop", idBioskop);
//        return "update-bioskop";
//    }
//
//    @RequestMapping("/bioskop/update/id-bioskop/{idBioskop}/nama-bioskop/{namaBioskop}")
//    public String updateNamaBioskop (
//            @PathVariable(value = "idBioskop", required = true) String idBioskop,
//            @PathVariable(value = "namaBioskop", required = true) String namaBioskop,
//            Model model
//    ) {
//        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
//        if (bioskop == null) {
//            model.addAttribute("operasi", "Update");
//            return "error-id";
//        }
//        if (bioskopService.cekNama(namaBioskop).equals("false")) {
//            model.addAttribute("operasi", "Update");
//            return "error-id";
//        }
//        bioskop.setNamaBioskop(namaBioskop);
//        model.addAttribute("idBioskop", idBioskop);
//        return "update-bioskop";
//    }
//
//    @RequestMapping("/bioskop/delete/id-bioskop/{idBioskop}")
//    public String deleteBioskop(
//            @PathVariable(value = "idBioskop", required = true) String idBioskop,
//            Model model
//    ) {
//        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
//        if (bioskop == null) {
//            model.addAttribute("operasi", "Delete");
//            return "error-id";
//        }
//        bioskopService.deleteBioskop(idBioskop);
//        model.addAttribute("idBioskop", idBioskop);
//        return "delete-bioskop";
//    }

//    // referensi: https://stackoverflow.com/questions/37746428/java-spring-how-to-handle-missing-required-request-parameters
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    public String handleMissingParams(MissingServletRequestParameterException ex) {
//        return "error";
//    }
}
