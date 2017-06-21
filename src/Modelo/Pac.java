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

    public synchronized int getLinha() {
        return linha;
    }

    public synchronized void setLinha(int linha) {
        this.linha = linha;
    }

    public synchronized int getColuna() {
        return coluna;
    }

    public synchronized void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public synchronized Character getDirecao() {
        return direcao;
    }

    public synchronized void setDirecao(Character direcao) {
        this.direcao = direcao;
    }

    @Override
    public synchronized String toString() {
        return "Pac{" +
                "linha=" + linha +
                ", coluna=" + coluna +
                ", direcao=" + direcao +
                '}';
    }
}
