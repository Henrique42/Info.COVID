package com.mycompany.projetocovid;

// Classe abstrata que faz as operações relacionadas aos meses
public abstract class Mes {
    // Classe que recebe o número do mês e retorna a data do último dia do mesmo, no formato mmdd
    static String getData(int n){
        switch(n){
            case 1:
                return "0131";
            case 2:
                return "0228";
            case 3:
                return "0331";
            case 4:
                return "0430";
            case 5:
                return "0530";
            case 6:
                return "0630";
            case 7:
                return "0731";
            case 8:
                return "0831";
            case 9:
                return "0930";
            case 10:
                return "1031";
            case 11:
                return "1130";
            case 12:
                return "1231";
            default:
                return "";
        }
    }
    
    // Classe que recebe o número do mês e retorna o nome do mesmo abreviado
    static String getNome(int n){
        switch(n){
            case 1:
                return "JAN";
            case 2:
                return "FEV";
            case 3:
                return "MAR";
            case 4:
                return "ABR";
            case 5:
                return "MAI";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AGO";
            case 9:
                return "SET";
            case 10:
                return "OUT";
            case 11:
                return "NOV";
            case 12:
                return "DEZ";
            default:
                return "";
        }
    }
}
