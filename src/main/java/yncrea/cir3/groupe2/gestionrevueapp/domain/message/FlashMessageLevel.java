package yncrea.cir3.groupe2.gestionrevueapp.domain.message;

public enum FlashMessageLevel {
    ERROR("danger"), WARNING("warning"), INFO("info"), SUCCESS("success");

    private String name;

    private FlashMessageLevel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
