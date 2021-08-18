package com.example.springdataelasticsearchdemo.model;

//Driver sınıfımız da her bir Document için temsil edici sınıfımız olacaktır.

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data //get-set metodlarını ayrı ayrı yazmamak için @Data anotasyonu ekledik.
@Document(indexName = "f1index") //Sınıfımızı @Document notasyonu ile işaretliyoruz ve notasyona parametre olarak kullanacağınız indexi indexName parametresi ile veriyoruz.
public class Driver {

    @Id //Elastichsearch her bir kayıt için bir id üretir. Biz de üretilen id’yi kendi tarafımıza alabilmek için id isimli alanımızı @Id notasyonu ile işaretliyoruz.
    private String id;

    private String name;

    private String surname;

    private String team;


}
