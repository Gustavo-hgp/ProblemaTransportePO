
public class CantoNoroeste extends OfertaDemanda{



    public CantoNoroeste() {
    }

    public static int[][] cantoNoroeste( OfertaDemanda valor) {
        int linhas = valor.oferta.length;
        int colunas = valor.demanda.length;

        // Inicialização da solução
        int[][] solucao = new int[linhas][colunas];

        int[] ofertaResidual = valor.oferta.clone();
        int[] demandaResidual = valor.demanda.clone();

        // Preenchimento da solução usando o método do canto noroeste
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                int quantidade = Math.min(ofertaResidual[i], demandaResidual[j]);
                solucao[i][j] = quantidade;
                ofertaResidual[i] -= quantidade;
                demandaResidual[j] -= quantidade;
            }
        }

        return solucao;
    }

    public static int calcularCustoTotal(int[][] solucao, int[][] custos) {
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

