package Lib;

import Modelo.Ghost;

import static Lib.Execute.colunas;
import static Lib.Execute.pac;

/**
 * Created by Diego on 23/05/2017.
 */
public class MovimentoGhost {

    private static Ghost ghostVermelho1 = new Ghost(10, 17, ' ', 'K', '.');
    private static Ghost ghostAzul = new Ghost(10, 19, ' ', '%', '.');
    private static Ghost ghostLilas = new Ghost(10, 20, ' ', '$', '.');
    private static Ghost ghostLaranja = new Ghost(10, 18, ' ', '@', '.');

    public MovimentoGhost() {
    }

    public synchronized static boolean olha() {
        if (ghostAzul.getSub().equals('C')) {
            System.out.println("Achou C");
            return true;
        }
        if (ghostVermelho1.getSub().equals('C')) {
            System.out.println("Achou C");
            return true;
        }
        if (ghostLilas.getSub().equals('C')) {
            System.out.println("Achou C");
            return true;
        }
        if (ghostLaranja.getSub().equals('C')) {
            System.out.println("Achou C");
            return true;
        }
        return false;
    }

    public static void init() {
        Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = ghostLilas.getIcone() + "";
        Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna()] = ghostAzul.getIcone() + "";
        Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna()] = ghostLaranja.getIcone() + "";
        Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna()] = ghostVermelho1.getIcone() + "";
    }


    /**
     * Classe Fantasma Lilas, muda direção de acordo com direção do Pacman
     */
    public static class MovimentoGhostLilas implements Runnable {
        public synchronized void run() {
            boolean flag = true;
            do {
                String aux = "";
                switch (pac.getDirecao()) {
                    case 'L':
                        if (Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()].equals("-")) {
                            Execute.mesa[ghostLilas.getLinha() - 2][ghostLilas.getColuna()] = ghostLilas.getIcone() + "";
                            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = " ";
                            ghostLilas.setLinha(ghostLilas.getLinha() - 2);
                        } else if (ghostLilas.getColuna() == 1 && Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals(" ")) {
                            movDireita();
                        } else if (!Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#")) {
                            movEsquerda();
                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#") && !Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
                            movBaixo();
                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#") && Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
                            do {
                                movDireita();
                            } while (pac.getDirecao().equals("D"));

                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals(" ")) {
                            movDireita();
                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#") && Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#") && !Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
                            movBaixo();
                        }
                        break;

                    case 'R':
                        if (Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()].equals("-")) {
                            Execute.mesa[ghostLilas.getLinha() - 2][ghostLilas.getColuna()] = ghostLilas.getIcone() + "";
                            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = " ";
                            ghostLilas.setLinha(ghostLilas.getLinha() - 2);
                        } else if (ghostLilas.getColuna() == colunas && Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals(" ")) {
                            movEsquerda();
                        } else if (!Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#")) {
                            movDireita();
                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#") && Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#") && !Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
                            movBaixo();
                        } else if ((Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#") || Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("  ")) && !Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
                            movBaixo();
                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals(" ")) {
                            movEsquerda();
                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#")) {
                            movEsquerda();
                        }
                        break;
                    case 'D': //Descendo
                        if (!Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#") && !Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("-")) {
                            movBaixo();
                            //Se esta subindo e tem barreira em baixo e emcima
                        } else if (Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#") && Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()].equals("#")) {
                            if (ghostLilas.getDirecao().equals('L')) {
                                movEsquerda();
                            } else if (ghostLilas.getDirecao().equals('R')) {
                                movDireita();
                            }
                            //Se esta subindo e tem barreira emcima
                        } else if (Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
                            if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#")) {
                                movEsquerda();
                            } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#")) {
                                movDireita();
                            } else {
                                movDireita();
                            }
                        }
                        break;
                    case 'U': //Subindo
                        //Esta saindo da casinha
                        if (Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()].equals("-")) {
                            Execute.mesa[ghostLilas.getLinha() - 2][ghostLilas.getColuna()] = ghostLilas.getIcone() + "";
                            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = " ";
                            ghostLilas.setLinha(ghostLilas.getLinha() - 2);
                            //Se não tem bairreira embaixo, ghost desce
                        } else if (!Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()].equals("#")) {
                            movCima();
                            ghostLilas.setDirecao('R');
                            //Se esta descendo e tem barreira embaixo e emcima
                        } else if (Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#") && Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()].equals("#")) {
                            if (ghostLilas.getDirecao().equals('L')) {
                                movEsquerda();
                            } else if (ghostLilas.getDirecao().equals('R')) {
                                movDireita();
                            }
                            //Se esta descendo e tem barreira embaixo
                        } else if (Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()].equals("#")) {
                            if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#")) {
                                movEsquerda();
                            } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#")) {
                                movDireita();
                            } else {
                                movEsquerda();
                            }

                        }
                        break;
                }
                try {
                    this.wait(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (flag);
        }

        private void movCima() {
            String aux;
            aux = Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()];
            Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()] = ghostLilas.getIcone() + "";
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = ghostLilas.getSub() + "";
            if (aux.charAt(0) != '%' && aux.charAt(0) != '@' && aux.charAt(0) != 'K') {
                ghostLilas.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostLilas.setLinha(ghostLilas.getLinha() - 1);
            ghostLilas.setDirecao('U');
        }

        private void movBaixo() {
            String aux;
            aux = Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()];
            Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()] = ghostLilas.getIcone() + "";
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = ghostLilas.getSub() + "";
            if (aux.charAt(0) != '%' && aux.charAt(0) != '@' && aux.charAt(0) != 'K') {
                ghostLilas.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostLilas.setLinha(ghostLilas.getLinha() + 1);
            ghostLilas.setDirecao('D');
        }

        private void movEsquerda() {
            String aux;
            aux = Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1];
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1] = ghostLilas.getIcone() + "";
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = ghostLilas.getSub() + "";
            if (aux.charAt(0) != '%' && aux.charAt(0) != '@' && aux.charAt(0) != 'K') {
                ghostLilas.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostLilas.setColuna(ghostLilas.getColuna() - 1);
            ghostLilas.setDirecao('L');
        }

        private void movDireita() {
            String aux;
            aux = Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1];
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1] = ghostLilas.getIcone() + "";
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = ghostLilas.getSub() + "";
            if (aux.charAt(0) != '%' && aux.charAt(0) != '@' && aux.charAt(0) != 'K') {
                ghostLilas.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostLilas.setColuna(ghostLilas.getColuna() + 1);
            ghostLilas.setDirecao('R');
        }
    }

    /**
     * Classe Fantasma Azul, muda direção de Contrária com direção do Pacman
     */
    public static class MovimentoGhostAzul implements Runnable {

        public synchronized void run() {
            boolean flag = true;
            do {
                String aux = "";
                switch (pac.getDirecao()) {
                    case 'R':
                        if (Execute.mesa[ghostAzul.getLinha() - 1][ghostAzul.getColuna()].equals("-")) {
                            Execute.mesa[ghostAzul.getLinha() - 2][ghostAzul.getColuna()] = ghostAzul.getIcone() + "";
                            Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna()] = " ";
                            ghostAzul.setLinha(ghostAzul.getLinha() - 2);
                        } else if (ghostAzul.getColuna() == 1 && Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1].equals(" ")) {
                            movDireita();
                        } else if (!Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1].equals("#")) {
                            movEsquerda();
                        } else if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1].equals("#") && !Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("#")) {
                            movBaixo();
                        } else if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1].equals("#") && Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("#")) {
                            movDireita();
                        } else if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1].equals(" ")) {
                            movDireita();
                        } else if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1].equals("#") && Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals("#") && !Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("#")) {
                            movBaixo();
                        }
                        break;

                    case 'L':
                        if (Execute.mesa[ghostAzul.getLinha() - 1][ghostAzul.getColuna()].equals("-")) {
                            Execute.mesa[ghostAzul.getLinha() - 2][ghostAzul.getColuna()] = ghostAzul.getIcone() + "";
                            Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna()] = " ";
                            ghostAzul.setLinha(ghostAzul.getLinha() - 2);
                        } else if (ghostAzul.getColuna() == colunas && Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals(" ")) {
                            movEsquerda();
                        } else if (!Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals("#")) {
                            movDireita();
                        } else if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals("#") && Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1].equals("#") && !Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("#")) {
                            movBaixo();
                        } else if ((Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals("#") || Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals("  ")) && !Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("#")) {
                            movBaixo();
                        } else if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals(" ")) {
                            movEsquerda();
                        } else if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals("#")) {
                            movEsquerda();
                        }
                        break;
                    case 'U': //Descendo
                        if (!Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("#") && !Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("-")) {
                            movBaixo();
                            //Se esta subindo e tem barreira em baixo e emcima
                        } else if (Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("#") && Execute.mesa[ghostAzul.getLinha() - 1][ghostAzul.getColuna()].equals("#")) {
                            if (ghostAzul.getDirecao().equals('L')) {
                                movEsquerda();
                            } else if (ghostAzul.getDirecao().equals('R')) {
                                movDireita();
                            }
                            //Se esta subindo e tem barreira emcima
                        } else if (Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("#")) {
                            if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals("#")) {
                                movEsquerda();
                            } else if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1].equals("#")) {
                                movDireita();
                            } else {
                                movDireita();
                            }
                        }
                        break;
                    case 'D': //Subindo
                        //Esta saindo da casinha
                        if (Execute.mesa[ghostAzul.getLinha() - 1][ghostAzul.getColuna()].equals("-")) {
                            Execute.mesa[ghostAzul.getLinha() - 2][ghostAzul.getColuna()] = ghostAzul.getIcone() + "";
                            Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna()] = " ";
                            ghostAzul.setLinha(ghostAzul.getLinha() - 2);
                            //Se não tem bairreira embaixo, ghost desce
                        } else if (!Execute.mesa[ghostAzul.getLinha() - 1][ghostAzul.getColuna()].equals("#")) {
                            movCima();
                            ghostAzul.setDirecao('R');
                            //Se esta descendo e tem barreira embaixo e emcima
                        } else if (Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()].equals("#") && Execute.mesa[ghostAzul.getLinha() - 1][ghostAzul.getColuna()].equals("#")) {
                            if (ghostAzul.getDirecao().equals('L')) {
                                movEsquerda();
                            } else if (ghostAzul.getDirecao().equals('R')) {
                                movDireita();
                            }
                            //Se esta descendo e tem barreira embaixo
                        } else if (Execute.mesa[ghostAzul.getLinha() - 1][ghostAzul.getColuna()].equals("#")) {
                            if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1].equals("#")) {
                                movEsquerda();
                            } else if (Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1].equals("#")) {
                                movDireita();
                            } else {
                                movEsquerda();
                            }
                        }
                        break;
                }
                try {
                    this.wait(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (flag);
        }

        private void movCima() {
            String aux;
            aux = Execute.mesa[ghostAzul.getLinha() - 1][ghostAzul.getColuna()];
            Execute.mesa[ghostAzul.getLinha() - 1][ghostAzul.getColuna()] = ghostAzul.getIcone() + "";
            Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna()] = ghostAzul.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '@' && aux.charAt(0) != 'K') {
                ghostAzul.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {

                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostAzul.setLinha(ghostAzul.getLinha() - 1);
            ghostAzul.setDirecao('U');
        }


        private void movBaixo() {
            String aux;
            aux = Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()];
            Execute.mesa[ghostAzul.getLinha() + 1][ghostAzul.getColuna()] = ghostAzul.getIcone() + "";
            Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna()] = ghostAzul.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '@' && aux.charAt(0) != 'K') {
                ghostAzul.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostAzul.setLinha(ghostAzul.getLinha() + 1);
            ghostAzul.setDirecao('D');
        }

        private void movEsquerda() {
            String aux;
            aux = Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1];
            Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() - 1] = ghostAzul.getIcone() + "";
            Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna()] = ghostAzul.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '@' && aux.charAt(0) != 'K') {
                ghostAzul.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostAzul.setColuna(ghostAzul.getColuna() - 1);
            ghostAzul.setDirecao('L');
        }

        private void movDireita() {
            String aux;
            aux = Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1];
            Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna() + 1] = ghostAzul.getIcone() + "";
            Execute.mesa[ghostAzul.getLinha()][ghostAzul.getColuna()] = ghostAzul.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '@' && aux.charAt(0) != 'K') {
                ghostAzul.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostAzul.setColuna(ghostAzul.getColuna() + 1);
            ghostAzul.setDirecao('R');
        }
    }


    public static class MovimentoGhostLaranja implements Runnable {
        private static Integer[][] PassouPosAbsoluta() {
            Integer[][] posAbs;
            posAbs = new Integer[17][2];
            posAbs[0][0] = 1;
            posAbs[0][1] = 1;
            posAbs[1][0] = 19;
            posAbs[1][1] = 1;

            posAbs[2][0] = 1;
            posAbs[2][1] = 35;
            posAbs[3][0] = 19;
            posAbs[3][1] = 35;

            posAbs[4][0] = 10;
            posAbs[4][1] = 5;
            posAbs[5][0] = 4;
            posAbs[5][1] = 9;

            posAbs[6][0] = 15;
            posAbs[6][1] = 10;
            posAbs[7][0] = 10;
            posAbs[7][1] = 11;

            posAbs[8][0] = 1;
            posAbs[8][1] = 17;
            posAbs[9][0] = 4;
            posAbs[9][1] = 22;

            posAbs[10][0] = 8;
            posAbs[10][1] = 19;
            posAbs[11][0] = 13;
            posAbs[11][1] = 18;

            posAbs[12][0] = 15;
            posAbs[12][1] = 23;
            posAbs[13][0] = 19;
            posAbs[13][1] = 17;

            posAbs[14][0] = 14;
            posAbs[14][1] = 31;
            posAbs[15][0] = 4;
            posAbs[15][1] = 29;

            posAbs[16][0] = 10;
            posAbs[16][1] = 30;


            int coluna = pac.getColuna();
            int linha = pac.getLinha();
            for (int i = 0; i < 17; i++) {
                if ((posAbs[i][0] == linha) && (posAbs[i][1] == coluna)) {
                    Integer[][] coordenada;
                    coordenada = new Integer[1][2];
                    coordenada[0][0] = linha;
                    coordenada[0][1] = coluna;
                    return coordenada;
                }
            }
            Integer[][] coordenada;
            coordenada = new Integer[1][2];
            coordenada[0][0] = -1;
            coordenada[0][1] = -1;
            return coordenada;
        }

        public synchronized void run() {
            int destinoLinha = 10; //Valores iniciais
            int destinoColuna = 17;
            boolean flag = true;
            do {
                int x = PassouPosAbsoluta()[0][0];
                int y = PassouPosAbsoluta()[0][1];
                if ((x == -1) && (y == -1)) {
                    // System.out.println("nao");
                } else {
                    destinoLinha = x;
                    destinoColuna = y;
                    //System.out.println("Posição absoluta - linha:" + destinoLinha + "  coluna:" + destinoColuna);
                }


                //Sair da casa
                if (pac.getDirecao() != 'I')
                    if (Execute.mesa[ghostLaranja.getLinha() - 1][ghostLaranja.getColuna()].equals("-")) {
                        Execute.mesa[ghostLaranja.getLinha() - 2][ghostLaranja.getColuna()] = ghostLaranja.getIcone() + "";
                        Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna()] = " ";
                        ghostLaranja.setLinha(ghostLaranja.getLinha() - 2);
                    } else if ((destinoLinha - ghostLaranja.getLinha() < 0) && ((!Execute.mesa[ghostLaranja.getLinha() - 1][ghostLaranja.getColuna()].equals("#")))) {
                        movCima();
                    } else if ((destinoLinha - ghostLaranja.getLinha() > 0) && (!Execute.mesa[ghostLaranja.getLinha() + 1][ghostLaranja.getColuna()].equals("#")) && (!Execute.mesa[ghostLaranja.getLinha() + 1][ghostLaranja.getColuna()].equals("-"))) {
                        movBaixo();
                    } else if ((destinoColuna - ghostLaranja.getColuna() < 0) && ((!Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna() - 1].equals("#")))) {
                        movEsquerda();
                    } else if ((destinoColuna - ghostLaranja.getColuna() > 0) && ((!Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna() + 1].equals("#")))) {
                        movDireita();
                    } else {
                        if ((!Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna() + 1].equals("#")) && (ghostLaranja.getDirecao() != 'L')) {
                            movDireita();
                        } else if ((!Execute.mesa[ghostLaranja.getLinha() + 1][ghostLaranja.getColuna()].equals("#")) && (!Execute.mesa[ghostLaranja.getLinha() + 1][ghostLaranja.getColuna()].equals("-")) && (ghostLaranja.getDirecao() != 'D') && (!Execute.mesa[ghostLaranja.getLinha() + 1][ghostLaranja.getColuna()].equals("-"))) {
                            movBaixo();
                        } else if ((!Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna() - 1].equals("#")) && (ghostLaranja.getDirecao() != 'R')) {
                            movEsquerda();
                        } else if ((!Execute.mesa[ghostLaranja.getLinha() - 1][ghostLaranja.getColuna()].equals("#")) && (ghostLaranja.getDirecao() != 'U')) {
                            movCima();
                        }
                    }



                try {
                    this.wait(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } while (flag);
        }

        private void movCima() {
            String aux;
            aux = Execute.mesa[ghostLaranja.getLinha() - 1][ghostLaranja.getColuna()];
            Execute.mesa[ghostLaranja.getLinha() - 1][ghostLaranja.getColuna()] = ghostLaranja.getIcone() + "";
            Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna()] = ghostLaranja.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '%' && aux.charAt(0) != 'K') {
                ghostLaranja.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostLaranja.setLinha(ghostLaranja.getLinha() - 1);
            ghostLaranja.setDirecao('U');
        }

        private void movBaixo() {
            String aux;
            aux = Execute.mesa[ghostLaranja.getLinha() + 1][ghostLaranja.getColuna()];
            Execute.mesa[ghostLaranja.getLinha() + 1][ghostLaranja.getColuna()] = ghostLaranja.getIcone() + "";
            Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna()] = ghostLaranja.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '%' && aux.charAt(0) != 'K') {
                ghostLaranja.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {

                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostLaranja.setLinha(ghostLaranja.getLinha() + 1);
            ghostLaranja.setDirecao('D');
        }

        private void movEsquerda() {
            String aux;
            aux = Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna() - 1];
            Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna() - 1] = ghostLaranja.getIcone() + "";
            Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna()] = ghostLaranja.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '%' && aux.charAt(0) != 'K') {
                ghostLaranja.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostLaranja.setColuna(ghostLaranja.getColuna() - 1);
            ghostLaranja.setDirecao('L');
        }

        private void movDireita() {
            String aux;
            aux = Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna() + 1];
            Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna() + 1] = ghostLaranja.getIcone() + "";
            Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna()] = ghostLaranja.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '%' && aux.charAt(0) != 'K') {
                ghostLaranja.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostLaranja.setColuna(ghostLaranja.getColuna() + 1);
            ghostLaranja.setDirecao('R');
        }


    }

    public static class MovimentoGhostVermelho1 implements Runnable {
        public synchronized void run() {

            int i = 0;
            boolean flag = true;
            boolean comecou = false;
            char dir = 'u';
            do {
                if ((pac.getLinha() != 10) || (pac.getColuna() != 4)) {
                    comecou = true;
                }
                while (comecou) {
                    if (i == 0) {
                        movDireita();
                        i++;
                    } else if (i == 1) {
                        movCima();
                        i++;
                    } else if (i == 2) {
                        movCima();
                        i++;
                        dir = 'u';
                    } else {
                        if ((dir == 'u') && ((!Execute.mesa[ghostVermelho1.getLinha() - 1][ghostVermelho1.getColuna()].equals("#")))) {
                            movCima();
                        } else if ((dir == 'u') && ((!Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() + 1].equals("#"))) || (dir == 'r') && ((!Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() + 1].equals("#")))) {
                            movDireita();
                            dir = 'r';
                        } else if ((dir == 'r') && ((!Execute.mesa[ghostVermelho1.getLinha() + 1][ghostVermelho1.getColuna()].equals("#"))) || (dir == 'd') && ((!Execute.mesa[ghostVermelho1.getLinha() + 1][ghostVermelho1.getColuna()].equals("#")))) {
                            movBaixo();
                            dir = 'd';
                        } else if ((dir == 'd') && ((!Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() - 1].equals("#"))) || (dir == 'l') && ((!Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() - 1].equals("#")))) {
                            movEsquerda();
                            dir = 'l';
                        } else {

                            if ((dir == 'l') && ((!Execute.mesa[ghostVermelho1.getLinha() + 1][ghostVermelho1.getColuna()].equals("#")))) {
                                movBaixo();
                                dir = 'd';
                            } else if ((dir == 'l') && ((!Execute.mesa[ghostVermelho1.getLinha() - 1][ghostVermelho1.getColuna()].equals("#")))) {
                                movCima();
                                dir = 'u';
                            } else if ((dir == 'u') && ((!Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() + 1].equals("#")))) {
                                movDireita();
                                dir = 'r';
                            } else if ((dir == 'u') && ((!Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() - 1].equals("#")))) {
                                movEsquerda();
                                dir = 'l';
                            } else if ((dir == 'r') && ((!Execute.mesa[ghostVermelho1.getLinha() + 1][ghostVermelho1.getColuna()].equals("#")))) {
                                movBaixo();
                                dir = 'd';
                            } else if ((dir == 'r') && ((!Execute.mesa[ghostVermelho1.getLinha() - 1][ghostVermelho1.getColuna()].equals("#")))) {
                                movCima();
                                dir = 'u';
                            } else if ((dir == 'd') && ((!Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() - 1].equals("#")))) {
                                movEsquerda();
                                dir = 'l';
                            } else if ((dir == 'd') && ((!Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() + 1].equals("#")))) {
                                movDireita();
                                dir = 'r';
                            }
                        }
                    }
                    try {
                        this.wait(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            } while (flag);


        }

        private void movCima() {
            String aux;
            aux = Execute.mesa[ghostVermelho1.getLinha() - 1][ghostVermelho1.getColuna()];
            Execute.mesa[ghostVermelho1.getLinha() - 1][ghostVermelho1.getColuna()] = ghostVermelho1.getIcone() + "";
            Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna()] = ghostVermelho1.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '%' && aux.charAt(0) != '@') {
                ghostVermelho1.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostVermelho1.setLinha(ghostVermelho1.getLinha() - 1);
            ghostVermelho1.setDirecao('U');
        }

        private void movBaixo() {
            String aux;
            aux = Execute.mesa[ghostVermelho1.getLinha() + 1][ghostVermelho1.getColuna()];
            Execute.mesa[ghostVermelho1.getLinha() + 1][ghostVermelho1.getColuna()] = ghostVermelho1.getIcone() + "";
            Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna()] = ghostVermelho1.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '%' && aux.charAt(0) != '@') {
                ghostVermelho1.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostVermelho1.setLinha(ghostVermelho1.getLinha() + 1);
            ghostVermelho1.setDirecao('D');
        }

        private void movEsquerda() {
            String aux;
            aux = Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() - 1];
            Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() - 1] = ghostVermelho1.getIcone() + "";
            Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna()] = ghostVermelho1.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '%' && aux.charAt(0) != '@') {
                ghostVermelho1.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }

            ghostVermelho1.setColuna(ghostVermelho1.getColuna() - 1);
            ghostVermelho1.setDirecao('L');
        }

        private void movDireita() {
            String aux;
            aux = Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() + 1];
            Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna() + 1] = ghostVermelho1.getIcone() + "";
            Execute.mesa[ghostVermelho1.getLinha()][ghostVermelho1.getColuna()] = ghostVermelho1.getSub() + "";
            if (aux.charAt(0) != '$' && aux.charAt(0) != '%' && aux.charAt(0) != '@') {
                ghostVermelho1.setSub(aux.charAt(0));
            } else if (aux.charAt(0) == 'C') {
                try {
                    Thread.interrupted();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
            ghostVermelho1.setColuna(ghostVermelho1.getColuna() + 1);
            ghostVermelho1.setDirecao('R');
        }

    }

}