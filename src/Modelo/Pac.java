package Modelo;

/**
 * Created by Diego on 19/05/2017.
 */
public class Pac {
    private int linha;
    private int coluna;
    private Character direcao;

    public Pac(int linha, int coluna, Character direcao) {
        this.linha = linha;
        this.coluna = coluna;
        this.direcao = direcao;
    }

    public Pac() {
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public Character getDirecao() {
        return direcao;
    }

    public void setDirecao(Character direcao) {
        this.direcao = direcao;
    }

    @Override
    public String toString() {
        return "Pac{" +
                "linha=" + linha +
                ", coluna=" + coluna +
                ", direcao=" + direcao +
                '}';
    }
}
