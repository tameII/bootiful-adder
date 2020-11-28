package fr.univlorraine.bootiful.controller;

import fr.univlorraine.bootiful.services.AdderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/adder", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class AdderController {

    private AdderService adderService;

    public AdderController() {
        this.adderService = new AdderService();
    }

    public AdderController(AdderService adderService) {
        this.adderService = adderService;
    }


    @GetMapping("/current")
    public int currentNum() {
        return adderService.currentBase();
    }

    @GetMapping("/add")
    public int addGet(@RequestParam int num) {
        return adderService.add(num);
    }

    @GetMapping("/substract")
    public int substractGet(@RequestParam int num) {
        return adderService.substract(num);
    }

    @GetMapping("/accumulate")
    public int accumulateGet(@RequestParam int num) {
        return adderService.accumulate(num);
    }


    @PostMapping(value = "/changeBaseNum")
    public void changeBaseNum(@RequestParam int base) {
        adderService.baseNum(base);
    }




}
