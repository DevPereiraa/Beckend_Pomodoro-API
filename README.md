## Timer Pomodoro API

Esta API foi desenvolvida para gerenciar sessões do Timer Pomodoro, permitindo iniciar sessões, registrar pomodoros concluídos e recuperar o histórico de sessões.

### 🚀 Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Spring Web** (para criação da API REST)
- **Spring Data JPA** (para persistência de dados)
- **H2 Database** (banco de dados em memória para testes)
- **Lombok** (para reduzir código boilerplate)

---

## 📌 Instalação e Execução
### 1️⃣ Clone o repositório:
```bash
 git clone https://github.com/seu-usuario/timer-pomodoro-api.git
 cd timer-pomodoro-api
```

### 2️⃣ Configure o ambiente:
O projeto usa um banco de dados em memória (H2), então não há necessidade de configurações adicionais.

### 3️⃣ Compile e execute:
```bash
 mvn spring-boot:run
```
A API será executada em `http://localhost:8080/api/pomodoro`

---

## 📚 Endpoints da API

### 🔹 Iniciar uma nova sessão
```http
POST /api/pomodoro/start?totalPomodoros={quantidade}
```
- **Descrição**: Inicia uma nova sessão de pomodoro.
- **Parâmetro**: `totalPomodoros` (Número total de pomodoros da sessão).
- **Resposta**:
```json
{
    "id": 1,
    "totalPomodoros": 4,
    "completedPomodoros": 0,
    "startTime": "2025-03-01T12:00:00"
}
```

---

### 🔹 Registrar um pomodoro concluído
```http
POST /api/pomodoro/complete/{sessionId}
```
- **Descrição**: Marca um pomodoro como concluído dentro de uma sessão ativa.
- **Parâmetro**: `sessionId` (ID da sessão).
- **Resposta**:
```json
{
    "id": 1,
    "totalPomodoros": 4,
    "completedPomodoros": 1,
    "startTime": "2025-03-01T12:00:00",
    "endTime": null
}
```

---

### 🔹 Listar todas as sessões
```http
GET /api/pomodoro/sessions
```
- **Descrição**: Retorna todas as sessões registradas no sistema.
- **Resposta**:
```json
[
    {
        "id": 1,
        "totalPomodoros": 4,
        "completedPomodoros": 3,
        "startTime": "2025-03-01T12:00:00",
        "endTime": "2025-03-01T14:00:00"
    }
]
```

---

## 🏗️ Estrutura do Projeto
```
📂 src
 ┣ 📂 main
 ┃ ┣ 📂 java/com/example/pomodoro
 ┃ ┃ ┣ 📄 PomodoroApplication.java  # Classe principal
 ┃ ┃ ┣ 📂 controller
 ┃ ┃ ┃ ┗ 📄 PomodoroController.java  # Controlador da API
 ┃ ┃ ┣ 📂 service
 ┃ ┃ ┃ ┗ 📄 PomodoroService.java  # Regras de negócio
 ┃ ┃ ┣ 📂 model
 ┃ ┃ ┃ ┗ 📄 PomodoroSession.java  # Modelo da entidade
 ┃ ┃ ┣ 📂 repository
 ┃ ┃ ┃ ┗ 📄 PomodoroRepository.java  # Interface para acesso ao banco de dados
 ┃ ┣ 📂 resources
 ┃ ┃ ┗ 📄 application.properties  # Configurações da aplicação
```

---

## 🔥 Testando a API
Para testar os endpoints, você pode usar o **Postman** ou o seguinte comando no terminal:

### 🔹 Criar uma sessão com 4 pomodoros:
```bash
curl -X POST "http://localhost:8080/api/pomodoro/start?totalPomodoros=4"
```

### 🔹 Completar um pomodoro:
```bash
curl -X POST "http://localhost:8080/api/pomodoro/complete/1"
```

### 🔹 Listar todas as sessões:
```bash
curl -X GET "http://localhost:8080/api/pomodoro/sessions"
```

---
## 📜 Licença

MIT License

Copyright (c) 2025 Gustavo Pereira

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
---
