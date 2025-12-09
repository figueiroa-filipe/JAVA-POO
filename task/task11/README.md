# 📚 Nível 1 - Fundamentos da POO

## Introdução

Bem-vindo ao **Nível 1**! Aqui você aprenderá os conceitos fundamentais da Programação Orientada a Objetos (POO), que são essenciais para escrever código organizado, reutilizável e fácil de manter.

---

## 🎯 Princípios Básicos da Programação Orientada a Objetos

### O que é POO?

A **Programação Orientada a Objetos** é um paradigma de programação que organiza o código em torno de **objetos** - entidades que representam conceitos do mundo real ou abstratos, combinando dados (atributos) e comportamentos (métodos).

### Conceito de Classe e Objeto

- **Classe**: É como uma "planta" ou "molde" que define as características (atributos) e comportamentos (métodos) que os objetos terão.
- **Objeto**: É uma instância concreta criada a partir de uma classe.

**Exemplo prático:**

```java
// Classe - o molde
public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }
    
    public void acelerar() {
        System.out.println(marca + " " + modelo + " está acelerando!");
    }
    
    public void frear() {
        System.out.println(marca + " " + modelo + " está freando!");
    }
}

// Objetos - instâncias criadas do molde
Carro meuCarro = new Carro("Toyota", "Corolla", 2023);
Carro seuCarro = new Carro("Honda", "Civic", 2024);

meuCarro.acelerar();  // Saída: Toyota Corolla está acelerando!
```

### Os Quatro Pilares da POO

#### 1. 🔒 **Encapsulamento**
Proteger os dados internos do objeto, controlando o acesso através de métodos públicos. Isso evita que dados sejam modificados de forma inadequada.

```java
public class ContaBancaria {
    private String titular;
    private double saldo;  // Atributo privado
    
    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }
    
    public double getSaldo() {
        return this.saldo;
    }
}
```

#### 2. 🧬 **Herança**
Criar novas classes baseadas em classes existentes, reutilizando código e estabelecendo relacionamentos hierárquicos.

#### 3. 🎭 **Polimorfismo**
Permitir que objetos de diferentes tipos respondam à mesma mensagem de formas diferentes.

#### 4. 🎨 **Abstração**
Simplificar a complexidade, mostrando apenas o essencial e ocultando detalhes de implementação.

---

## 🧬 Herança

### O que é Herança?

**Herança** é um mecanismo que permite criar uma nova classe (classe filha ou subclasse) baseada em uma classe existente (classe pai ou superclasse). A classe filha herda atributos e métodos da classe pai, podendo adicionar novos comportamentos ou modificar os existentes.

### Por que usar Herança?

- ♻️ **Reutilização de código**: Evita duplicação
- 📊 **Hierarquia lógica**: Organiza classes de forma natural
- 🔧 **Manutenção facilitada**: Alterações na classe pai afetam todas as filhas
- 🎯 **Especialização**: Classes filhas podem ter comportamentos específicos

### Exemplo Prático

```java
// Classe Pai (Superclasse)
public class Animal {
    protected String nome;
    protected int idade;
    
    public Animal(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public void emitirSom() {
        System.out.println("O animal está fazendo um som");
    }
    
    public void dormir() {
        System.out.println(nome + " está dormindo");
    }
}

// Classe Filha (Subclasse)
public class Cachorro extends Animal {
    private String raca;
    
    public Cachorro(String nome, int idade, String raca) {
        super(nome, idade);  // Chama o construtor da classe pai
        this.raca = raca;
    }
    
    @Override
    public void emitirSom() {
        System.out.println(nome + " está latindo: Au au!");
    }
    
    public void abanarRabo() {
        System.out.println(nome + " está abanando o rabo");
    }
}

// Outra Classe Filha
public class Gato extends Animal {
    private String cor;
    
    public Gato(String nome, int idade, String cor) {
        super(nome, idade);
        this.cor = cor;
    }
    
    @Override
    public void emitirSom() {
        System.out.println(nome + " está miando: Miau!");
    }
    
    public void arranhar() {
        System.out.println(nome + " está arranhando");
    }
}

// Uso
Cachorro dog = new Cachorro("Rex", 3, "Labrador");
dog.emitirSom();      // Rex está latindo: Au au!
dog.dormir();         // Rex está dormindo (herdado de Animal)
dog.abanarRabo();     // Rex está abanando o rabo

Gato cat = new Gato("Mimi", 2, "Branco");
cat.emitirSom();      // Mimi está miando: Miau!
cat.arranhar();       // Mimi está arranhando
```

### Tipos de Herança em Java

- **Herança Simples**: Uma classe herda de apenas uma classe pai (Java suporta)
- **Herança Múltipla**: Uma classe herda de múltiplas classes pai (Java NÃO suporta diretamente, mas pode ser feito via interfaces)

---

## 📦 Encapsulamento

### O que é Encapsulamento?

**Encapsulamento** é o princípio de esconder os detalhes internos de uma classe e expor apenas o necessário através de métodos públicos. É como uma cápsula que protege o conteúdo interno.

### Modificadores de Acesso em Java

| Modificador | Classe | Pacote | Subclasse | Todos |
|-------------|--------|--------|-----------|-------|
| `private`   | ✅     | ❌     | ❌        | ❌    |
| `default`   | ✅     | ✅     | ❌        | ❌    |
| `protected` | ✅     | ✅     | ✅        | ❌    |
| `public`    | ✅     | ✅     | ✅        | ✅    |

### Exemplo Prático

```java
public class Pessoa {
    // Atributos privados (encapsulados)
    private String nome;
    private int idade;
    private String cpf;
    
    // Construtor
    public Pessoa(String nome, int idade, String cpf) {
        this.nome = nome;
        setIdade(idade);  // Usa o setter para validar
        this.cpf = cpf;
    }
    
    // Métodos públicos (interface pública)
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        if (idade > 0 && idade < 150) {
            this.idade = idade;
        } else {
            System.out.println("Idade inválida!");
        }
    }
    
    // CPF apenas leitura (sem setter)
    public String getCpf() {
        // Retorna apenas os últimos 4 dígitos
        return "***.***.***-" + cpf.substring(cpf.length() - 2);
    }
}

// Uso
Pessoa pessoa = new Pessoa("João Silva", 25, "12345678901");
System.out.println(pessoa.getNome());  // João Silva
pessoa.setIdade(30);  // Idade alterada com validação
pessoa.setIdade(-5);  // Idade inválida! (não altera)
```

### Benefícios do Encapsulamento

- 🔐 **Segurança**: Protege dados sensíveis
- ✅ **Validação**: Controla como os dados são modificados
- 🔧 **Flexibilidade**: Permite mudar implementação interna sem afetar o código externo
- 🧹 **Manutenibilidade**: Facilita a manutenção do código

---

## 🎓 Exercícios do Nível 1

Agora que você aprendeu os fundamentos, pratique com os exercícios disponíveis na pasta de exercícios do Nível 1!

### O que você aprenderá:

1. ✅ Criar classes e objetos
2. ✅ Implementar encapsulamento com getters e setters
3. ✅ Usar herança para reutilizar código
4. ✅ Sobrescrever métodos (@Override)
5. ✅ Aplicar modificadores de acesso

---

## 📚 Próximo Passo

Após dominar o Nível 1, você estará pronto para o **Nível 2 - POO Avançada**, onde aprenderá:

- Sobrecarga de métodos
- Polimorfismo
- Classes abstratas
- Interfaces

**Bons estudos! 🚀**
