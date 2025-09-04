# Abstraction di Java

Dokumen ini menjelaskan konsep **Abstraction** di Java menggunakan contoh kode. Abstraksi adalah proses menyembunyikan detail implementasi dan hanya menampilkan fungsionalitas penting kepada pengguna.

---

## **Kode Contoh**

```java
abstract class Animal {
    public abstract void sound();

    public void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Woof Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.sleep();

        Animal cat = new Cat();
        cat.sound();
        cat.sleep();
    }
}
```

---

## **Penjelasan Baris per Baris**

### **1. Kelas Abstrak**

```java
abstract class Animal {
```

* Membuat kelas abstrak `Animal`. Kelas abstrak tidak bisa di-instantiate langsung (`new Animal()` tidak diperbolehkan).
* Berfungsi sebagai **blueprint** untuk kelas turunannya.

### **2. Metode Abstrak dan Konkret**

```java
public abstract void sound();
```

* Metode **abstrak**: tidak memiliki isi (body) dan **harus diimplementasikan** oleh kelas turunan.

```java
public void sleep() {
    System.out.println("Sleeping...");
}
```

* Metode **konkret**: memiliki implementasi langsung. Kelas turunan akan **mewarisi** metode ini apa adanya (boleh di-override, tapi tidak wajib).

### **3. Kelas Turunan**

```java
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Woof Woof!");
    }
}
```

* `Dog` **mewarisi** `Animal` dan **mengimplementasikan** metode `sound()`.
* `@Override` menunjukkan metode ini menggantikan metode abstrak dari superclass.

```java
class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow Meow!");
    }
}
```

* `Cat` juga **mewarisi** `Animal` dan memberikan implementasi `sound()` sendiri.

### **4. Kelas Main**

```java
public class Main {
    public static void main(String[] args) {
```

* Kelas utama (`Main`) menjadi **entry point** program.

```java
Animal dog = new Dog();
```

* Menggunakan **polimorfisme**: variabel bertipe `Animal`, tapi objek sebenarnya adalah `Dog`.

```java
dog.sound();
```

* Memanggil metode `sound()` milik objek `Dog`, hasilnya **"Woof Woof!"**.

```java
dog.sleep();
```

* Memanggil metode `sleep()` dari `Animal`, hasilnya **"Sleeping..."**.

```java
Animal cat = new Cat();
cat.sound(); // "Meow Meow!"
cat.sleep(); // "Sleeping..."
```

* Sama seperti `dog`, tapi kali ini objeknya `Cat`.

---

## **Konsep yang Ditunjukkan**

| Konsep               | Penjelasan                                                                   |
| -------------------- | ---------------------------------------------------------------------------- |
| **Abstraksi**        | Menyembunyikan detail implementasi dan hanya menampilkan fungsionalitas inti |
| **Metode Abstrak**   | `sound()` memaksa kelas turunan memberikan implementasi sendiri              |
| **Pewarisan**        | `Dog` dan `Cat` mewarisi `sleep()` dari `Animal`                             |
| **Polimorfisme**     | Memanggil metode sesuai tipe **objek nyata**, bukan tipe referensi           |
| **Dynamic Dispatch** | Pemanggilan metode `sound()` dilakukan berdasarkan objek sebenarnya          |

---

## **Output Program**

```
Woof Woof!
Sleeping...
Meow Meow!
Sleeping...
```

---

## **Bonus: Contoh Polimorfisme dengan Array**

Kita bisa menyimpan banyak hewan dalam satu array dan memanggil metode `sound()` dan `sleep()` tanpa tahu tipe konkretnya:

```java
public class Main {
    public static void main(String[] args) {
        Animal[] animals = { new Dog(), new Cat() };

        for (Animal animal : animals) {
            animal.sound();
            animal.sleep();
        }
    }
}
```

**Output:**

```
Woof Woof!
Sleeping...
Meow Meow!
Sleeping...
```

---

## **Kesimpulan**

* **Abstraksi** memudahkan pembuatan *blueprint* untuk kelas turunannya.
* Memisahkan **apa yang dilakukan** dari **bagaimana dilakukan**.
* Membantu menciptakan kode yang **lebih rapi**, **terstruktur**, dan **mudah diperluas**.

---
