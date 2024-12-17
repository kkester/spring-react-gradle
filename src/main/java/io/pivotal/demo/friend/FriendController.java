package io.pivotal.demo.friend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Collections.singletonList;

@RestController
public class FriendController {
    @GetMapping("/api/friends")
    public List<Friend> list() {
        return singletonList(Friend.builder().name("Andrew").build());
    }
}
