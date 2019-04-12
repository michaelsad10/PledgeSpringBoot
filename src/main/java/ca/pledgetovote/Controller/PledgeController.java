package ca.pledgetovote.Controller;

import ca.pledgetovote.Model.Pledge;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PledgeController {
    private List<Pledge> pledges = new ArrayList<>();  // List of pledges
    private AtomicLong nextId = new AtomicLong();
    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello Spring Boot World";
    }

    @PostMapping("/pledges")
    public Pledge createNewPledge(@RequestBody Pledge pledge) { // @RequestBody takes the input from the html search bar
        // Set pledge to have next ID:
        pledge.setId(nextId.incrementAndGet());
        pledges.add(pledge);
        return pledge;
    }

    @GetMapping("/pledges")
    public List<Pledge> getAllPledges() {
        return pledges;
    }

    @GetMapping("pledges/{id}")
    public Pledge getOnePledge(@PathVariable("id") long pledgeId) {
        for (Pledge pledge : pledges) {
            if (pledge.getId() == pledgeId) {
                return pledge;
            }
        }
        return null;
    }
}
