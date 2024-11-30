package entidaddes;

public class Dec {

    private Servidor servidor;
    private CargaHoraria cargaHoraria;

    public Dec(Servidor servidor, CargaHoraria cargaHoraria) {
        this.servidor = servidor;
        this.cargaHoraria = cargaHoraria;
    }

    public String toString() {
        StringBuilder declaracao = new StringBuilder();
        declaracao.append("Declaramos para os devidos fins de direito, que " + servidor + "\n" +
                " desta Polícia Cientifica do Pará, no periodo de " +
                cargaHoraria.getDatain() + " à " + cargaHoraria.getDatafim() +
                ", exerceu suas atividades de Segunda a Sexta-feira, " + cargaHoraria);
        return declaracao.toString();
    }
}


