package apap.tutorial.cineplux.restcontroller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import apap.tutorial.cineplux.rest.BioskopDetail;
import apap.tutorial.cineplux.service.BioskopRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import apap.tutorial.cineplux.model.BioskopModel;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class BioskopRestController {

    @Autowired
    private BioskopRestService bioskopRestService;

    @PostMapping(value = "/bioskop")
    private BioskopModel createBioskop(@Valid @RequestBody BioskopModel bioskop, BindingResult bindingResult ) {
        if(bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );
        }
        else {
            return bioskopRestService.createBioskop(bioskop);
        }
    }

    @GetMapping(value = "/bioskop/{noBioskop}")
    private BioskopModel retrieveBioskop(
            @PathVariable("noBioskop") Long noBioskop
    ) {
        try{
            return bioskopRestService.getBioskopByNoBioskop(noBioskop);
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Bioskop " + String.valueOf(noBioskop) + " Not Found."
            );
        }
    }

    @DeleteMapping(value = "/bioskop/{noBioskop}")
    private ResponseEntity deleteBioskop(
            @PathVariable("noBioskop") Long noBioskop
    ) {
        try {
            bioskopRestService.deleteBioskop(noBioskop);
            return ResponseEntity.ok("Bioskop with no Bioskop " + String.valueOf(noBioskop) + " Deleted!");
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bioskop with no Bioskop " + String.valueOf(noBioskop) + " Not Found."
            );
        }
        catch(UnsupportedOperationException e){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Bioskop is still open or has penjaga!"
            );
        }
    }

    @PutMapping(value = "/bioskop/{noBioskop}")
    private BioskopModel updateBioskop(
            @PathVariable("noBioskop") Long noBioskop,
            @RequestBody BioskopModel bioskop
    ) {
        try{
            return bioskopRestService.updateBioskop(noBioskop, bioskop);
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Bioskop with no Bioskop " + String.valueOf(noBioskop) + " Not Found."
            );
        }
    }

    @GetMapping(value = "/list-bioskop")
    private List<BioskopModel> retrieveListBioskop(){
        return bioskopRestService.retrieveListBioskop();
    }

    @GetMapping(value = "/bioskop/{noBioskop}/status")
    private Mono<String> getStatus(
            @PathVariable("noBioskop")
                    Long noBioskop
    ) {
        return bioskopRestService.getStatus(noBioskop);
    }

    @GetMapping(value = "/full")
    private Mono<BioskopDetail> postStatus() {
        return bioskopRestService.postStatus();
    }
}