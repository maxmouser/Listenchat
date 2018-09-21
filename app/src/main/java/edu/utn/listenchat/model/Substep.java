package edu.utn.listenchat.model;

/**
 * Created by fabiandelacruz on 13/9/17.
 */

public enum Substep {

    MESSAGES("Mensajes nuevos", Step.MAIN),
    NOVELTIES("Novedades", Step.MAIN),
    CONVERSATION("Conversación", Step.MAIN),
    SELECT_CONTACT("Seleccione contacto", Step.CONVERSATION),
    READ("", Step.CONVERSATION);

    Substep(String description, Step step) {
        this.description = description;
        this.step = step;
    }

    private String description;
    private Step step;

    public String getDescription() {
        return description;
    }

    public static Substep previous(Substep substep) {
        for (Substep value: values()) {
            if (value.ordinal() == substep.ordinal() - 1) {
                return value;
            }
        }

        return substep;
    }

    public static Substep next(Substep substep) {
        for (Substep value: values()) {
            if (value.step.equals(substep.step) && value.ordinal() == substep.ordinal() + 1) {
                return value;
            }
        }

        return substep;
    }
}
