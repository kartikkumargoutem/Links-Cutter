package kartik.URL.Serves;


import kartik.URL.Entity.Url;
import kartik.URL.Repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlServes {


    public String generateUrl(){ // generate Url

            byte[] array = new byte[7];

            new Random().nextBytes(array);   // set Auto random numbers.

            // create new String (Random array , convert AIICs value to charter, );
            return new String(array, StandardCharsets.UTF_8).replaceAll("[^a-zA-Z0-9]" , "");
    }


    @Autowired
    private UrlRepository urlRepository;

    public Url ShorterUrl(String urlCode){
        String UrlCode = generateUrl();

        // save repository (create obj Url, set originalUrl, set urlcode, return both);
        return urlRepository.save(Url.builder().originalUrl(urlCode).urlCode(UrlCode).build());
    }

    public  Optional<Url> getOriginalUrl(String UrlCode){

        // return from Sol database with jpaRepository class.
        return urlRepository.findByUrlCode(UrlCode);
    }
}
