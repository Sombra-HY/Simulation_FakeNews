
<h1>Simulador de Fake News</h1>
<h2>Recursos</h2>
    <ul>
        <li>O simulador é baseado em uma grade de mundo composta por uma matriz de 30 linhas por 60 colunas.</li>
        <li>A grade de mundo é cíclica, o que significa que objetos móveis reaparecem no lado oposto quando atingem as bordas.</li>
        <li>Cada pessoa se move aleatoriamente dentro da grade de mundo, com quatro movimentos possíveis: para cima, para baixo, para a esquerda e para a direita, todos com um tamanho de passo de 1.</li>
        <li>Quando duas pessoas entram em contato, elas trocam informações de contato (números de WhatsApp) e se tornam conhecidas uma da outra.</li>
        <li>O contato ocorre quando duas pessoas ocupam o mesmo quadrado ou estão em quadrados adjacentes (acima, abaixo, esquerda ou direita).</li>
        <li>Quando uma pessoa entra em contato com a IA que dissemina fake news, ela recebe e espalha as fake news para todos os seus contatos, tornando todo o grupo "desinformado".</li>
        <li>Quando uma pessoa entra em contato com a IA que desmente fake news, ela remove as fake news de todos os seus contatos, inclusive dela mesma, tornando todo o grupo "bem informado".</li>
        <li>Uma pessoa que entra em contato com o veículo de comunicação confiável não recebe fake news por 30 segundos.</li>
        <li>Diferentes tipos de pessoas são representados por cores diferentes na simulação: pessoas sem fake news, pessoas com fake news e pessoas resistentes a fake news.</li>
    </ul>

<h2>Implementação</h2>
    <p>O projeto segue o diagrama de classes fornecido e utiliza uma grade de mundo com objetos móveis. A simulação é executada por meio da interface do console, exibindo a grade de mundo e informações relevantes sobre a disseminação de fake news.</p>

   <h2>Uso</h2>
   <p>Para executar o simulador, compile e execute o código Java no Netbeans IDE. A interface do console exibirá a grade de mundo simulada e informações sobre a propagação de fake news.</p>

   <p>Observação: Para criar uma grade de mundo colorida no console, são utilizados códigos de escape ANSI.</p>

   <h2>Créditos</h2>
   <p>Este projeto foi desenvolvido como um exercício de simulação para entender os efeitos da disseminação de fake news em um ambiente controlado.</p>

   <p>Para mais detalhes, consulte os arquivos de código-fonte em Java.</p>

