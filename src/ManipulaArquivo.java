import Modelo.Pac;
import Modelo.Som;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;


import javax.swing.*;


public class ManipulaArquivo {

    public static int qtdAcucar;
    public static int parada;
    public static String formiga[];
    static int linhas = 0;
    static int colunas = 0;



    public static String[][] mesa;
    public static String[] inicia;
    public static Pac pac;
    public static int score = 0;

    Som som = new Som();
    private static boolean ligaSom = false;

    static ArrayList<ArrayList<String>> listaTrans = new ArrayList<ArrayList<String>>();
    static ArrayList<String> listaTransicao = new ArrayList<String>();

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
                    if ((i == (linhas+1)/2  && j == 0) || (i == (linhas+1)/2  && j == colunas+1))
                        mesa[i][j] = " ";
                    else if (i == 0)
                        mesa[i][j] = "#";
                    else if (j == 0)
                        mesa[i][j] = "#";
                    else if (i == linhas+1 )
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
            while (linha.charAt(0) != 'A'){
                linha = limpaString(linha);
                montaBarreira(linha);
                linha = lerArqMesa.readLine();
            }
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
            qtdAcucar = aux / 2;

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
            for (int i = 0; i < qtdAcucar * 2; ) {
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

    public boolean carregarAutomato() {

        String nome = "auto1.txt";
        try {
            FileReader arqAuto = new FileReader(nome);
            BufferedReader lerArqAuto = new BufferedReader(arqAuto);
            String linha = lerArqAuto.readLine();
            String[] temp = new String[2];
            // ################################################### Monta Mesa
            // ################################################

            // ################################################### Barreira
            // ################################################
            linha = lerArqAuto.readLine(); // Le 2� linha
            linha = limpaString(linha);

            temp = new String[254];
            temp = linha.split(" ");
            linha = lerArqAuto.readLine(); // Le 2� linha

            // ################################################
            linha = lerArqAuto.readLine(); // Le 3� linha
            linha = linha.replaceAll("[(]", "");
            linha = limpaString(linha);
            temp = new String[254];
            temp = linha.split(",");

            int aux = 0;
            for (int i = 0; i < temp.length; i++) {
                if (!temp[i].equals("")) {
                    listaTransicao.add(temp[i]);
                    aux++;
                    if (aux % 7 == 0) {
                        listaTrans.add(listaTransicao);
                        listaTransicao = new ArrayList<String>();
                    }
                }

            }

            arqAuto.close();

        } catch (IOException e) {

            return false;
        }

        return true;
    }

    public boolean movimenta()  {

        Tela tela = new Tela();
        tela.setTitle("   Pac-man LFA    ");
        tela.setSize(850, 700);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.texto.setBackground(Color.BLACK);
        tela.texto.setForeground(Color.GREEN);
        tela.texto.setFont(new Font("Consolas", Font.BOLD, 20));
        tela.texto.setText(imprimeMesa());
        tela.label.setText("Score : " + score);
        verificaDirecional(tela);


        formiga = new String[4];
        formiga[0] = "q0"; // Estado
        formiga[1] = inicia[0]; // Posição linha
        formiga[2] = inicia[1]; // Posição coluna
        formiga[3] = inicia[2]; // Direção

        int cont = 0;


        do {

            switch (pac.getDirecao()) {

                case 'D': // Para Baixo
                    if (!mesa[pac.getLinha() + 1][pac.getColuna()].equals("#")){
                        if(mesa[pac.getLinha() + 1][pac.getColuna()].equals(".")){
                            score+=10;
                            if(ligaSom) som.comendoMoeda();
                        }else if(ligaSom) som.parado();
                        mesa[pac.getLinha() + 1][pac.getColuna()] = "C";
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setLinha(pac.getLinha() + 1);
                        pac.setDirecao('D');
                        System.out.println(pac.toString());
                    }else if(ligaSom) som.parado();

                    break;
                case 'U': // Para Cima
                    if(!mesa[pac.getLinha() - 1][pac.getColuna()].equals("#")) {
                        if(mesa[pac.getLinha() -1][pac.getColuna()].equals(".")){
                            score+=10;
                            if(ligaSom) som.comendoMoeda();
                        }else if(ligaSom)  som.parado();
                        mesa[pac.getLinha() - 1][pac.getColuna()] = "C";
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setLinha(pac.getLinha() - 1);
                        pac.setDirecao('U');
                        System.out.println(pac.toString());

                    }else som.parado();
                    break;
                case 'L': //Esquerda
                    if(pac.getColuna() == 0){
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setColuna(colunas+1);
                        break;
                    }

                    if(!mesa[pac.getLinha()][pac.getColuna() - 1].equals("#")) {
                        if(mesa[pac.getLinha()][pac.getColuna() -1].equals(".")){
                            score+=10;
                            if(ligaSom)  som.comendoMoeda();
                        }else if(ligaSom) som.parado();
                        mesa[pac.getLinha()][pac.getColuna() - 1] = "C";
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setColuna(pac.getColuna() - 1);
                        pac.setDirecao('L');
                        System.out.println(pac.toString());

                    }else if(ligaSom) som.parado();
                    break;
                case 'R': //Direita
                    if(pac.getColuna() == colunas+1){
                        mesa[pac.getLinha()][pac.getColuna()] = " ";
                        pac.setColuna(0);
                        break;
                    }

                    if(!mesa[pac.getLinha()][pac.getColuna() + 1].equals("#")){
                        if(mesa[pac.getLinha()][pac.getColuna() + 1].equals(".")){
                            score+=10;
                            if(ligaSom) som.comendoMoeda();
                        }else if(ligaSom)  som.parado();
                    mesa[pac.getLinha()][pac.getColuna() + 1] = "C";
                    mesa[pac.getLinha()][pac.getColuna()] = " ";
                    pac.setColuna(pac.getColuna() + 1);
                    pac.setDirecao('R');
                    System.out.println(pac.toString());

                } else if(ligaSom) som.parado();
                    break;
            }

            tela.label.setText("Score : " + score);
            tela.texto.setText(imprimeMesa());

            try {
                //Velocidade de execução
                Thread.sleep(200);
            } catch (Exception e) {
                // TODO: handle exception
            }

            cont++;
        } while (qtdAcucar < 0 || cont < parada);

        return false;
    }

    private void verificaDirecional(Tela tela) {
        tela.texto.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                int aux;
                int keyCode = evt.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_DOWN:  //Baixo
                        if (!mesa[pac.getLinha() + 1][pac.getColuna()].equals("#")) {
                            if (pac.getDirecao() != 'D'){
                                pac.setDirecao('D');
                                System.out.println(pac.toString());
                            }
                        }
                        break;
                    case KeyEvent.VK_UP: //Cima
                        if(!mesa[pac.getLinha() - 1][pac.getColuna()].equals("#")) {
                            if (pac.getDirecao() != 'U') {
                                pac.setDirecao('U');
                                System.out.println(pac.toString());
                            }
                        }
                        break;
                    case KeyEvent.VK_LEFT: //Esquerda
                        if(!mesa[pac.getLinha()][pac.getColuna() - 1].equals("#")) {
                            if (pac.getDirecao() != 'L') {
                                pac.setDirecao('L');
                                System.out.println(pac.toString());
                            }
                        }
                        break;
                    case KeyEvent.VK_RIGHT:  //Direita
                        if(!mesa[pac.getLinha()][pac.getColuna() + 1].equals("#")) {
                            if (pac.getDirecao() != 'R') {
                                pac.setDirecao('R');
                                System.out.println(pac.toString());
                            }
                        }
                        break;
                }
            }
        });
    }

}
