package com.patjab.Service;

import com.patjab.Dao.TeudoongieDao;
import com.patjab.Entity.Teudoongie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeudoongieService {

    @Autowired
    private TeudoongieDao teudoongieDao;

    public Collection<Teudoongie> getAllTeudoongies() {
        return this.teudoongieDao.selectAll();
    }

    public Teudoongie getTeudoongieById(Integer id) {
        return this.teudoongieDao.selectById(id);
    }

    public Teudoongie getTeudoongieByName(String name) {
        return this.teudoongieDao.selectByName(name);
    }

    public void deleteTeudoongieById(Integer id) {
        this.teudoongieDao.deleteTeudoongieById(id);
    }

    public void addTeudoongie(Teudoongie t) {
        this.teudoongieDao.addTeudoongie(t);
    }

    public void editTeudoongieById(Integer id, String name) {
        Teudoongie currTeudoongie = this.teudoongieDao.selectById(id);
        if (currTeudoongie != null) {
            currTeudoongie.setName(name);
            this.teudoongieDao.editTeudoongieById(currTeudoongie);
        }
    }
}