package br.com.sistema.model;

public class Venda {
    private int id;
    private Cliente cliente;
    private String dataVenda;
    private double totalVenda;
    private String observacoes;

    public Venda() {}

    public Venda(int id, Cliente cliente, String dataVenda, double totalVenda, String observacoes) {
        this.id = id;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.totalVenda = totalVenda;
        this.observacoes = observacoes;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getDataVenda() { return dataVenda; }
    public void setDataVenda(String dataVenda) { this.dataVenda = dataVenda; }

    public double getTotalVenda() { return totalVenda; }
    public void setTotalVenda(double totalVenda) { this.totalVenda = totalVenda; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}