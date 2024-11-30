package entidaddes;

public class Servidor {

    private String nome, cargo, curso;
    private Integer matricula, vinculo;
    public Servidor(){
    }

    public Servidor(String nome, String cargo, String curso, Integer matricula, Integer vinculo) {
        this.nome = nome;
        this.cargo = cargo;
        this.curso = curso;
        this.matricula = matricula;
        this.vinculo = vinculo;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getVinculo() {
        return vinculo;
    }

    public void setVinculo(Integer vinculo) {
        this.vinculo = vinculo;
    }

    public String toString(){
        StringBuilder dados = new StringBuilder();
        dados.append("O(A) estagiário(a) "
                + nome  + ", matriculado(a) no curso de "
                + curso + " cadastrado sob matrícula " + matricula + "/" + vinculo);
        return dados.toString();
    }

}
