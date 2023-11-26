public class CustoMinimo extends OfertaDemanda {



    public CustoMinimo() {

    }

    public static Integer[][] resolverCustoMinimo(OfertaDemanda ofertaDemanda) {
        int numFornecedores = ofertaDemanda.custos.length;
        int numDestinos = ofertaDemanda.custos[0].length;


        Integer[][] alocacao = new Integer[numFornecedores][numDestinos];

        while (true) {
            int[] minCostCell = encontrarCustoMinimo(ofertaDemanda.getCustos(), alocacao);
            if (minCostCell == null) {
                break; // Todas as células foram alocadas
            }

            int i = minCostCell[0];
            int j = minCostCell[1];

            int quantidadeAlocada = Math.min(ofertaDemanda.oferta[i], ofertaDemanda.demanda[j]);

            alocacao[i][j] = quantidadeAlocada;

            ofertaDemanda.oferta[i] -= quantidadeAlocada;
            ofertaDemanda.demanda[j] -= quantidadeAlocada;

            if(ofertaDemanda.oferta[i] == 0 || ofertaDemanda.demanda[j] == 0 ) {
                if (ofertaDemanda.oferta[i] == 0) {
                    zerarLinhaEscolhida(i, numDestinos, j, alocacao);
                }else  {
                    zerarColunaEscolhida(j, numFornecedores, i, alocacao);
                }
            }
        }
        return alocacao;
    }



    public static int[] encontrarCustoMinimo(int[][] custos, Integer[][] alocacao) {
        int numFornecedores = custos.length;
        int numDestinos = custos[0].length;

        int[] minCostCell = null;
        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < numFornecedores; i++) {
            for (int j = 0; j < numDestinos; j++) {
                if (alocacao[i][j] == null && custos[i][j] < minCost) {
                    minCost = custos[i][j];
                    minCostCell = new int[]{i, j};
                }
            }
        }
        return minCostCell;
    }

    private static void zerarLinhaEscolhida(int linha, int qtdeColunas, int colunaMinima, Integer[][] alocacao){
        for (int i = 0; i < qtdeColunas; i++){
            if (i != colunaMinima && alocacao[linha][i] == null){
                alocacao[linha][i] = 0;
            }
        }
    }

    private static void zerarColunaEscolhida(int coluna, int qtdeLinhas, int linhaMinima, Integer[][] alocacao) {
        for (int i = 0; i < qtdeLinhas; i++){
            if (i != linhaMinima && alocacao[i][coluna] == null){
                alocacao[i][coluna] = 0;
            }
        }
    }
    public static int calcularCustoTotal(Integer[][] solucao, int[][] custos) {
        int linhas = solucao.length;
        int colunas = solucao[0].length;

        int custoTotal = 0;

        // Cálculo do custo total (Z)
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                custoTotal += solucao[i][j] * custos[i][j];
            }
        }

        return custoTotal;
    }
}

