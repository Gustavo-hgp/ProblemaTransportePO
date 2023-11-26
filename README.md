
# Problema do Transporte

Implementação do algoritmo do Canto Noroeste e Custo Minimo em Java para resolver problemas em logística de transporte, design de redes de distribuição, e alocação eficiente de recursos em cadeias de suprimentos.

Através da comparação vemos qual método é melhor para determinada solução e assim podemos tomar decisões. 

## Funcionalidades

- Alocação de Recursos: Ambos são usados para alocar recursos de maneira eficiente de acordo com a oferta e a demanda.

- Iteração: Ambos operam em um processo iterativo até que todas as ofertas e demandas sejam atendidas.

- Respeito às Restrições: Podem ser adaptados para respeitar restrições específicas do problema, como limitações de capacidade em rotas.


## Problema - Exemplo

A fabrica de doce GM localizada em Belo Horizonte, tem 9 filiais no sul e sudeste do brasil. A produção foi direcionada pra atender diversos estados do norte e nordeste que ainda nao contam com filiais fisicas da fabrica. as 10 filiais devem atender 26 estados e o distrito federal, totalizando 27 locais de demanda. Usando o algoritimo de custo minimo e canto noroesta vamos descobrir quanto deve ser produzido e entregue por cada fábrica em cada centro consumidor, de forma a minimizar os custos de transporte.

Os 27 locais tem uma demanda de 43915 barrasde chocolates por semana, sendo divididas por:
```bash
1208, 1823, 1685, 1894, 1456,
1721, 1123, 1342, 1167, 1530,
1312, 1755, 1497, 1942, 1355, 
1924, 1713, 1828, 1986, 1105,
1907, 1134, 1558, 1975, 1127, 
1967, 1689 
```

Sendo assim as 10 fabricas para atender esse problema deve produzir, respectivamente:
```bash
{3896, 3569, 3516, 4434, 4445, 3676, 3941, 4502, 4123, 4193}
```

Gerando assim uma matriz 10 x 27 
Com os custos de transporte de cada filial representados abaixo: 
```bash
{26, 24, 30, 25, 29, 19, 29, 26, 21, 22, 29, 16, 30, 17, 18, 27, 23, 30, 26, 16, 25, 27, 20, 20, 16, 18, 28}
{19, 21, 28, 15, 22, 30, 20, 24, 15, 25, 17, 28, 27, 22, 25, 29, 23, 23, 22, 18, 29, 23, 22, 17, 30, 23, 18}
{29, 30, 26, 19, 25, 21, 19, 27, 20, 17, 19, 22, 22, 27, 26, 27, 29, 23, 18, 30, 17, 27, 20, 18, 19, 26, 27}
{19, 26, 30, 19, 19, 28, 30, 17, 26, 30, 30, 26, 29, 23, 27, 21, 30, 24, 26, 23, 30, 29, 17, 30, 30, 18, 20}
{29, 29, 25, 16, 26, 26, 18, 30, 19, 26, 18, 22, 18, 27, 21, 22, 30, 17, 19, 17, 24, 26, 22, 16, 18, 22, 25}
{19, 28, 15, 19, 23, 23, 20, 17, 25, 29, 17, 27, 26, 26, 27, 22, 23, 18, 17, 25, 16, 30, 18, 17, 30, 23, 23}
{26, 26, 19, 27, 27, 27, 30, 20, 22, 21, 23, 18, 29, 18, 18, 22, 27, 19, 28, 17, 28, 23, 27, 23, 27, 19, 22}
{17, 20, 28, 25, 23, 27, 26, 17, 27, 26, 19, 16, 20, 20, 28, 23, 17, 19, 18, 29, 20, 22, 20, 29, 25, 30, 23}
{20, 29, 30, 27, 18, 29, 25, 19, 20, 28, 16, 28, 19, 29, 26, 22, 19, 18, 22, 17, 29, 29, 18, 19, 26, 28, 20}
{28, 19, 20, 27, 20, 20, 20, 17, 23, 29, 18, 20, 19, 20, 29, 23, 18, 17, 17, 18, 23, 18, 22, 29, 23, 19, 27}
```

- xij = Quantidade transportada da fábrica i para o centro consumidor j

## Execução do Código - Exemplo minimizado

1- Adicione os valores dos coefientes das funções na classe OfertaDemanda.


```bash
 final static int[][] custos = {
            {25, 20, 30},
            {30, 25, 25},
            {20, 15, 23},
    };
```

2- Adicione os valores dos coenficientes da oferta/capacidade na classe OfertaDemanda.

```bash
 final static int[] oferta = {2000, 1500, 1500};
```

3- Adicione os valores dos coenficientes da demanda  na classe OfertaDemanda.

```bash
 final static int[] demanda = {2000, 2000, 1000};
```

4- Execute a classe Main e verifique a resposta do SBF no console. 

## Demonstração

Solução Canto Noroeste: 
```bash
2000      |0	  |0	  |   Custo Total (Z): 118000
0	  |1500	  |0	  |
0	  |500	  |1000	  | 
```

_________________________________________________________________________________

Solução Canto minimo:
```bash
1500      |500	  |0	  |   Custo Total (Z): 110000
500	  |0	  |1000	  |
0	  |1500	  |0	  |
```
_________________________________________________________________________________ 


## Autores

- [@Gustavo Henrique Garcias Pedrosa]()
- [@Mariana Gonçalves de Souza]()


## Referência e fontes 

 - [Implementando o algoritmo Simplex (P.O) com python](https://www.youtube.com/watch?v=Dh-uWR5VPTU)
 - [github - tiagoadmstz](https://github.com/tiagoadmstz/simplex-example)
 - [ github - pauloEzequiel (Código Fonte)](https://github.com/pauloEzequiel/ProgramacaoLinear)
 - [chatgpt - Link Conversa](https://chat.openai.com/share/fcaaee2d-3628-4c64-862b-eb26849667c3)

