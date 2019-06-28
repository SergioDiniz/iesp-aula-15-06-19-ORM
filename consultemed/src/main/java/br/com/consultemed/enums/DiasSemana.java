package br.com.consultemed.enums;

public enum DiasSemana {
    DOMINGO(1), SEGUNDA(2), TERCA(3), QUARTA(4), QUINTA(5), SEXTA(6), SABADO(7);

    public final int dia;

    DiasSemana(int i) {
        this.dia = i;
    }

    public static DiasSemana getDia(int i){
        for (DiasSemana e : values()) {
            if (e.dia == i) {
                return e;
            }
        }
        return null;
    }
}
