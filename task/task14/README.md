# 🔄 Nível 4 - Type Casting

## Introdução

Bem-vindo ao **Nível 4**! Neste nível, você aprenderá sobre **conversão de tipos (type casting)** em Java, um conceito fundamental para trabalhar com polimorfismo e hierarquias de classes. Entender casting é essencial para manipular objetos de forma segura e eficiente.

---

## 🎯 Conversão de Tipos

### O que é Type Casting?

**Type Casting** é o processo de converter um tipo de dado em outro. Em Java, temos dois tipos principais de casting:

1. **Casting de tipos primitivos** (int, double, float, etc.)
2. **Casting de referências** (objetos e classes)

### Casting de Tipos Primitivos

#### Widening Casting (Automático)

Conversão de um tipo menor para um tipo maior. É **automática** e **segura**.

```java
public class WideningCasting {
    public static void main(String[] args) {
        // byte -> short -> int -> long -> float -> double
        
        int numeroInt = 100;
        double numeroDouble = numeroInt;  // Automático
        
        System.out.println("Int: " + numeroInt);        // 100
        System.out.println("Double: " + numeroDouble);  // 100.0
        
        // Outros exemplos
        byte b = 10;
        short s = b;    // byte -> short
        int i = s;      // short -> int
        long l = i;     // int -> long
        float f = l;    // long -> float
        double d = f;   // float -> double
        
        System.out.println("Byte: " + b);      // 10
        System.out.println("Double: " + d);    // 10.0
    }
}
```

#### Narrowing Casting (Manual)

Conversão de um tipo maior para um tipo menor. É **manual** e pode causar **perda de dados**.

```java
public class NarrowingCasting {
    public static void main(String[] args) {
        // Requer casting explícito
        double numeroDouble = 9.78;
        int numeroInt = (int) numeroDouble;  // Manual
        
        System.out.println("Double: " + numeroDouble);  // 9.78
        System.out.println("Int: " + numeroInt);        // 9 (perdeu .78)
        
        // Exemplo com perda de dados
        int valorGrande = 130;
        byte valorPequeno = (byte) valorGrande;
        System.out.println("Valor: " + valorPequeno);  // -126 (overflow!)
        
        // Casting seguro
        long l = 100L;
        int i = (int) l;
        short s = (short) i;
        byte b = (byte) s;
        
        System.out.println("Long: " + l);    // 100
        System.out.println("Byte: " + b);    // 100
    }
}
```

---

## 📦 Casting de Referências (Objetos)

O casting de objetos trabalha com a hierarquia de classes e interfaces.

### Upcasting (Automático)

**Upcasting** é converter uma referência de subclasse para superclasse. É **automático** e **sempre seguro**.

```java
// Hierarquia de classes
class Animal {
    public void emitirSom() {
        System.out.println("Animal fazendo som");
    }
    
    public void dormir() {
        System.out.println("Animal dormindo");
    }
}

class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au au!");
    }
    
    public void abanarRabo() {
        System.out.println("Abanando o rabo");
    }
}

class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }
    
    public void arranhar() {
        System.out.println("Arranhando");
    }
}

public class UpcastingExemplo {
    public static void main(String[] args) {
        // Upcasting - automático
        Cachorro cachorro = new Cachorro();
        Animal animal = cachorro;  // Upcasting implícito
        
        // Também pode ser explícito
        Animal animal2 = (Animal) cachorro;
        
        // Pode chamar métodos da classe Animal
        animal.emitirSom();  // Au au! (usa a versão sobrescrita)
        animal.dormir();     // Animal dormindo
        
        // NÃO pode chamar métodos específicos de Cachorro
        // animal.abanarRabo();  // ERRO de compilação!
        
        // Polimorfismo com upcasting
        Animal[] animais = {
            new Cachorro(),  // Upcasting automático
            new Gato(),      // Upcasting automático
            new Animal()
        };
        
        for (Animal a : animais) {
            a.emitirSom();  // Chama a versão correta em tempo de execução
        }
    }
}
```

### Downcasting (Manual)

**Downcasting** é converter uma referência de superclasse para subclasse. É **manual** e pode causar **ClassCastException**.

```java
public class DowncastingExemplo {
    public static void main(String[] args) {
        // Criando objeto e fazendo upcasting
        Animal animal = new Cachorro();  // Upcasting
        
        // Downcasting - SEGURO (objeto é realmente um Cachorro)
        Cachorro cachorro = (Cachorro) animal;
        cachorro.abanarRabo();  // Agora funciona!
        cachorro.emitirSom();
        
        // Downcasting - PERIGOSO (pode causar erro)
        Animal animal2 = new Animal();
        
        try {
            Cachorro cachorro2 = (Cachorro) animal2;  // ClassCastException!
            cachorro2.abanarRabo();
        } catch (ClassCastException e) {
            System.out.println("Erro: Não é possível converter Animal para Cachorro");
        }
        
        // Downcasting correto com verificação
        Animal animal3 = new Gato();
        
        if (animal3 instanceof Cachorro) {
            Cachorro c = (Cachorro) animal3;
            c.abanarRabo();
        } else if (animal3 instanceof Gato) {
            Gato g = (Gato) animal3;
            g.arranhar();  // Funciona!
        }
    }
}
```

### Diagrama de Upcasting e Downcasting

```
        Animal (Superclasse)
           ↑ ↓
     Upcasting | Downcasting
     (automático) | (manual)
           ↓ ↑
        Cachorro (Subclasse)
```

---

## 🔍 Operador instanceof

O operador `instanceof` verifica se um objeto é uma instância de uma classe específica ou implementa uma interface.

### Sintaxe

```java
objeto instanceof Tipo
```

Retorna `true` se o objeto for do tipo especificado, `false` caso contrário.

### Exemplo Básico

```java
public class InstanceofExemplo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Cachorro cachorro = new Cachorro();
        Animal cachorroComoAnimal = new Cachorro();
        
        // Verificações simples
        System.out.println(animal instanceof Animal);           // true
        System.out.println(cachorro instanceof Cachorro);       // true
        System.out.println(cachorro instanceof Animal);         // true (herda de Animal)
        System.out.println(cachorroComoAnimal instanceof Cachorro);  // true
        System.out.println(animal instanceof Cachorro);         // false
        
        // Verificação com null
        Animal nulo = null;
        System.out.println(nulo instanceof Animal);  // false (null não é instância)
    }
}
```

### Uso Prático com Interfaces

```java
interface Nadador {
    void nadar();
}

interface Voador {
    void voar();
}

class Pato implements Nadador, Voador {
    @Override
    public void nadar() {
        System.out.println("Pato nadando");
    }
    
    @Override
    public void voar() {
        System.out.println("Pato voando");
    }
}

class Peixe implements Nadador {
    @Override
    public void nadar() {
        System.out.println("Peixe nadando");
    }
}

public class InstanceofComInterfaces {
    public static void main(String[] args) {
        Object[] objetos = {
            new Pato(),
            new Peixe(),
            new String("Texto"),
            new Integer(42)
        };
        
        for (Object obj : objetos) {
            System.out.println("\nAnalisando: " + obj.getClass().getSimpleName());
            
            if (obj instanceof Nadador) {
                System.out.println("  - Pode nadar");
                ((Nadador) obj).nadar();  // Downcasting seguro
            }
            
            if (obj instanceof Voador) {
                System.out.println("  - Pode voar");
                ((Voador) obj).voar();  // Downcasting seguro
            }
            
            if (obj instanceof String) {
                System.out.println("  - É uma String: " + obj);
            }
            
            if (obj instanceof Number) {
                System.out.println("  - É um número: " + obj);
            }
        }
    }
}
```

### Pattern Matching com instanceof (Java 16+)

A partir do Java 16, você pode declarar variáveis diretamente no `instanceof`:

```java
public class PatternMatching {
    public static void processarAnimal(Animal animal) {
        // Java antigo
        if (animal instanceof Cachorro) {
            Cachorro cachorro = (Cachorro) animal;
            cachorro.abanarRabo();
        }
        
        // Java 16+ - Pattern Matching
        if (animal instanceof Cachorro cachorro) {
            cachorro.abanarRabo();  // Variável já criada!
        }
        
        if (animal instanceof Gato gato) {
            gato.arranhar();
        }
    }
}
```

---

## 🎯 Tarefas Práticas Envolvendo Interfaces

### Exercício 1: Sistema de Pagamentos

```java
// Interface principal
interface FormaPagamento {
    boolean processar(double valor);
    String obterNome();
}

// Interface para pagamentos que podem ser parcelados
interface Parcelavel {
    boolean processarParcelado(double valor, int parcelas);
    double calcularJuros(int parcelas);
}

// Interface para pagamentos com cashback
interface Cashback {
    double calcularCashback(double valor);
    void aplicarCashback(double valor);
}

// Implementações
class CartaoCredito implements FormaPagamento, Parcelavel, Cashback {
    private String numero;
    private String titular;
    private double limite;
    private double cashbackAcumulado;
    
    public CartaoCredito(String numero, String titular, double limite) {
        this.numero = numero;
        this.titular = titular;
        this.limite = limite;
        this.cashbackAcumulado = 0;
    }
    
    @Override
    public boolean processar(double valor) {
        if (valor <= limite) {
            limite -= valor;
            aplicarCashback(valor);
            System.out.println("Pagamento de R$ " + valor + " processado no cartão");
            return true;
        }
        System.out.println("Limite insuficiente!");
        return false;
    }
    
    @Override
    public String obterNome() {
        return "Cartão de Crédito";
    }
    
    @Override
    public boolean processarParcelado(double valor, int parcelas) {
        double valorComJuros = valor + calcularJuros(parcelas);
        if (valorComJuros <= limite) {
            limite -= valorComJuros;
            System.out.println("Pagamento parcelado: " + parcelas + "x de R$ " + 
                             (valorComJuros / parcelas));
            return true;
        }
        return false;
    }
    
    @Override
    public double calcularJuros(int parcelas) {
        return parcelas > 1 ? parcelas * 2.5 : 0;
    }
    
    @Override
    public double calcularCashback(double valor) {
        return valor * 0.02;  // 2% de cashback
    }
    
    @Override
    public void aplicarCashback(double valor) {
        double cashback = calcularCashback(valor);
        cashbackAcumulado += cashback;
        System.out.println("Cashback de R$ " + cashback + " aplicado");
    }
    
    public double getCashbackAcumulado() {
        return cashbackAcumulado;
    }
}

class Pix implements FormaPagamento {
    private String chave;
    
    public Pix(String chave) {
        this.chave = chave;
    }
    
    @Override
    public boolean processar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " via PIX processado");
        System.out.println("Chave: " + chave);
        return true;
    }
    
    @Override
    public String obterNome() {
        return "PIX";
    }
}

class Boleto implements FormaPagamento {
    private String codigo;
    private String dataVencimento;
    
    public Boleto(String dataVencimento) {
        this.dataVencimento = dataVencimento;
        this.codigo = "34191.79001 01043.510047 91020.150008 1 " + System.currentTimeMillis();
    }
    
    @Override
    public boolean processar(double valor) {
        System.out.println("Boleto gerado!");
        System.out.println("Valor: R$ " + valor);
        System.out.println("Vencimento: " + dataVencimento);
        System.out.println("Código: " + codigo);
        return true;
    }
    
    @Override
    public String obterNome() {
        return "Boleto Bancário";
    }
}

// Sistema de processamento
public class SistemaPagamento {
    public static void main(String[] args) {
        FormaPagamento[] formasPagamento = {
            new CartaoCredito("1234-5678-9012-3456", "João Silva", 5000),
            new Pix("joao@email.com"),
            new Boleto("31/12/2024")
        };
        
        double valorCompra = 1500.00;
        
        for (FormaPagamento forma : formasPagamento) {
            System.out.println("\n=== " + forma.obterNome() + " ===");
            
            // Processa pagamento básico
            forma.processar(valorCompra);
            
            // Verifica se pode parcelar
            if (forma instanceof Parcelavel) {
                Parcelavel parcelavel = (Parcelavel) forma;
                System.out.println("\nOpção de parcelamento disponível:");
                parcelavel.processarParcelado(valorCompra, 3);
            }
            
            // Verifica cashback
            if (forma instanceof Cashback) {
                Cashback cashback = (Cashback) forma;
                double valorCashback = cashback.calcularCashback(valorCompra);
                System.out.println("Cashback disponível: R$ " + valorCashback);
            }
            
            System.out.println("-".repeat(50));
        }
    }
}
```

### Exercício 2: Sistema de Notificações

```java
// Interface base
interface Notificacao {
    void enviar(String destinatario, String mensagem);
    boolean foiEnviado();
}

// Interface para notificações agendáveis
interface Agendavel {
    void agendar(String destinatario, String mensagem, String dataHora);
    void cancelarAgendamento();
}

// Interface para notificações prioritárias
interface Prioritaria {
    void enviarUrgente(String destinatario, String mensagem);
    int obterNivelPrioridade();
}

// Implementações
class Email implements Notificacao, Agendavel {
    private boolean enviado;
    private String assunto;
    
    public Email(String assunto) {
        this.assunto = assunto;
        this.enviado = false;
    }
    
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("📧 Enviando email para: " + destinatario);
        System.out.println("Assunto: " + assunto);
        System.out.println("Mensagem: " + mensagem);
        enviado = true;
    }
    
    @Override
    public boolean foiEnviado() {
        return enviado;
    }
    
    @Override
    public void agendar(String destinatario, String mensagem, String dataHora) {
        System.out.println("📅 Email agendado para: " + dataHora);
        System.out.println("Destinatário: " + destinatario);
    }
    
    @Override
    public void cancelarAgendamento() {
        System.out.println("❌ Agendamento de email cancelado");
    }
}

class SMS implements Notificacao, Prioritaria {
    private boolean enviado;
    private int prioridade;
    
    public SMS(int prioridade) {
        this.prioridade = prioridade;
        this.enviado = false;
    }
    
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("📱 Enviando SMS para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        enviado = true;
    }
    
    @Override
    public boolean foiEnviado() {
        return enviado;
    }
    
    @Override
    public void enviarUrgente(String destinatario, String mensagem) {
        System.out.println("🚨 SMS URGENTE para: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Prioridade: " + prioridade);
        enviado = true;
    }
    
    @Override
    public int obterNivelPrioridade() {
        return prioridade;
    }
}

class Push implements Notificacao, Prioritaria, Agendavel {
    private boolean enviado;
    private String aplicativo;
    
    public Push(String aplicativo) {
        this.aplicativo = aplicativo;
        this.enviado = false;
    }
    
    @Override
    public void enviar(String destinatario, String mensagem) {
        System.out.println("🔔 Notificação Push para: " + destinatario);
        System.out.println("App: " + aplicativo);
        System.out.println("Mensagem: " + mensagem);
        enviado = true;
    }
    
    @Override
    public boolean foiEnviado() {
        return enviado;
    }
    
    @Override
    public void enviarUrgente(String destinatario, String mensagem) {
        System.out.println("🚨 PUSH URGENTE no " + aplicativo);
        System.out.println("Usuário: " + destinatario);
        System.out.println("Mensagem: " + mensagem);
        enviado = true;
    }
    
    @Override
    public int obterNivelPrioridade() {
        return 1;  // Máxima prioridade
    }
    
    @Override
    public void agendar(String destinatario, String mensagem, String dataHora) {
        System.out.println("📅 Push agendado para: " + dataHora);
        System.out.println("App: " + aplicativo);
    }
    
    @Override
    public void cancelarAgendamento() {
        System.out.println("❌ Agendamento de push cancelado");
    }
}

// Gerenciador de notificações
public class GerenciadorNotificacoes {
    public static void enviarNotificacoes(Notificacao[] notificacoes, 
                                         String destinatario, 
                                         String mensagem) {
        for (Notificacao notif : notificacoes) {
            System.out.println("\n" + "=".repeat(50));
            
            // Verifica se é prioritária
            if (notif instanceof Prioritaria) {
                Prioritaria prioritaria = (Prioritaria) notif;
                System.out.println("⚠️  Notificação Prioritária (Nível " + 
                                 prioritaria.obterNivelPrioridade() + ")");
                prioritaria.enviarUrgente(destinatario, mensagem);
            } else {
                notif.enviar(destinatario, mensagem);
            }
            
            // Verifica se pode agendar
            if (notif instanceof Agendavel) {
                System.out.println("✅ Suporta agendamento");
            }
            
            System.out.println("Status: " + (notif.foiEnviado() ? "Enviado" : "Pendente"));
        }
    }
    
    public static void main(String[] args) {
        Notificacao[] notificacoes = {
            new Email("Bem-vindo!"),
            new SMS(2),
            new Push("MeuApp")
        };
        
        enviarNotificacoes(notificacoes, "joao@email.com", 
                          "Sua conta foi criada com sucesso!");
    }
}
```

---

## ⚠️ Erros Comuns e Como Evitar

### 1. ClassCastException

```java
// ❌ ERRADO - Causa ClassCastException
Animal animal = new Animal();
Cachorro cachorro = (Cachorro) animal;  // ERRO em tempo de execução!

// ✅ CORRETO - Sempre verificar antes
Animal animal = new Animal();
if (animal instanceof Cachorro) {
    Cachorro cachorro = (Cachorro) animal;
    cachorro.abanarRabo();
} else {
    System.out.println("Não é um cachorro");
}
```

### 2. Perda de Funcionalidade com Upcasting

```java
// ❌ PROBLEMA - Perde acesso a métodos específicos
Cachorro cachorro = new Cachorro();
Animal animal = cachorro;  // Upcasting
// animal.abanarRabo();  // ERRO! Método não existe em Animal

// ✅ SOLUÇÃO - Fazer downcasting quando necessário
if (animal instanceof Cachorro) {
    ((Cachorro) animal).abanarRabo();  // Funciona!
}
```

### 3. Verificação de null

``
