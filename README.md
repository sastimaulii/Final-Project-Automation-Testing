## **Java Automation Framework (Web & API)** 

Project ini adalah sebuah Test Automation Framework yang menggabungkan pengujian Web UI dan API dalam satu repositori. Dibangun menggunakan Java dengan pendekatan Behavior-Driven Development (BDD) menggunakan Cucumber dan TestNG.

### **Apa saja fitur yang diimplementasi?**

1. Dual-Test Capability: Menjalankan pengujian Web (Selenium) dan API (RestAssured) secara terpisah atau bersamaan.

2. BDD Implementation: Skenario ditulis dalam format Gherkin yang mudah dipahami manusia.

3. Page Object Model (POM): Pemisahan antara logika navigasi halaman dan logika pengujian untuk pemeliharaan kode yang lebih mudah.

4. CI/CD Integrated: Otomatisasi eksekusi menggunakan GitHub Actions.

5. Comprehensive Reporting: Menghasilkan laporan dalam format HTML dan JSON.


### **Apa saja stack-nya?**

1. Language: Java 17

2. Build Tool: Gradle

3. Test Framework: TestNG

4. BDD Library: Cucumber

5. Web Automation: Selenium WebDriver

6. API Automation: RestAssured

7. Driver Management: WebDriverManager

### **Bagaimana setiap directory berfungsi?**

```text
├── .github/workflows/      # Konfigurasi CI/CD (GitHub Actions)
├── src/main/java/          # Core Logic & Reusable Components
│   └── sastimauli/demo/
│       ├── pages/          # Page Object Model (Locator & Action Web)
│       └── utils/          # Helper (BaseTest & API Configuration)
├── src/test/java/          # Test Execution Logic
│   └── sastimauli/demo/
│       ├── stepdefs/       # Implementasi Gherkin (Glue Code)
│       └── runners/        # Class untuk menjalankan TestNG & Cucumber
└── src/test/resources/     # Test Data & Documentation
    └── features/           # File .feature (Skenario Gherkin)
```

### **Bagaimana cara execute code?**

**1. Menjalankan Semua API Test :**
```bash
./gradlew apiTest
```
**2. Menjalankan Semua Web UI Test :**
```bash
./gradlew webTest
```
**3. Menjalankan Seluruh Test :**
```bash
./gradlew test
```
### **Dimana kamu dapat melihat hasil report?**

Setelah pengujian selesai, laporan otomatis akan tergenerate di direktori berikut:

1. HTML Report: ```target/cucumber-reports/index.html```

2. JSON Report: ```target/cucumber-reports/cucumber.json```

### **CI/CD dengan GitHub Actions**

Framework ini dikonfigurasi untuk berjalan otomatis pada setiap Push atau Pull Request ke branch ```main```. Kamu juga bisa menjalankannya secara manual melalui tab Actions di GitHub (Workflow Dispatch).

### **Skenario Pengujian :**

1. Web UI Target: ```SauceDemo``` (Login functionality).

2. API Target: ```DummyAPI.io``` (User Management: GET, POST, PUT, DELETE).
   ``