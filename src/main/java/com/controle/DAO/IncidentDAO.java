package com.controle.DAO;

import com.controle.Models.*;

import java.util.Set;

public interface IncidentDAO {

    void inserer(Incident i);
    void inser(Set<Incident> is);

}
