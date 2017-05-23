package Modelo;

/**
 * Created by Diego on 23/05/2017.
 */
public class Ghost {
    private int linha;
    private int coluna;
    private Character direcao;
    private Character icone;

    public Ghost() {
    }

    public Ghost(int linha, int coluna, Character direcao, Character icone) {
        this.linha = linha;
        this.coluna = coluna;
        this.direcao = direcao;
        this.icone = icone;
    }

    public Character getDirecao() {
        return direcao;
    }

    public void setDirecao(Character direcao) {
        this.direcao = direcao;
    }

    public Character getIcone() {
        return icone;
    }

    public void setIcone(Character icone) {
        this.icone = icone;
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
}
