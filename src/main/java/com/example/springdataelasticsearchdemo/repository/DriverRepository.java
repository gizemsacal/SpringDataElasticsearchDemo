package com.example.springdataelasticsearchdemo.repository;
//DriverRepository interface’imiz bizim için veri tabanı operasyonlarını gerçekleştirecek olan yapıdır.
import com.example.springdataelasticsearchdemo.model.Driver;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository //@Repository sınıfı ile interface’i işaretleyip Spring’e kaydını yaptırıyoruz.
public interface DriverRepository extends ElasticsearchRepository<Driver,String> {
    //nterface’i ElasticsearchRepository interface’inden kalıtıyoruz.
    // ElasticsearchRepository interface’ine parametre olarak Document’leri temsil eden sınıfı ve bu sınıftaki id’nin tipini geçiriyoruz.
}
