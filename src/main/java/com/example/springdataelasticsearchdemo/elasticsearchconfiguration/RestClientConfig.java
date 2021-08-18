package com.example.springdataelasticsearchdemo.elasticsearchconfiguration;
//RestClientConfig sınıfımız Elastichsearch ile iletişime geçecek client’in kayda geçirildiği sınıftır.
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration //Sınıfımızı @Configuration notasyonu ile işaretleyip Spring’e tanıtıyoruz.
public class RestClientConfig extends AbstractElasticsearchConfiguration { //Sınıfımızı AbstractElasticsearchConfiguration sınıfından kalıtıyoruz.
    @Override //AbstractElasticsearchConfiguration sınıfından gelen elasticsearchClient metodunu Override ediyoruz
    @Bean // RestHighLevelClient tipindeki bir objenin Spring tarafından kullanılabilmesi için @Bean notasyonu ile işaretliyoruz.
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("localhost:9200")
                .build();        //elasticsearchClient metodu içerisinde Elasticsearch’ün çalıştığı
                                // host ve port bilgisini connectedTo metoduna vererek ClientConfiguration tipinde bir obje elde ediyoruz.

        return RestClients.create(clientConfiguration).rest();
    }  //Son olarak da RestClients sınıfındaki create metodunu
      // ClientConfiguration tipindeki objeyi parametre vererek
    // ve rest() metodunu çağırarak client objemizi elde etmiş oluyoruz.
}

