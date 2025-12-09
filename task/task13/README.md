# 🎯 Nível 3 - Interfaces e Herança Múltipla
---
## 🔍 Comparação entre Interfaces e Classes Abstratas

### Quando usar cada uma?

Entender a diferença entre interfaces e classes abstratas é fundamental para criar bom design de software.

### Tabela Comparativa Completa

| Aspecto | Interface | Classe Abstrata |
|---------|-----------|-----------------|
| **Palavra-chave** | `interface` | `abstract class` |
| **Herança** | Múltipla (`implements`) | Simples (`extends`) |
| **Métodos** | Abstratos por padrão (até Java 7) | Abstratos e concretos |
| **Métodos default** | ✅ Sim (Java 8+) | ✅ Sim |
| **Métodos static** | ✅ Sim (Java 8+) | ✅ Sim |
| **Atributos** | `public static final` (constantes) | Qualquer tipo |
| **Construtor** | ❌ Não possui | ✅ Possui |
| **Modificadores de acesso** | `public` apenas | `public`, `protected`, `private` |
| **Implementação** | Apenas assinatura (até Java 7) | Implementação completa possível |
| **Propósito** | Contrato de comportamento | Código compartilhado |
| **Relacionamento** | "pode fazer" (can-do) | "é um" (is-a) |

### Exemplo Comparativo

```java
// INTERFACE - Define "o que" fazer
public interface Voador {
    void voar();
    void pousar();
    
    // Constante (implicitamente public static final)
    int ALTITUDE_MAXIMA = 10000;
    
    // Método default (Java 8+)
    default void decolar() {
        System.out.println("Preparando para decolagem...");
        voar();
    }
}

// CLASSE ABSTRATA - Define "o que" e "como" fazer
public abstract class Animal {
    // Atributos com diferentes modificadores
    protected String nome;
    private int idade;
    
    // Construtor
    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    // Método abstrato - deve ser implementado
    public abstract void emitirSom();
    
    // Método concreto - já implementado
    public void dormir() {
        System.out.println(nome + " está dormindo");
    }
    
    // Getters
    public int getIdade() {
        return idade;
    }
}

// Classe usando AMBOS
public class Passaro extends Animal implements Voador {
    private String especie;
    
    public Passaro(String nome, int idade, String especie) {
        super(nome, idade);
        this.especie = especie;
    }
    
    // Implementação da classe abstrata
    @Override
    public void emitirSom() {
        System.out.println(nome + " está cantando: piu piu!");
    }
    
    // Implementação da interface
    @Override
    public void voar() {
        System.out.println(nome + " está voando alto!");
    }
    
    @Override
    public void pousar() {
        System.out.println(nome + " está pousando suavemente");
    }
}
```

### Diretrizes de Uso

#### ✅ Use **Interface** quando:

1. Você quer definir um **contrato** que diferentes classes podem implementar
2. Precisa de **herança múltipla** de comportamento
3. Classes não relacionadas devem ter o mesmo comportamento
4. Quer definir **capacidades** (Voador, Nadador, Comparável)

**Exemplo de uso correto:**
```java
// Diferentes classes podem ser "Comparáveis"
public interface Comparavel<T> {
    int comparar(T outro);
}

public class Produto implements Comparavel<Produto> {
    private double preco;
    
    @Override
    public int comparar(Produto outro) {
        return Double.compare(this.preco, outro.preco);
    }
}

public class Pessoa implements Comparavel<Pessoa> {
    private int idade;
    
    @Override
    public int comparar(Pessoa outra) {
        return Integer.compare(this.idade, outra.idade);
    }
}
```

#### ✅ Use **Classe Abstrata** quando:

1. Você quer **compartilhar código** entre classes relacionadas
2. As classes têm muitos **atributos/métodos em comum**
3. Precisa de **controle de acesso** (protected, private)
4. Quer fornecer **implementação padrão** que subclasses podem sobrescrever

**Exemplo de uso correto:**
```java
public abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected int ano;
    protected boolean ligado;
    
    public Veiculo(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.ligado = false;
    }
    
    // Método concreto compartilhado
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println(marca + " " + modelo + " ligado");
        }
    }
    
    // Método abstrato - cada veículo acelera diferente
    public abstract void acelerar();
}

public class Carro extends Veiculo {
    private int numeroPortas;
    
    public Carro(String marca, String modelo, int ano, int portas) {
        super(marca, modelo, ano);
        this.numeroPortas = portas;
    }
    
    @Override
    public void acelerar() {
        System.out.println("Carro acelerando suavemente");
    }
}
```

---

## 🔗 Implementação de Múltiplas Interfaces

Uma das grandes vantagens das interfaces em Java é a possibilidade de uma classe implementar **múltiplas interfaces**, simulando herança múltipla de comportamento.

### Sintaxe

```java
public class MinhaClasse implements Interface1, Interface2, Interface3 {
    // Implementação de todos os métodos das interfaces
}
```

### Exemplo Prático Completo

```java
// Interface 1 - Capacidade de nadar
public interface Nadador {
    void nadar();
    void mergulhar();
    
    default void flutuar() {
        System.out.println("Flutuando na água");
    }
}

// Interface 2 - Capacidade de voar
public interface Voador {
    void voar();
    void pousar();
    
    default void planar() {
        System.out.println("Planando no ar");
    }
}

// Interface 3 - Capacidade de correr
public interface Corredor {
    void correr();
    void parar();
    
    default void caminhar() {
        System.out.println("Caminhando devagar");
    }
}

// Classe que implementa múltiplas interfaces
public class Pato implements Nadador, Voador, Corredor {
    private String nome;
    
    public Pato(String nome) {
        this.nome = nome;
    }
    
    // Implementação de Nadador
    @Override
    public void nadar() {
        System.out.println(nome + " está nadando na lagoa");
    }
    
    @Override
    public void mergulhar() {
        System.out.println(nome + " mergulhou para pegar comida");
    }
    
    // Implementação de Voador
    @Override
    public void voar() {
        System.out.println(nome + " está voando para o sul");
    }
    
    @Override
    public void pousar() {
        System.out.println(nome + " pousou graciosamente");
    }
    
    // Implementação de Corredor
    @Override
    public void correr() {
        System.out.println(nome + " está correndo na grama");
    }
    
    @Override
    public void parar() {
        System.out.println(nome + " parou para descansar");
    }
}

// Uso demonstrando polimorfismo com múltiplas interfaces
public class Main {
    public static void main(String[] args) {
        Pato pato = new Pato("Donald");
        
        // Usando como Nadador
        Nadador nadador = pato;
        nadador.nadar();
        nadador.mergulhar();
        nadador.flutuar();  // Método default
        
        System.out.println();
        
        // Usando como Voador
        Voador voador = pato;
        voador.voar();
        voador.planar();    // Método default
        voador.pousar();
        
        System.out.println();
        
        // Usando como Corredor
        Corredor corredor = pato;
        corredor.caminhar(); // Método default
        corredor.correr();
        corredor.parar();
    }
}
```

### Exemplo com Sistema Real - E-commerce

```java
// Interface para produtos vendáveis
public interface Vendavel {
    double calcularPreco();
    boolean estaDisponivel();
    void vender(int quantidade);
}

// Interface para produtos que podem ser enviados
public interface Enviavel {
    double calcularFrete(String cep);
    int obterPrazoEntrega(String cep);
    String obterCodigoRastreio();
}

// Interface para produtos digitais
public interface Digital {
    String obterLinkDownload();
    long obterTamanhoArquivo();
    void enviarPorEmail(String email);
}

// Interface para produtos físicos
public interface Fisico {
    double obterPeso();
    String obterDimensoes();
    boolean precisaRefrigeracao();
}

// Produto Físico - Livro
public class Livro implements Vendavel, Enviavel, Fisico {
    private String titulo;
    private String autor;
    private double preco;
    private int estoque;
    private double peso;
    private String codigoRastreio;
    
    public Livro(String titulo, String autor, double preco, int estoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.estoque = estoque;
        this.peso = 0.5; // kg
    }
    
    // Vendavel
    @Override
    public double calcularPreco() {
        return preco;
    }
    
    @Override
    public boolean estaDisponivel() {
        return estoque > 0;
    }
    
    @Override
    public void vender(int quantidade) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
            System.out.println("Livro vendido: " + titulo);
        }
    }
    
    // Enviavel
    @Override
    public double calcularFrete(String cep) {
        return peso * 10.0; // Simulação simples
    }
    
    @Override
    public int obterPrazoEntrega(String cep) {
        return 7; // dias
    }
    
    @Override
    public String obterCodigoRastreio() {
        if (codigoRastreio == null) {
            codigoRastreio = "BR" + System.currentTimeMillis();
        }
        return codigoRastreio;
    }
    
    // Fisico
    @Override
    public double obterPeso() {
        return peso;
    }
    
    @Override
    public String obterDimensoes() {
        return "20x15x2 cm";
    }
    
    @Override
    public boolean precisaRefrigeracao() {
        return false;
    }
}

// Produto Digital - E-book
public class Ebook implements Vendavel, Digital {
    private String titulo;
    private String autor;
    private double preco;
    private String linkDownload;
    private long tamanhoMB;
    
    public Ebook(String titulo, String autor, double preco, long tamanhoMB) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.tamanhoMB = tamanhoMB;
    }
    
    // Vendavel
    @Override
    public double calcularPreco() {
        return preco * 0.7; // 30% desconto para digital
    }
    
    @Override
    public boolean estaDisponivel() {
        return true; // Sempre disponível
    }
    
    @Override
    public void vender(int quantidade) {
        System.out.println("E-book vendido: " + titulo);
        // Gera link de download
        gerarLinkDownload();
    }
    
    // Digital
    @Override
    public String obterLinkDownload() {
        return linkDownload;
    }
    
    @Override
    public long obterTamanhoArquivo() {
        return tamanhoMB;
    }
    
    @Override
    public void enviarPorEmail(String email) {
        gerarLinkDownload();
        System.out.println("E-book enviado para: " + email);
        System.out.println("Link: " + linkDownload);
    }
    
    private void gerarLinkDownload() {
        if (linkDownload == null) {
            linkDownload = "https://downloads.com/" + titulo.replace(" ", "-");
        }
    }
}

// Classe de teste
public class LojaVirtual {
    public static void main(String[] args) {
        Livro livro = new Livro("Clean Code", "Robert Martin", 89.90, 10);
        Ebook ebook = new Ebook("Clean Code", "Robert Martin", 89.90, 15);
        
        // Processando livro físico
        System.out.println("=== LIVRO FÍSICO ===");
        processarVenda(livro);
        if (livro instanceof Enviavel) {
            Enviavel enviavel = (Enviavel) livro;
            System.out.println("Frete: R$ " + enviavel.calcularFrete("01310-100"));
            System.out.println("Prazo: " + enviavel.obterPrazoEntrega("01310-100") + " dias");
            System.out.println("Rastreio: " + enviavel.obterCodigoRastreio());
        }
        
        System.out.println("\n=== E-BOOK ===");
        processarVenda(ebook);
        if (ebook instanceof Digital) {
            Digital digital = (Digital) ebook;
            digital.enviarPorEmail("cliente@email.com");
            System.out.println("Tamanho: " + digital.obterTamanhoArquivo() + " MB");
        }
    }
    
    // Método polimórfico que aceita qualquer produto vendável
    public static void processarVenda(Vendavel produto) {
        if (produto.estaDisponivel()) {
            System.out.println("Preço: R$ " + produto.calcularPreco());
            produto.vender(1);
        } else {
            System.out.println("Produto indisponível");
        }
    }
}
```

---

## 🌳 Herança Múltipla em Java

Java **não suporta herança múltipla de classes** para evitar o problema do diamante. No entanto, Java permite **herança múltipla de interfaces**.

### O Problema do Diamante

```java
// ISTO NÃO É PERMITIDO EM JAVA!
public class A {
    public void metodo() {
        System.out.println("A");
    }
}

public class B extends A {
    @Override
    public void metodo() {
        System.out.println("B");
    }
}

public class C extends A {
    @Override
    public void metodo() {
        System.out.println("C");
    }
}

// ERRO: Não pode estender duas classes
// public class D extends B, C { }  // ISSO NÃO COMPILA!
```

### Solução com Interfaces

```java
// Interface A
public interface InterfaceA {
    default void metodo() {
        System.out.println("Interface A");
    }
}

// Interface B
public interface InterfaceB {
    default void metodo() {
        System.out.println("Interface B");
    }
}

// Classe que implementa ambas - DEVE resolver o conflito
public class MinhaClasse implements InterfaceA, InterfaceB {
    
    // OBRIGATÓRIO: resolver qual método usar
    @Override
    public void metodo() {
        // Opção 1: Escolher um específico
        InterfaceA.super.metodo();
        
        // Opção 2: Implementação própria
        // System.out.println("Minha implementação");
        
        // Opção 3: Chamar ambos
        // InterfaceA.super.metodo();
        // InterfaceB.super.metodo();
    }
}
```

### Exemplo Prático - Sistema de Veículos

```java
// Interface para veículos terrestres
public interface Terrestre {
    void acelerar();
    void frear();
    
    default void dirigir() {
        System.out.println("Dirigindo na estrada");
    }
}

// Interface para veículos aquáticos
public interface Aquatico {
    void navegar();
    void ancorar();
    
    default void dirigir() {
        System.out.println("Navegando na água");
    }
}

// Veículo anfíbio - implementa múltiplas interfaces
public class VeiculoAnfibio implements Terrestre, Aquatico {
    private String modelo;
    private boolean modoAgua;
    
    public VeiculoAnfibio(String modelo) {
        this.modelo = modelo;
        this.modoAgua = false;
    }
    
    // Implementação de Terrestre
    @Override
    public void acelerar() {
        if (!modoAgua) {
            System.out.println(modelo + " acelerando na terra");
        } else {
            System.out.println(modelo + " aumentando velocidade na água");
        }
    }
    
    @Override
    public void frear() {
        System.out.println(modelo + " freando");
    }
    
    // Implementação de Aquatico
    @Override
    public void navegar() {
        modoAgua = true;
        System.out.println(modelo + " entrando na água");
    }
    
    @Override
    public void ancorar() {
        System.out.println(modelo + " ancorando");
    }
    
    // Resolve conflito do método dirigir()
    @Override
    public void dirigir() {
        if (modoAgua) {
            Aquatico.super.dirigir();
        } else {
            Terrestre.super.dirigir();
        }
    }
    
    public void alterarModo() {
        modoAgua = !modoAgua;
        System.out.println("Modo alterado para: " + (modoAgua ? "ÁGUA" : "TERRA"));
    }
}

// Teste
public class Main {
    public static void main(String[] args) {
        VeiculoAnfibio anfibio = new VeiculoAnfibio("Amphicar");
        
        // Modo terrestre
        anfibio.dirigir();
        anfibio.acelerar();
        anfibio.frear();
        
        System.out.println();
        
        // Mudando para modo aquático
        anfibio.navegar();
        anfibio.alterarModo();
        anfibio.dirigir();
        anfibio.acelerar();
        anfibio.ancorar();
    }
}
```

### Herança de Classe + Múltiplas Interfaces

O padrão mais comum em Java:

```java
// Classe abstrata base
public abstract class Funcionario {
    protected String nome;
    protected double salario;
    
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }
    
    public abstract double calcularSalario();
}

// Interfaces de capacidades
public interface Vendedor {
    void realizarVenda(double valor);
    double calcularComissao();
}

public interface Treinador {
    void treinarNovato(String nomeNovato);
    int obterHorasTreinamento();
}

// Classe que herda e implementa múltiplas interfaces
public class GerenteVendas extends Funcionario 
                           implements Vendedor, Treinador {
    private double totalVendas;
    private int horasTreinamento;
    
    public GerenteVendas(String nome, double salario) {
        super(nome, salario);
        this.totalVendas = 0;
        this.horasTreinamento = 0;
    }
    
    @Override
    public double calcularSalario() {
        return salario + calcularComissao();
    }
    
    // Vendedor
    @Override
    public void realizarVenda(double valor) {
        totalVendas += valor;
        System.out.println(nome + " realizou venda de R$ " + valor);
    }
    
    @Override
    public double calcularComissao() {
        return totalVendas * 0.05; // 5% de comissão
    }
    
    // Treinador
    @Override
    public void treinarNovato(String nomeNovato) {
        horasTreinamento += 8;
        System.out.println(nome + " treinou " + nomeNovato);
    }
    
    @Override
    public int obterHorasTreinamento() {
        return horasTreinamento;
    }
}
```

---

## 🎓 Exercícios do Nível 3

Pratique os conceitos de interfaces e herança múltipla com os exercícios disponíveis!

### O que você aprenderá:

1. ✅ Decidir entre interface e classe abstrata
2. ✅ Implementar múltiplas interfaces
3. ✅ Resolver conflitos de métodos default
4. ✅ Criar arquiteturas flexíveis com interfaces
5. ✅ Combinar herança de classe com múltiplas interfaces

---

## 💡 Boas Práticas

### Interface Segregation Principle (ISP)

Prefira **interfaces pequenas e específicas** ao invés de interfaces grandes e genéricas:

```java
// ❌ MAU - Interface muito grande
public interface Trabalhador {
    void trabalhar();
    void comer();
    void dormir();
    void receberSalario();
}

// ✅ BOM - Interfaces segregadas
public interface Trabalhador {
    void trabalhar();
}

public interface Alimentavel {
    void comer();
}

public interface Descansavel {
    void dormir();
}

public interface Assalariado {
    void receberSalario();
}
```

### Nomenclatura

- Use substantivos ou adjetivos para interfaces: `Voador`, `Comparavel`, `Serializable`
- Interfaces que representam capacidades geralmente terminam em `-vel` ou `-able`
- Use verbos para métodos: `voar()`, `comparar()`, `serializar()`
