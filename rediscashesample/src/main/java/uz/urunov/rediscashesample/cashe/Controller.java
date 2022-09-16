package uz.urunov.rediscashesample.cashe;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: rediscashesample
 * @Date: 16.09.2022
 * @author: H_Urunov
 **/
@RestController
public class Controller {
    //
    private final CacheService cacheService;


    public Controller(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping
    public String getDao(){
      return cacheService.getData();
    }

    @GetMapping("/lastName")
    public String getDataLastName(String lastName){
        return cacheService.getDataLastName(lastName);
    }



    @GetMapping("/update")
    public String update(){
        return cacheService.getData();
    }

    @GetMapping("/evict")
    public void evict(){
        cacheService.evict();
    }

    @GetMapping("/manual")
    public String getDataManual(@RequestParam String lastName){
        return cacheService.getManualData(lastName);
    }

    @GetMapping("/full/manual")
    public String getDataFullManual(@RequestParam String lastName, String name){
        return cacheService.getDataFullSer(lastName, name);
    }
}
//http://localhost:8080/lastName/?lastName=ivanov
//http://localhost:8080/full/manual/?lastName=urunov