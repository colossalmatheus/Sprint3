
# Estoque Fácil

## Equipe

- **Enzo Oliveira** (Desenvolvedor FullStack | Data Scientist) - RM 551356
- **João Vitor** (Desenvolvedor FullStack) - RM 550381
- **Pedro** (Analista de Projetos) - RM 551446
- **Matheus Colossal** (Desenvolvedor FullStack | Java) - RM 99572
- **Igor** (DBA) - RM 550415

## Como Rodar a Aplicação

### 1. Configuração do Ambiente de Desenvolvimento
- Certifique-se de ter o Java Development Kit (JDK) instalado na sua máquina.

### 2. Configuração do Projeto
- Clone o repositório do projeto ou crie um novo projeto Spring Boot usando uma IDE como IntelliJ IDEA, Eclipse ou Spring Tool Suite.
- Configure as dependências e propriedades do projeto, incluindo a configuração do banco de dados no arquivo `application-homologacao.yml`.

### 3. Configuração do Banco de Dados
- Certifique-se de que o banco de dados esteja configurado e em execução.
- Ajuste as credenciais e a URL do banco de dados no arquivo `application-homologacao.yml`.

### 4. Criando e Executando com Docker
- **Crie a imagem Docker:**
  ```bash
  docker build -t condo-facil .
  ```
- **Execute o container para testar:**
  ```bash
  docker run -p 8080:8080 condo-facil
  ```
- **Criar imagem para o Docker Hub:**
  ```bash
  docker build -t natevitor/condo-facil:1.0
  ```
- **Enviar a imagem para o Docker Hub:**
  ```bash
  docker push natevitor/condo-facil:1.0
  ```

### 5. Deploy no Azure
- Crie um WebApp no Azure com a opção de container.
- Utilize a imagem criada no Docker Hub.
- Aguarde a conclusão do deploy.

### 6. Execução Local da Aplicação
- Execute a aplicação Spring Boot localmente usando a IDE ou a linha de comando.

### 7. Teste
- Acesse a aplicação via navegador ou use ferramentas como o Postman para testar os endpoints.

## Endpoints

### Condomínio

- `/index` — Lista os condomínios.
- `/inserir_form` — Exibe o formulário de inserção de um novo condomínio.
- `/atualiza_condominio/{id}` — Atualiza as informações de um condomínio pelo ID.

### Unidade

- `{id}/unidade` — Lista as unidades de um condomínio específico.
- `{id}/inserir_unidade` — Exibe o formulário de inserção de uma nova unidade.
- `/atualiza_unidade/{id}` — Atualiza as informações de uma unidade pelo ID.

## Vídeo no YouTube

[Assista ao vídeo no YouTube](https://www.youtube.com/watch?v=ltjadLAPTAg)
