package trabalho1POO;

public enum Combustivel {
    GASOLINA("Gasolina"),
    ALCOOL("Alcool"),
    DIESEL("Diesel");
    
    private String combustivel;
    
    private Combustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCombustivel() {
        return combustivel;
    }
}