package se.systementor.supershoppen1.shop.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
         this.restTemplate = new RestTemplate();
    }

    @Test
    void testKrisinfoSingleFeatureToTemplate(){

        String id = "12652";
        String url = "https://api.krisinformation.se/v3/features/"+id;
        String expected = "{Id=12652, FeatureSection=2, Headline=Covid-19, Preamble=Här kan du läsa mer om hanteringen av utbrottet av covid-19 och vad du kan göra för att undvika att sprida smittan. , BodyText=, ImageLink=https://www.krisinformation.se/globalassets/detta-kan-handa/handelser-och-kriser/2020-coronavirus/johner_provror_appen.jpg, ImageCaption=, VideoUrl=, VideoCaption=, YoutubeId=, Checklist=[], Facts=, Links=[{Text=Myndigheternas samlade information om covid-19, Url=https://www.krisinformation.se/detta-kan-handa/handelser-och-storningar/20192/myndigheterna-om-det-nya-coronaviruset/}], ChangedDate=2022-12-16T10:27:44+01:00, SortOrder=0}";

        Object result = restTemplate.getForObject(url, Object.class);
        assertEquals(result.toString(),expected);

    }

}