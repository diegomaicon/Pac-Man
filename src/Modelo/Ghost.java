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


    public Ghost(int linha, int coluna, Character direcao, Character icone, Character sub) {
        this.linha = linha;
        this.coluna = coluna;
        this.direcao = direcao;
        this.icone = icone;
        this.sub = sub;
    }

    public synchronized Character getDirecao() {
        return direcao;
    }

    public synchronized void setDirecao(Character direcao) {
        this.direcao = direcao;
    }

    public synchronized Character getIcone() {
        return icone;
    }

    public synchronized void setIcone(Character icone) {
        this.icone = icone;
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

    public synchronized Character getSub() {
        return sub;
    }

    public synchronized void setSub(Character sub) {
        this.sub = sub;
    }

}
