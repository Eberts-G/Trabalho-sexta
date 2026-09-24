-- Apaga as tabelas antigas caso já existam (na ordem correta por causa das chaves estrangeiras)
DROP TABLE IF EXISTS tb_vendas CASCADE;
DROP TABLE IF EXISTS tb_produtos CASCADE;
DROP TABLE IF EXISTS tb_clientes CASCADE;
DROP TABLE IF EXISTS tb_usuarios CASCADE;

-- 1. Tabela de Usuários (Login)
CREATE TABLE tb_usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(50) NOT NULL,
    cargo VARCHAR(50) NOT NULL
);

-- 2. Tabela de Clientes
CREATE TABLE tb_clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100),
    telefone VARCHAR(20)
);

-- 3. Tabela de Produtos
CREATE TABLE tb_produtos (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(100) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    qtd_estoque INT NOT NULL,
    categoria VARCHAR(50)
);

-- 4. Tabela de Vendas
CREATE TABLE tb_vendas (
    id SERIAL PRIMARY KEY,
    cliente_id INT NOT NULL,
    data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_venda NUMERIC(10, 2) NOT NULL,
    observacoes TEXT,
    CONSTRAINT fk_venda_cliente FOREIGN KEY (cliente_id) REFERENCES tb_clientes(id)
);

-- 5. Inserir Usuário Administrador Inicial
INSERT INTO tb_usuarios (nome, login, senha, cargo) 
VALUES ('Administrador', 'postgres', 'altf4', 'Gerente');