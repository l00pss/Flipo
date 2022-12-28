package az.rock.ws.presentation.feign;

import az.rock.lib.value.generic.JCredential;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/matcher")
public class AuthMatcherFeignController {


    @PostMapping
    public ResponseEntity<Boolean> match(@RequestBody JCredential credential){
        var result = Boolean.TRUE;
        return ResponseEntity.ok(result);
    }
}
