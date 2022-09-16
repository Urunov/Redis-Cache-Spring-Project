package uz.urunov.rediscashesample.cashe;


import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @project: rediscashesample
 * @Date: 16.09.2022
 * @author: H_Urunov
 **/
@Service
@CacheConfig(cacheNames = "data")
public class CacheService {
    private final Dao dao;
    private final CacheManager cacheManager;


    public CacheService(Dao dao, CacheManager cacheManager) {
        this.dao = dao;
        this.cacheManager = cacheManager;
    }

    // step-1. GET data.
    @Cacheable("data")
    public String getData(){
        return dao.getData1();
    }

    // step-2. GET
    @CachePut
    public String update() {
        return dao.getData1();
    }

    @Cacheable
    public String getDataLastName(String lastName) {
        return dao.getData(lastName);
    }

    @Cacheable(key = "#lastName")
    public String getDataFullSer(String lastName, String name) {
        Cache dataFull = cacheManager.getCache("data");
        return dao.getDataFull(lastName, name);
    }

    public String getManualData(String lastName) {
        Cache data = cacheManager.getCache("data");
      //  return Objects.requireNonNull(data).get(lastName, String.class);
        return null;
    }

    @CacheEvict(allEntries = true)
    public void evict() {
        /* Clean cache on time */
    }
}

//http://localhost:8080/full/manual/?lastName=ivanov&name=ivan