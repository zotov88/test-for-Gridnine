# Тестовое задание

## Содержание

1. [Задание](#задание)
2. [Диаграмма созданного модуля](#диаграмма-созданного-модуля)
3. [Покрытие тестами](#покрытие-тестами)
4. [Инструкция по запуску проекта](#инструкция-по-запуску-проекта)

### Задание

Постановка задачи.
Имеется некая система, которая обрабатывает авиа перелёты. Перелёт — это перевозка пассажира из одной точки в другую с возможными промежуточными посадками. Т. о. перелёт можно представить как набор из одного или нескольких элементарных перемещений, называемых сегментами. Сегмент — это атомарная перевозка, которую для простоты будем характеризовать всего двумя атрибутами: дата/время вылета и дата/время прилёта.
Вам нужно написать небольшой модуль, который будет заниматься фильтрацией набора перелётов согласно различным правилам. Правил фильтрации может быть очень много. Также наборы перелётов могут быть очень большими. Правила могут выбираться и задаваться динамически в зависимости от контекста выполнения операции фильтрации.
Продумайте структуру модуля, создайте необходимые классы и интерфейсы. Если знакомы с Junit, то покройте свой код тестами. Пользовательский интерфейс не рассматривайте. Достаточно вывода информации в консоль. Никаких сторонних библиотек использовать не нужно.
Приложенный файл TestClasses.java содержит упрощённые модельные классы и фабрику для получения тестовых образцов. Весь код необходимо поместить в пакет com.gridnine.testing
Для проверочного запуска создайте публичный класс Main c методом main() Этот метод должен выдать в консоль результаты обработки тестового набора перелётов. Получить тестовый набор нужно методом FlightBuilder.createFlights()
Поместите в main() такой проверочный код. Исключите из тестового набора перелёты по следующим правилам (по каждому правилу нужен отдельный вывод списка перелётов):
1. вылет до текущего момента времени
2. имеются сегменты с датой прилёта раньше даты вылета
3. общее время, проведённое на земле превышает два часа (время на земле — это интервал между прилётом одного сегмента и вылетом следующего за ним)

### Диаграмма созданного модуля

![diagram.png](src%2Fmain%2Fresources%2Fimage%2Fdiagram.png)

### Покрытие тестами

![tests.png](src%2Fmain%2Fresources%2Fimage%2Ftests.png)

### Инструкция по запуску проекта

* Скопируйте проект на локальную машину
* В корне проекта запустите командную строку и выполните команду ``mvn clean install`` после чего появится
  папка **target**

![1.png](src%2Fmain%2Fresources%2Fimage%2F1.png)

![2.png](src%2Fmain%2Fresources%2Fimage%2F2.png)

* Перейдите в папку **target** и выполните команду  ``java -jar testfornota-0.0.1-SNAPSHOT.jar``

![3.png](src%2Fmain%2Fresources%2Fimage%2F3.png)


