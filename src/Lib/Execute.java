package Lib;

import Modelo.Pac;
import Modelo.Som;
import bin.Tela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Execute implements Runnable {

    static int qtdFruta;
    static int parada;
    static int linhas = 0;
    static int colunas = 0;

    static String[][] mesa;
    static String[] inicia;
    static Pac pac;
    static int score = 0;

    Som som = new Som();
    //Ativa e desativa som
    private static boolean ligaSom = false;

    static ArrayList<ArrayList<String>> listaTrans = new ArrayList<ArrayList<String>>();
    static ArrayList<String> listaTransicao = new ArrayList<String>();

    /**
     * Lê arquivo de mexa.txt, e monta matriz com barreiras, pacman, frutas.
     *
     * @return
     */
    public boolean carregarMesa() {

        String nome = "mesa.txt";// entrada.nextLine();

        try {
            FileReader arqMesa = new FileReader(nome);
            BufferedReader lerArqMesa = new BufferedReader(arqMesa);
            String linha = lerArqMesa.readLine();

            String[] temp = new String[2];
            // ################################################### Monta Mesa
            // ################################################
            linha = lerArqMesa.readLine(); // Le a segunda

            temp = linha.split(" ");
            linhas = Integer.parseInt(temp[2]);
            colunas = Integer.parseInt(temp[4]);
            parada = linhas * colunas;

            mesa = new String[linhas + 2][colunas + 2];


            for (int i = 0; i < linhas + 2; i++) {
                for (int j = 0; j < colunas + 2; j++) {
                    if ((i == (linhas + 1) / 2 && j == 0) || (i == (linhas + 1) / 2 && j == colunas + 1))
                        mesa[i][j] = " ";
                    else if (i == 0)
                        mesa[i][j] = "#";
                    else if (j == 0)
                        mesa[i][j] = "#";
                    else if (i == linhas + 1)
                        mesa[i][j] = "#";
                    else if (j == colunas + 1)
                        mesa[i][j] = "#";
                    else
                        mesa[i][j] = ".";
                }
            }

            // ################################################### Barreira
            // ################################################
            linha = lerArqMesa.readLine(); // Le 3� linha
            linha = limpaString(linha);

            montaBarreira(linha);
            linha = lerArqMesa.readLine();
            while (linha.charAt(0) != 'A') {
                linha = limpaString(linha);
                montaBarreira(linha);
                linha = lerArqMesa.readLine();
            }
            //Porta de saida fantasma

            casaGhosts();

            // ################################################### A�ucar
            // ################################################
            String[] cordenadas;
            int aux;
            linha = limpaString(linha);

            temp = new String[254];
            temp = linha.split(" ");

            cordenadas = new String[254];

            aux = 0;
            for (int i = 0; i < temp.length; i++)
                if (!temp[i].equals("")) {
                    cordenadas[aux] = temp[i];
                    aux++;
                }
            qtdFruta = aux / 2;

            // ############################################################################
            linha = lerArqMesa.readLine(); // Le Ultima linha
            linha = limpaString(linha);
            temp = new String[254];
            temp = linha.split(" ");

            inicia = new String[3];

            aux = 0;
            for (int i = 0; i < temp.length; i++)
                if (!temp[i].equals("")) {
                    inicia[aux] = temp[i];
                    aux++;
                }

            mesa[Integer.parseInt(inicia[0])][Integer.parseInt(inicia[1])] = "C";
            pac = new Pac(Integer.parseInt(inicia[0]), Integer.parseInt(inicia[1]), inicia[2].charAt(0));

            // ####################################################################################################
            for (int i = 0; i < qtdFruta * 2; ) {
                mesa[Integer.parseInt(cordenadas[i])][Integer
                        .parseInt(cordenadas[i + 1])] = "o";
                i = i + 2;
            }

            arqMesa.close();
            // entrada.close();
        } catch (IOException e) {
            // entrada.close();
            return false;
        }

        return true;
    }

    /**
     * Monta casinha de dos Fantasma
     */
    private void casaGhosts() {
        mesa[9][18] = "-";
        mesa[9][19] = "-";
        mesa[10][17] = " ";
        mesa[10][18] = " ";
        mesa[10][19] = " ";
        mesa[10][20] = " ";
    }

    /**
     * Monta barreira de cada linha lida do Arquivo
     *
     * @param linha
     */
    private void montaBarreira(String linha) {
        String[] temp;
        linha = limpaString(linha);
        temp = linha.split(" ");
        String[] cordenadas = new String[254];

        int aux = 0;
        for (int i = 0; i < temp.length; i++)
            if (!temp[i].equals("")) {
                cordenadas[aux] = temp[i];
                aux++;
            }
        int tamCoo = aux;

        for (int i = 0; i < tamCoo; ) {

            if (cordenadas[i].equals(cordenadas[i + 2])) {
                for (int j = Integer.parseInt(cordenadas[i + 1]); j < Integer
                        .parseInt(cordenadas[i + 3]) + 1; j++) {
                    mesa[Integer.parseInt(cordenadas[i])][j] = "#";
                }

            }

            if (cordenadas[i + 1].equals(cordenadas[i + 3])) {
                for (int j = Integer.parseInt(cordenadas[i]); j < Integer
                        .parseInt(cordenadas[i + 2]) + 1; j++) {
                    mesa[j][Integer.parseInt(cordenadas[i + 1])] = "#";
                }
            }

            i = i + 4;
        }
    }

    /**
     * Imprime mesa na Tela
     *
     * @return
     */
    private String imprimeMesa() {
        String print = "";

        for (int i = 0; i < linhas + 2; i++) {
            for (int j = 0; j < colunas + 2; j++) {

                if (i == 0)
                    print += mesa[i][j] + "#";
                else if (i == linhas + 1)
                    print += mesa[i][j] + "#";
                else
                    print += mesa[i][j] + " ";

            }
            print += "\n";
        }
        return print;
    }

    /**
     * Retira caracter especiais da String, do arquivo mesa.txt
     *
     * @param linha
     * @return
     */
    private String limpaString(String linha) {
        linha = linha.replaceAll("[(]", "");
        linha = linha.replaceAll("[)]", "");
        linha = linha.replaceAll("[,]", " ");
        linha = linha.replaceAll("[-]", "");
        linha = linha.replaceAll("[=]", "");
        linha = linha.replaceAll("A", "");
        linha = linha.replaceAll("[{]", "");
        linha = linha.replaceAll("[}]", "");
        linha = linha.replaceAll("B", "");
        linha = linha.replaceAll("Q", "");
        linha = linha.replaceAll("P", "");

        return linha;
    }



    /**
     * Realiza movimento de do Pacman
     *
     * @return
     */
    @Override
    public synchronized void run() {

        Tela tela = new Tela();
        tela.setTitle("          Pac-man LFA         ");
        tela.setSize(850, 700);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.texto.setBackground(Color.BLACK);
        tela.texto.setForeground(Color.GREEN);
        tela.texto.setFont(new Font("Consolas", Font.BOLD, 20));
        tela.texto.setText(imprimeMesa());
        tela.label.setText("Score : " + score);
        verificaDirecional(tela);

        int cont = 0;
        MovimentoGhost.init();
        Thread lilas = new Thread(new MovimentoGhost.MovimentoGhostLilas());
        Thread azul = new Thread(new MovimentoGhost.MovimentoGhostAzul());
        Thread laranja = new Thread(new MovimentoGhost.MovimentoGhostLaranja());
        Thread vermelho1 = new Thread(new MovimentoGhost.MovimentoGhostVermelho1());
        startThreads(lilas, azul, laranja, vermelho1);

        do {

            switch (pac.getDirecao()) {
                case 'D': // Para Baixo
                    if (!mesa[pac.getLinha() + 1][pac.getColuna()].equals("#") && !mesa[pac.getLinha() + 1][pac.getColuna()].equals("-")) {
                        mesa[pac.getLinha() + 1][pac.getColuna()] = "C";
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setLinha(pac.getLinha() + 1);
                        pac.setDirecao('D');

                        if (mesa[pac.getLinha() + 1][pac.getColuna()].equals(".")) {
                            score += 10;
                            if (ligaSom) som.comendoMoeda();
                        } else if (ligaSom) som.parado();
                        //Bonus de 100 pontos
                        if (mesa[pac.getLinha() + 1][pac.getColuna()].equals("o")) {
                            score += 100;
                            if (ligaSom) {
                                som.comendoFruta();
                            }
                        }

                    } else if (ligaSom) som.parado();
                    //Se achou Fantasma Lilas {$}
                    if (isAchouGhost() || MovimentoGhost.olha()) {
                        gameOver(tela, lilas, azul, laranja, vermelho1);
                        return;
                    }
                    break;

                case 'U': // Para Cima
                    if (!mesa[pac.getLinha() - 1][pac.getColuna()].equals("#")) {
                        mesa[pac.getLinha() - 1][pac.getColuna()] = "C";
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setLinha(pac.getLinha() - 1);
                        pac.setDirecao('U');

                        if (mesa[pac.getLinha() - 1][pac.getColuna()].equals(".")) {
                            score += 10;
                            if (ligaSom) som.comendoMoeda();
                        } else if (ligaSom) som.parado();
                        //Bonus de 100 pontos
                        if (mesa[pac.getLinha() - 1][pac.getColuna()].equals("o")) {
                            score += 100;
                            if (ligaSom) {
                                som.comendoFruta();
                            }
                        }

                    } else som.parado();
                    //Se achou Fantasma Lilas {$}
                    if (isAchouGhost() || MovimentoGhost.olha()) {
                        gameOver(tela, lilas, azul, laranja, vermelho1);
                        return;
                    }
                    break;
                case 'L': //Esquerda
                    if (pac.getColuna() == 1 && mesa[pac.getLinha()][pac.getColuna() - 1].equals(" ")) {
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setColuna(colunas + 1);
                        break;
                    }
                    if (!mesa[pac.getLinha()][pac.getColuna() - 1].equals("#")) {
                        mesa[pac.getLinha()][pac.getColuna() - 1] = "C";
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setColuna(pac.getColuna() - 1);
                        pac.setDirecao('L');

                        if (mesa[pac.getLinha()][pac.getColuna() - 1].equals(".")) {
                            score += 10;
                            if (ligaSom) som.comendoMoeda();
                        } else if (ligaSom) som.parado();
                        //Bonus de 100 pontos
                        if (mesa[pac.getLinha()][pac.getColuna() - 1].equals("o")) {
                            score += 100;
                            if (ligaSom) {
                                som.comendoFruta();
                            }
                        }

                    } else if (ligaSom) som.parado();
                    //Se achou Fantasma Lilas {$}
                    if (isAchouGhost()) {
                        gameOver(tela, lilas, azul, laranja, vermelho1);
                        return;
                    }
                    break;
                case 'R': //Direita
                    if (pac.getColuna() == colunas && mesa[pac.getLinha()][pac.getColuna() + 1].equals(" ")) {
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setColuna(0);
                        break;
                    }
                    if (!mesa[pac.getLinha()][pac.getColuna() + 1].equals("#")) {
                        mesa[pac.getLinha()][pac.getColuna() + 1] = "C";
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setColuna(pac.getColuna() + 1);
                        pac.setDirecao('R');

                        if (mesa[pac.getLinha()][pac.getColuna() + 1].equals(".")) {
                            score += 10;
                            if (ligaSom) som.comendoMoeda();
                        } else if (ligaSom) som.parado();
                        //Bonus de 100 pontos
                        if (mesa[pac.getLinha()][pac.getColuna() + 1].equals("o")) {
                            score += 100;
                            if (ligaSom) {
                                som.comendoFruta();
                            }
                        }

                    } else if (ligaSom) som.parado();
                    //Se achou Fantasma Lilas {$}
                    if (isAchouGhost() || MovimentoGhost.olha()) {
                        gameOver(tela, lilas, azul, laranja, vermelho1);
                        return;
                    }
                    break;
            }

            tela.label.setText("Score : " + score);
            tela.texto.setText(imprimeMesa());


            try {

                //Velocidade de execução
                this.wait(200);
                ;
            } catch (Exception e) {
                // TODO: handle exception
            }

            cont++;
        } while (!MovimentoGhost.olha());

        return;
    }


    private void gameOver(Tela tela, Thread lilas, Thread azul, Thread laranja, Thread vermelho1) {
        som.parado();
        paraGhosts(lilas, azul, laranja, vermelho1);
        tela.gameOver.setVisible(true);
        tela.texto.setText(imprimeMesa());
        som.gameOver();
    }

    private synchronized boolean isAchouGhost() {
        return mesa[pac.getLinha() + 1][pac.getColuna()].equals("$") || mesa[pac.getLinha() - 1][pac.getColuna()].equals("$") ||
                mesa[pac.getLinha()][pac.getColuna() - 1].equals("$") || mesa[pac.getLinha()][pac.getColuna() + 1].equals("$") ||
                mesa[pac.getLinha() + 1][pac.getColuna()].equals("%") || mesa[pac.getLinha() - 1][pac.getColuna()].equals("%") ||
                mesa[pac.getLinha()][pac.getColuna() - 1].equals("%") || mesa[pac.getLinha()][pac.getColuna() + 1].equals("%") ||
                mesa[pac.getLinha() + 1][pac.getColuna()].equals("@") || mesa[pac.getLinha() - 1][pac.getColuna()].equals("@") ||
                mesa[pac.getLinha()][pac.getColuna() - 1].equals("@") || mesa[pac.getLinha()][pac.getColuna() + 1].equals("@") ||
                mesa[pac.getLinha() + 1][pac.getColuna()].equals("K") || mesa[pac.getLinha() - 1][pac.getColuna()].equals("K") ||
                mesa[pac.getLinha()][pac.getColuna() - 1].equals("K") || mesa[pac.getLinha()][pac.getColuna() + 1].equals("K");
    }

    private void startThreads(Thread lilas, Thread azul, Thread laranja, Thread vernelho1) {

        laranja.setPriority(Thread.MAX_PRIORITY);
        azul.setPriority(Thread.MAX_PRIORITY);
        lilas.setPriority(Thread.MAX_PRIORITY);
        vernelho1.setPriority(Thread.MAX_PRIORITY);

        laranja.start();
        azul.start();
        lilas.start();
        vernelho1.start();

    }

    private synchronized void paraGhosts(Thread lilas, Thread azul, Thread laranja, Thread vermelho1) {
        lilas.interrupt();
        azul.interrupt();
        laranja.interrupt();
        vermelho1.interrupt();
    }

    /**
     * Verifica qual botão do direcional foi precionado e muda a direção do Pacman
     *
     * @param tela
     */
    private synchronized void verificaDirecional(Tela tela) {
        tela.texto.addKeyListener(new KeyAdapter() {
            public synchronized void keyPressed(KeyEvent evt) {
                int aux;
                int keyCode = evt.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_DOWN:  //Baixo
                        if (!mesa[pac.getLinha() + 1][pac.getColuna()].equals("#")) {
                            if (pac.getDirecao() != 'D') {
                                pac.setDirecao('D');
                            }
                        }
                        break;
                    case KeyEvent.VK_UP: //Cima
                        if (!mesa[pac.getLinha() - 1][pac.getColuna()].equals("#")) {
                            if (pac.getDirecao() != 'U') {
                                pac.setDirecao('U');
                            }
                        }
                        break;
                    case KeyEvent.VK_LEFT: //Esquerda
                        if (!mesa[pac.getLinha()][pac.getColuna() - 1].equals("#")) {
                            if (pac.getDirecao() != 'L') {
                                pac.setDirecao('L');
                            }
                        }
                        break;
                    case KeyEvent.VK_RIGHT:  //Direita
                        if (!mesa[pac.getLinha()][pac.getColuna() + 1].equals("#")) {
                            if (pac.getDirecao() != 'R') {
                                pac.setDirecao('R');
                            }
                        }
                        break;
                }
            }
        });
    }


}
