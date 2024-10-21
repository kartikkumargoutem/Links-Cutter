package kartik.URL.Controller;


import kartik.URL.Entity.Url;
import kartik.URL.Serves.UrlServes;
import kartik.URL.UrlApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping()
public class UrlController {

    @Autowired
    private UrlServes urlServes;

    @PostMapping("/shortUrl")
    public ResponseEntity<Url> ShorterUrl(@RequestParam String url){
        return ResponseEntity.ok(urlServes.ShorterUrl(url));
    }

    @GetMapping("/{url}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String url){
        Optional<Url> urlOptional = urlServes.getOriginalUrl(url);

        if (urlOptional.isPresent()) {
            Url url1 = urlOptional.get();
            return ResponseEntity
                    .status(302)
                    .location(URI.create(url1.getOriginalUrl()))
                    .build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
