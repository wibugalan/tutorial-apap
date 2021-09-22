package apap.tutorial.cineplux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.cineplux.model.BioskopModel;
import apap.tutorial.cineplux.service.BioskopService;

import java.util.List;

@Controller
public class BioskopController {
    @Autowired
    private BioskopService bioskopService;

    @RequestMapping("/bioskop/add")
    public String addBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            @RequestParam(value = "namaBioskop", required = true) String namaBioskop,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        //Membuat objek BioskopModel
        BioskopModel bioskopModel = new BioskopModel(idBioskop, namaBioskop, alamat, noTelepon, jumlahStudio);

        //Menambahkan objek BioskopModel ke dalam service
        bioskopService.addBioskop(bioskopModel);

        //Add variabel id bioskop ke "idBioskop" untuk dirender ke dalam thymeleaf
        model.addAttribute("idBioskop", idBioskop);

        //Return view template yang digunakan
        return "add-bioskop";
    }

    @RequestMapping("/bioskop/viewall")
    public String listBioskop(Model model) {
        List<BioskopModel> listBioskop = bioskopService.getBioskopList();
        model.addAttribute("listBioskop",listBioskop);
        return "viewall-bioskop";
    }

    @RequestMapping("/bioskop/view")
    public String detailBioskop(
            @RequestParam(value = "idBioskop", required = true) String idBioskop,
            Model model
    ){
        BioskopModel bioskopModel = bioskopService.getBioskopByIdBioskop(idBioskop);
        model.addAttribute("bioskop", bioskopModel);

        return "view-bioskop";
    }
    @RequestMapping("/bioskop/view/id-bioskop/{idBioskop}")
    public String viewDetailByID(
            @PathVariable(value = "idBioskop") String idBioskop, Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
        if (bioskop == null) {
            model.addAttribute("operasi", "View by Id");
            return "error-id";
        }
        return detailBioskop(idBioskop, model);
    }

    @RequestMapping("/bioskop/update/id-bioskop/{idBioskop}/jumlah-studio/{jumlahStudio}")
    public String updateJumlahStudio (
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            @PathVariable(value = "jumlahStudio", required = true) int jumlahStudio,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
        if (bioskop == null) {
            model.addAttribute("operasi", "Update");
            return "error-id";
        }
        bioskop.setJumlahStudio(jumlahStudio);
        model.addAttribute("idBioskop", idBioskop);
        return "update-bioskop";
    }

    @RequestMapping("/bioskop/delete/id-bioskop/{idBioskop}")
    public String deleteBioskop(
            @PathVariable(value = "idBioskop", required = true) String idBioskop,
            Model model
    ) {
        BioskopModel bioskop = bioskopService.getBioskopByIdBioskop(idBioskop);
        if (bioskop == null) {
            model.addAttribute("operasi", "Delete");
            return "error-id";
        }
        bioskopService.deleteBioskop(idBioskop);
        model.addAttribute("idBioskop", idBioskop);
        return "delete-bioskop";
    }

    // referensi: https://stackoverflow.com/questions/37746428/java-spring-how-to-handle-missing-required-request-parameters
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        return "error";
    }
}
