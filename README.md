<h1>Project 1 - Java_CRUD_Example</h1>
  <p>
    <strong>About</strong><br />
    A beginner-friendly Java desktop application using <code>JOptionPane</code> to manage client data with full CRUD operations, 
    interface-based DAO pattern, input validation, and in-memory storage. Built to reinforce object-oriented principles and Java fundamentals.
  </p>
<h2>🖼️ Screenshot</h2>
  <p>A quick look at the main application panels side by side, showcasing the user interface and workflow.</p>

  ![Java CRUD Application Screenshot](https://servidor-host-imagens.vercel.app/Java_CRUD_Example.jpg)
  
<h2>📌 Features</h2>
  <ul>
    <li>Client Registration, Search, Update, and Deletion;</li>
    <li>Two DAO Implementations (<code>HashMap</code> and <code>HashSet</code>);</li>
    <li>JOptionPane UI with consistent user feedback and input validation;</li>
    <li>Reusable input prompt handlers and warnings;</li>
    <li>Uses CPF as a unique identifier;</li>
    <li>Polished UI interactions with error handling for null/empty inputs.</li>
  </ul>
<h2>🗂️ Packages Structure</h2>
  <ul>
    <li><code>br.com.eaugusto.app</code>: Entry point and UI logic (App.java);</li>
    <li><code>br.com.eaugusto.domain</code>: Contains the <code>Client</code> model class;</li>
    <li><code>br.com.eaugusto.dao</code>: DAO interface and its in-memory implementations (Map and Set).</li>
  </ul>
<h2>🧩 Class Overview</h2>
  <ul>
    <li><strong>Client</strong>: Contains all relevant personal and contact data, overrides <code>equals</code> and <code>hashCode</code> using CPF;</li>
    <li><strong>IClientDAO</strong>: Declares CRUD operations for client management;</li>
    <li><strong>ClientMapDAO</strong>: Stores clients using a <code>HashMap</code> with CPF as key;</li>
    <li><strong>ClientSetDAO</strong>: Stores clients using a <code>HashSet</code>, relying on object equality;</li>
    <li><strong>App</strong>: Handles user interaction and flow via <code>JOptionPane</code>, with a looped dashboard menu and input validation.</li>
  </ul>
<h2>🚀 How to Run</h2>
  <ol>
    <li>Ensure you have Java 15 or newer installed (for Java Text Blocks);</li>
    <li>Clone the repository and open the project in your preferred IDE (e.g. Spring Tools Suite, Eclipse, IntelliJ);</li>
    <li>Run <code>App.java</code> from the <code>br.com.eaugusto.app</code> package;</li>
    <li>Use the menu to register, search, update or delete client records.</li>
  </ol>
<h2>📅 Commit Highlights</h2>
  <h3>May 23, 2025</h3>
  <ul>
    <li>Added Modify And Delete Functions To CRUD App;</li>
    <li>Reorganized <code>App.java</code> and added reusable prompt methods.</li>
    <li>Prevented Crashes When No Input Is Provided Through Input Validation.</li>
  </ul>
  <h3>May 22, 2025</h3>
  <ul>
    <li>Implemented advanced validation for missing fields;</li>
    <li>Used Java Text Blocks for cleaner code and clearer error messages.</li>
  </ul>
  <h3>May 21, 2025</h3>
  <ul>
    <li>Added full app logic and <code>toString</code> overrides;</li>
    <li>Integrated <code>JOptionPane</code> UI flow with option validation.</li>
  </ul>
  <h3>May 20, 2025</h3>
  <ul>
    <li>Created DAO interface and in-memory implementations with <code>HashMap</code> and <code>HashSet</code>;</li>
    <li>Developed the <code>Client</code> class and defined the data structure.</li>
  </ul>
<h2>📌 Requirements</h2>
  <ul>
    <li>Java 15+ (for text blocks and enhanced syntax);</li>
    <li>No external libraries required (pure Java).</li>
  </ul>
<h2>📚 Learning Goals</h2>
  <ul>
    <li>Practice Java object-oriented programming;</li>
    <li>Learn how to implement interfaces and in-memory data storage;</li>
    <li>Understand how to build simple desktop applications with <code>JOptionPane</code>;</li>
    <li>Write readable, maintainable, and validated code.</li>
  </ul>
<h3>🔗 Related Projects</h3>
  <p>This project was developed using Spring Tools Suite 4 (STS4) with a focus on <code>JOptionPane</code> dialogs for the user interface.</p>
  <p>If you are interested, there is a related CRUD project developed in Apache NetBeans, which uses <strong>Swing</strong> for the GUI instead. Both projects share similar functionality but explore different Java desktop UI technologies and development environments.</p>
  <p>Check out the related repository here:<br>
  <a href="https://github.com/AsrielDreemurrGM/Java_CRUD_Example_Apache" target="_blank" rel="noopener noreferrer">Java_CRUD_Example_Apache</a></p>
