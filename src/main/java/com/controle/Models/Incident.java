package com.controle.Models;

import java.time.LocalTime;

public class Incident {
    private String reference;
    private LocalTime time;
    private String status;
    private String membre_id;

    public Incident(String reference, LocalTime time, String status, String membre_id) {
        this.reference = reference;
        this.time = time;
        this.status = status;
        this.membre_id = membre_id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMembre_id() {
        return membre_id;
    }

    public void setMembre_id(String membre_id) {
        this.membre_id = membre_id;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "reference='" + reference + '\'' +
                ", time=" + time +
                ", status='" + status + '\'' +
                ", membre_id='" + membre_id + '\'' +
                '}';
    }
}
