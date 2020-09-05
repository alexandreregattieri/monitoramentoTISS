# monitoramentoTISS
Projeto de geração de arquivos de Monitoramento TISS, versão "1.00.00", com dados obtidos através de XLS ou BD.

Observações:
1) Foram omitidos os dados das consultas SQL feito na base de dados, por uma questão de segurança e de tratar-se de uma produção específica para cada BD;

2) A classe "Principal" localizada no pacote "principal" inicializa o programa de geração do arquivo de Monitoramento TISS;

3) Na classe "Principal", caso a variável "caminho" esteja preenchida (ou seja, diferente de nulo) o sistema gera o arquivo de Monitotamento TISS a partir dos dados contantes no arquivo XLS (especificado na variável "caminho");

4) Na classe "Principal", caso a variável "caminho" não esteja preenchida (ou seja, igual a nulo) o sistema gera o arquivo de Monitotamento TISS a partir de consultas ao BD.
