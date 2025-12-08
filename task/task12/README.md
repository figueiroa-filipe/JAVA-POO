# 🚀 Nível 2 - POO Avançada

## Introdução

Bem-vindo ao **Nível 2**! Aqui você aprofundará seus conhecimentos em Programação Orientada a Objetos, aprendendo conceitos avançados que tornarão seu código mais flexível, extensível e profissional.

---

## 🔄 Sobrecarga de Métodos (Method Overloading)

### O que é Sobrecarga?

**Sobrecarga de métodos** é a capacidade de ter múltiplos métodos com o mesmo nome, mas com assinaturas diferentes (número, tipo ou ordem de parâmetros). É uma forma de **polimorfismo em tempo de compilação**.

### Como funciona?

O compilador Java determina qual método chamar com base nos argumentos fornecidos.

### Exemplo Prático

```java
public class Calculadora {
    
    // Soma de dois inteiros
    public int somar(int a, int b) {
        return a + b;
    }
    
    // Soma de três inteiros
    public int somar(int a, int b, int c) {
        return a + b + c;
    }
    
    // Soma de dois doubles
    public double somar(double a, double b) {
        return a + b;
    }
    
    // Soma de array de inteiros
    public int somar(int[] numeros) {
        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        return soma;
    }
}

// Uso
Calculadora calc = new Calculadora();
System.out.println(calc.somar(5, 3));           // 8
System.out.println(calc.somar(5, 3, 2));        // 10
System.out.println(calc.somar(5.5, 3.2));       // 8.7
System.out.println(calc.somar(new int[]{1,2,3,4})); // 10
```

### Regras para Sobrecarga

✅ **Permitido:**
- Mudar o número de parâmetros
- Mudar o tipo de parâmetros
- Mudar a ordem dos parâmetros

❌ **NÃO permitido:**
- Mudar apenas o tipo de retorno
- Mudar apenas os nomes dos parâmetros

```java
// CORRETO
public int calcular(int a, int b) { }
public double calcular(double a, double b) { }

// INCORRETO - só mudou o retorno
public int processar(int x) { }
public double processar(int x) { }  // ERRO de compilação!
```

---

## 🎭 Polimorfismo (Polymorphism)

### O que é Polimorfismo?

**Polimorfismo** significa "muitas formas". É a capacidade de um objeto se comportar de diferentes maneiras dependendo do contexto. Em Java, temos dois tipos:

1. **Polimorfismo em Tempo de Compilação** (Sobrecarga)
2. **Polimorfismo em Tempo de Execução** (Sobrescrita)

### Polimorfismo em Tempo de Execução

Ocorre quando uma referência de uma classe pai aponta para um objeto de uma classe filha, e o método apropriado é chamado em tempo de execução.

```java
// Classe pai
public class Forma {
    public void desenhar() {
        System.out.println("Desenhando uma forma");
    }
    
    public double calcularArea() {
        return 0.0;
    }
}

// Classes filhas
public class Circulo extends Forma {
    private double raio;
    
    public Circulo(double raio) {
        this.raio = raio;
    }
    
    @Override
    public void desenhar() {
        System.out.println("Desenhando um círculo");
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * raio * raio;
    }
}

public class Retangulo extends Forma {
    private double largura;
    private double altura;
    
    public Retangulo(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }
    
    @Override
    public void desenhar() {
        System.out.println("Desenhando um retângulo");
    }
    
    @Override
    public double calcularArea() {
        return largura * altura;
    }
}

// Uso - Demonstrando Polimorfismo
public class Main {
    public static void main(String[] args) {
        // Referência da classe pai apontando para objetos das classes filhas
        Forma forma1 = new Circulo(5.0);
        Forma forma2 = new Retangulo(4.0, 6.0);
        Forma forma3 = new Forma();
        
        // Array polimórfico
        Forma[] formas = {forma1, forma2, forma3};
        
        for (Forma forma : formas) {
            forma.desenhar();  // Método correto é chamado em tempo de execução
            System.out.println("Área: " + forma.calcularArea());
            System.out.println();
        }
    }
}

/* Saída:
Desenhando um círculo
Área: 78.53981633974483

Desenhando um retângulo
Área: 24.0

Desenhando uma forma
Área: 0.0
*/
```

### Benefícios do Polimorfismo

- 🔄 **Flexibilidade**: Um método pode trabalhar com múltiplos tipos
- 📦 **Extensibilidade**: Fácil adicionar novos tipos sem modificar código existente
- 🧹 **Código Limpo**: Reduz duplicação e melhora organização

---

## 🎨 Abstração (Abstract Classes)

### O que é uma Classe Abstrata?

Uma **classe abstrata** é uma classe que não pode ser instanciada diretamente. Ela serve como um modelo para outras classes e pode conter:

- Métodos abstratos (sem implementação)
- Métodos concretos (com implementação)
- Atributos

### Quando usar Classes Abstratas?

Use quando você quiser:
- Definir um comportamento comum para subclasses
- Forçar subclasses a implementarem certos métodos
- Compartilhar código entre classes relacionadas

### Exemplo Prático

```java
// Classe abstrata
public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salarioBase;
    
    public Funcionario(String nome, String cpf, double salarioBase) {
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
    }
    
    // Método abstrato - deve ser implementado pelas subclasses
    public abstract double calcularSalario();
    
    // Método abstrato
    public abstract String obterCargo();
    
    // Método concreto - pode ser usado por todas as subclasses
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Cargo: " + obterCargo());
        System.out.println("Salário: R$ " + calcularSalario());
    }
    
    // Getters e setters
    public String getNome() {
        return nome;
    }
}

// Subclasse 1
public class Desenvolvedor extends Funcionario {
    private String linguagemPrincipal;
    private int horasExtras;
    
    public Desenvolvedor(String nome, String cpf, double salarioBase, 
                        String linguagem) {
        super(nome, cpf, salarioBase);
        this.linguagemPrincipal = linguagem;
        this.horasExtras = 0;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase + (horasExtras * 50.0);
    }
    
    @Override
    public String obterCargo() {
        return "Desenvolvedor " + linguagemPrincipal;
    }
    
    public void registrarHorasExtras(int horas) {
        this.horasExtras += horas;
    }
}

// Subclasse 2
public class Gerente extends Funcionario {
    private double bonus;
    private int numeroSubordinados;
    
    public Gerente(String nome, String cpf, double salarioBase, 
                   int subordinados) {
        super(nome, cpf, salarioBase);
        this.numeroSubordinados = subordinados;
        this.bonus = 0.0;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase + bonus + (numeroSubordinados * 100.0);
    }
    
    @Override
    public String obterCargo() {
        return "Gerente";
    }
    
    public void atribuirBonus(double valor) {
        this.bonus = valor;
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        // Não pode instanciar classe abstrata
        // Funcionario f = new Funcionario("João", "123", 3000); // ERRO!
        
        Desenvolvedor dev = new Desenvolvedor("Maria", "111", 5000, "Java");
        dev.registrarHorasExtras(10);
        
        Gerente gerente = new Gerente("Carlos", "222", 8000, 5);
        gerente.atribuirBonus(2000);
        
        // Polimorfismo com classe abstrata
        Funcionario[] funcionarios = {dev, gerente};
        
        for (Funcionario func : funcionarios) {
            func.exibirInformacoes();
            System.out.println("-".repeat(30));
        }
    }
}
```

---

## 🔌 Interfaces

### O que é uma Interface?

Uma **interface** é um contrato que define o que uma classe deve fazer, mas não como fazer. É uma forma de alcançar abstração total e herança múltipla em Java.

### Diferenças entre Interface e Classe Abstrata

| Característica | Interface | Classe Abstrata |
|----------------|-----------|-----------------|
| Métodos | Abstratos (até Java 7) | Abstratos e concretos |
| Atributos | `public static final` | Qualquer modificador |
| Herança | Múltipla (`implements`) | Simples (`extends`) |
| Construtor | ❌ Não possui | ✅ Possui |
| Uso | "Contrato" de comportamento | Código compartilhado |

### Exemplo Prático

```java
// Interface
public interface Pagavel {
    double calcularValorPagamento();
    void processarPagamento();
    String obterFormaPagamento();
}

// Outra interface
public interface Imprimivel {
    void imprimir();
    String gerarRelatorio();
}

// Classe que implementa múltiplas interfaces
public class Fatura implements Pagavel, Imprimivel {
    private String numero;
    private String descricao;
    private int quantidade;
    private double precoPorItem;
    
    public Fatura(String numero, String descricao, int quantidade, 
                  double precoPorItem) {
        this.numero = numero;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoPorItem = precoPorItem;
    }
    
    // Implementação de Pagavel
    @Override
    public double calcularValorPagamento() {
        return quantidade * precoPorItem;
    }
    
    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento da fatura " + numero);
        System.out.println("Valor: R$ " + calcularValorPagamento());
    }
    
    @Override
    public String obterFormaPagamento() {
        return "Fatura";
    }
    
    // Implementação de Imprimivel
    @Override
    public void imprimir() {
        System.out.println("=== FATURA ===");
        System.out.println("Número: " + numero);
        System.out.println("Descrição: " + descricao);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço unitário: R$ " + precoPorItem);
        System.out.println("Total: R$ " + calcularValorPagamento());
    }
    
    @Override
    public String gerarRelatorio() {
        return String.format("Fatura %s: R$ %.2f", numero, 
                           calcularValorPagamento());
    }
}

// Outra classe implementando as mesmas interfaces
public class Funcionario implements Pagavel, Imprimivel {
    private String nome;
    private String cpf;
    private double salario;
    
    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }
    
    @Override
    public double calcularValorPagamento() {
        return salario;
    }
    
    @Override
    public void processarPagamento() {
        System.out.println("Processando salário de " + nome);
        System.out.println("Valor: R$ " + calcularValorPagamento());
    }
    
    @Override
    public String obterFormaPagamento() {
        return "Salário";
    }
    
    @Override
    public void imprimir() {
        System.out.println("=== FUNCIONÁRIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: R$ " + salario);
    }
    
    @Override
    public String gerarRelatorio() {
        return String.format("%s - Salário: R$ %.2f", nome, salario);
    }
}

// Uso demonstrando polimorfismo com interfaces
public class Main {
    public static void main(String[] args) {
        // Array polimórfico com interface
        Pagavel[] itensPagaveis = {
            new Fatura("001", "Notebook", 2, 3000.00),
            new Funcionario("João Silva", "123", 5000.00),
            new Fatura("002", "Mouse", 10, 50.00)
        };
        
        System.out.println("=== PROCESSAMENTO DE PAGAMENTOS ===\n");
        double total = 0;
        
        for (Pagavel item : itensPagaveis) {
            item.processarPagamento();
            total += item.calcularValorPagamento();
            System.out.println();
        }
        
        System.out.println("Total a pagar: R$ " + total);
        
        System.out.println("\n=== RELATÓRIOS ===\n");
        
        // Usando outra interface
        Imprimivel[] itensImprimiveis = {
            new Fatura("001", "Notebook", 2, 3000.00),
            new Funcionario("João Silva", "123", 5000.00)
        };
        
        for (Imprimivel item : itensImprimiveis) {
            item.imprimir();
            System.out.println();
        }
    }
}
```

### Interfaces com Métodos Default (Java 8+)

A partir do Java 8, interfaces podem ter métodos com implementação padrão:

```java
public interface Notificavel {
    void enviarNotificacao(String mensagem);
    
    // Método default com implementação
    default void enviarNotificacaoUrgente(String mensagem) {
        System.out.println("🚨 URGENTE: " + mensagem);
        enviarNotificacao(mensagem);
    }
    
    // Método estático
    static void validarMensagem(String mensagem) {
        if (mensagem == null || mensagem.isEmpty()) {
            throw new IllegalArgumentException("Mensagem inválida");
        }
    }
}
```

---

## 🎯 Quando Usar Cada Conceito?

### Use **Classe Abstrata** quando:
- Você quer compartilhar código entre classes relacionadas
- As classes possuem muitos métodos/campos em comum
- Você precisa de controle de acesso (protected, private)

### Use **Interface** quando:
- Você quer definir um contrato de comportamento
- Você precisa de herança múltipla
- Classes não relacionadas devem ter o mesmo comportamento

---

## 🎓 Exercícios do Nível 2

Pratique os conceitos avançados com os exercícios disponíveis na pasta de exercícios do Nível 2!

### O que você aprenderá:

1. ✅ Implementar sobrecarga de métodos
2. ✅ Aplicar polimorfismo em situações reais
3. ✅ Criar e usar classes abstratas
4. ✅ Implementar interfaces múltiplas
5. ✅ Combinar todos os conceitos em projetos complexos
