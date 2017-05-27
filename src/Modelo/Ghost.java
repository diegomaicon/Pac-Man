package Modelo;

/**
 * Created by Diego on 23/05/2017.
 */
public class Ghost {
    private int linha;
    private int coluna;
    private Character direcao;
    private Character icone;
    private Character sub;

    public Ghost() {
    }


    public Character getSub() {
        return sub;
    }

    public void setSub(Character sub) {
        this.sub = sub;
    }

    public Ghost(int linha, int coluna, Character direcao, Character icone, Character sub) {
        this.linha = linha;
        this.coluna = coluna;

        this.direcao = direcao;
        this.icone = icone;
        this.sub = sub;
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
