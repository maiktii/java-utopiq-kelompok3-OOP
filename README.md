# Encapsulation di Java

Dokumen ini menjelaskan konsep **Encapsulation** di Java menggunakan contoh kode. **Encapsulation** adalah teknik untuk menyembunyikan detail implementasi dengan membuat atribut kelas bersifat `private` dan memberikan akses melalui metode `getter` dan `setter`.

---

## **Kode Contoh**

```java
class Employee {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be positive!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setName("Michael");
        employee1.setAge(21);

        employee2.setName("Rian");
        employee2.setAge(22);

        System.out.println("Name : " + employee1.getName());
        System.out.println("Age: " + employee1.getAge());

        System.out.println("Name : " + employee2.getName());
        System.out.println("Age: " + employee2.getAge());
    }
}
```

---

## **Penjelasan Baris per Baris**

### **1. Deklarasi Kelas Employee**

```java
class Employee {
```

* Membuat kelas `Employee` sebagai **model** data karyawan.

### **2. Atribut Private**

```java
private String name;
private int age;
```

* Atribut `name` dan `age` diberi modifier **private**, sehingga **tidak bisa diakses langsung** dari luar kelas.
* Hal ini adalah inti dari **encapsulation**.

### **3. Getter dan Setter**

#### **Getter untuk name**

```java
public String getName() {
    return name;
}
```

* Mengambil nilai `name` dari objek.

#### **Setter untuk name**

```java
public void setName(String name) {
    this.name = name;
}
```

* Mengatur nilai `name`.
* Kata kunci `this` digunakan untuk membedakan **variabel instance** dan **parameter metode**.

#### **Getter untuk age**

```java
public int getAge() {
    return age;
}
```

* Mengambil nilai `age`.

#### **Setter untuk age dengan Validasi**

```java
public void setAge(int age) {
    if (age > 0) {
        this.age = age;
    } else {
        System.out.println("Age must be positive!");
    }
}
```

* Mengatur nilai `age` **hanya jika** nilainya positif.
* Jika nilai tidak valid, program akan mencetak pesan kesalahan.

### **4. Kelas Main**

```java
public class Main {
    public static void main(String[] args) {
```

* Kelas utama tempat program dijalankan.

```java
Employee employee1 = new Employee();
Employee employee2 = new Employee();
```

* Membuat **dua objek** `Employee` berbeda: `employee1` dan `employee2`.

```java
employee1.setName("Michael");
employee1.setAge(21);

employee2.setName("Rian");
employee2.setAge(22);
```

* Mengatur nama dan umur masing-masing karyawan menggunakan metode **setter**.

```java
System.out.println("Name : " + employee1.getName());
System.out.println("Age: " + employee1.getAge());

System.out.println("Name : " + employee2.getName());
System.out.println("Age: " + employee2.getAge());
```

* Mengambil dan menampilkan nama dan umur karyawan menggunakan metode **getter**.

---

## **Konsep yang Ditunjukkan**

| Konsep            | Penjelasan                                                                  |
| ----------------- | --------------------------------------------------------------------------- |
| **Encapsulation** | Menyembunyikan detail implementasi dengan atribut `private`.                |
| **Getter**        | Metode untuk mengambil nilai dari atribut privat.                           |
| **Setter**        | Metode untuk mengatur nilai atribut privat dengan kontrol validasi.         |
| **Validasi Data** | Pada `setAge()`, nilai umur tidak bisa negatif atau nol.                    |
| **Reusability**   | Kelas dapat digunakan berkali-kali untuk membuat objek dengan data berbeda. |

---

## **Output Program**

```
Name : Michael
Age: 21
Name : Rian
Age: 22
```

Jika kita mencoba memberikan nilai umur negatif, misalnya:

```java
employee1.setAge(-5);
```

**Outputnya akan:**

```
Age must be positive!
```

---

## **Kesimpulan**

* **Encapsulation** melindungi data dengan membuat atribut menjadi `private`.
* Akses dan modifikasi dilakukan melalui **getter** dan **setter**.
* Validasi data bisa dilakukan dalam **setter** agar nilai atribut selalu konsisten.

---

📌 **Catatan:**
Encapsulation biasanya digunakan bersama dengan **abstraction**, **inheritance**, dan **polymorphism** untuk menerapkan prinsip **OOP** secara penuh di Java.


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
📌 Catatan:
Jika ingin mengimplementasikan banyak metode abstrak sekaligus, Anda juga bisa menggunakan interface di Java, tetapi perbedaan dan penggunaannya tergantung pada kebutuhan desain.
