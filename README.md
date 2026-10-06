# POAO

Repositório de exercícios práticos em Java, organizados por fichas. Os exemplos exploram fundamentos de programação e conceitos introdutórios de programação orientada a objetos, usando situações relacionadas com comboios, passageiros, estações e combustíveis.

## Conteúdo

- **Ficha 01** — cálculos e duração de viagens, controlo de falhas em carruagens e validação de dados de estudantes.
- **Ficha 02** — vetores e matrizes, análise de velocidades, organização de lugares e distribuição de candidatos por vagas.
- **Ficha 03** — manipulação e validação de texto, códigos de comboios e troços, e criação de avisos de viagem.
- **Ficha 04** — classes e objetos, encapsulamento, comboios e estações, e cálculo de custos e comparação de postos de combustível.

## Requisitos

- JDK instalado (inclui `javac` e `java`).

## Executar um exercício

Cada exercício pode ser compilado e executado separadamente a partir da raiz do repositório. Por exemplo:

```bash
javac Ficha_01/Exercicio_01.java
java -cp Ficha_01 Exercicio_01
```

Alguns exercícios pedem valores na consola. Como várias fichas reutilizam nomes de classes como `Exercicio_01`, compile apenas o exercício que pretende executar.

O exercício de combustíveis está num pacote Java e pode ser compilado assim:

```bash
javac -d out Ficha_04/Exercicio_03/*.java
java -cp out Exercicio_03.AppCombustiveis
```