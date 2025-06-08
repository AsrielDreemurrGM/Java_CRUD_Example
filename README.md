<h1>Project 1 - Java_CRUD_Example</h1>
 📄 README Em PT-BR:

- [Versão em Português](README_pt_BR.md)

<p>
    <strong>About</strong><br />
    Java desktop application using <code>JOptionPane</code> to manage client and product data with full CRUD operations, 
    interface-based DAO pattern, input validation, and in-memory storage (Map or Set). Built to reinforce object-oriented principles, generics, and Java fundamentals.<br />
    Includes a refactored and modular architecture with reusable components and polished UI interactions.
</p>
<h2>🖼️ Screenshot</h2>
  <p>A quick look at the main application panels side by side, showcasing the user interface and workflow.</p>

  ![Java CRUD Application Screenshot](https://servidor-host-imagens.vercel.app/Java_CRUD_Example.jpg)
  
<h2>📌 Features</h2>
  <ul>
    <li>Client and Product Registration, Search, Update, and Deletion;</li>
    <li>Two DAO Implementations (Map and Set) with a runtime toggle;</li>
    <li>JOptionPane UI with consistent user feedback and input validation;</li>
    <li>Reusable prompt and menu helpers for user interaction;</li>
    <li>Clients use CPF as a unique identifier; Products use immutable product codes;</li>
    <li>Generics-based DAO design for scalable entity management;</li>
    <li>Extensive JavaDocs for all classes and methods.</li>
  </ul>
<h2>🗂️ Packages Structure</h2>
  <ul>
    <li><code>br.com.eaugusto.app</code>: Entry point and UI logic (<code>App.java</code>);</li>
    <li><code>br.com.eaugusto.domain</code>: Contains <code>Client</code> and <code>Product</code> model classes and <code>Persistable</code> interface;</li>
    <li><code>br.com.eaugusto.dao</code>: DAO interfaces and concrete implementations for both <code>Map</code> and <code>Set</code> storage (Client and Product);</li>
    <li><code>br.com.eaugusto.dao.generic</code>: Generic DAO base classes for reusable persistence logic;</li>
    <li><code>br.com.eaugusto.ui</code>: Helper classes for prompts and menu handling (<code>PromptHelper</code>, <code>MenuHelper</code>).</li>
  </ul>
<h2>🧩 Class Overview</h2>
  <ul>
    <li><strong>Client</strong>: Contains personal and contact data, overrides <code>equals</code> and <code>hashCode</code> based on CPF;</li>
    <li><strong>Product</strong>: Contains product data with immutable product code and mutable properties, overrides <code>equals</code> and <code>hashCode</code> based on product code;</li>
    <li><strong>Persistable</strong>: Common interface for entities with <code>getCodeOrCPF()</code> method to standardize DAO handling;</li>
    <li><strong>IGenericDAO&lt;T&gt;</strong>: Generic DAO interface with CRUD operations;</li>
    <li><strong>GenericMapDAO</strong> / <strong>GenericSetDAO</strong>: Generic implementations for <code>Map</code> and <code>Set</code>-based persistence;</li>
    <li><strong>IClientDAO</strong> / <strong>ClientMapDAO</strong> / <strong>ClientSetDAO</strong>: Client-specific DAO implementations;</li>
    <li><strong>IProductDAO</strong> / <strong>ProductMapDAO</strong> / <strong>ProductSetDAO</strong>: Product-specific DAO implementations;</li>
    <li><strong>PromptHelper</strong>: Centralizes reusable input and output prompts and messages;</li>
    <li><strong>MenuHelper</strong>: Manages menu display, option validation, and flow handling;</li>
    <li><strong>App</strong>: Main application class with a runtime menu for choosing entity type and performing CRUD operations.</li>
  </ul>
<h2>🚀 How to Run</h2>
  <ol>
    <li>Ensure you have Java 15 or newer installed (for Java Text Blocks);</li>
    <li>Clone the repository and open the project in your preferred IDE (e.g. Spring Tools Suite, Eclipse, IntelliJ);</li>
    <li>Run <code>App.java</code> from the <code>br.com.eaugusto.app</code> package;</li>
    <li>Use the menu to select Client or Product management, and perform CRUD operations.</li>
  </ol>
<h2>📅 Commit Highlights</h2>
  <h3>June 6, 2025</h3>
  <ul>
    <li>Created <code>ProductSetDAO</code> implementation;</li>
    <li>Improved <code>App.java</code> to support dynamic DAO switching (Map/Set) via <code>USEMAP</code> flag;</li>
    <li>Added JavaDocs to all files in <code>br.com.eaugusto.dao</code> and <code>br.com.eaugusto.dao.generic</code> packages;</li>
    <li>Refactored DAOs to simplify storage logic and improve readability;</li>
    <li>ClientSetDAO refactored to leverage GenericSetDAO correctly.</li>
  </ul>
  <h3>June 5, 2025</h3>
  <ul>
    <li>Added JavaDocs to domain classes (<code>Client</code> and <code>Product</code>);</li>
    <li>Added JavaDocs to helper classes (<code>PromptHelper</code> and <code>MenuHelper</code>).</li>
  </ul>
  <h3>June 4, 2025</h3>
  <ul>
    <li>Refactored App <code>main()</code> method to reduce cognitive complexity and improve readability;</li>
    <li>Moved menu logic into <code>MenuHelper</code>;</li>
    <li>Moved prompt methods into <code>PromptHelper</code>;</li>
    <li>Fixed critical input handling bugs and improved robustness.</li>
  </ul>
  <h3>June 3, 2025</h3>
  <ul>
    <li>Implemented full product support with CRUD operations;</li>
    <li>Refactored DAO structure to support generics and simplify code reuse (<code>GenericDAO</code>, <code>IGenericDAO</code>);</li>
    <li>Introduced <code>Persistable</code> interface for unified DAO key access strategy.</li>
  </ul>
  <h3>Earlier Commits (May 20-24, 2025)</h3>
  <ul>
    <li>Initial implementation of client CRUD operations with both Map and Set DAOs;</li>
    <li>Added screenshot and created initial README version.</li>
  </ul>
<h2>📌 Requirements</h2>
  <ul>
    <li>Java 15+ (for text blocks and enhanced syntax);</li>
    <li>No external libraries required (pure Java).</li>
  </ul>
<h2>📚 Learning Goals</h2>
  <ul>
    <li>Practice Java object-oriented programming and generics;</li>
    <li>Learn how to implement scalable DAO patterns with Map and Set storage;</li>
    <li>Understand how to build simple desktop applications with <code>JOptionPane</code>;</li>
    <li>Write maintainable and reusable Java code with clean architecture and proper validation.</li>
  </ul>
<h3>🔗 Related Projects</h3>
  <p>This project was developed using Spring Tools Suite 4 (STS4) with a focus on <code>JOptionPane</code> dialogs for the user interface.</p>
  <p>If you are interested, there is a related CRUD project developed in Apache NetBeans, which uses <strong>Swing</strong> for the GUI instead. Both projects share similar functionality but explore different Java desktop UI technologies and development environments.</p>
  <p>Check out the related repository here:<br>
  <a href="https://github.com/AsrielDreemurrGM/Java_CRUD_Example_Apache" target="_blank" rel="noopener noreferrer">Java_CRUD_Example_Apache</a>
  </p>
