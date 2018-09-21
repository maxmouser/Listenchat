package edu.utn.listenchat.model;

/**
 * Created by fabiandelacruz on 13/9/17.
 */

public enum Step {

    MAIN(""),
    NEW_MESSAGES("Mensajes nuevos"),
    CONVERSATION("Conversaciòn"),
    NOVELTIES("Novedades");

    Step(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }
}
