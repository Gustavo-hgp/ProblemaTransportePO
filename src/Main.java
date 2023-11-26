public class Main {
    public static void main(String[] args) {
        OfertaDemanda values = new OfertaDemanda();


        // SOLUÇÃO CANTO NOROESTE
        int[][] solucaoCN = new CantoNoroeste().cantoNoroeste(values);
        int custoTotal = new CantoNoroeste().calcularCustoTotal(solucaoCN, values.custos);

        //Imprimir a solução e o custo total
        System.out.println("Solução Canto Noroeste:");
        for (int i = 0; i < solucaoCN.length; i++) {
            for (int j = 0; j < solucaoCN[0].length; j++) {
                System.out.print(solucaoCN[i][j] + "\t  |");
            }
            System.out.println();
        }

        System.out.println("\nCusto Total (Z): " + custoTotal);
        System.out.println("//_________________________________________________________________________________//");


        // SOLUÇÃO CUSTO MINIMO
        Integer[][] solucaoCustoMinimo = new CustoMinimo().resolverCustoMinimo(values);
        int custoTotalCM = new CustoMinimo().calcularCustoTotal(solucaoCustoMinimo, values.custos);

        //Imprimir a solução e o custo total
        System.out.println("Solução Canto minimo:");
        for (int i = 0; i < solucaoCustoMinimo.length; i++) {
            for (int j = 0; j < solucaoCustoMinimo[0].length; j++) {
                System.out.print(solucaoCustoMinimo[i][j] + "\t  |");
            }
            System.out.println();
   }

        System.out.println("\nCusto Total (Z): " + custoTotalCM);
        System.out.println("//_________________________________________________________________________________//");




    }
}
