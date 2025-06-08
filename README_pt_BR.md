<h1>Projeto 1 - Java_CRUD_Example</h1>
 📄 README In English:
 
- [English Version](README.md)

<p>
  <strong>Sobre o Projeto</strong><br />
  Aplicação desktop em Java utilizando <code>JOptionPane</code> para gerenciar dados de clientes e produtos com operações CRUD completas, 
  padrão DAO baseado em interfaces, validação de entrada e armazenamento em memória. 
  O projeto também utiliza <strong>Generics</strong> nas implementações de DAO, permitindo um código mais flexível e reutilizável.
  Foi meu primeiro projeto em Java, desenvolvido em paralelo a uma aplicação CRUD semelhante com Swing no Apache NetBeans.
</p>

<h2>🖼️ Screenshot</h2>
<p>Uma visão rápida dos painéis principais da aplicação, exibindo a interface de usuário e o fluxo de navegação.</p>

![Java CRUD Application Screenshot](https://servidor-host-imagens.vercel.app/Java_CRUD_Example.jpg)

<h2>📌 Funcionalidades</h2>
<ul>
  <li>Cadastro, busca, atualização e exclusão de clientes e produtos;</li>
  <li>Duas implementações DAO (<code>HashMap</code> e <code>HashSet</code>), com uso de <strong>Generics</strong> para maior flexibilidade;</li>
  <li>Interface com <code>JOptionPane</code>, com feedback consistente e validação de entrada;</li>
  <li>Reutilização de métodos auxiliares para prompts e validações;</li>
  <li>Utilização do CPF (para clientes) e código do produto (para produtos) como identificadores únicos;</li>
  <li>Interações de UI aprimoradas, com tratamento de erros e entradas nulas/vazias.</li>
</ul>
<h2>🗂️ Estrutura de Pacotes</h2>
<ul>
  <li><code>br.com.eaugusto.app</code>: Ponto de entrada da aplicação e lógica da interface (App.java);</li>
  <li><code>br.com.eaugusto.domain</code>: Modelos de domínio: <code>Client</code> e <code>Product</code>;</li>
  <li><code>br.com.eaugusto.dao</code>: Interface DAO e suas implementações em memória (Map e Set);</li>
  <li><code>br.com.eaugusto.dao.generic</code>: Implementações DAO genéricas baseadas em <strong>Generics</strong>;</li>
  <li><code>br.com.eaugusto.ui</code>: Classes auxiliares para prompts e navegação de menu.</li>
</ul>
<h2>🧩 Visão Geral das Classes</h2>
<ul>
  <li><strong>Client</strong>: Contém os dados pessoais e de contato, sobrescreve <code>equals</code> e <code>hashCode</code> com base no CPF;</li>
  <li><strong>Product</strong>: Modelo de produto com código imutável e propriedades editáveis, sobrescreve <code>equals</code> e <code>hashCode</code> com base no código do produto;</li>
  <li><strong>IClientDAO</strong> / <strong>IProductDAO</strong>: Interfaces DAO que declaram as operações CRUD para clientes e produtos;</li>
  <li><strong>ClientMapDAO</strong> / <strong>ProductMapDAO</strong>: Implementações de DAO com <code>HashMap</code>;</li>
  <li><strong>ClientSetDAO</strong> / <strong>ProductSetDAO</strong>: Implementações de DAO com <code>HashSet</code>;</li>
  <li><strong>GenericMapDAO</strong> / <strong>GenericSetDAO</strong>: Implementações genéricas de DAO usando Generics;</li>
  <li><strong>App</strong>: Controla o fluxo da aplicação e a interação com o usuário via <code>JOptionPane</code>;</li>
  <li><strong>PromptHelper</strong> / <strong>MenuHelper</strong>: Auxiliam na criação de prompts e menus, centralizando a lógica de interface.</li>
</ul>
<h2>🚀 Como Executar</h2>
<ol>
  <li>Certifique-se de ter o Java 15 ou superior instalado (requerido pelo uso de Text Blocks);</li>
  <li>Clique no botão <code>Clone</code> e abra o projeto na sua IDE preferida (ex.: Spring Tools Suite, Eclipse, IntelliJ);</li>
  <li>Execute a classe <code>App.java</code> no pacote <code>br.com.eaugusto.app</code>;</li>
  <li>Utilize o menu principal para gerenciar registros de clientes e produtos.</li>
</ol>
<h2>📅 Principais Commits</h2>
<h3>Junho 2025</h3>
<ul>
  <li>Adição do suporte completo a produtos na aplicação;</li>
  <li>Refatoração das implementações DAO para simplificar o armazenamento e utilizar Generics;</li>
  <li>Criação de DAO baseado em Set para clientes e produtos;</li>
  <li>Refatoração da lógica de menu e prompts para melhorar a legibilidade e manutenibilidade;</li>
  <li>Adição de documentação (Javadoc) em todas as classes e métodos relevantes.</li>
</ul>
<h3>Maio 2025</h3>
<ul>
  <li>Implementação inicial da aplicação CRUD com clientes;</li>
  <li>Estruturação do padrão DAO e criação dos modelos de domínio;</li>
  <li>Validação aprimorada de entradas e melhorias na interface com o usuário.</li>
</ul>
<h2>📌 Requisitos</h2>
<ul>
  <li>Java 15+ (uso de Text Blocks e sintaxe aprimorada);</li>
  <li>Sem dependências externas, aplicação feita em Java puro.</li>
</ul>
<h2>📚 Objetivos de Aprendizado</h2>
<ul>
  <li>Praticar a programação orientada a objetos com Java;</li>
  <li>Aprender a implementar interfaces e padrões de armazenamento em memória;</li>
  <li>Construir aplicações desktop simples com <code>JOptionPane</code>;</li>
  <li>Utilizar <strong>Generics</strong> para criar implementações DAO reutilizáveis e flexíveis;</li>
  <li>Escrever código legível, manutenível e seguro.</li>
</ul>
<h3>🔗 Projetos Relacionados</h3>
<p>Este projeto foi desenvolvido com o Spring Tools Suite 4 (STS4), com foco em diálogos via <code>JOptionPane</code> para a interface do usuário.</p>
<p>Existe também um projeto CRUD relacionado, desenvolvido no Apache NetBeans, utilizando <strong>Swing</strong> para a interface gráfica. Ambos compartilham funcionalidades semelhantes, mas exploram diferentes tecnologias de UI no ecossistema Java desktop.</p>
<p>Confira o repositório relacionado:<br>
<a href="https://github.com/AsrielDreemurrGM/Java_CRUD_Example_Apache" target="_blank" rel="noopener noreferrer">Java_CRUD_Example_Apache</a>
</p>
