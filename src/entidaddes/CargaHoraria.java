package entidaddes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class CargaHoraria {

    private Integer horas;
    private LocalDate datain, datafim;

    public CargaHoraria() {
    }

    public CargaHoraria(LocalDate datain, LocalDate datafim) {
        setDatain(datain);
        setDatafim(datafim);
    }

    public Integer getHoras() {
        return horas;
    }

    public LocalDate getDatain() {
        return datain;
    }

    public LocalDate getDatafim() {
        return datafim;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public void setDatain(LocalDate datain) {
        this.datain = datain;
    }

    public void setDatafim(LocalDate datafim) {
        if (datafim == null) {
            throw new IllegalArgumentException("A data de fim não pode ser nula.");
        }
        this.datafim = datafim;
    }

    private void validarDatas() {
        if (datain == null || datafim == null) {
            throw new IllegalArgumentException("As datas de início e fim não podem ser nulas.");
        }
    }

    public long diasTotais() {
        validarDatas();
        return ChronoUnit.DAYS.between(datain, datafim);
    }

    public long mesesCompletos() {
        validarDatas();
        return ChronoUnit.MONTHS.between(datain, datafim);
    }

    public long calcularHorasTotais() {
        validarDatas();
        long mesesCompletos = mesesCompletos();
        LocalDate dataAposMeses = datain.plusMonths(mesesCompletos);
        long diasRestantes = ChronoUnit.DAYS.between(dataAposMeses, datafim);

        long horasMesesCompletos = mesesCompletos * 120;
        double horasDiasRestantes = (diasRestantes / 30.0) * 120;

        return (long) (horasMesesCompletos + horasDiasRestantes);
    }

    public String converterNumeroParaExtenso(long numero) {
        if (numero == 0) return "zero";

        String[] unidades = {"", "um", "dois", "três", "quatro", "cinco",
                "seis", "sete", "oito", "nove"};

        String[] dezenas = {"", "", "vinte", "trinta", "quarenta", "cinquenta",
                "sessenta", "setenta", "oitenta", "noventa"};

        String[] especiais = {"dez", "onze", "doze", "treze", "quatorze", "quinze",
                "dezesseis", "dezessete", "dezoito", "dezenove"};

        String[] centenas = {"", "cem", "duzentos", "trezentos", "quatrocentos", "quinhentos",
                "seiscentos", "setecentos", "oitocentos", "novecentos"};

        StringBuilder resultado = new StringBuilder();


        if (numero >= 1000) {
            long milhar = numero / 1000;
            resultado.append(converterNumeroParaExtenso(milhar)).append(" mil");
            numero %= 1000;
            if (numero > 0) resultado.append(" e ");
        }


        if (numero >= 100) {
            long centena = numero / 100;
            if (centena == 1 && numero % 100 == 0) {
                resultado.append("cem");
            } else {
                resultado.append(centenas[(int) centena]);
            }
            numero %= 100;
            if (numero > 0) resultado.append(" e ");
        }


        if (numero >= 20) {
            long dezena = numero / 10;
            resultado.append(dezenas[(int) dezena]);
            numero %= 10;
            if (numero > 0) resultado.append(" e ");
        } else if (numero >= 10) {
            resultado.append(especiais[(int) (numero - 10)]);
            numero = 0;
        }


        if (numero > 0) {
            resultado.append(unidades[(int) numero]);
        }

        return resultado.toString().trim();
    }

    @Override
    public String toString() {
        long horasTotais = calcularHorasTotais();
        return "Totalizando " + horasTotais + " (" + converterNumeroParaExtenso(horasTotais) + ") horas.";
    }
}
