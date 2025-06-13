# 💳 Payment Plugin System (Java – Interface-Based)

A simple yet powerful Java mini-project that demonstrates real-world **plugin architecture** using **interfaces, abstraction, and runtime polymorphism** — no Spring, just pure OOP.

---

## 🚀 What This Project Demonstrates

| Concept                              | Implementation                           |
| ------------------------------------ | ---------------------------------------- |
| ✅ Interface as Plugin Contract       | `PaymentGateway`                         |
| ✅ Abstract Class for Shared Logic    | `BasePaymentGateway`                     |
| ✅ Runtime Polymorphism               | Different gateways used interchangeably  |
| ✅ Reflection + Config-Driven Loading | Plugin class names from `plugins.config` |
| ✅ File-Based Logging                 | Payments logged to a local file          |
| ✅ Input Validation                   | Clean handling of invalid amounts        |
| ✅ Error Simulation                   | Mimics real-world API unreliability      |

---

## 🏗️ Project Structure

```java

src/
├─ core/
│  ├─ PaymentGateway.java         # Interface - plugin contract
│  ├─ BasePaymentGateway.java     # Abstract class with shared logic
│  ├─ PaymentProcessor.java       # Manager class for executing payments
│  └─ LoggerUtil.java             # Logs payments to file
│
├─ gateways/
│  ├─ PayPalGateway.java
│  ├─ StripeGateway.java
│  └─ RazorpayGateway.java
│
├─ directory/
│  └─ plugins.config              # External plugin class registry (used at runtime)
│
└─ Main.java                      # Entry point: loads plugins, accepts user input

```

---

## ⚙️ How It Works

1. On launch, the app reads `plugins.config` (e.g. `gateways.PayPalGateway`)

2. Shows user a list of payment gateway options

3. Accepts user input for gateway + payment amount

4. Dynamically loads the selected gateway using `Class.forName(...)`

5. Validates input, logs the payment, and simulates gateway response

---

## 📝 Sample Console Output

```java
💳 Welcome to the Payment Plugin System

Available Payment Gateways:
1. PayPal
2. Stripe
3. Razorpay

Select gateway [number]: 2
Enter payment amount: ₹500

🔄 Initiating payment via: Stripe
✅ Payment Successful via Stripe

```

> Note: System randomly simulates gateway errors to mimic real-world APIs.

---

## 🧪 Simulated Logging

Logs are written to a file named `payment_logs.txt`:

```java
[2025-06-13 12:24:01] Stripe - ₹500.00 - ✅ Payment Successful via Stripe
```

---

## 📦 Setup Instructions (IntelliJ)

1. Open project in IntelliJ

2. Ensure `plugins.config` is placed under `src/`

3. Run `Main.java`

4. Use terminal for input and view logs in `payment_logs.txt`

---

## 🎯 Why This Project Matters

Even though most enterprise projects today use Spring Boot, understanding how abstraction works *without frameworks* builds a **solid OOP foundation**.

This project helps you:

- Revisit interfaces, inheritance, and reflection

- Build mental models of plugin architectures

- Prepare for low-level design and source-level interviews

---

## 🏁 Ready to Extend?

You can further enhance this by:

- Adding new plugins without touching core logic

- Introducing plugin filtering (e.g. based on country/currency)

- Externalizing config paths or logging levels

- Adding a GUI (Swing/JavaFX) layer

- Migrating to Spring Boot (when ready)
