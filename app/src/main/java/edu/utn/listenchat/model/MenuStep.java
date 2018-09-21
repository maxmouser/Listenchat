package edu.utn.listenchat.model;

/**
 * Created by fabiandelacruz on 13/9/17.
 */

public class MenuStep {

    private Step step;
    private Substep substep;
    private String contact;

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    public Substep getSubstep() {
        return substep;
    }

    public void setSubstep(Substep substep) {
        this.substep = substep;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
