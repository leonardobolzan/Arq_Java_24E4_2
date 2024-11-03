# Arq_Java_24E4_2
Projeto desenvolvido para a disciplina de Java, no curso de pós-graduação em Arquitetura de Software pelo Instituto Infnet.

## Definição das entidades

### Partida
- Entidade principal da aplicação.
- Responsável por fazer o controle e gestão de uma partida de futebol.

### Time
- Entidade que representa um time de futebol.
- Permite definir atributos como nome, sigla e lista de jogadores.

### Jogador
- Entidade que representa um jogador de futebol.
- Essa entidade estende a classe "Pessoa".

### Narrador
- Entidade que representa um narrador de transmissão de jogos esportivos.
- Essa entidade estende a classe "Pessoa".

### Pessoa
- Classe abstrata que representa uma pessoa.
- Possui atributos gerais de uma pessoa do mundo real, como nome e idade.
- Essa classe é estendida por classes derivadas como "Jogador" e "Narrador".

### Canal
- Entidade que representa um canal de transmissão de jogos.
- Permite associar um narrador ao canal.

### Estatisticas
- Entidade que agrupa as estatísticas de uma partida de futebol, como chutes a gol e posse de bola.
- São utilizadas na classe principal "Partida", associando estatísticas ao time da casa e ao time visitante.
