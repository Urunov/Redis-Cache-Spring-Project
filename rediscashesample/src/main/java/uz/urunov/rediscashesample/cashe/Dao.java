package uz.urunov.rediscashesample.cashe;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @project: rediscashesample
 * @Date: 16.09.2022
 * @author: H_Urunov
 **/

@Component
public class Dao {
   //


   // step-1. Get method.
   @SneakyThrows
   public String getDataSimple() {
       Thread.sleep(2000);
       return "Danniy ...";
   }


   // step-2

    @SneakyThrows
    public String getData1() {
        Thread.sleep(2000);
        List<String> strings =
               Files.readAllLines(Path.of("urunov.txt"));

        return String.join("", strings);
    }

    @SneakyThrows
    public String getData(String lastName) {
        Thread.sleep(2000);
        List<String> strings =
                Files.readAllLines(Path.of(lastName+".txt"));

        return String.join("", strings);
    }

    @SneakyThrows
    public String getDataFull(String lastName, String name) {
        Thread.sleep(2000);
        List<String> strings =
                Files.readAllLines(Path.of(lastName+".txt"));

        return String.join("", strings);
    }

}
