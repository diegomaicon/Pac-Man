package Lib;

import Modelo.Ghost;

import static Lib.Execute.pac;

/**
 * Created by Diego on 23/05/2017.
 */
public class MovimentoGhost {

    private Ghost ghostVermelho1;
    private Ghost ghostVermelho12;
    private static Ghost ghostAzul;
    private static Ghost ghostLilas = new Ghost(10, 20, ' ', '$', ' ');
    private static Ghost ghostLaranja = new Ghost(10, 17, 'D', '@', ' ');

    public MovimentoGhost() {
    }

    public static void init() {
        Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = ghostLilas.getIcone() + "";
        //  Execute.mesa[ghostLaranja.getLinha()][ghostLaranja.getColuna()] = ghostLaranja.getIcone() + "";
    }


    /**
     * Classe Fantasma Lilas, muda direção de acordo com direção do Pacman
     */
    public static class MovimentoGhostLilas extends Thread {

        public void run() {
            boolean flag = true;
            do {
                String aux = "";
                switch (pac.getDirecao()) {
                    case 'L':
                        if (Execute.mesa[ghostLilas.getLinha() - 1][ghostLilas.getColuna()].equals("-")) {
                            Execute.mesa[ghostLilas.getLinha() - 2][ghostLilas.getColuna()] = ghostLilas.getIcone() + "";
                            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = " ";
                            ghostLilas.setLinha(ghostLilas.getLinha() - 2);
                        } else if (!Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#")) {
                            movEsquerda();
                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#") && !Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
                            movBaixo();
                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#") && Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
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
                        } else if (!Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#")) {
                            movDireita();
                        } else if (Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#") && Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1].equals("#") && !Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
                            movBaixo();
                        } else if ((Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("#") || Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1].equals("  ")) && !Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()].equals("#")) {
                            movBaixo();
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
                    sleep(200);
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
            ghostLilas.setSub(aux.charAt(0));
            ghostLilas.setLinha(ghostLilas.getLinha() - 1);
            ghostLilas.setDirecao('U');
        }

        private void movBaixo() {
            String aux;
            aux = Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()];
            Execute.mesa[ghostLilas.getLinha() + 1][ghostLilas.getColuna()] = ghostLilas.getIcone() + "";
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = ghostLilas.getSub() + "";
            ghostLilas.setSub(aux.charAt(0));
            ghostLilas.setLinha(ghostLilas.getLinha() + 1);
            ghostLilas.setDirecao('D');
        }

        private void movEsquerda() {
            String aux;
            aux = Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1];
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() - 1] = ghostLilas.getIcone() + "";
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = ghostLilas.getSub() + "";
            ghostLilas.setSub(aux.charAt(0));
            ghostLilas.setColuna(ghostLilas.getColuna() - 1);
            ghostLilas.setDirecao('L');
        }

        private static void movDireita() {
            String aux;
            aux = Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1];
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna() + 1] = ghostLilas.getIcone() + "";
            Execute.mesa[ghostLilas.getLinha()][ghostLilas.getColuna()] = ghostLilas.getSub() + "";
            ghostLilas.setSub(aux.charAt(0));
            ghostLilas.setColuna(ghostLilas.getColuna() + 1);
            ghostLilas.setDirecao('R');
        }
    }
}





/*
    public void verificaD(String estado) {
        int aux;
        if (estado.equals("D")) {
            //Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
            }

            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q1";
                formiga[3] = "T";
            }


            // frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q2";
            }

            // frete
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q3";
            }

            //Direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q4";
                formiga[3] = "T";
            }
            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q5";
                formiga[3] = "M";
            }
            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q6";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q7";
                formiga[3] = "M";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q8";
            }


            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q9";
                formiga[3] = "M";
            }

            //Direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q10";
                formiga[3] = "T";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q11";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q12";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q13";
                formiga[3] = "M";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q14";
            }

            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q15";
                formiga[3] = "T";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q16";
                formiga[3] = "M";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q17";
                formiga[3] = "M";
            }
            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q18";
                formiga[3] = "T";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q19";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q20";
            }


            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q21";
                formiga[3] = "T";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q22";
                formiga[3] = "M";
            }


            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q23";
            }


            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q24";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q25";
            }
            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q26";
                formiga[3] = "T";
            }

        }
    }


    public void verificaT(String estado) {

        int aux;
        if (estado.equals("T")) {
            // frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1] + 1)][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
            }

            // direita
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q1";
                formiga[3] = "E";
            }


            // frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q2";
            }

            // frete
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q3";
            }

            //Direita
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q4";
                formiga[3] = "E";
            }
            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q5";
                formiga[3] = "D";
            }
            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q6";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q7";
                formiga[3] = "D";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q8";
            }


            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q9";
                formiga[3] = "D";
            }

            //Direita
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q10";
                formiga[3] = "E";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q11";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2] + 1)].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q12";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q13";
                formiga[3] = "D";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q14";
            }

            // direita
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q15";
                formiga[3] = "E";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q16";
                formiga[3] = "D";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q17";
                formiga[3] = "D";
            }
            // direita
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q18";
                formiga[3] = "E";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q19";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q20";
            }


            // direita
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q21";
                formiga[3] = "E";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q22";
                formiga[3] = "D";
            }


            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q23";
            }


            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q24";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                ;
                formiga[0] = "q25";
            }
            // direita
            if (mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q26";
                formiga[3] = "E";
            }

        }
    }

    public void verificaM(String estado) {

        int aux;
        if (estado.equals("M")) {
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
            }

            // direita
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q1";
                formiga[3] = "D";
            }


            // frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q2";
            }

            // frete pronto
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q3";
            }

            //Direita
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q4";
                formiga[3] = "D";
            }
            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q5";
                formiga[3] = "E";
            }
            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q6";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q7";
                formiga[3] = "E";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q8";
            }


            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q9";
                formiga[3] = "E";
            }

            //Direita
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q10";
                formiga[3] = "D";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q11";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q12";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q13";
                formiga[3] = "E";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q14";
            }

            // direita
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q15";
                formiga[3] = "D";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q16";
                formiga[3] = "E";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q17";
                formiga[3] = "E";
            }
            // direita
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q18";
                formiga[3] = "D";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q19";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q20";
            }


            // direita
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q21";
                formiga[3] = "D";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q22";
                formiga[3] = "E";
            }


            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q23";
            }


            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q24";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                ;
                formiga[0] = "q25";
            }
            // direita
            if (mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q26";
                formiga[3] = "D";
            }

        }
    }

    public void verificaE(String estado) {

        int aux;
        if (estado.equals("E")) {
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
            }

            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q1";
                formiga[3] = "M";
            }


            // frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q2";
            }

            // frete
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q3";
            }

            //Direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q4";
                formiga[3] = "M";
            }
            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q5";
                formiga[3] = "T";
            }
            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q6";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q7";
                formiga[3] = "T";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q8";
            }


            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q9";
                formiga[3] = "T";
            }

            //Direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q10";
                formiga[3] = "T";
            }

            // Frente pronto
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) - 1] = "C";
                aux = Integer.parseInt(formiga[2]) - 1;
                formiga[2] = aux + "";
                formiga[0] = "q11";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q12";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q13";
                formiga[3] = "M";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q14";
            }

            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q15";
                formiga[3] = "T";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals(" ") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q16";
                formiga[3] = "M";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q17";
                formiga[3] = "M";
            }
            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q18";
                formiga[3] = "T";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals(" ") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q19";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals(" ")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q20";
            }


            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q21";
                formiga[3] = "T";
            }

            // Esquerda
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) - 1;
                formiga[1] = aux + "";
                formiga[0] = "q22";
                formiga[3] = "M";
            }


            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q23";
            }


            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q24";
            }

            // Frente
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("a") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("#") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("#")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1] = "C";
                aux = Integer.parseInt(formiga[2]) + 1;
                formiga[2] = aux + "";
                formiga[0] = "q25";
            }
            // direita
            if (mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2]) + 1].equals("#") && mesa[Integer.parseInt(formiga[1]) - 1][Integer.parseInt(formiga[2])].equals("a") && mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])].equals("a")) {
                mesa[Integer.parseInt(formiga[1])][Integer.parseInt(formiga[2])] = " ";
                mesa[Integer.parseInt(formiga[1]) + 1][Integer.parseInt(formiga[2])] = "C";
                aux = Integer.parseInt(formiga[1]) + 1;
                formiga[1] = aux + "";
                formiga[0] = "q26";
                formiga[3] = "T";
            }

        }
    }
    */

