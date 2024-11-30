package Aplicacao;
import entidaddes.CargaHoraria;
import entidaddes.Dec;
import entidaddes.Servidor;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class app {
    public static void main(String[] args) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Dados do estagiário: ");
        System.out.print("Nome:");
        String nome = sc.nextLine();
        System.out.print("Curso:");
        String curso = sc.nextLine();
        System.out.print("Cargo:");
        String cargo = sc.nextLine();
        System.out.print("Matricula:");
        Integer matricula = sc.nextInt();
        System.out.print("Vinculo:");
        Integer vinculo = sc.nextInt();

        sc.nextLine();

        System.out.print("Data de início:");
        String datainString = sc.nextLine();
        System.out.print("Data de fim:");
        String datafinString = sc.nextLine();

            LocalDate datain = LocalDate.parse(datainString, formatter);
            LocalDate datafin = LocalDate.parse(datafinString, formatter);

            Servidor servidor = new Servidor(nome, cargo, curso, matricula, vinculo);
            CargaHoraria cargaHoraria = new CargaHoraria(datain,datafin);

            Dec dec = new Dec(servidor, cargaHoraria);

            System.out.println();

            System.out.println(dec);

        sc.close();
    }
}