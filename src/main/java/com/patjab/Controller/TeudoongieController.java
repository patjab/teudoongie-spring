package com.patjab.Controller;

import com.patjab.Entity.Teudoongie;
import com.patjab.Service.TeudoongieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/teudoongie")
public class TeudoongieController {

    @Autowired
    private TeudoongieService teudoongieService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Teudoongie> getAllTeudoongies() {
        return this.teudoongieService.getAllTeudoongies();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Teudoongie getAllTeudoongieById(@PathVariable Integer id) {
        return this.teudoongieService.getTeudoongieById(id);
    }

    @RequestMapping(path = "/name/{name}", method = RequestMethod.GET)
    public Teudoongie getTeudoongieByName(@PathVariable String name) {
        return this.teudoongieService.getTeudoongieByName(name);
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public void addTeudoongie(@RequestBody Teudoongie t) {
        this.teudoongieService.addTeudoongie(t);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteTeudoongieById(@PathVariable Integer id) {
        this.teudoongieService.deleteTeudoongieById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void editTeudoongieById(@PathVariable Integer id, @RequestBody String name) {
        this.teudoongieService.editTeudoongieById(id, name);
    }
}
