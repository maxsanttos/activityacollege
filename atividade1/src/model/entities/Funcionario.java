package model.entities;

public class Funcionario extends  Pessoa{
    private Double salBruto;
    private Double percenDesconto;

    public  Funcionario(){super();}
    public Funcionario(String name, String cpf, Double salBruto, Double percenDesconto) {
        super(name, cpf);
        this.salBruto = salBruto;
        this.percenDesconto = percenDesconto;
    }
    public Double getSalBruto() {
        return salBruto;
    }
    public void setSalBruto(Double salBruto) {
        this.salBruto = salBruto;
    }
    public Double getPercenDesconto() {
        return percenDesconto;
    }
    public void setPercenDesconto(Double percenDesconto) {
        this.percenDesconto = percenDesconto;
    }

    public String valorDesconto(){
        double desconto = getSalBruto() * this.percenDesconto;
        return String.format("%.2f", desconto);
    }
 
    public String salarioLiquido(){
        double salLiquido = getSalBruto() - Double.valueOf(valorDesconto()).doubleValue();
        return String.format("%.2f",salLiquido);
    }
}
