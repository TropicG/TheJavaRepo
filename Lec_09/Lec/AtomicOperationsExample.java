// Всички имплементации имат методи get() и set() за достъп до съхраняваната променлива
AtomicInteger atomicInt = new AtomicInteger();
atomicInt.set(2024);
System.out.println(atomicInt.get()); // 2024

// thread-safe вариант на ++i (i = i + 1)
System.out.println(atomicInt.incrementAndGet()); // 2025

//thread-safe вариант на i += x (i = i + x)
System.out.println(atomicInt.addAndGet(5)); // 2030

AtomicReference<String> atomicRef = new AtomicReference<>();
// atomicRef не е null, но стойноста, която wrap-ва е null

atomicRef.compareAndSet(null, "Java is good!!!");
// Проверява дали текущата стойност е expected (в случая null), ако да тогава я замени с update("Java is good!!!"), ако не не праив нищо
// Цялата тази операция се случва атомарна, което елиминира race condition-a 

