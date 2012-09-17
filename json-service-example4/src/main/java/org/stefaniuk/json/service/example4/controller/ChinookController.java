package org.stefaniuk.json.service.example4.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stefaniuk.json.service.example4.service.AlbumService;
import org.stefaniuk.json.service.example4.service.ArtistService;
import org.stefaniuk.json.service.example4.service.TrackService;

@Controller
@RequestMapping(value = "/chinook/*")
public class ChinookController extends AbstractController {

    @Override
    @RequestMapping("service/{service}")
    public ResponseEntity<String> service(HttpServletRequest request, HttpServletResponse response,
            @PathVariable String service) throws Exception {

        ResponseEntity<String> re = null;

        if(service.equals("artist")) {
            re = handleJsonRpc(request, response, ArtistService.class);
        }
        else if(service.equals("album")) {
            re = handleJsonRpc(request, response, AlbumService.class);
        }
        else if(service.equals("track")) {
            re = handleJsonRpc(request, response, TrackService.class);
        }

        return re;
    }

}
