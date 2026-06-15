# 🏛️ Roman Numeral Converter

A console-based Java application that converts **Roman numerals to integers** — with full validation of numeral rules.

---

## ✨ Features

- Converts any valid Roman numeral to its integer equivalent
- Validates input against standard Roman numeral rules:
  - Only valid characters accepted (`I`, `V`, `X`, `L`, `C`, `D`, `M`)
  - `V`, `L`, `D` cannot repeat
  - No symbol repeats more than 3 times in a row
  - Only valid subtractive pairs allowed (`IV`, `IX`, `XL`, `XC`, `CD`, `CM`)
- Interactive loop — convert as many numerals as you want
- Graceful exit when the user types `n`

---

## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- Any Java IDE (IntelliJ IDEA recommended) or terminal with `javac`

### Running the Project

```bash
# Compile
javac Roman/RomanConverter.java

# Run
java Roman.RomanConverter
```

---

## 🎮 How to Use

```
Write Roman:
> XIV
14
Next?(y/n)
> y

Write Roman:
> MCMXCIX
1999
Next?(y/n)
> n

GoodBye
```

---

## 🧠 How It Works

The converter uses a **left-to-right scan** with subtractive notation logic:

| Condition | Action |
|---|---|
| Current value < Next value | **Subtract** current from result |
| Current value ≥ Next value | **Add** current to result |

### Example — `XIV` → `14`

| Position | Char | Value | Action | Running Total |
|---|---|---|---|---|
| 0 | X | 10 | 10 < 1? No → Add | 10 |
| 1 | I | 1 | 1 < 5? Yes → Subtract | 9 |
| 2 | V | 5 | Last char → Add | 14 |

---

## 📁 Project Structure

```
Roman/
└── RomanConverter.java
      ├── main()          → Input loop & output
      ├── romanToValue()  → Char to integer mapping
      └── correct()       → Full validation logic
```

---

## ✅ Valid Input Examples

| Roman | Integer |
|---|---|
| `III` | 3 |
| `IV` | 4 |
| `IX` | 9 |
| `XL` | 40 |
| `XCIX` | 99 |
| `CDXLIV` | 444 |
| `MCMXCIX` | 1999 |
| `MMXXIV` | 2024 |

---

## ❌ Invalid Input Examples

| Input | Reason |
|---|---|
| `VV` | `V` cannot repeat |
| `IIII` | Max 3 consecutive repetitions |
| `IC` | `I` can only precede `V` or `X` |
| `XM` | `X` can only precede `L` or `C` |
| `abc` | Invalid characters |

---

## 👨‍💻 Author

Thiago Fogaca